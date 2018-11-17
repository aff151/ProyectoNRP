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
import database.ProyReq;
import database.Proyecto;
import database.Requisito;
import database.Valor;

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
	BD_Peso bdpeso = new BD_Peso();
	JLabel lblProyecto;

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
	// TABLA PROYECTOS
	///////////////////////////////////////
	private JTable tabla;
	private JScrollPane panelScroll;
	private String titColumna[];
	private String datoColumna[][];
	private List<Peso> listPeso;
	private List<Proyecto> listProy;
	////////////////////////////////////////
	// TABLA REQUISITOS
	///////////////////////////////////////
	private JTable tablaReq;
	private JScrollPane panelScrollReq;
	private String titColumnaReq[];
	private String datoColumnaReq[][];
	private List<Valor> listValor;
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
		//// TABLA PROYECTOS
		///////////////////////////////////////////////////
		// Creamos las columnas y las cargamos con los datos que van a
		// aparecer en la pantalla
		CreaColumnas();
		CargaDatos();
		// Creamos una instancia del componente Swing
		tabla = new JTable(datoColumna, titColumna) { 
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		// Aquí se configuran algunos de los parámetros que permite
		// variar la JTable
		tabla.setRowSelectionAllowed(true);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Incorporamos la tabla a un panel que incorpora ya una barra
		// de desplazamiento, para que la visibilidad de la tabla sea
		// automática
		panelScroll = new JScrollPane(tabla);
		panelScroll.setSize(170, 240);
		panelScroll.setLocation(10, 99);
		getContentPane().add(panelScroll, BorderLayout.CENTER);
		contentPane.add(panelScroll);

		///////////////////////////////////////////////////
		//// TABLA REQUISITOS
		///////////////////////////////////////////////////
		CreaColumnasReq();
		datoColumnaReq = new String[0][0];
		tablaReq = new JTable(datoColumnaReq, titColumnaReq);
		panelScrollReq = new JScrollPane(tablaReq);
		panelScrollReq.setSize(170, 240);
		panelScrollReq.setLocation(324, 99);
		getContentPane().add(panelScrollReq, BorderLayout.CENTER);
		contentPane.add(panelScrollReq);
		
		JLabel lblListaDeProyectos = new JLabel("Lista de proyectos del cliente");
		lblListaDeProyectos.setBounds(10, 60, 217, 16);
		contentPane.add(lblListaDeProyectos);

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos del proyecto");
		lblListaDeRequisitos.setBounds(324, 60, 217, 16);
		contentPane.add(lblListaDeRequisitos);

		JButton btnVerRequisitos = new JButton("Ver\r\n requisitos");
		btnVerRequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabla.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					creaTablaReq();
				}
			}
		});
		btnVerRequisitos.setBounds(193, 197, 118, 29);
		contentPane.add(btnVerRequisitos);
		lblProyecto = new JLabel();
		lblProyecto.setBounds(369, 79, 69, 16);
		contentPane.add(lblProyecto);
		
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
			listProy = bdpeso.cargarProyectosCliente(ConsultarClientes.cliSeleccionado);
			listPeso = bdpeso.cargarPesosProyectosCliente(ConsultarClientes.cliSeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datoColumna = new String[listProy.size()][2];

		for (int i = 0; i < listProy.size(); i++) {
			datoColumna[i][0] = listProy.get(i).getNombre();
		}
		for (int j = 0; j < listProy.size(); j++) {
			datoColumna[j][1] = "" + listPeso.get(j).getPeso();
		}

	}
	// Creamos las etiquetas que sirven de título a cada una de
	// las columnas de la tabla
	public void CreaColumnasReq() {
		titColumnaReq = new String[2];
		titColumnaReq[0] = "Nombre";
		titColumnaReq[1] = "Esfuerzo";
	}
	// Creamos los datos para cada uno de los elementos de la tabla
	public void CargaDatosReq() {
		String proyecto = "";
		if(tabla.getSelectedRow() != -1) 
			proyecto = datoColumna[tabla.getSelectedRow()][0];
		try {
			listValor = bdvalor.cargarValorRequisitosClienteProyecto(proyecto, ConsultarClientes.cliSeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblProyecto.setText(proyecto);
		datoColumnaReq = new String[listValor.size()][2];

		for (int i = 0; i < listValor.size(); i++) {
			datoColumnaReq[i][0] = listValor.get(i).getRequisito().getNombre();
		}
		for (int j = 0; j < listValor.size(); j++) {
			datoColumnaReq[j][1] = "" + listValor.get(j).getValor();
		}
	}
	public void creaTablaReq() {
		///////////////////////////////////////////////////
		//// TABLA REQUISITOS
		///////////////////////////////////////////////////
		CargaDatosReq();
		tablaReq = new JTable(datoColumnaReq, titColumnaReq);
		panelScrollReq = new JScrollPane(tablaReq);
		panelScrollReq.setSize(170, 240);
		panelScrollReq.setLocation(324, 99);
		getContentPane().add(panelScrollReq, BorderLayout.CENTER);
		contentPane.add(panelScrollReq);
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
