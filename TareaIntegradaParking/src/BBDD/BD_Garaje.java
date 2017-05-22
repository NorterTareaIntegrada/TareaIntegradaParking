package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import Items.Garaje;


public class BD_Garaje extends BBDD_Connector {

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Garaje(String bbdd){
		super(bbdd);
	}	
	
	public int daralta_Usuario ( Garaje ga){
		String cadenaSQL="INSER INTO garajes VALUES('" + ga.getCodigo() + "'," + ga.getDireccion()+"')";
	try{
	this.abrir();
	s=c.createStatement();
	int filas=s.executeUpdate(cadenaSQL);
	s.close();
	this.cerrar();
	return filas;
	}
	catch (SQLException e){
		return -1;
	}
		
		
	}
	
	
	
	public  Vector<Garaje> listadoGaraje(String Garaje){
		String cadenaSQL="SELECT * from garajes WHERE nombre='"+Garaje+"'";
		Vector<Garaje> listaGaraje=new Vector<Garaje>();
		try{
			this.abrir();
			s=c.createStatement();
			reg=s.executeQuery(cadenaSQL);
			while ( reg.next()){
				listaGaraje.add(new Garaje(reg.getString("codigo"),reg.getString("direccion")));
				
			}
			s.close();
			this.cerrar();
			return listaGaraje;
		}
		catch ( SQLException e){	
			return null;			
		}
	}
	


}
