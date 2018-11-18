package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.BD_Proyectos;
import database.BD_Requisitos;
import database.BD_Valor;
import database.Cliente;
import database.Requisito;

import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class AsignarValoresRequisitos extends JFrame {

	BD_Valor bdValor = new BD_Valor();
	
	
	private JPanel contentPane;
	private JTextField textValor;
	protected String procedencia;
	//Componentes para listaReq
	private JList listRequisitos;
	private List<Requisito> listaRequisito;
	private DefaultListModel<String> modelReq;
	private JScrollPane scrollLista;
	BD_Requisitos bd_req = new BD_Requisitos();
	
	//Componentes para listaClientes
	private JList listClientes;
	private List<Cliente> listaClientes;
	private DefaultListModel<String> modelCli;
	private JScrollPane scrollListaC;
	BD_Proyectos bdProyecto = new BD_Proyectos();
	
	ConsultarProyectos cons = new ConsultarProyectos();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignarValoresRequisitos frame = new AsignarValoresRequisitos();
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
	public AsignarValoresRequisitos() {
	//	inicializar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDebeDeAsignar = new JLabel("Debe de asignar un valor al requisto en relación al cliente");
		lblDebeDeAsignar.setBounds(22, 6, 409, 16);
		contentPane.add(lblDebeDeAsignar);
		
		JLabel lblSeleccionCliente = new JLabel("Selecciona Cliente");
		lblSeleccionCliente.setBounds(16, 56, 128, 16);
		contentPane.add(lblSeleccionCliente);
		
		JLabel lblSeleccionarRequisito = new JLabel("Seleccionar Requisito");
		lblSeleccionarRequisito.setBounds(174, 56, 176, 16);
		contentPane.add(lblSeleccionarRequisito);
		/*
		 * LISTA DE REQUISITOS
		 */
		listRequisitos = new JList();
		listRequisitos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	//	scrollLista = new JScrollPane();
		//scrollLista.setBounds(286, 46, 121, 129);		
		//scrollLista.setViewportView(listRequisitos);
		listRequisitos.setBounds(184, 84, 117, 149);
		contentPane.add(listRequisitos);
		modelReq = new DefaultListModel<String>();
		
		/*
		 * LISTA DE CLIENTES
		 */
		listClientes = new JList();
		listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	//	scrollListaC = new JScrollPane();
	//	scrollListaC.setBounds(286, 46, 121, 129);		
	//	scrollListaC.setViewportView(listClientes);
		listClientes.setBounds(16, 84, 117, 149);
		contentPane.add(listClientes);
		modelCli = new DefaultListModel<String>();
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(356, 106, 61, 16);
		contentPane.add(lblValor);
		
		textValor = new JTextField();
		textValor.setBounds(313, 138, 130, 26);
		contentPane.add(textValor);
		textValor.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				modificarValores();
				
			}
		});
		btnGuardar.setBounds(327, 232, 117, 29);
		contentPane.add(btnGuardar);
		
		JButton btnCargardatos = new JButton("Cargar");
		btnCargardatos.setBounds(371, 161, 72, 29);
		contentPane.add(btnCargardatos);
		cargarClientesProyecto();
		cargarRequisitosProyecto();
	}
	
	//CARGAR CLIENTES DEL PROYECTO
	//CARGAR REQUISITOS DEL PROYECTO
	//CARGAR VALOR
	//MODIFICAR VALOR
	
	public void cargarClientesProyecto()
	{
		try {
			listaClientes = bdProyecto.cargarClientesProyecto(cons.proySeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Cliente c : listaClientes)
		{
			modelCli.addElement(c.getNombre());
			listClientes.setModel(modelCli);
		}
		
	}
	public void cargarRequisitosProyecto() {
		try {
			listaRequisito = bd_req.cargarRequisitosProyecto(cons.proySeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Requisito r : listaRequisito) {
			String nombre = r.getNombre();
			modelReq.addElement(r.getNombre());
			listRequisitos.setModel(modelReq);
		}
	}

	public boolean modificarValores()
	{
		
		String nProyecto = cons.proySeleccionado;
		String nCliente = listClientes.getSelectedValue().toString();
		String valor = textValor.getText();
		String nReq = listRequisitos.getSelectedValue().toString();
		
		try {
			bdValor.crearValor(nProyecto, nCliente, nReq, valor);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
}
