package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnadirClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtImportancia;
	public static String procedencia = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirClientes frame = new AnadirClientes();
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
	public AnadirClientes() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 236, 398);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSeleccionarProyecto = new JLabel("Seleccionar Cliente");
		lblSeleccionarProyecto.setBounds(52, 37, 141, 16);
		contentPane.add(lblSeleccionarProyecto);

		JList list = new JList();
		list.setBounds(52, 65, 141, 226);
		contentPane.add(list);

		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.setBounds(119, 303, 86, 29);
		contentPane.add(btnAgregar);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "ConsultarProyecto") {
					ConsultarProyecto consultarProyecto = new ConsultarProyecto();
					consultarProyecto.setVisible(true);
				} else if (procedencia == "ModificarProyecto") {
					ModificarProyecto modificarProyecto = new ModificarProyecto();
					modificarProyecto.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(137, 340, 62, 29);
		contentPane.add(btnAtrs);

		txtImportancia = new JTextField();
		txtImportancia.setText("Importancia");
		txtImportancia.setBounds(33, 303, 86, 26);
		contentPane.add(txtImportancia);
		txtImportancia.setColumns(10);
	}

}
