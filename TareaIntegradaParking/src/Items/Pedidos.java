package Items;

import java.time.LocalDate;

public class Pedidos {

	private LocalDate fecha;
	private int cod_producto;
	private int cantidad;
	private double prec_total;

	public Pedidos(LocalDate fecha, int cod_producto, int cantidad, double precioTotal) {
		super();
		this.fecha = fecha;
		this.cod_producto = cod_producto;
		this.cantidad = cantidad;
		this.prec_total = prec_total;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public int getCodigoProducto() {
		return cod_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public double getPrecioTotal() {
		return prec_total;
	}

}