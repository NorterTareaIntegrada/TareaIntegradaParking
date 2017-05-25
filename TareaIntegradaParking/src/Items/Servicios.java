package Items;

public class Servicios {
	private int cod;
	private String nombre;
	private String descripcion;

	public Servicios(int cod, String nombre, String descripcion) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getCod() {
		return cod;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
