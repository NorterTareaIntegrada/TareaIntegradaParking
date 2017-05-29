package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Items.Productos;

public class BD_Productos extends BBDD_Connector {
	private static Statement s;
	private static ResultSet reg;

	public BD_Productos(String bbdd) {
		super(bbdd);
		// TODO Auto-generated constructor stub
	}

	public Vector<Productos> listado() {
		String cadenaSQL = "SELECT cod, cod_servicio, cod_proveedor, nombre, descripcion, unidades, max_unidades, precio_uni from productos";
		Vector<Productos> ListaProductos = new Vector<Productos>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				ListaProductos.add(new Productos(reg.getInt(1), reg.getInt(2), reg.getInt(3), reg.getString(4),
						reg.getString(5), reg.getInt(6), reg.getInt(7), reg.getDouble("PrecioUnidad")));
			}
			s.close();
			this.cerrar();
			return ListaProductos;
		} catch (SQLException e) {
			return null;
		}
	}

}
