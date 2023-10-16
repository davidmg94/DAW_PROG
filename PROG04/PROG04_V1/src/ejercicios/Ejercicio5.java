package ejercicios;

import java.util.Scanner;

/**
 *
 * @author David
 */
public class Ejercicio5 {

    public static void divisor() {

        Scanner entrada = new Scanner(System.in);
        int numDivisiones = 0;
        int dividendo = 0;
        int divisor = 0;
        int resultado = 0;
        while (dividendo != -1 && divisor != -1) {
            try {
                System.out.println("Introduce el dividendo");
                dividendo = entrada.nextInt();
                System.out.println("Introduce el divisor");
                divisor = entrada.nextInt();
                if (dividendo != -1 && divisor != -1) {
                    
                
                resultado = dividendo / divisor;

                System.out.println("Resultado: " + resultado);
                numDivisiones++;
                }

            } catch (ArithmeticException e) {
                System.out.println("El divisor no puede ser 0");
            }

        }
        System.out.println("Numero de divisiones " + numDivisiones);
    }
}
