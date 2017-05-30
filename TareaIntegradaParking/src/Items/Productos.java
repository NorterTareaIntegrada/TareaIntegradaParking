package Items;

public class Productos {
	private int cod;
	private int cod_servicio;
	private int cod_proveedor;
	private String nombre;
	private String descripcion;
	private int unidades;
	private int maxUnidades;
	private double precio_uni;
	/**
	 * Constructor de Productos
	 * @param cod C�digo del producto
	 * @param cod_servicio C�digo de el servicio al que pertenece
	 * @param cod_proveedor C�digo del proveedor que lo suministra
	 * @param nombre Nombre de el producto
	 * @param descripcion Descripci�n breve del producto
	 * @param unidades Unidades almacenadas actualmente
	 * @param maxUnidades Unidades m�ximas almacenables
	 * @param precio_uni Precio Unitario
	 */
	public Productos(int cod, int cod_servicio, int cod_proveedor, String nombre, String descripcion, int unidades,
			int maxUnidades, double precio_uni) {
		super();
		this.cod = cod;
		this.cod_servicio = cod_servicio;
		this.cod_proveedor = cod_proveedor;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.unidades = unidades;
		this.maxUnidades = maxUnidades;
		this.precio_uni = precio_uni;
	}

	public int getCod() {
		return cod;
	}

	public int getCod_servicio() {
		return cod_servicio;
	}

	public int getCod_proveedor() {
		return cod_proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getunidades() {
		return unidades;
	}

	public int getMaxUnidades() {
		return maxUnidades;
	}

	public double getPrecio_uni() {
		return precio_uni;
	}

}
