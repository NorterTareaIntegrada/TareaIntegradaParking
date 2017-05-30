package Items;

import java.util.Vector;

import Windows.Principal;

public class Eventos {
	
	private static Vector<String> misEventos=new Vector<String>();
	/**
	 * Añade un evento a la lista y procede a insertar los 32 últimos elementos de la misma el el label de eventos
	 * @param text Indica el texto con formato html del que se compone el evento
	 */
	public static void addEvento(String text){
		int n=32;
		misEventos.add(text);
		String txt="<html><div style='padding:10px;text-align:justify;'>";
		if(misEventos.size() < n) {
			for(int i=0;i<misEventos.size(); i++) {
				txt+="<p>"+misEventos.get(i).toString()+"</p>";
			}
		}else{
			for(int i=misEventos.size()-n;i<misEventos.size();i++) {
				txt+="<p>"+misEventos.get(i).toString()+"</p>";
			}
		}
		txt+="</div></html>";
		Principal.lblEventos.setText(txt);
	}
}