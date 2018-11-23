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

public class IniciarSesion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
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
	public IniciarSesion() {
		
		inicializar();
		
		crearComponentes();
		
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 223, 184);
		setLocationRelativeTo(null);
		setTitle("Iniciar Sesión");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	
	public void crearComponentes() {
		
		textField = new JTextField();
		textField.setBounds(44, 50, 130, 26);
		TextPrompt placeholder = new TextPrompt("Usuario", textField);
		placeholder.changeAlpha(0.75f);
		placeholder.changeStyle(Font.ITALIC);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(67, 19, 77, 16);
		contentPane.add(lblBienvenido);
		
		JButton btnNewButton = new JButton("Iniciar Sesión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Debe introducir un nombre de usuario.", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				else {
					String nombreUsuario=textField.getText();
					BD_Propietarios bd=new BD_Propietarios();
					try {
						if(bd.comprobarPropietario(nombreUsuario)==false) 						
							JOptionPane.showMessageDialog(null, "El usuario no existe.", "MENSAJE",
									JOptionPane.WARNING_MESSAGE);
						else {
							claseEstatica.setPropietario(nombreUsuario);
							Menu menu=new Menu();
							menu.setVisible(true);
							dispose();
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (PersistentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setBounds(44, 81, 130, 29);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Registrarse");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrarse registrarse = new Registrarse();
				registrarse.setVisible(true);
				dispose();
			}
		});
		button.setBounds(54, 122, 103, 29);
		contentPane.add(button);
		
		
		
		
	}
}
