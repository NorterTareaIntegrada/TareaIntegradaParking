package Items;

public class Tarjetas {
	private String dni;
	private int numPlaza;
	private String matricula;
	private int numAbonado;
	private int codGaraje;
	private boolean activa;
	private boolean valida;
	/**
	 * Constructor de Tarjetas
	 * @param dni DNI del abonado
	 * @param numPlaza N�mero de plaza asignado al abonado
	 * @param matricula Matr�cula registrada en la tarjeta
	 * @param numAbonado N�mero de abonado identificador
	 * @param codGaraje C�digo de garaje asignado al abonado
	 * @param activa Indica si la tarjeta esta activa
	 */
	public Tarjetas(String dni, int numPlaza, String matricula, int numAbonado, int codGaraje, boolean activa) {
		super();
		this.dni = dni;
		this.numPlaza = numPlaza;
		this.matricula = matricula;
		this.numAbonado = numAbonado;
		this.codGaraje = codGaraje;
		this.activa = activa;
		this.valida = activa;
	}
	/**
	 * Constructor de tarjetas inv�lidas
	 */
	public Tarjetas() {
		this.valida = false;
	}

	public boolean isValida() {
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
		return "Tarjetas [dni=" + dni + ", numPlaza=" + numPlaza + ", matricula=" + matricula + ", numAbonado="
				+ numAbonado + ", codGaraje=" + codGaraje + ", activa=" + activa + ", valida=" + valida + "]";
	}

}