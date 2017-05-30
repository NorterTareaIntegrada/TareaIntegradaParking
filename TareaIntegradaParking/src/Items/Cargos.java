package Items;

public class Cargos {
	private int cod_garaje;
	private int num_plaza;
	private int cod_servicio;
	/**
	 * Constructor de Cargos
	 * @param cod_garaje Garaje en el que se ha solicitado ael servicio
	 * @param num_plaza Plaza en la que se ha solicitado el servicio
	 * @param cod_servicio Identificador de servicio Solicitado
	 */
	public Cargos(int cod_garaje, int num_plaza, int cod_servicio) {
		super();
		this.cod_garaje = cod_garaje;
		this.num_plaza = num_plaza;
		this.cod_servicio = cod_servicio;
	}

	public int getCod_garaje() {
		return cod_garaje;
	}

	public int getNum_plaza() {
		return num_plaza;
	}

	public int getCod_servicio() {
		return cod_servicio;
	}

}
