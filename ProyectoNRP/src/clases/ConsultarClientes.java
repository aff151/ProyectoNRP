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
	public ConsultarClientes() throws PersistentException {

		inicializar();

		JLabel seleccionarClientes = new JLabel("Seleccionar Clientes");
		seleccionarClientes.setBounds(33, 30, 127, 16);
		contentPane.add(seleccionarClientes);


		listClientes = new JList();
		listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo = new DefaultListModel<String>();
		scrollLista = new JScrollPane();
		scrollLista.setBounds(10, 60, 165, 146);
	    scrollLista.setViewportView(listClientes);
		contentPane.add(scrollLista);
		cargarClientes();

		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(30, 144, 255));
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
		btnConsultar.setBounds(86, 256, 89, 29);
		contentPane.add(btnConsultar);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(10, 256, 65, 29);
		contentPane.add(btnAtrs);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					eliminarCliente();
					
			}
		});
		btnEliminar.setBounds(33, 217, 117, 29);
		contentPane.add(btnEliminar);
	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 203, 331);
		setLocationRelativeTo(null);
		//setTitle("Consultar Clientes");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	public void cargarClientes()  {
			//listCli = bd_Cli.cargarClientes();
			try {
				listCli = bd_Cli.cargarClientesPropios(claseEstatica.getPropietario());
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for (Cliente c : listCli) {
			modelo.addElement(c.getNombre());
			listClientes.setModel(modelo);
		}
	}
	public void eliminarCliente()
	{
		if (listClientes.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente", "MENSAJE",
					JOptionPane.WARNING_MESSAGE);
		}
		try {
			bd_Cli.eliminarCliente(claseEstatica.getPropietario(), listClientes.getSelectedValue().toString());
			ConsultarClientes cli = new ConsultarClientes();
			cli.setVisible(true);
			dispose();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
