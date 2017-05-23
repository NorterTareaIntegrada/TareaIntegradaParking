package Items;

public class Plazas {
	private String codGaraje;
	private String numPlaza;
	private String numPlanta;
	private double dimensiones;
	private String abonado;
	private String hora_entrada;
	private String codTicket;
	
	
	public Plazas(String codGaraje, String numPlaza, String numPlanta,
			double dimensiones, String abonado, String hora_entrada,
			String codTicket) {
		super();
		this.codGaraje = codGaraje;
		this.numPlaza = numPlaza;
		this.numPlanta = numPlanta;
		this.dimensiones = dimensiones;
		this.abonado = abonado;
		this.hora_entrada = hora_entrada;
		this.codTicket = codTicket;
	}
	
	public Plazas(){};

	public String getCodGaraje() {
		return codGaraje;
	}


	public void setCodGaraje(String codGaraje) {
		this.codGaraje = codGaraje;
	}


	public String getNumPlaza() {
		return numPlaza;
	}


	public void setNumPlaza(String numPlaza) {
		this.numPlaza = numPlaza;
	}


	public String getNumPlanta() {
		return numPlanta;
	}


	public void setNumPlanta(String numPlanta) {
		this.numPlanta = numPlanta;
	}


	public double getDimensiones() {
		return dimensiones;
	}


	public void setDimensiones(double dimensiones) {
		this.dimensiones = dimensiones;
	}


	public String getAbonado() {
		return abonado;
	}


	public void setAbonado(String abonado) {
		this.abonado = abonado;
	}


	public String getHora_entrada() {
		return hora_entrada;
	}


	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}


	public String getCodTicket() {
		return codTicket;
	}


	public void setCodTicket(String codTicket) {
		this.codTicket = codTicket;
	}
	
	public boolean isValida(){
		return false;
	}
	
}
