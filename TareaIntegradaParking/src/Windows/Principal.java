package Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Font;

import Items.Usuario;
import Main.Parking;

import javax.swing.border.MatteBorder;

public class Principal extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static Principal frame;
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	//public static JPanel panelGris = new JPanel();
	public static JPanel cabecera = new JPanel();
	//Paneles de tabbedPane
	public static JPanel panelAvisos = new JPanel();
	public static JPanel panelReponer = new JPanel();
	public static JPanel panelPedidos = new JPanel();
	public static JPanel panelConsulta = new JPanel();
	public static JPanel panelEventos = new JPanel();
	public static JPanel panelPersonal = new JPanel();
	//Less important
	public static JLabel lblMsgBienvenida = new JLabel("");
	private final JLabel lblEventos = new JLabel("a");
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Principal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					setUtil(false);
					frame.setEnabled(false);
					Login.abrir();
					CambiarContrasenya.abrir();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cargador.class.getResource("/Recursos/iconos/northlogo_default.png")));
		setEnabled(false);
		setResizable(false);
		setTitle("[Norter S.L.] - Gesti\u00F3n de Parking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/north2.png")));
		setBounds(0, 0, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cabecera.setBackground(new Color(169, 169, 169));
		cabecera.setBounds(0, 0, 994, 40);
		contentPane.add(cabecera);
		cabecera.setLayout(null);
		
		JButton closeSessionButton = new JButton("Cerrar Sesi\u00F3n");
		closeSessionButton.setToolTipText("Cierra la sesi\u00F3n, ser\u00E1 necesario iniciar sesi\u00F3n con otra cuenta v\u00E1lida");
		closeSessionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setUtil(false);
				frame.setEnabled(false);
				Parking.usuarioConectado=new Usuario(false);
				Login.reset();
			}
		});
		closeSessionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeSessionButton.setBackground(new Color(204, 102, 102));
		closeSessionButton.setFocusPainted(false);
		closeSessionButton.setBounds(869, 5, 120, 30);
		cabecera.add(closeSessionButton);
		
		JButton changePasswordButton = new JButton("Cambiar Contrase\u00F1a");
		changePasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		changePasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setEnabled(false);
				//CambiarContrasenya.frame.setLocationRelativeTo(Principal.frame);
				CambiarContrasenya.frame.setLocationRelativeTo(changePasswordButton);
				CambiarContrasenya.frame.setVisible(true);
			}
		});
		changePasswordButton.setToolTipText("Cambiar la contrase\u00F1a de su cuenta");
		changePasswordButton.setHorizontalTextPosition(SwingConstants.CENTER);
		changePasswordButton.setBackground(new Color(255, 204, 153));
		changePasswordButton.setActionCommand("");
		changePasswordButton.setFocusPainted(false);
		changePasswordButton.setBounds(706, 8, 153, 24);
		cabecera.add(changePasswordButton);
		
		lblMsgBienvenida.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 15));
		lblMsgBienvenida.setBounds(0, 0, 850, 40);
		cabecera.add(lblMsgBienvenida);
		
		//panelGris.setBackground(new Color(102, 102, 102));
		//panelGris.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		//panelGris.setBounds(0, 0, 994, 572);
		//contentPane.add(panelGris);
		//panelGris.setLayout(null);
		
		tabbedPane.setBounds(0, 40, 994, 532);
		contentPane.add(tabbedPane);
		
		panelAvisos.setLayout(null);
		
		panelReponer.setLayout(null);
		
		panelPedidos.setLayout(null);
		
		panelPersonal.setLayout(null);
		
		panelEventos.setLayout(null);
		lblEventos.setForeground(new Color(47, 79, 79));
		lblEventos.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEventos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(105, 105, 105)));
		lblEventos.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblEventos.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblEventos.setBackground(new Color(211, 211, 211));
		lblEventos.setOpaque(true);
		lblEventos.setBounds(315, 5, 664, 488);
		
		panelEventos.add(lblEventos);
		
		JLabel lblInfoTitle = new JLabel("Visor de Eventos");
		lblInfoTitle.setForeground(new Color(0, 0, 51));
		lblInfoTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblInfoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoTitle.setBounds(0, 0, 314, 74);
		panelEventos.add(lblInfoTitle);
		
		JLabel lblInfoContent = new JLabel("<html>\r\n<p style=\"text-align:justify;padding:15px;\">\r\nAqui aparecer\u00E1n los <b>eventos</b> mas recientes desde el inicio de la sesi\u00F3n como:<br>\r\n</p><ul>\r\n<li>Entradas y salidas del parking</li>\r\n<li>Altas y bajas de personal</li>\r\n<li>Solicitaciones de servicios</li>\r\n<li>Pedidos realizados de forma autom\u00E1tica</li>\r\n</ul>\r\n</html>");
		lblInfoContent.setVerticalAlignment(SwingConstants.TOP);
		lblInfoContent.setBounds(10, 85, 304, 419);
		panelEventos.add(lblInfoContent);
		
		panelConsulta.setLayout(null);
				
		/**/

		JTextField txtAltaNomUsuario;
		JPasswordField passwordAlta1;
		JPasswordField passwordAlta2;
		JTextField txtAltaNombre;
		JTextField txtAltaApellidos;

		
		panelPersonal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPersonal.setLayout(null);
		
		JLabel lblBajas = new JLabel("<html>\r\n\t<h2>Dar de baja</h2>\r\n</html>");
		lblBajas.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblBajas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBajas.setBounds(651, 11, 333, 50);
		panelPersonal.add(lblBajas);
		
		JPanel panelBajas = new JPanel();
		panelBajas.setBackground(SystemColor.controlHighlight);
		panelBajas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelBajas.setBounds(651, 64, 333, 432);
		panelPersonal.add(panelBajas);
		panelBajas.setLayout(null);
		
		JLabel lblAlta = new JLabel("<html>\r\n\t<h2>Dar de alta</h2>\r\n</html>");
		lblAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlta.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblAlta.setBounds(304, 11, 333, 50);
		panelPersonal.add(lblAlta);
		
		JPanel panelAlta = new JPanel();
		panelAlta.setLayout(null);
		panelAlta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelAlta.setBackground(SystemColor.controlHighlight);
		panelAlta.setBounds(305, 64, 333, 432);
		panelPersonal.add(panelAlta);
		
		JComboBox comboBoxAltaTipo = new JComboBox();
		comboBoxAltaTipo.setModel(new DefaultComboBoxModel(new String[] {"MECANICO", "LIMPIEZA", "SEGURIDAD"}));
		comboBoxAltaTipo.setBounds(123, 11, 200, 20);
		panelAlta.add(comboBoxAltaTipo);
		
		txtAltaNomUsuario = new JTextField();
		txtAltaNomUsuario.setBounds(123, 37, 200, 20);
		panelAlta.add(txtAltaNomUsuario);
		txtAltaNomUsuario.setColumns(10);
		
		passwordAlta1 = new JPasswordField();
		passwordAlta1.setBounds(123, 63, 200, 20);
		panelAlta.add(passwordAlta1);
		
		passwordAlta2 = new JPasswordField();
		passwordAlta2.setBounds(123, 89, 200, 20);
		panelAlta.add(passwordAlta2);
		
		JComboBox comboBoxAltaGaraje = new JComboBox();
		comboBoxAltaGaraje.setBounds(123, 116, 200, 20);
		panelAlta.add(comboBoxAltaGaraje);
		
		txtAltaNombre = new JTextField();
		txtAltaNombre.setBounds(123, 141, 200, 20);
		panelAlta.add(txtAltaNombre);
		txtAltaNombre.setColumns(10);
		
		txtAltaApellidos = new JTextField();
		txtAltaApellidos.setBounds(123, 167, 200, 20);
		panelAlta.add(txtAltaApellidos);
		txtAltaApellidos.setColumns(10);
		
		JLabel lblPersonal = new JLabel("<html>\r\n\t<h1><b>PERSONAL</b></h1>\r\n</html>");
		lblPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonal.setBounds(10, 11, 282, 50);
		panelPersonal.add(lblPersonal);
		
		JLabel lblDescripcion = new JLabel("<html>\r\n\t<h3>Descripci\u00F3n</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">El panel de personal permite dar de <b>alta</b> y <b>baja</b> a el personal</p>\r\n\t<h3>Utilizaci\u00F3n</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">Se deben introducir datos v\u00E1lidos para dar de alta, no son necesarios todos los datos, los campos obligatorios son:\r\n<ul>\r\n\t<li>Tipo</li>\r\n\t<li>Nombre</li>\r\n\t<li>Nombre de usuario</li>\r\n\t<li>Contrase\u00F1a</li>\r\n\t<li>Garaje</li>\r\n</ul></p>\r\n\t<h3>Precauciones</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">Los cambios aqui realizados son <span style=\"color:red;\">permanentes</span>, una vez dada de baja una persona, no podr\u00E1 recuperarse.</p>\r\n</html>");
		lblDescripcion.setToolTipText("Datos generales sobre el panel de personal");
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(20, 67, 272, 429);
		panelPersonal.add(lblDescripcion);
		
		/**/
	}
	public static void setUtil(Boolean x){
		
		//Visual
		
		//panelGris.setVisible(!x);
		cabecera.setVisible(x);
		tabbedPane.setVisible(x);
		
		//Paneles
		
		if(Parking.TOKEN!=null){
			tabbedPane.removeAll();
			System.out.println(Parking.TOKEN);
			switch(Parking.TOKEN){
				case "USUARIO":
					lblMsgBienvenida.setText("<html>&nbsp;&nbsp;&nbsp;\u00A1 Bienvenido/a "+Parking.usuarioConectado.getNombreCompleto()+" !&nbsp;&nbsp;&nbsp;<span style=\"background-color:#8c7a31;color:#ceccc2;font-size:11px;padding-left:3px;\">&nbsp;"+Parking.usuarioConectado.getTipo().toUpperCase()+"&nbsp;</span></html>");
					switch(Parking.usuarioConectado.getTipo()){
						case "ADMINISTRADOR":
							tabbedPane.addTab(" Consultas ", null, panelConsulta, "Consultar distintos tipos de datos");
							tabbedPane.addTab(" Avisos ", null, panelAvisos, "Mirar los temas de urgencia a tratar");
							tabbedPane.addTab(" Reponer ", null, panelReponer, "Reponer materiales propios de los servicios");
							tabbedPane.addTab(" Pedidos ", null, panelPedidos, "Consultar los ultimos pedidos");
							tabbedPane.addTab(" Personal ", null, panelPersonal, "Dar de alta y de baja a el personal");
						case "MECANICO":case "LIMPIEZA":case "SEGURIDAD":
							tabbedPane.addTab(" Eventos Recientes ", null, panelEventos, "Consultar los eventos que han ocurrido desde el inicio de sesi\u00F3n");
							break;
					}
					break;
				case "ESTANDAR":
					lblMsgBienvenida.setText("<html>&nbsp;&nbsp;&nbsp;Gestión de Coche&nbsp;&nbsp;&nbsp;<span style=\"background-color:#687043;color:#ceccc2;font-size:11px;padding-left:3px;font-family:consolas;\">&nbsp;"+"aqui va la matricula de la clase plazas"+"&nbsp;</span></html>");
					break;
				case "ABONADO":
					lblMsgBienvenida.setText("<html>&nbsp;&nbsp;&nbsp;Panel Gestión Abonado&nbsp;&nbsp;&nbsp;<span style=\"background-color:#8c7a31;color:#ceccc2;font-size:11px;padding-left:3px;font-family:consolas;\">&nbsp;"+Parking.tarjetaIdentificada.getDni().toUpperCase()+"&nbsp;</span>&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;Coche&nbsp;&nbsp;&nbsp;<span style=\"background-color:#687043;color:#ceccc2;font-size:11px;padding-left:3px;font-family:consolas;\">&nbsp;"+Parking.tarjetaIdentificada.getMatricula().toUpperCase()+"&nbsp;</span></html>");
					break;
				case "LOST":
					lblMsgBienvenida.setText("<html>&nbsp;&nbsp;&nbsp;Panel de Duplicado de Tarjeta</html>");
					break;
				default:
					System.out.println("INVALID TOKEN!: "+Parking.TOKEN);
					break;
			}
		}
	}
}
