package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;


import database.BD_Peso;
import database.BD_ProyReq;
import database.BD_Proyectos;
import database.BD_Valor;
import database.Cliente;
import database.Proyecto;
import database.Requisito;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

public class ConsultarCliente extends JFrame {

	private JPanel contentPane;
	public static String procedencia="";
	BD_Proyectos bdproy = new BD_Proyectos();
	BD_Peso bdimp = new BD_Peso();
	
	BD_ProyReq bdproyreq = new BD_ProyReq();
	BD_Valor bdvalor = new BD_Valor();
	private JTextField textFieldDescripcion;
	private List<Proyecto> listProy;
	private List<Requisito> listReq;
	private DefaultListModel modelo;
	private DefaultListModel modelo1;
	private JList listProyectos;
	private JList listRequisitos;
	private JScrollPane scrollLista;
	private JScrollPane scrollLista2;


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
		
				JButton btnAtrs = new JButton("Atrás");
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
				btnAtrs.setBounds(194, 359, 117, 29);
				contentPane.add(btnAtrs);
		
		JLabel lblNombreCliente = new JLabel(ConsultarClientes.cliSeleccionado);
		lblNombreCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreCliente.setBounds(160, 21, 174, 16);
		contentPane.add(lblNombreCliente);

		listProyectos = new JList();
		listProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo = new DefaultListModel();
		scrollLista = new JScrollPane();
		scrollLista.setBounds(10, 99, 170, 240);
	    scrollLista.setViewportView(listProyectos);
		cargarProyectosCliente();
		contentPane.add(scrollLista);
		
		listRequisitos = new JList();
		modelo1 = new DefaultListModel();
		scrollLista2 = new JScrollPane();
		scrollLista2.setBounds(324, 99, 170, 240);
	    scrollLista2.setViewportView(listRequisitos);
		contentPane.add(scrollLista2);

		JLabel lblListaDeProyectos = new JLabel("Lista de proyectos del cliente");
		lblListaDeProyectos.setBounds(10, 60, 217, 16);
		contentPane.add(lblListaDeProyectos);
		

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos del proyecto");
		lblListaDeRequisitos.setBounds(324, 60, 217, 16);
		contentPane.add(lblListaDeRequisitos);
		
		JButton btnVerRequisitos = new JButton("Ver\r\n requisitos");
		btnVerRequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listProyectos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					modelo1.clear();
					listRequisitos.setModel(modelo1);
					cargarRequisitosClienteProyecto(listProyectos.getSelectedValue().toString(),
							ConsultarClientes.cliSeleccionado);
				}
			}
		});
		btnVerRequisitos.setBounds(193, 197, 118, 29);
		contentPane.add(btnVerRequisitos);
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
		setBounds(100, 100, 518, 428);
		setLocationRelativeTo(null);
		setTitle("Consultar Cliente");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void cargarRequisitosClienteProyecto(String proyecto, String cliente) {
		try {
			listReq = bdvalor.cargarRequisitosClienteProyecto(proyecto, cliente);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Requisito r : listReq) {
			modelo1.addElement(r.getNombre());
			listRequisitos.setModel(modelo1);
		}
	}
}
