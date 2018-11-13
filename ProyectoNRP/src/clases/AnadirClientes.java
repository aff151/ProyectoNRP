package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.Cliente;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AnadirClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtImportancia;
	public static String procedencia = "";
	public static String proySeleccionado = "";
	ConsultarProyectos cp = new ConsultarProyectos();
	
	private DefaultListModel<String> modelo;
	BD_Clientes bdCliente = new BD_Clientes();
	private List<Cliente> listaClientes;
	private JList listClientes;
	public static String cliSeleccionado = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirClientes frame = new AnadirClientes();
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
	public AnadirClientes() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 236, 398);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblSeleccionarProyecto = new JLabel("Seleccionar Cliente");
		lblSeleccionarProyecto.setBounds(52, 37, 141, 16);
		contentPane.add(lblSeleccionarProyecto);

		///////////////////////////////////////////////////
		/*
		 * CARGAR CLIENTES DE LA BD AQUI
		 */
		modelo = new DefaultListModel<String>();
		listClientes = new JList();
		listClientes.setBounds(52, 65, 141, 226);
		listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
		contentPane.add(listClientes);
		/////////////////////////////////////////////////////////////
		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//HAY QUE DARLE UNA REVISION A ESTO QUE NO TENGO GNAS DE PENSAR Q ES TARDE
				if(listClientes.isSelectionEmpty() && txtImportancia.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Debe de seleccionar un cliente e introducir su importancia", "MENSAJE", JOptionPane.WARNING_MESSAGE);
				}
				if(listClientes.isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Debe de seleccionar un cliente", "MENSAJE", JOptionPane.WARNING_MESSAGE);
				}
				if(txtImportancia.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Debe de introducir numericamente la importancia del cliente en el proyecto", "MENSAJE", JOptionPane.WARNING_MESSAGE);
				}
				try {
					bdCliente.asignaClienteProyecto(listClientes.getSelectedValue().toString(), txtImportancia.getText(), cp.proySeleccionado);
				} catch (PersistentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ModificarProyecto modificarProyecto = new ModificarProyecto();
				modificarProyecto.setVisible(true);
			}
		});
		btnAgregar.setBounds(119, 303, 86, 29);
		contentPane.add(btnAgregar);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "ConsultarProyecto") {
					ConsultarProyecto consultarProyecto = new ConsultarProyecto();
					consultarProyecto.setVisible(true);
				} else if (procedencia == "ModificarProyecto") {
					ModificarProyecto modificarProyecto = new ModificarProyecto();
					modificarProyecto.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(137, 340, 62, 29);
		contentPane.add(btnAtrs);

		txtImportancia = new JTextField();
		txtImportancia.setBounds(33, 303, 86, 26);
		contentPane.add(txtImportancia);
		txtImportancia.setColumns(10);
		cargarClientes();
	}
	
	public void cargarClientes()
	{
		try {
			listaClientes = bdCliente.cargarClientes();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Cliente c : listaClientes)
		{
			modelo.addElement(c.getNombre());
			System.out.println(c.getNombre());
			listClientes.setModel(modelo);
		}
	}

}
