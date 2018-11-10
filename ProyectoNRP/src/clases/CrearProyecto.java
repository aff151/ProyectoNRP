package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CrearProyecto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProyecto frame = new CrearProyecto();
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
	public CrearProyecto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAtras = new JButton("Atrás");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(473, 460, 117, 29);
		contentPane.add(btnAtras);
		
		JButton btnCrearProyecto = new JButton("Crear Proyecto");
		btnCrearProyecto.setBounds(256, 370, 133, 29);
		contentPane.add(btnCrearProyecto);
		
		textField_1 = new JTextField();
		textField_1.setBounds(270, 18, 167, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIntrodProyecto = new JLabel("Introduce el nombre del nuevo proyecto");
		lblIntrodProyecto.setBounds(35, 23, 246, 16);
		contentPane.add(lblIntrodProyecto);
		
		JList list = new JList();
		list.setBackground(Color.WHITE);
		list.setBounds(35, 121, 189, 226);
		contentPane.add(list);
		
		JLabel lblIntrodImport = new JLabel("Introduce la importancia del cliente para el proyecto");
		lblIntrodImport.setBounds(256, 135, 334, 67);
		contentPane.add(lblIntrodImport);
		
		textField = new JTextField();
		textField.setBounds(342, 195, 80, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSelecCliente = new JLabel("Seleccionar Cliente");
		lblSelecCliente.setBounds(52, 93, 160, 16);
		contentPane.add(lblSelecCliente);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(CrearProyecto.class.getResource("/imagenes/fondo.png")));
		lblFondo.setBounds(0, 0, 600, 500);
		contentPane.add(lblFondo);
	}
}
