package BBDD;

import java.sql.*;

public class BBDD_Connector {
	
	private String base;
	private String usuario;
	private String pass;
	private String url;
	protected Connection c;
	
	public BBDD_Connector(String bbdd){		
		base=bbdd;
		usuario="UsuNorter";
		pass="a1234567";
		url="jdbc:mysql://localhost/"+base;
	}
	
	public void abrir(){
		try{Class.forName("com.mysql.jdbc.Driver");}
		catch (ClassNotFoundException e){System.out.println(e.getMessage());}
		try{c=DriverManager.getConnection(url,usuario,pass);}
		catch (SQLException e ){System.out.println(e.getMessage());}
	}	

	public void cerrar(){
		try{c.close();}
		catch (SQLException e){System.out.println(e.getMessage());}
	}
}