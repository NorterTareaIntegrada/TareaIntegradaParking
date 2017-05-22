package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import BBDD.BD_Usuario;
import Items.Usuario;
import Main.Parking;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Login frame;
	public static JPanel contentPane;
		public static JPanel panelPrincipal = new JPanel();
		public static JPanel panelClientes = new JPanel();
		public static JTextField usernameField;
		public static JPasswordField passwordField;
		public static JButton button_id = new JButton("Identificarse");
		public static JButton button_delete = new JButton("Borrar");
		public static JSeparator separator_bot = new JSeparator();
		public static JSeparator separator_mid = new JSeparator();
		public static JLabel label_password = new JLabel("Contrase\u00F1a");
		public static JSeparator separator_top = new JSeparator();
		public static JLabel label_username = new JLabel("Nombre de Usuario");
		public static JLabel lblProTip = new JLabel("Rellena los campos para continuar");
	public static JPanel panelCargando = new JPanel();
	private final JLabel lblCargando = new JLabel("Un momento...");
	private final JButton btnAreaDeClientes = new JButton("Area de Clientes");
	private final JSeparator separator_mid_2 = new JSeparator();
	private final JButton btnDuplicado = new JButton("Pedir duplicado de tarjeta");
	private final JPanel panelEstandar = new JPanel();
	private final JPanel panelAbonados = new JPanel();
	private final JTextField txtNAbonado = new JTextField();
	private final JTextField txtDNI = new JTextField();
	private final JLabel lblNAbonado = new JLabel("N\u00BA Abonado");
	private final JLabel lblDNI = new JLabel("DNI");
	private final JButton btnAbonados = new JButton("Acceder");
	private final JButton btnBorrar = new JButton("Borrar");
	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(Principal.frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		txtDNI.setBounds(85, 90, 160, 35);
		txtDNI.setColumns(10);
		txtNAbonado.setBounds(85, 40, 160, 35);
		txtNAbonado.setColumns(10);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cargador.class.getResource("/Recursos/iconos/northlogo_default.png")));
		setResizable(false);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(Cargador.class.getResource("/north2.png")));
		setTitle("Identificaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 261, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelPrincipal.setBounds(0, 0, 255, 313);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		separator_top.setBounds(0, 55, 255, 2);
		panelPrincipal.add(separator_top);
		
		label_username.setBounds(0, 55, 255, 40);
		label_username.setHorizontalAlignment(SwingConstants.CENTER);
		label_username.setFont(new Font("Consolas", Font.PLAIN, 15));
		panelPrincipal.add(label_username);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Consolas", Font.PLAIN, 15));
		usernameField.setHorizontalAlignment(SwingConstants.CENTER);
		usernameField.setBounds(10, 95, 235, 30);
		usernameField.setToolTipText("Introduce aqui el nombre de usuario");
		usernameField.setColumns(10);
		panelPrincipal.add(usernameField);
		
		label_password.setBounds(0, 125, 255, 40);
		label_password.setHorizontalAlignment(SwingConstants.CENTER);
		label_password.setFont(new Font("Consolas", Font.PLAIN, 15));
		panelPrincipal.add(label_password);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Consolas", Font.PLAIN, 15));
		passwordField.setBounds(10, 165, 235, 30);
		passwordField.setToolTipText("Introduce aqui la contrase\u00F1a");
		panelPrincipal.add(passwordField);
		
		separator_mid.setBounds(0, 210, 255, 1);
		panelPrincipal.add(separator_mid);
		
		separator_bot.setBounds(0, 250, 255, 1);
		panelPrincipal.add(separator_bot);
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usernameField.setText("");
				passwordField.setText("");
			}
		});
		
		button_delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_delete.setBounds(10, 262, 85, 40);
		button_delete.setToolTipText("Borrar los campos");
		button_delete.setFont(new Font("Consolas", Font.PLAIN, 12));
		button_delete.setBackground(new Color(211, 211, 211));
		panelPrincipal.add(button_delete);
		
		button_id.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(usernameField.getText().equals("")||passwordField.getText().equals("")){
					lblProTip.setText("¡Ningun campo puede estar vacio!");
					lblProTip.setForeground(new Color(225,155,25));
				}else{
					lblProTip.setText("Cargando...");
					lblProTip.setForeground(new Color(225,155,25));
					panelPrincipal.setVisible(false);
					panelCargando.setVisible(true);
				}
			}
		});
		button_id.setBounds(113, 262, 132, 40);
		panelPrincipal.add(button_id);
		button_id.setToolTipText("Identificarse");
		button_id.setFont(new Font("Consolas", Font.PLAIN, 12));
		
		lblProTip.setForeground(new Color(75,75,75));
		lblProTip.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblProTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblProTip.setBounds(0, 210, 255, 40);
		panelPrincipal.add(lblProTip);
		btnAreaDeClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAreaDeClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelPrincipal.setVisible(false);
				panelClientes.setVisible(true);
			}
		});
		btnAreaDeClientes.setBounds(10, 11, 235, 33);
		
		panelPrincipal.add(btnAreaDeClientes);
		
		panelCargando.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){}
				Usuario uSu= new BD_Usuario("mysql-properties.xml").validarLogin(usernameField.getText(),passwordField.getText());
				if(uSu.isVerificado()){
					Parking.usuarioConectado=uSu;
					lblProTip.setText("¡Login Correcto!");
					lblProTip.setForeground(new Color(75,255,75));
					panelPrincipal.setVisible(true);
					panelCargando.setVisible(false);
					try{
						Thread.sleep(750);
					}catch(InterruptedException e){}
					Principal.frame.setEnabled(true);
					Principal.setUtil(true);
					Login.frame.dispose();
				}else{
					lblProTip.setText("¡Login Incorrecto!");
					lblProTip.setForeground(new Color(255,75,75));
				}
				panelPrincipal.setVisible(true);
				panelCargando.setVisible(false);
			}
		});
		
		panelClientes.setBounds(0, 0, 255, 313);
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);
		
		JButton btnAreaDePersonal = new JButton("Area de Personal");
		btnAreaDePersonal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAreaDePersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(true);
				panelClientes.setVisible(false);
			}
		});
		btnAreaDePersonal.setBounds(10, 11, 235, 33);
		panelClientes.add(btnAreaDePersonal);
		
		JTabbedPane tabbedPaneInsideClientes = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneInsideClientes.setBounds(0, 50, 255, 263);
		panelClientes.add(tabbedPaneInsideClientes);
		
		tabbedPaneInsideClientes.addTab(" Usuario Est\u00E1ndar", null, panelEstandar, null);
		panelEstandar.setLayout(null);
		
		tabbedPaneInsideClientes.addTab(" Usuario Abonado ", null, panelAbonados, "Identificate como usuario abonado o pide un duplicado de tarjeta");
		panelAbonados.setLayout(null);
		btnDuplicado.setBounds(10, 5, 230, 20);
		panelAbonados.add(btnDuplicado);
		btnDuplicado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		separator_mid_2.setBounds(0, 30, 255, 2);
		panelAbonados.add(separator_mid_2);
		
		panelAbonados.add(txtNAbonado);
		lblNAbonado.setBounds(10, 40, 74, 35);
		
		panelAbonados.add(lblNAbonado);
		
		panelAbonados.add(txtDNI);
		lblDNI.setBounds(10, 90, 74, 35);
		
		panelAbonados.add(lblDNI);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtDNI.setText("");
				txtNAbonado.setText("");
			}
		});
		btnBorrar.setBounds(10, 189, 81, 36);
		panelAbonados.add(btnBorrar);
		btnAbonados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aqui se validan los abonados
			}
		});
		btnAbonados.setBounds(113, 189, 128, 36);
		
		panelAbonados.add(btnAbonados);
		
		JSeparator separator_abonado_1 = new JSeparator();
		separator_abonado_1.setBounds(0, 135, 250, 2);
		panelAbonados.add(separator_abonado_1);
		
		JSeparator separator_abonado_2 = new JSeparator();
		separator_abonado_2.setBounds(0, 180, 250, 2);
		panelAbonados.add(separator_abonado_2);
		
		JLabel lblAbonadoProTip = new JLabel("Introduce N\u00BA Abonado y DNI");
		lblAbonadoProTip.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblAbonadoProTip.setForeground(new Color(75,75,75));
		lblAbonadoProTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbonadoProTip.setBounds(0, 140, 250, 35);
		panelAbonados.add(lblAbonadoProTip);
		panelCargando.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		
		panelCargando.setBounds(0, 0, 255, 313);
		contentPane.add(panelCargando);
		panelCargando.setLayout(null);

		lblCargando.setForeground(new Color(255, 140, 0));
		lblCargando.setFont(new Font("Consolas", Font.PLAIN, 15));
		lblCargando.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargando.setBounds(0, 288, 255, 30);
		panelCargando.add(lblCargando);
		
		JLabel lblLoagingIcon = new JLabel("");
		lblLoagingIcon.setIcon(new ImageIcon(Login.class.getResource("/Recursos/iconos/cargando_adjusted.png")));
		lblLoagingIcon.setBounds(67, 90, 120, 120);
		panelCargando.add(lblLoagingIcon);
		
		//Fin de la construcción
		panelCargando.setVisible(false);
		panelClientes.setVisible(false);
	}
	public static void reset(){
		frame.setLocationRelativeTo(Principal.frame);
		lblProTip.setText("Se ha cerrado la sesión");
		passwordField.setText("");
		frame.setVisible(true);
	}
}
