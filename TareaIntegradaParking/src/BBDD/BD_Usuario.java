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

	public int altaUsuario(Usuario usu) {
		String cadenaSQL = "INSERT INTO usuarios VALUES('" + usu.getTipo() + "','" + usu.getNombreUsuario() + "','"
				+ usu.getContrasenya() + "','" + usu.getCodGaraje() + "','" + usu.getNombre() + "','"
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
