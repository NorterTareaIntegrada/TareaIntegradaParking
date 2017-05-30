package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Items.Cargos;

public class BD_Cargos extends BBDD_Connector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Cargos(String bbdd) {
		super(bbdd);
	}
	/**
	 * Funcion para listar los cargos registrados en la base de datos
	 * @return Devuelve un Vector de tipo Cargos que contiene los cargos registrados en la base de datos
	 */
	public Vector<Cargos> listadoCargos(String Cargos) {
		String cadenaSQL = "SELECT cod_garaje,num_plaza,cod_servicio FROM cargos";
		Vector<Cargos> listaCargos = new Vector<Cargos>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				listaCargos.add(new Cargos(reg.getInt(1), reg.getInt(2), reg.getInt(3)));
			}
			s.close();
			this.cerrar();
			return listaCargos;
		} catch (SQLException e) {
			return null;
		}
	}
	/**
	 * Funcion para añadir un cargo a la base de datos
	 * @param co Código de garaje en que se realiza el cargo
	 * @param nu Plaza a la que se aplica el cargo
	 * @param se Código de servicio contratado
	 * @return Devuelve un número con la cantidad de filas añadidas (1 si se ha aañadido satisfactoriamente, 0 si ha ocurrido un error)
	 */
	public int anyadirCargo(int co,int nu,int se){
		this.abrir();
		int re=0;
		try{
			re=c.createStatement().executeUpdate("INSERT INTO cargos VALUES("+co+","+nu+","+se+") ;");
		}catch(SQLException e){
			this.cerrar();
			return re;
		}
		this.cerrar();
		return re;
	}

}
