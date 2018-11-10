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

public class AnadirClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 739, 522);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarProyecto = new JLabel("Seleccionar Cliente");
		lblSeleccionarProyecto.setBounds(30, 95, 141, 16);
		contentPane.add(lblSeleccionarProyecto);
		
		JList list = new JList();
		list.setBounds(18, 123, 176, 226);
		contentPane.add(list);
		
		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.setBounds(601, 445, 117, 29);
		contentPane.add(btnAgregar);
		
		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.setBounds(26, 445, 117, 29);
		contentPane.add(btnAtrs);
		
		JLabel lblInroduceLaImportancia = new JLabel("Inroduce la importancia para el proyecto");
		lblInroduceLaImportancia.setBounds(362, 143, 263, 16);
		contentPane.add(lblInroduceLaImportancia);
		
		textField = new JTextField();
		textField.setBounds(424, 183, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
