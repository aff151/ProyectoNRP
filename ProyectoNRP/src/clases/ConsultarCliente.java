package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCliente frame = new ConsultarCliente();
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaDelProyecto = new JLabel("Consulta del cliente...");
		lblConsultaDelProyecto.setBounds(31, 43, 174, 16);
		contentPane.add(lblConsultaDelProyecto);
		
		JList list = new JList();
		list.setBounds(68, 154, 124, 199);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(353, 154, 124, 199);
		contentPane.add(list_1);
		
		JLabel lblListaDeClientes = new JLabel("Lista de proyectos asociados");
		lblListaDeClientes.setBounds(31, 126, 217, 16);
		contentPane.add(lblListaDeClientes);
		
		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos asociados");
		lblListaDeRequisitos.setBounds(313, 126, 217, 16);
		contentPane.add(lblListaDeRequisitos);
		
		JButton btnAadirMsClientes = new JButton("Consultar Proyecto");
		btnAadirMsClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConsultarProyecto consultarProyecto = new ConsultarProyecto();
				consultarProyecto.setVisible(true);
				consultarProyecto.procedencia="ConsultarCliente";
				dispose();
			}
		});
		btnAadirMsClientes.setBounds(45, 365, 170, 29);
		contentPane.add(btnAadirMsClientes);
		
		JButton btnAadirMsRequisitos = new JButton("Consultar Requisito");
		btnAadirMsRequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarRequisito consultarRequisito = new ConsultarRequisito();
				consultarRequisito.setVisible(true);
				dispose();
			}
		});
		btnAadirMsRequisitos.setBounds(333, 365, 170, 29);
		contentPane.add(btnAadirMsRequisitos);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarRequisito consultarRequisito = new ConsultarRequisito();
				consultarRequisito.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(482, 429, 77, 29);
		contentPane.add(btnAtrs);
		
		JButton button = new JButton("Añadir más Proyectos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AsignarProyectos asignarProyectos = new AsignarProyectos();
				asignarProyectos.setVisible(true);
				dispose();
			}
		});
		button.setBounds(45, 393, 170, 29);
		contentPane.add(button);
	}
}
