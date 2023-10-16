package ejer_gimnasio;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validacion {

    public static boolean validarDni(String dni) {
        return dni.matches("^[0-9]{8}[A-Z]$");
    }

    public static boolean validarCodigoTaquilla(String codigoTaquilla) {
        return codigoTaquilla.matches("^[A-Za-z]{2}[0-9]{3}$");
    }

    public static boolean validarNombre(String nombre) {

        //        return nombre.length() >= 20;
        if (nombre.length() < 20) {
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

    public static boolean validarFormatoFecha(String fecha) {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                try {
            formatter.parse(fecha);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}

