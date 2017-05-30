package Items;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import BBDD.BD_Usuario;
import Main.Parking;

public class Xml {

	public static int crearXmlPlantilla(String file,boolean html,int skin,boolean replace,boolean incAdm,boolean incMec,boolean incLim,boolean incSeg) {
		try{
			if(Parking.usuarioConectado.getCodGaraje()<0){
				return 5;
			}
		}catch(Exception e){
			return 5;
		}
		//Se valida Que todo este en orden
		if(file.equals(""))return 6;
		if(!Files.exists(Paths.get("Personal"))){
			try {
				Files.createDirectories(Paths.get("Personal"));
			} catch (IOException e) {
				return 2;
			}
		}
		try{
			if((Files.exists(Paths.get("Personal/"+file+".html"))||Files.exists(Paths.get("Personal/"+file+".xml")))&&!replace){
				return 3;
			}
		}catch(Exception e){
			return 7;
		}
		//Se crea todo el resto
		try {
			Vector<Usuario> listaUsuarios = new BD_Usuario("mysql-properties.xml").listadoUsuarios();
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Trabajadores");
			doc.appendChild(rootElement);

			/*
			 * tipo, nombre_usuario ,contrasenya, cod_garaje,nombre ,apellidos,
			 * f_nac,direccion, telefono
			 */
			for (Usuario usu : listaUsuarios) {
				
				if(usu.getCodGaraje()!=Parking.usuarioConectado.getCodGaraje()&&Parking.usuarioConectado.getCodGaraje()!=0) continue;
				if(!incAdm&&usu.getTipo().equalsIgnoreCase("ADMINISTRADOR")) continue;
				if(!incMec&&usu.getTipo().equalsIgnoreCase("MECANICO")) continue;
				if(!incLim&&usu.getTipo().equalsIgnoreCase("LIMPIEZA")) continue;
				if(!incSeg&&usu.getTipo().equalsIgnoreCase("SEGURIDAD")) continue;

				Element empleado = doc.createElement("Empleado");
				Element tipo = doc.createElement("tipo");
				Element nombre_usuario = doc.createElement("nombre_usuario");
				Element contrasenya = doc.createElement("contrasenya");
				Element cod_garaje = doc.createElement("cod_garaje");
				Element nombreape = doc.createElement("nombreape");
				Element fecha = doc.createElement("f_nac");
				Element direccion = doc.createElement("direccion");
				Element telefono = doc.createElement("telefono");

				rootElement.appendChild(empleado);
				tipo.appendChild(doc.createTextNode(usu.getTipo()));
				empleado.appendChild(tipo);
				nombre_usuario.appendChild(doc.createTextNode(usu.getNombreUsuario()));
				empleado.appendChild(nombre_usuario);
				contrasenya.appendChild(doc.createTextNode(usu.getContrasenya()));
				empleado.appendChild(contrasenya);
				cod_garaje.appendChild(doc.createTextNode(usu.getCodGaraje() + ""));
				empleado.appendChild(cod_garaje);
				nombreape.appendChild(doc.createTextNode(usu.getNombreCompleto()));
				empleado.appendChild(nombreape);
				fecha.appendChild(doc.createTextNode(usu.getFechaNacimientoFormateada(" / ")));
				empleado.appendChild(fecha);
				direccion.appendChild(doc.createTextNode(usu.getDireccion()));
				empleado.appendChild(direccion);
				telefono.appendChild(doc.createTextNode(usu.getTelefono() + ""));
				empleado.appendChild(telefono);

			}

			// Se escribe el contenido generado pasado por el filtro xslt

			DOMSource source = new DOMSource(doc);
			FileWriter writer = null;
			try {
				writer = new FileWriter(new File("Personal/"+file+".xml"));
			} catch (IOException e) {
				return 4;
			}
			StreamResult result = new StreamResult(writer);
			if(html){
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				transformer.transform(source, result);
	
				String inputPathname = "Personal/"+file+".xml";
				String outputPathname = "Personal/"+file+".html";
	
				TransformerFactory factory = TransformerFactory.newInstance();
				Source stylesheetSource;
				if(skin==1) stylesheetSource = new StreamSource(Xml.class.getResourceAsStream("/Recursos/xslt/hoja_estilos_clear.xsl"));
				else stylesheetSource = new StreamSource(Xml.class.getResourceAsStream("/Recursos/xslt/hoja_estilos_dark.xsl"));
				Transformer transformer1 = factory.newTransformer(stylesheetSource);
				Source inputSource = new StreamSource(new File(inputPathname).getAbsoluteFile());
				StreamResult outputResult = new StreamResult(new File(outputPathname).getAbsoluteFile());
				transformer1.transform(inputSource, outputResult);
			}
			return 0;

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return 1;
	}
}
