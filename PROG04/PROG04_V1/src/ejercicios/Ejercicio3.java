package ejercicios;

/**
 *
 * @author David
 */
import java.util.Scanner;

public class Ejercicio3 {

    public static void mcm() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();

        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();

        if (num1 <= 0 || num2 <= 0) {
            System.out.println("ERROR: Ambos números deben ser positivos.");
        } else {
            int mcm = calcularMCM(num1, num2);
            System.out.println("El MCM de " + num1 + " y " + num2 + " es: " + mcm);
        }
    }
    
    public static int calcularMCM(int a, int b){
        
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int mcm = max;
        
        while (true) {
            if (mcm % min == 0 && mcm % max == 0) {
                return mcm;
            }
            mcm += max;
        }
    }
}

   