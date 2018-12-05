package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PlanificacionManual extends JFrame {

	private JPanel contentPane;
	private JTable tablaRes;
	private JTable tablaSel;
	private JButton btnDer;
	private JButton btnIzq;
	private JButton btnAtras;
	private JTextField textlimite;
	private static int limite;
	private JButton btnReiniciar;
	private JLabel lblEsfuerzo;
	private JLabel lbLimite;
	private JButton calcularM;
	private JLabel lblTablaRes;
	private JLabel lblTablaSel;
	private JLabel lblTablaProd;
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
					PlanificacionManual frame = new PlanificacionManual();
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
	public PlanificacionManual() {
		inicializar();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 232, 317);
		contentPane.add(scrollPane);
		
		Object [][] obj = new Object[Planificacion.listReqSat.size()][3];
		for(int i = 0; i < Planificacion.listReqSat.size(); i++) {
			obj[i][0] = Planificacion.listReqSat.get(i).getNombre();
			obj[i][1] = Planificacion.listReqSat.get(i).getSatisfaccion();
			obj[i][2] = Planificacion.listReqSat.get(i).getEsfuerzo();
		}
		//
		tablaRes = new JTable();
		tablaRes.setModel(new DefaultTableModel(obj,
			new String[] {
				"Requisito", "Satisfaccion", "Esfuerzo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaRes.getColumnModel().getColumn(0).setPreferredWidth(98);
		tablaRes.getColumnModel().getColumn(1).setPreferredWidth(67);
		tablaRes.getColumnModel().getColumn(2).setPreferredWidth(52);
		scrollPane.setViewportView(tablaRes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(373, 78, 232, 317);
		contentPane.add(scrollPane_1);
		
		tablaSel = new JTable();
		tablaSel.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Requisito", "Satisfaccion", "Esfuerzo"
			}
		) {
			Class[] columnTypes1 = new Class[] {
				String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes1[columnIndex];
			}
			boolean[] columnEditables1 = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables1[column];
			}
		});
		tablaSel.getColumnModel().getColumn(0).setPreferredWidth(98);
		tablaSel.getColumnModel().getColumn(1).setPreferredWidth(67);
		tablaSel.getColumnModel().getColumn(2).setPreferredWidth(52);
		scrollPane_1.setViewportView(tablaSel);
		
		btnDer = new JButton(">");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablaRes.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un "
							+ "requisito de la tabla de satisfaccion de requisitos", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					DefaultTableModel modelo = (DefaultTableModel)tablaRes.getModel();
					DefaultTableModel modelo1 = (DefaultTableModel)tablaSel.getModel();
					String nombre = (String) modelo.getValueAt(tablaRes.getSelectedRow(), 0);
					for (RequisitoSat rs : Planificacion.listReqSat) {
						if(rs.getNombre().equals(nombre)) {
							if(limite - rs.getEsfuerzo() < 0) {
								JOptionPane.showMessageDialog(null, "Ha superado el límite de esfuerzo", "MENSAJE",
										JOptionPane.WARNING_MESSAGE);
							} else {
								modelo1.addRow(new Object[] {
										rs.getNombre(),
										rs.getSatisfaccion(),
										rs.getEsfuerzo(),
								});
								limite -= rs.getEsfuerzo();
								lbLimite.setText(String.valueOf(limite));
								modelo.removeRow(tablaRes.getSelectedRow());
							}
						}
					}
					
				}
				}

		});
		btnDer.setBounds(263, 215, 89, 23);
		contentPane.add(btnDer);
		
		btnIzq = new JButton("<");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablaSel.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un "
							+ "requisito de la tabla de requisitos seleccionados", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					DefaultTableModel modelo = (DefaultTableModel)tablaRes.getModel();
					DefaultTableModel modelo1 = (DefaultTableModel)tablaSel.getModel();
					String nombre = (String) modelo1.getValueAt(tablaSel.getSelectedRow(), 0);
					for (RequisitoSat rs : Planificacion.listReqSat) {
						if(rs.getNombre().equals(nombre)) {
							modelo.addRow(new Object[] {
									rs.getNombre(),
									rs.getSatisfaccion(),
									rs.getEsfuerzo(),
							});
							limite += rs.getEsfuerzo();
							lbLimite.setText(String.valueOf(limite));
						}
						
					}
					modelo1.removeRow(tablaSel.getSelectedRow());
				}
			}
		});
		btnIzq.setBounds(263, 269, 89, 23);
		contentPane.add(btnIzq);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planificacion pl = new Planificacion();
				pl.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(10, 439, 89, 23);
		contentPane.add(btnAtras);
		
		JLabel labelproy = new JLabel(ConsultarProyectosPlanificacion.proySeleccionado);
		labelproy.setBounds(240, 11, 148, 14);
		contentPane.add(labelproy);
		
		textlimite = new JTextField();
		textlimite.setBounds(20, 20, 53, 20);
		contentPane.add(textlimite);
		textlimite.setColumns(10);
		
		JButton btnIntroLimite = new JButton("Introducir límite");
		btnIntroLimite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 650, 502);
				setLocationRelativeTo(null);
				limite = Integer.parseInt(textlimite.getText());
				lbLimite.setText(textlimite.getText());
				scrollPane.setVisible(true);
				scrollPane_1.setVisible(true);
				labelproy.setVisible(true);
				lblEsfuerzo.setVisible(true);
				lbLimite.setVisible(true);
				btnIzq.setVisible(true);
				btnDer.setVisible(true);
				calcularM.setVisible(true);
				btnReiniciar.setVisible(true);
				btnIntroLimite.setVisible(false);
				textlimite.setVisible(false);
				lblTablaRes.setVisible(true);
				lblTablaSel.setVisible(true);
			}
		});
		btnIntroLimite.setBounds(80, 20, 140, 19);
		contentPane.add(btnIntroLimite);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlanificacionManual plmanual = new PlanificacionManual();
				plmanual.setVisible(true);
				dispose();
			}
		});
		btnReiniciar.setBounds(263, 372, 89, 23);
		contentPane.add(btnReiniciar);
		
		lblEsfuerzo = new JLabel("Esfuerzo restante: ");
		lblEsfuerzo.setBounds(187, 42, 110, 14);
		contentPane.add(lblEsfuerzo);
		
		lbLimite = new JLabel("");
		lbLimite.setBounds(314, 42, 46, 14);
		contentPane.add(lbLimite);
		
		calcularM = new JButton("Calcular métricas");
		calcularM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularProductividad();
				crearTablaProductividad();
			}
		});
		calcularM.setBounds(465, 439, 140, 23);
		contentPane.add(calcularM);
		
		lblTablaRes = new JLabel("Tabla de satisfaccion de requisitos");
		lblTablaRes.setBounds(26, 60, 200, 14);
		contentPane.add(lblTablaRes);
		
		lblTablaSel = new JLabel("Tabla de requisitos seleccionados");
		lblTablaSel.setBounds(393, 60, 200, 14);
		contentPane.add(lblTablaSel);
		
		lblTablaProd = new JLabel("Productividad de los requisitos");
		lblTablaProd.setBounds(675, 60, 200, 14);
		contentPane.add(lblTablaProd);
		
		labelproy.setVisible(false);
		scrollPane.setVisible(false);
		scrollPane_1.setVisible(false);
		lblEsfuerzo.setVisible(false);
		lbLimite.setVisible(false);
		btnIzq.setVisible(false);
		btnDer.setVisible(false);
		calcularM.setVisible(false);
		btnReiniciar.setVisible(false);
		lblTablaRes.setVisible(false);
		lblTablaSel.setVisible(false);
		lblTablaProd.setVisible(false);
	}
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 250, 90);
		setLocationRelativeTo(null);
		setTitle("Planificacion Manual");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void calcularProductividad() {
		DefaultTableModel modelo = (DefaultTableModel)tablaSel.getModel();
		int satisfaccionTotal = 0, esfuerzoTotal = 0;
		arrayProd = new double[modelo.getRowCount()];
		arrayTabProd = new Object[modelo.getRowCount()+1][2];
		for(int i = 0; i < modelo.getRowCount(); i++) {
			for(int j = 0; j < Planificacion.listReqSat.size(); j++) {
				if(Planificacion.listReqSat.get(j).getNombre().equals
						((String)modelo.getValueAt(i, 0))){
					//Productividad(de cada requisito) = satisfaccion/esfuerzo
					arrayProd[i] = ((double)Planificacion.listReqSat.get(j).getSatisfaccion()/
							(double)Planificacion.listReqSat.get(j).getEsfuerzo()); 
					arrayTabProd[i][0] = (String)modelo.getValueAt(i, 0);
					arrayTabProd[i][1] = arrayProd[i];
					satisfaccionTotal += Planificacion.listReqSat.get(j).getSatisfaccion();
					esfuerzoTotal += Planificacion.listReqSat.get(j).getEsfuerzo();
				}
			}
		}
		arrayTabProd[modelo.getRowCount()][0] = "pro(S) = sat(S)/eff(S)";
		arrayTabProd[modelo.getRowCount()][1] = (double)satisfaccionTotal/esfuerzoTotal;
	}
	public void crearTablaProductividad() {
		lblTablaProd.setVisible(true);
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
		scrollPane_2.setBounds(670, 78, 205, 317);
		contentPane.add(scrollPane_2);
		tablaProd.getColumnModel().getColumn(0).setPreferredWidth(110);
		tablaProd.getColumnModel().getColumn(1).setPreferredWidth(77);
		scrollPane_2.setViewportView(tablaProd);
		
		setBounds(100, 100, 900, 502);
		setLocationRelativeTo(null);
	}
}
