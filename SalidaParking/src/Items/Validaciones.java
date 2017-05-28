package Items;

public  class Validaciones {
	
	private static String letrasDNI="TRWAGMYFPDXBNJZSQVHLCKE";
	
	
	public static boolean Dni(String dni) {
	    try{
	    	return dni.length() == 9 && Character.isLetter(dni.charAt(8)) && (letrasDNI.charAt( Integer.parseInt(dni.substring(0,8)) % 23)+"").equals((dni.charAt(8)+"").toUpperCase());
	    }catch(Exception e){
	    	return false;
	    }
	}
	public static boolean CodAbonado(String codAbonado){
		try{
			return codAbonado.length()==5 && Integer.parseInt(codAbonado)<100000;
		}catch(Exception e){
			return false;
		}
	}
	public static boolean Matricula(String matricula){
		try{
		return (matricula.length()==7 && Character.isLetter(matricula.charAt(4)) && Character.isLetter(matricula.charAt(5)) && Character.isLetter(matricula.charAt(6)) && Integer.parseInt(matricula.substring(0,4))<10000);
		}catch(Exception e){
			return false;
		}
	}
	public static boolean CodTicket(String codTicket){
		try{
			return codTicket.length()==10 && Integer.parseInt(codTicket)<2000000000;
		}catch(Exception e){
			return false;
		}
	}
}
