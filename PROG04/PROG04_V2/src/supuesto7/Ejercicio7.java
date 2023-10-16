package supuesto7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Bienvenido a este ejercicio.");
        
        ecuacion(sn);
        
        System.out.println("FIN DEL PROGRAMA. Hasta luego!");
    }

    public static void ecuacion(Scanner sn) {
        try {
            System.out.println("Introduzca el valor de a.");
            int a = sn.nextInt();

            System.out.println("Introduzca el valor de b.");
            int b = sn.nextInt();

            System.out.println("Introduzca el valor de c.");
            int c = sn.nextInt();

            Ecuacion ecuacion = new Ecuacion(a, b, c);

            ecuacion.calcularX1();
            ecuacion.calcularX2();
            continuar(sn);

        } catch (ExcepcionDiscriminanteNegativo e) {
            System.out.println("ERROR: " + e.getMessage());
            continuar(sn);
        } catch (InputMismatchException e) {
            System.out.println("ERROR. Introduzca un numero entero.");
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
                ecuacion(sn);
            } else if ("n".equalsIgnoreCase(repetir)) {
                continuar = true;
            } else {
                System.out.println("ERROR. Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        } while (!continuar);
    }
}
