package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.BD_ProyReq;
import database.BD_Requisitos;
import database.Cliente;
import database.Requisito;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class CrearRequisito extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreDelRequisito;
	private JTextArea txtAdescripcion;
	public static String procedencia = "";
	BD_Requisitos bd_req = new BD_Requisitos();
	BD_ProyReq bdpr = new BD_ProyReq();
	ConsultarProyectos cons = new ConsultarProyectos();

	private JTextField esfuerzoReq;
	private List<Requisito> listaRequisito;
	private DefaultListModel<String> modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearRequisito frame = new CrearRequisito();
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
	public CrearRequisito() {
		inicializar();

		txtNombreDelRequisito = new JTextField();
		txtNombreDelRequisito.setBounds(22, 16, 199, 26);
		contentPane.add(txtNombreDelRequisito);
		txtNombreDelRequisito.setColumns(10);
		TextPrompt placeholder = new TextPrompt("Nombre del Requisito", txtNombreDelRequisito);
		placeholder.changeAlpha(0.75f);
		placeholder.changeStyle(Font.ITALIC);

		txtAdescripcion = new JTextArea();
		txtAdescripcion.setBounds(26, 53, 190, 93);
		txtAdescripcion.setLineWrap(true);
		txtAdescripcion.setWrapStyleWord(true);
		TextPrompt placeholder1 = new TextPrompt("Descripción", txtAdescripcion);
		placeholder1.setVerticalAlignment(SwingConstants.TOP);
		placeholder1.changeAlpha(0.75f);
		placeholder1.changeStyle(Font.ITALIC);

		contentPane.add(txtAdescripcion);

		JButton btnCrearRequisitos = new JButton("Crear");
		btnCrearRequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadena = esfuerzoReq.getText();

				boolean esDigito = false;
				for (Character s : cadena.toCharArray()) {
					if (Character.isDigit(s))
						esDigito = true;
				}
				if (esDigito == false) {
					JOptionPane.showMessageDialog(null, "El esfuerzo es un número entre 0 y 10", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					int esfuerzo = Integer.parseInt(cadena);
					if (esfuerzo < 0 || esfuerzo > 10)
						JOptionPane.showMessageDialog(null, "El esfuerzo es un número entre 0 y 10", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					else
						crearRequisito();
				}

			}
		});

		btnCrearRequisitos.setBounds(120, 158, 77, 29);
		contentPane.add(btnCrearRequisitos);

		JButton button = new JButton("Atrás");
		button.addActionListener(new ActionListener() {
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
		button.setBounds(22, 193, 77, 29);
		contentPane.add(button);

		esfuerzoReq = new JTextField();
		esfuerzoReq.setBounds(22, 160, 86, 20);
		TextPrompt placeholder2 = new TextPrompt("Esfuerzo", esfuerzoReq);
		placeholder2.changeAlpha(0.75f);
		placeholder2.changeStyle(Font.ITALIC);
		contentPane.add(esfuerzoReq);
		esfuerzoReq.setColumns(10);

		modelo = new DefaultListModel<String>();

	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 253, 263);
		setLocationRelativeTo(null);
		setTitle("Crear Requisito");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	public void crearRequisito() {
		try {
			if (txtNombreDelRequisito.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe introducir el nombre del requisito", "MENSAJE",
						JOptionPane.WARNING_MESSAGE);
			} else if (esfuerzoReq.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe introducir el essfuerzo al requisito", "MENSAJE",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (bd_req.crearRequisito(txtNombreDelRequisito.getText(), txtAdescripcion.getText())) {
					bdpr.asignarRequisitoProyecto(txtNombreDelRequisito.getText(), cons.proySeleccionado,
							esfuerzoReq.getText());
					txtNombreDelRequisito.setText("");
					txtAdescripcion.setText("");
					esfuerzoReq.setText("");
					JOptionPane.showMessageDialog(null, "El requisito se ha creado con éxito", "MENSAJE",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "El requisito introducido ya existe" + "", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
