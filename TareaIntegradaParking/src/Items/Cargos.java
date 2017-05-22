package Items;

public class Cargos {
 private String cod_garaje;
 private String num_plaza;
 private String cod_servicio;
public Cargos(String cod_garaje, String num_plaza, String cod_servicio) {
	super();
	this.cod_garaje = cod_garaje;
	this.num_plaza = num_plaza;
	this.cod_servicio = cod_servicio;
}
public String getCod_garaje() {
	return cod_garaje;
}
public void setCod_garaje(String cod_garaje) {
	this.cod_garaje = cod_garaje;
}
public String getNum_plaza() {
	return num_plaza;
}
public void setNum_plaza(String num_plaza) {
	this.num_plaza = num_plaza;
}
public String getCod_servicio() {
	return cod_servicio;
}
public void setCod_servicio(String cod_servicio) {
	this.cod_servicio = cod_servicio;
}
 
}
