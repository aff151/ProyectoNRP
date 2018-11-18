package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Proyectos;
import database.Cliente;
import database.Proyecto;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultarProyectosPlanificacion extends JFrame {

	private JPanel contentPane;
	public static String procedencia = "";
	public static String proySeleccionado = "";
	private List<Proyecto> listPro;
	private DefaultListModel<String> modelo;
	private JList listProyectos;
	private JScrollPane scrollLista;
	BD_Proyectos bdProy = new BD_Proyectos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarProyectosPlanificacion frame = new ConsultarProyectosPlanificacion();
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
	public ConsultarProyectosPlanificacion() {

		inicializar();

		JLabel lblNewLabel = new JLabel("Seleccionar Proyecto");
		lblNewLabel.setBounds(33, 10, 150, 14);
		contentPane.add(lblNewLabel);

		modelo = new DefaultListModel<String>();

		listProyectos = new JList();
		listProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollLista = new JScrollPane();
		scrollLista.setBounds(10, 36, 179, 147);
	    scrollLista.setViewportView(listProyectos);
		contentPane.add(scrollLista);

		JButton btnPlanificarProyecto = new JButton("Planificar");
		btnPlanificarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (listProyectos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					proySeleccionado = listProyectos.getSelectedValue().toString();
					Planificacion consultarproyecto = new Planificacion();
					consultarproyecto.setVisible(true);
					Planificacion.procedencia = "ConsultarProyectos";
					dispose();
				}

			}
		});
		btnPlanificarProyecto.setBounds(46, 194, 108, 23);
		contentPane.add(btnPlanificarProyecto);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(64, 228, 71, 23);
		contentPane.add(btnAtrs);
		cargarProyectos();
	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 204, 288);
		setLocationRelativeTo(null);
		//setTitle("Consultar Proyectos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void cargarProyectos() {
		try {
			listPro = bdProy.cargarProyectos();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Proyecto c : listPro) {
			modelo.addElement(c.getNombre());
			listProyectos.setModel(modelo);
		}
	}
}
