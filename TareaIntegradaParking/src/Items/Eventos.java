package Items;

import java.util.Vector;

public class Eventos {

	private String mensaje;

	public Eventos(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	@Override
	public String toString() {
		return "Eventos [mensaje=" + mensaje + "]\n";
	}

	public void mostrarEventos(Vector<Eventos> misEventos) {
		if (misEventos.size() < 20) {
			for (int i = misEventos.size() - 1; i >= 0; i--) {
				System.out.println(misEventos.get(i).toString());
			}
		} else {
			for (int i = misEventos.size() - 1; i > misEventos.size() - 22; i--) {
				System.out.println(misEventos.get(i).toString());
			}
		}
	}

}
