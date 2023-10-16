package ejercicios;

/**
 *
 * @author david
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @class Ejercicio 4. Clase para la elaboracion de un juego que permita al
 * usuario adivinar un numero aleatorio oculto, con un numero finito de
 * intentos.
 */
public class Ejercicio4 {

    // Metodo principal donde se definen las variables y se llama al metodo juego
    public static void adivinarNumero() {

        int NUM_INT_DEFAULT = 5;
        int NUM_MAX_DEFAULT = 10;
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        int numInt = NUM_INT_DEFAULT, numMax = NUM_MAX_DEFAULT;
        boolean jugarNuevamente = true;

        //Con este bucle cuando terminemos la partida nos preguntara si queremos echar otra
        while (jugarNuevamente) {
            juego(entrada, salir, numInt, numMax);

            System.out.print("¿Quieres jugar otra vez? (s/n): ");
            char otra = entrada.next().charAt(0);

            if (otra != 's' && otra != 'S') {
                jugarNuevamente = false;
                System.out.println("¡Gracias por jugar! ¡Hasta luego!");
            }
        }
    }

    // Metodo en el que se realiza la funcionalidad del juego por opciones
    private static void juego(Scanner entrada, boolean salir, int numInt, int numMax) {
        int opcion;
        //Bucle, mientras no sea la opcion salir realiza todos los pasos del juego
        while (!salir) {

            System.out.println("Este es un juego de adivinar números.\n");
            System.out.println("Elige entre las siguientes opciones:");

            //Se muestra el menu por pantalla con las tres opciones Configurar, Jugar y Salir
            System.out.println("1. Configurar juego");
            System.out.println("2. Jugar");
            System.out.println("3. Salir");

            //Comienzo de la captura de excepcion
            try {
                //Se solicita al usuario que introduzca el numero de una de las opciones mostradas
                System.out.println("Introduce un número: ");
                opcion = entrada.nextInt();
                // Bucle switch para la funcion de cada opcion
                switch (opcion) {
                    //Se le solicitará por teclado el número de intentos permitidos (numInt) y el número máximo  (numMax) generado.
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        System.out.println("Introduzca el número de intentos permitidos");
                        numInt = entrada.nextInt();
                        System.out.println("Introduzca el número máximo generado");
                        numMax = entrada.nextInt();
                        break;
                    //el programa generará un número aleatorio entre 0 y numMax que será el número a adivinar (numOculto). A partir de este momento, se le solicitarán al usuario números hasta adivinar el número oculto.
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        System.out.println("¡Adivina el número oculto entre 1 y " + numMax + "!");
                        int numOculto = (int) Math.floor(Math.random() * numMax + 1);
                        int intentosJugador = 1;
                        int numJugador = 0;
                        boolean acertado = false;
                        //bucle para observar si los intentos son menores que los definidos y no ha acertado
                        while (intentosJugador <= numInt && !acertado) {

                            System.out.println("Introduce un numero");
                            numJugador = entrada.nextInt();
                            //Si el usuario adivina el número, se mostrará un mensaje "Has ganado!. Has necesitado X intentos".
                            if (numJugador == numOculto) {
                                System.out.println("¡Has ganado!. Has necesitado " + intentosJugador + " intentos");
                                acertado = true;
                                salir = true;
                            } else {
                                //Se le proporcionan al usuario pistas si no ha ganado el juego.
                                if (numJugador > numOculto) {
                                    System.out.println("El numero oculto es menor");
                                } else {
                                    System.out.println("El numero oculto es mayor");
                                }
                                //Si se consume el número de intentos sin adivinar el número, se mostrará el mensaje "Perdiste!. Intentos consumidos".
                                if ((numInt - intentosJugador) == 0) {
                                    System.out.println("¡Perdiste!. Intentos consumidos.");
                                    intentosJugador++;
                                    salir = true;
                                } else {
                                    // Se muestran los intentos que quedan pendientes
                                    System.out.println("Te quedan " + (numInt - intentosJugador) + " intentos");
                                    intentosJugador++;
                                }
                            }
                        }
                        break;
                    //Se sale del juego si selecciona la opcion 3
                    case 3:
                        salir = true;
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3\n");
                }
                //Excecion capturada en el caso de que no se introduzcan numeros a la hora de seleccionar las opciones
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                entrada.next();
            }
        }
    }
}
