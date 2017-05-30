package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Toolkit;

import javax.swing.JButton;

import Main.Salida;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Color;

public class Cargador extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public static Cargador frame;
	public static JProgressBar progressBar = new JProgressBar();
	public static JLabel lblNewLabel = new JLabel("");
	public static JLabel lblCargando = new JLabel("Cargando...");
	private final JLabel lblNorterSl = new JLabel("NORTER S.L.");
	public static JButton btnReiniciar = new JButton("Reiniciar");
	public static JButton btnSalir = new JButton("Salir");
	public static boolean haPulsadoReiniciar=false;
	
	/**
	 * Abre la ventana de cargador
	 * @param tam Especifica el tamaño de la barra de progreso
	 */
	
	public static void abrir(int tam) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				haPulsadoReiniciar=false;
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
	 * Constructor de la Ventana
	 * @param tam Tamaño de la barra de progreso
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
		lblCargando.setBounds(10, 237, 430, 25);
		
		contentPane.add(lblCargando);
		
		progressBar.setMinimum(0);
		progressBar.setMaximum(tam);
		progressBar.setBounds(10, 264, 430, 25);
		progressBar.setVisible(true);
		contentPane.add(progressBar);
		lblNewLabel.setIcon(new ImageIcon(Cargador.class.getResource("/Recursos/iconos/northlogo_carga.png")));
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 430, 242);
		contentPane.add(lblNewLabel);
		btnSalir.setBackground(new Color(255, 182, 193));
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(320, 264, 120, 25);
		btnSalir.setVisible(false);
		contentPane.add(btnSalir);
		btnReiniciar.setBackground(new Color(255, 250, 205));
		btnReiniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				haPulsadoReiniciar=true;
			}
		});
		btnReiniciar.setVisible(false);
		btnReiniciar.setBounds(10, 264, 120, 25);
		contentPane.add(btnReiniciar);
		//lblNewLabel.setIcon(new javax.swing.ImageIcon(Cargador.class.getResource("iconos/northlogo_default.png")));
	}
	public static void setCarga(int c){
		if(!Salida.errConBBDD)progressBar.setValue(c);
		String text="";
		if(c<0)text+="Iniciando";
		if(c<75&&c>=0)text="Cargando";
		if(c>=75)text+="Finalizando";
		text+=".";
		if(c%150>50)text+=".";
		if(c%150>100)text+=".";
		lblCargando.setText(text);
	}
	public static void errConBBDD(String msg){
		lblCargando.setText(msg);
		progressBar.setVisible(false);
		btnSalir.setVisible(true);
		btnReiniciar.setVisible(true);
	}
}
