package Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

import java.awt.Font;

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
	public static JLabel lblMsgBienvenida = new JLabel("   \u00A1 Bienvenido  !");
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
				Login.reset();
			}
		});
		closeSessionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		closeSessionButton.setBackground(new Color(204, 102, 102));
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
		changePasswordButton.setBounds(706, 8, 153, 24);
		cabecera.add(changePasswordButton);
		
		lblMsgBienvenida.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 15));
		lblMsgBienvenida.setBounds(0, 0, 350, 40);
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
		
		JLabel lblInfoContent = new JLabel("<html>\r\n<p style=\"text-align:justify;padding:15px;\">\r\nAqui aparecer\u00E1n los <b>eventos</b> mas recientes desde el inicio de la sesi\u00F3n como:<br>\r\n</p><ul>\r\n<li>Entradas y salidas del parking</li>\r\n<li style=\"color:red;\">Altas y bajas de personal</li>\r\n<li>Solicitaciones de servicios</li>\r\n<li>Pedidos realizados de forma autom\u00E1tica</li>\r\n</ul>\r\n</html>");
		lblInfoContent.setVerticalAlignment(SwingConstants.TOP);
		lblInfoContent.setBounds(10, 85, 304, 419);
		panelEventos.add(lblInfoContent);
		
		panelConsulta.setLayout(null);
	}
	public static void setUtil(Boolean x){
		
		//Visual
		
		lblMsgBienvenida.setText("   \u00A1 Bienvenido/a "+Parking.usuarioConectado.getNombreCompleto()+" !");
		//panelGris.setVisible(!x);
		cabecera.setVisible(x);
		tabbedPane.setVisible(x);
		
		//Paneles
		
		if(Parking.usuarioConectado.isVerificado()){
			tabbedPane.removeAll();
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
		}
	}
}
