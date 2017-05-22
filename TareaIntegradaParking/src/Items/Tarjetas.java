package Items;

public class Tarjetas {
	private String dni;
	private int numPlaza;
	private String matricula;
	private int numAbonado;
	private int codGaraje;
	private boolean activa;
	private boolean valida;
	
	public Tarjetas(String dni, int numPlaza, String matricula,
			int numAbonado, int codGaraje, boolean activa) {
		super();
		this.dni = dni;
		this.numPlaza = numPlaza;
		this.matricula = matricula;
		this.numAbonado = numAbonado;
		this.codGaraje = codGaraje;
		this.activa = activa;
		this.valida = activa;
	}
	
	public Tarjetas(){
		this.valida = false;
	}
	
	public boolean isValida(){
		return this.valida;
	}
	
	public String getDni() {
		return dni;
	}
	
	public int getNumPlaza() {
		return numPlaza;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public int getNumAbonado() {
		return numAbonado;
	}
	
	public int getCodGaraje() {
		return codGaraje;
	}

	@Override
	public String toString() {
		return "Tarjetas [dni=" + dni + ", numPlaza=" + numPlaza
				+ ", matricula=" + matricula + ", numAbonado=" + numAbonado
				+ ", codGaraje=" + codGaraje + ", activa=" + activa
				+ ", valida=" + valida + "]";
	}
	
	
	
}