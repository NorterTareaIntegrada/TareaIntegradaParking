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

public class Principal extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static Principal frame;
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	public static JPanel panelGris = new JPanel();
	public static JPanel cabecera = new JPanel();
	//Less important
	public static JLabel lblMsgBienvenida = new JLabel("   \u00A1 Bienvenido  !");
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
		changePasswordButton.setBounds(689, 8, 170, 24);
		cabecera.add(changePasswordButton);
		
		lblMsgBienvenida.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 15));
		lblMsgBienvenida.setBounds(0, 0, 350, 40);
		cabecera.add(lblMsgBienvenida);
		
		panelGris.setBackground(new Color(102, 102, 102));
		panelGris.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		panelGris.setBounds(0, 0, 994, 572);
		contentPane.add(panelGris);
		panelGris.setLayout(null);
		
		tabbedPane.setBounds(0, 40, 994, 532);
		contentPane.add(tabbedPane);
		
		JPanel panel0 = new JPanel();
		tabbedPane.addTab("Funcionalidad 1", null, panel0, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Funcionalidad 2", null, panel_1, null);
	}
	public static void setUtil(Boolean x){
		panelGris.setVisible(!x);
		cabecera.setVisible(x);
		tabbedPane.setVisible(x);
	}
}
