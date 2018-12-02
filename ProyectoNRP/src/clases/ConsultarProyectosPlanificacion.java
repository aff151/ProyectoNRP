package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.border.EmptyBorder;

import org.orm.PersistentException;

import database.BD_Proyectos;
import database.Cliente;
import database.Proyecto;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultarProyectosPlanificacion extends JFrame {

	private JPanel contentPane;
	public static String procedencia = "";
	public static String proySeleccionado = "";
	private List<Proyecto> listPro;
	private DefaultListModel<String> modelo;
	private JList listProyectos;
	private JScrollPane scrollLista;
	//private JTextField desctextField;
	private JTextArea desctextField;
	BD_Proyectos bdProy = new BD_Proyectos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarProyectosPlanificacion frame = new ConsultarProyectosPlanificacion();
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
	public ConsultarProyectosPlanificacion() {

		inicializar();

		JLabel lblNewLabel = new JLabel("Seleccionar Proyecto");
		lblNewLabel.setBounds(33, 10, 150, 14);
		contentPane.add(lblNewLabel);

		desctextField = new JTextArea("");
		desctextField.setBounds(220, 36, 117, 107);
		desctextField.setLineWrap(true);
		desctextField.setWrapStyleWord(true);
		desctextField.setEditable(false);
		desctextField.setBackground(getForeground());
		contentPane.add(desctextField);
		
		modelo = new DefaultListModel<String>();

		listProyectos = new JList();
		listProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProyectos.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 1) {
		    		desctextField.setText(listPro.get(list.getSelectedIndex()).getDescripcion());
		        }
		    }
		});
		scrollLista = new JScrollPane();
		scrollLista.setBounds(10, 36, 179, 147);
	    scrollLista.setViewportView(listProyectos);
		contentPane.add(scrollLista);

		JButton btnPlanificarProyecto = new JButton("Planificar");
		btnPlanificarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (listProyectos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto", "MENSAJE",
							JOptionPane.WARNING_MESSAGE);
				} else {
					proySeleccionado = listProyectos.getSelectedValue().toString();
					Planificacion consultarproyecto = new Planificacion();
					consultarproyecto.setVisible(true);
					Planificacion.procedencia = "ConsultarProyectos";
					dispose();
				}

			}
		});
		btnPlanificarProyecto.setBounds(46, 194, 108, 23);
		contentPane.add(btnPlanificarProyecto);

		JButton btnAtrs = new JButton("Atrás");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnAtrs.setBounds(64, 228, 71, 23);
		contentPane.add(btnAtrs);
		cargarProyectos();
	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 367, 288);
		setLocationRelativeTo(null);
		//setTitle("Consultar Proyectos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void cargarProyectos() {
		try {
			listPro = bdProy.cargarProyectosPropios(claseEstatica.getPropietario());
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Proyecto c : listPro) {
			modelo.addElement(c.getNombre());
			listProyectos.setModel(modelo);
		}
	}
}
