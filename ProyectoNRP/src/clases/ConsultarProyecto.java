package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Proyectos;
import database.Proyecto;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class ConsultarProyecto extends JFrame {

	private JPanel contentPane;
	public static String procedencia="";
	ConsultarProyectos cons = new ConsultarProyectos();
	BD_Proyectos bdproy = new BD_Proyectos();
	private JTextField textFieldDescripcion;

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
	public ConsultarProyecto() {
		
		inicializar();
		
		Proyecto consproy = null;
		try {
			consproy = descargarInformacion(cons.proySeleccionado);
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblNombreProyecto = new JLabel(consproy.getNombre());
		lblNombreProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreProyecto.setBounds(196, 21, 174, 16);
		contentPane.add(lblNombreProyecto);

		JList listClientes = new JList();
		listClientes.setBounds(43, 135, 170, 240);
		contentPane.add(listClientes);

		JList listRequisitos = new JList();
		listRequisitos.setBounds(324, 135, 170, 240);
		contentPane.add(listRequisitos);

		JLabel lblListaDeClientes = new JLabel("Lista de clientes del proyecto");
		lblListaDeClientes.setBounds(42, 108, 217, 16);
		contentPane.add(lblListaDeClientes);

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos del proyecto");
		lblListaDeRequisitos.setBounds(324, 108, 217, 16);
		contentPane.add(lblListaDeRequisitos);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.setBackground(Color.RED);
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "ConsultarCliente") {
					ConsultarCliente consultarCliente = new ConsultarCliente();
					consultarCliente.setVisible(true);
				} else if (procedencia == "ConsultarProyectos") {
					ConsultarProyectos consultarProyectos = new ConsultarProyectos();
					consultarProyectos.setVisible(true);
				}

				dispose();
			}
		});
		btnAtrs.setBounds(197, 386, 157, 29);
		contentPane.add(btnAtrs);
		
		textFieldDescripcion = new JTextField(consproy.getDescripcion());
		textFieldDescripcion.setBounds(112, 43, 382, 54);
		textFieldDescripcion.setEditable(false);
		contentPane.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(30, 59, 87, 22);
		contentPane.add(lblDescripcin);
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 551, 455);
		setLocationRelativeTo(null);
		setTitle("Consultar Proyecto");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public Proyecto descargarInformacion(String proySeleccionado) throws PersistentException {
		return bdproy.descargarInformacion(proySeleccionado);
	}
}
