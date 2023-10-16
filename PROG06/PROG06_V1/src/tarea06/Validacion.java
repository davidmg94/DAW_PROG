package tarea06;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validacion {

    public static boolean validarDni(String dni) {
        return dni.matches("^[0-9]{8}[A-Za-z]$");
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

    public static boolean comprobarSexo(Scanner sn) {
//        Scanner sn = new Scanner(System.in);
        String sexo = sn.next();
        while (!"h".equalsIgnoreCase(sexo) && !"m".equalsIgnoreCase(sexo)) {
            System.out.println("El sexo debe ser 'H' (Hombre) o 'M' (Mujer).");
            System.out.println("Introduzca de nuevo el sexo:");
            sexo = sn.next();
        }
        return true;
    }
}
