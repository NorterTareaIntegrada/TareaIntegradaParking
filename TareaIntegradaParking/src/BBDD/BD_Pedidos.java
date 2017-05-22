package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import Items.Pedidos;


public class BD_Pedidos extends BBDD_Connector {

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Pedidos(String bbdd){
		super(bbdd);
	}	
	
	public  Vector<Pedidos> listadoPedidos(String Pedidos){
		String cadenaSQL="SELECT * from pedidos WHERE nombre='"+Pedidos+"'";
		Vector<Pedidos> listaPedidos=new Vector<Pedidos>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaPedidos.add(new Pedidos(reg.getString("fecha"),reg.getString("cod_producto"),reg.getDouble("cantidad"),reg.getDouble("precio_total")));
				
			}
			s.close();
			this.cerrar();
			return listaPedidos;
		}
		catch ( SQLException e){		
			return null;			
		}
	}
	


}
