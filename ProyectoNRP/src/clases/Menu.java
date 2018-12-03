package clases;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;
	public static String proc = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {

		inicializar();

		crearComponentes();

	}

	public void inicializar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/imagenes/icono.PNG")));
		setResizable(false);
		setBounds(100, 100, 368, 406);
		setLocationRelativeTo(null);
		setTitle("Programa para gestión de requisitos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	public void crearComponentes() {
		JButton crearCliente = new JButton("Crear Cliente");
		crearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCliente crearcliente = new CrearCliente();
				claseEstatica.setProcedencia("Menu");
				crearcliente.setVisible(true);
				dispose();
			}
		});
		crearCliente.setBounds(79, 60, 220, 29);
		contentPane.add(crearCliente);

		JButton consultarClientes = new JButton("Consultar Clientes");
		consultarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarClientes consultarclientes = new ConsultarClientes();
				consultarclientes.setVisible(true);
				dispose();
			}
		});
		consultarClientes.setBounds(79, 88, 220, 29);
		contentPane.add(consultarClientes);

		JButton crearProyecto = new JButton("Crear Proyecto");
		crearProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearProyecto crearproyecto = new CrearProyecto();
				crearproyecto.setVisible(true);
				dispose();
			}
		});

		crearProyecto.setBounds(79, 129, 220, 29);
		contentPane.add(crearProyecto);

		JButton consultarProyectos = new JButton("Consultar Proyectos");
		consultarProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proc = "Consultar";
				ConsultarProyectos consultarproyectos = new ConsultarProyectos();
				consultarproyectos.setVisible(true);
				consultarproyectos.procedencia = "menuConsultar";

				dispose();
			}
		});
		consultarProyectos.setBounds(79, 158, 220, 29);
		contentPane.add(consultarProyectos);

		JLabel lblInicioDeLa = new JLabel("Inicio de la Aplicación");
		lblInicioDeLa.setBackground(Color.RED);
		lblInicioDeLa.setBounds(128, 22, 139, 16);
		contentPane.add(lblInicioDeLa);

		JButton btnConsultarRequisitos = new JButton("Consultar Requisitos");
		btnConsultarRequisitos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarRequisito Consultarrequisito = new ConsultarRequisito();
				Consultarrequisito.setVisible(true);
				Consultarrequisito.procedencia = "menu";
				dispose();
			}
		});
		btnConsultarRequisitos.setBounds(79, 253, 220, 29);
		contentPane.add(btnConsultarRequisitos);

		JButton btnPlanificacin = new JButton("Planificación");
		btnPlanificacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarProyectosPlanificacion consultarPlan = new ConsultarProyectosPlanificacion();
				consultarPlan.setVisible(true);
				dispose();
			}
		});
		btnPlanificacin.setBounds(79, 223, 220, 29);
		contentPane.add(btnPlanificacin);

		JButton btnCerrarSesin = new JButton("Cerrar sesión");
		btnCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarSesion iniciarSesion = new IniciarSesion();
				iniciarSesion.setVisible(true);
				claseEstatica.setPropietario("");
				dispose();
			}
		});
		btnCerrarSesin.setBounds(128, 332, 117, 29);
		contentPane.add(btnCerrarSesin);

		JLabel lblSesinIniciadaComo = new JLabel("Sesión iniciada como:");
		lblSesinIniciadaComo.setBounds(26, 305, 145, 16);
		contentPane.add(lblSesinIniciadaComo);

		JLabel lblUsuario = new JLabel(claseEstatica.getPropietario());
		lblUsuario.setBounds(160, 305, 80, 16);
		contentPane.add(lblUsuario);

		JButton btnModificarProyectos = new JButton("Modificar Proyectos");
		btnModificarProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				proc = "Modificar";
				ConsultarProyectos consultarproyectos = new ConsultarProyectos();
				consultarproyectos.setVisible(true);
				consultarproyectos.procedencia = "menuModificar";

				dispose();
			}
		});
		btnModificarProyectos.setBounds(79, 187, 220, 29);
		contentPane.add(btnModificarProyectos);
	}
}
