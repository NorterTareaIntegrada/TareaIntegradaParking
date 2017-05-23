package Items;

import java.time.LocalDate;

public class Pedidos {

	private LocalDate fecha;
	private String codigoProducto;
	private int cantidad;
	private double precioTotal;

	public Pedidos(LocalDate fecha, String codigoProducto, int cantidad, double precioTotal) {
		super();
		this.fecha = fecha;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

}
