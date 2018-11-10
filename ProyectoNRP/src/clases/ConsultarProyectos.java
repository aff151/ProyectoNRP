package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class ConsultarProyectos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarProyectos frame = new ConsultarProyectos();
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
	public ConsultarProyectos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Proyecto");
		lblNewLabel.setBounds(155, 11, 106, 14);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(87, 36, 245, 137);
		contentPane.add(list);
		
		JButton btnConsultarProyecto = new JButton("Consultar Proyecto");
		btnConsultarProyecto.setBounds(155, 184, 125, 23);
		contentPane.add(btnConsultarProyecto);
		
		JButton btnModificarProyecto = new JButton("Modificar Proyecto");
		btnModificarProyecto.setBounds(155, 214, 125, 23);
		contentPane.add(btnModificarProyecto);
	}
}
