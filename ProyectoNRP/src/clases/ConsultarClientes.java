package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class ConsultarClientes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarClientes frame = new ConsultarClientes();
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
	public ConsultarClientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 187, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel seleccionarClientes = new JLabel("Seleccionar Clientes");
		seleccionarClientes.setBounds(32, 6, 440, 16);
		contentPane.add(seleccionarClientes);
		
		JList list = new JList();
		list.setBounds(32, 35, 124, 146);
		contentPane.add(list);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(SystemColor.textHighlight);
		btnConsultar.setBounds(32, 193, 117, 29);
		contentPane.add(btnConsultar);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.setBounds(32, 228, 117, 29);
		contentPane.add(btnAtrs);
	}
}
