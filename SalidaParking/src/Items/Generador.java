package Items;

public class Generador {
	private static String letras="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String matricula(){
		return rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+letras.charAt(rand(0,letras.length()-1))+letras.charAt(rand(0,letras.length()-1))+letras.charAt(rand(0,letras.length()-1));
	}
	public static int codTicket(){
		return Integer.parseInt(rand(1,1)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9)+""+rand(0,9));
	}
	private static int rand(int a, int b){
		return (int)Math.floor(Math.random()*(b-a+1)+a);
	}
}
