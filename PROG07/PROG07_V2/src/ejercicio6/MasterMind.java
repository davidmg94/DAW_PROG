package ejercicio6;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MasterMind {

    static final int MAX_RONDAS = 7;
    static final int NUM_DIGITOS = 3;

    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        try {
            Scanner sn = new Scanner(System.in);
            int[] numRandom = new int[NUM_DIGITOS];
            generarArrayAleatorios(numRandom);

            int numRondas = 0;
            System.out.println(Arrays.toString(numRandom));
            System.out.println("Bienvenido a Master Mind.");
            System.out.println("Este juego consiste en adivinar los numeros escondidos en " + MAX_RONDAS + " rondas.");
            System.out.println("Verde(V) has acertado, Amarillo(A) el numero esta, pero en otra posicion, Rojo(R) no esta el numero.");

            int aciertos = 0;

            while (aciertos < 3 && numRondas < MAX_RONDAS) {
                numRondas++;

                System.out.println("Ronda: " + numRondas);

                System.out.println("Introduzca " + (numRandom.length) + " numeros");
                aciertos = 0;
                System.out.println("Numero 1");
                String numero1 = "";
                int num1 = sn.nextInt();
                if (num1 == numRandom[0]) {
                    numero1 = "V";
                    aciertos++;
                } else if (num1 == numRandom[1] || num1 == numRandom[2]) {
                    numero1 = "A";
                } else {
                    numero1 = "R";
                }

                System.out.println("Numero 2");
                String numero2 = "";
                int num2 = sn.nextInt();
                if (num2 == numRandom[1]) {
                    numero2 = "V";
                    aciertos++;
                } else if (num2 == numRandom[0] || num2 == numRandom[2]) {
                    numero2 = "A";
                } else {
                    numero2 = "R";
                }

                System.out.println("Numero 3");
                String numero3 = "";
                int num3 = sn.nextInt();
                if (num3 == numRandom[2]) {
                    numero3 = "V";
                    aciertos++;
                } else if (num3 == numRandom[1] || num3 == numRandom[0]) {
                    numero3 = "A";
                } else {
                    numero3 = "R";
                }
                System.out.println(num1 + " " + num2 + " " + num3 + "\t" + numero1 + " " + numero2 + " " + numero3);
                if (aciertos == 3) {
                    System.out.println("Enhorabuena. Has ganado en " + numRondas + " rondas.");
                    System.out.println("Numeros: " + Arrays.toString(numRandom));
                }
                if (numRondas == MAX_RONDAS) {
                    System.out.println("Se acabaron las rondas. Has perdido.");
                    System.out.println("Numeros: " + Arrays.toString(numRandom));
                    break;
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("ERROR. Introduzca un numero entre 0-9.");
        }
        salir();
    }
//    public static int[] generarArrayAleatorios() {
//        Random r = new Random();
//        int[] random = new int[3];
//        random[0] = r.nextInt(10);
//        do {
//            random[1] = r.nextInt(10);
//        } while (random[1] == random[0]);
//        do {
//            random[2] = r.nextInt(10);
//        } while (random[2] == random[0] || random[2] == random[1]);
//        return random;
//    }

    public static void generarArrayAleatorios(int[] clave) {
        Random r = new Random();
        for (int i = 0; i < clave.length; i++) {
            clave[i] = -1;
        }

        int digito;
        boolean repetido;
        for (int i = 0; i < clave.length; i++) {

            do {
                repetido = false;

                digito = r.nextInt(10);

                for (int j = 0; j < i; j++) {
                    if (digito == clave[j]) {
                        repetido = true;
                    }
                }
            } while (repetido);

            clave[i] = digito;

        }

    }

    public static void salir() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;

        System.out.println("¿Quieres intentarlo otra vez?(S/N)");
        do {

            String opcion = sn.next();
            if ("s".equalsIgnoreCase(opcion)) {
                iniciarPrograma();
                salir = true;

            } else if ("n".equalsIgnoreCase(opcion)) {
                System.out.println("Fin del juego. Hasta luego.");
                salir = true;
            } else {
                System.out.println("¡ERROR!. Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        } while (!salir);
    }
}
