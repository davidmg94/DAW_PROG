package tarea2;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        sn.useLocale(Locale.US);

        float salario = 0;
        String nombre;
        int edad;

        System.out.println("Introduzca el nombre:");
        nombre = sn.nextLine();

        System.out.println("Introduzca la edad:");
        edad = sn.nextInt();

        System.out.println("Introduzca el salario:");
        salario = sn.nextFloat();

        if (edad < 25) {
            salario = salario + 10;
            System.out.println("El salario de " + nombre + " se ha incrementado, ahora es de " + salario);
        } else {
            salario = salario + 20;
            System.out.println("El salario de " + nombre + " se ha incrementado, ahora es de " + salario);
        }
    }
}
