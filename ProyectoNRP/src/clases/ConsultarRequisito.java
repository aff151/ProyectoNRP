package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Requisitos;
import database.Requisito;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultarRequisito extends JFrame {

	private JPanel contentPane;
	public static String procedencia = "";
	public static String nombrerequisito = "";
	private JList listRequisitos_1;
	private List<Requisito> listReq;
	private DefaultListModel<String> modelo;
	private JScrollPane scrollLista;
	BD_Requisitos bdReq = new BD_Requisitos();
	private JList listRequisitos;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarRequisito frame = new ConsultarRequisito();
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
	public ConsultarRequisito() {

		inicializar();

		modelo = new DefaultListModel<String>();

		listRequisitos_1 = new JList();
		listRequisitos_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollLista = new JScrollPane();
		scrollLista.setBounds(31, 83, 156, 248);
		scrollLista.setViewportView(listRequisitos_1);
		contentPane.add(scrollLista);
		cargarRequisitos();


		JList list_1 = new JList();
		list_1.setBounds(337, 84, 156, 248);
		contentPane.add(list_1);

		

		JLabel lblListaDeRequisitos = new JLabel("Lista de TODOS los requisitos");
		lblListaDeRequisitos.setBounds(21, 50, 196, 14);
		contentPane.add(lblListaDeRequisitos);

		JLabel lblListaDeProyectos = new JLabel("Lista de Proyectos que lo contienen");
		lblListaDeProyectos.setBounds(294, 50, 231, 14);
		contentPane.add(lblListaDeProyectos);

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
		btnAtrs.setBounds(32, 360, 83, 23);
		contentPane.add(btnAtrs);
		
		JButton btnVerProyectos = new JButton("Ver Proyectos");
		btnVerProyectos.setBounds(197, 190, 130, 23);
		contentPane.add(btnVerProyectos);
		
		
	}
	
	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 531, 422);
		setLocationRelativeTo(null);
		setTitle("Consultar Requisitos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void cargarRequisitos() {
		try {
			listReq = bdReq.cargarRequisitos();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Requisito c : listReq) {
			modelo.addElement(c.getNombre());
			listRequisitos_1.setModel(modelo);
		}
	}
}
