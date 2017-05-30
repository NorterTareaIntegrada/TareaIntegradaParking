package Items;

public class Servicios {
	private int cod;
	private String nombre;
	private double precio;
	private String descripcion;
	/**
	 * Constructor de servicios
	 * @param cod C�digo de servicio
	 * @param nombre Nombre de el servicio
	 * @param precio Precio de contrataci�n del servicio
	 * @param descripcion Descripci�n breve del servicio
	 */
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
