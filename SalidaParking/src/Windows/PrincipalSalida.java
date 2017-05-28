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
import Items.Plazas;
import Items.Tarjetas;
import Items.Validaciones;
import Main.Salida;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Cursor;
import java.awt.Toolkit;

import javax.swing.JSeparator;

public class PrincipalSalida extends JFrame {

	/**
	 * 
	 */
	public static Plazas plaz=new Plazas();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JPanel panelPortada = new JPanel();
	public static JPanel panelEstandar = new JPanel();
	public static JPanel panelAbonado = new JPanel();
	public static JTextField txtSalidaAbonadoCodAbonado;
	public static JTextField txtSalidaAbonadoDNI;
	public static JButton btnNewButton;
	public static JLabel lblSalidaAbonadoProTip = new JLabel("Introduzca sus datos");
	public static JLabel lblSalidaAbonadoHastaLaProximaChao = new JLabel("<html>\r\n\t<br><br>\r\n\t<h1 style=\"text-align:center\">\u00A1Gracias por su visita!</h1>\r\n\t<br><br>\r\n\t<h3 style=\"text-align:center\">Los recargos de los servicios contratados se a\u00F1adir\u00E1n a su cuota mensual</h3>\r\n</html>");
	private JButton btnSalidaAbonadoSalir;
	public static JButton btnSalidaAtras = new JButton("Atr\u00E1s");
	public static JButton btnSalida0Atras = new JButton("Atr\u00E1s");
	public static JTextField txtSalidaEstandarCodTicket;
	public static  JTextField txtSalidaEstandarMatricula;
	public static JSeparator separatorSalidaEstandar1 = new JSeparator();
	public static JLabel lblSalidaEstandarPrecio = new JLabel("<html>&nbsp;&nbsp;<span style=\"font-size:15px;\">Estancia + <span style=\"font-size:17px;font-weight:bold;\">X</span> servicios: <span style=\"font-size:17px;font-weight:bold;\">12,34</sppan>\u20AC</span></html>");
	public static JButton btnSalidaEstandarPago2 = new JButton("<html><h4>Pagar</h4></html>");
	public static JSeparator separatorSalidaEstandar2 = new JSeparator();
	public static JLabel lblSalidaEstandarGraciasPorTuVisita = new JLabel("<html><h2>Gracias por tu visita!</h2><br>\r\n<span>Esperamos volver a verle pronto</span></html>");
	public static JLabel lblSalidaEstandarProTip = new JLabel("Completa los campos para continuar");
	public static JButton btnSalidaEstandarBorrar = new JButton("Borrar");
	public static JButton btnSalidaEstandarPago = new JButton("Proceder al pago");
	/**
	 * Launch the application.
	 */
	public static void abrir() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalSalida frame = new PrincipalSalida();
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
	public PrincipalSalida() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalSalida.class.getResource("/Recursos/iconos/northlogo_default.png")));
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
		
		JButton btnNewButton = new JButton("Salida Est\u00E1ndar");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		
		String descParking=new BD_Garaje("mysql-properties.xml").descGaraje(Salida.PARKING);
		JLabel lblNewLabel = new JLabel("<html><h1 style=\"font-size:32px;\">Salida del Parking</h1><br><h3>Parking: <b style=\"font-weight:bolder\">"+descParking+"</b></h3></html>");
		lblNewLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 494, 230);
		panelPortada.add(lblNewLabel);
		
		/**/
		
		panelEstandar.setBackground(new Color(255, 228, 196));
		
		panelEstandar.setLayout(null);
		panelEstandar.setBounds(0, 0, 494, 472);
		contentPane.add(panelEstandar);
		
		JLabel lblSalidaEstandarCodTicket = new JLabel("C\u00F3digo de Ticket");
		lblSalidaEstandarCodTicket.setFont(new Font("Consolas", Font.BOLD, 15));
		lblSalidaEstandarCodTicket.setBounds(50, 20, 150, 30);
		panelEstandar.add(lblSalidaEstandarCodTicket);
		
		txtSalidaEstandarCodTicket = new JTextField();
		txtSalidaEstandarCodTicket.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtSalidaEstandarCodTicket.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalidaEstandarCodTicket.setBounds(250, 20, 200, 30);
		panelEstandar.add(txtSalidaEstandarCodTicket);
		txtSalidaEstandarCodTicket.setColumns(10);
		
		JLabel lblSalidaEstandarMatricula = new JLabel("Matricula");
		lblSalidaEstandarMatricula.setFont(new Font("Consolas", Font.BOLD, 15));
		lblSalidaEstandarMatricula.setBounds(50, 70, 150, 30);
		panelEstandar.add(lblSalidaEstandarMatricula);
		
		txtSalidaEstandarMatricula = new JTextField();
		txtSalidaEstandarMatricula.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtSalidaEstandarMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalidaEstandarMatricula.setBounds(250, 70, 200, 30);
		panelEstandar.add(txtSalidaEstandarMatricula);
		txtSalidaEstandarMatricula.setColumns(10);
		
		lblSalidaEstandarProTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaEstandarProTip.setOpaque(true);
		lblSalidaEstandarProTip.setBackground(new Color(109, 109, 109));
		lblSalidaEstandarProTip.setForeground(new Color(190,190,190));
		lblSalidaEstandarProTip.setBounds(30, 120, 420, 30);
		panelEstandar.add(lblSalidaEstandarProTip);
		
		btnSalidaEstandarBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(2);
			}
		});
		btnSalidaEstandarBorrar.setFocusPainted(false);
		btnSalidaEstandarBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalidaEstandarBorrar.setBackground(new Color(211, 211, 211));
		btnSalidaEstandarBorrar.setBounds(30, 170, 125, 30);
		panelEstandar.add(btnSalidaEstandarBorrar);
		
		btnSalidaEstandarPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean cont=true;
				String txt="";
				if(cont&&(txtSalidaEstandarMatricula.getText().equals("")||txtSalidaEstandarCodTicket.getText().equals(""))){
					cont=false;txt="Ningun campo puede estar vacio";
				}
				if(cont&&!Validaciones.CodTicket(txtSalidaEstandarCodTicket.getText())){
					cont=false;txt="Formato de Cod. Ticket inválido";
				}
				if(cont&&!Validaciones.Matricula(txtSalidaEstandarMatricula.getText())){
					cont=false;txt="Formato de Matricula inválido";
				}
				if(cont){
					plaz=new BD_Plazas("mysql-properties.xml").validarPlaza(txtSalidaEstandarMatricula.getText(),Integer.parseInt(txtSalidaEstandarCodTicket.getText()));
					if(plaz.isActiva()){
						//new BD_Plazas("mysql-properties.xml").salir(plaz);
						lblSalidaEstandarProTip.setText("¡Datos Correctos!");
						lblSalidaEstandarProTip.setForeground(new Color(70,150,70));
						lblSalidaEstandarPrecio.setText("<html>&nbsp;&nbsp;<span style=\"font-size:15px;\">Estancia + <span style=\"font-size:17px;font-weight:bold;\">X</span> servicios: <span style=\"font-size:17px;font-weight:bold;\">12,34</sppan>\u20AC</span></html>");
						lblSalidaEstandarPrecio.setVisible(true);
						btnSalidaEstandarPago2.setVisible(true);
						separatorSalidaEstandar1.setVisible(true);
						btnSalida0Atras.setEnabled(false);
					}else{
						lblSalidaEstandarProTip.setText("¡Datos Incorrectos!");
						lblSalidaEstandarProTip.setForeground(new Color(200,100,100));
					}
				}else{
					lblSalidaEstandarProTip.setText(txt);
					lblSalidaEstandarProTip.setForeground(new Color(225,155,25));
				}
			}
		});
		btnSalidaEstandarPago.setFocusPainted(false);
		btnSalidaEstandarPago.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalidaEstandarPago.setBackground(new Color(144, 238, 144));
		btnSalidaEstandarPago.setBounds(175, 170, 275, 30);
		panelEstandar.add(btnSalidaEstandarPago);
		
		separatorSalidaEstandar1.setBounds(0, 222, 494, 2);
		panelEstandar.add(separatorSalidaEstandar1);
		
		lblSalidaEstandarPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaEstandarPrecio.setBounds(0, 222, 375, 60);
		panelEstandar.add(lblSalidaEstandarPrecio);
		
		btnSalidaEstandarPago2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSalidaEstandarCodTicket.setEnabled(false);
				txtSalidaEstandarMatricula.setEnabled(false);
				btnSalidaEstandarBorrar.setEnabled(false);
				btnSalidaEstandarPago.setEnabled(false);
				btnSalidaEstandarPago2.setEnabled(false);
				separatorSalidaEstandar2.setVisible(true);
				lblSalidaEstandarGraciasPorTuVisita.setVisible(true);
				new BD_Plazas("mysql-properties.xml").salir(plaz);
				plaz=new Plazas();
			}
		});
		btnSalidaEstandarPago2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalidaEstandarPago2.setBackground(new Color(255, 255, 224));
		btnSalidaEstandarPago2.setBounds(390, 237, 89, 30);
		btnSalidaEstandarPago2.setFocusPainted(false);
		panelEstandar.add(btnSalidaEstandarPago2);
		
		separatorSalidaEstandar2.setBounds(0, 282, 494, 2);
		panelEstandar.add(separatorSalidaEstandar2);
		
		lblSalidaEstandarGraciasPorTuVisita.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				try {
					Thread.sleep(4500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				reset(1);
			}
		});
		lblSalidaEstandarGraciasPorTuVisita.setOpaque(true);
		lblSalidaEstandarGraciasPorTuVisita.setBackground(new Color(211, 211, 211));
		lblSalidaEstandarGraciasPorTuVisita.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaEstandarGraciasPorTuVisita.setBounds(10, 293, 474, 140);
		panelEstandar.add(lblSalidaEstandarGraciasPorTuVisita);
		
		btnSalida0Atras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalida0Atras.setFocusPainted(false);
		btnSalida0Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(1);
			}
		});
		btnSalida0Atras.setBackground(new Color(255, 250, 205));
		btnSalida0Atras.setBounds(190, 440, 110, 25);
		panelEstandar.add(btnSalida0Atras);
		/**/
		
		panelAbonado.setBackground(new Color(220, 220, 220));
		
		panelAbonado.setLayout(null);
		panelAbonado.setBounds(0, 0, 494, 472);
		contentPane.add(panelAbonado);
		
		JLabel lblSalidaAbonadoTitle = new JLabel("Introduzca c\u00F3digo de abonado");
		lblSalidaAbonadoTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblSalidaAbonadoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaAbonadoTitle.setBounds(0, 0, 494, 90);
		panelAbonado.add(lblSalidaAbonadoTitle);
		
		JLabel lblSalidaAbonadoCodAbonado = new JLabel("Cod. Abonado");
		lblSalidaAbonadoCodAbonado.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblSalidaAbonadoCodAbonado.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaAbonadoCodAbonado.setBounds(10, 101, 224, 30);
		panelAbonado.add(lblSalidaAbonadoCodAbonado);
		
		txtSalidaAbonadoCodAbonado = new JTextField();
		txtSalidaAbonadoCodAbonado.setFont(new Font("Consolas", Font.PLAIN, 15));
		txtSalidaAbonadoCodAbonado.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalidaAbonadoCodAbonado.setBounds(256, 101, 200, 30);
		panelAbonado.add(txtSalidaAbonadoCodAbonado);
		txtSalidaAbonadoCodAbonado.setColumns(10);
		
		JLabel lblSalidaAbonadoDNI = new JLabel("DNI");
		lblSalidaAbonadoDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaAbonadoDNI.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblSalidaAbonadoDNI.setBounds(10, 141, 224, 30);
		panelAbonado.add(lblSalidaAbonadoDNI);
		
		txtSalidaAbonadoDNI = new JTextField();
		txtSalidaAbonadoDNI.setHorizontalAlignment(SwingConstants.CENTER);
		txtSalidaAbonadoDNI.setFont(new Font("Consolas", Font.PLAIN, 15));
		txtSalidaAbonadoDNI.setColumns(10);
		txtSalidaAbonadoDNI.setBounds(256, 142, 200, 30);
		panelAbonado.add(txtSalidaAbonadoDNI);
		
		lblSalidaAbonadoProTip.setOpaque(true);
		lblSalidaAbonadoProTip.setBackground(new Color(109, 109, 109));
		lblSalidaAbonadoProTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaAbonadoProTip.setBounds(10, 182, 224, 30);
		panelAbonado.add(lblSalidaAbonadoProTip);
		
		btnSalidaAbonadoSalir = new JButton("Salir de Parking");
		btnSalidaAbonadoSalir.setFocusPainted(false);
		btnSalidaAbonadoSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalidaAbonadoSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean cont=true;
				String txt="";
				if(cont&&(txtSalidaAbonadoCodAbonado.getText().equals("")||txtSalidaAbonadoDNI.getText().equals(""))){
					cont=false;txt="No puede quedar ningun campo vacio";
				}
				if(cont&&!Validaciones.CodAbonado(txtSalidaAbonadoCodAbonado.getText())){
					cont=false;txt="Formato de Cod. Abonado inválido";
				}
				if(cont&&!Validaciones.Dni(txtSalidaAbonadoDNI.getText())){
					cont=false;txt="Formato de DNI inválido";
				}
				if(cont){
					Tarjetas tarj=new BD_Tarjeta("mysql-properties.xml").validarTarjeta(Integer.parseInt(txtSalidaAbonadoCodAbonado.getText()), txtSalidaAbonadoDNI.getText());
					if(tarj.isValida()){
						txtSalidaAbonadoCodAbonado.setEnabled(false);
						txtSalidaAbonadoDNI.setEnabled(false);
						btnSalidaAtras.setEnabled(false);
						lblSalidaAbonadoHastaLaProximaChao.setVisible(true);
						lblSalidaAbonadoProTip.setText("Tarjeta aceptada");
						lblSalidaAbonadoProTip.setForeground(new Color(70,150,70));
						new BD_Plazas("mysql-properties.xml").salirA(tarj);
						plaz=new Plazas();
					}else{
						lblSalidaAbonadoProTip.setText("La tarjeta indicada no es válida");
						lblSalidaAbonadoProTip.setForeground(new Color(200,100,100));
					}
				}else{
					lblSalidaAbonadoProTip.setText(txt);
					lblSalidaAbonadoProTip.setForeground(new Color(225,155,25));
				}
			}
		});
		btnSalidaAbonadoSalir.setBounds(256, 183, 200, 29);
		panelAbonado.add(btnSalidaAbonadoSalir);
		
		lblSalidaAbonadoHastaLaProximaChao.addComponentListener(new ComponentAdapter() {
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
		lblSalidaAbonadoHastaLaProximaChao.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaAbonadoHastaLaProximaChao.setVerticalAlignment(SwingConstants.TOP);
		lblSalidaAbonadoHastaLaProximaChao.setBounds(10, 234, 474, 227);
		panelAbonado.add(lblSalidaAbonadoHastaLaProximaChao);
		btnSalidaAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalidaAtras.setFocusPainted(false);
		btnSalidaAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(1);
			}
		});
		btnSalidaAtras.setBackground(new Color(255, 250, 205));
		btnSalidaAtras.setBounds(190, 440, 110, 25);
		
		panelAbonado.add(btnSalidaAtras);
		/**/
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
				txtSalidaEstandarMatricula.setText("");
				txtSalidaEstandarCodTicket.setText("");
				panelEstandar.setVisible(true);
				separatorSalidaEstandar1.setVisible(false);
				lblSalidaEstandarPrecio.setVisible(false);
				btnSalidaEstandarPago2.setVisible(false);
				separatorSalidaEstandar2.setVisible(false);
				lblSalidaEstandarGraciasPorTuVisita.setVisible(false);
				lblSalidaEstandarProTip.setForeground(new Color(190,190,190));
				lblSalidaEstandarProTip.setText("Completa los campos para continuar");

				txtSalidaEstandarCodTicket.setEnabled(true);
				txtSalidaEstandarMatricula.setEnabled(true);
				btnSalidaEstandarBorrar.setEnabled(true);
				btnSalidaEstandarPago.setEnabled(true);
				btnSalidaEstandarPago2.setEnabled(true);
				
				btnSalida0Atras.setEnabled(true);
				break;
			case 3:
				panelAbonado.setVisible(true);
				lblSalidaAbonadoHastaLaProximaChao.setVisible(false);
				lblSalidaAbonadoProTip.setForeground(new Color(190,190,190));
				lblSalidaAbonadoProTip.setText("Introduzca sus datos");
				txtSalidaAbonadoCodAbonado.setEnabled(true);
				txtSalidaAbonadoDNI.setEnabled(true);
				txtSalidaAbonadoCodAbonado.setText("");
				txtSalidaAbonadoDNI.setText("");
				btnSalidaAtras.setEnabled(true);
				break;
		}
	}
}
