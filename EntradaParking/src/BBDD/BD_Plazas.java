package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Vector;

import Items.Plazas;
import Items.Tarjetas;
import Main.Entrada;

public class BD_Plazas extends BBDD_Connector {
	private static Statement s;
	private static ResultSet reg;

	public BD_Plazas(String bbdd) {
		super(bbdd);
	}
	/**
	 * Funcion para listar las plazas registradas en la base de datos
	 * @return Devuelve un Vector de tipo Plazas que contiene las plazas registradas en la base de datos
	 */
	public Vector<Plazas> listado() {
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
	/**
	 * Función para validar en que plaza esta aparcado un determinado cliente
	 * @param matricula La matricula del vehiculo introducido en el garaje
	 * @param codTicket Código de ticket otorgado a la entrada del garaje
	 * @return Si los datos son válidos se devuelve un objeto Plaza con los datos de la misma, si no lo son, se devuelve un objeto Plaza sin datos válidos
	 */
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
	/**
	 * Función para añadir registro de una persona estándar aparcando en una plaza no reservada a abonados
	 * @param mat Matricula del coche que euiere aparcar
	 * @param codTicket Código de ticket otorgado a el vehiculo
	 * @return Devuelve true si se ha apracado correctamente, false si ha ocurrido una excepción
	 */
	public boolean aparcarEstandar(String mat,int codTicket) {
		this.abrir();
		try {
			reg=c.createStatement().executeQuery("SELECT cod_garaje,num_plaza FROM plazas WHERE (cod_garaje,num_plaza) NOT IN (SELECT cod_garaje,num_plaza FROM tarjetas WHERE cod_garaje = "+Entrada.PARKING+") AND cod_garaje = "+Entrada.PARKING+" AND matricula IS NULL ORDER BY rand() LIMIT 1");
			reg.next();
			c.createStatement().executeUpdate("UPDATE plazas SET matricula = '"+mat+"', h_entrada = now(), cod_ticket = "+codTicket+" WHERE cod_garaje = "+reg.getInt(1)+" AND num_plaza = "+reg.getInt(2)+" ;");
		} catch (SQLException e) {
			this.cerrar();
			return false;
		}
		this.cerrar();
		return true;
	}
	/**
	 * Función para añadir registro de una persona abonada aparcando en su plaza reservada
	 * @param tarj Tarjeta de abonado presentada en la entrada
	 * @return Devuelve true si se ha apracado correctamente, false si ha ocurrido una excepción
	 */
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
}
