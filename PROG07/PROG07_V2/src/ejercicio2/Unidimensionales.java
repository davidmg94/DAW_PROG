package ejercicio2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Unidimensionales {

    static boolean[] esconditeMosca = new boolean[8];
    static int MAX_RONDAS = 5;

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        try {
            int numRonda = 0;
            int posicionMosca = generarRandom();
            esconditeMosca[posicionMosca] = true;
            System.out.println(posicionMosca);
            System.out.println("Bienvenido al juego de la Mosca. Tienes " + MAX_RONDAS + " rondas para encontrar la mosca. Diviertete.");
            System.out.println("Escriba el lugar donde cree que esta la mosca (0-" + (esconditeMosca.length - 1) + ")");
            int adivinarMosca = 0;
            while (numRonda < MAX_RONDAS) {
                numRonda++;
                System.out.println("RONDA: " + numRonda);
                adivinarMosca = sn.nextInt();
                while (adivinarMosca < 0 || adivinarMosca > esconditeMosca.length - 1) {
                    System.out.println("ERROR. Introduzca un numero entre 0-7");
                    adivinarMosca = sn.nextInt();
                }

                if (esconditeMosca[adivinarMosca]) {
                    System.out.println("Enhorabuena, has ganado.");
                    System.out.println("La mosca ha sido cazada en la ronda " + numRonda);
                    break;
                } else if (numRonda == MAX_RONDAS) {
                    System.out.println("Se acabaron las rondas. Has perdido. La mosca estaba en la posicion " + posicionMosca);
                } else if (moscaCerca(esconditeMosca, adivinarMosca)) {
                    System.out.println("Casi! Habia una mosca justo al lado, pero se ha asustado y se ha movido de posicion.");
                    posicionMosca = generarRandom();
                    esconditeMosca[posicionMosca] = true;
                    System.out.println(posicionMosca);
                    System.out.println("Intentelo otra vez");
                } else {
                    System.out.println("La mosca estaba bastante lejos, Sigue en la misma posision.");
                    System.out.println(posicionMosca);
                    System.out.println("Intentelo otra vez");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR. Introduzca un numero entre 0-7.");
        }

    }

    public static int generarRandom() {
        Random random = new Random();
        int r = random.nextInt(esconditeMosca.length - 1);
        return r;
    }

    public static boolean moscaCerca(boolean esconditeMosca[], int pos) {
        int posMosca = 0;
        for (int i = 0; i < esconditeMosca.length; i++) {
            if (esconditeMosca[i]) {
                posMosca = i;
            }
        }
        return posMosca + 1 == pos || posMosca - 1 == pos;
    }
}
