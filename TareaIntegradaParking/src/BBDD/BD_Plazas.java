package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Items.Plazas;

public class BD_Plazas extends BBDD_Connector {
	private static Statement s;	
	private static ResultSet reg;

	public BD_Plazas(String bbdd) {
		super(bbdd);
		// TODO Auto-generated constructor stub
	}
	
	public  Vector<Plazas> listado(String plaza){
		String cadenaSQL="SELECT * from producto'";
		Vector<Plazas> ListadoPlazas=new Vector<Plazas>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				ListadoPlazas.add(new Plazas(reg.getString("CodGaraje"),reg.getString("NumPlaza"),reg.getString("NumPlanta"),reg.getDouble("Dimensiones"),reg.getString("Abonado"),reg.getString("Hora"),reg.getString("CodTicket")));
			}
			s.close();
			this.cerrar();
			return ListadoPlazas;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
}

