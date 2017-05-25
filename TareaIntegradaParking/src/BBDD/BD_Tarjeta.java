package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Items.Tarjetas;

public class BD_Tarjeta extends BBDD_Connector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Tarjeta(String bbdd) {
		super(bbdd);
	}

	public Tarjetas validarTarjeta(int nAbonado, String dni) {
		Tarjetas tarjetaReturn = new Tarjetas();
		this.abrir();
		try {
			reg = c.createStatement().executeQuery(
					"SELECT dni,num_plaza,matricula,n_abonado,cod_garaje,activa FROM tarjetas WHERE n_abonado = '"
							+ nAbonado + "' AND dni = '" + dni + "';");
			reg.next();
			tarjetaReturn = new Tarjetas(reg.getString(1), reg.getInt(2), reg.getString(3), reg.getInt(4),
					reg.getInt(5), reg.getBoolean(6));
		} catch (SQLException e) {
		}
		this.cerrar();
		return tarjetaReturn;
	}

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
