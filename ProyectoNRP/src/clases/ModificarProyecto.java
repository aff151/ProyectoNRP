package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Peso;
import database.BD_ProyReq;
import database.BD_Proyectos;
import database.BD_Requisitos;
import database.Cliente;
import database.peso;
import database.ProyReq;
import database.Proyecto;
import database.Requisito;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class ModificarProyecto extends JFrame {

	private JPanel contentPane;
	public static String procedencia = "";
	private DefaultListModel modelo;
	private DefaultListModel modelo2;
	BD_Proyectos bdproy = new BD_Proyectos();
	BD_Peso bdimp = new BD_Peso();
	BD_Requisitos bdreq = new BD_Requisitos();

	BD_ProyReq bdproyreq = new BD_ProyReq();
	ConsultarProyectos cons = new ConsultarProyectos();
	Proyecto consproy = null;
	private List<Cliente> listCli;
	private List<Requisito> listReq;
	private TextField txtNombreProyecto;
	private JTextArea tAreaDesc;

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
					ModificarProyecto frame = new ModificarProyecto();
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
	public ModificarProyecto() {

		inicializar();

		try {
			consproy = descargarInformacion(cons.proySeleccionado);
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JSeparator separator = new JSeparator();
		// separator.setForeground(Color.BLACK);
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(10, 146, 406, 2);
		contentPane.add(separator);

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
		panelScroll.setSize(170, 198);
		panelScroll.setLocation(10, 187);
		getContentPane().add(panelScroll, BorderLayout.CENTER);
		contentPane.add(panelScroll);

		///////////////////////////////////////////////////
		//// TABLA ESFUERZO
		///////////////////////////////////////////////////
		CreaColumnasEsf();
		CargaDatosEsf();
		tablaEsf = new JTable(datoColumnaEsf, titColumnaEsf);
		panelScrollEsf = new JScrollPane(tablaEsf);
		panelScrollEsf.setSize(170, 198);
		panelScrollEsf.setLocation(250, 187);
		getContentPane().add(panelScrollEsf, BorderLayout.CENTER);
		contentPane.add(panelScrollEsf);

		txtNombreProyecto = new TextField(consproy.getNombre());
		txtNombreProyecto.setBounds(131, 10, 285, 25);
		contentPane.add(txtNombreProyecto);

		JLabel lblListaDeClientes = new JLabel("Lista de clientes del proyecto");
		lblListaDeClientes.setBounds(10, 159, 217, 16);
		contentPane.add(lblListaDeClientes);

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos del proyecto");
		lblListaDeRequisitos.setBounds(246, 159, 217, 16);
		contentPane.add(lblListaDeRequisitos);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "ConsultarProyectos") {
					ConsultarProyectos consultarProyectos = new ConsultarProyectos();
					consultarProyectos.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(10, 477, 73, 29);
		contentPane.add(btnAtrs);

		JButton btnAadirMsClientes_1 = new JButton("Añadir más Clientes");
		btnAadirMsClientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnadirClientes anadirClientes = new AnadirClientes();
				anadirClientes.setVisible(true);
				anadirClientes.procedencia = "ModificarProyecto";
				dispose();
			}
		});
		btnAadirMsClientes_1.setBounds(10, 432, 166, 29);
		contentPane.add(btnAadirMsClientes_1);

		JButton btnAadirMsRequisitos_1 = new JButton("Añadir más Requisitos");
		btnAadirMsRequisitos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearRequisito crearRequisito = new CrearRequisito();
				crearRequisito.setVisible(true);
				crearRequisito.procedencia = "ModificarProyecto";
				dispose();
			}
		});
		btnAadirMsRequisitos_1.setBounds(250, 432, 166, 29);
		contentPane.add(btnAadirMsRequisitos_1);

		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(31, 51, 73, 21);
		contentPane.add(lblDescripcin);

		tAreaDesc = new JTextArea(consproy.getDescripcion());
		tAreaDesc.setBounds(131, 49, 285, 66);
		tAreaDesc.setColumns(10);
		tAreaDesc.setLineWrap(true);
		tAreaDesc.setWrapStyleWord(true);
		contentPane.add(tAreaDesc);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(51, 10, 46, 14);
		contentPane.add(lblNombre);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarProyecto();
			}
		});
		btnGuardar.setBounds(10, 115, 89, 23);
		contentPane.add(btnGuardar);

		JButton btnNewButton = new JButton("Asignar Valores a Requisitos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AsignarValoresRequisitos avr = new AsignarValoresRequisitos();
				avr.setVisible(true);
				avr.procedencia = "ModificarProyecto";
				dispose();
			}
		});
		btnNewButton.setBounds(206, 479, 209, 25);
		contentPane.add(btnNewButton);

		JButton btnQuitarCliente = new JButton("Quitar Cliente");
		btnQuitarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarCliente();
			}
		});
		btnQuitarCliente.setBounds(31, 395, 124, 29);
		contentPane.add(btnQuitarCliente);

		JButton btnQuitarRequisito = new JButton("Quitar Requisito");
		btnQuitarRequisito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarRequisito();
			}
		});
		btnQuitarRequisito.setBounds(272, 395, 131, 29);
		contentPane.add(btnQuitarRequisito);

	}

	public void inicializar() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 439, 534);
		setLocationRelativeTo(null);
		setTitle("Modificar Proyecto");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public Proyecto descargarInformacion(String proySeleccionado) throws PersistentException {
		return bdproy.descargarInformacion(proySeleccionado);
	}

	///////////////////////////////////////////////////// NUEVA FUNCIONALIDAD

	public void quitarRequisito() {

		if (tablaEsf.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Seleccione un requisito.", "MENSAJE", JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				 bdproy.quitarRequisitoProyecto(listReq.get(tablaEsf.getSelectedRow()),
						cons.proySeleccionado);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (int i = 0; i < listReq.size(); i++) {
				datoColumnaEsf[i][0] ="";
			}
			for (int j = 0; j < listReq.size(); j++) {
				datoColumnaEsf[j][1] = "";
			}
			
			try {
				listReq = bdproyreq.cargarRequisitosProyecto(cons.proySeleccionado);
				listEsfuerzo = bdproyreq.cargarEsfuerzo(cons.proySeleccionado);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (int i = 0; i < listReq.size(); i++) {
				datoColumnaEsf[i][0] = listReq.get(i).getNombre();
			}
			for (int j = 0; j < listReq.size(); j++) {
				datoColumnaEsf[j][1] = "" + listEsfuerzo.get(j).getEsfuerzo();
			}
			tabla = new JTable(datoColumna, titColumna) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			///////////////////////////////////////////////////
			//// TABLA ESFUERZO
			///////////////////////////////////////////////////
			
			tablaEsf = new JTable(datoColumnaEsf, titColumnaEsf);
			panelScrollEsf = new JScrollPane(tablaEsf);
			panelScrollEsf.setSize(170, 198);
			panelScrollEsf.setLocation(250, 187);
			getContentPane().add(panelScrollEsf, BorderLayout.CENTER);
			contentPane.add(panelScrollEsf);

		}

	}

	public void quitarCliente() {

		if (tabla.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Seleccione un cliente.", "MENSAJE", JOptionPane.WARNING_MESSAGE);
		} else {
			try {
			 bdproy.quitarClienteProyecto(listCli.get(tabla.getSelectedRow()), cons.proySeleccionado);
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//

			
			

			for (int i = 0; i < listCli.size(); i++) {
				datoColumna[i][0] = "";
			}
			for (int j = 0; j < listCli.size(); j++) {
				datoColumna[j][1] = "";
			}
			try {
				listCli = bdimp.cargarClientesProyecto(consproy.getNombre());
				listPeso = bdimp.cargarPesosProyecto(consproy.getNombre());
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 0; i < listCli.size(); i++) {
				datoColumna[i][0] = listCli.get(i).getNombre();
			}
			for (int j = 0; j < listCli.size(); j++) {
				datoColumna[j][1] = "" + listPeso.get(j).getPeso();
			}
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
			panelScroll.setSize(170, 198);
			panelScroll.setLocation(10, 187);
			getContentPane().add(panelScroll, BorderLayout.CENTER);
			contentPane.add(panelScroll);

			

		}

	}
	///////////////////////////////////////////////////////// NUEVAFUNCIONALIDAD

	private void CargaDatosEsf() {
		try {
			listReq = bdproyreq.cargarRequisitosProyecto(cons.proySeleccionado);
			listEsfuerzo = bdproyreq.cargarEsfuerzo(cons.proySeleccionado);
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

	public void modificarProyecto() {
		try {
			if (!bdproy.comprobarProyecto(ConsultarProyectos.proySeleccionado, txtNombreProyecto.getText())) {
				if (bdproy.modificarProyecto(ConsultarProyectos.proySeleccionado, txtNombreProyecto.getText(),
						tAreaDesc.getText())) {
					ConsultarProyectos.proySeleccionado = txtNombreProyecto.getText();
					JOptionPane.showMessageDialog(null, "El proyecto ha sido modificado" + "", "MENSAJE",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "El proyecto introducido ya existe" + "", "MENSAJE",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
