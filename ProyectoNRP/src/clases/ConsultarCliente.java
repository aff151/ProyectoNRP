package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Proyectos;
import database.BD_Requisitos;
import database.Proyecto;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultarCliente extends JFrame {

	BD_Requisitos bdReq = new BD_Requisitos();
	BD_Proyectos bdPro = new BD_Proyectos();
	private JPanel contentPane;
	public static String procedencia = "";
	public static String nombreCliente = "";

	public static String proySeleccionado = "";
	private List<Proyecto> listPro;
	private DefaultListModel<String> modelo;
	private JList listProyectos;

	public static String reqSeleccionado = "";
	private List<Proyecto> listReq;

	private JList listRequisitos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCliente frame = new ConsultarCliente();
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
	public ConsultarCliente() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
System.out.println("NOMBRE DEL CLIENTE: "+nombreCliente);
		JLabel lblConsultaDelProyecto = new JLabel("Consulta del cliente " + nombreCliente);
		lblConsultaDelProyecto.setBounds(31, 43, 174, 16);
		contentPane.add(lblConsultaDelProyecto);
////////////////////
		// JList list = new JList();
		// list.setBounds(68, 154, 124, 199);
		// contentPane.add(list);

		modelo = new DefaultListModel<String>();

		listProyectos = new JList();
		listProyectos.setBounds(68, 154, 124, 199);
		listProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(listProyectos);

////////////////////////////		
		// JList list_1 = new JList();
		// list_1.setBounds(353, 154, 124, 199);
		// contentPane.add(list_1);

		modelo = new DefaultListModel<String>();

		listRequisitos = new JList();
		listRequisitos.setBounds(353, 154, 124, 199);
		listRequisitos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(listRequisitos);
////////////////////////////
		JLabel lblListaDeClientes = new JLabel("Lista de proyectos asociados");
		lblListaDeClientes.setBounds(31, 126, 217, 16);
		contentPane.add(lblListaDeClientes);

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos asociados");
		lblListaDeRequisitos.setBounds(313, 126, 217, 16);
		contentPane.add(lblListaDeRequisitos);

		JButton btnAadirMsClientes = new JButton("Consultar Proyecto");
		btnAadirMsClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listProyectos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					ConsultarProyecto consultarProyecto = new ConsultarProyecto();
					consultarProyecto.setVisible(true);
					consultarProyecto.procedencia = "ConsultarCliente";
					dispose();
				}
			}
		});
		btnAadirMsClientes.setBounds(45, 365, 170, 29);
		contentPane.add(btnAadirMsClientes);

		JButton btnAadirMsRequisitos = new JButton("Consultar Requisito");
		btnAadirMsRequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listRequisitos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un requisito", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					ConsultarRequisito consultarRequisito = new ConsultarRequisito();
					consultarRequisito.setVisible(true);
					consultarRequisito.procedencia = "ConsultarCliente";
					dispose();
				}
			}
		});
		btnAadirMsRequisitos.setBounds(333, 365, 170, 29);
		contentPane.add(btnAadirMsRequisitos);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "ConsultarRequisito") {
					ConsultarRequisito consultarRequisito = new ConsultarRequisito();
					consultarRequisito.setVisible(true);
				} else if (procedencia == "ConsultarClientes") {
					ConsultarClientes consultarClientes = new ConsultarClientes();
					consultarClientes.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(482, 429, 77, 29);
		contentPane.add(btnAtrs);

		JButton button = new JButton("Añadir más Proyectos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsignarProyectos asignarProyectos = new AsignarProyectos();
				asignarProyectos.setVisible(true);
				asignarProyectos.procedencia = "ConsultarCliente";
				dispose();
			}
		});
		button.setBounds(45, 393, 170, 29);
		contentPane.add(button);

		cargarProyectos();
		// cargarRequisitos();
	}

	public void cargarProyectos() {
		try {
			listPro = bdPro.cargarProyectosCliente(nombreCliente);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Proyecto c : listPro) {
			modelo.addElement(c.getNombre());
			listProyectos.setModel(modelo);
		}
	}
	/*
	 * public void cargarRequisitos() { try { listPro =
	 * bdReq.cargarRequisitosCliente(nombreCliente); } catch (PersistentException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } for (Proyecto c :
	 * listPro) { modelo.addElement(c.getNombre()); listProyectos.setModel(modelo);
	 * } }
	 */
}
