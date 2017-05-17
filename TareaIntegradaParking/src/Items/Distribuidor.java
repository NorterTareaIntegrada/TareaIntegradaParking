package Items;

public class Distribuidor {
	private String cod;
	private String nombre;
	private String mail;
	private String direccion;
	public Distribuidor(String cod, String nombre, String mail, String direccion) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.mail = mail;
		this.direccion = direccion;
	}
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
