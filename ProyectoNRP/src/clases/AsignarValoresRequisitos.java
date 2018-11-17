package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AsignarValoresRequisitos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	//	inicializar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDebeDeAsignar = new JLabel("Debe de asignar un valor al requisto en relación al cliente");
		lblDebeDeAsignar.setBounds(22, 6, 409, 16);
		contentPane.add(lblDebeDeAsignar);
		
		JLabel lblSeleccionCliente = new JLabel("Selecciona Cliente");
		lblSeleccionCliente.setBounds(16, 56, 128, 16);
		contentPane.add(lblSeleccionCliente);
		
		JLabel lblSeleccionarRequisito = new JLabel("Seleccionar Requisito");
		lblSeleccionarRequisito.setBounds(174, 56, 176, 16);
		contentPane.add(lblSeleccionarRequisito);
		
		JList listRequisitos = new JList();
		listRequisitos.setBounds(184, 84, 117, 149);
		contentPane.add(listRequisitos);
		
		JList listClientes = new JList();
		listClientes.setBounds(16, 84, 117, 149);
		contentPane.add(listClientes);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(356, 106, 61, 16);
		contentPane.add(lblValor);
		
		textField = new JTextField();
		textField.setBounds(313, 138, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(327, 232, 117, 29);
		contentPane.add(btnGuardar);
		
		JButton btnCargardatos = new JButton("Cargar");
		btnCargardatos.setBounds(371, 161, 72, 29);
		contentPane.add(btnCargardatos);
	}
	
	//CARGAR CLIENTES DEL PROYECTO
	//CARGAR REQUISITOS DEL PROYECTO
	//CARGAR VALOR
	//MODIFICAR VALOR
	
	public void cargarClientesProyecto()
	{
		
	}

}
