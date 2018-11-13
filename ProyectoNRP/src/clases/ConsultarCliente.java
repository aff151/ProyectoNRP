package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Importancia;
import database.BD_Proyectos;
import database.Cliente;
import database.Proyecto;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class ConsultarCliente extends JFrame {

	private JPanel contentPane;
	public static String procedencia="";
	BD_Proyectos bdproy = new BD_Proyectos();
	BD_Importancia bdimp = new BD_Importancia();
	private JTextField textFieldDescripcion;
	private List<Proyecto> listProy;
	private DefaultListModel modelo;
	private JList listProyectos;



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

		JLabel lblNombreCliente = new JLabel(ConsultarClientes.cliSeleccionado);
		lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCliente.setBounds(196, 21, 174, 16);
		contentPane.add(lblNombreCliente);

		listProyectos = new JList();
		listProyectos.setBounds(43, 135, 170, 240);
		modelo = new DefaultListModel();
		cargarProyectosCliente();
		contentPane.add(listProyectos);
		
		JList listRequisitos = new JList();
		listRequisitos.setBounds(324, 135, 170, 240);
		contentPane.add(listRequisitos);

		JLabel lblListaDeProyectos = new JLabel("Lista de proyectos del cliente");
		lblListaDeProyectos.setBounds(42, 108, 217, 16);
		contentPane.add(lblListaDeProyectos);
		

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos del proyecto");
		lblListaDeRequisitos.setBounds(324, 108, 217, 16);
		contentPane.add(lblListaDeRequisitos);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.setBackground(Color.RED);
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
		btnAtrs.setBounds(197, 386, 157, 29);
		contentPane.add(btnAtrs);
	}
	
	private void cargarProyectosCliente() {
		try {
			listProy = bdimp.cargarProyectosCliente(ConsultarClientes.cliSeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Proyecto p : listProy) {
			modelo.addElement(p.getNombre());
			listProyectos.setModel(modelo);
		}
	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 551, 455);
		setLocationRelativeTo(null);
		setTitle("Consultar Cliente");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
