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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Font;

import BBDD.BD_Usuario;
import Items.Usuario;
import Main.Parking;

import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

public class Principal extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static Principal frame;
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	public static JPanel panelGris = new JPanel();
	public static JPanel cabecera = new JPanel();
	//Paneles de tabbedPane
	public static JPanel panelAvisos = new JPanel();
	public static JPanel panelReponer = new JPanel();
	public static JPanel panelPedidos = new JPanel();
	public static JPanel panelConsulta = new JPanel();
	public static JPanel panelEventos = new JPanel();
	public static JPanel panelPersonal = new JPanel();
	//Cosas de paneles de tabbedPane
		//Cosas de panelPersonal
			public static JComboBox comboBoxPersonalAltaGaraje = new JComboBox();
			public static JSeparator separatorPersonalAlta1 = new JSeparator();
			public static JLabel lblPersonalAltaPaso2 = new JLabel("<html><div style=\"font-weight:bold;\">&nbsp;&nbsp;&nbsp;<span>2</span>&nbsp;&nbsp;-&nbsp;&nbsp;Verifica los datos</div></html>");
			public static JLabel lblPersonalAltaPaso2Alt = new JLabel("");
			public static JLabel lblPersonalAltaDataContainer = new JLabel("<html>\r\n\t<table border=\"1\" cellpadding=\"2\" cellspacing=\"1\" width=\"238px\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Tipo</b>:</td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>N. Usuario</b>:</td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Contrase\u00F1a</b>:</td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Garaje</b>:</td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Nombre</b>:</td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>F. Nac</b>:</td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Direccion</b>:</td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Tfno</b>:</td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t</table>\r\n</html>");
			public static JButton btnPersonalAltaP2Continuar = new JButton("Continuar");
			public static JSeparator separatorPersonalAlta2 = new JSeparator();
			public static JLabel lblPersonalAltaPaso3 = new JLabel("<html><div style=\"font-weight:bold;\">&nbsp;&nbsp;&nbsp;<span>3</span>&nbsp;&nbsp;-&nbsp;&nbsp;Confirma los cambios a punto de realizarse</div></html>");
			public static JLabel lblPersonalAltaPaso3Alt = new JLabel("");
			public static JButton btnPersonalAltaP3Cancelar = new JButton("Cancelar Operaci\u00F3n");
			public static JButton btnPersonalAltaP3Confirmar = new JButton("Confirmar Baja");
			public static JTextField txtPersonalAltaNUsuario;
			
			public static Usuario usuABorrar=new Usuario();
			
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
				Parking.usuarioConectado=new Usuario();
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
		
		panelGris.setBackground(new Color(102, 102, 102));
		panelGris.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		panelGris.setBounds(0, 0, 994, 572);
		contentPane.add(panelGris);
		panelGris.setLayout(null);
		
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

		panelPersonal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPersonal.setLayout(null);
		
		JTextField txtPersonalAltaNomUsuario;
		JPasswordField passwordPersonalAlta1;
		JPasswordField passwordPersonalAlta2;
		JTextField txtPersonalAltaNombre;
		JTextField txtPersonalAltaApellidos;
		JTextField txtPersonalAltaDireccion;
		JTextField txtPersonalAltaTelefono;
		
		panelPersonal.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelPersonal.setLayout(null);
		
		JLabel lblPersonalBajas = new JLabel("<html>\r\n\t<h2>Dar de baja</h2>\r\n</html>");
		lblPersonalBajas.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblPersonalBajas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalBajas.setBounds(651, 11, 333, 50);
		panelPersonal.add(lblPersonalBajas);
		
		JPanel panelPersonalBajas = new JPanel();
		panelPersonalBajas.setBackground(SystemColor.controlHighlight);
		panelPersonalBajas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPersonalBajas.setBounds(651, 64, 333, 432);
		panelPersonal.add(panelPersonalBajas);
		panelPersonalBajas.setLayout(null);
		
		txtPersonalAltaNUsuario = new JTextField();
		txtPersonalAltaNUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		txtPersonalAltaNUsuario.setBounds(12, 37, 311, 20);
		panelPersonalBajas.add(txtPersonalAltaNUsuario);
		txtPersonalAltaNUsuario.setColumns(10);
		
		JLabel lblPersonalAltaPaso1 = new JLabel("<html><div style=\"font-weight:bold;\">&nbsp;&nbsp;&nbsp;<span>1</span>&nbsp;&nbsp;-&nbsp;&nbsp;Introduce el Nombre de Usuario del empleado</div></html>");
		lblPersonalAltaPaso1.setOpaque(true);
		lblPersonalAltaPaso1.setBackground(new Color(169, 169, 169));
		lblPersonalAltaPaso1.setBounds(2, 2, 329, 26);
		panelPersonalBajas.add(lblPersonalAltaPaso1);
		
		JButton btnPersonalAltaP1Cancelar = new JButton("Cancelar");
		btnPersonalAltaP1Cancelar.setFocusPainted(false);
		btnPersonalAltaP1Cancelar.setBackground(new Color(169, 169, 169));
		btnPersonalAltaP1Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPersonalAltaNUsuario.setText("");
				PanelBajaBorrarTodo();
			}
		});
		btnPersonalAltaP1Cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPersonalAltaP1Cancelar.setBounds(12, 65, 152, 25);
		panelPersonalBajas.add(btnPersonalAltaP1Cancelar);
		
		JButton btnPersonalAltaP1Continuar = new JButton("Continuar");
		btnPersonalAltaP1Continuar.setFocusPainted(false);
		btnPersonalAltaP1Continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelBajaBorrarTodo();
				usuABorrar=new BD_Usuario("mysql-properties.xml").validarNomUsu(txtPersonalAltaNUsuario.getText());
				if(usuABorrar.isVerificado()){
					separatorPersonalAlta1.setVisible(true);
					lblPersonalAltaPaso2.setVisible(true);
					lblPersonalAltaDataContainer.setVisible(true);
					lblPersonalAltaDataContainer.setText("<html>\r\n\t<table border=\"1\" cellpadding=\"2\" cellspacing=\"1\" width=\"238px\">\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Tipo</b>:</td>\r\n\t\t\t<td>"+usuABorrar.getTipo()+"</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>N. Usuario</b>:</td>\r\n\t\t\t<td>"+usuABorrar.getNombreUsuario()+"</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Contrase\u00F1a</b>:</td>\r\n\t\t\t<td>"+usuABorrar.getContrasenya()+"</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Garaje</b>:</td>\r\n\t\t\t<td>"+usuABorrar.getCodGaraje()+"</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Nombre</b>:</td>\r\n\t\t\t<td>"+usuABorrar.getNombreCompleto()+"</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>F. Nac</b>:</td>\r\n\t\t\t<td>"+usuABorrar.getFechaNacimientoFormateada(" / ")+"</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Direccion</b>:</td>\r\n\t\t\t<td>"+usuABorrar.getDireccion()+"</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td width=\"75px\"><b>Tfno</b>:</td>\r\n\t\t\t<td>"+usuABorrar.getTelefono()+"</td>\r\n\t\t</tr>\r\n\t</table>\r\n</html>");
					btnPersonalAltaP2Continuar.setVisible(true);
					
				}else{
					lblPersonalAltaPaso2Alt.setText("<html><div style=\"font-weight:bold;\">&nbsp;&nbsp;&nbsp;El nombre de usuario introducido no existe</div></html>");
					lblPersonalAltaPaso2Alt.setVisible(true);
				}
			}
		});
		btnPersonalAltaP1Continuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPersonalAltaP1Continuar.setBounds(171, 65, 152, 25);
		panelPersonalBajas.add(btnPersonalAltaP1Continuar);
		
		separatorPersonalAlta1.setBounds(2, 96, 329, 2);
		panelPersonalBajas.add(separatorPersonalAlta1);

		lblPersonalAltaPaso2.setOpaque(true);
		lblPersonalAltaPaso2.setBackground(new Color(169, 169, 169));
		lblPersonalAltaPaso2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPersonalAltaPaso2.setBounds(2, 98, 329, 26);
		panelPersonalBajas.add(lblPersonalAltaPaso2);

		lblPersonalAltaPaso2Alt.setOpaque(true);
		lblPersonalAltaPaso2Alt.setBackground(new Color(183, 106, 106));
		lblPersonalAltaPaso2Alt.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPersonalAltaPaso2Alt.setBounds(2, 98, 329, 26);
		panelPersonalBajas.add(lblPersonalAltaPaso2Alt);
		
		lblPersonalAltaDataContainer.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPersonalAltaDataContainer.setVerticalAlignment(SwingConstants.TOP);
		lblPersonalAltaDataContainer.setBounds(12, 135, 311, 178);
		panelPersonalBajas.add(lblPersonalAltaDataContainer);
		
		btnPersonalAltaP2Continuar.setFocusPainted(false);
		btnPersonalAltaP2Continuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(1);
				boolean posibleBorrar=true;
				String msgError="";
				if(posibleBorrar&&!usuABorrar.isVerificado()){
					msgError="Ha ocurrido un error inesperado, reintenta más tarde";
					posibleBorrar=false;
				}
				if(posibleBorrar&&usuABorrar.getNombreUsuario().equals(Parking.usuarioConectado.getNombreUsuario())){
					msgError="No puedes date de baja a ti mismo";
					posibleBorrar=false;
				}
				if(posibleBorrar&&usuABorrar.getCodGaraje()!=Parking.usuarioConectado.getCodGaraje()){
					msgError="No puedes dar de baja a miembros de orto garaje";
					posibleBorrar=false;
				}
				if(posibleBorrar){
					separatorPersonalAlta2.setVisible(true);
					lblPersonalAltaPaso3.setVisible(true);
					btnPersonalAltaP3Cancelar.setVisible(true);
					btnPersonalAltaP3Confirmar.setVisible(true);
					System.out.println(2);
				}else{
					lblPersonalAltaPaso3Alt.setText("<html><div style=\"font-weight:bold;\">&nbsp;&nbsp;&nbsp;"+msgError+"</div></html>");
					lblPersonalAltaPaso3Alt.setVisible(true);
					System.out.println(3);
				}
			}
		});
		btnPersonalAltaP2Continuar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPersonalAltaP2Continuar.setBounds(12, 324, 311, 26);
		panelPersonalBajas.add(btnPersonalAltaP2Continuar);
		
		separatorPersonalAlta2.setBounds(2, 359, 329, 2);
		panelPersonalBajas.add(separatorPersonalAlta2);

		lblPersonalAltaPaso3.setOpaque(true);
		lblPersonalAltaPaso3.setBackground(new Color(169, 169, 169));
		lblPersonalAltaPaso3.setBounds(2, 361, 329, 26);
		panelPersonalBajas.add(lblPersonalAltaPaso3);
		
		lblPersonalAltaPaso3Alt.setOpaque(true);
		lblPersonalAltaPaso3Alt.setBackground(new Color(183, 106, 106));
		lblPersonalAltaPaso3Alt.setBounds(2, 361, 329, 26);
		panelPersonalBajas.add(lblPersonalAltaPaso3Alt);
		
		btnPersonalAltaP3Cancelar.setFocusPainted(false);
		btnPersonalAltaP3Cancelar.setBackground(new Color(255, 192, 203));
		btnPersonalAltaP3Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPersonalAltaNUsuario.setText("");
				PanelBajaBorrarTodo();
			}
		});
		btnPersonalAltaP3Cancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPersonalAltaP3Cancelar.setBounds(12, 398, 152, 25);
		panelPersonalBajas.add(btnPersonalAltaP3Cancelar);
		
		btnPersonalAltaP3Confirmar.setFocusPainted(false);
		btnPersonalAltaP3Confirmar.setBackground(new Color(240, 255, 240));
		btnPersonalAltaP3Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPersonalAltaP3Confirmar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPersonalAltaP3Confirmar.setBounds(171, 398, 152, 25);
		panelPersonalBajas.add(btnPersonalAltaP3Confirmar);
		
		JLabel lblPersonalAlta = new JLabel("<html>\r\n\t<h2>Dar de alta</h2>\r\n</html>");
		lblPersonalAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalAlta.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblPersonalAlta.setBounds(304, 11, 333, 50);
		panelPersonal.add(lblPersonalAlta);
		
		JPanel panelPersonalAlta = new JPanel();
		panelPersonalAlta.setLayout(null);
		panelPersonalAlta.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelPersonalAlta.setBackground(SystemColor.controlHighlight);
		panelPersonalAlta.setBounds(305, 64, 333, 432);
		panelPersonal.add(panelPersonalAlta);
		
		JComboBox comboBoxPersonalAltaTipo = new JComboBox();
		comboBoxPersonalAltaTipo.setToolTipText("Seleccionar el rol que tomar\u00E1 en el parking");
		comboBoxPersonalAltaTipo.setModel(new DefaultComboBoxModel(new String[] {"MECANICO", "LIMPIEZA", "SEGURIDAD"}));
		comboBoxPersonalAltaTipo.setBounds(123, 11, 200, 20);
		panelPersonalAlta.add(comboBoxPersonalAltaTipo);
		
		JLabel lblPersonalAltaTipo = new JLabel("Tipo");
		lblPersonalAltaTipo.setBounds(10, 11, 103, 20);
		panelPersonalAlta.add(lblPersonalAltaTipo);
		
		txtPersonalAltaNomUsuario = new JTextField();
		txtPersonalAltaNomUsuario.setToolTipText("Introduce el nombre de usuario");
		txtPersonalAltaNomUsuario.setBounds(123, 37, 200, 20);
		panelPersonalAlta.add(txtPersonalAltaNomUsuario);
		txtPersonalAltaNomUsuario.setColumns(10);
		
		JLabel lblPersonalAltaNombreDeUsuario = new JLabel("Nombre de Usuario");
		lblPersonalAltaNombreDeUsuario.setBounds(10, 37, 103, 20);
		panelPersonalAlta.add(lblPersonalAltaNombreDeUsuario);
		
		passwordPersonalAlta1 = new JPasswordField();
		passwordPersonalAlta1.setToolTipText("Introduce la contrase\u00F1a");
		passwordPersonalAlta1.setBounds(123, 63, 200, 20);
		panelPersonalAlta.add(passwordPersonalAlta1);
		
		JLabel lblPersonalAltaContrasenya = new JLabel("Contrase\u00F1a");
		lblPersonalAltaContrasenya.setBounds(10, 63, 103, 20);
		panelPersonalAlta.add(lblPersonalAltaContrasenya);
		
		passwordPersonalAlta2 = new JPasswordField();
		passwordPersonalAlta2.setToolTipText("Repite la contrase\u00F1a");
		passwordPersonalAlta2.setBounds(123, 89, 200, 20);
		panelPersonalAlta.add(passwordPersonalAlta2);
		
		JLabel lblPersonalAltaRepetirContrasenya = new JLabel("Repetir Contrase\u00F1a");
		lblPersonalAltaRepetirContrasenya.setBounds(10, 89, 103, 20);
		panelPersonalAlta.add(lblPersonalAltaRepetirContrasenya);
		
		comboBoxPersonalAltaGaraje.setEnabled(false);
		comboBoxPersonalAltaGaraje.setBounds(123, 116, 200, 20);
		//comboBoxPersonalAltaGaraje.setForeground(DefaultLookup.getColor(comboBoxPersonalAltaGaraje, this, "ComboBox.disabledForeground", null));
		panelPersonalAlta.add(comboBoxPersonalAltaGaraje);
		
		JLabel lblPersonalAltaGaraje = new JLabel("Garaje");
		lblPersonalAltaGaraje.setBounds(10, 116, 103, 20);
		panelPersonalAlta.add(lblPersonalAltaGaraje);
		
		txtPersonalAltaNombre = new JTextField();
		txtPersonalAltaNombre.setToolTipText("Nombre del empleado");
		txtPersonalAltaNombre.setBounds(123, 141, 200, 20);
		panelPersonalAlta.add(txtPersonalAltaNombre);
		txtPersonalAltaNombre.setColumns(10);
		
		JLabel lblPersonalAltaNombre = new JLabel("Nombre");
		lblPersonalAltaNombre.setBounds(10, 141, 103, 20);
		panelPersonalAlta.add(lblPersonalAltaNombre);
		
		txtPersonalAltaApellidos = new JTextField();
		txtPersonalAltaApellidos.setToolTipText("Apellidos del empleado");
		txtPersonalAltaApellidos.setBounds(123, 167, 200, 20);
		panelPersonalAlta.add(txtPersonalAltaApellidos);
		txtPersonalAltaApellidos.setColumns(10);
		
		JLabel lblPersonalAltaApellidos = new JLabel("Apellidos");
		lblPersonalAltaApellidos.setBounds(10, 167, 103, 20);
		panelPersonalAlta.add(lblPersonalAltaApellidos);
		
		JDateChooser dateChooserPersonalAlta = new JDateChooser();
		dateChooserPersonalAlta.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooserPersonalAlta.setBounds(123, 193, 200, 20);
		panelPersonalAlta.add(dateChooserPersonalAlta);
		
		JLabel lblPersonalAltaFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblPersonalAltaFechaNacimiento.setBounds(10, 193, 103, 20);
		panelPersonalAlta.add(lblPersonalAltaFechaNacimiento);
		
		txtPersonalAltaDireccion = new JTextField();
		txtPersonalAltaDireccion.setBounds(123, 219, 200, 20);
		panelPersonalAlta.add(txtPersonalAltaDireccion);
		txtPersonalAltaDireccion.setColumns(10);
		
		JLabel lblPersonalAltaDireccion = new JLabel("Direccion");
		lblPersonalAltaDireccion.setBounds(10, 218, 103, 20);
		panelPersonalAlta.add(lblPersonalAltaDireccion);
		
		txtPersonalAltaTelefono = new JTextField();
		txtPersonalAltaTelefono.setBounds(123, 245, 200, 20);
		panelPersonalAlta.add(txtPersonalAltaTelefono);
		txtPersonalAltaTelefono.setColumns(10);
		
		JLabel lblPersonalAltaTelefono = new JLabel("Telefono");
		lblPersonalAltaTelefono.setBounds(10, 245, 103, 20);
		panelPersonalAlta.add(lblPersonalAltaTelefono);
		
		JSeparator separatorAltaPersonal1 = new JSeparator();
		separatorAltaPersonal1.setBounds(2, 275, 329, 2);
		panelPersonalAlta.add(separatorAltaPersonal1);
		
		JSeparator separatorAltaPersonal2 = new JSeparator();
		separatorAltaPersonal2.setBounds(2, 305, 329, 2);
		panelPersonalAlta.add(separatorAltaPersonal2);
		
		JSeparator separatorAltaPersonal3 = new JSeparator();
		separatorAltaPersonal3.setBounds(2, 380, 329, 2);
		panelPersonalAlta.add(separatorAltaPersonal3);
		
		JLabel lblAltaPersonalProTip = new JLabel("Completa el formulario para continuar");
		lblAltaPersonalProTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaPersonalProTip.setBounds(10, 276, 313, 30);
		panelPersonalAlta.add(lblAltaPersonalProTip);
		
		JButton btnAltaPersonalCancelar = new JButton("Cancelar");
		btnAltaPersonalCancelar.setBackground(new Color(175, 175, 175));
		btnAltaPersonalCancelar.setFocusPainted(false);
		btnAltaPersonalCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAltaPersonalCancelar.setBounds(10, 391, 103, 30);
		panelPersonalAlta.add(btnAltaPersonalCancelar);
		
		JButton btnAltaPersonalGoes = new JButton("Dar de alta");
		btnAltaPersonalGoes.setFocusPainted(false);
		btnAltaPersonalGoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAltaPersonalGoes.setBounds(123, 391, 200, 30);
		panelPersonalAlta.add(btnAltaPersonalGoes);
		
		JLabel lblAltaPersonalDescripcion = new JLabel("<html>\r\n\t<div style=\"padding:3px;font-size:10px;\">Para poder da a nuevo personal es necesario:</div>\r\n\t<span style=\"color:#222222;\">&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;Rellenar los campos obligatorios</span><br>\r\n\t<span style=\"color:#222222;\">&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;Que todos los formatos sean correctos</span><br>\r\n\t<span style=\"color:#222222;\">&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;El nuevo miembro debe ser mayor de edad</span><br>\r\n\t\r\n</html>");
		lblAltaPersonalDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAltaPersonalDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaPersonalDescripcion.setBounds(10, 306, 313, 74);
		panelPersonalAlta.add(lblAltaPersonalDescripcion);
		
		JLabel lblPersonal = new JLabel("<html>\r\n\t<h1><b>PERSONAL</b></h1>\r\n</html>");
		lblPersonal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonal.setBounds(10, 11, 282, 50);
		panelPersonal.add(lblPersonal);
		
		JLabel lblDescripcion = new JLabel("<html>\r\n\t<h3>Descripci\u00F3n</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">El panel de personal permite dar de <b>alta</b> y <b>baja</b> a el personal</p>\r\n\t<h3>Utilizaci\u00F3n</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">Se deben introducir datos v\u00E1lidos para dar de alta, no son necesarios todos los datos, los campos obligatorios son:\r\n<ul>\r\n\t<li>Tipo</li>\r\n\t<li>Nombre</li>\r\n\t<li>Nombre de usuario</li>\r\n\t<li>Contrase\u00F1a</li>\r\n\t<li>Garaje</li>\r\n</ul></p>\r\n\t<h3>Precauciones</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">Los cambios aqui realizados son <span style=\"color:red;\">permanentes</span>, una vez dada de baja una persona, no podr\u00E1 recuperarse.</p>\r\n</html>");
		lblDescripcion.setToolTipText("Datos generales sobre el panel de personal");
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(20, 67, 272, 429);
		panelPersonal.add(lblDescripcion);
		
		PanelBajaBorrarTodo();
		/**/
		
	}
	public static void setUtil(Boolean x){
		
		//Visual
		
		panelGris.setVisible(!x);
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
							comboBoxPersonalAltaGaraje.setModel(new DefaultComboBoxModel(new String[] {""+Parking.usuarioConectado.getCodGaraje()}));
						case "MECANICO":case "LIMPIEZA":case "SEGURIDAD":
							tabbedPane.addTab(" Eventos Recientes ", null, panelEventos, "Consultar los eventos que han ocurrido desde el inicio de sesi\u00F3n");
							break;
					}
					break;
				case "ESTANDAR":
					lblMsgBienvenida.setText("<html>&nbsp;&nbsp;&nbsp;Gestión de Coche&nbsp;&nbsp;&nbsp;<span style=\"background-color:#687043;color:#ceccc2;font-size:11px;padding-left:3px;font-family:consolas;\">&nbsp;"+Parking.plazaObjetivo.getMatricula()+"&nbsp;</span>&nbsp;&nbsp;&nbsp;Entrada: <span style=\"background-color:#91cee0;color:#343434;font-size:11px;padding-left:3px;font-family:consolas;\">&nbsp;"+Parking.plazaObjetivo.getHora_entrada()+"&nbsp;</span></html>");
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
	public static void PanelBajaBorrarTodo(){
		separatorPersonalAlta1.setVisible(false);
		lblPersonalAltaPaso2.setVisible(false);
		lblPersonalAltaPaso2Alt.setVisible(false);
		lblPersonalAltaDataContainer.setVisible(false);
		btnPersonalAltaP2Continuar.setVisible(false);
		separatorPersonalAlta2.setVisible(false);
		lblPersonalAltaPaso3.setVisible(false);
		lblPersonalAltaPaso3Alt.setVisible(false);
		btnPersonalAltaP3Cancelar.setVisible(false);
		btnPersonalAltaP3Confirmar.setVisible(false);
	}
}
