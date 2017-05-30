package BBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Items.Usuario;

public class BD_Usuario extends BBDD_Connector {

	private static Statement s;
	private static ResultSet reg;

	public BD_Usuario(String fileName) {
		super(fileName);
	}
	/**
	 * Función que valida las credenciales de un usuario
	 * @param usu Nombre de usuario
	 * @param pass Contraseña de la cuenta
	 * @return Si las credenciales son válidas se devuelve un objeto Usuario con los datos del mismo, si no lo son se devuelve un objeto Usuario sin datos válidos
	 */
	public Usuario validarLogin(String usu, String pass) {
		Usuario usuReturn = new Usuario();
		this.abrir();
		try {
			reg = c.createStatement().executeQuery(
					"SELECT tipo,nombre_usuario,contrasenya,cod_garaje,nombre,apellidos,f_nac,direccion,telefono FROM usuarios WHERE nombre_usuario = '"
							+ usu + "' AND contrasenya = '" + pass + "'");
			reg.next();
			usuReturn = new Usuario(reg.getString(1), reg.getString(2), reg.getString(3), reg.getInt(4),
					reg.getString(5), reg.getString(6), reg.getDate(7).toLocalDate(), reg.getString(8), reg.getInt(9));
		} catch (SQLException e) {
		}
		this.cerrar();
		return usuReturn;
	}
	/**
	 * Función para validar que un nombre de usuario existe
	 * @param usu Nombre de usuario a comprobar
	 * @return Si el nombre existe se devuelve un objeto Usuario con los datos del mismo, si no lo es, se devuelve un objeto Usuario sin datos válidos
	 */
	public Usuario validarNomUsu(String usu) {
		Usuario usuReturn = new Usuario();
		this.abrir();
		try {
			reg = c.createStatement().executeQuery(
					"SELECT tipo,nombre_usuario,contrasenya,cod_garaje,nombre,apellidos,f_nac,direccion,telefono FROM usuarios WHERE nombre_usuario = '"
							+ usu + "'");
			reg.next();
			usuReturn = new Usuario(reg.getString(1), reg.getString(2), reg.getString(3), reg.getInt(4),
					reg.getString(5), reg.getString(6), reg.getDate(7).toLocalDate(), reg.getString(8), reg.getInt(9));
		} catch (SQLException e) {
		}
		this.cerrar();
		return usuReturn;
	}
	/**
	 * Función para dar de alta un usuario en la base de datos
	 * @param usu Objeto tipo Usuario que se registrará
	 * @return Devuelve el número de filas modificadas (1 si se ha dado de alta satisfactoriamente, -1 en caso de excepción)
	 */
	public int altaUsuario(Usuario usu) {
		String cadenaSQL = "INSERT INTO usuarios VALUES('" + usu.getTipo() + "','" + usu.getNombreUsuario() + "','"
				+ usu.getContrasenyaIf() + "','" + usu.getCodGaraje() + "','" + usu.getNombre() + "','"
				+ usu.getApellidos() + "','" + usu.getFechaNacimiento() + "','" + usu.getDireccion() + "','"
				+ usu.getTelefono() + "')";

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			return -1;
		}
	}
	/**
	 * Función para dar de baja a un usuario en la base de datos
	 * @param nombre_usuario Nombre del usuario a dar de baja
	 * @return Devuelve el número de filas modificadas (1 si se ha dado de baja satisfactoriamente, -1 en caso de excepción)
	 */
	public int bajaUsuario(String nombre_usuario) {
		String cadenaSQL = "DELETE FROM usuarios WHERE nombre_usuario = ('" + nombre_usuario + "')";

		try {
			this.abrir();
			s = c.createStatement();
			int filas = s.executeUpdate(cadenaSQL);
			s.close();
			this.cerrar();
			return filas;
		} catch (SQLException e) {
			return -1;
		}
	}
	/**
	 * Función para listar los usuarios en la base de datos
	 * @return Devuelve un Vector de tipo Usuario con todos los usuarios de la base de datos
	 */
	public Vector<Usuario> listadoUsuarios() {
		String cadenaSQL = "SELECT tipo, nombre_usuario, contrasenya, cod_garaje, nombre, apellidos, f_nac, direccion,telefono from usuarios";
		Vector<Usuario> listaUsuarios = new Vector<Usuario>();
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(cadenaSQL);
			while (reg.next()) {
				listaUsuarios.add(new Usuario(reg.getString(1), reg.getString(2), reg.getString(3), reg.getInt(4),
						reg.getString(5), reg.getString(6), reg.getDate(7).toLocalDate(), reg.getString(8),
						reg.getInt(9)));
			}
			s.close();
			this.cerrar();
			return listaUsuarios;
		} catch (SQLException e) {
			return null;
		}
	}

}
