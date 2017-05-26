package Items;

public  class Validaciones {
	private  String dni;
	private String matricula;
	private String telefono;
	private String codTicket;
	private String contrasenya;
	
	 
 



public Validaciones(String matricula) {
		super();
		this.matricula = matricula;
	}
public   boolean validarDni(String dni) {

    
    String letraMayus = ""; //Aqui Guardamos la letra en formato mayúscula
         
    //Con esto estamos diciendo que tiene que tener 9 caracteres y que la ultima tiene que ser una letra
    if(dni.length() != 9 || Character.isLetter(this.dni.charAt(8)) == false ) {
        return false;
    }     
    // Aqui se pasa la letra a mayúscula
    letraMayus = (this.dni.substring(8)).toUpperCase();
    
    if(soloNumeros() == true && letraDNI().equals(letraMayus)) {
        return true;
    }
    else {
        return false;
    }
}
    public boolean soloNumeros() {
        int i, j = 0;
        String numero = ""; // Es el número que se comprueba uno a uno por si hay alguna letra entre los 8 primeros dígitos
        String miDNI = ""; // Aqui se guarda los números para después calcular la letra
        String[] numerosDni = {"0","1","2","3","4","5","6","7","8","9"};

        for(i = 0; i<dni.length() - 1; i++) {
            numero = dni.substring(i, i+1);

            for(j = 0; j < numerosDni.length; j++) {
                if(numero.equals(numerosDni[j])) {
                    miDNI += numerosDni[j];
                }
            }
        }

        if(miDNI.length() != 8) {
            return false;
        }
        else {
            return true;
        }
    }

    public  String letraDNI() {
    // pasar miNumero a integer
    int miDNI = Integer.parseInt(this.dni.substring(0,8));
    int resto = 0;
    String miLetra = "";
    String[] asignacionLetra = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
    resto = miDNI % 23;
    miLetra = asignacionLetra[resto];

    return miLetra;
}

    public boolean ValidarMatricula(String matricula){
    	int num;
    	try{
    	if (matricula.length()==7 && Character.isLetter(this.matricula.charAt(4)) == true && Character.isLetter(this.matricula.charAt(5)) == true && Character.isLetter(this.matricula.charAt(6)) == true &&
    			Character.isLetter(this.matricula.charAt(0)) == false && Character.isLetter(this.matricula.charAt(1)) == false && Character.isLetter(this.matricula.charAt(2)) == false && Character.isLetter(this.matricula.charAt(3)) == false) {
    		return true;
         } else {
            return false;
         }
    	
    	}catch(Exception e){
    		return false;
    	}
    }
	public boolean ValidarTicket(String codTicket){
		int num;
		try{
			if(codTicket.length()==10){
				num=Integer.parseInt(codTicket);
				}else{
					return false;
				}
				
			return true;
		
		}catch(Exception e){
			return false;
		}
	}
	public boolean ValidarCodAbonado(String codAbonado){
		int num;
		try{
			if(codAbonado.length()==5){
				num=Integer.parseInt(codAbonado);
			}else{
				return false;
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}
	public boolean ValidarContrasenya(String contrasenya){
		if(contrasenya.length()>=8){
			return true;
		}else{
			return false;
		}
	}
	public boolean ValidarTelefono(String telefono){
		int num;
		try{
			if(telefono.length()==9){
				num=Integer.parseInt(telefono);
			}else{
				return false;
			}
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
