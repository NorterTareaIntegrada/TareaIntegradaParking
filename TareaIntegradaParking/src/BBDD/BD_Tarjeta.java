package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

import Items.Tarjetas;

public class BD_Tarjeta extends BBDD_Connector {

	//private static Statement s;
	private static ResultSet reg;

	public BD_Tarjeta(String bbdd) {
		super(bbdd);
	}
	/**
	 * Valida si las credenciales de una tarjeta introducidas son válidas
	 * @param nAbonado Número de abonado asignado a esa tarjeta
	 * @param dni DNI de el propietario de la tarjeta
	 * @return Si las credenciales son válidas se devuelve un objeto Tarjeta con los datos de la misma, si no lo son, se devuelve un objeto Tarjeta sin datos válidos
	 */
	public Tarjetas validarTarjeta(int nAbonado, String dni) {
		Tarjetas tarjetaReturn = new Tarjetas();
		this.abrir();
		try {
			reg = c.createStatement().executeQuery(
					"SELECT tarjetas.dni,tarjetas.num_plaza,tarjetas.matricula,tarjetas.n_abonado,tarjetas.cod_garaje,tarjetas.activa FROM tarjetas,plazas WHERE tarjetas.n_abonado = '"+nAbonado+"' AND tarjetas.dni = '"+dni+"' AND (tarjetas.cod_garaje,tarjetas.num_plaza) = (plazas.cod_garaje,plazas.num_plaza) AND plazas.matricula IS NOT NULL;;");
			reg.next();
			tarjetaReturn = new Tarjetas(reg.getString(1), reg.getInt(2), reg.getString(3), reg.getInt(4),
					reg.getInt(5), reg.getBoolean(6));
		} catch (SQLException e) {
		}
		this.cerrar();
		return tarjetaReturn;
	}
	/**
	 * Función para hacer una tarjeta no funcional en caso de pérdida
	 * @param nAbonado Número de abonado asignado ala tarjeta objetivo
	 * @return Devuelve True en caso de ser satisfactorio, False en caso de excepción
	 */
	public boolean desvalidarTarjeta(int nAbonado) {
		this.abrir();
		try {
			c.createStatement().executeUpdate("UPDATE TARJETAS SET ACTIVA = '0' WHERE n_abonado = '" + nAbonado + "';");
		} catch (SQLException e) {
			this.cerrar();
			return false;
		}
		this.cerrar();
		return true;
	}
	/**
	 * Comprueba si una tarjeta existe y no esta invalidada para pedir un duplicado
	 * @param codGaraje Código del garaje a el que pertenece la tarjeta
	 * @param numPlaza Plaza asignada a la tarjeta
	 * @param dniTitular DNI del titular de la tarjeta
	 * @return Si las credenciales son válidas se devuelve un objeto Tarjeta con los datos de la misma, si no lo son, se devuelve un objeto Tarjeta sin datos válidos
	 */
	public Tarjetas existenciaTarjeta(int codGaraje, int numPlaza, String dniTitular) {
		Tarjetas tarjetaReturn = new Tarjetas();
		this.abrir();
		try {
			reg = c.createStatement().executeQuery(
					"SELECT dni,num_plaza,matricula,n_abonado,cod_garaje,activa FROM tarjetas WHERE cod_garaje = "
							+ codGaraje + " AND num_plaza = " + numPlaza + " AND dni = '" + dniTitular + "';");
			reg.next();
			tarjetaReturn = new Tarjetas(reg.getString(1), reg.getInt(2), reg.getString(3), reg.getInt(4),
					reg.getInt(5), reg.getBoolean(6));
		} catch (SQLException e) {
		}
		this.cerrar();
		return tarjetaReturn;
	}

}
