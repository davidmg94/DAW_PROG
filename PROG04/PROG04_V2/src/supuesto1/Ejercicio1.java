package supuesto1;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio1 {

    public static void rangoNotas(float nota) throws ExcepcionRangoNotas {
        if (nota > 10 || nota < 0) {
            throw new ExcepcionRangoNotas("ERROR: La nota está fuera del rango (0-10)");
        }
    }

    public static void main(String[] args) {
        
            Scanner sn = new Scanner(System.in);
            sn.useLocale(Locale.US);

            System.out.println("Bienvenido a este ejercicio.");
        try {
            System.out.println("Introduzca su nombre.");
            String nombre = sn.nextLine();

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

        } catch (Exception ex) {
            System.out.println("ERROR: Se ha introducido un valor no permitido.");
        }
        System.out.println("FIN DEL PROGRAMA. Hasta luego!");
    }
}
