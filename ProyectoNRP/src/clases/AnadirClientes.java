package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.BD_Peso;
import database.BD_Proyectos;
import database.Cliente;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class AnadirClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtImportancia;
	public static String procedencia = "";
	public static String proySeleccionado = "";
	ConsultarProyectos cp = new ConsultarProyectos();

	private DefaultListModel<String> modelo;
	BD_Clientes bdCliente = new BD_Clientes();
	BD_Peso bdimp = new BD_Peso();
	private List<Cliente> listaClientes;
	private JList listClientes;
	public static String cliSeleccionado = "";
	private JScrollPane scrollLista;
	public static String cproySeleccionado = "";
	public static String cprocedencia = "";

	BD_Proyectos bdP = new BD_Proyectos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirClientes frame = new AnadirClientes();
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
	public AnadirClientes() {
		inicializar();

		JLabel lblSeleccionarProyecto = new JLabel("Seleccionar Cliente");
		lblSeleccionarProyecto.setBounds(52, 37, 141, 16);
		contentPane.add(lblSeleccionarProyecto);

		///////////////////////////////////////////////////
		/*
		 * CARGAR CLIENTES DE LA BD AQUI
		 */
		modelo = new DefaultListModel<String>();
		listClientes = new JList();
		listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollLista = new JScrollPane();
		scrollLista.setBounds(52, 65, 141, 226);
		scrollLista.setViewportView(listClientes);

		contentPane.add(scrollLista);
		/////////////////////////////////////////////////////////////
		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// HAY QUE DARLE UNA REVISION A ESTO QUE NO TENGO GNAS DE PENSAR Q ES TARDE
				if (listClientes.isSelectionEmpty() || txtImportancia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe de seleccionar un cliente e introducir su peso",
							"MENSAJE", JOptionPane.WARNING_MESSAGE);
				} else {
					try {

						if (bdimp.comprobarCliente(listClientes.getSelectedValue().toString(),
								ConsultarProyectos.proySeleccionado) == true) {
							JOptionPane.showMessageDialog(null, "El Cliente ya está en el proyecto", "MENSAJE",
									JOptionPane.WARNING_MESSAGE);
						} else {
							String cadena = txtImportancia.getText();

							boolean isDigit = true;
							for (int i = 0; i < cadena.length(); i++) {
								if (Character.isDigit(cadena.charAt(i)) == false) {
									isDigit = false;
									break;
								}
							}

							if (isDigit == false) {
								JOptionPane.showMessageDialog(null, "El peso debe ser un número entre 0 y 5", "MENSAJE",
										JOptionPane.WARNING_MESSAGE);
							} else {
								int importancia = Integer.parseInt(txtImportancia.getText());
								if (importancia < 0 || importancia > 5) {
									JOptionPane.showMessageDialog(null, "El peso debe ser un número entre 0 y 5",
											"MENSAJE", JOptionPane.WARNING_MESSAGE);
								} else {
									bdimp.asignaClienteProyecto(listClientes.getSelectedValue().toString(),
											txtImportancia.getText(), cp.proySeleccionado);
									JOptionPane.showMessageDialog(null, "GOOD JOB, cliente agregado", "MENSAJE",
											JOptionPane.WARNING_MESSAGE);
									AnadirClientes c = new AnadirClientes();
									c.setVisible(true);
									dispose();
									// ModificarProyecto modificarProyecto = new ModificarProyecto();
									// modificarProyecto.setVisible(true);
									// dispose();
								}
							}
						}

					} catch (PersistentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnAgregar.setBounds(106, 303, 117, 26);
		contentPane.add(btnAgregar);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "ConsultarProyecto") {
					ConsultarProyecto consultarProyecto = new ConsultarProyecto();
					consultarProyecto.setVisible(true);
				} else if (procedencia == "ModificarProyecto") {
					ModificarProyecto modificarProyecto = new ModificarProyecto();
					modificarProyecto.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(33, 354, 69, 29);
		contentPane.add(btnAtrs);

		txtImportancia = new JTextField();
		txtImportancia.setBounds(33, 303, 69, 26);
		contentPane.add(txtImportancia);
		txtImportancia.setColumns(10);

		TextPrompt placeholder = new TextPrompt("Peso", txtImportancia);
		placeholder.changeAlpha(0.75f);

		JButton btnCrearCliente = new JButton("Crear Cliente");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("ANADIR: " + cp.proySeleccionado);
				claseEstatica claseE = new claseEstatica();
				claseE.setProcedencia("AnadirClientes");
				claseE.setProySeleccionado(cp.proySeleccionado);
				CrearCliente crearCliente = new CrearCliente();
				crearCliente.procedencia = "AnadirClientes";

				crearCliente.setVisible(true);
				dispose();
			}
		});
		btnCrearCliente.setBounds(106, 354, 117, 29);
		contentPane.add(btnCrearCliente);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 340, 231, 2);
		contentPane.add(separator);
		cargarClientes();
	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 257, 429);
		setLocationRelativeTo(null);
		setTitle("Añadir Clientes");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void cargarClientes() {
		try {
			// Poner clientes que no estan en el proyecto
			listaClientes = bdimp.cargarClientesFueraProyecto(cp.proySeleccionado, claseEstatica.getPropietario());
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Cliente c : listaClientes) {
			modelo.addElement(c.getNombre());
			listClientes.setModel(modelo);
		}
	}
}
