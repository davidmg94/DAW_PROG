package ejercicio5;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Bidimensionales {

    static final byte MAX_RONDAS = 8;

    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Bienvenido al juego de la Mosca. Tienes " + MAX_RONDAS + " rondas para encontrar las moscas escondidas.");
        System.out.println("Existen dos modos de juego FACIL y DIFICIL.");
        System.out.println("FACIL\n-----------");
        System.out.println("En cada ronda tendras tantas oportunidades de encontrar las moscas como moscas haya escondidadas.");
        System.out.println("Por ejemplo, si hay 2 moscas, por cada ronda te pedirán el escondite de cada mosca.");
        System.out.println("DIFICL\n-----------");
        System.out.println("Solo tendras una oportunidad por ronda de encontrar a las moscas.");
        System.out.println("Espero que lo hayas entendido. Diviertete.\n");
        System.out.println("Elija dificultad");
        dificultad();
    }

    public static boolean moscaCerca(boolean[][] esconditeMoscas, byte f, byte c) {
        for (int i = f - 1; i <= f + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i >= 0 && i < esconditeMoscas.length
                        && j >= 0 && j < esconditeMoscas[0].length
                        && esconditeMoscas[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void revolotearMoscas(boolean[][] esconditeMoscas, byte f, byte c) {
        for (int i = 0; i < esconditeMoscas.length; i++) {
            for (int j = 0; j < esconditeMoscas[0].length; j++) {
                if (esconditeMoscas[i][j]) {
                    esconditeMoscas[i][j] = false;
                    int newI, newJ;
                    do {
                        newI = new Random().nextInt(esconditeMoscas.length);
                        newJ = new Random().nextInt(esconditeMoscas[0].length);
                    } while (esconditeMoscas[newI][newJ]);

                    esconditeMoscas[newI][newJ] = true;
                }
            }
        }
    }

    public static void mostrarMatriz(boolean[][] esconditeMoscas) {
        for (byte i = 0; i < esconditeMoscas.length; i++) {
            for (byte j = 0; j < esconditeMoscas[0].length; j++) {
                System.out.print(esconditeMoscas[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void dificultad() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;

        System.out.println("¿Quieres el modo facil o el dificil?(F/D)");
        do {

            String opcion = sn.next();
            if ("f".equalsIgnoreCase(opcion)) {
                System.out.println("Modo de dificultad: FACIL.");
                salir = true;
                facil();

            } else if ("d".equalsIgnoreCase(opcion)) {
                System.out.println("Modo de dificultad: DIFICIL.");
                salir = true;
                dificil();
            } else {
                System.out.println("¡ERROR!. Debe introducir uno de los siguientes valores (F, f, D, d)");
            }
        } while (!salir);
    }

    public static void salir() {
        Scanner sn = new Scanner(System.in);

        System.out.println("¿Quieres intentarlo otra vez?(S/N)");
        while (true) {

            String opcion = sn.next();
            if ("s".equalsIgnoreCase(opcion)) {
                iniciarPrograma();

            } else if ("n".equalsIgnoreCase(opcion)) {
                System.out.println("Fin del juego. Hasta luego.");
                System.exit(0);
            } else {
                System.out.println("¡ERROR!. Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        }
    }

    public static void facil() {
        try {
            Scanner sn = new Scanner(System.in);
            Random r = new Random();
            byte numRondas = 0;

            System.out.println("Elija el tamaño de la matriz.");
            System.out.println("NOTA: A mayor tamaño de la matriz, mayor dificultad.");
            System.out.println("Filas");
            byte f = sn.nextByte();

            System.out.println("Columnas");
            byte c = sn.nextByte();

            System.out.println("Elija el numero de moscas");
            System.out.println("NOTA: A mayor numero de moscas, mayor dificultad.");

            byte numMoscas = sn.nextByte();

            boolean[][] esconditeMoscas = new boolean[f][c];
            System.out.println("Hay " + numMoscas + " moscas escondidas");

            byte filaMosca = 0, colMosca = 0;
            for (byte i = 0; i < numMoscas; i++) {
                filaMosca = (byte) r.nextInt(f);
                colMosca = (byte) r.nextInt(c);
                esconditeMoscas[filaMosca][colMosca] = true;
            }
            System.out.println("Las moscas se han escondido.");
            System.out.println("Tamaño de la matriz: Filas: " + f + " Columnas: " + c);

//            System.out.println("Matriz");
//            mostrarMatriz(esconditeMoscas);
            boolean moscaCazada = false;
            while (!moscaCazada && numRondas < MAX_RONDAS) {
                numRondas++;
                System.out.println("Ronda: " + numRondas);
                for (int i = 0; i < numMoscas; i++) {

                    do {
                        System.out.println("Introduzca la fila donde cree que hay una mosca.(0-" + (esconditeMoscas.length - 1) + ")");
                        f = sn.nextByte();
                        if (f < 0 || f >= esconditeMoscas.length) {
                            System.out.println("ERROR: Introduce un número entre 0 y " + (esconditeMoscas[0].length - 1) + ".");
                            f = sn.nextByte();
                        }
                    } while (f < 0 || f >= esconditeMoscas.length);

                    do {
                        System.out.println("Introduzca la columna donde cree que hay una mosca.(0-" + (esconditeMoscas[0].length - 1) + ")");
                        c = sn.nextByte();
                        if (c < 0 || c >= esconditeMoscas[0].length) {
                            System.out.println("ERROR: Introduce un número entre 0 y " + (esconditeMoscas[0].length - 1) + ".");
                            c = sn.nextByte();
                        }
                    } while (c < 0 || c >= esconditeMoscas[0].length);

                    if (esconditeMoscas[f][c]) {
                        System.out.println("Has cazado una mosca");
                        System.out.println("Quedan " + (numMoscas - 1) + " moscas por cazar");
                        esconditeMoscas[f][c] = false;
                        numMoscas--;
                        if (numMoscas == 0) {
                            System.out.println("Enhorabuena. Has ganado.");
                            moscaCazada = true;
                            break;
                        } else if (moscaCerca(esconditeMoscas, f, c)) {
                            System.out.println("Ademas, habia una mosca justo al lado, pero se ha asustado y se ha movido de posicion.");
                            esconditeMoscas[f][c] = false;
                            revolotearMoscas(esconditeMoscas, f, c);
//                            mostrarMatriz(esconditeMoscas);
                        }

                    } else if (!moscaCerca(esconditeMoscas, f, c)) {
                        System.out.println("Lastima, no habia ninguna mosca cerca. Ambas se quedan en su posicion");
//                        mostrarMatriz(esconditeMoscas);

                    } else {
                        System.out.println("Casi! Habia una mosca justo al lado, pero se ha asustado y se ha movido de posicion.");
                        esconditeMoscas[f][c] = false;
                        revolotearMoscas(esconditeMoscas, f, c);
//                        mostrarMatriz(esconditeMoscas);
                    }

                    if (numRondas == MAX_RONDAS) {
                        System.out.println("Se acabaron las rondas. Has perdido.");
                        mostrarMatriz(esconditeMoscas);
                        break;
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR. Introduzca un numero entre 0-7.");
        }
        salir();
    }

    public static void dificil() {
        try {
            Scanner sn = new Scanner(System.in);
            Random r = new Random();
            byte numRondas = 0;

            System.out.println("Elija el tamaño de la matriz.");
            System.out.println("NOTA: A mayor tamaño de la matriz, mayor dificultad.");

            System.out.println("Filas");
            byte f = sn.nextByte();

            System.out.println("Columnas");
            byte c = sn.nextByte();

            System.out.println("Elija el numero de moscas");
            System.out.println("NOTA: A mayor numero de moscas, mayor dificultad.");

            byte numMoscas = sn.nextByte();

            boolean[][] esconditeMoscas = new boolean[f][c];
            System.out.println("Hay " + numMoscas + " moscas escondidas");

            byte filaMosca = 0, colMosca = 0;
            for (byte i = 0; i < numMoscas; i++) {
                filaMosca = (byte) r.nextInt(f);
                colMosca = (byte) r.nextInt(c);
                esconditeMoscas[filaMosca][colMosca] = true;
            }
            System.out.println("Las moscas se han escondido.");
            System.out.println("Tamaño de la matriz: Filas: " + f + " Columnas: " + c);

//            System.out.println("Matriz");
//            mostrarMatriz(esconditeMoscas);
            boolean moscaCazada = false;
            while (!moscaCazada && numRondas < MAX_RONDAS) {
                numRondas++;
                System.out.println("Ronda: " + numRondas);

                do {
                    System.out.println("Introduzca la fila donde cree que hay una mosca.(0-" + (esconditeMoscas.length - 1) + ")");
                    f = sn.nextByte();
                    if (f < 0 || f >= esconditeMoscas.length) {
                        System.out.println("ERROR: Introduce un número entre 0 y " + (esconditeMoscas[0].length - 1) + ".");
                        f = sn.nextByte();
                    }
                } while (f < 0 || f >= esconditeMoscas.length);

                do {
                    System.out.println("Introduzca la columna donde cree que hay una mosca.(0-" + (esconditeMoscas[0].length - 1) + ")");
                    c = sn.nextByte();
                    if (c < 0 || c >= esconditeMoscas[0].length) {
                        System.out.println("ERROR: Introduce un número entre 0 y " + (esconditeMoscas[0].length - 1) + ".");
                        c = sn.nextByte();
                    }
                } while (c < 0 || c >= esconditeMoscas[0].length);

                if (esconditeMoscas[f][c]) {
                    System.out.println("Has cazado una mosca");
                    System.out.println("Quedan " + (numMoscas - 1) + " moscas por cazar");
                    esconditeMoscas[f][c] = false;
                    numMoscas--;
                    if (numMoscas == 0) {
                        System.out.println("Enhorabuena. Has ganado.");
                        moscaCazada = true;
                        break;
                    } else if (moscaCerca(esconditeMoscas, f, c)) {
                        System.out.println("Ademas, habia una mosca justo al lado, pero se ha asustado y se ha movido de posicion.");
                        esconditeMoscas[f][c] = false;
                        revolotearMoscas(esconditeMoscas, f, c);
//                        mostrarMatriz(esconditeMoscas);
                    }

                } else if (!moscaCerca(esconditeMoscas, f, c)) {
                    System.out.println("Lastima, no habia ninguna mosca cerca. Ambas se quedan en su posicion");
//                    mostrarMatriz(esconditeMoscas);

                } else {
                    System.out.println("Casi! Habia una mosca justo al lado, pero se ha asustado y se ha movido de posicion.");
                    esconditeMoscas[f][c] = false;
                    revolotearMoscas(esconditeMoscas, f, c);
//                    mostrarMatriz(esconditeMoscas);
                }

                if (numRondas == MAX_RONDAS) {
                    System.out.println("Se acabaron las rondas. Has perdido.");
                    mostrarMatriz(esconditeMoscas);
                    break;
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("ERROR. Introduzca un numero entre 0-7.");
        }
        salir();
    }

}
