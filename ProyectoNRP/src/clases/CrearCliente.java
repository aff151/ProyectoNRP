package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearCliente extends JFrame {

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
		
		JLabel lblNewLabel = new JLabel("Seleccionar Proyecto");
		lblNewLabel.setBounds(52, 93, 160, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblIntroduceElPeso = new JLabel("Introduce la importancia  al cliente para el proyecto");
		lblIntroduceElPeso.setBounds(353, 131, 334, 67);
		contentPane.add(lblIntroduceElPeso);
		
		textField = new JTextField();
		textField.setBounds(438, 198, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Crear Cliente");
		btnNewButton.setBounds(633, 469, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atrás");
		btnNewButton_1.setBounds(6, 469, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblIntroduceElNombre = new JLabel("Introduce el nombre del nuevo cliente");
		lblIntroduceElNombre.setBounds(35, 23, 246, 16);
		contentPane.add(lblIntroduceElNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(332, 18, 320, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
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
