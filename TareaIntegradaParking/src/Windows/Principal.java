package Windows;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Font;

import BBDD.BD_Tarjeta;
import BBDD.BD_Usuario;
import Items.Tarjetas;
import Items.Usuario;
import Items.Validator;
import Items.Xml;
import Main.Parking;

import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

public class Principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public static JPanel panelDuplicadoTarjeta = new JPanel();
	public static JPanel panelGenerar = new JPanel();
	//Cosas de paneles de tabbedPane
		//Cosas de panelPersonal
			public static JLabel lblAltaPersonalProTip = new JLabel("Completa el formulario para continuar");
			public static JComboBox<Object> comboBoxPersonalAltaGaraje = new JComboBox<Object>();
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
		//Cosas de panelDuplicadotarjeta
			public static JTextField txtDuplicadoTarjetaFormCodGaraje;
			public static JTextField txtDuplicadoTarjetaFormNumPlaza;
			public static JTextField txtDuplicadoTarjetaFormDNI;
			public static JLabel lblDuplicadoTarjetaAnulacionDuplicado = new JLabel("<html>\r\n\t<h3>Anulaci\u00F3n y Duplicado</h3>\r\n</html>");
			public static JLabel lblDuplicadoTarjetaDibujoTop = new JLabel("<html>\r\n\t<table>\r\n\t\t<tr>\r\n\t\t\t<td width=\"70\">Garaje: <b>1</b></td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>N. Plaza: <b>1</b></td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr height=\"3\">\r\n\t\t\t<td></td>\r\n\t\t\t<td>Cod. Tarjeta: <b>12345</b></td>\r\n\t\t</tr>\r\n\t</table>\r\n</html>");
			public static JLabel lblDuplicadoTarjetaDibujo = new JLabel("");
			public static JButton btnDuplicadoTarjetaFinalProTipOcultar = new JButton("Ocultar");
			public static JLabel lblDuplicadoTarjetaFinalProTip = new JLabel("<html><div style=\"padding:10px;\">La tarjeta se ha anulado correctamente, su duplicado estar\u00E1 disponible en un periodo de 2 horas en la oficina de administraci\u00F3n de su parking<br><br>Deber\u00E1 traer la documentaci\u00F3n que lo acredite (DNI).</div></html>");
			public static JLabel lblDuplicadoTarjetaConfirmacion = new JLabel("<html><div>\u00BFEst\u00E1s seguro/a de queres anular esta tarjeta?</div></html>");
			public static JButton btnDuplicadoTarjetaCancelar = new JButton("Cancelar");
			public static JButton btnDuplicadoTarjetaProceder = new JButton("Proceder");
			public static JLabel lblDuplicadoTarjetaFormProTip = new JLabel("Introduce los datos para continuar");
			
			public static Tarjetas tarjetaAAunlar=new Tarjetas();
		//Cosas de panelGenerar
			public static JTextField txtGenerarPreferenciasNomOtro = new JTextField();
			public static JLabel lblGenerarCredits = new JLabel("<html><div style=\"padding:10px;text-align:justify;\">Se han generado los archivos requeridos.<br><br>Puedes encontrarlos en el directorio <b>\"/Personal/\"</b>.<br><br>El proceso se ha completado sin errores.</div></html>");
			public static JButton btnGenerarOcultar = new JButton("Ocultar");
			public static JLabel lblGenerarProTip = new JLabel("<html>ProTip</html>");
			public static JRadioButton rdbtnGenerarPreferenciasNomDef = new JRadioButton("<html><b>Por Defecto</b>:&nbsp;&nbsp;&nbsp;<span style=\"color:gray\">Personal_Parking_X</span></html>");
			
			public static String preffilenamedef="Personal_Parking_X";
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
		//	PERSONAL
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
				}else{
					lblPersonalAltaPaso3Alt.setText("<html><div style=\"font-weight:bold;\">&nbsp;&nbsp;&nbsp;"+msgError+"</div></html>");
					lblPersonalAltaPaso3Alt.setVisible(true);
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
				txtPersonalAltaNUsuario.setText("");
				PanelBajaBorrarTodo();
				new BD_Usuario("mysql-properties.xml").bajaUsuario(usuABorrar.getNombreUsuario());
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
		
		JComboBox<Object> comboBoxPersonalAltaTipo = new JComboBox<Object>();
		comboBoxPersonalAltaTipo.setToolTipText("Seleccionar el rol que tomar\u00E1 en el parking");
		comboBoxPersonalAltaTipo.setModel(new DefaultComboBoxModel<Object>(new String[] {"MECANICO", "LIMPIEZA", "SEGURIDAD"}));
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
		
		JLabel lblPersonalAltaNombreDeUsuario = new JLabel("Nombre Usuario");
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
		btnAltaPersonalGoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean cont = true;
				String txt="";
				if(cont&&(txtPersonalAltaNomUsuario.getText().equals("")||new String(passwordPersonalAlta1.getPassword()).equals("")||new String(passwordPersonalAlta2.getPassword()).equals("")||txtPersonalAltaNombre.getText().equals(""))){
					cont=false;txt="Completa todos los campos obligatorios";
				}
				if(cont&&(!new String(passwordPersonalAlta1.getPassword()).equals(new String(passwordPersonalAlta2.getPassword())))){
					cont=false;txt="Las contraseñas no coinciden";
				}
				if(cont&&(!Validator.Contrasenya(new String(passwordPersonalAlta1.getPassword())))){
					cont=false;txt="La contraseña debe de tener al menos 8 caracteres";
				}
				if(cont&&!Validator.Telefono(txtPersonalAltaTelefono.getText())){
					cont=false;txt="Formato incorrecto de telefono";
				}
				if(cont&&new BD_Usuario("mysql-properties.xml").validarNomUsu(txtPersonalAltaNomUsuario.getText()).isVerificado()){
					cont=false;txt="Ese nombre de usuario ya esta cogido";
				}
				boolean tmp=false;
				//try{dateChooserPersonalAlta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().wait();}catch(Exception ee){tmp=true;}
				try{new java.sql.Date(dateChooserPersonalAlta.getDate().getTime()).toLocalDate();}catch(Exception ee){tmp=true;}
				//System.out.println(new java.sql.Date(dateChooserPersonalAlta.getDate().getTime()).toLocalDate());
				if(cont&&tmp){
					cont=false;txt="Introduce una fecha de nacimiento";
				}
				if(cont){
					if(new BD_Usuario("mysql-properties.xml").altaUsuario(
							new Usuario(
									(String)comboBoxPersonalAltaTipo.getSelectedItem(),
									txtPersonalAltaNomUsuario.getText(),
									new String(passwordPersonalAlta1.getPassword()),
									Parking.usuarioConectado.getCodGaraje(),
									txtPersonalAltaNombre.getText(),
									(txtPersonalAltaApellidos.getText()),
									new java.sql.Date(dateChooserPersonalAlta.getDate().getTime()).toLocalDate(),//dateChooserPersonalAlta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
									(txtPersonalAltaDireccion.getText()),
									Integer.parseInt(txtPersonalAltaTelefono.getText())
							))==1){//(String s)
						lblAltaPersonalProTip.setForeground(new Color(75,255,75));
						lblAltaPersonalProTip.setText("¡Todo en orden!");
						//Se borra todo el texto
						txtPersonalAltaNomUsuario.setText("");
						passwordPersonalAlta1.setText("");
						passwordPersonalAlta2.setText("");
						txtPersonalAltaNombre.setText("");
						txtPersonalAltaApellidos.setText("");
						dateChooserPersonalAlta.setDate(null);
						txtPersonalAltaDireccion.setText("");
						txtPersonalAltaTelefono.setText("");
					}else{
						lblAltaPersonalProTip.setForeground(new Color(255,75,75));
						lblAltaPersonalProTip.setText("La información no es válida");
					}
				}else{
					lblAltaPersonalProTip.setForeground(new Color(225,155,25));
					lblAltaPersonalProTip.setText(txt);
				}
			}
		});
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
		
		/**/
		
		/**/
		//	DUPLICADO TARJETA
		/**/
		
		panelDuplicadoTarjeta.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelDuplicadoTarjeta.setLayout(null);
		
		JLabel lblDuplicadoTarjetaIdentificacion = new JLabel("<html>\r\n\t<h3>Identificaci\u00F3n de tarjeta perdida</h3>\r\n</html>");
		lblDuplicadoTarjetaIdentificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuplicadoTarjetaIdentificacion.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblDuplicadoTarjetaIdentificacion.setBounds(304, 11, 333, 50);
		panelDuplicadoTarjeta.add(lblDuplicadoTarjetaIdentificacion);
		
		btnDuplicadoTarjetaProceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelDuplicadoTarjetaBorrarTodo(true);
				lblDuplicadoTarjetaFinalProTip.setVisible(true);
				btnDuplicadoTarjetaFinalProTipOcultar.setVisible(true);
				new BD_Tarjeta("mysql-properties.xml").desvalidarTarjeta(tarjetaAAunlar.getNumAbonado());
			}
		});
		btnDuplicadoTarjetaProceder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDuplicadoTarjetaProceder.setBackground(new Color(240, 255, 240));
		btnDuplicadoTarjetaProceder.setBounds(830, 290, 100, 25);
		panelDuplicadoTarjeta.add(btnDuplicadoTarjetaProceder);
		
		btnDuplicadoTarjetaCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelDuplicadoTarjetaBorrarTodo(true);
			}
		});
		btnDuplicadoTarjetaCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDuplicadoTarjetaCancelar.setBackground(new Color(255, 192, 203));
		btnDuplicadoTarjetaCancelar.setBounds(720, 290, 100, 25);
		panelDuplicadoTarjeta.add(btnDuplicadoTarjetaCancelar);
		
		lblDuplicadoTarjetaAnulacionDuplicado.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuplicadoTarjetaAnulacionDuplicado.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblDuplicadoTarjetaAnulacionDuplicado.setBounds(651, 11, 333, 50);
		panelDuplicadoTarjeta.add(lblDuplicadoTarjetaAnulacionDuplicado);
		
		lblDuplicadoTarjetaDibujoTop.setVerticalAlignment(SwingConstants.TOP);
		lblDuplicadoTarjetaDibujoTop.setBounds(725, 100, 194, 124);
		panelDuplicadoTarjeta.add(lblDuplicadoTarjetaDibujoTop);
		
		lblDuplicadoTarjetaDibujo.setVerticalAlignment(SwingConstants.TOP);
		lblDuplicadoTarjetaDibujo.setIcon(new ImageIcon(Principal.class.getResource("/Recursos/iconos/magnetic-stripe-recorted.png")));
		lblDuplicadoTarjetaDibujo.setBounds(725, 100, 194, 124);
		panelDuplicadoTarjeta.add(lblDuplicadoTarjetaDibujo);
		
		lblDuplicadoTarjetaFinalProTip.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDuplicadoTarjetaFinalProTip.setOpaque(true);
		lblDuplicadoTarjetaFinalProTip.setBackground(Color.LIGHT_GRAY);
		lblDuplicadoTarjetaFinalProTip.setVerticalAlignment(SwingConstants.TOP);
		lblDuplicadoTarjetaFinalProTip.setBounds(651, 335, 333, 112);
		panelDuplicadoTarjeta.add(lblDuplicadoTarjetaFinalProTip);
		
		btnDuplicadoTarjetaFinalProTipOcultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDuplicadoTarjetaFinalProTip.setVisible(false);
				btnDuplicadoTarjetaFinalProTipOcultar.setVisible(false);
			}
		});
		btnDuplicadoTarjetaFinalProTipOcultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDuplicadoTarjetaFinalProTipOcultar.setBounds(651, 447, 333, 20);
		btnDuplicadoTarjetaFinalProTipOcultar.setBackground(SystemColor.controlHighlight);
		panelDuplicadoTarjeta.add(btnDuplicadoTarjetaFinalProTipOcultar);
		
		
		lblDuplicadoTarjetaConfirmacion.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblDuplicadoTarjetaConfirmacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuplicadoTarjetaConfirmacion.setBounds(648, 252, 336, 30);
		lblDuplicadoTarjetaConfirmacion.setBackground(Color.LIGHT_GRAY);
		panelDuplicadoTarjeta.add(lblDuplicadoTarjetaConfirmacion);
		
		JPanel panelDuplicadoTarjetaForm = new JPanel();
		panelDuplicadoTarjetaForm.setBounds(305, 64, 333, 432);
		panelDuplicadoTarjetaForm.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelDuplicadoTarjeta.add(panelDuplicadoTarjetaForm);
		panelDuplicadoTarjetaForm.setLayout(null);
		
		JLabel lblDuplicadoTarjetaFormCodGaraje = new JLabel("C\u00F3digo de Garaje");
		lblDuplicadoTarjetaFormCodGaraje.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblDuplicadoTarjetaFormCodGaraje.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuplicadoTarjetaFormCodGaraje.setBounds(2, 10, 329, 30);
		panelDuplicadoTarjetaForm.add(lblDuplicadoTarjetaFormCodGaraje);
		
		txtDuplicadoTarjetaFormCodGaraje = new JTextField();
		txtDuplicadoTarjetaFormCodGaraje.setHorizontalAlignment(SwingConstants.CENTER);
		txtDuplicadoTarjetaFormCodGaraje.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtDuplicadoTarjetaFormCodGaraje.setBounds(50, 50, 233, 30);
		panelDuplicadoTarjetaForm.add(txtDuplicadoTarjetaFormCodGaraje);
		txtDuplicadoTarjetaFormCodGaraje.setColumns(10);
		
		JLabel lblDuplicadoTarjetaFormNumPlaza = new JLabel("N\u00FAmero de Plaza");
		lblDuplicadoTarjetaFormNumPlaza.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblDuplicadoTarjetaFormNumPlaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuplicadoTarjetaFormNumPlaza.setBounds(2, 90, 329, 30);
		panelDuplicadoTarjetaForm.add(lblDuplicadoTarjetaFormNumPlaza);
		
		txtDuplicadoTarjetaFormNumPlaza = new JTextField();
		txtDuplicadoTarjetaFormNumPlaza.setHorizontalAlignment(SwingConstants.CENTER);
		txtDuplicadoTarjetaFormNumPlaza.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtDuplicadoTarjetaFormNumPlaza.setBounds(50, 130, 233, 30);
		panelDuplicadoTarjetaForm.add(txtDuplicadoTarjetaFormNumPlaza);
		txtDuplicadoTarjetaFormNumPlaza.setColumns(10);
		
		JLabel lblDuplicadoTarjetaFormDNI = new JLabel("DNI Titular");
		lblDuplicadoTarjetaFormDNI.setFont(new Font("Rockwell", Font.PLAIN, 15));
		lblDuplicadoTarjetaFormDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuplicadoTarjetaFormDNI.setBounds(2, 170, 329, 30);
		panelDuplicadoTarjetaForm.add(lblDuplicadoTarjetaFormDNI);
		
		txtDuplicadoTarjetaFormDNI = new JTextField();
		txtDuplicadoTarjetaFormDNI.setHorizontalAlignment(SwingConstants.CENTER);
		txtDuplicadoTarjetaFormDNI.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtDuplicadoTarjetaFormDNI.setBounds(50, 210, 233, 30);
		panelDuplicadoTarjetaForm.add(txtDuplicadoTarjetaFormDNI);
		txtDuplicadoTarjetaFormDNI.setColumns(10);
		
		JSeparator separatorDuplicadoTarjetaForm1 = new JSeparator();
		separatorDuplicadoTarjetaForm1.setBounds(2, 260, 329, 2);
		panelDuplicadoTarjetaForm.add(separatorDuplicadoTarjetaForm1);
		
		lblDuplicadoTarjetaFormProTip.setForeground(new Color(75,75,75));
		lblDuplicadoTarjetaFormProTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuplicadoTarjetaFormProTip.setBounds(2, 260, 329, 52);
		panelDuplicadoTarjetaForm.add(lblDuplicadoTarjetaFormProTip);
		
		JSeparator separatorDuplicadoTarjetaForm2 = new JSeparator();
		separatorDuplicadoTarjetaForm2.setBounds(2, 310, 329, 2);
		panelDuplicadoTarjetaForm.add(separatorDuplicadoTarjetaForm2);
		
		JButton btnDuplicadoTarjetaFormCancelar = new JButton("Borrar");
		btnDuplicadoTarjetaFormCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelDuplicadoTarjetaBorrarTodo(true);
			}
		});
		btnDuplicadoTarjetaFormCancelar.setBackground(new Color(169, 169, 169));
		btnDuplicadoTarjetaFormCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDuplicadoTarjetaFormCancelar.setBounds(50, 334, 233, 30);
		panelDuplicadoTarjetaForm.add(btnDuplicadoTarjetaFormCancelar);
		
		JButton btnDuplicadoTarjetaFormAceptar = new JButton("Pedir Duplicado");
		btnDuplicadoTarjetaFormAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelDuplicadoTarjetaBorrarTodo(false);
				boolean proceder=true;
				String txt="";
				if(proceder&&(txtDuplicadoTarjetaFormCodGaraje.getText().equals("")||txtDuplicadoTarjetaFormNumPlaza.getText().equals("")||txtDuplicadoTarjetaFormDNI.getText().equals(""))){
					txt="Completa todos los campos para continuar";proceder=false;
				}
				if(proceder&&!Validator.CodGaraje(txtDuplicadoTarjetaFormCodGaraje.getText())){
					txt="El código de garaje no tiene un formato válido";proceder=false;
				}
				if(proceder&&!Validator.NumPlaza(txtDuplicadoTarjetaFormNumPlaza.getText())){
					txt="El número de plaza no tiene un formato válido";proceder=false;
				}
				if(proceder&&!Validator.Dni(txtDuplicadoTarjetaFormDNI.getText())){
					txt="El DNI del titular no tiene un formato válido";proceder=false;
				}
				if(proceder){
					tarjetaAAunlar=new BD_Tarjeta("mysql-properties.xml").existenciaTarjeta(Integer.parseInt(txtDuplicadoTarjetaFormCodGaraje.getText()), Integer.parseInt(txtDuplicadoTarjetaFormNumPlaza.getText()), txtDuplicadoTarjetaFormDNI.getText());
					if(tarjetaAAunlar.isValida()){
						lblDuplicadoTarjetaFormProTip.setText("Tarjeta Válida");
						lblDuplicadoTarjetaFormProTip.setForeground(new Color(75,150,75));
						lblDuplicadoTarjetaAnulacionDuplicado.setVisible(true);
						lblDuplicadoTarjetaDibujoTop.setVisible(true);
						lblDuplicadoTarjetaDibujo.setVisible(true);
						lblDuplicadoTarjetaConfirmacion.setVisible(true);
						btnDuplicadoTarjetaCancelar.setVisible(true);
						btnDuplicadoTarjetaProceder.setVisible(true);
					}else{
						lblDuplicadoTarjetaFormProTip.setText("La tarjeta indicada no existe o no esta activa");
						lblDuplicadoTarjetaFormProTip.setForeground(new Color(255,75,75));
					}
				}else{
					lblDuplicadoTarjetaFormProTip.setText(txt);
					lblDuplicadoTarjetaFormProTip.setForeground(new Color(225,155,25));
				}
			}
		});
		btnDuplicadoTarjetaFormAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDuplicadoTarjetaFormAceptar.setBounds(50, 381, 233, 40);
		panelDuplicadoTarjetaForm.add(btnDuplicadoTarjetaFormAceptar);
		
		JLabel lblDuplicadoTarjetaDescripcion = new JLabel("<html>\r\n\t<h3>Descripci\u00F3n</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">El panel de duplicado de tarjeta permite <b>anular</b> y <b>solicitar un duplicado</b> de una tarjeta extraviada</p>\r\n\t<h3>Utilizaci\u00F3n</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">Se deben introducir datos v\u00E1lidos para solicitar un duplicado, todos los campos son obligatorios.\r\n</p>\r\n\t<h3>Precauciones</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">Una vez anulada una tarjeta desde este panel, deber\u00E1 acudir a la oficina del parking presentando documnetaci\u00F3n v\u00E1lida como su DNI, y en un periodo de 2 horas recibir\u00E1 su duplicado.</p>\r\n</html>");
		lblDuplicadoTarjetaDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDuplicadoTarjetaDescripcion.setBounds(10, 64, 285, 432);
		panelDuplicadoTarjeta.add(lblDuplicadoTarjetaDescripcion);
		
		JLabel lblDuplicadoTarjetaTitle = new JLabel("<html>\r\n\t<h2>Duplicado de Tarjeta</h2>\r\n</html>");
		lblDuplicadoTarjetaTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuplicadoTarjetaTitle.setBounds(10, 11, 284, 50);
		panelDuplicadoTarjeta.add(lblDuplicadoTarjetaTitle);
		
		btnDuplicadoTarjetaFormCancelar.setFocusPainted(false);
		btnDuplicadoTarjetaFormAceptar.setFocusPainted(false);
		btnDuplicadoTarjetaCancelar.setFocusPainted(false);
		btnDuplicadoTarjetaProceder.setFocusPainted(false);
		btnDuplicadoTarjetaFinalProTipOcultar.setFocusPainted(false);
		
		/**/
		
		/**/
		//Generar XML
		/**/
		
		
		panelGenerar.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGenerar.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGenerar.setLayout(null);
		
		panelGenerar.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGenerar.setLayout(null);
		panelGenerar.setLayout(null);
		
		JLabel lblGenerarGenerar = new JLabel("<html>\r\n\t<h2>Generar</h2>\r\n</html>");
		lblGenerarGenerar.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblGenerarGenerar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarGenerar.setBounds(651, 11, 333, 50);
		panelGenerar.add(lblGenerarGenerar);
		
		JLabel lblGenerarPreferencias = new JLabel("<html>\r\n\t<h2>Preferencias</h2>\r\n</html>");
		lblGenerarPreferencias.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarPreferencias.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		lblGenerarPreferencias.setBounds(304, 11, 333, 50);
		panelGenerar.add(lblGenerarPreferencias);
		
		JPanel panelGenerarPreferencias = new JPanel();
		panelGenerarPreferencias.setLayout(null);
		panelGenerarPreferencias.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelGenerarPreferencias.setBackground(SystemColor.controlHighlight);
		panelGenerarPreferencias.setBounds(305, 64, 333, 383);
		panelGenerar.add(panelGenerarPreferencias);
		
		JLabel lblGenerarPreferenciasTitle1 = new JLabel("<html><div style=\"font-weight:bold;\">&nbsp;&nbsp;&nbsp;<span>Nombre del Archivo</span></div></html>");
		lblGenerarPreferenciasTitle1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenerarPreferenciasTitle1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarPreferenciasTitle1.setOpaque(true);
		lblGenerarPreferenciasTitle1.setBackground(new Color(169, 169, 169));
		lblGenerarPreferenciasTitle1.setBounds(2, 2, 329, 30);
		panelGenerarPreferencias.add(lblGenerarPreferenciasTitle1);
		
		rdbtnGenerarPreferenciasNomDef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGenerarPreferenciasNomOtro.setEnabled(false);
			}
		});
		rdbtnGenerarPreferenciasNomDef.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnGenerarPreferenciasNomDef.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnGenerarPreferenciasNomDef.setFocusPainted(false);
		rdbtnGenerarPreferenciasNomDef.setSelected(true);
		rdbtnGenerarPreferenciasNomDef.setBackground(SystemColor.controlHighlight);
		rdbtnGenerarPreferenciasNomDef.setBounds(20, 50, 303, 25);
		panelGenerarPreferencias.add(rdbtnGenerarPreferenciasNomDef);
		
		JRadioButton rdbtnGenerarPreferenciasNomOtro = new JRadioButton("<html><b>Otro</b>:</html>");
		rdbtnGenerarPreferenciasNomOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGenerarPreferenciasNomOtro.setEnabled(true);
			}
		});
		rdbtnGenerarPreferenciasNomOtro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnGenerarPreferenciasNomOtro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnGenerarPreferenciasNomOtro.setFocusPainted(false);
		rdbtnGenerarPreferenciasNomOtro.setBackground(SystemColor.controlHighlight);
		rdbtnGenerarPreferenciasNomOtro.setBounds(20, 90, 100, 25);
		panelGenerarPreferencias.add(rdbtnGenerarPreferenciasNomOtro);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnGenerarPreferenciasNomDef);
	    group.add(rdbtnGenerarPreferenciasNomOtro);

		txtGenerarPreferenciasNomOtro.setToolTipText("Nombre del empleado");
		txtGenerarPreferenciasNomOtro.setBounds(123, 90, 200, 25);
		panelGenerarPreferencias.add(txtGenerarPreferenciasNomOtro);
		txtGenerarPreferenciasNomOtro.setColumns(10);
		txtGenerarPreferenciasNomOtro.setEnabled(false);
		
		JLabel lblGenerarPreferenciasTitle2 = new JLabel("<html><div style=\"font-weight:bold;\">&nbsp;&nbsp;&nbsp;<span>HTML</span></div></html>");
		lblGenerarPreferenciasTitle2.setOpaque(true);
		lblGenerarPreferenciasTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarPreferenciasTitle2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenerarPreferenciasTitle2.setBackground(new Color(169, 169, 169));
		lblGenerarPreferenciasTitle2.setBounds(2, 130, 329, 30);
		panelGenerarPreferencias.add(lblGenerarPreferenciasTitle2);
		
		JCheckBox chckbxGenerarPreferenciasGenHTML = new JCheckBox("<html>Generar un documento HTML</html>");
		chckbxGenerarPreferenciasGenHTML.setSelected(true);
		chckbxGenerarPreferenciasGenHTML.setFocusPainted(false);
		chckbxGenerarPreferenciasGenHTML.setBackground(SystemColor.controlHighlight);
		chckbxGenerarPreferenciasGenHTML.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chckbxGenerarPreferenciasGenHTML.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGenerarPreferenciasGenHTML.setBounds(12, 170, 311, 30);
		panelGenerarPreferencias.add(chckbxGenerarPreferenciasGenHTML);
		
		JLabel lblGenerarPreferenciasSkinHTML = new JLabel("<html>Estilo <span style=\"color:gray;\">/</span> Skin</html>");
		lblGenerarPreferenciasSkinHTML.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGenerarPreferenciasSkinHTML.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarPreferenciasSkinHTML.setBounds(2, 210, 111, 30);
		panelGenerarPreferencias.add(lblGenerarPreferenciasSkinHTML);
		
		JComboBox<String> comboBoxGenerarPreferenciasSkinHTML = new JComboBox<String>();
		comboBoxGenerarPreferenciasSkinHTML.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxGenerarPreferenciasSkinHTML.setToolTipText("Seleccionar skin del documento html, cambiar\u00E1 la apariencia(colores) de el documento.");
		comboBoxGenerarPreferenciasSkinHTML.setModel(new DefaultComboBoxModel<String>(new String[] {"  Por Defecto", "  Nocturno"}));
		comboBoxGenerarPreferenciasSkinHTML.setBounds(115, 210, 200, 30);
		comboBoxGenerarPreferenciasSkinHTML.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGenerarPreferencias.add(comboBoxGenerarPreferenciasSkinHTML);
		
		JLabel lblGenerarPreferenciasTitle3 = new JLabel("<html><div style=\"font-weight:bold;\">&nbsp;&nbsp;&nbsp;<span>Otros</span></div></html>");
		lblGenerarPreferenciasTitle3.setOpaque(true);
		lblGenerarPreferenciasTitle3.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarPreferenciasTitle3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenerarPreferenciasTitle3.setBackground(new Color(169, 169, 169));
		lblGenerarPreferenciasTitle3.setBounds(2, 260, 329, 30);
		panelGenerarPreferencias.add(lblGenerarPreferenciasTitle3);
		
		JCheckBox chckbxGenerarPreferenciasOverwrite = new JCheckBox("<html>Sobreescribir archivos</html>");
		chckbxGenerarPreferenciasOverwrite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chckbxGenerarPreferenciasOverwrite.setSelected(true);
		chckbxGenerarPreferenciasOverwrite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGenerarPreferenciasOverwrite.setFocusPainted(false);
		chckbxGenerarPreferenciasOverwrite.setBackground(SystemColor.controlHighlight);
		chckbxGenerarPreferenciasOverwrite.setBounds(12, 300, 311, 30);
		panelGenerarPreferencias.add(chckbxGenerarPreferenciasOverwrite);
		
		JCheckBox chckbxGenerarPreferenciasSacar = new JCheckBox("<html>Sacar usuarios de todos los garajes (superusuario)</html>");
		chckbxGenerarPreferenciasSacar.setEnabled(false);
		chckbxGenerarPreferenciasSacar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxGenerarPreferenciasSacar.setFocusPainted(false);
		chckbxGenerarPreferenciasSacar.setBackground(SystemColor.controlHighlight);
		chckbxGenerarPreferenciasSacar.setBounds(12, 335, 311, 30);
		panelGenerarPreferencias.add(chckbxGenerarPreferenciasSacar);
		
		JLabel lblGenerar = new JLabel("<html>\r\n\t<h1><b>Generar Fichero XML</b></h1>\r\n</html>");
		lblGenerar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerar.setBounds(10, 11, 282, 50);
		panelGenerar.add(lblGenerar);
		
		JLabel lblGenerarDescripcion = new JLabel("<html>\r\n\t<h3>Descripci\u00F3n</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">Este panel permite generar ficheros que continen la informaci\u00F3n del personal del parking que diriges.</p>\r\n\t<h3>Utilizaci\u00F3n</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">El proceso es autom\u00E1tico, solo necesitas seleccionar las preferencias y los ficheros se generar\u00E1s de forma autom\u00E1tica:\r\n</p>\r\n\t<h3>Precauciones</h3>\r\n\t<p style=\"margin:10px;text-align:justify;\">No podr\u00E1s acceder a los datos de los usuarios de otro parking, ni a las contrase\u00F1as de ning\u00FAn usuario por motivos de seguridad. Si seleccionas la opci\u00F3n de sobreescribir archivo, se sustituir\u00E1 por completo el archivo con ese nombre.</p>\r\n</html>");
		lblGenerarDescripcion.setToolTipText("Datos generales sobre el panel de personal");
		lblGenerarDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblGenerarDescripcion.setBounds(20, 67, 272, 429);
		panelGenerar.add(lblGenerarDescripcion);
		
		JCheckBox chckbxGenerarIncAdm = new JCheckBox("<html>Incluir <b>Administradores</b></html>");
		chckbxGenerarIncAdm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chckbxGenerarIncAdm.setSelected(true);
		chckbxGenerarIncAdm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGenerarIncAdm.setFocusPainted(false);
		chckbxGenerarIncAdm.setBackground(SystemColor.control);
		chckbxGenerarIncAdm.setBounds(710, 75, 250, 30);
		panelGenerar.add(chckbxGenerarIncAdm);
		
		JCheckBox chckbxGenerarIncMec = new JCheckBox("<html>Incluir <b>Mecanicos</b></html>");
		chckbxGenerarIncMec.setSelected(true);
		chckbxGenerarIncMec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGenerarIncMec.setFocusPainted(false);
		chckbxGenerarIncMec.setBackground(SystemColor.menu);
		chckbxGenerarIncMec.setBounds(710, 108, 250, 30);
		chckbxGenerarIncMec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGenerar.add(chckbxGenerarIncMec);
		
		JCheckBox chckbxGenerarIncLim = new JCheckBox("<html>Incluir <b>Personal de Limpieza</b></html>");
		chckbxGenerarIncLim.setSelected(true);
		chckbxGenerarIncLim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGenerarIncLim.setFocusPainted(false);
		chckbxGenerarIncLim.setBackground(SystemColor.menu);
		chckbxGenerarIncLim.setBounds(710, 141, 250, 30);
		chckbxGenerarIncLim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGenerar.add(chckbxGenerarIncLim);
		
		JCheckBox chckbxGenerarIncSeg = new JCheckBox("<html>Incluir <b>Personal de Seguridad</b></html>");
		chckbxGenerarIncSeg.setSelected(true);
		chckbxGenerarIncSeg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxGenerarIncSeg.setFocusPainted(false);
		chckbxGenerarIncSeg.setBackground(SystemColor.menu);
		chckbxGenerarIncSeg.setBounds(710, 174, 250, 30);
		chckbxGenerarIncSeg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelGenerar.add(chckbxGenerarIncSeg);
		
		JButton btnGenerarGenerar = new JButton("Generar");
		btnGenerarGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String preffilename;
				if(rdbtnGenerarPreferenciasNomDef.isSelected()) preffilename=preffilenamedef;
				else preffilename=txtGenerarPreferenciasNomOtro.getText();
				int errorCode=Xml.crearXmlPlantilla(
						preffilename,
						chckbxGenerarPreferenciasGenHTML.isSelected(),
						comboBoxGenerarPreferenciasSkinHTML.getSelectedIndex()+1,
						chckbxGenerarPreferenciasOverwrite.isSelected(),
						chckbxGenerarIncAdm.isSelected(),
						chckbxGenerarIncMec.isSelected(),
						chckbxGenerarIncLim.isSelected(),
						chckbxGenerarIncSeg.isSelected()
					);
				String txt="";
				switch(errorCode){
					case 0:
						lblGenerarCredits.setVisible(true);
						btnGenerarOcultar.setVisible(true);
						lblGenerarProTip.setVisible(false);
						break;
					case 1:txt="Error al crear el archivo";break;
					case 2:txt="No se ha podido crear el directorio /Personal/";break;
					case 3:txt="No se pueden sobreescribir los archivos";break;
					case 4:txt="Error al crear el archivo";break;
					case 5:txt="Usuario Inválido";break;
					case 6:txt="Introduce un nombre de archivo";break;
					default:txt="Error Desconocido";break;
				}
				if(errorCode!=0){
					lblGenerarCredits.setVisible(false);
					btnGenerarOcultar.setVisible(false);
					lblGenerarProTip.setVisible(true);
					lblGenerarProTip.setText(txt);
				}
			}
		});
		btnGenerarGenerar.setFocusPainted(false);
		btnGenerarGenerar.setBackground(SystemColor.info);
		btnGenerarGenerar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerarGenerar.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnGenerarGenerar.setBounds(675, 225, 275, 40);
		panelGenerar.add(btnGenerarGenerar);
		
		lblGenerarCredits.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGenerarCredits.setOpaque(true);
		lblGenerarCredits.setBackground(new Color(169, 169, 169));
		lblGenerarCredits.setVerticalAlignment(SwingConstants.TOP);
		lblGenerarCredits.setBounds(675, 285, 275, 125);
		lblGenerarCredits.setVisible(false);
		panelGenerar.add(lblGenerarCredits);
		
		lblGenerarProTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarProTip.setOpaque(true);
		lblGenerarProTip.setBackground(new Color(240, 128, 128));
		lblGenerarProTip.setBounds(675, 285, 275, 30);
		lblGenerarProTip.setVisible(false);
		panelGenerar.add(lblGenerarProTip);
		
		btnGenerarOcultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGenerarCredits.setVisible(false);
				btnGenerarOcultar.setVisible(false);
			}
		});
		btnGenerarOcultar.setFocusPainted(false);
		btnGenerarOcultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGenerarOcultar.setBackground(new Color(211, 211, 211));
		btnGenerarOcultar.setBounds(675, 410, 275, 20);
		btnGenerarOcultar.setVisible(false);
		panelGenerar.add(btnGenerarOcultar);
		
		/**/
		
		reset();
	}
	
	public static void reset(){
		PanelDuplicadoTarjetaBorrarTodo(true);
		PanelBajaBorrarTodo();
		txtPersonalAltaNUsuario.setText("");
	}
	
	public static void setUtil(Boolean x){
		
		reset();
		
		//Visual
		
		panelGris.setVisible(!x);
		cabecera.setVisible(x);
		tabbedPane.setVisible(x);
		
		//Paneles
		
		if(Parking.TOKEN!=null){
			tabbedPane.removeAll();
			//System.out.println(Parking.TOKEN);
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
							comboBoxPersonalAltaGaraje.setModel(new DefaultComboBoxModel<Object>(new String[] {""+Parking.usuarioConectado.getCodGaraje()}));
							tabbedPane.addTab(" Generar XML ", null, panelGenerar, "Generar archivos XML y HTML opcionalmente");
							preffilenamedef="Personal_Parking_"+Parking.usuarioConectado.getCodGaraje();
							rdbtnGenerarPreferenciasNomDef.setText("<html><b>Por Defecto</b>:&nbsp;&nbsp;&nbsp;<span style=\"color:gray\">Personal_Parking_"+Parking.usuarioConectado.getCodGaraje()+"</span></html>");
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
					tabbedPane.addTab(" Duplicado de Tarjeta ", null, panelDuplicadoTarjeta, "Anula una tarjeta extraviada y pide un duplicado");
					break;
				default:
					System.out.println("INVALID TOKEN!: "+Parking.TOKEN);
					break;
			}
		}
		
	}
	public static void PanelBajaBorrarTodo(){
		lblAltaPersonalProTip.setText("Completa el formulario para continuar");
		lblAltaPersonalProTip.setForeground(new Color(75,75,75));
		
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
	public static void PanelDuplicadoTarjetaBorrarTodo(boolean borrarTexto){
		if(borrarTexto){
			txtDuplicadoTarjetaFormCodGaraje.setText("");
			txtDuplicadoTarjetaFormNumPlaza.setText("");
			txtDuplicadoTarjetaFormDNI.setText("");
			lblDuplicadoTarjetaFormProTip.setText("Introduce los datos para continuar");
			lblDuplicadoTarjetaFormProTip.setForeground(new Color(75,75,75));
		}
		lblDuplicadoTarjetaAnulacionDuplicado.setVisible(false);
		lblDuplicadoTarjetaDibujoTop.setVisible(false);
		lblDuplicadoTarjetaDibujo.setVisible(false);
		btnDuplicadoTarjetaFinalProTipOcultar.setVisible(false);
		lblDuplicadoTarjetaFinalProTip.setVisible(false);
		lblDuplicadoTarjetaConfirmacion.setVisible(false);
		btnDuplicadoTarjetaCancelar.setVisible(false);
		btnDuplicadoTarjetaProceder.setVisible(false);
	}
}
