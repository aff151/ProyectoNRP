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

public class ConsultarRequisito extends JFrame {

	private JPanel contentPane;

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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaDelRequisito = new JLabel("Consulta del requisito");
		lblConsultaDelRequisito.setBounds(233, 11, 110, 14);
		contentPane.add(lblConsultaDelRequisito);
		
		JList list = new JList();
		list.setBounds(51, 84, 183, 282);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(358, 84, 183, 282);
		contentPane.add(list_1);
		
		JButton btnConsultarProyecto = new JButton("Consultar Proyecto");
		btnConsultarProyecto.setBounds(78, 377, 133, 23);
		contentPane.add(btnConsultarProyecto);
		
		JButton btnConsultarCliente = new JButton("Consultar Cliente");
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConsultarCliente.setBounds(383, 377, 133, 23);
		contentPane.add(btnConsultarCliente);
		
		JLabel lblListaDeProyectos = new JLabel("Lista de Proyectos Asociados");
		lblListaDeProyectos.setBounds(65, 59, 156, 14);
		contentPane.add(lblListaDeProyectos);
		
		JLabel lblListaDeClientes = new JLabel("Lista de Clientes Asociados");
		lblListaDeClientes.setBounds(369, 59, 156, 14);
		contentPane.add(lblListaDeClientes);
	}

}
