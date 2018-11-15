package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.Cliente;
import database.Proyecto;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultarClientes extends JFrame {
	public static String procedencia = "";
	private JPanel contentPane;

	private List<Cliente> listCli;
	private DefaultListModel<String> modelo;
	public static String cliSeleccionado = "";
	private JList listClientes;
	BD_Clientes bd_Cli = new BD_Clientes();
	private JScrollPane scrollLista;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarClientes frame = new ConsultarClientes();
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
	public ConsultarClientes() {

		inicializar();

		JLabel seleccionarClientes = new JLabel("Seleccionar Clientes");
		seleccionarClientes.setBounds(49, 30, 127, 16);
		contentPane.add(seleccionarClientes);


		listClientes = new JList();
		listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo = new DefaultListModel<String>();
		scrollLista = new JScrollPane();
		scrollLista.setBounds(34, 60, 143, 146);
	    scrollLista.setViewportView(listClientes);
		contentPane.add(scrollLista);
		cargarClientes();

		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listClientes.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					cliSeleccionado = listClientes.getSelectedValue().toString();
					ConsultarCliente consultarCliente = new ConsultarCliente();
					consultarCliente.setVisible(true);
					consultarCliente.procedencia = "ConsultarClientes";
					dispose();
				}
			}
		});
		btnConsultar.setBounds(46, 217, 117, 29);
		contentPane.add(btnConsultar);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(46, 257, 117, 29);
		contentPane.add(btnAtrs);
	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 219, 326);
		setLocationRelativeTo(null);
		// setTitle("Programa para gestión de requisitos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	public void cargarClientes() {
		try {
			listCli = bd_Cli.cargarClientes();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Cliente c : listCli) {
			modelo.addElement(c.getNombre());
			listClientes.setModel(modelo);
		}
	}
}
