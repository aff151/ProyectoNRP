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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.orm.PersistentException;

import database.BD_Peso;
import database.BD_ProyReq;
import database.BD_Proyectos;
import database.BD_Valor;
import database.Cliente;
import database.peso;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.Delayed;
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

	BD_ProyReq bdproyreq = new BD_ProyReq();
	BD_Valor bdvalor = new BD_Valor();
	private List<Requisito> listReq;
	private DefaultListModel modelo1;
	private JList listRequisitos;
	////////////////////////////////////////
	// TABLA PROYECTOS
	///////////////////////////////////////
	private JTable tabla;
	private JScrollPane panelScroll;
	private String titColumna[];
	private String datoColumna[][];
	private List<peso> listPeso;
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

		botonAtras();

		tablaProyectos();

		eliminarProyecto();

	}

	private void eliminarProyecto() {
		// TODO Auto-generated method stub
		JButton btnEliminarProyecto = new JButton("Eliminar Proyecto");
		btnEliminarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quitarDeTablaYRelaciones(datoColumna[tabla.getSelectedRow()][0]);
				ConsultarCliente consultarCliente = new ConsultarCliente();
				consultarCliente.setVisible(true);
				dispose();
				
			}

			
		});
		btnEliminarProyecto.setBounds(20, 310, 147, 29);
		contentPane.add(btnEliminarProyecto);
		
		JLabel lblSeleccioneUnProyecto = new JLabel("Seleccione un proyecto");
		lblSeleccioneUnProyecto.setForeground(Color.RED);
		lblSeleccioneUnProyecto.setBounds(10, 74, 150, 14);
		contentPane.add(lblSeleccioneUnProyecto);
	}
	
	private void quitarDeTablaYRelaciones(String proyecto) {
		// TODO Auto-generated method stub
		try {
			bdpeso.eliminarProyecto(proyecto, ConsultarClientes.cliSeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void tablaRequisitos() {

		setBounds(100, 100, 430, 424);
		setLocationRelativeTo(null);

		CreaColumnasReq();
		CargaDatosReq();
		//datoColumnaReq = new String[0][0];
		tablaReq = new JTable(datoColumnaReq, titColumnaReq);
		panelScrollReq = new JScrollPane(tablaReq);
		TableColumnModel columnModel2 = tablaReq.getColumnModel();
		DefaultTableCellRenderer tcr2 = new DefaultTableCellRenderer();
		tcr2.setHorizontalAlignment(SwingConstants.CENTER);
		columnModel2.getColumn(1).setPreferredWidth(0);
		columnModel2.getColumn(1).setCellRenderer(tcr2);
		panelScrollReq.setSize(170, 200);
		panelScrollReq.setLocation(227, 99);
		getContentPane().add(panelScrollReq, BorderLayout.CENTER);
		contentPane.add(panelScrollReq);

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos del proyecto");
		lblListaDeRequisitos.setBounds(227, 60, 217, 16);
		contentPane.add(lblListaDeRequisitos);
	}

	/**
	 * 
	 */
	private void tablaProyectos() {

		JLabel lblListaDeProyectos = new JLabel("Lista de proyectos del cliente");
		lblListaDeProyectos.setBounds(10, 48, 217, 16);
		contentPane.add(lblListaDeProyectos);
		CreaColumnas();
		CargaDatos();
		tabla = new JTable(datoColumna, titColumna) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tabla.setRowSelectionAllowed(true);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TableColumnModel columnModel = tabla.getColumnModel();
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		columnModel.getColumn(1).setPreferredWidth(0);
		columnModel.getColumn(1).setCellRenderer(tcr);

		panelScroll = new JScrollPane(tabla);
		panelScroll.setSize(170, 200);
		panelScroll.setLocation(10, 99);
		getContentPane().add(panelScroll, BorderLayout.CENTER);
		contentPane.add(panelScroll);
		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable list = (JTable) evt.getSource();
				if (evt.getClickCount() == 1) {
					tablaRequisitos();
				}
			}
		});
	}

	/**
	 * 
	 */
	private void botonAtras() {
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
		btnAtrs.setBounds(64, 355, 69, 29);
		contentPane.add(btnAtrs);
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
		if (tabla.getSelectedRow() != -1)
			proyecto = datoColumna[tabla.getSelectedRow()][0];
		try {
			listValor = bdvalor.cargarValorRequisitosClienteProyecto(proyecto, ConsultarClientes.cliSeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datoColumnaReq = new String[listValor.size()][2];

		for (int i = 0; i < listValor.size(); i++) {
			datoColumnaReq[i][0] = listValor.get(i).getRequisito().getNombre();
		}
		for (int j = 0; j < listValor.size(); j++) {
			datoColumnaReq[j][1] = "" + listValor.get(j).getValor();
		}
	}

	public void creaTablaReq() {

	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 209, 424);
		setLocationRelativeTo(null);
		setTitle("Consultar Cliente");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreCliente = new JLabel(ConsultarClientes.cliSeleccionado);
		lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCliente.setBounds(20, 21, 174, 16);
		contentPane.add(lblNombreCliente);
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
