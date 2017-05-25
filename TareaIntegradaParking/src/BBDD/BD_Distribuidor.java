package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Items.Distribuidor;

public class BD_Distribuidor extends BBDD_Connector {
	private static Statement s;
	private static ResultSet reg;

	public BD_Distribuidor(String bbdd) {
		super(bbdd);
		// TODO Auto-generated constructor stub
	}

	public Vector<Distribuidor> listado(String distribuidores) {
		String cadenaSQL = "SELECT cod,nombre,mail,direccion from distribuidores";
		Vector<Distribuidor> ListaDistribuidor = new Vector<Distribuidor>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				ListaDistribuidor
						.add(new Distribuidor(reg.getInt(1), reg.getString(2), reg.getString(3), reg.getString(4)));
			}
			s.close();
			this.cerrar();
			return ListaDistribuidor;
		} catch (SQLException e) {
			return null;
		}
	}

}
