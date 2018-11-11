package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarProyecto extends JFrame {

	private JPanel contentPane;
	public static String procedencia="";
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
		
		JLabel lblNombreProyecto = new JLabel(ConsultarProyectos.proySeleccionado);
		lblNombreProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreProyecto.setBounds(171, 43, 174, 16);
		contentPane.add(lblNombreProyecto);

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
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(procedencia=="ConsultarProyectos") {
				ConsultarProyectos consultarProyectos = new ConsultarProyectos();
				consultarProyectos.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(491, 443, 77, 29);
		contentPane.add(btnAtrs);

		JButton btnAadirMsClientes_1 = new JButton("Añadir más Clientes");
		btnAadirMsClientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnadirClientes anadirClientes = new AnadirClientes();
				anadirClientes.setVisible(true);
				anadirClientes.procedencia="ModificarProyecto";
				dispose();
			}
		});
		btnAadirMsClientes_1.setBounds(45, 391, 170, 29);
		contentPane.add(btnAadirMsClientes_1);

		JButton btnAadirMsRequisitos_1 = new JButton("Añadir más Requisitos");
		btnAadirMsRequisitos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearRequisito crearRequisito = new CrearRequisito();
				crearRequisito.setVisible(true);				
				crearRequisito.procedencia="ModificarProyecto";
				dispose();
			}
		});
		btnAadirMsRequisitos_1.setBounds(333, 391, 170, 29);
		contentPane.add(btnAadirMsRequisitos_1);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(Interfaz.class.getResource("/imagenes/fondo.png")));
				lblNewLabel.setBounds(0, 0, 600, 500);
				contentPane.add(lblNewLabel);

	}
}
