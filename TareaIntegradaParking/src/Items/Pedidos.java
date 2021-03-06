package Items;

import java.time.LocalDate;

public class Pedidos {

	private LocalDate fecha;
	private int cod_producto;
	private int cantidad;
	private double prec_total;
	/**
	 * Constructor de Pedidos
	 * @param fecha Fecha de el pedido
	 * @param cod_producto Producto que se solicita
	 * @param cantidad Contidad Solicitada
	 * @param precioTotal Precio del pedido
	 */
	public Pedidos(LocalDate fecha, int cod_producto, int cantidad, double precioTotal) {
		super();
		this.fecha = fecha;
		this.cod_producto = cod_producto;
		this.cantidad = cantidad;
		this.prec_total = precioTotal;
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