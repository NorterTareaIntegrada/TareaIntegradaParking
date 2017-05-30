package Items;

import java.time.LocalDateTime;

public class Plazas {
	private int cod_garaje;
	private int num_plaza;
	private int num_planta;
	private int dimensiones;
	private String matricula;
	private LocalDateTime h_entrada;
	private int cod_ticket;
	private Boolean activa;
	/**
	 * Constructor de Plazas
	 * @param cod_garaje Código del garaje en el que se situan
	 * @param num_plaza Número de plaza por la que se identifica
	 * @param num_planta Planta en la que se situa
	 * @param dimensiones Dimensiones de la plaza expresada en metros cuadrados
	 * @param matricula Martricula de el coche actualmente estacionado "si lo hay"
	 * @param h_entrada Hora de entrada de el coche actualmente estacionado "si lo hay"
	 * @param cod_ticket Código de ticket de el coche actualmente estacionado "si lo hay y no es abonado"
	 */
	public Plazas(int cod_garaje, int num_plaza, int num_planta, int dimensiones, String matricula,
			LocalDateTime h_entrada, int cod_ticket) {
		super();
		this.cod_garaje = cod_garaje;
		this.num_plaza = num_plaza;
		this.num_planta = num_planta;
		this.dimensiones = dimensiones;
		this.matricula = matricula;
		this.h_entrada = h_entrada;
		this.cod_ticket = cod_ticket;
		this.activa = true;
	}
	/**
	 * Constructor de Plazas inválidas
	 */
	public Plazas() {
		this.activa = false;
	}

	public int getCodGaraje() {
		return cod_garaje;
	}

	public int getCodTicket() {
		return cod_ticket;
	}

	public int getNumPlaza() {
		return num_plaza;
	}

	public int getNumPlanta() {
		return num_planta;
	}

	public int getDimensiones() {
		return dimensiones;
	}

	public LocalDateTime getHora_entrada() {
		return h_entrada;
	}

	public String getMatricula() {
		return matricula;
	}

	public Boolean isActiva() {
		return activa;
	}

}
