package clases;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Propietarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;

public class Registrarse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAtrs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrarse frame = new Registrarse();
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
	public Registrarse() {

		inicializar();

		crearComponentes();

	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 223, 169);
		setLocationRelativeTo(null);
		setTitle("Registrarse");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	public void crearComponentes() {
		textField = new JTextField();
		textField.setBounds(41, 33, 130, 26);
		TextPrompt placeholder = new TextPrompt("Usuario", textField);
		placeholder.changeAlpha(0.75f);
		placeholder.changeStyle(Font.ITALIC);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe introducir un nombre de usuario.", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				else {
					BD_Propietarios bd_prop = new BD_Propietarios();
					try {
						if (bd_prop.comprobarPropietario(textField.getText()) == true) // si ya existe..
							JOptionPane.showMessageDialog(null,
									"El nombre de usuario ya existe, por favor, elija otro.", "MENSAJE",
									JOptionPane.WARNING_MESSAGE);
						 else {
							JOptionPane.showMessageDialog(null, "El usuario se ha creado con éxito.", "MENSAJE",
									JOptionPane.WARNING_MESSAGE);

							bd_prop.crearPropietario(textField.getText());
							textField.setText("");
						 }
						 } catch (PersistentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		});
		btnNewButton.setBounds(41, 67, 130, 29);
		contentPane.add(btnNewButton);

		btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarSesion iniciarSesion = new IniciarSesion();
				iniciarSesion.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(6, 108, 65, 29);
		contentPane.add(btnAtrs);
	}
}
