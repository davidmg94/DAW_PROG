package ejercicios;

/**
 *
 * @author David
 */
import java.util.Scanner;

public class Ejercicio1 {

    public static void tablas() {

        Scanner scanner = new Scanner(System.in);

        //Solicita el numero.
        System.out.print("Ingrese un número (menor que 30): ");
        int numero = scanner.nextInt();
        System.out.println();
        
        //Comprueba si el numero es menor de 30.
        if (numero >= 30) {
            System.out.println("Error. El número debe ser menor que 30. El programa ha finalizado.");
            return;
        }

        //Bucle for.
        System.out.println("Tabla de multiplicar del número " + numero + ":");
        System.out.println();

        System.out.println("Usando bucle 'for':");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
        System.out.println();

        //Bucle while
        System.out.println("Usando bucle 'while':");
        int i = 1;
        while (i <= 10) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
            ++i;
        }
        System.out.println();

        //Bucle while
        System.out.println("Usando bucle 'do-while':");
        i = 1;
        do {
            System.out.println(numero + " x " + i + " = " + (numero * i));
            ++i;
        } while (i <= 10);
    }
}
