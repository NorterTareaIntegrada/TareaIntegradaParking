package Items;

public class Usuario {
	private String nombreUsuario;
	private String contrasenya;
	private boolean verificado;
	private String tipo;
	private int codGaraje;
	private String nombre;
	public boolean isVerificado() {
		return verificado;
	}

	private String apellidos;

	public Usuario(boolean verificado) {
		super();
		this.verificado = verificado;
	}

	public Usuario(String nombreUsuario, String contrasenya, boolean verificado,
			String tipo, int codGaraje, String nombre, String apellidos) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasenya = contrasenya;
		this.verificado = verificado;
		this.tipo = tipo;
		this.codGaraje = codGaraje;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public String getNombreCompleto(){
		return nombre+" "+apellidos;
	}

	public String getTipo() {
		return tipo;
	}
	
}