package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import BBDD.BD_Garaje;
import BBDD.BD_Plazas;
import BBDD.BD_Tarjeta;
import Items.Generador;
import Items.Tarjetas;
import Items.Validaciones;
import Main.Entrada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Cursor;
import java.awt.Toolkit;

public class PrincipalEntrada extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JPanel panelPortada = new JPanel();
	public static JPanel panelEstandar = new JPanel();
	public static JPanel panelAbonado = new JPanel();
	public static JLabel lblNewLabelasdf = new JLabel("<html>\r\n\t<h1><br><br>Disfrute de su estancia</h1>\r\n\t<br>\r\n\t<h4>Si lo desea puede contratar servicios extra durante su estancia</h4>\r\n\t<br><br><br>\r\n\t<h3>\r\n\t<table>\r\n\t\t<tr style=\"font-size:20px;\"><td>Matricula:</td><td><b>1234</b></td></tr>\r\n\t\t<tr style=\"font-size:20px;\"><td>Cod. Ticket:&nbsp;&nbsp;&nbsp;</td><td><b>1234</b></td></tr>\r\n\t</table>\r\n\t</h3>\r\n</html>");
	public static JTextField textCodAbonado;
	public static JTextField textDNI;
	public static JButton btnNewButton;
	public static JLabel lblAbonadoProTip = new JLabel("Introduzca sus datos");
	public static JLabel lblNewLabel_4 = new JLabel("<html>\r\n\t<br><br>\r\n\t<h1>\u00A1Bienvenido!</h1>\r\n\t<br><br>\r\n\t<h3>Continue a la plaza x</h3>\r\n</html>");
	private JButton btnNewButton_2;
	public static JButton btnNewButton_3 = new JButton("Atr\u00E1s");
	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalEntrada frame = new PrincipalEntrada();
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
	public PrincipalEntrada() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalEntrada.class.getResource("/Recursos/iconos/northlogo_default.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelPortada.setBackground(new Color(119, 136, 153));
		panelPortada.setBounds(0, 0, 494, 472);
		contentPane.add(panelPortada);
		panelPortada.setLayout(null);
		
		JButton btnNewButton = new JButton("Entrada Est\u00E1ndar");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mat=Generador.matricula();
				int cod_t=Generador.codTicket();
				lblNewLabelasdf.setText("<html>\r\n\t<h1><br><br>Disfrute de su estancia</h1>\r\n\t<br>\r\n\t<h4>Si lo desea puede contratar servicios extra durante su estancia</h4>\r\n\t<br><br><br>\r\n\t<h3>\r\n\t<table>\r\n\t\t<tr style=\"font-size:20px;\"><td>Matricula:</td><td><b>"+mat+"</b></td></tr>\r\n\t\t<tr style=\"font-size:20px;\"><td>Cod. Ticket:&nbsp;&nbsp;&nbsp;</td><td><b>"+cod_t+"</b></td></tr>\r\n\t</table>\r\n\t</h3>\r\n</html>");
				new BD_Plazas("mysql-properties.xml").aparcarEstandar(mat, cod_t);
				reset(2);
			}
		});
		btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		btnNewButton.setBounds(100, 240, 300, 50);
		panelPortada.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Soy Abonado");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(3);
			}
		});
		btnNewButton_1.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(224, 255, 255));
		btnNewButton_1.setBounds(100, 330, 300, 50);
		panelPortada.add(btnNewButton_1);
		
		
		String descParking=new BD_Garaje("mysql-properties.xml").descGaraje(Entrada.PARKING);
		JLabel lblNewLabel = new JLabel("<html><h1 style=\"font-size:32px;\">Entrada a Parking</h1><br><h3>Parking: <b style=\"font-weight:bolder\">"+descParking+"</b></h3></html>");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 494, 230);
		panelPortada.add(lblNewLabel);
		
		/**/
		panelEstandar.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					Thread.sleep(4500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				reset(1);
			}
		});
		
		
		panelEstandar.setBackground(new Color(255, 228, 196));
		
		panelEstandar.setLayout(null);
		panelEstandar.setBounds(0, 0, 494, 472);
		contentPane.add(panelEstandar);
		lblNewLabelasdf.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabelasdf.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabelasdf.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabelasdf.setBounds(0, 0, 494, 472);
		
		panelEstandar.add(lblNewLabelasdf);
		
		/**/
		panelAbonado.setBackground(new Color(220, 220, 220));
		
		panelAbonado.setLayout(null);
		panelAbonado.setBounds(0, 0, 494, 472);
		contentPane.add(panelAbonado);
		
		JLabel lblNewLabel_2 = new JLabel("Introduzca c\u00F3digo de abonado");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 494, 90);
		panelAbonado.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Cod. Abonado");
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 101, 224, 30);
		panelAbonado.add(lblNewLabel_1);
		
		textCodAbonado = new JTextField();
		textCodAbonado.setFont(new Font("Consolas", Font.PLAIN, 15));
		textCodAbonado.setHorizontalAlignment(SwingConstants.CENTER);
		textCodAbonado.setBounds(256, 101, 200, 30);
		panelAbonado.add(textCodAbonado);
		textCodAbonado.setColumns(10);
		
		JLabel lblMatricula = new JLabel("DNI");
		lblMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricula.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblMatricula.setBounds(10, 141, 224, 30);
		panelAbonado.add(lblMatricula);
		
		textDNI = new JTextField();
		textDNI.setHorizontalAlignment(SwingConstants.CENTER);
		textDNI.setFont(new Font("Consolas", Font.PLAIN, 15));
		textDNI.setColumns(10);
		textDNI.setBounds(256, 142, 200, 30);
		panelAbonado.add(textDNI);
		
		lblAbonadoProTip.setOpaque(true);
		lblAbonadoProTip.setBackground(new Color(109, 109, 109));
		lblAbonadoProTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbonadoProTip.setBounds(10, 182, 224, 30);
		panelAbonado.add(lblAbonadoProTip);
		
		btnNewButton_2 = new JButton("Acceder");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean cont=true;
				String txt="";
				if(cont&&(textCodAbonado.getText().equals("")||textDNI.getText().equals(""))){
					cont=false;txt="No puede quedar ningun campo vacio";
				}
				if(cont&&!Validaciones.CodAbonado(textCodAbonado.getText())){
					cont=false;txt="Formato de Cod. Abonado inválido";
				}
				if(cont&&!Validaciones.Dni(textDNI.getText())){
					cont=false;txt="Formato de DNI inválido";
				}
				if(cont){
					Tarjetas tarj=new BD_Tarjeta("mysql-properties.xml").validarTarjeta(Integer.parseInt(textCodAbonado.getText()), textDNI.getText());
					if(tarj.isValida()){
						textCodAbonado.setEnabled(false);
						textDNI.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						lblNewLabel_4.setVisible(true);
						lblNewLabel_4.setText("<html>\r\n\t<br><br>\r\n\t<h1>\u00A1Bienvenido!</h1>\r\n\t<br><br>\r\n\t<h3>Continue a la plaza <b>"+tarj.getNumPlaza()+"</b></h3>\r\n</html>");
						lblAbonadoProTip.setText("Tarjeta aceptada");
						lblAbonadoProTip.setForeground(new Color(70,150,70));
						new BD_Plazas("mysql-properties.xml").aparcarAbonado(tarj);
					}else{
						lblAbonadoProTip.setText("La tarjeta indicada no es válida");
						lblAbonadoProTip.setForeground(new Color(200,100,100));
					}
				}else{
					lblAbonadoProTip.setText(txt);
					lblAbonadoProTip.setForeground(new Color(225,155,25));
				}
			}
		});
		btnNewButton_2.setBounds(256, 183, 200, 29);
		panelAbonado.add(btnNewButton_2);
		
		lblNewLabel_4.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				try {
					Thread.sleep(4500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				reset(1);
			}
		});
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setBounds(10, 234, 474, 227);
		panelAbonado.add(lblNewLabel_4);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(1);
			}
		});
		btnNewButton_3.setBackground(new Color(255, 250, 205));
		btnNewButton_3.setBounds(190, 440, 110, 25);
		
		panelAbonado.add(btnNewButton_3);
		
		reset(1);
	}
	public static void reset(int x){
		panelPortada.setVisible(false);
		panelEstandar.setVisible(false);
		panelAbonado.setVisible(false);
		switch(x){
			case 1:
				panelPortada.setVisible(true);
				break;
			case 2:
				panelEstandar.setVisible(true);
				break;
			case 3:
				textCodAbonado.setText("");
				textDNI.setText("");
				textCodAbonado.setEnabled(true);
				textDNI.setEnabled(true);
				btnNewButton_3.setEnabled(true);
				panelAbonado.setVisible(true);
				lblNewLabel_4.setVisible(false);
				lblAbonadoProTip.setText("Introduzca sus datos");
				lblAbonadoProTip.setForeground(new Color(190,190,190));
				break;
		}
	}
}
