package supuesto5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Bienvenido a este ejercicio.");
        
        anadirAsteriscos(sn);

        System.out.println("FIN DEL PROGRAMA. Hasta luego!");
    }

    public static void anadirAsteriscos(Scanner sn) {
        try {
            System.out.println("Introduzca un numero entero.");
            int n = sn.nextInt();
            String asterisco = "";

            for (int i = 1; i <= n; i++) {
                asterisco += "*";
                System.out.println(asterisco);
            }
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
                anadirAsteriscos(sn);
            } else if ("n".equalsIgnoreCase(repetir)) {
                continuar = true;
            } else {
                System.out.println("ERROR. Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        } while (!continuar);
    }
}
