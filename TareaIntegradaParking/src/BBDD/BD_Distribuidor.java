package BBDD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Main.*;
import Items.Distribuidor;

public class BD_Distribuidor extends BBDD_Connector {
	private static Statement s;	
	private static ResultSet reg;

	public BD_Distribuidor(String bbdd) {
		super(bbdd);
		// TODO Auto-generated constructor stub
	}
	public  Vector<Distribuidor> listado(String producto){
		String cadenaSQL="SELECT * from productos WHERE nombre='"+producto+"'";
		Vector<Distribuidor> ListaProductos=new Vector<Distribuidor>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				ListaProductos.add(new Distribuidor(reg.getString("Cod"),reg.getString("Nombre"),reg.getString("Correo"),reg.getString("Direccion")));
			}
			s.close();
			this.cerrar();
			return ListaProductos;
		}
		catch ( SQLException e){		
			return null;			
		}
	}

}
