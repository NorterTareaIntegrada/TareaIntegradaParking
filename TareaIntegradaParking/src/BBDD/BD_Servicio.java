package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;
import items.Servicios;


public class BD_Servicio extends BBDD_Connector {

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Servicio(String bbdd){
		super(bbdd);
	}	
	
	public  Vector<Servicios> listadoServicios(String Servicios){
		String cadenaSQL="SELECT * from servicios WHERE nombre='"+Servicios+"'";
		Vector<Servicios> listaServicios=new Vector<Servicios>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaServicios.add(new Servicios(reg.getString("codigo"),reg.getString("nombre"),reg.getString("descripcion")));
				
			}
			s.close();
			this.cerrar();
			return listaServicios;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	


}
