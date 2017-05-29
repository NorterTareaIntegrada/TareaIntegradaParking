package Items;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

public class Xml {

	public static void crearXmlPlantilla() {
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
			for (Usuario usu : listaUsuarios) {// significa que usu va a tomar
												// todos los valores que tenga
												// listaUsuarios

				Element empleado = doc.createElement("Empleado");
				Element tipo = doc.createElement("tipo");
				Element nombre_usuario = doc.createElement("nombre_usuario");
				Element contrasenya = doc.createElement("contrasenya");
				Element cod_garaje = doc.createElement("cod_garaje");
				Element nombreape = doc.createElement("nombre");
				Element fecha = doc.createElement("fecha_nacimiento");
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
				fecha.appendChild(doc.createTextNode(usu.getFechaNacimientoFormateada("-")));
				empleado.appendChild(fecha);
				direccion.appendChild(doc.createTextNode(usu.getDireccion()));
				empleado.appendChild(direccion);
				telefono.appendChild(doc.createTextNode(usu.getTelefono() + ""));
				empleado.appendChild(telefono);

			}

			// write the content into xml file

			DOMSource source = new DOMSource(doc);
			FileWriter writer = null;
			try {
				writer = new FileWriter(new File("file.xml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StreamResult result = new StreamResult(writer);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(source, result);

			String stylesheetPathname = "oigamigente.xsl";
			String inputPathname = "file.xml";
			String outputPathname = "lool.html";

			TransformerFactory factory = TransformerFactory.newInstance();
			Source stylesheetSource = new StreamSource(new File(stylesheetPathname).getAbsoluteFile());
			Transformer transformer1 = factory.newTransformer(stylesheetSource);
			Source inputSource = new StreamSource(new File(inputPathname).getAbsoluteFile());
			StreamResult outputResult = new StreamResult(new File(outputPathname).getAbsoluteFile());
			transformer1.transform(inputSource, outputResult);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
