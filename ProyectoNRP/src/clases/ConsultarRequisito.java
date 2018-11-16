package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarRequisito extends JFrame {

	private JPanel contentPane;
	public static String procedencia = "";
	public static String nombrerequisito = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarRequisito frame = new ConsultarRequisito();
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
	public ConsultarRequisito() {

		inicializar();

		JList list = new JList();
		list.setBounds(61, 84, 156, 216);
		contentPane.add(list);

		JList list_1 = new JList();
		list_1.setBounds(304, 84, 143, 216);
		contentPane.add(list_1);

		JButton btnConsultarProyecto = new JButton("Consultar Proyecto");
		btnConsultarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProyecto consultarProyecto = new ConsultarProyecto();
				consultarProyecto.setVisible(true);
				consultarProyecto.procedencia = "ConsultarRequisito";
				dispose();
			}
		});
		btnConsultarProyecto.setBounds(61, 318, 156, 23);
		contentPane.add(btnConsultarProyecto);

		JButton btnConsultarCliente = new JButton("Consultar Cliente");
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultarCliente consultarCliente = new ConsultarCliente();
				consultarCliente.setVisible(true);
				consultarCliente.procedencia = "ConsultarRequisito";
				dispose();
			}
		});
		btnConsultarCliente.setBounds(314, 318, 133, 23);
		contentPane.add(btnConsultarCliente);

		JLabel lblListaDeProyectos = new JLabel("Lista de Proyectos Asociados");
		lblListaDeProyectos.setBounds(52, 50, 196, 14);
		contentPane.add(lblListaDeProyectos);

		JLabel lblListaDeClientes = new JLabel("Lista de Clientes Asociados");
		lblListaDeClientes.setBounds(294, 50, 189, 14);
		contentPane.add(lblListaDeClientes);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "ConsultarCliente") {
					ConsultarCliente consultarCliente = new ConsultarCliente();
					consultarCliente.setVisible(true);
				}else if(procedencia=="ConsultarRequisitos") {
					ConsultarRequisitos ConsultarRequisito = new ConsultarRequisitos();
					ConsultarRequisito.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(32, 360, 83, 23);
		contentPane.add(btnAtrs);
		
		JLabel lblNombreRequisito = new JLabel(ConsultarRequisitos.proySeleccionado);
		lblNombreRequisito.setBounds(198, 17, 189, 14);
		contentPane.add(lblNombreRequisito);
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 531, 422);
		setLocationRelativeTo(null);
		setTitle("Consultar Requisito");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
