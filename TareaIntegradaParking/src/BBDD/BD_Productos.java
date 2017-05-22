package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Items.Productos;

public class BD_Productos extends BBDD_Connector{
		private static Statement s;	
		private static ResultSet reg;
	public BD_Productos(String bbdd) {
			super(bbdd);
			// TODO Auto-generated constructor stub
		}
	public  Vector<Productos> listado(String producto){
		String cadenaSQL="SELECT * from producto'";
		Vector<Productos> ListaProductos=new Vector<Productos>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				ListaProductos.add(new Productos(reg.getString("CodProducto"),reg.getString("CodServicio"),reg.getString("CodServicio"),reg.getDouble("unidades"),reg.getDouble("MaxUnidades"),reg.getDouble("PrecioUnidad")));
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
