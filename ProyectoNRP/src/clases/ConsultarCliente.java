package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Peso;
import database.BD_ProyReq;
import database.BD_Proyectos;
import database.BD_Valor;
import database.Cliente;
import database.Peso;
import database.Proyecto;
import database.Requisito;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

public class ConsultarCliente extends JFrame {

	private JPanel contentPane;
	public static String procedencia = "";
	BD_Proyectos bdproy = new BD_Proyectos();
	BD_Peso bdimp = new BD_Peso();

	BD_ProyReq bdproyreq = new BD_ProyReq();
	BD_Valor bdvalor = new BD_Valor();
	private JTextField textFieldDescripcion;
	private List<Requisito> listReq;
	private DefaultListModel modelo;
	private DefaultListModel modelo1;
	private JList listProyectos;
	private JList listRequisitos;
	private JScrollPane scrollLista;
	private JScrollPane scrollLista2;
	////////////////////////////////////////
	// TABLA
	///////////////////////////////////////
	private JTable tabla;
	private JScrollPane panelScroll;
	private String titColumna[];
	private String datoColumna[][];
	private List<Peso> listPeso;
	private List<Proyecto> listProy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarProyecto frame = new ConsultarProyecto();
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

		inicializar();

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
		btnAtrs.setBounds(216, 351, 69, 29);
		contentPane.add(btnAtrs);

		JLabel lblNombreCliente = new JLabel(ConsultarClientes.cliSeleccionado);
		lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCliente.setBounds(160, 21, 174, 16);
		contentPane.add(lblNombreCliente);

		///////////////////////////////////////////////////
		//// TABLA
		///////////////////////////////////////////////////
		// Creamos las columnas y las cargamos con los datos que van a
		// aparecer en la pantalla
		CreaColumnas();
		CargaDatos();
		// Creamos una instancia del componente Swing
		tabla = new JTable(datoColumna, titColumna);
		// Aquí se configuran algunos de los parámetros que permite
		// variar la JTable
		tabla.setRowSelectionAllowed(true);
		tabla.setColumnSelectionAllowed(true);
		// Incorporamos la tabla a un panel que incorpora ya una barra
		// de desplazamiento, para que la visibilidad de la tabla sea
		// automática
		panelScroll = new JScrollPane(tabla);
		panelScroll.setSize(170, 240);
		panelScroll.setLocation(10, 99);
		getContentPane().add(panelScroll, BorderLayout.CENTER);
		contentPane.add(panelScroll);

		listRequisitos = new JList();
		modelo1 = new DefaultListModel();
		scrollLista2 = new JScrollPane();
		scrollLista2.setBounds(324, 99, 170, 240);
		scrollLista2.setViewportView(listRequisitos);
		contentPane.add(scrollLista2);

		JLabel lblListaDeProyectos = new JLabel("Lista de proyectos del cliente");
		lblListaDeProyectos.setBounds(10, 60, 217, 16);
		contentPane.add(lblListaDeProyectos);

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos del proyecto");
		lblListaDeRequisitos.setBounds(324, 60, 217, 16);
		contentPane.add(lblListaDeRequisitos);

		JButton btnVerRequisitos = new JButton("Ver\r\n requisitos");
		btnVerRequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listProyectos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					modelo1.clear();
					listRequisitos.setModel(modelo1);
					cargarRequisitosClienteProyecto(listProyectos.getSelectedValue().toString(),
							ConsultarClientes.cliSeleccionado);
				}
			}
		});
		btnVerRequisitos.setBounds(193, 197, 118, 29);
		contentPane.add(btnVerRequisitos);
	}

	// Creamos las etiquetas que sirven de título a cada una de
	// las columnas de la tabla
	public void CreaColumnas() {
		titColumna = new String[2];
		titColumna[0] = "Nombre";
		titColumna[1] = "Peso";

	}

	// Creamos los datos para cada uno de los elementos de la tabla
	public void CargaDatos() {
		try {
			listProy = bdimp.cargarProyectosCliente(ConsultarClientes.cliSeleccionado);
			listPeso = bdimp.cargarPesosProyectosCliente(ConsultarClientes.cliSeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datoColumna = new String[listProy.size()][2];

		for (int i = 0; i < listProy.size(); i++) {
			datoColumna[i][0] = listProy.get(i).getNombre();
		}
		for (int j = 0; j < listProy.size(); j++) {
			datoColumna[j][1] = "" + listPeso.get(j);
		}

	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 518, 419);
		setLocationRelativeTo(null);
		setTitle("Consultar Cliente");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void cargarRequisitosClienteProyecto(String proyecto, String cliente) {
		try {
			listReq = bdvalor.cargarRequisitosClienteProyecto(proyecto, cliente);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Requisito r : listReq) {
			modelo1.addElement(r.getNombre());
			listRequisitos.setModel(modelo1);
		}
	}
}
