package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import Recursos.*;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Cargador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static Cargador frame;
	public static JProgressBar progressBar = new JProgressBar();
	public static JLabel lblNewLabel = new JLabel("");
	public static JLabel lblCargando = new JLabel("Cargando...");
	private final JLabel lblNorterSl = new JLabel("NORTER S.L.");
	public static void abrir(int tam) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Cargador(tam);
					frame.setLocationRelativeTo(null);
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
	public Cargador(int tam) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cargador.class.getResource("/Recursos/iconos/northlogo_default.png")));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNorterSl.setVerticalAlignment(SwingConstants.TOP);
		lblNorterSl.setHorizontalAlignment(SwingConstants.LEFT);
		lblNorterSl.setFont(new Font("Impact", Font.PLAIN, 15));
		lblNorterSl.setBounds(10, 11, 117, 85);
		
		contentPane.add(lblNorterSl);
		
		lblCargando.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargando.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCargando.setBounds(184, 237, 87, 25);
		
		contentPane.add(lblCargando);
		
		progressBar.setMinimum(0);
		progressBar.setMaximum(tam);
		progressBar.setBounds(10, 264, 430, 25);
		contentPane.add(progressBar);
		lblNewLabel.setIcon(new ImageIcon(Cargador.class.getResource("/Recursos/iconos/northlogo_carga.png")));
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 430, 242);
		contentPane.add(lblNewLabel);
		//lblNewLabel.setIcon(new javax.swing.ImageIcon(Cargador.class.getResource("iconos/northlogo_default.png")));
	}
	public static void setCarga(int c){
		progressBar.setValue(c);
		String text="";
		if(c<0)text+="Iniciando";
		if(c<350&&c>=0)text="Cargando";
		if(c>=350)text+="Finalizando";
		text+=".";
		if(c%150>50)text+=".";
		if(c%150>100)text+=".";
		lblCargando.setText(text);
	}
}
