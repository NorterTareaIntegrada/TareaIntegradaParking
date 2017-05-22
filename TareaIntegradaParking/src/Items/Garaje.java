package Items;

public class Garaje {
	private String codigo;
	private String direccion;
	
	public Garaje(String codigo, String direccion) {
		super();
		this.codigo = codigo;
		this.direccion = direccion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	
}
