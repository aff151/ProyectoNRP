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

public class ConsultarProyectos extends JFrame {

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
					ConsultarProyectos frame = new ConsultarProyectos();
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
	public ConsultarProyectos() {

		inicializar();

		cargarJlist();

	}

	private void cargarJlist() {
		// TODO Auto-generated method stub
		//if (Menu.proc == "Modificar") {
		if (Menu.proc == "Consultar") {
			setTitle("Consultar Proyectos");
			listProyectos = new JList();
			listProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollLista = new JScrollPane();
			scrollLista.setBounds(10, 36, 179, 147);
			scrollLista.setViewportView(listProyectos);
			contentPane.add(scrollLista);
			modelo = new DefaultListModel<String>();

			JButton btnConsultarProyecto = new JButton("Consultar");
			btnConsultarProyecto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (listProyectos.isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					} else {
						proySeleccionado = listProyectos.getSelectedValue().toString();
						ConsultarProyecto consultarproyecto = new ConsultarProyecto();
						consultarproyecto.setVisible(true);
						ConsultarProyecto.procedencia = "ConsultarProyectos";
						dispose();
					}

				}
			});
			btnConsultarProyecto.setBounds(10, 195, 170, 23);
			contentPane.add(btnConsultarProyecto);
			cargarProyectos();
		}
		//Menu.proc
		if (Menu.proc == "Modificar") {
			setTitle("Modificar Proyectos Propios");
			listProyectos = new JList();
			listProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollLista = new JScrollPane();
			scrollLista.setBounds(10, 36, 179, 147);
			scrollLista.setViewportView(listProyectos);
			contentPane.add(scrollLista);
			modelo = new DefaultListModel<String>();
			// CARGAR LOS PROYECTOS QUE ESE ADMIN SEA PROPIETARIO (NUEVO METODO)
			// OJO CON LA VARIABLE ESTÁTICA DE LA CLASE MODIFICAR PROYECTO "PROCEDENCIA" POR
			// QUE AHORA HE PUESTO NUEVA LA PROCEDENCIA A MODIFICARPROYECTOS
			// CREAR UN NUEVO JLIST CON LOS PROYECTOSPROPIOS Y REALIZAR SIMILAR A LO QUE
			// ESTÁ COMENTADO Y AL CASO DE ARRIBA
			JButton btnModificarProyecto = new JButton("Modificar");
			btnModificarProyecto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (listProyectos.isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					} else {
						proySeleccionado = listProyectos.getSelectedValue().toString();
						ModificarProyecto modificarProyecto = new ModificarProyecto();
						modificarProyecto.setVisible(true);
						modificarProyecto.procedencia = "modificarProyectos";
						dispose();
					}
				}
			});
			btnModificarProyecto.setBounds(10, 195, 170, 23);
			contentPane.add(btnModificarProyecto);
			cargarProyectos();
		}

	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 204, 288);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Seleccionar Proyecto");
		lblNewLabel.setBounds(33, 10, 150, 14);
		contentPane.add(lblNewLabel);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "menuModificar" || procedencia == "menuConsultar") {
					Menu menu = new Menu();
					menu.setVisible(true);
				} else if (procedencia == "ConsultarProyecto") {
					ConsultarProyecto consultarProyecto = new ConsultarProyecto();
					consultarProyecto.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(64, 228, 71, 23);
		contentPane.add(btnAtrs);
	}

	public void cargarProyectos() {
		try {
			//Meter un carar proyectos propio
			listPro = bdProy.cargarProyectosPropios(claseEstatica.getPropietario());
		//	listPro = bdProy.cargarProyectos();
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
