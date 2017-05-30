package Items;

import java.time.LocalDate;

public class Usuario {
	private String tipo;
	private String nombreUsuario;
	private String contrasenya;
	private int codGaraje;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String direccion;
	private int telefono;

	private boolean verificado;
	
	public boolean isVerificado() {
		return verificado;
	}
	/**
	 * Constructor de Usuarios inválidos
	 */
	public Usuario() {
		super();
		this.verificado = false;
	}
	/**
	 * Constructor de Usuarios
	 * @param tipo Tipo de usuario (Administrador / Seguridad ... )
	 * @param nombreUsuario Nombre de usuario para identificarse posteriormente
	 * @param contrasenya Contraseña para identificarse posteriormente
	 * @param codGaraje Garaje a el que pertenece el usuario
	 * @param nombre Nombre del usuario (no confundir con nombre de usuario)
	 * @param apellidos Apellidos del usuario
	 * @param fechaNacimiento Fecha de nacimiento del usuario en formato LocalDate
	 * @param direccion Dirección del usuario, sin restricciones
	 * @param telefono Telefono del usuario
	 */
	public Usuario(String tipo, String nombreUsuario, String contrasenya, int codGaraje, String nombre,
			String apellidos, LocalDate fechaNacimiento, String direccion, int telefono) {
		super();
		this.tipo = tipo;
		this.nombreUsuario = nombreUsuario;
		this.contrasenya = contrasenya;
		this.codGaraje = codGaraje;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;

		this.verificado = true;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getNombreCompleto() {
		return nombre + " " + apellidos;
	}

	public String getTipo() {
		return tipo;
	}

	public int getCodGaraje() {
		return codGaraje;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * Devuelve La contraseña con * en vez de los carácteres que la componen
	 * @return Devuelve un string
	 */
	public String getContrasenya() {
		String cadena = "";
		for (int i = 0; i < this.contrasenya.length(); i++) {
			cadena += "*";
		}
		return cadena;
	}

	public String getContrasenyaIf() {
		return contrasenya;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * Genera una fecha con formato DD MM YYYY
	 * @param separador Separador que se aplica a los distintos dígitos de la fecha
	 * @return La fecha formateada en forma de String
	 */
	public String getFechaNacimientoFormateada(String separador) {
		return this.fechaNacimiento.getDayOfMonth() + separador + this.fechaNacimiento.getMonth() + separador
				+ fechaNacimiento.getYear();
	}

	public int getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

}