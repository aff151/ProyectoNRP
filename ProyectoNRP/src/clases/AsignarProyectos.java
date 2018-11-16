package clases;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AsignarProyectos extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeso;
	public static String procedencia="";
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
		
		inicializar();
		
		JLabel lblSeleccionarProyectos = new JLabel("Seleccionar Proyectos");
		lblSeleccionarProyectos.setBounds(39, 26, 186, 16);
		contentPane.add(lblSeleccionarProyectos);
		
		JList list = new JList();
		list.setBounds(46, 54, 130, 150);
		contentPane.add(list);
		
		txtPeso = new JTextField();
		txtPeso.setText("Peso");
		txtPeso.setBounds(34, 216, 66, 26);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JButton btnAsignarProyectos = new JButton("Asignar");
		btnAsignarProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAsignarProyectos.setBounds(102, 216, 75, 29);
		contentPane.add(btnAsignarProyectos);
		
		JButton button = new JButton("Atrás");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarCliente consultarCliente = new ConsultarCliente();
				consultarCliente.setVisible(true);				
				dispose();
			}
		});
		button.setBounds(39, 243, 69, 29);
		contentPane.add(button);
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 223, 307);
		setLocationRelativeTo(null);
		setTitle("Asignar Proyectos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

}
