package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;

import BBDD.BBDD_Connector;
import Windows.*;

/**
 * Programa de salida del parking
 * @author Norter S.L.
 * @version 1.0
 */

public class Salida {
	
	
	public static Scanner in=new Scanner(System.in);
	public static BBDD_Connector bd;
	
	public static final int PARKING=1;
	
	public static int ContCarga;
	public static boolean CargaAcabada;
	public static boolean errConBBDD;
	public static String msgErrBBDD;
	public static boolean reiniciar;
	
	public static void main(String[] args){
		while(programa(args));
	}
	/**
	 * Funcion que actua como un main, contenido dentro de otro main en forma de bucle
	 * @param args Son los mismos parametros que los de la funcion main
	 * @return Retorna en funci�n de si ha ocurrido un error al conectarse a la BBDD
	 */
	public static boolean programa(String[] args){

		ContCarga=-25;
		CargaAcabada=false;
		
		errConBBDD=false;
		Cargador.abrir(100);
		Timer cargaInicial=new Timer(1,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!errConBBDD)ContCarga++;
				if(ContCarga==20){
					bd=new BBDD_Connector("mysql-properties.xml");
					if(errConBBDD){
						ContCarga++;
						Cargador.errConBBDD(msgErrBBDD);
					}
				}
				if(!errConBBDD)Cargador.setCarga(ContCarga);
				if(ContCarga>100&&!errConBBDD) CargaAcabada=true;
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
		PrincipalSalida.abrir();
		return false;
	}
}