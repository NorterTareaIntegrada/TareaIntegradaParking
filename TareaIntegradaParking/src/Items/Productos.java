package Items;

public class Productos {
	private String codProducto;
	private String codServicio;
	private String codProveedor;
	private double unidades;
	private double maxUnidades;
	private double precioUnidad;
	public Productos(String codProducto, String codServicio,
			String codProveedor, double unidades, double maxUnidades,
			double precioUnidad) {
		super();
		this.codProducto = codProducto;
		this.codServicio = codServicio;
		this.codProveedor = codProveedor;
		this.unidades = unidades;
		this.maxUnidades = maxUnidades;
		this.precioUnidad = precioUnidad;
	}
	public String getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}
	public String getCodServicio() {
		return codServicio;
	}
	public void setCodServicio(String codServicio) {
		this.codServicio = codServicio;
	}
	public String getCodProveedor() {
		return codProveedor;
	}
	public void setCodProveedor(String codProveedor) {
		this.codProveedor = codProveedor;
	}
	public double getUnidades() {
		return unidades;
	}
	public void setUnidades(double unidades) {
		this.unidades = unidades;
	}
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public double getMaxUnidades() {
		return maxUnidades;
	}
	public void setMaxUnidades(double maxUnidades) {
		this.maxUnidades = maxUnidades;
	}
	
}
