package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Clientes;
import database.BD_ProyReq;
import database.BD_Requisitos;
import database.Cliente;
import database.Requisito;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class CrearRequisito extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreDelRequisito;
	private JTextArea txtAdescripcion;
	public static String procedencia="";
	BD_Requisitos bd_req = new BD_Requisitos();
	BD_ProyReq bdpr = new BD_ProyReq();
	ConsultarProyectos cons = new ConsultarProyectos();
	
	private JTextField esfuerzoReq;
	private JList listRequisitos;
	private List<Requisito> listaRequisito;
	private DefaultListModel<String> modelo;
	private JTextField esfuerzoReqV;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearRequisito frame = new CrearRequisito();
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
	public CrearRequisito() {
		inicializar();
		
		txtNombreDelRequisito = new JTextField();
		txtNombreDelRequisito.setBounds(52, 16, 199, 26);
		contentPane.add(txtNombreDelRequisito);
		txtNombreDelRequisito.setColumns(10);
		TextPrompt placeholder = new TextPrompt("Nombre del Requisito", txtNombreDelRequisito);
		placeholder.changeAlpha(0.75f);
		placeholder.changeStyle(Font.ITALIC);

		
		txtAdescripcion = new JTextArea();
		txtAdescripcion.setBounds(80, 53, 174, 93);
		txtAdescripcion.setLineWrap(true);
		txtAdescripcion.setWrapStyleWord(true);

		contentPane.add(txtAdescripcion);
		
		JLabel label = new JLabel("Descripción");
		label.setBounds(10, 53, 99, 14);
		contentPane.add(label);
		
		JButton btnCrearRequisitos = new JButton("Crear Requisito");
		btnCrearRequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadena = esfuerzoReq.getText();
				
				boolean esDigito = false;
				for(Character s : cadena.toCharArray())
				{
					if(Character.isDigit(s))
						esDigito = true;
				}
				if(esDigito == false)
				{
					JOptionPane.showMessageDialog(null, "Debe introducir el esfuerzo con valores numericos", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				}
				else 
				{
					crearRequisito();
				}
				
			}
		});
		
		btnCrearRequisitos.setBounds(266, 180, 139, 29);
		contentPane.add(btnCrearRequisitos);
		
		JButton button = new JButton("Atrás");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(procedencia=="ConsultarProyecto") {
					ConsultarProyecto consultarProyecto = new ConsultarProyecto();
					consultarProyecto.setVisible(true);
				} else if (procedencia == "ModificarProyecto") {
					ModificarProyecto modificarProyecto = new ModificarProyecto();
					modificarProyecto.setVisible(true);
				}
				dispose();
				}
			
		});
		button.setBounds(10, 180, 125, 29);
		contentPane.add(button);
		
		JLabel lblIntroduceElEsfuerzo = new JLabel("Introduce el esfuerzo");
		lblIntroduceElEsfuerzo.setBounds(285, 85, 149, 14);
		contentPane.add(lblIntroduceElEsfuerzo);

		esfuerzoReq = new JTextField();
		esfuerzoReq.setBounds(295, 110, 86, 20);
		contentPane.add(esfuerzoReq);
		esfuerzoReq.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(444, 16, 50, 200);
		contentPane.add(separator);
		
		JLabel lblListaDeRequisitos = new JLabel("Lista de Requisitos");
		lblListaDeRequisitos.setBounds(504, 22, 108, 14);
		contentPane.add(lblListaDeRequisitos);
		
		listRequisitos = new JList();
		listRequisitos.setBounds(462, 57, 125, 133);
		listRequisitos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo = new DefaultListModel<String>();
		cargarRequisitos();
		contentPane.add(listRequisitos);
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//COGER EL PARAMETRO DE LA LISTA
				boolean esDigito = false;
				if(esfuerzoReqV.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Debe introducir el essfuerzo al requisito", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					for(Character s : esfuerzoReqV.getText().toCharArray())
					{
						if(Character.isDigit(s))
							esDigito = true;
					}
				}
				if(esDigito)
				{
				try {
					bdpr.asignarRequisitoProyecto(listRequisitos.getSelectedValue().toString(), cons.proySeleccionado, esfuerzoReqV.getText());
				} catch (PersistentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnAsignar.setBounds(655, 183, 90, 29);
		contentPane.add(btnAsignar);
		
		JLabel lblIntroduceEsfuerzo = new JLabel("Introduce esfuerzo");
		lblIntroduceEsfuerzo.setBounds(615, 58, 130, 14);
		contentPane.add(lblIntroduceEsfuerzo);
		
		esfuerzoReqV = new JTextField();
		esfuerzoReqV.setBounds(625, 82, 86, 20);
		contentPane.add(esfuerzoReqV);
		esfuerzoReqV.setColumns(10);
		
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 760, 263);
		setLocationRelativeTo(null);
		setTitle("Programa para gestión de requisitos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	
	public void crearRequisito() {
		try {
			if(txtNombreDelRequisito.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe introducir el nombre del requisito", "MENSAJE",
						JOptionPane.WARNING_MESSAGE);
			} else if(esfuerzoReq.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Debe introducir el essfuerzo al requisito", "MENSAJE",
						JOptionPane.WARNING_MESSAGE);
			}
			else {
				if(bd_req.crearRequisito(txtNombreDelRequisito.getText(), txtAdescripcion.getText())) {
					bdpr.asignarRequisitoProyecto(txtNombreDelRequisito.getText(), cons.proySeleccionado,esfuerzoReq.getText());
					txtNombreDelRequisito.setText("");
					txtAdescripcion.setText("");
					esfuerzoReq.setText("");
					JOptionPane.showMessageDialog(null, "El requisito se ha creado con éxito", "MENSAJE",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "El requisito introducido ya existe"
							+ "", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cargarRequisitos() {
		try {
			listaRequisito = bd_req.cargarRequisitos();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Requisito r : listaRequisito) {
			String nombre = r.getNombre();
			modelo.addElement(nombre);
			listRequisitos.setModel(modelo);
		}
	}
}
