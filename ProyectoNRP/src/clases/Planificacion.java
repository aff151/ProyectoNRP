package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Peso;
import database.BD_ProyReq;
import database.BD_Requisitos;
import database.BD_Valor;
import database.Peso;
import database.Proyecto;
import database.Requisito;
import database.Valor;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Planificacion extends JFrame {

	protected static String procedencia;
	private JPanel contentPane;
	BD_ProyReq bdProyreq = new BD_ProyReq();
	BD_Peso bdPeso = new BD_Peso();
	BD_Valor bdValor = new BD_Valor();
	////////////////////////////////////////
	// TABLA PLANIFICACION
	///////////////////////////////////////
	private JTable tabla;
	private JScrollPane panelScroll;
	private String titColumna[];
	private String datoColumna[][];
	private List<Peso> listPeso;
	private List<Requisito> listReq;
	private List<Valor> listValor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Planificacion frame = new Planificacion();
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
	public Planificacion() {
		
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
		panelScroll.setSize(543, 240);
		panelScroll.setLocation(10, 57);
		getContentPane().add(panelScroll, BorderLayout.CENTER);
		contentPane.add(panelScroll);
		
		
		JLabel label = new JLabel(ConsultarProyectosPlanificacion.proySeleccionado);
		label.setBounds(214, 22, 120, 14);
		contentPane.add(label);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProyectosPlanificacion consProyPlanif = new ConsultarProyectosPlanificacion();
				consProyPlanif.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(10, 342, 89, 23);
		contentPane.add(btnAtrs);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(464, 308, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnPlanificar = new JButton("Planificar");
		btnPlanificar.setBounds(464, 342, 89, 23);
		contentPane.add(btnPlanificar);
	}
	
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 569, 405);
		setLocationRelativeTo(null);
		setTitle("Programa para gestión de requisitos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	// Creamos las etiquetas que sirven de título a cada una de
	// las columnas de la tabla
	public void CreaColumnas() {
		try {
			listReq = bdProyreq.cargarRequisitosProyecto(ConsultarProyectosPlanificacion.proySeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		titColumna = new String[listReq.size() + 2];
		titColumna[0] = "Cliente";
		titColumna[listReq.size() + 1] = "Peso";
		for(int i = 1; i <= titColumna.length-2; i++) {
			titColumna[i] = listReq.get(i-1).getNombre();
		}
	}

	// Creamos los datos para cada uno de los elementos de la tabla
	public void CargaDatos() {
		int k = 0;
		try {
			listPeso = bdPeso.cargarPesosProyecto(ConsultarProyectosPlanificacion.proySeleccionado);
			listValor = bdValor.cargarValorProyecto(ConsultarProyectosPlanificacion.proySeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datoColumna = new String[listPeso.size()][titColumna.length];
		//Columna de clientes
		for(int i = 0; i < listPeso.size(); i++)
			datoColumna[i][0] = listPeso.get(i).getCliente().getNombre();
		for(int i = 0; i < listPeso.size(); i++) {
			for(int j = 0; j < listValor.size(); j++) {

			}
		}
		for(int i = 0; i < listPeso.size(); i++) {
			datoColumna[i][listReq.size() + 1] = String.valueOf(listPeso.get(i).getPeso());
		}
		/*for(int i = 0; i < listPeso.size(); i++)
			datoColumna[i][0] = "";
		for(int i = 0; i < listPeso.size(); i++) {
			for(int j = 0; j < listValor.size(); j++) {
				if(listPeso.get(i).getCliente().getNombre().equals(listValor.get(j).getCliente().getNombre()))
						datoColumna[i][j+1] = "";
				datoColumna[i][j+1] = "";
			}
		}
		for(int i = 0; i < listPeso.size(); i++) {
			datoColumna[i][listReq.size() + 1] = "";
		}*/
	}
}
