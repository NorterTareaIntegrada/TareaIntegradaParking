package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;

import BBDD.BBDD_Connector;
import Windows.*;

public class Parking {
	
	
	public static Scanner in=new Scanner(System.in);
	public static BBDD_Connector bd;
	
	public static int ContCarga;
	public static boolean CargaAcabada;
	public static boolean errConBBDD;
	public static String msgErrBBDD;
	public static boolean reiniciar;
	
	public static void main(String[] args){
		while(programa(args));
	}
	public static boolean programa(String[] args){
		
		ContCarga=-150;
		CargaAcabada=false;
		
		errConBBDD=false;
		Cargador.abrir(400);
		Timer cargaInicial=new Timer(1,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!errConBBDD)ContCarga++;
				if(ContCarga==100){
					bd=new BBDD_Connector("mysql-properties.xml");
					if(errConBBDD)Cargador.errConBBDD(msgErrBBDD);
				}
				if(!errConBBDD)Cargador.setCarga(ContCarga);
				if(ContCarga>450&&!errConBBDD) CargaAcabada=true;
				if(errConBBDD&&Cargador.haPulsadoReiniciar)reiniciar=true;
			}
		});
		cargaInicial.start();
		reiniciar=false;
		while(!CargaAcabada){
			if(reiniciar){
				Cargador.frame.dispose();
				cargaInicial.stop();
				return true;
				}
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){}
		}
		cargaInicial.stop();
		Cargador.frame.dispose();
		Principal.abrir();
		return false;
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