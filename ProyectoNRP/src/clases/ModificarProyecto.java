package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarProyecto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarProyecto frame = new ModificarProyecto();
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
	public ModificarProyecto() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Interfaz.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBackground(new Color(204, 0, 0));
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setBounds(487, 450, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblConsultaDelProyecto = new JLabel("Modificación del proyecto...");
		lblConsultaDelProyecto.setBounds(31, 40, 184, 16);
		contentPane.add(lblConsultaDelProyecto);

		JList list = new JList();
		list.setBounds(68, 154, 124, 199);
		contentPane.add(list);

		JList list_1 = new JList();
		list_1.setBounds(353, 154, 124, 199);
		contentPane.add(list_1);

		JLabel lblListaDeClientes = new JLabel("Lista de clientes del proyecto");
		lblListaDeClientes.setBounds(31, 126, 217, 16);
		contentPane.add(lblListaDeClientes);

		JLabel lblListaDeRequisitos = new JLabel("Lista de requisitos del proyecto");
		lblListaDeRequisitos.setBounds(313, 126, 217, 16);
		contentPane.add(lblListaDeRequisitos);

		JButton btnAadirMsClientes = new JButton("Eliminar Clientes");
		btnAadirMsClientes.setBounds(45, 365, 170, 29);
		contentPane.add(btnAadirMsClientes);

		JButton btnAadirMsRequisitos = new JButton("Eliminar Requisitos");
		btnAadirMsRequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAadirMsRequisitos.setBounds(333, 365, 170, 29);
		contentPane.add(btnAadirMsRequisitos);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.setBounds(389, 447, 77, 29);
		contentPane.add(btnAtrs);

		JButton btnAadirMsClientes_1 = new JButton("Añadir más Clientes");
		btnAadirMsClientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAadirMsClientes_1.setBounds(45, 391, 170, 29);
		contentPane.add(btnAadirMsClientes_1);

		JButton btnAadirMsRequisitos_1 = new JButton("Añadir más Requisitos");
		btnAadirMsRequisitos_1.setBounds(333, 391, 170, 29);
		contentPane.add(btnAadirMsRequisitos_1);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(Interfaz.class.getResource("/imagenes/fondo.png")));
				lblNewLabel.setBounds(0, 0, 600, 500);
				contentPane.add(lblNewLabel);

	}
}
