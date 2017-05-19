package Items;

public class Tarjetas {
	private String dni;
	private String numPlaza;
	private String matricula;
	private String numAbonado;
	private String codGaraje;
	public Tarjetas(String dni, String numPlaza, String matricula,
			String numAbonado, String codGaraje) {
		super();
		this.dni = dni;
		this.numPlaza = numPlaza;
		this.matricula = matricula;
		this.numAbonado = numAbonado;
		this.codGaraje = codGaraje;
	}
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	public String getNumPlaza() {
		return numPlaza;
	}
	public void setNumPlaza(String numPlaza) {
		this.numPlaza = numPlaza;
	}
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	public String getNumAbonado() {
		return numAbonado;
	}
	public void setNumAbonado(String numAbonado) {
		this.numAbonado = numAbonado;
	}
	
	
	public String getCodGaraje() {
		return codGaraje;
	}
	public void setCodGaraje(String codGaraje) {
		this.codGaraje = codGaraje;
	}
	
}
