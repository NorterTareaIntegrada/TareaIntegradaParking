package Items;

public  class Validaciones {
	
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
}
