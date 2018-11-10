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
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarClientes extends JFrame {
	public static String procedencia="";
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
		
		inicializar();
		
		JLabel seleccionarClientes = new JLabel("Seleccionar Clientes");
		seleccionarClientes.setBounds(49, 30, 127, 16);
		contentPane.add(seleccionarClientes);
		
		JList list = new JList();
		list.setBounds(34, 60, 143, 146);
		contentPane.add(list);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConsultarCliente consultarCliente = new ConsultarCliente();
				consultarCliente.setVisible(true);
				consultarCliente.procedencia="ConsultarClientes";
				dispose();
			}
		});
		btnConsultar.setBackground(new Color(50, 205, 50));
		btnConsultar.setBounds(46, 217, 117, 29);
		contentPane.add(btnConsultar);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(46, 257, 117, 29);
		contentPane.add(btnAtrs);
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 219, 326);
		setLocationRelativeTo(null);
		//setTitle("Programa para gestión de requisitos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
