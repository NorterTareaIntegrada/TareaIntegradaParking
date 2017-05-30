package Items;

public class Garaje {
	private int codigo;
	private String direccion;
	/**
	 * Constructor de Garajes
	 * @param codigo Código de garaje (1-3)
	 * @param direccion Dirección en la que se localiza el garaje (en texto plano)
	 */
	public Garaje(int codigo, String direccion) {
		super();
		this.codigo = codigo;
		this.direccion = direccion;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDireccion() {
		return direccion;
	}

}
