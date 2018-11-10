package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class CrearRequisito extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreDelRequisito;
	private JTextField txtPeso;

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
		setBounds(100, 100, 296, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarClientes = new JLabel("Seleccionar Clientes");
		lblSeleccionarClientes.setBounds(90, 46, 146, 16);
		contentPane.add(lblSeleccionarClientes);
		
		txtNombreDelRequisito = new JTextField();
		txtNombreDelRequisito.setText("Nombre del requisito");
		txtNombreDelRequisito.setBounds(52, 16, 199, 26);
		contentPane.add(txtNombreDelRequisito);
		txtNombreDelRequisito.setColumns(10);
		
		JList list = new JList();
		list.setBounds(90, 74, 124, 145);
		contentPane.add(list);
		
		txtPeso = new JTextField();
		txtPeso.setText("Peso");
		txtPeso.setColumns(10);
		txtPeso.setBounds(67, 231, 46, 26);
		contentPane.add(txtPeso);
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(119, 231, 117, 29);
		contentPane.add(btnAsignar);
		
		JButton btnCrearRequisitos = new JButton("Crear Requisitos");
		btnCrearRequisitos.setBounds(52, 269, 190, 29);
		contentPane.add(btnCrearRequisitos);
	}

}
