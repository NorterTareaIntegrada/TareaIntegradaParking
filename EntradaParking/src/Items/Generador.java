package Items;

public class Generador {
	private static String letras="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/**
	 * Genera una matricula aleatoria con motivo de simulaci�n del funcionamiento de escaneo de matriculas
	 * @return Devuelve la matricula generada en forma de String
	 */
	public static String matricula(){
		return rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+letras.charAt(rand(0,letras.length()-1))+letras.charAt(rand(0,letras.length()-1))+letras.charAt(rand(0,letras.length()-1));
	}
	/**
	 * Genera un c�digo de ticket aleatorio
	 * @return Devuelve el c�digo de ticket en forma de int
	 */
	public static int codTicket(){
		return Integer.parseInt(rand(1,1)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9));
	}
	/**
	 * Funci�n para devolver un n�mero aleatorio entre un intervalo establecido
	 * @param a M�nimo valor del intervalo inclusive
	 * @param b M�ximo valor del intervalo inclusive
	 * @return Devuelve un int con valor aleatorio comprendido en el intervalo establecido
	 */
	private static int rand(int a, int b){
		return (int)Math.floor(Math.random()*(b-a+1)+a);
	}
}
