package supuesto3;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {

    private static final Random rand = new Random();

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useLocale(Locale.US);

        System.out.println("Bienvenido a este ejercicio.");

        int opcion = 0;
        while (opcion != 5) {
            try {
                mostrarMenu();
                opcion = sn.nextInt();
                int random = generarRandom();

                switch (opcion) {
                    case 1:
                        generarFraseMotivacional(random);
                        break;
                    case 2:
                        generarFrasePesimista(random);
                        break;
                    case 3:
                        generarChiste(random);
                        break;
                    case 4:
                        generarRefran(random);
                        break;
                    case 5:
                        System.out.println("Fin del programa. Hasta luego");
                        break;
                    default:
                        System.out.println("¡ERROR!. Introduzca una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR!. Introduzca una opción válida.");
                sn.nextLine();
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("1. Mostrar frase motivacional.");
        System.out.println("2. Mostrar fase pesimista.");
        System.out.println("3. Contar un chiste.");
        System.out.println("4. Decir un refrán.");
        System.out.println("5. Salir.");
        System.out.println("Ingrese una opcion valida:");

    }

    public static int generarRandom() {
        int random = rand.nextInt(3) + 1;
        return random;
    }

    public static void generarFraseMotivacional(int random) {
        switch (random) {
            case 1:
                System.out.println("Puedo aceptar el fracaso pero no puedo aceptar no intentarlo");
                break;
            case 2:
                System.out.println("El conocimiento es poder");

                break;
            case 3:
                System.out.println("El hombre que mueve montañas comienza cargando pequeñas piedras");

                break;
            default:
                System.out.println("¡ERROR!. Introduzca una opción válida.");
        }
    }

    public static void generarFrasePesimista(int random) {
        switch (random) {
            case 1:
                System.out.println("Quien espera mucho puede esperar poco");
                break;
            case 2:
                System.out.println("No hay más que un problema filosófico verdaderamente serio: el suicidio");
                break;
            case 3:
                System.out.println("Lo más terrible se aprende enseguida y lo hermoso nos cuesta la vida");
                break;
            default:
                System.out.println("¡ERROR!. Introduzca una opción válida.");
        }
    }

    public static void generarChiste(int random) {
        switch (random) {
            case 1:
                System.out.println("¿Qué le dice un jardinero a otro? Nos  vemos cuando podamos.");
                break;
            case 2:
                System.out.println("Iba a contar un chiste sobre sodio... pero Na.");
                break;
            case 3:
                System.out.println("¿Qué pasa si se va la luz en una escuela privada? Que no se ve ni un pijo.");
                break;
            default:
                System.out.println("¡ERROR!. Introduzca una opción válida.");
        }
    }

    public static void generarRefran(int random) {
        switch (random) {
            case 1:
                System.out.println("Cuando el grajo vuela bajo, hace un frío del carajo.");
                break;
            case 2:
                System.out.println("A buen entendedor, pocas palabras bastan.");
                break;
            case 3:
                System.out.println("A caballo regalado no le mires el diente.");
                break;
            default:
                System.out.println("¡ERROR!. Introduzca una opción válida.");
        }
    }
}
