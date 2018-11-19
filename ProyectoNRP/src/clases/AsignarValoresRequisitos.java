package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.BD_Proyectos;
import database.BD_Requisitos;
import database.BD_Valor;
import database.Cliente;
import database.Requisito;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class AsignarValoresRequisitos extends JFrame {

	BD_Valor bdValor = new BD_Valor();

	private JPanel contentPane;
	private JTextField textValor;
	protected String procedencia;
	// Componentes para listaReq
	private JList listRequisitos;
	private List<Requisito> listaRequisito;
	private DefaultListModel<String> modelReq;
	private JScrollPane scrollLista;
	private JScrollPane scrollLista1;
	BD_Requisitos bd_req = new BD_Requisitos();

	// Componentes para listaClientes
	private JList listClientes;
	private List<Cliente> listaClientes;
	private DefaultListModel<String> modelCli;
	private JScrollPane scrollListaC;
	BD_Proyectos bdProyecto = new BD_Proyectos();

	ConsultarProyectos cons = new ConsultarProyectos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignarValoresRequisitos frame = new AsignarValoresRequisitos();
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
	public AsignarValoresRequisitos() {
		inicializar();

		JLabel lblDebeDeAsignar = new JLabel("Asignar un valor al requisto en relación al cliente");
		lblDebeDeAsignar.setBounds(6, 18, 409, 16);
		contentPane.add(lblDebeDeAsignar);

		JLabel lblSeleccionCliente = new JLabel("Selecciona Cliente");
		lblSeleccionCliente.setBounds(16, 56, 128, 16);
		contentPane.add(lblSeleccionCliente);

		JLabel lblSeleccionarRequisito = new JLabel("Seleccionar Requisito");
		lblSeleccionarRequisito.setBounds(174, 56, 176, 16);
		contentPane.add(lblSeleccionarRequisito);
		/*
		 * LISTA DE REQUISITOS
		 */
		listRequisitos = new JList();
		listRequisitos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollLista = new JScrollPane();
		scrollLista.setBounds(184, 84, 117, 149);
		scrollLista.setViewportView(listRequisitos);
		contentPane.add(scrollLista);

		modelReq = new DefaultListModel<String>();

		/*
		 * LISTA DE CLIENTES
		 */
		listClientes = new JList();
		listClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollLista1 = new JScrollPane();
		scrollLista1.setBounds(16, 84, 117, 149);
		scrollLista1.setViewportView(listClientes);
		contentPane.add(scrollLista1);

		modelCli = new DefaultListModel<String>();

		textValor = new JTextField();
		textValor.setBounds(65, 245, 90, 26);
		textValor.setColumns(10);
		TextPrompt placeholder2 = new TextPrompt("Valor", textValor);
		placeholder2.changeAlpha(0.75f);
		placeholder2.changeStyle(Font.ITALIC);
		contentPane.add(textValor);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (listClientes.isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Seleccione un cliente.", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					} else if (listRequisitos.isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Seleccione un requisito.", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					} else {
						boolean isDigit = true;
						for (Character a : textValor.getText().toCharArray()) {
							if (!Character.isDigit(a)) {
								isDigit = false;
								break;
							}

						}
						if (isDigit) {
							int valor = Integer.parseInt(textValor.getText());
							if (valor < 0 || valor > 5) {
								JOptionPane.showMessageDialog(null, "El valor es un número entre 0 y 5.", "MENSAJE",
										JOptionPane.WARNING_MESSAGE);
							} else {
								if (bdValor.modificarValor(cons.proySeleccionado,
										listClientes.getSelectedValue().toString(),
										listRequisitos.getSelectedValue().toString(), textValor.getText())) {
									JOptionPane.showMessageDialog(null, "Se ha modificado el valor correctamente.",
											"MENSAJE", JOptionPane.WARNING_MESSAGE);
									
								} else {
									bdValor.crearValor(cons.proySeleccionado,
											listClientes.getSelectedValue().toString(),
											listRequisitos.getSelectedValue().toString(), textValor.getText());
									JOptionPane.showMessageDialog(null, "Se ha creado el valor correctamente.",
											"MENSAJE", JOptionPane.WARNING_MESSAGE);
								}
								dispose();
							}
						}
					}
				} catch (HeadlessException | PersistentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ModificarProyecto mp = new ModificarProyecto();
				mp.setVisible(true);
				

			}
		});
		btnGuardar.setBounds(218, 279, 90, 29);
		contentPane.add(btnGuardar);

		JButton btnCargardatos = new JButton("Cargar");
		btnCargardatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCargardatos.setBounds(167, 245, 72, 29);
		contentPane.add(btnCargardatos);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProyecto modificarProyecto = new ModificarProyecto();
				modificarProyecto.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(6, 279, 72, 29);
		contentPane.add(btnAtrs);
		cargarClientesProyecto();
		cargarRequisitosProyecto();
	}

	// CARGAR CLIENTES DEL PROYECTO
	// CARGAR REQUISITOS DEL PROYECTO
	// CARGAR VALOR
	// MODIFICAR VALOR

	public void cargarClientesProyecto() {
		try {
			listaClientes = bdProyecto.cargarClientesProyecto(cons.proySeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Cliente c : listaClientes) {
			modelCli.addElement(c.getNombre());
			listClientes.setModel(modelCli);
		}

	}
public void inicializar() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
	setResizable(false);
	setBounds(100, 100, 336, 334);
	setLocationRelativeTo(null);
	setTitle("Asignar Valor a Requisito");
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
}
	public void cargarRequisitosProyecto() {
		try {
			listaRequisito = bd_req.cargarRequisitosProyecto(cons.proySeleccionado);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Requisito r : listaRequisito) {
			String nombre = r.getNombre();
			modelReq.addElement(r.getNombre());
			listRequisitos.setModel(modelReq);
		}
	}
}
