package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Vector;

import Items.Plazas;

public class BD_Plazas extends BBDD_Connector {
	private static Statement s;
	private static ResultSet reg;

	public BD_Plazas(String bbdd) {
		super(bbdd);
		// TODO Auto-generated constructor stub
	}

	public Vector<Plazas> listado(String plaza) {
		String cadenaSQL = "SELECT COD_GARAJE,NUM_PLAZA,NUM_PLANTA,DIMENSIONES,MATRICULA,H_ENTRADA,COD_TICKET FROM plazas";
		Vector<Plazas> listaPlazas = new Vector<Plazas>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				java.sql.Date f = reg.getDate("h_entrada");
				LocalDateTime fBuena = LocalDateTime.ofInstant(f.toInstant(), ZoneId.systemDefault());
				listaPlazas.add(new Plazas(reg.getInt(1), reg.getInt(2), reg.getInt(3), reg.getInt(4), reg.getString(5),
						fBuena, reg.getInt(7)));
			}
			s.close();
			this.cerrar();
			return listaPlazas;
		} catch (SQLException e) {
			return null;
		}
	}

	public Plazas validarPlaza(String matricula, int codTicket) {
		Plazas plazaReturn = new Plazas();
		this.abrir();
		try {
			reg = c.createStatement().executeQuery(
					"SELECT COD_GARAJE,NUM_PLAZA,NUM_PLANTA,DIMENSIONES,MATRICULA,H_ENTRADA,COD_TICKET FROM plazas WHERE matricula = '"
							+ matricula + "' AND cod_ticket = " + codTicket + " AND H_ENTRADA IS NOT NULL;");
			reg.next();
			plazaReturn = new Plazas(reg.getInt(1), reg.getInt(2), reg.getInt(3), reg.getInt(4), reg.getString(5),
					reg.getTimestamp(6).toLocalDateTime(), reg.getInt(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.cerrar();
		return plazaReturn;
	}

	/*
	 * SALIR, ENTRAR, SI LA PLAZA ESTA OCUPADA O NO, Y PASANDOLE LA MAT Y COD
	 * TICKET QUE LA MAT NO SEA NULL, QUE COD TICKET NO SEA NULL, Y HDE ENTRADA
	 * NO NULL
	 */
}
