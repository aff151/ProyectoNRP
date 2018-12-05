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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

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
	private JScrollPane scrollLista;
	private JTextArea desctextField;
	

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
		
		desctextField = new JTextArea("");
		desctextField.setBounds(443, 55, 117, 107);
		desctextField.setLineWrap(true);
		desctextField.setWrapStyleWord(true);
		desctextField.setEditable(false);
		desctextField.setBackground(getForeground());
		contentPane.add(desctextField);
		
		txtNombreDelRequisito = new JTextField();
		txtNombreDelRequisito.setBounds(22, 16, 199, 26);
		contentPane.add(txtNombreDelRequisito);
		txtNombreDelRequisito.setColumns(10);
		TextPrompt placeholder = new TextPrompt("Nombre del Requisito", txtNombreDelRequisito);
		placeholder.changeAlpha(0.75f);
		placeholder.changeStyle(Font.ITALIC);

		
		txtAdescripcion = new JTextArea();
		txtAdescripcion.setBounds(27, 53, 190, 93);
		txtAdescripcion.setLineWrap(true);
		txtAdescripcion.setWrapStyleWord(true);
		TextPrompt placeholder1 = new TextPrompt("Descripción", txtAdescripcion);
		placeholder1.setVerticalAlignment(SwingConstants.TOP);
		placeholder1.changeAlpha(0.75f);
		placeholder1.changeStyle(Font.ITALIC);
		
		
		contentPane.add(txtAdescripcion);
		
		JButton btnCrearRequisitos = new JButton("Crear");
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
					JOptionPane.showMessageDialog(null, "Debe introducir el esfuerzo con valores numéricos.", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				}
				else 
				{
					int esfuerzo=Integer.parseInt(esfuerzoReq.getText());
					if(esfuerzo<1||esfuerzo>10) {
						JOptionPane.showMessageDialog(null, "El esfuerzo es un número entre 1 y 10.", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					}
					crearRequisito();
				}
				
			}
		});
		
		btnCrearRequisitos.setBounds(144, 155, 77, 20);
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
		button.setBounds(10, 203, 77, 20);
		contentPane.add(button);

		esfuerzoReq = new JTextField();
		esfuerzoReq.setBounds(75, 155, 59, 21);
		
		esfuerzoReq.setColumns(10);
		TextPrompt placeholder2 = new TextPrompt("Esfuerzo", esfuerzoReq);
		
		placeholder2.changeAlpha(0.75f);
		placeholder2.changeStyle(Font.ITALIC);
		contentPane.add(esfuerzoReq);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(233, 16, 2, 200);
		contentPane.add(separator);
		
		JLabel lblListaDeRequisitos = new JLabel("Lista de Requisitos");
		lblListaDeRequisitos.setBounds(290, 22, 133, 14);
		contentPane.add(lblListaDeRequisitos);
		modelo = new DefaultListModel<String>();
		
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//COGER EL PARAMETRO DE LA LISTA
				boolean esDigito = false;
				if(listRequisitos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un requisito.", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				}
				else if(esfuerzoReqV.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Debe introducir el esfuerzo al requisito.", "MENSAJE",
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
					int esfuerzo=Integer.parseInt(esfuerzoReqV.getText());
					if(esfuerzo<1||esfuerzo>10) {
						JOptionPane.showMessageDialog(null, "El esfuerzo es un número entre 1 y 10.", "MENSAJE",
								JOptionPane.WARNING_MESSAGE);
					}else {
					bdpr.asignarRequisitoProyecto(listRequisitos.getSelectedValue().toString(), cons.proySeleccionado, esfuerzoReqV.getText());
					ModificarProyecto modificarProyecto = new ModificarProyecto();
					modificarProyecto.setVisible(true);
					dispose();
					
					}} catch (PersistentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		
		
		
		/////////////////
		listRequisitos = new JList();
		listRequisitos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listRequisitos.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 1) {
		        	
		    		//desctextField = new JTextField(listaRequisito.get(list.getSelectedIndex()).getDescripcion());

		        	desctextField.setText(listaRequisito.get(list.getSelectedIndex()).getDescripcion());
		        	
		        }
		    }
		});
		scrollLista = new JScrollPane();
		scrollLista.setBounds(286, 46, 121, 129);		
		scrollLista.setViewportView(listRequisitos);
		cargarRequisitosExternos();
		contentPane.add(scrollLista);
		//////////////////
		
		
		
		//listRequisitos.setBounds(286, 46, 121, 129);
		//contentPane.add(listRequisitos);
		
		btnAsignar.setBounds(334, 182, 85, 20);
		contentPane.add(btnAsignar);
		
		esfuerzoReqV = new JTextField();
		esfuerzoReqV.setBounds(272, 182, 59, 21);
TextPrompt placeholder3 = new TextPrompt("Esfuerzo", esfuerzoReqV);
		
		placeholder3.changeAlpha(0.75f);
		placeholder3.changeStyle(Font.ITALIC);
		contentPane.add(esfuerzoReqV);
		esfuerzoReqV.setColumns(10);
		
		JLabel lblDescripcinDe = new JLabel("Descripción");
		lblDescripcinDe.setBounds(433, 22, 106, 14);
		contentPane.add(lblDescripcinDe);
		
		
		
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 590, 263);
		setLocationRelativeTo(null);
		setTitle("Crear Requisito");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	
	public void crearRequisito() {
		try {
			if(txtNombreDelRequisito.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe introducir el nombre del requisito.", "MENSAJE",
						JOptionPane.WARNING_MESSAGE);
			} else if(esfuerzoReq.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Debe introducir el esfuerzo al requisito.", "MENSAJE",
						JOptionPane.WARNING_MESSAGE);
			}
			else {
				
				
				if(bd_req.crearRequisito(txtNombreDelRequisito.getText(), txtAdescripcion.getText())) {
					bdpr.asignarRequisitoProyecto(txtNombreDelRequisito.getText(), cons.proySeleccionado,esfuerzoReq.getText());
					txtNombreDelRequisito.setText("");
					txtAdescripcion.setText("");
					esfuerzoReq.setText("");
					JOptionPane.showMessageDialog(null, "El requisito se ha creado con éxito.", "MENSAJE",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "El requisito introducido ya existe."
							+ "", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void cargarRequisitosExternos() {
		try {
			listaRequisito = bd_req.cargarRequisitosOtros(cons.proySeleccionado);
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
