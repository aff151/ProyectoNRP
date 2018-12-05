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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.orm.PersistentException;

import database.peso;
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
	private List<peso> listPeso;
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
	private List<peso> listPeso2;
	private List<ProyReq> listProyReq2;
	private List<Requisito> listReq2;
	private List<Valor> listValor2;
	//Array con todas las productividades
	private double [] arrayProd;
	//Tabla con todas las productividades
	private JTable tablaProd;
	private Object [][] arrayTabProd;
	private JScrollPane scrollPane_2;
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
		TableColumnModel columnModel = tabla.getColumnModel();
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		columnModel.getColumn(1).setPreferredWidth(60);
		columnModel.getColumn(2).setPreferredWidth(40);
		columnModel.getColumn(1).setCellRenderer(tcr);
		columnModel.getColumn(2).setCellRenderer(tcr);
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
				TableColumnModel columnModel2 = tabla2.getColumnModel();
				DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
				tcr2.setHorizontalAlignment(SwingConstants.CENTER);
				columnModel2.getColumn(1).setPreferredWidth(60);
				columnModel2.getColumn(2).setPreferredWidth(40);
				columnModel2.getColumn(1).setCellRenderer(tcr2);
				columnModel2.getColumn(2).setCellRenderer(tcr2);
				// Incorporamos la tabla a un panel que incorpora ya una barra
				// de desplazamiento, para que la visibilidad de la tabla sea
				// automática
				panelScroll2 = new JScrollPane(tabla2);
				panelScroll2.setSize(217, 240);
				panelScroll2.setLocation(364, 57);
				getContentPane().add(panelScroll2, BorderLayout.CENTER);
				contentPane.add(panelScroll2);
				
				calcularProductividad();
				crearTablaProductividad();
			}

		});
		BtnLimiteEsfuerzo.setBounds(237, 192, 117, 23);
		contentPane.add(BtnLimiteEsfuerzo);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planificacion consProyPlanif = new Planificacion();
				consProyPlanif.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(31, 319, 89, 23);
		contentPane.add(btnAtrs);

		limitetextField = new JTextField();
		limitetextField.setBounds(250, 161, 86, 20);
		contentPane.add(limitetextField);
		limitetextField.setColumns(10);
		
		JLabel lblTablaRes = new JLabel("Tabla de satisfaccion de requisitos");
		lblTablaRes.setBounds(25, 35, 202, 14);
		contentPane.add(lblTablaRes);
		
		JLabel lblTablaSel = new JLabel("Tabla de requisitos seleccionados");
		lblTablaSel.setBounds(370, 35, 200, 14);
		contentPane.add(lblTablaSel);
		
		JLabel lblTablaProd = new JLabel("Productividad de los requisitos");
		lblTablaProd.setBounds(680, 35, 200, 14);
		contentPane.add(lblTablaProd);

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
		setBounds(100, 100, 632, 395);
		setLocationRelativeTo(null);
		setTitle("Planificación del proyecto" + ConsultarProyectosPlanificacion.proySeleccionado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProyecto = new JLabel(ConsultarProyectosPlanificacion.proySeleccionado);
		lblProyecto.setBounds(320, 11, 332, 14);
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
	
	public void calcularProductividad() {
		int satisfaccionTotal = 0, esfuerzoTotal = 0;
		arrayProd = new double[listReqLimite.size()];
		arrayTabProd = new Object[arrayProd.length+1][2];
		for(int i = 0; i < arrayProd.length; i++) {
			//Productividad(de cada requisito) = satisfaccion/esfuerzo
			arrayProd[i] = ((double)listReqLimite.get(i).getSatisfaccion()/
					(double)listReqLimite.get(i).getEsfuerzo()); 
			arrayTabProd[i][0] = listReqLimite.get(i).getNombre(); 
			arrayTabProd[i][1] = arrayProd[i];
			satisfaccionTotal += listReqLimite.get(i).getSatisfaccion();
			esfuerzoTotal += listReqLimite.get(i).getEsfuerzo();
		}
		arrayTabProd[arrayProd.length][0] = "pro(S) = sat(S)/eff(S)";
		arrayTabProd[arrayProd.length][1] = (double)satisfaccionTotal/esfuerzoTotal;
	}
	
	public void crearTablaProductividad() {
		//lblTablaProd.setVisible(true);
		tablaProd = new JTable();
		tablaProd.setModel(new DefaultTableModel(arrayTabProd,
			new String[] {
				"Requisito", "Productividad"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(670, 57, 217, 240);
		contentPane.add(scrollPane_2);
		tablaProd.getColumnModel().getColumn(0).setPreferredWidth(110);
		tablaProd.getColumnModel().getColumn(1).setPreferredWidth(77);
		scrollPane_2.setViewportView(tablaProd);
		
		setBounds(100, 100, 932, 395);
		setLocationRelativeTo(null);
	}
}
