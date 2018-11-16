package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import javax.swing.text.JTextComponent;

public class AnadirRequisitos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreDelRequisito;
	public static String procedencia="";
	public static String proyectoR="";
	BD_Requisitos bd_req = new BD_Requisitos();
	BD_ProyReq bdpr = new BD_ProyReq();
	private JScrollPane scrollLista;
	
	private JList listRequisitos;
	private List<Requisito> listaRequisito;
	private DefaultListModel<String> modelo;
	private JTextField esfuerzoReqV;
	private JButton btnAtrs;
	
	ModificarProyecto cons = new ModificarProyecto();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnadirRequisitos frame = new AnadirRequisitos();
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
	public AnadirRequisitos() {
		
		inicializar();
		
		JLabel lblListaDeRequisitos = new JLabel("Lista de Requisitos");
		lblListaDeRequisitos.setBounds(29, 20, 159, 14);
		contentPane.add(lblListaDeRequisitos);
		modelo = new DefaultListModel<String>();
		//cargarRequisitosExternos();
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//COGER EL PARAMETRO DE LA LISTA
				boolean esDigito = false;
				
				if(listRequisitos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un requisito", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				}
				else if(esfuerzoReqV.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Debe introducir el esfuerzo al requisito", "MENSAJE",
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
					int esfuerzo = Integer.parseInt(esfuerzoReqV.getText());
					if(esfuerzo<0||esfuerzo>10)
						JOptionPane.showMessageDialog(null, "El esfuerzo debe ser un número entre 0 y 10", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					else {
					bdpr.asignarRequisitoProyecto(listRequisitos.getSelectedValue().toString(), proyectoR, esfuerzoReqV.getText());
					ModificarProyecto modificarProyecto = new ModificarProyecto();
					modificarProyecto.setVisible(true);
					dispose();}
					
				} catch (PersistentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnAsignar.setBounds(95, 197, 90, 29);
		contentPane.add(btnAsignar);
		/////////////////////////////////
		esfuerzoReqV = new JTextField();
		esfuerzoReqV.setBounds(16, 200, 86, 20);
		contentPane.add(esfuerzoReqV);
		esfuerzoReqV.setColumns(10);
		
		TextPrompt placeholder = new TextPrompt("Esfuerzo", esfuerzoReqV);
		placeholder.changeAlpha(0.75f);
		placeholder.changeStyle(Font.ITALIC);
		
		btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarProyecto modificarProyecto = new ModificarProyecto();
				modificarProyecto.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(16, 232, 77, 29);
		contentPane.add(btnAtrs);
		
		
		listRequisitos = new JList();
		listRequisitos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelo = new DefaultListModel<String>();
		scrollLista = new JScrollPane();
		scrollLista.setBounds(462, 57, 125, 133);
	    scrollLista.setViewportView(listRequisitos);
		cargarRequisitosExternos();
		contentPane.add(scrollLista);
		
		
		
		//listRequisitos = new JList();
		//listRequisitos.setBounds(39, 56, 121, 129);
		//contentPane.add(listRequisitos);
		//listRequisitos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 751, 289);
		setLocationRelativeTo(null);
		setTitle("Añadir Requisito");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	
	public void cargarRequisitosExternos() {
		try {
			listaRequisito = bd_req.cargarRequisitosOtros(cons.getProyecto());
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

	
	
	/*
	public void cargarRequisitosExternos() {
		try {
			System.out.println("NOMBRE PROYECTOOOO: "+cons.getProyecto());
			listaRequisito = bd_req.cargarRequisitosOtros(cons.getProyecto());
			System.out.println("llega hasta aqui, "+listaRequisito.toString());
			for (Requisito r : listaRequisito) {
				System.out.println(r.getNombre());
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hasta aqui tambien llega");
		for (Requisito r : listaRequisito) {
			System.out.println("ANTESSSSSS req: "+r.getNombre());
			String nombre = r.getNombre();
			System.out.println("Antes modelo.add");
			modelo.addElement(nombre);}
			System.out.println("antes listRequi");
			listRequisitos.setModel(modelo);/////////////////////////////////////FALLOOOO
			System.out.println("termina");
		//}
		System.out.println("finaliza");
	}*/
}
