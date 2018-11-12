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
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
		crearClienteBoton.setBounds(400, 373, 117, 29);
		contentPane.add(crearClienteBoton);

		/////////////////////////////////////
		crearClienteBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//IR A LA BBDD PARA METER AL CLIENTE
				String nombreCliente = nombreTexttField.getText();

				try {
					bd_Clientes.crearCliente(nombreCliente);
				} catch (PersistentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//listProyectos.
			}
		});
		
		//////////////////////////////

		
		
		JButton volverInicio = new JButton("Atrás");
		volverInicio.setBounds(35, 373, 117, 29);
		contentPane.add(volverInicio);
		
		volverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblIntroduceElNombre = new JLabel("Introduce el nombre del nuevo cliente");
		lblIntroduceElNombre.setBounds(35, 23, 245, 16);
		contentPane.add(lblIntroduceElNombre);
		
		nombreTexttField = new JTextField();
		nombreTexttField.setBounds(285, 18, 232, 26);
		contentPane.add(nombreTexttField);
		nombreTexttField.setColumns(10);
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 558, 454);
		setLocationRelativeTo(null);
		setTitle("Crear nuevo cliente");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void cargarProyectos() {
	
		try {
			listaProyecto = bd_Proyectos.cargarProyectos();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Proyecto p : listaProyecto)
		{
			modelo.addElement(p.getNombre());
			//listProyectos.setModel(modelo);
		}
	}
	

	/*private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});*/
	//}
	

}

