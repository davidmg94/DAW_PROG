package ejercicios;

/**
 *
 * @author David
 */
import java.util.Scanner;

public class Ejercicio2 {

    public static void primo() {

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese un número: ");
            int num = scanner.nextInt();
            if (num < 0) {
                System.out.println("El numero es negativo");
            } else {

                boolean esPrimo = true;

                for (int j = (int) Math.sqrt(num); j > 1 && esPrimo; j--) {
                    if (num % j == 0) {
                        esPrimo = false;
                    }
                }

                if (esPrimo) {
                    System.out.println("El numero es primo");
                } else {
                    System.out.println("El numero no es primo");
                }

            }
            //ALTERNATIVA
//            if (num < 0) {
//                System.out.println("El numero es negativo.");
//            } else if (esPrimo(num)) {
//                System.out.println("El número es primo.");
//            } else {
//                System.out.println("El número no es primo.");
//            }
        }
    }
      //ALTERNATIVA
//    public static boolean esPrimo(int num) {
//        if (num <= 1) {
//            return false;
//        }
//        for (int i = 2; i <= Math.sqrt(num); i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
