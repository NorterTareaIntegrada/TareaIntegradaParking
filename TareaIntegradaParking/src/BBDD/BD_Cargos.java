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

}
