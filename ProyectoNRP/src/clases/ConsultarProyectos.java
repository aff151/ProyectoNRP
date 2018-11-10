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

public class ConsultarProyectos extends JFrame {

	private JPanel contentPane;
	public static String procedencia="";
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
		setBounds(100, 100, 192, 316);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Proyecto");
		lblNewLabel.setBounds(30, 10, 150, 14);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(30, 36, 125, 147);
		contentPane.add(list);
		
		JButton btnConsultarProyecto = new JButton("Consultar Proyecto");
		btnConsultarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProyecto consultarproyecto = new ConsultarProyecto();
				consultarproyecto.setVisible(true);
				ConsultarProyecto.procedencia="ConsultarProyectos";
				dispose();
			}
		});
		btnConsultarProyecto.setBounds(19, 195, 150, 23);
		contentPane.add(btnConsultarProyecto);
		
		JButton btnModificarProyecto = new JButton("Modificar Proyecto");
		btnModificarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProyecto modificarProyecto = new ModificarProyecto();
				modificarProyecto.setVisible(true);
				dispose();
			}
		});
		btnModificarProyecto.setBounds(19, 220, 147, 23);
		contentPane.add(btnModificarProyecto);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(procedencia=="menu") {
				Menu menu = new Menu();
				menu.setVisible(true);
				}else if(procedencia=="ConsultarProyecto"){
					ConsultarProyecto consultarProyecto = new ConsultarProyecto();
					consultarProyecto.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(56, 255, 71, 29);
		contentPane.add(btnAtrs);
	}
}
