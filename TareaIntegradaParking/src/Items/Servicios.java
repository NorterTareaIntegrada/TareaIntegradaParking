package Items;

public class Servicios {
	private int cod;
	private String nombre;
	private double precio;
	private String descripcion;

	public Servicios(int cod, String nombre, double precio, String descripcion) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.precio=precio;
		this.descripcion = descripcion;
	}

	public int getCod() {
		return cod;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return this.precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
