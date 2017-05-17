package BBDD;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import Main.Parking;

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
		    prop.loadFromXML(Files.newInputStream(Paths.get(fileName)));
			this.dbms = this.prop.getProperty("dbms");
			//this.driver = this.prop.getProperty("driver");
			this.dbName = this.prop.getProperty("database_name");
			this.usuario = this.prop.getProperty("user_name");
			this.pass = this.prop.getProperty("password");
			this.serverName = this.prop.getProperty("server_name");
			this.portNumber = Integer.parseInt(this.prop.getProperty("port_number"));
			System.out.println("superada 1a prueba");
			
			//Se prueba la conexión para lanzar errores si no se puede conectar
			try{
				c = null;
				Properties connectionProps = new Properties();
				connectionProps.put("user", this.usuario);
				connectionProps.put("password", this.pass);
				c = DriverManager.getConnection("jdbc:"+this.dbms+"://"+this.serverName+":"+this.portNumber+"/"+this.dbName,connectionProps);
			}
			catch (SQLException e){
				Parking.msgErrBBDD="No se ha podido establecer una conexión con la base de datos";
				Parking.errConBBDD=true;
			}
			try{if (c!=null){c.close();c=null;}}
			catch (SQLException e){
				Parking.msgErrBBDD="No se ha podido completar la conexión con la base de datos";
				Parking.errConBBDD=true;
			}
			
		}catch(FileNotFoundException e){
			Parking.msgErrBBDD="No se encuentra el archivo de configuración";
			Parking.errConBBDD=true;
		}catch(InvalidPropertiesFormatException e){
			Parking.msgErrBBDD="Error formato fichero de configuración";
			Parking.errConBBDD=true;
		}catch(IOException e){
			Parking.msgErrBBDD="Error abriendo fichero de configuración";
			Parking.errConBBDD=true;
		}catch(Exception e){
			Parking.msgErrBBDD="Error desconocido al acceder a la Base de Datos";
			Parking.errConBBDD=true;
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