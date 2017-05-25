package Items;

public class Productos {
	private int cod;
	private int cod_servicio;
	private int cod_proveedor;
	private String nombre;
	private String descripcion;
	private int max_unidades;
	private int maxUnidades;
	private double precio_uni;

	public Productos(int cod, int cod_servicio, int cod_proveedor, String nombre, String descripcion, int max_unidades,
			int maxUnidades, double precio_uni) {
		super();
		this.cod = cod;
		this.cod_servicio = cod_servicio;
		this.cod_proveedor = cod_proveedor;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.max_unidades = max_unidades;
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

	public int getMax_unidades() {
		return max_unidades;
	}

	public int getMaxUnidades() {
		return maxUnidades;
	}

	public double getPrecio_uni() {
		return precio_uni;
	}

}
