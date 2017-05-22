package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import Items.Cargos;


public class BD_Cargos extends BBDD_Connector {

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Cargos(String bbdd){
		super(bbdd);
	}	
	
	public  Vector<Cargos> listadoCargos(String Cargos){
		String cadenaSQL="SELECT * from cargos WHERE nombre='"+Cargos+"'";
		Vector<Cargos> listaCargos=new Vector<Cargos>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaCargos.add(new Cargos(reg.getString("cod_garaje"),reg.getString("num_plaza"),reg.getString("cod_servicio")));
				
			}
			s.close();
			this.cerrar();
			return listaCargos;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	


}
