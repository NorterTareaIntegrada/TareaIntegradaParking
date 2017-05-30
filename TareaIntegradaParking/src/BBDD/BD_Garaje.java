package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Items.Garaje;

public class BD_Garaje extends BBDD_Connector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Garaje(String bbdd) {
		super(bbdd);
	}
	/**
	 * Funcion para listar los garajes registrados en la base de datos
	 * @return Devuelve un Vector de tipo Garajes que contiene los garajes registrados en la base de datos
	 */
	public Vector<Garaje> listadoGaraje() {
		String cadenaSQL = "SELECT cod,direccion from garajes";
		Vector<Garaje> listaGaraje = new Vector<Garaje>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				listaGaraje.add(new Garaje(reg.getInt(1), reg.getString(2)));

			}
			s.close();
			this.cerrar();
			return listaGaraje;
		} catch (SQLException e) {
			return null;
		}
	}

}
