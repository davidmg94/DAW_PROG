package supuesto2;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio2 {

    static void rangoNotas(float nota) throws ExcepcionRangoNotas {
            if (nota > 10 || nota < 0) {
            throw new ExcepcionRangoNotas("ERROR: La nota está fuera del rango (0-10)");
        }
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useLocale(Locale.US);

        System.out.println("Bienvenido a este ejercicio.");
        
        calcularNota(sn);

        System.out.println("FIN DEL PROGRAMA. Hasta luego!");
    }

    public static void calcularNota(Scanner sn) {
        try {
            System.out.println("Introduzca su nombre.");
            String nombre = sn.next();

            System.out.println("Introduzca una nota.");
            float nota = sn.nextFloat();

            rangoNotas(nota);

            String mensajeCalificacion;

            if (nota < 5) {
                mensajeCalificacion = "Suspenso";
            } else if (nota < 6) {
                mensajeCalificacion = "Aprobado";
            } else if (nota < 7) {
                mensajeCalificacion = "Bien";
            } else if (nota < 9) {
                mensajeCalificacion = "Notable";
            } else if (nota < 10) {
                mensajeCalificacion = "Sobresaliente";
            } else {
                mensajeCalificacion = "Matrícula de Honor";
            }
            System.out.println("Hola " + nombre + ", tu calificación es: " + mensajeCalificacion);

        } catch (ExcepcionRangoNotas e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("ERROR: Introduzca un numero entre 1 y 10.");
            sn.next();
            continuar(sn);
        } 
    }
    
    public static void continuar(Scanner sn) {
        boolean continuar = false;
        do {
            System.out.println("¿Quiere continuar? (S/N)");
            String repetir = sn.next();

            if ("s".equalsIgnoreCase(repetir)) {
                continuar = true;
                calcularNota(sn);
            } else if ("n".equalsIgnoreCase(repetir)) {
                continuar = true;
            } else {
                System.out.println("ERROR. Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        } while (!continuar);
    }
}
