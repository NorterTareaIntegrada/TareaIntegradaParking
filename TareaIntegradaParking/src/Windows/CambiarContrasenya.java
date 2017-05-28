package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambiarContrasenya extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static CambiarContrasenya frame;
	
	private JPanel contentPane;
	private JPasswordField passwordAntiguaField;
	private JPasswordField passwordNuevaField;
	private JPasswordField passwordNuevaValidField;

	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CambiarContrasenya();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CambiarContrasenya() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cargador.class.getResource("/Recursos/iconos/northlogo_default.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Principal.frame.setEnabled(true);
			}
		});
		setType(Type.UTILITY);
		setTitle("Cambiar Contrase\u00F1a");
		setBounds(100, 100, 300, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 284, 241);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel labelContraAntigua = new JLabel("Contrase\u00F1a Antigua");
		labelContraAntigua.setHorizontalAlignment(SwingConstants.CENTER);
		labelContraAntigua.setBounds(0, 0, 284, 30);
		panelPrincipal.add(labelContraAntigua);
		
		JLabel labelContraNueva = new JLabel("Nueva Contrase\u00F1a");
		labelContraNueva.setHorizontalAlignment(SwingConstants.CENTER);
		labelContraNueva.setBounds(0, 55, 284, 30);
		panelPrincipal.add(labelContraNueva);
		
		JLabel labelContraNuevaValid = new JLabel("Repetir Nueva Contrase\u00F1a");
		labelContraNuevaValid.setHorizontalAlignment(SwingConstants.CENTER);
		labelContraNuevaValid.setBounds(0, 110, 284, 30);
		panelPrincipal.add(labelContraNuevaValid);
		
		passwordAntiguaField = new JPasswordField();
		passwordAntiguaField.setEchoChar('#');
		passwordAntiguaField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordAntiguaField.setBounds(42, 30, 200, 25);
		panelPrincipal.add(passwordAntiguaField);
		
		passwordNuevaField = new JPasswordField();
		passwordNuevaField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordNuevaField.setBounds(42, 85, 200, 25);
		panelPrincipal.add(passwordNuevaField);
		
		passwordNuevaValidField = new JPasswordField();
		passwordNuevaValidField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordNuevaValidField.setBounds(42, 140, 200, 25);
		panelPrincipal.add(passwordNuevaValidField);
		
		JSeparator separator_top = new JSeparator();
		separator_top.setBounds(0, 175, 284, 2);
		panelPrincipal.add(separator_top);
		
		JSeparator separator_bot = new JSeparator();
		separator_bot.setBounds(0, 205, 284, 2);
		panelPrincipal.add(separator_bot);
		
		JLabel lblProTip = new JLabel("Completar los campos para continuar");
		lblProTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblProTip.setBounds(0, 176, 284, 28);
		panelPrincipal.add(lblProTip);
		
		JButton btnAplicarCambios = new JButton("Establecer Nueva Contrase\u00F1a");
		btnAplicarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(new String(passwordAntiguaField.getPassword()).equals("")||new String(passwordNuevaField.getPassword()).equals("")||new String(passwordNuevaValidField.getPassword()).equals("")){
					lblProTip.setText("Todos los campos tienen que estar rellenos");
					lblProTip.setForeground(new Color(225,155,25));
				}else if(!new String(passwordNuevaField.getPassword()).equals(new String(passwordNuevaValidField.getPassword()))){
					lblProTip.setText("�La contrase�a nueva no coincide!");
					lblProTip.setForeground(new Color(225,155,25));
				}else{
					
				}
			}
		});
		btnAplicarCambios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAplicarCambios.setBackground(new Color(204, 255, 153));
		btnAplicarCambios.setBounds(5, 210, 274, 26);
		panelPrincipal.add(btnAplicarCambios);
		
		JPanel panelCargando = new JPanel();
		panelCargando.setBounds(0, 0, 284, 366);
		contentPane.add(panelCargando);
		panelCargando.setLayout(null);
	}
}
