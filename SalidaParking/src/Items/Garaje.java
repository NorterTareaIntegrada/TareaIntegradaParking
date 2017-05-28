package Items;

public class Garaje {
	private int codigo;
	private String direccion;

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
