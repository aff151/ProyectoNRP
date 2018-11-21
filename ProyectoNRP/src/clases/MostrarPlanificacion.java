package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.Peso;
import database.ProyReq;
import database.Requisito;
import database.Valor;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MostrarPlanificacion extends JFrame {

	private JPanel contentPane;
	////////////////////////////////////////
	// TABLA PLANIFICACION
	///////////////////////////////////////
	private JTable tabla;
	private JScrollPane panelScroll;
	private String titColumna[];
	private String datoColumna[][];
	private List<Peso> listPeso;
	private List<ProyReq> listProyReq;
	private List<Requisito> listReq;
	private List<Valor> listValor;
	private JTextField limitetextField;
	public List<RequisitoSat> listReqLimite;
	////////////////////////////////////////
	// TABLA PLANIFICACION
	///////////////////////////////////////
	private JTable tabla2;
	private JScrollPane panelScroll2;
	private String titColumna2[];
	private String datoColumna2[][];
	private List<Peso> listPeso2;
	private List<ProyReq> listProyReq2;
	private List<Requisito> listReq2;
	private List<Valor> listValor2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarPlanificacion frame = new MostrarPlanificacion();
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
	public MostrarPlanificacion() {
		inicializar();

		///////////////////////////////////////////////////
		//// TABLA PROYECTOS
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
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Incorporamos la tabla a un panel que incorpora ya una barra
		// de desplazamiento, para que la visibilidad de la tabla sea
		// automática
		panelScroll = new JScrollPane(tabla);
		panelScroll.setSize(217, 240);
		panelScroll.setLocation(10, 57);
		getContentPane().add(panelScroll, BorderLayout.CENTER);
		contentPane.add(panelScroll);

		JButton BtnLimiteEsfuerzo = new JButton("Aplicar límite");
		BtnLimiteEsfuerzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int limit = Integer.parseInt(limitetextField.getText());
				cargarDatosLimitados(limit);

				///////////////////////////////////////////////////
				//// TABLA PROYECTOS
				///////////////////////////////////////////////////
				// Creamos las columnas y las cargamos con los datos que van a
				// aparecer en la pantalla
				CreaColumnas();
				CargaDatos2();
				// Creamos una instancia del componente Swing
				tabla2 = new JTable(datoColumna2, titColumna);
				// Aquí se configuran algunos de los parámetros que permite
				// variar la JTable
				tabla2.setRowSelectionAllowed(true);
				tabla2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				// Incorporamos la tabla a un panel que incorpora ya una barra
				// de desplazamiento, para que la visibilidad de la tabla sea
				// automática
				panelScroll2 = new JScrollPane(tabla2);
				panelScroll2.setSize(217, 240);
				panelScroll2.setLocation(364, 57);
				getContentPane().add(panelScroll2, BorderLayout.CENTER);
				contentPane.add(panelScroll2);
			}

		});
		BtnLimiteEsfuerzo.setBounds(237, 192, 117, 23);
		contentPane.add(BtnLimiteEsfuerzo);

		limitetextField = new JTextField();
		limitetextField.setBounds(250, 161, 86, 20);
		contentPane.add(limitetextField);
		limitetextField.setColumns(10);

	}

	private void CargaDatos2() {
		// TODO Auto-generated method stub
		datoColumna2 = new String[listReqLimite.size()][3];
		for (int i = 0; i < listReqLimite.size(); i++) {

			datoColumna2[i][0] = listReqLimite.get(i).getNombre();
			datoColumna2[i][1] = Integer.toString(listReqLimite.get(i).getSatisfaccion());
			datoColumna2[i][2] = Integer.toString(listReqLimite.get(i).getEsfuerzo());

		}
	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 632, 427);
		setLocationRelativeTo(null);
		setTitle("Planificación del proyecto" + ConsultarProyectosPlanificacion.proySeleccionado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProyecto = new JLabel(
				"Planificación del proyecto" + ConsultarProyectosPlanificacion.proySeleccionado);
		lblProyecto.setBounds(20, 11, 332, 14);
		contentPane.add(lblProyecto);

	}

	public void CreaColumnas() {

		titColumna = new String[3];
		titColumna[0] = "Requisito";
		titColumna[1] = "Satisfacción";
		titColumna[2] = "Esfuerzo";

	}

	// Creamos los datos para cada uno de los elementos de la tabla
	public void CargaDatos() {

		datoColumna = new String[Planificacion.listReqSat.size()][titColumna.length];
		for (int i = 0; i < Planificacion.listReqSat.size(); i++) {

			datoColumna[i][0] = Planificacion.listReqSat.get(i).getNombre();
			datoColumna[i][1] = Integer.toString(Planificacion.listReqSat.get(i).getSatisfaccion());
			datoColumna[i][2] = Integer.toString(Planificacion.listReqSat.get(i).getEsfuerzo());

		}

	}

	private void cargarDatosLimitados(int limit) {
		// TODO Auto-generated method stub
		listReqLimite = new ArrayList<RequisitoSat>();
		for (int i = 0; i < Planificacion.listReqSat.size(); i++) {
			if (Planificacion.listReqSat.get(i).getEsfuerzo() <= limit) {
				
				listReqLimite.add(Planificacion.listReqSat.get(i));
				limit = limit - Planificacion.listReqSat.get(i).getEsfuerzo();
			}

		}
	}
}
