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

import Main.Parking;
import javax.swing.ImageIcon;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Login frame;
	public static JPanel contentPane;
		public static JComboBox comboBox = new JComboBox();
		public static JLabel label_enterAs = new JLabel("Entrar como:");
		public static JPanel panelPrincipal = new JPanel();
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
		
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setFont(new Font("Consolas", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Mec\u00E1nico", "Personal de Limpieza", "Personal de Seguridad"}));
		comboBox.setBounds(113, 14, 132, 30);
		comboBox.setToolTipText("Selecciona el tipo de usuario con el que te identificaras");
		panelPrincipal.add(comboBox);
		
		label_enterAs.setBounds(0, 13, 111, 30);
		label_enterAs.setHorizontalTextPosition(SwingConstants.CENTER);
		label_enterAs.setHorizontalAlignment(SwingConstants.CENTER);
		label_enterAs.setFont(new Font("Consolas", Font.PLAIN, 15));
		panelPrincipal.add(label_enterAs);
		
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
		
		panelCargando.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){}
				if(Parking.validarLogin(usernameField.getText(),passwordField.getText())){
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
				if(2==(2*1)){
					panelPrincipal.setVisible(true);
					panelCargando.setVisible(false);
				}
			}
		});
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
	}
	public static void reset(){
		frame.setLocationRelativeTo(Principal.frame);
		lblProTip.setText("Se ha cerrado la sesión");
		passwordField.setText("");
		frame.setVisible(true);
	}
}
