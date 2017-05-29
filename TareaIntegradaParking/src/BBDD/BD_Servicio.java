package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Items.Servicios;

public class BD_Servicio extends BBDD_Connector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Servicio(String bbdd) {
		super(bbdd);
	}

	public Vector<Servicios> listadoServicios(String Servicios) {
		String cadenaSQL = "SELECT cod,nombre,precio,descripcion from servicios";
		Vector<Servicios> listaServicios = new Vector<Servicios>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				listaServicios.add(new Servicios(reg.getInt(1), reg.getString(2), reg.getDouble(3), reg.getString(4)));
			}
			s.close();
			this.cerrar();
			return listaServicios;
		} catch (SQLException e) {
			return null;
		}
	}

}
