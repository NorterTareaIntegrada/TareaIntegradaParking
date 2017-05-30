package Items;

public class Distribuidor {
	private int cod;
	private String nombre;
	private String mail;
	private String direccion;
	/**
	 * Constructor de Distribuidores
	 * @param cod Código de distribuidor
	 * @param nombre El nombre de el distribuidor
	 * @param mail Correo electrónico de contacto con en proveedor
	 * @param direccion Direccion de su sede principal
	 */
	public Distribuidor(int cod, String nombre, String mail, String direccion) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.mail = mail;
		this.direccion = direccion;
	}

	public int getCod() {
		return cod;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMail() {
		return mail;
	}

	public String getDireccion() {
		return direccion;
	}

}
