package Items;

public class Validator {
	private static String letrasDNI="TRWAGMYFPDXBNJZSQVHLCKE";
	/**
	 * Valida que un DNI sea v�lido (8 n�meros, 1 letra,letra correcta)
	 * @param dni El DNI como tal
	 * @return True si es v�lido, False si no
	 */
	public static boolean Dni(String dni) {
	    try{
	    	return dni.length() == 9 && Character.isLetter(dni.charAt(8)) && (letrasDNI.charAt( Integer.parseInt(dni.substring(0,8)) % 23)+"").equals((dni.charAt(8)+"").toUpperCase());
	    }catch(Exception e){
	    	return false;
	    }
	}
	/**
	 * Valida que un c�digo de abonado tenga el formato correcto (5 n�meros)
	 * @param codAbonado El C�digo de Abonado como tal
	 * @return True si es v�lido, False si no
	 */
	public static boolean CodAbonado(String codAbonado){
		try{
			return codAbonado.length()==5 && Integer.parseInt(codAbonado)<100000;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * Valida que un C�digo de Ticket sea v�lido (10 n�meros)
	 * @param codTicket El C�digo de Ticket como tal
	 * @return True si es v�lido, False si no
	 */
	public static boolean CodTicket(String codTicket){
		try{
			return codTicket.length()==10 && Integer.parseInt(codTicket)<2000000000;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * Valida si un tel�fono tiene el formato correcto (9 d�gitos)
	 * @param telefono El tel�fono como tal
	 * @return True si es v�lido, False si no
	 */
	public static boolean Telefono(String telefono){
		try{
			return telefono.length()==9 && Integer.parseInt(telefono)<1000000000;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * Valida si una contrase�a tiene un formato v�lido (longitud de al menos 6 caracters)
	 * @param contrasenya La contrase�a como tal
	 * @return True si es v�lido, False si no
	 */
	public static boolean Contrasenya(String contrasenya){
		return contrasenya.length()>=6;
	}
	/**
	 * Valida si una matr�cula tiene un formato correcto (4 d�gitos seguidos de 3 letras)
	 * @param matricula La matr�cula como tal
	 * @return True si es v�lido, False si no
	 */
	public static boolean Matricula(String matricula){
		try{
		return (matricula.length()==7 && Character.isLetter(matricula.charAt(4)) && Character.isLetter(matricula.charAt(5)) && Character.isLetter(matricula.charAt(6)) && Integer.parseInt(matricula.substring(0,4))<10000);
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * Valida que el c�digo de garaje este entrre 1 y 3
	 * @param cod El c�digo de garaje como tal
	 * @return True si es v�lido, False si no
	 */
	public static boolean CodGaraje(String cod){
		try{
		return "123".indexOf(Integer.parseInt(cod)+"")!=-1 && cod.length()==1;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * Valida que un numero de plaza sea correcto (un d�gito entre 1 y 600 ambos inclusive)
	 * @param num El n�mero de plaza como tal
	 * @return True si es v�lido, False si no
	 */
	public static boolean NumPlaza(String num){
		try{
		return Integer.parseInt(num)>0&&Integer.parseInt(num)<=600;
		}catch(Exception e){
			return false;
		}
	}
}
