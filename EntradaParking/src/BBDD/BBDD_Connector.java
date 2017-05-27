package BBDD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import Main.Entrada;

public class BBDD_Connector {

	private String dbms;
	private String dbName;
	private String usuario;
	private String pass;
	protected Connection c;

	//private String driver;
	private String serverName;
	private int portNumber;
	private Properties prop;
	
	public BBDD_Connector(String fileName){
		try{
			this.prop = new Properties();
		    //prop.loadFromXML(Files.newInputStream(Paths.get(fileName)));
		    prop.loadFromXML(BBDD_Connector.class.getResourceAsStream("/Recursos/"+fileName));
			this.dbms = this.prop.getProperty("dbms");
			//this.driver = this.prop.getProperty("driver");
			this.dbName = this.prop.getProperty("database_name");
			this.usuario = this.prop.getProperty("user_name");
			this.pass = this.prop.getProperty("password");
			this.serverName = this.prop.getProperty("server_name");
			this.portNumber = Integer.parseInt(this.prop.getProperty("port_number"));
			//System.out.println("Superada la prueba inicial de conexion a BBDD");
			
			//Se prueba la conexi�n para lanzar errores si no se puede conectar
			try{
				c = null;
				Properties connectionProps = new Properties();
				connectionProps.put("user", this.usuario);
				connectionProps.put("password", this.pass);
				c = DriverManager.getConnection("jdbc:"+this.dbms+"://"+this.serverName+":"+this.portNumber+"/"+this.dbName,connectionProps);
				abrir();
				cerrar();
			}
			catch (SQLException e){
				Entrada.msgErrBBDD="No se ha podido establecer una conexi�n con la base de datos";
				Entrada.errConBBDD=true;
			}
			try{if (c!=null){c.close();c=null;}}
			catch (SQLException e){
				Entrada.msgErrBBDD="No se ha podido completar la conexi�n con la base de datos";
				Entrada.errConBBDD=true;
			}
			
		}catch(FileNotFoundException e){
			Entrada.msgErrBBDD="No se encuentra el archivo de configuraci�n";
			Entrada.errConBBDD=true;
		}catch(InvalidPropertiesFormatException e){
			Entrada.msgErrBBDD="Error formato fichero de configuraci�n";
			Entrada.errConBBDD=true;
		}catch(IOException e){
			Entrada.msgErrBBDD="Error abriendo fichero de configuraci�n";
			Entrada.errConBBDD=true;
		}catch(Exception e){
			Entrada.msgErrBBDD="Error desconocido al acceder a la Base de Datos";
			Entrada.errConBBDD=true;
		}
	}
	
	public void abrir(){
		try{
			c = null;
			Properties connectionProps = new Properties();
			connectionProps.put("user", this.usuario);
			connectionProps.put("password", this.pass);
			c = DriverManager.getConnection("jdbc:"+this.dbms+"://"+this.serverName+":"+this.portNumber+"/"+this.dbName,connectionProps);
		}
		catch (SQLException e){System.out.println(e.getMessage());}
	}
	
	public void cerrar(){
		try{if (c!=null){c.close();c=null;}}
		catch (SQLException e){System.out.println(e.getMessage());}
	}
}