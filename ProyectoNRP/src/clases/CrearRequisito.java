package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.BD_Requisitos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class CrearRequisito extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreDelRequisito;
	private JTextField txtPeso;
	private JTextArea descripcion;
	public static String procedencia="";
	BD_Requisitos req = new BD_Requisitos();

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
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarClientes = new JLabel("Seleccionar Clientes");
		lblSeleccionarClientes.setBounds(62, 46, 146, 16);
		contentPane.add(lblSeleccionarClientes);
		
		txtNombreDelRequisito = new JTextField();
		txtNombreDelRequisito.setText("Nombre del requisito");
		txtNombreDelRequisito.setBounds(52, 16, 199, 26);
		contentPane.add(txtNombreDelRequisito);
		txtNombreDelRequisito.setColumns(10);
		
		JList list = new JList();
		list.setBounds(55, 73, 124, 145);
		contentPane.add(list);
		
		txtPeso = new JTextField();
		txtPeso.setText("Peso");
		txtPeso.setColumns(10);
		txtPeso.setBounds(67, 231, 46, 26);
		contentPane.add(txtPeso);
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(119, 231, 117, 29);
		contentPane.add(btnAsignar);
		
		descripcion = new JTextArea();
		descripcion.setBounds(208, 73, 157, 142);
		contentPane.add(descripcion);
		
		JLabel label = new JLabel("Descripción");
		label.setBounds(243, 47, 99, 14);
		contentPane.add(label);
		
		JButton btnCrearRequisitos = new JButton("Crear Requisitos");
		btnCrearRequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				crearRequisito();
			}
		});
		
		btnCrearRequisitos.setBounds(52, 269, 190, 29);
		contentPane.add(btnCrearRequisitos);
		
		JButton button = new JButton("Atrás");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(procedencia=="ConsultarProyecto") {
					ConsultarProyecto consultarProyecto = new ConsultarProyecto();
					consultarProyecto.setVisible(true);
				} else if (procedencia == "ModificarProyecto") {
					ModificarProyecto modificarProyecto = new ModificarProyecto();
					modificarProyecto.setVisible(true);
				}
				dispose();
				}
			
		});
		button.setBounds(218, 310, 190, 29);
		contentPane.add(button);
		
	}
	public void crearRequisito() {
		req.crearRequisito(txtNombreDelRequisito.getText(), descripcion.getText());
	}
}
