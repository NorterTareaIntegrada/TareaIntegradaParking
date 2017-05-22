package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Items.Tarjetas;

public class BD_Tarjeta extends BBDD_Connector{

	private static Statement s;	
	private static ResultSet reg;
	
	public BD_Tarjeta(String bbdd) {
		super(bbdd);
	}
	
	public Tarjetas validarTarjeta(int nAbonado, String dni){
		Tarjetas tarjetaReturn=new Tarjetas();
		this.abrir();
		try{
			reg=c.createStatement().executeQuery("SELECT dni,num_plaza,matricula,n_abonado,cod_garaje,activa FROM tarjetas WHERE n_abonado = '"+nAbonado+"' AND dni = '"+dni+"';");
			reg.next();
			tarjetaReturn=new Tarjetas(reg.getString(1),reg.getInt(2),reg.getString(3),reg.getInt(4),reg.getInt(5),reg.getBoolean(6));
		}
		catch(SQLException e){}
		this.cerrar();
		return tarjetaReturn;
	}
}
