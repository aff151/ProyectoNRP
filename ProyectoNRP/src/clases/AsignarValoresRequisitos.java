package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.BD_Peso;
import database.BD_ProyReq;
import database.BD_Proyectos;
import database.BD_Requisitos;
import database.BD_Valor;
import database.Cliente;
import database.ProyReq;
import database.Proyecto;
import database.Requisito;
import database.peso;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class AsignarValoresRequisitos extends JFrame {

	BD_Valor bdValor = new BD_Valor();

	private JPanel contentPane;
	private JTextField textValor;
	protected String procedencia;
	private List<Cliente> listCli;
	private List<Requisito> listReq;
	private JTextArea desctextField;
	private TextPrompt placeholder2;
	BD_Proyectos bdproy = new BD_Proyectos();
	BD_Peso bdimp = new BD_Peso();
	BD_Requisitos bdreq = new BD_Requisitos();

	BD_ProyReq bdproyreq = new BD_ProyReq();

	ConsultarProyectos cons = new ConsultarProyectos();

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
		inicializar();
		
		desctextField = new JTextArea("");
		desctextField.setBounds(415, 83, 117, 107);
		desctextField.setLineWrap(true);
		desctextField.setWrapStyleWord(true);
		desctextField.setEditable(false);
		desctextField.setBackground(getForeground());
		contentPane.add(desctextField);
		
		textValor = new JTextField();
		textValor.setBounds(225, 294, 72, 30);
		textValor.setColumns(10);
		placeholder2 = new TextPrompt("Valor", textValor);
		placeholder2.changeAlpha(0.75f);
		placeholder2.changeStyle(Font.ITALIC);
		contentPane.add(textValor);

		JLabel lblDebeDeAsignar = new JLabel("Selecciona un cliente y un requisito, y añada un valor");
		lblDebeDeAsignar.setBounds(6, 18, 409, 16);
		contentPane.add(lblDebeDeAsignar);

		JLabel lblSeleccionCliente = new JLabel("Selecciona Cliente");
		lblSeleccionCliente.setBounds(34, 56, 116, 16);
		contentPane.add(lblSeleccionCliente);

		JLabel lblSeleccionarRequisito = new JLabel("Seleccionar Requisito");
		lblSeleccionarRequisito.setBounds(254, 56, 128, 16);
		contentPane.add(lblSeleccionarRequisito);
		
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
		tabla.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	JTable tab = (JTable)evt.getSource();
		        if (evt.getClickCount() == 1) {
		    		cargarValor();
		        }
		    }
		});
		// Aquí se configuran algunos de los parámetros que permite
		// variar la JTable
		tabla.setRowSelectionAllowed(true);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Incorporamos la tabla a un panel que incorpora ya una barra
		// de desplazamiento, para que la visibilidad de la tabla sea
		// automática
		panelScroll = new JScrollPane(tabla);
		panelScroll.setSize(170, 198);
		panelScroll.setLocation(10, 83);
		getContentPane().add(panelScroll, BorderLayout.CENTER);
		contentPane.add(panelScroll);
		
		///////////////////////////////////////////////////
		//// TABLA ESFUERZO
		///////////////////////////////////////////////////
		CreaColumnasEsf();
		CargaDatosEsf();
		tablaEsf = new JTable(datoColumnaEsf, titColumnaEsf){
		public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaEsf.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	JTable tab = (JTable)evt.getSource();
		        if (evt.getClickCount() == 1) {
		    		desctextField.setText(listEsfuerzo.get(tab.getSelectedRow()).getRequisito().getDescripcion());
		    		cargarValor();
		        }
		    }
		});
		tablaEsf.setRowSelectionAllowed(true);
		tablaEsf.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelScrollEsf = new JScrollPane(tablaEsf);
		panelScrollEsf.setSize(170, 198);
		panelScrollEsf.setLocation(226, 83);
		getContentPane().add(panelScrollEsf, BorderLayout.CENTER);
		contentPane.add(panelScrollEsf);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (tabla.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Seleccione un cliente.", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					} else if (tablaEsf.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Seleccione un requisito.", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					} else {
						boolean isDigit = true;
						if(textValor.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Introduzca un valor", "MENSAJE",
									JOptionPane.WARNING_MESSAGE);
							isDigit = false;
						}
						for (Character a : textValor.getText().toCharArray()) {
							if (!Character.isDigit(a)) {
								isDigit = false;
								break;
							}

						}
						if (isDigit) {
							int valor = Integer.parseInt(textValor.getText());
							if (valor < 0 || valor > 5) {
								JOptionPane.showMessageDialog(null, "El valor es un número entre 0 y 5.", "MENSAJE",
										JOptionPane.WARNING_MESSAGE);
							} else {
								if (bdValor.modificarValor(cons.proySeleccionado,
										datoColumna[tabla.getSelectedRow()][0],
										datoColumnaEsf[tablaEsf.getSelectedRow()][0], textValor.getText())) {
									JOptionPane.showMessageDialog(null, "Se ha modificado el valor correctamente.",
											"MENSAJE", JOptionPane.WARNING_MESSAGE);
									
								} else {
									bdValor.crearValor(cons.proySeleccionado,
											datoColumna[tabla.getSelectedRow()][0],
											datoColumnaEsf[tablaEsf.getSelectedRow()][0], textValor.getText());
									JOptionPane.showMessageDialog(null, "Se ha creado el valor correctamente.",
											"MENSAJE", JOptionPane.WARNING_MESSAGE);
								}
								
							}
						}
					}
				} catch (HeadlessException | PersistentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGuardar.setBounds(306, 294, 90, 29);
		contentPane.add(btnGuardar);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProyecto modificarProyecto = new ModificarProyecto();
				modificarProyecto.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(16, 293, 72, 29);
		contentPane.add(btnAtrs);
		//cargarClientesProyecto();
		//cargarRequisitosProyecto();
	}

	// CARGAR CLIENTES DEL PROYECTO
	// CARGAR REQUISITOS DEL PROYECTO
	// CARGAR VALOR
	// MODIFICAR VALOR

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 549, 367);
		setLocationRelativeTo(null);
		setTitle("Asignar Valor a Requisito");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
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
			listCli = bdimp.cargarClientesProyecto(ConsultarProyectos.proySeleccionado);
			listPeso = bdimp.cargarPesosProyecto(ConsultarProyectos.proySeleccionado);
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

	public void cargarValor() {
		if(tabla.getSelectedRowCount() == 1 &&
				tablaEsf.getSelectedRowCount() == 1) {
			int v = -1;
			try {
				v = bdValor.cargarValor(ConsultarProyectos.proySeleccionado,
						datoColumna[tabla.getSelectedRow()][0], datoColumnaEsf[tablaEsf.getSelectedRow()][0]);
				if(v == -1) {
					System.out.println("if");
					placeholder2.setText("Valor");
				}
				else {
					System.out.println("no");
					placeholder2.setText(String.valueOf(v));
				}
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
