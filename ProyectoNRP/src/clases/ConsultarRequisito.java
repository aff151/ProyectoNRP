package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

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

import database.BD_Clientes;
import database.BD_ProyReq;
import database.BD_Requisitos;
import database.BD_Valor;
import database.Cliente;
import database.ProyReq;
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
import java.awt.event.ActionEvent;

public class ConsultarRequisito extends JFrame {
//
	private JPanel contentPane;
	public static String procedencia = "";
	public static String nombrerequisito = "";
	private JList listRequisitos_1;
	private List<Requisito> listReq;
	private DefaultListModel<String> modelo;
	private JScrollPane scrollLista;
	BD_Requisitos bdReq = new BD_Requisitos();
	BD_ProyReq bdpr = new BD_ProyReq();
	BD_Valor bdvalor = new BD_Valor();
	BD_Clientes bdcli = new BD_Clientes();
	private JList listRequisitos;
	private String reqselec = "";
	private JLabel lblNewLabel;
	String PSelect = "";
	////////////////////////////////////////
	// TABLA REQUISITOS
	///////////////////////////////////////
	private JTable tablaReq;
	private JScrollPane panelScrollReq;
	private String datoColumnaReq[][];
	private List<Valor> listValor;
	private List<Cliente> listCliente;
	
	//
	private JTable tablaPro;
	private JScrollPane panelScrollPro;
	private String datoColumnaPro[][];
	private List<ProyReq> listProy;
	private List<ProyReq> listEsf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarRequisito frame = new ConsultarRequisito();
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
	public ConsultarRequisito() {

		inicializar();

		modelo = new DefaultListModel<String>();

		listRequisitos_1 = new JList();
		listRequisitos_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollLista = new JScrollPane();
		scrollLista.setBounds(31, 83, 156, 248);
		scrollLista.setViewportView(listRequisitos_1);
		contentPane.add(scrollLista);
		cargarRequisitos();
		listRequisitos_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 1) {
					if (listRequisitos_1.isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un requisito", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					} else {

						reqselec = (String) listRequisitos_1.getSelectedValue();
						CargaDatosPro();
						creaTablaPro();
					}

				}
			}
		});

		JLabel lblListaDeRequisitos = new JLabel("Selecciona uno de tus Proyectos");
		lblListaDeRequisitos.setBounds(21, 50, 196, 14);
		contentPane.add(lblListaDeRequisitos);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "menu") {
					Menu menu = new Menu();
					menu.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(249, 359, 83, 23);
		contentPane.add(btnAtrs);

		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(213, 63, 177, 14);
		contentPane.add(lblNewLabel);

		JButton btnEliminarrequisito = new JButton("EliminarRequisito");
		btnEliminarrequisito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarRequisito();
			}

		});
		btnEliminarrequisito.setBounds(31, 359, 156, 23);
		contentPane.add(btnEliminarrequisito);

	}
	
	void tablaRequisitos() {

		tablaReq = new JTable();
		tablaReq.setModel(new DefaultTableModel(datoColumnaReq,
			new String[] {
				"Cliente", "Valor"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
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
		panelScrollReq = new JScrollPane();
		panelScrollReq.setBounds(400, 82, 180, 250);
		contentPane.add(panelScrollReq);
		tablaReq.getColumnModel().getColumn(0).setPreferredWidth(90);
		tablaReq.getColumnModel().getColumn(1).setPreferredWidth(70);
		panelScrollReq.setViewportView(tablaReq);
		
	
	}

	public void CargaDatosReq() {
		//Cargar clientes que tengan un valor en ese proyecto para ese requisito y su valor.
		try {
			listCliente = bdcli.cargarClientesProyectosRequisito(reqselec, PSelect);
			listValor = bdcli.cargarValorClienteProyectoRequisito(reqselec, PSelect);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datoColumnaReq = new String[listCliente.size()][2];

		for (int i = 0; i < listCliente.size(); i++) {
			datoColumnaReq[i][0] = listCliente.get(i).getNombre();
		}
		for (int j = 0; j < listCliente.size(); j++) {
			datoColumnaReq[j][1] = "" + listValor.get(j).getValor();
		}
	}
	
	private void eliminarRequisito() {
		// TODO Auto-generated method stub
		if (listRequisitos_1.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un requisito", "MENSAJE",
					JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				bdvalor.eliminarRequisitoCR(listRequisitos_1.getSelectedValue().toString(), claseEstatica.getPropietario());
				ConsultarRequisito con = new ConsultarRequisito();
				con.setVisible(true);
				dispose();
			} catch (PersistentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 602, 422);
		setLocationRelativeTo(null);
		setTitle("Consultar Requisitos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void CargaDatosPro() {
		try {
			listProy = bdpr.cargarProyectosRequisito(reqselec);
			listEsf = bdpr.cargarEsfuerzoRequisito(reqselec);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datoColumnaPro = new String[listProy.size()][2];

		for (int i = 0; i < listProy.size(); i++) {
			datoColumnaPro[i][0] = listProy.get(i).getProyecto().getNombre();
		}
		for (int j = 0; j < listProy.size(); j++) {
			datoColumnaPro[j][1] = "" + listEsf.get(j).getEsfuerzo();
		}
		
	}

	public void creaTablaPro() {
		tablaPro = new JTable();
		tablaPro.setModel(new DefaultTableModel(datoColumnaPro,
			new String[] {
				"Proyecto", "Esfuerzo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
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
		panelScrollPro = new JScrollPane();
		panelScrollPro.setBounds(213, 84, 156, 248);
		contentPane.add(panelScrollPro);
		//tablaPro.setRowSelectionAllowed(true);
		//tablaPro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaPro.getColumnModel().getColumn(0).setPreferredWidth(90);
		tablaPro.getColumnModel().getColumn(1).setPreferredWidth(70);
		panelScrollPro.setViewportView(tablaPro);
		tablaPro.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable list = (JTable) evt.getSource();
				if (evt.getClickCount() == 1) {
					
						CargaDatosReq();
						tablaRequisitos();
					

				}
			}
		});
	}

	public void cargarRequisitos() {
		try {
			listReq = bdReq.cargarRequisitos(claseEstatica.getPropietario());
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Requisito c : listReq) {
			modelo.addElement(c.getNombre());
			listRequisitos_1.setModel(modelo);
		}
	}
}
