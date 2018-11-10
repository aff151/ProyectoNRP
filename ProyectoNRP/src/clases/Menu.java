package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton crearCliente = new JButton("Crear Cliente");
		crearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente crearcliente = new CrearCliente();
				crearcliente.setVisible(true);
				dispose();
			}
		});
		crearCliente.setBounds(175, 129, 220, 29);
		contentPane.add(crearCliente);
		
		JButton consultarClientes = new JButton("Consultar Clientes");
		consultarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarClientes consultarclientes = new ConsultarClientes();
				consultarclientes.setVisible(true);
				dispose();
			}
		});
		consultarClientes.setBounds(175, 181, 220, 29);
		contentPane.add(consultarClientes);
		
		JButton crearProyecto = new JButton("Crear Proyecto");
		crearProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearProyecto crearproyecto = new CrearProyecto();
				crearproyecto.setVisible(true);				
				dispose();
			}
		});
		
		crearProyecto.setBounds(175, 236, 220, 29);
		contentPane.add(crearProyecto);
		
		JButton consultarProyectos = new JButton("Consultar Proyectos");
		consultarProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProyectos consultarproyectos = new ConsultarProyectos();
				consultarproyectos.setVisible(true);
				consultarproyectos.procedencia="menu";
				dispose();
			}
		});
		consultarProyectos.setBounds(175, 290, 220, 29);
		contentPane.add(consultarProyectos);
		
		JLabel lblInicioDeLa = new JLabel("Inicio de la Aplicación");
		lblInicioDeLa.setBounds(221, 71, 139, 16);
		contentPane.add(lblInicioDeLa);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/imagenes/fondo.png")));
		lblNewLabel.setBounds(0, 0, 600, 500);
		contentPane.add(lblNewLabel);
	}
}
