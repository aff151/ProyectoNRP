package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.BD_Proyectos;
import database.Cliente;
import database.Proyecto;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CrearCliente extends JFrame {

	private JPanel contentPane;
	private JTextField nombreTexttField;
	private BD_Clientes bd_Clientes = new BD_Clientes();
	private BD_Proyectos bd_Proyectos = new BD_Proyectos();
	private DefaultListModel modelo;
	private List<Proyecto> listaProyecto;
	public static String procedencia = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente frame = new CrearCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrearCliente() {

		inicializar();

		modelo = new DefaultListModel();

		JButton crearClienteBoton = new JButton("Crear Cliente");
		crearClienteBoton.setBounds(104, 51, 117, 29);
		contentPane.add(crearClienteBoton);

		/////////////////////////////////////
		crearClienteBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearCliente();
			}
		});
		//////////////////////////////

		JButton volverInicio = new JButton("Atrás");
		volverInicio.setBounds(14, 51, 66, 29);
		contentPane.add(volverInicio);

		volverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (procedencia == "AnadirClientes") {
					AnadirClientes anadirClientes = new AnadirClientes();
					anadirClientes.setVisible(true);

				} else {

					Menu m = new Menu();
					m.setVisible(true);
					
				}
				dispose();
			}
		});


		nombreTexttField = new JTextField();
		nombreTexttField.setBounds(14, 14, 200, 30);
		contentPane.add(nombreTexttField);
		nombreTexttField.setColumns(10);
		TextPrompt placeholder = new TextPrompt("Nombre del cliente", nombreTexttField);
		placeholder.changeAlpha(0.75f);
	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 233, 117);
		setLocationRelativeTo(null);
		setTitle("Crear Cliente");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void crearCliente() {
		try {
			if (nombreTexttField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe introducir el nombre del cliente", "MENSAJE",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (bd_Clientes.crearCliente(nombreTexttField.getText())) {
					nombreTexttField.setText("");
					JOptionPane.showMessageDialog(null, "El cliente se ha creado con éxito", "MENSAJE",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "El cliente introducido ya existe" + "", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * public void cargarProyectos() {
	 * 
	 * try { listaProyecto = bd_Proyectos.cargarProyectos(); } catch
	 * (PersistentException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * for(Proyecto p : listaProyecto) { modelo.addElement(p.getNombre());
	 * //listProyectos.setModel(modelo); } }
	 */

}
