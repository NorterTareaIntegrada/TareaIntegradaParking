package Items;

import java.util.Vector;

public class Eventos {

	private String mensaje;
	private int codGaraje;
	/**
	 * Constructor de eventos que se registrarán en el panel de eventos recientes
	 * @param mensaje El mensaje que se mostrará
	 * @param codGaraje Garaje a el que va dirigido
	 */
	public Eventos(String mensaje,int codGaraje) {
		super();
		this.mensaje = mensaje;
		this.codGaraje = codGaraje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public int getCodGaraje() {
		return codGaraje;
	}

	@Override
	public String toString() {
		return "Eventos [mensaje=" + mensaje + "]\n";
	}
	/**
	 * Muestra los últimos eventos
	 * @param misEventos Vector de Eventos que mostrar
	 */
	public static void mostrarEventos(Vector<Eventos> misEventos) {
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
