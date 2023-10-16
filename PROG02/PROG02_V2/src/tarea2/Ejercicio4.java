package tarea2;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useLocale(Locale.US);

        int num1;
        int num2;
        int DOS = 2;

        System.out.println("Introduzca el primer numero");
        num1 = sn.nextInt();

        System.out.println("Introduzca el segundo numero");
        num2 = sn.nextInt();
        
        System.out.println("La suma de los numeros introducidos es " + (num1 + num2));
        System.out.println("La resta de los numeros introducidos es " + (num1 - num2));
        
        if (num1 % DOS == 0) {
            System.out.println("El primer numero introducido es par");
        } else {
            System.out.println("El primer numero introducido es impar");
        }
        
        if (num2 % DOS == 0) {
            System.out.println("El segundo numero introducido es par");
        } else {
            System.out.println("El segundo numero introducido es impar");
        }
        
        if (num1 % num2 == 0) {
            System.out.println("El segundo número es un divisor del primer número");
        } else {
            System.out.println("El segundo número no es un divisor del primer número");
        }

        if (num1 > num2) {
            System.out.println("El primer numero es mayor que el segundo numero");
        } else {
            System.out.println("El segundo numero es mayor que el primer numero");
        }
    }
}
