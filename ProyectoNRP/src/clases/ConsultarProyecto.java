package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import database.BD_Requisitos;
import database.Cliente;
import database.Peso;
import database.ProyReq;
import database.Proyecto;
import database.Requisito;
import database.Valor;

import javax.swing.JLabel;
import javax.swing.JList;
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
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class ConsultarProyecto extends JFrame {

	private JPanel contentPane;
	public static String procedencia = "";
	ConsultarProyectos cons = new ConsultarProyectos();
	BD_Proyectos bdproy = new BD_Proyectos();
	BD_Peso bdimp = new BD_Peso();
	BD_ProyReq bdreq = new BD_ProyReq();
	private List<Cliente> listCli;
	private List<Requisito> listReq;
	private DefaultListModel modelo;
	private DefaultListModel modelo2;
	private JList listClientes;
	private JList listRequisitos;
	Proyecto consproy = null;
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
	private JTable tablaEsf;
	private JScrollPane panelScrollEsf;
	private String titColumnaEsf[];
	private String datoColumnaEsf[][];
	private List<ProyReq> listEsfuerzo;

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
	public ConsultarProyecto() {

		inicializar();

		try {
			consproy = descargarInformacion(cons.proySeleccionado);
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblNombreProyecto = new JLabel(consproy.getNombre());
		lblNombreProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreProyecto.setBounds(126, 21, 174, 16);
		contentPane.add(lblNombreProyecto);

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
		panelScroll.setLocation(10, 136);
		getContentPane().add(panelScroll, BorderLayout.CENTER);
		contentPane.add(panelScroll);

		///////////////////////////////////////////////////
		//// TABLA REQUISITOS
		///////////////////////////////////////////////////
		CreaColumnasEsf();
		CargaDatosEsf();
		tablaEsf= new JTable(datoColumnaEsf, titColumnaEsf);
		panelScrollEsf = new JScrollPane(tablaEsf);
		panelScrollEsf.setSize(170, 240);
		panelScrollEsf.setLocation(250, 136);
		getContentPane().add(panelScrollEsf, BorderLayout.CENTER);
		contentPane.add(panelScrollEsf);

		JLabel lblListaDeClientes = new JLabel("Lista de clientes del proyecto");
		lblListaDeClientes.setBounds(15, 108, 217, 16);
		contentPane.add(lblListaDeClientes);

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos del proyecto");
		lblListaDeRequisitos.setBounds(250, 108, 217, 16);
		contentPane.add(lblListaDeRequisitos);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "ConsultarCliente") {
					ConsultarCliente consultarCliente = new ConsultarCliente();
					consultarCliente.setVisible(true);
				} else if (procedencia == "ConsultarProyectos") {
					ConsultarProyectos consultarProyectos = new ConsultarProyectos();
					consultarProyectos.setVisible(true);
				}

				dispose();
			}
		});
		btnAtrs.setBounds(184, 386, 69, 29);
		contentPane.add(btnAtrs);

		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(15, 52, 87, 16);
		contentPane.add(lblDescripcin);

		JTextArea textArea = new JTextArea(consproy.getDescripcion());
		textArea.setBounds(93, 52, 331, 49);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBackground(getForeground());
		contentPane.add(textArea);
	}

	private void CargaDatosEsf() {
		try {
			listReq = bdreq.cargarRequisitosProyecto(cons.proySeleccionado);
			listEsfuerzo = bdreq.cargarEsfuerzo(cons.proySeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datoColumnaEsf = new String[listReq.size()][2];

		for (int i = 0; i < listReq.size(); i++) {
			datoColumnaEsf[i][0] = listReq.get(i).getNombre();
		}
		for (int j = 0; j < listReq.size(); j++) {
			datoColumnaEsf[j][1] = "" + listEsfuerzo.get(j).getEsfuerzo();
		}
	}

	private void CreaColumnasEsf() {
		titColumnaEsf = new String[2];
		titColumnaEsf[0] = "Nombre";
		titColumnaEsf[1] = "Esfuerzo";
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
			listCli = bdimp.cargarClientesProyecto(consproy.getNombre());
			listPeso = bdimp.cargarPesosProyecto(consproy.getNombre());
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datoColumna = new String[listCli.size()][2];

		for (int i = 0; i < listCli.size(); i++) {
			datoColumna[i][0] = listCli.get(i).getNombre();
		}
		for (int j = 0; j < listCli.size(); j++) {
			datoColumna[j][1] = "" + listPeso.get(j).getPeso();
		}

	}


	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 451, 454);
		setLocationRelativeTo(null);
		setTitle("Consultar Proyecto");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public Proyecto descargarInformacion(String proySeleccionado) throws PersistentException {
		return bdproy.descargarInformacion(proySeleccionado);
	}
}
