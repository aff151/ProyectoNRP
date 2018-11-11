package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Proyectos;
import database.Cliente;
import database.Proyecto;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultarProyectos extends JFrame {

	private JPanel contentPane;
	public static String procedencia="";
	public static String proySeleccionado = "";
	private List<Proyecto> listPro;
	private DefaultListModel<String> modelo;
	private JList listProyectos;

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
		
		JLabel lblNewLabel = new JLabel("Seleccionar Proyecto");
		lblNewLabel.setBounds(30, 10, 150, 14);
		contentPane.add(lblNewLabel);
		
		modelo = new DefaultListModel<String>();
		
		listProyectos = new JList();
		listProyectos.setBounds(30, 36, 125, 147);
		
		contentPane.add(listProyectos);
		
		JButton btnConsultarProyecto = new JButton("Consultar Proyecto");
		btnConsultarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proySeleccionado = listProyectos.getSelectedValue().toString();
				ConsultarProyecto consultarproyecto = new ConsultarProyecto();
				consultarproyecto.setVisible(true);
				ConsultarProyecto.procedencia="ConsultarProyectos";
				dispose();
			}
		});
		btnConsultarProyecto.setBounds(19, 195, 150, 23);
		contentPane.add(btnConsultarProyecto);
		
		JButton btnModificarProyecto = new JButton("Modificar Proyecto");
		btnModificarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proySeleccionado = listProyectos.getSelectedValue().toString();
				ModificarProyecto modificarProyecto = new ModificarProyecto();
				modificarProyecto.setVisible(true);
				modificarProyecto.procedencia="ConsultarProyectos";
				dispose();
			}
		});
		btnModificarProyecto.setBounds(19, 220, 147, 23);
		contentPane.add(btnModificarProyecto);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(procedencia=="menu") {
				Menu menu = new Menu();
				menu.setVisible(true);
				}else if(procedencia=="ConsultarProyecto"){
					ConsultarProyecto consultarProyecto = new ConsultarProyecto();
					consultarProyecto.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(56, 255, 71, 29);
		contentPane.add(btnAtrs);
		cargarProyectos();
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 192, 316);
		setLocationRelativeTo(null);
		//setTitle("Programa para gestión de requisitos");
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
		for(Proyecto c : listPro) {
			modelo.addElement(c.getNombre());
			listProyectos.setModel(modelo);
		}
	}
}
