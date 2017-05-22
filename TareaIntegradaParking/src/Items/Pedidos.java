package Items;

public class Pedidos {
 private String fecha;
 private String cod_producto;
 private double cantidad;
 private double precio_total;
public Pedidos(String fecha, String cod_producto, double cantidad, double precio_total) {
	super();
	this.fecha = fecha;
	this.cod_producto = cod_producto;
	this.cantidad = cantidad;
	this.precio_total = precio_total;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public String getCod_producto() {
	return cod_producto;
}
public void setCod_producto(String cod_producto) {
	this.cod_producto = cod_producto;
}
public double getCantidad() {
	return cantidad;
}
public void setCantidad(double cantidad) {
	this.cantidad = cantidad;
}
public double getPrecio_total() {
	return precio_total;
}
public void setPrecio_total(double precio_total) {
	this.precio_total = precio_total;
}
 
}
