package ejercicio3;

import java.util.Random;
import java.util.Scanner;

public class Multidimensionales {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Introduzca el tamaño de la matriz");
        int n = sn.nextInt();
        if (n >= 0) {
            System.out.println("Martiz.");
            int[][] matriz = new int[n][n];
            int[] maximos = new int[n];

            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = random.nextInt(10);
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("");

            System.out.println("Maximos.");
            double sumMaximos = 0;

            for (int i = 0; i < matriz.length; i++) {
                maximos[i] = encontrarMaximo(matriz[i]);
                System.out.println("El maximo de cada fila es " + maximos[i]);
                sumMaximos += maximos[i];
            }
            System.out.println("");

            System.out.println("Media.");
            double mediaMaximos = sumMaximos / matriz.length;
            System.out.printf("La media de los maximos es %.2f\n", mediaMaximos);
        } else {
            System.out.println("El numero debe ser un numero entero mayor de 0.");
        }
    }

    public static int encontrarMaximo(int[] fila) {

        int maximo = fila[0];
        for (int i = 1; i < fila.length; i++) {
            if (maximo < fila[i]) {
                maximo = fila[i];
            }
        }
        return maximo;
    }
}
