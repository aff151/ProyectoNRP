package clases;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AsignarProyectos extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignarProyectos frame = new AsignarProyectos();
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
	public AsignarProyectos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 223, 310);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionarProyectos = new JLabel("Seleccionar Proyectos");
		lblSeleccionarProyectos.setBounds(39, 26, 186, 16);
		contentPane.add(lblSeleccionarProyectos);
		
		JList list = new JList();
		list.setBounds(46, 54, 130, 150);
		contentPane.add(list);
		
		txtPeso = new JTextField();
		txtPeso.setText("Peso");
		txtPeso.setBounds(34, 216, 46, 26);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JButton btnNewButton = new JButton("Asignar");
		btnNewButton.setBounds(82, 216, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAsignarProyectos = new JButton("Asignar Proyectos");
		btnAsignarProyectos.setBounds(39, 243, 155, 29);
		contentPane.add(btnAsignarProyectos);
	}

}
