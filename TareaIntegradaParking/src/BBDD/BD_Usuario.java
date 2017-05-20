package BBDD;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import Items.Usuario;

public class BD_Usuario extends BBDD_Connector {
	
	private static Statement s;
	private static ResultSet reg;
	
	public BD_Usuario(String fileName) {
		super(fileName);
	}
	public Usuario validarLogin(String usu,String pass){
		Usuario usuReturn=new Usuario(false);
		this.abrir();
		try {
			reg = c.createStatement().executeQuery("SELECT nombre_usuario,contrasenya,tipo,cod_garaje,nombre,apellidos FROM usuarios WHERE nombre_usuario = '"+usu+"' AND contrasenya = '"+pass+"'");
			reg.next();
			usuReturn=new Usuario(reg.getString(1),reg.getString(2),true,reg.getString(3),reg.getInt(4),reg.getString(5),reg.getString(6));
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		this.cerrar();
		return usuReturn;
	}
	
}
