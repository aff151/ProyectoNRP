package clases;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.management.Notification;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.BD_Proyectos;
import database.Cliente;

import javax.swing.JTextArea;

public class CrearProyecto extends JFrame {

	private JPanel contentPane;
	//private JTextField textFImport;
	private JTextField textFNombre;
	private JTextArea tAreaDesc;
	/*private JList listClientes;
	private List<Cliente> listCli;
	private DefaultListModel modelo;*/
	
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
		inicializar();
		
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		
		tAreaDesc = new JTextArea();
		tAreaDesc.setBounds(269, 191, 252, 74);
		tAreaDesc.setLineWrap(true);
		tAreaDesc.setWrapStyleWord(true);
		contentPane.add(tAreaDesc);
		
		JLabel lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setBounds(160, 196, 99, 14);
		contentPane.add(lblDescripcion);
		btnAtras.setBounds(35, 431, 117, 29);
		contentPane.add(btnAtras);
		
		JButton btnCrearProyecto = new JButton("Crear Proyecto");
		btnCrearProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearProyecto();
			}
		});
		btnCrearProyecto.setBounds(388, 431, 133, 29);
		contentPane.add(btnCrearProyecto);
		
		textFNombre = new JTextField();
		textFNombre.setBounds(269, 100, 252, 26);
		contentPane.add(textFNombre);
		textFNombre.setColumns(10);
		
		JLabel lblIntrodProyecto = new JLabel("Introduce el nombre del nuevo proyecto");
		lblIntrodProyecto.setBounds(22, 105, 237, 16);
		contentPane.add(lblIntrodProyecto);
		
		/*listClientes = new JList();
		listClientes.setBackground(Color.WHITE);
		listClientes.setBounds(35, 173, 189, 226);
		listClientes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		contentPane.add(listClientes);
		
		modelo = new DefaultListModel();
		
		JLabel lblIntrodImport = new JLabel("Introduce el peso del cliente en el proyecto");
		lblIntrodImport.setBounds(275, 189, 297, 16);
		contentPane.add(lblIntrodImport);
		
		textFImport = new JTextField();
		textFImport.setBounds(343, 228, 80, 26);
		contentPane.add(textFImport);
		textFImport.setColumns(10);
		
		JLabel lblSelecCliente = new JLabel("Seleccionar Cliente");
		lblSelecCliente.setBounds(82, 146, 122, 16);
		contentPane.add(lblSelecCliente);*/
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(CrearProyecto.class.getResource("/imagenes/fondo.png")));
		lblFondo.setBounds(0, 0, 600, 500);
		contentPane.add(lblFondo);
		
		//cargarClientes();
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 549, 500);
		setLocationRelativeTo(null);
		//setTitle("Programa para gestión de requisitos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void crearProyecto() {
		try {
			if(textFNombre.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe introducir el nombre del proyecto", "MENSAJE",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if(bdProy.crearProyecto(textFNombre.getText(), tAreaDesc.getText())) {
					textFNombre.setText("");
					tAreaDesc.setText("");
					JOptionPane.showMessageDialog(null, "El proyecto se ha creado con éxito", "MENSAJE",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "El proyecto introducido ya existe"
							+ "", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public void cargarClientes() {
		try {
			listCli = bdCli.cargarClientes();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Cliente c : listCli) {
			modelo.addElement(c.getNombre());
			listClientes.setModel(modelo);
		}
	}*/
}
