package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import Items.Pedidos;

public class BD_Pedidos extends BBDD_Connector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Pedidos(String bbdd) {
		super(bbdd);
	}

	public Vector<Pedidos> listadoPedidos(String Pedidos) {
		String cadenaSQL = "SELECT fecha,cod_producto,cantidad,prec_total from pedidos";
		Vector<Pedidos> listaPedidos = new Vector<Pedidos>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				java.sql.Date f = reg.getDate("fecha");
				LocalDate fBuena = f.toLocalDate();
				listaPedidos.add(new Pedidos(fBuena, reg.getInt(1), reg.getInt(2), reg.getDouble(3)));

			}
			s.close();
			this.cerrar();
			return listaPedidos;
		} catch (SQLException e) {
			return null;
		}
	}
}
