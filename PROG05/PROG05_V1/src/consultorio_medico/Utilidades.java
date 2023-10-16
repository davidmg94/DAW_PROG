package consultorio_medico;

import prog05_tarea.enumEspecialidad;
/**
 *
 * @author David
 */
import java.time.LocalDate;
import java.util.Scanner;

public class Utilidades {

    public static boolean mayorFecha(LocalDate fecha) {
        return fecha.isAfter(LocalDate.now());
    }

    public static void comparaFecha(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la fecha en formato yyyy-MM-dd:");
        String fechaIngresadaStr = scanner.nextLine();

        // Convertir la fecha ingresada a LocalDate
        LocalDate fechaIngresada = LocalDate.parse(fechaIngresadaStr);

        boolean esMayor = Utilidades.mayorFecha(fechaIngresada);

        if (esMayor) {
            System.out.println("La fecha ingresada es mayor que la fecha actual.");
        } else {
            System.out.println("La fecha ingresada no es mayor que la fecha actual.");
        }
    }

//    ALTERNATIVA (con una fecha dada)
//    public static boolean mayorFecha(LocalDate fecha) {
//        LocalDate fechaActual = LocalDate.now();
//        return fecha.isAfter(fechaActual);
//    }
//    public static void comparaFecha(String[] args) {
//        LocalDate fechaIngresada = LocalDate.of(2023, 8, 30); 
//        boolean esMayor = Utilidades.comparaFecha(fechaIngresada);
//
//        if (esMayor) {
//            System.out.println("La fecha ingresada es mayor que la fecha actual.");
//        } else {
//            System.out.println("La fecha ingresada no es mayor que la fecha actual.");
//        }
//    }
    public static double precioVisita(int tipoVisita, enumEspecialidad especialidad, double precio_minimo) {

        double precioVisita = 0;
        precio_minimo = Visitas.PRECIO_MINIMO;

        switch (tipoVisita) {
            case 0:
                if (especialidad == enumEspecialidad.DIGESTIVO) {
                    precioVisita = precio_minimo + precio_minimo * 0.15;
                }
                break;
            case 1:
                if (especialidad == enumEspecialidad.GINECOLOGIA) {
                    precioVisita = precio_minimo + precio_minimo * 0.1;
                }
                break;
            case 2:
                precioVisita = precio_minimo - precio_minimo * 0.1;

                break;
            case 3:
                if (especialidad != enumEspecialidad.MCABECERA) {
                    precioVisita = precio_minimo + precio_minimo * 0.5;
                }
                break;

            default:
                throw new AssertionError("No existe el tipo de visita indicado");
        }
        return precioVisita;
    }

    public static boolean codigoValido(String codigo){
       
        boolean cumpleCondiciones = false;
        try {

            String letras = codigo.substring(0, 2);
            String numeros = codigo.substring(2, 7);
            if (codigo.length() == 7 && (letras.equals("TR") || letras.equals("DI")
                    || letras.equals("GI") || letras.equals("MC"))
                    && numeros.matches("[0-9]+")) {
                cumpleCondiciones = true;
            }
        } catch (Exception e) {
            System.out.println("El formato del código no es correcto. Introdúcelo otra vez.");
        }
        return cumpleCondiciones;
    }
//    ALTERNATIVA
//    public static boolean codigoValido(String codigo)
//            throws Exception {
//        boolean correcto = false;
//        String subcadena;
//        if (codigo.length() != 7) {
//            throw new Exception("El código del médico debe de tener 7 caracteres");
//        } else {
//            subcadena = codigo.substring(0, 2);
//            if (((subcadena.equalsIgnoreCase("DI"))
//                    || (subcadena.equalsIgnoreCase("TR"))
//                    || subcadena.equalsIgnoreCase("MC")) || ((subcadena.equalsIgnoreCase("GI")))) {
//                subcadena = codigo.substring((2));
//                if (subcadena.length() == 5) {
//                    int num = Integer.parseInt(subcadena);
//                    correcto = true;
//                } else {
//                    throw new Exception("El formato del código estará formado por 2 caracteres y 5 números");
//                }
//            } else {
//                throw new Exception("El código del médico debe de contener dos caracteres asociados a la especialidad");
//            }
//        }
//        return correcto;
//    }
//    ALTERNATIVA 2
//    public static boolean codigoValido(String codigo) throws Exception {
//        if (codigo.length() != 7) {
//            throw new Exception("La longitud del código debe ser de 7 caracteres.");
//        }
//
//        String letras = codigo.substring(0, 2);
//        String numeros = codigo.substring(2, 7);
//
//        if (!((letras.equals("TR") || letras.equals("DI") || letras.equals("GI") || letras.equals("MC"))
//                && letras.equals(letras.toUpperCase()))) {
//            throw new Exception("Los dos primeros caracteres deben estar en mayúsculas y tener valores válidos (TR, DI, GI, MC).");
//        }
//
//        if (!numeros.matches("[0-9]+")) {
//            throw new Exception("Los últimos 5 caracteres deben ser valores numéricos.");
//        }
//
//        return true;
//    }
//    ALTERNATIVA 3
//    public static boolean codigoValido(String codigo) throws Exception {
//        boolean cumpleCondiciones = false;
//
//        String letras = codigo.substring(0, 2);
//        String numeros = codigo.substring(2, 7);
//        if ((codigo.length() != 7
//                || (!letras.equals("TR") || !letras.equals("DI") || !letras.equals("GI")
//                || !letras.equals("MC")))
//                || !numeros.matches("[0-9]+")) {
//            throw new Exception("El formato del código no es correcto. Introdúcelo otra vez.");
//        } else {
//            cumpleCondiciones = true;
//        }
//
//        return cumpleCondiciones;
//    }
}
 
