package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;

import Windows.*;

public class Parking {
	
	
	public static Scanner in=new Scanner(System.in);
	public static int ContCarga=-150;
	public static boolean CargaAcabada=false;
	
	
	public static void main(String[] args){
		Cargador.abrir(400);
		Timer cargaInicial=new Timer(1,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ContCarga++;
				Cargador.setCarga(ContCarga);
				if(ContCarga>450) CargaAcabada=true;
			}
		});
		cargaInicial.start();
		while(!CargaAcabada){
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){}
		}
		cargaInicial.stop();
		Cargador.frame.dispose();
		Principal.abrir();
	}
	public static String[] usuarios=new String[] {"admin","user","kisko"};
	public static String[] contrasenyas=new String[] {"admin","a1234567","kiko"};
	public static boolean validarLogin(String usu,String con){
		if(buscarUsu(usu)!=-1){
			if(contrasenyas[buscarUsu(usu)].equals(con)){
				Principal.lblMsgBienvenida.setText("   \u00A1 Bienvenido "+usu+" !");
				return true;
			}
		}
		return false;
	}
	public static int buscarUsu(String usu){
		for(int i=0;i<usuarios.length;i++) if(usuarios[i].equals(usu)) return i;
		return -1;
	}
}