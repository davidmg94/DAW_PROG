package ejercicio1;

import static ejercicio1.UtilidadesCadenas.girarCadena;
import static ejercicio1.UtilidadesCadenas.palindromo;
import static ejercicio1.UtilidadesCadenas.unionCadenas;
import static ejercicio1.UtilidadesCadenas.vecesLetra;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        Scanner sn = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 5) {
            try {
                System.out.println("Ejercicio 1, de la tarea 7.");
                System.out.println(" 1. Union de cadenas.");
                System.out.println(" 2. Numero de veces que se repite una letra en una cadena.");
                System.out.println(" 3. Saber si una cadena es palindromo.");
                System.out.println(" 4. Devolver una cadena al reves.");
                System.out.println(" 5. Salir.");
                System.out.println("Elija una opcion.");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        lanzarUnionCadenas();
                        break;
                    case 2:
                        lanzarVecesLetra();
                        break;
                    case 3:
                        lanzarPalindromo();
                        break;
                    case 4:
                        lanzarCadenaAlReves();
                        break;
                    case 5:
                        salir();
                        break;
                    default:
                        System.out.println("¡ERROR! Introduzca una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR! Introduzca una opción válida.");
                sn.next();
            } catch (Exception e) {
                System.out.println("Error inesperado.");
                sn.next();
            }
        }
    }

    public static void lanzarUnionCadenas() {
        Scanner sn = new Scanner(System.in);
        System.out.println("cadena 1");
        String cadena1 = sn.nextLine();
        System.out.println("cadena 2");
        String cadena2 = sn.nextLine();
        System.out.println(unionCadenas(cadena1, cadena2));
    }

    public static void lanzarVecesLetra() {
        Scanner sn = new Scanner(System.in);
        System.out.println("cadena");
        String cadena1 = sn.nextLine();
        System.out.println("letra");
        String strletra = sn.next();
        char letra = strletra.charAt(0);
        int numVeces = vecesLetra(cadena1, letra);
        System.out.println(numVeces);
    }

    public static void lanzarPalindromo() {
        Scanner sn = new Scanner(System.in);
        System.out.println("cadena");
        String cadena = sn.nextLine();
        System.out.println("¿La cadena es un palíndromo? " + palindromo(cadena));
    }

    public static void lanzarCadenaAlReves() {
        Scanner sn = new Scanner(System.in);
        System.out.println("cadena");
        String cadena = sn.nextLine();
        System.out.println(girarCadena(cadena));
    }

    public static void salir() {
        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        do {
            System.out.println("¿Quiere salir? (S/N)");
            String continuar = sn.next();

            if ("s".equalsIgnoreCase(continuar)) {
                System.out.println("Fin del programa. ¡Hasta luego!");
                salir = true;

            } else if ("n".equalsIgnoreCase(continuar)) {
                salir = true;
                iniciarPrograma();
            } else {
                System.out.println("¡ERROR!. Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        } while (!salir);
    }
}
