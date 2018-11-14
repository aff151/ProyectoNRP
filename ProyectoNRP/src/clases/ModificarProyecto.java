package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Importancia;
import database.BD_ProyReq;
import database.BD_Proyectos;
import database.BD_Requisitos;
import database.Cliente;
import database.Proyecto;
import database.Requisito;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

public class ModificarProyecto extends JFrame {

	private JPanel contentPane;
	public static String procedencia="";
	private DefaultListModel modelo;
	private DefaultListModel modelo2;
	BD_Proyectos bdproy = new BD_Proyectos();
	BD_Importancia bdimp = new BD_Importancia();
	BD_Requisitos bdreq = new BD_Requisitos();
	BD_ProyReq bdproyreq = new BD_ProyReq();
	ConsultarProyectos cons = new ConsultarProyectos();
	private JList listClientes;
	private JList listRequisitos;
	Proyecto consproy = null;
	private List<Cliente> listCli;
	private List<Requisito> listReq;
	private TextField txtNombreProyecto;
	private JTextArea tAreaDesc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProyecto frame = new ModificarProyecto();
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
	public ModificarProyecto() {
		
		inicializar();

		try {
			consproy = descargarInformacion(cons.proySeleccionado);
		} catch (PersistentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JSeparator separator = new JSeparator();
		//separator.setForeground(Color.BLACK);
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(10, 146, 406, 2);
		contentPane.add(separator);
		
		txtNombreProyecto = new TextField(consproy.getNombre());
		txtNombreProyecto.setBounds(131, 10, 285, 25);
		contentPane.add(txtNombreProyecto);

		listClientes = new JList();
		listClientes.setBounds(10, 186, 166, 199);
		modelo = new DefaultListModel();
		cargarNombresLista();
		listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(listClientes);

		listRequisitos = new JList();
		listRequisitos.setBounds(250, 186, 166, 199);
		modelo2 = new DefaultListModel();
		cargarRequisitos();
		listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(listRequisitos);

		JLabel lblListaDeClientes = new JLabel("Lista de clientes del proyecto");
		lblListaDeClientes.setBounds(10, 159, 217, 16);
		contentPane.add(lblListaDeClientes);

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos del proyecto");
		lblListaDeRequisitos.setBounds(246, 159, 217, 16);
		contentPane.add(lblListaDeRequisitos);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(procedencia=="ConsultarProyectos") {
				ConsultarProyectos consultarProyectos = new ConsultarProyectos();
				consultarProyectos.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(177, 438, 73, 29);
		contentPane.add(btnAtrs);

		JButton btnAadirMsClientes_1 = new JButton("Añadir más Clientes");
		btnAadirMsClientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnadirClientes anadirClientes = new AnadirClientes();
				anadirClientes.setVisible(true);
				anadirClientes.procedencia="ModificarProyecto";
				dispose();
			}
		});
		btnAadirMsClientes_1.setBounds(10, 396, 166, 29);
		contentPane.add(btnAadirMsClientes_1);

		JButton btnAadirMsRequisitos_1 = new JButton("Añadir más Requisitos");
		btnAadirMsRequisitos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearRequisito crearRequisito = new CrearRequisito();
				crearRequisito.setVisible(true);				
				crearRequisito.procedencia="ModificarProyecto";
				dispose();
			}
		});
		btnAadirMsRequisitos_1.setBounds(250, 396, 166, 29);
		contentPane.add(btnAadirMsRequisitos_1);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setBounds(31, 51, 73, 21);
		contentPane.add(lblDescripcin);
		
		tAreaDesc = new JTextArea(consproy.getDescripcion());
		tAreaDesc.setBounds(131, 49, 285, 66);
		tAreaDesc.setColumns(10);
		tAreaDesc.setLineWrap(true);
		tAreaDesc.setWrapStyleWord(true);
		contentPane.add(tAreaDesc);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(51, 10, 46, 14);
		contentPane.add(lblNombre);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarProyecto();
			}
		});
		btnGuardar.setBounds(10, 115, 89, 23);
		contentPane.add(btnGuardar);

	}
	
	public void inicializar() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 439, 507);
		setLocationRelativeTo(null);
		setTitle("Modificar Proyecto");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public Proyecto descargarInformacion(String proySeleccionado) throws PersistentException {
		return bdproy.descargarInformacion(proySeleccionado);
	}

	private void cargarNombresLista() {
		try {
			listCli = bdimp.cargarClientesProyecto(cons.proySeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Cliente c : listCli) {
			modelo.addElement(c.getNombre());
			listClientes.setModel(modelo);
		}
	}
	
	private void cargarRequisitos() {
		try {
			listReq = bdproyreq.cargarRequisitosProyecto(cons.proySeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Requisito c : listReq) {
			modelo2.addElement(c.getNombre());
			listRequisitos.setModel(modelo2);
		}
	}
	
	public void modificarProyecto() {
		try {
			if(!bdproy.comprobarProyecto(ConsultarProyectos.proySeleccionado, txtNombreProyecto.getText())) {
				if(bdproy.modificarProyecto(ConsultarProyectos.proySeleccionado, txtNombreProyecto.getText(), tAreaDesc.getText())) {
					ConsultarProyectos.proySeleccionado = txtNombreProyecto.getText();
					JOptionPane.showMessageDialog(null, "El proyecto ha sido modificado"
							+ "", "MENSAJE",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "El proyecto introducido ya existe"
						+ "", "MENSAJE",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
