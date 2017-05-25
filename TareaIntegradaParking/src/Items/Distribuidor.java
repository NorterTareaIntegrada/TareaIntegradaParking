package Items;

public class Distribuidor {
	private int cod;
	private String nombre;
	private String mail;
	private String direccion;

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
