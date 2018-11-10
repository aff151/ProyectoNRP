package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CrearCliente extends JFrame {

	private JPanel contentPane;
	private JTextField importanciaCliente;
	private JTextField nombreTexttField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente frame = new CrearCliente();
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
	public CrearCliente() {
		
		 setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIrAMenu = new JButton("Ir a menu ");
		btnIrAMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnIrAMenu.setBounds(204, 254, 107, 23);
		contentPane.add(btnIrAMenu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Interfaz.class.getResource("/imagenes/fondo.png")));
		lblNewLabel.setBounds(0, 0, 600, 500);
		contentPane.add(lblNewLabel);

	//--------------------------------------------------------------------------------------------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBackground(Color.WHITE);
		list.setBounds(35, 121, 189, 226);
		contentPane.add(list);
		
		JLabel lblNewLabel1 = new JLabel("Seleccionar Proyecto");
		lblNewLabel1.setBounds(52, 93, 160, 16);
		contentPane.add(lblNewLabel1);
		
		JLabel lblIntroduceElPeso = new JLabel("Introduce la importancia  al cliente para el proyecto");
		lblIntroduceElPeso.setBounds(353, 131, 334, 67);
		contentPane.add(lblIntroduceElPeso);
		
		importanciaCliente = new JTextField();
		importanciaCliente.setBounds(438, 198, 130, 26);
		contentPane.add(importanciaCliente);
		importanciaCliente.setColumns(10);
		
		JButton crearClienteBoton = new JButton("Crear Cliente");
		crearClienteBoton.setBounds(633, 469, 117, 29);
		contentPane.add(crearClienteBoton);

		/////////////////////////////////////
		crearClienteBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//IR A LA BBDD PARA METER AL CLIENTE
				String nombreCliente = nombreTexttField.getText();
				
				
			}
		});
		
		//////////////////////////////

		
		
		JButton volverInicio = new JButton("Atrás");
		volverInicio.setBounds(6, 469, 117, 29);
		contentPane.add(volverInicio);
		
		volverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu m = new Menu();
				m.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblIntroduceElNombre = new JLabel("Introduce el nombre del nuevo cliente");
		lblIntroduceElNombre.setBounds(35, 23, 246, 16);
		contentPane.add(lblIntroduceElNombre);
		
		nombreTexttField = new JTextField();
		nombreTexttField.setBounds(332, 18, 320, 26);
		contentPane.add(nombreTexttField);
		nombreTexttField.setColumns(10);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	

}

