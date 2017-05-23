package Items;

import java.time.LocalDateTime;

public class Plazas {
	private int codGaraje;
	private int numPlaza;
	private int numPlanta;
	private int dimensiones;
	private String matricula;
	private LocalDateTime hora_entrada;
	private int codTicket;
	private Boolean activa;

	public Plazas(int codGaraje, int numPlaza, int numPlanta, int dimensiones, String matricula,
			LocalDateTime hora_entrada, int codTicket) {
		super();
		this.codGaraje = codGaraje;
		this.numPlaza = numPlaza;
		this.numPlanta = numPlanta;
		this.dimensiones = dimensiones;
		this.matricula = matricula;
		this.hora_entrada = hora_entrada;
		this.codTicket = codTicket;
		this.activa = true;
	}
  
	public Plazas() {
		this.activa = false;
	}

	public int getCodGaraje() {
		return codGaraje;
	}

	public int getCodTicket() {
		return codTicket;
	}

	public int getNumPlaza() {
		return numPlaza;
	}

	public int getNumPlanta() {
		return numPlanta;
	}

	public int getDimensiones() {
		return dimensiones;
	}

	public LocalDateTime getHora_entrada() {
		return hora_entrada;
	}

	public String getMatricula() {
		return matricula;
	}
}
