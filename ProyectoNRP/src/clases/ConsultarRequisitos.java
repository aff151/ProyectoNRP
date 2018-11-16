package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Proyectos;
import database.BD_Requisitos;
import database.Cliente;
import database.Proyecto;
import database.Requisito;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultarRequisitos extends JFrame {

	private JPanel contentPane;
	public static String procedencia = "";
	public static String proySeleccionado = "";
	private List<Requisito> listReq;
	private DefaultListModel<String> modelo;
	private JList listProyectos;
	private JScrollPane scrollLista;
	BD_Requisitos bdProy = new BD_Requisitos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarRequisitos frame = new ConsultarRequisitos();
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
	public ConsultarRequisitos() {

		inicializar();

		JLabel lblNewLabel = new JLabel("Seleccionar Requisito");
		lblNewLabel.setBounds(30, 10, 150, 14);
		contentPane.add(lblNewLabel);

		modelo = new DefaultListModel<String>();

		listProyectos = new JList();
		listProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollLista = new JScrollPane();
		scrollLista.setBounds(21, 36, 148, 147);
	    scrollLista.setViewportView(listProyectos);
		contentPane.add(scrollLista);

		JButton btnConsultarProyecto = new JButton("Consultar");
		btnConsultarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (listProyectos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un requisito", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					proySeleccionado = listProyectos.getSelectedValue().toString();
					ConsultarRequisito Consultarrequisito = new ConsultarRequisito();
					ConsultarRequisito.nombrerequisito=proySeleccionado;
					Consultarrequisito.setVisible(true);
					ConsultarRequisito.procedencia = "ConsultarRequisitos";
					
					dispose();
				}

			}
		});
		btnConsultarProyecto.setBounds(83, 198, 87, 23);
		contentPane.add(btnConsultarProyecto);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (procedencia == "menu") {
					Menu menu = new Menu();
					menu.setVisible(true);
				}
				dispose();
			}
		});
		btnAtrs.setBounds(21, 195, 71, 29);
		contentPane.add(btnAtrs);
		cargarRequisitos();
	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 192, 258);
		setLocationRelativeTo(null);
		//setTitle("Consultar Requisitos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void cargarRequisitos() {
		try {
			listReq = bdProy.cargarRequisitos();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Requisito c : listReq) {
			modelo.addElement(c.getNombre());
			listProyectos.setModel(modelo);
		}
	}
}
