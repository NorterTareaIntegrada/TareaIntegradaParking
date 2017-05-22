package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;

import BBDD.BBDD_Connector;
import Items.Usuario;
import Windows.*;

/**
 * @descrition Programa de gestion de parking
 * @author Norter S.L.
 * @version 1.0
 */

public class Parking {
	
	
	public static Scanner in=new Scanner(System.in);
	public static BBDD_Connector bd;
	
	public static Usuario usuarioConectado = new Usuario(false);
	
	public static int ContCarga;
	public static boolean CargaAcabada;
	public static boolean errConBBDD;
	public static String msgErrBBDD;
	public static boolean reiniciar;
	
	public static void main(String[] args){
		while(programa(args));
	}
	public static boolean programa(String[] args){

		//ContCarga=-150;
		ContCarga=449;
		CargaAcabada=false;
		
		errConBBDD=false;
		Cargador.abrir(400);
		Timer cargaInicial=new Timer(1,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//System.out.println("bucle "+ContCarga);
				if(!errConBBDD)ContCarga++;
				if(ContCarga==100){
					bd=new BBDD_Connector("mysql-properties.xml");
					if(errConBBDD){
						ContCarga++;
						Cargador.errConBBDD(msgErrBBDD);
					}
				}
				if(!errConBBDD)Cargador.setCarga(ContCarga);
				if(ContCarga>450&&!errConBBDD) CargaAcabada=true;
				if(errConBBDD&&Cargador.haPulsadoReiniciar){
					reiniciar=true;
				}
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
}