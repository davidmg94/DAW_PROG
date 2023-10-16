package ejer_banco;

public class Validacion {

    public static boolean validarDni(String dni) {
        return dni.matches("^[0-9]{8}[A-Z]$");
    }

    public static boolean validarIBAN(String IBAN) {
        return IBAN.matches("^ES[0-9]{20}$");
    }
    
    public static boolean validarNombre(String nombre) {
        
        if (nombre.length() > 40) {
            return false;
        }
        
        char caracter;
        for (int i = 0; i < nombre.length(); i++) {
            caracter = nombre.charAt(i);
            if (Character.isDigit(caracter)) {
                return false;
            }
        }
        return true;
    }
}
