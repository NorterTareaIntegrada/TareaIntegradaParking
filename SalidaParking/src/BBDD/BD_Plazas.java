package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Vector;

import Items.Plazas;
import Items.Tarjetas;
import Main.Salida;

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
							+ matricula + "' AND cod_ticket = " + codTicket + " AND H_ENTRADA IS NOT NULL AND cod_garaje = "+Salida.PARKING+";");
			reg.next();
			plazaReturn = new Plazas(reg.getInt(1), reg.getInt(2), reg.getInt(3), reg.getInt(4), reg.getString(5),
					reg.getTimestamp(6).toLocalDateTime(), reg.getInt(7));
		} catch (SQLException e) {
		}
		this.cerrar();
		return plazaReturn;
	}

	public boolean salir(Plazas pl) {
		this.abrir();
		try {
			c.createStatement().executeUpdate("DELETE FROM cargos WHERE cod_garaje = "+Salida.PARKING+" AND num_plaza = "+pl.getNumPlaza()+" ;");
			c.createStatement().executeUpdate("UPDATE plazas SET matricula = NULL, h_entrada = NULL, cod_ticket = NULL WHERE cod_garaje = "+Salida.PARKING+" AND num_plaza = "+pl.getNumPlaza()+" ;");
		} catch (SQLException e) {
			e.printStackTrace();
			this.cerrar();
			return false;
		}
		this.cerrar();
		return true;
	}
	
	public boolean salirA(Tarjetas tarj) {
		this.abrir();
		try {
			c.createStatement().executeUpdate("UPDATE plazas SET matricula = NULL, h_entrada = NULL, cod_ticket = NULL WHERE cod_garaje = "+Salida.PARKING+" AND num_plaza = "+tarj.getNumPlaza()+" ;");
		} catch (SQLException e) {
			this.cerrar();
			return false;
		}
		this.cerrar();
		return true;
	}/**/
	
	public boolean aparcarAbonado(Tarjetas tarj) {
		this.abrir();
		try {
			c.createStatement().executeUpdate("UPDATE plazas SET matricula = '"+tarj.getMatricula()+"', h_entrada = now() WHERE cod_garaje = "+tarj.getCodGaraje()+" AND num_plaza = "+tarj.getNumPlaza()+" ;");
		} catch (SQLException e) {
			this.cerrar();
			return false;
		}
		this.cerrar();
		return true;
	}
	
	public double precioTotal(Plazas pla){
		this.abrir();
		double tot=0;
		try{
			System.out.println(pla.getCodGaraje()+" - "+pla.getNumPlaza());
			reg = c.createStatement().executeQuery("SELECT IF(SUM(precio) IS NULL,0,SUM(precio)) FROM cargos,servicios WHERE cargos.cod_servicio = servicios.cod AND cargos.cod_garaje = "+pla.getCodGaraje()+" AND cargos.num_plaza = "+pla.getNumPlaza()+";");
			reg.next();
			double sumServ=reg.getDouble(1);
			reg = c.createStatement().executeQuery("SELECT "+sumServ+" + (now()-h_entrada)/10000 FROM plazas WHERE cod_garaje = "+pla.getCodGaraje()+" AND num_plaza = "+pla.getNumPlaza()+";");
			reg.next();
			tot=reg.getDouble(1);
		}catch(Exception e){
			e.printStackTrace();
			this.cerrar();
			return 0;
		}
		this.cerrar();
		return Math.floor(tot*100)/100;
	}
	
	public int contServicios(Plazas pla){
		this.abrir();
		int tot=0;
		try{
			reg = c.createStatement().executeQuery("SELECT COUNT(precio) FROM cargos,servicios WHERE cargos.cod_servicio = servicios.cod AND cargos.cod_garaje = "+pla.getCodGaraje()+" AND cargos.num_plaza = "+pla.getNumPlaza()+";");
			reg.next();
			tot=reg.getInt(1);
		}catch(Exception e){
			this.cerrar();
			return 0;
		}
		this.cerrar();
		return tot;
	}
	/*
	 * SALIR, ENTRAR, SI LA PLAZA ESTA OCUPADA O NO, Y PASANDOLE LA MAT Y COD
	 * TICKET QUE LA MAT NO SEA NULL, QUE COD TICKET NO SEA NULL, Y HDE ENTRADA
	 * NO NULL
	 */
}
