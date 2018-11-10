package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.management.Notification;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.BD_Principal;
import database.BD_Proyectos;
import database.Cliente;

import javax.swing.JTextArea;

public class CrearProyecto extends JFrame {

	private JPanel contentPane;
	private JTextField textFImport;
	private JTextField textFNombre;
	private JTextArea tAreaDesc;
	private JList listClientes;
	private List<Cliente> listCli;
	
	BD_Proyectos bdProy = new BD_Proyectos();
	BD_Clientes bdCli = new BD_Clientes();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProyecto frame = new CrearProyecto();
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
	public CrearProyecto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		
		tAreaDesc = new JTextArea();
		tAreaDesc.setBounds(312, 58, 252, 74);
		contentPane.add(tAreaDesc);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(173, 63, 99, 14);
		contentPane.add(lblDescripcion);
		btnAtras.setBounds(473, 460, 117, 29);
		contentPane.add(btnAtras);
		
		JButton btnCrearProyecto = new JButton("Crear Proyecto");
		btnCrearProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearProyecto();
			}
		});
		btnCrearProyecto.setBounds(256, 370, 133, 29);
		contentPane.add(btnCrearProyecto);
		
		textFNombre = new JTextField();
		textFNombre.setBounds(312, 18, 252, 26);
		contentPane.add(textFNombre);
		textFNombre.setColumns(10);
		
		JLabel lblIntrodProyecto = new JLabel("Introduce el nombre del nuevo proyecto");
		lblIntrodProyecto.setBounds(35, 23, 237, 16);
		contentPane.add(lblIntrodProyecto);
		
		listClientes = new JList();
		listClientes.setBackground(Color.WHITE);
		listClientes.setBounds(35, 173, 189, 226);
		contentPane.add(listClientes);
		
		JLabel lblIntrodImport = new JLabel("Introduce la importancia del cliente para el proyecto");
		lblIntrodImport.setBounds(294, 160, 306, 16);
		contentPane.add(lblIntrodImport);
		
		textFImport = new JTextField();
		textFImport.setBounds(393, 186, 80, 26);
		contentPane.add(textFImport);
		textFImport.setColumns(10);
		
		JLabel lblSelecCliente = new JLabel("Seleccionar Cliente");
		lblSelecCliente.setBounds(82, 146, 122, 16);
		contentPane.add(lblSelecCliente);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(CrearProyecto.class.getResource("/imagenes/fondo.png")));
		lblFondo.setBounds(0, 0, 600, 500);
		contentPane.add(lblFondo);
		
		cargarClientes();
	}
	public void crearProyecto() {
		try {
			bdProy.crearProyecto(textFNombre.getText(), tAreaDesc.getText());
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cargarClientes() {
		try {
			listCli = bdCli.cargarClientes();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Cliente c : listCli) {
			//listClientes.add
		}
	}
}
