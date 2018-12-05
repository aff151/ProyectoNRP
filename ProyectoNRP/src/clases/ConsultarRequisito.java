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
import java.util.ArrayList;
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
	String PSelect = "";
	private ArrayList<Valor> listValora;
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
	private JButton button;

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
		scrollLista.setBounds(10, 85, 156, 248);
		scrollLista.setViewportView(listRequisitos_1);
		contentPane.add(scrollLista);
		cargarRequisitos();

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

		JButton btnEliminarrequisito = new JButton("EliminarRequisito");
		btnEliminarrequisito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarRequisito();
			}

		});
		btnEliminarrequisito.setBounds(31, 359, 156, 23);
		contentPane.add(btnEliminarrequisito);

		button = new JButton(">");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (listRequisitos_1.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un requisito", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {

					reqselec = (String) listRequisitos_1.getSelectedValue();
					CargaDatosPro();
					creaTablaPro();
				}

			}
		});
		button.setBounds(165, 194, 41, 23);
		contentPane.add(button);

	}

	private void eliminarRequisito() {
		// TODO Auto-generated method stub
		if (listRequisitos_1.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un requisito", "MENSAJE",
					JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				bdvalor.eliminarRequisitoCR(listRequisitos_1.getSelectedValue().toString(),
						claseEstatica.getPropietario());
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
			listValora = new ArrayList<Valor>();
			listValora = bdvalor.cargarDatosTabla(reqselec);
			//listProy = bdpr.cargarProyectosRequisito(reqselec);
			listEsf = bdpr.cargarEsfuerzoRequisito(reqselec);
			//listCliente = bdcli.cargarClientesProyectosRequisito(reqselec, PSelect);
			//listValor = bdcli.cargarValorClienteProyectoRequisito(reqselec, PSelect);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		datoColumnaPro = new String[listValora.size()][4];
		
		for(int i = 0; i < listValora.size(); i++) {
			datoColumnaPro[i][0] = listValora.get(i).getProyecto().getNombre();
			datoColumnaPro[i][2] = listValora.get(i).getCliente().getNombre();
			datoColumnaPro[i][3] = "" + listValora.get(i).getValor();
			for(int j = 0; j < listEsf.size(); j++) {
				if(listEsf.get(j).getProyecto().equals(listValora.get(i).getProyecto())) {
					datoColumnaPro[i][1] = "" + listEsf.get(j).getEsfuerzo();
				}
			}
		}

	}

	public void creaTablaPro() {
		tablaPro = new JTable();
		tablaPro.setModel(
				new DefaultTableModel(datoColumnaPro, new String[] { "Proyecto", "Esfuerzo", "Cliente", "Valor" }) {
					Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}

					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		panelScrollPro = new JScrollPane();
		panelScrollPro.setBounds(213, 84, 350, 248);
		contentPane.add(panelScrollPro);
		tablaPro.setRowSelectionAllowed(true);
		tablaPro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaPro.getColumnModel().getColumn(0).setPreferredWidth(90);
		tablaPro.getColumnModel().getColumn(1).setPreferredWidth(70);
		panelScrollPro.setViewportView(tablaPro);
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
