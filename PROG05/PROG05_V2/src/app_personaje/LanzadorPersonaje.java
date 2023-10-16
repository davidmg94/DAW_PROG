package app_personaje;

import excepcionespersonaje.ExcepcionPersonaje;
import excepcionespersonaje.ExcepcionRangoEstadisticas;
import java.util.InputMismatchException;
import java.util.Scanner;
import modeladopersonaje.Personaje;
import static modeladopersonaje.Personaje.MIN_STAT;
import static modeladopersonaje.Personaje.MAX_STAT;

public class LanzadorPersonaje {

    public static Personaje[] arrPersonajes = new Personaje[2];
    public static short personajesCreados = Personaje.getNumPersonajes();

    public static void rangoEstadisticas(byte stat) throws ExcepcionRangoEstadisticas {
        if (stat < MIN_STAT || stat > MAX_STAT) {
            throw new ExcepcionRangoEstadisticas("¡ERROR! La estadistica está fuera del rango. Valor máximo: " + MAX_STAT + ", Valor mínimo: " + MIN_STAT);
        }
    }

    public static void personajeCreado(Personaje p) throws ExcepcionPersonaje {
        if (p != null) {
            throw new ExcepcionPersonaje("El personaje de ese espacio ya ha sido creado");
        }
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        try {
            iniciarPrograma(sn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            sn.next();
        }
    }

    public static void iniciarPrograma(Scanner sn) {
        int opcion = 0;
        System.out.println("Bienvenido a este frenético juego de peleas.");

        while (opcion != 7) {
            try {
                System.out.println(" 1. Crear personaje 1.");
                System.out.println(" 2. Crear personaje 2.");
                System.out.println(" 3. Batalla.");
                System.out.println(" 4. Mostrar personajes.");
                System.out.println(" 5. Modificar personaje 1.");
                System.out.println(" 6. Modificar personaje 2.");
                System.out.println(" 7. Salir.");
                System.out.println("Elija una opción:");

                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        crearPersonaje(1);
                        break;
                    case 2:
                        crearPersonaje(2);
                        break;
                    case 3:
                        batalla();
                        break;
                    case 4:
                        mostrarPersonajes();
                        break;
                    case 5:
                        modificarPersonaje(1);
                        break;
                    case 6:
                        modificarPersonaje(2);
                        break;
                    case 7:
                        salir(sn);
                        break;
                    default:
                        System.out.println("¡ERROR! Introduzca una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR! Introduzca una opción válida.");
                sn.next();
            }
        }
    }

    public static void salir(Scanner sn) {
        boolean salir = false;
        do {
            System.out.println("¿Quiere salir? (S/N)");
            String continuar = sn.next();

            if ("s".equalsIgnoreCase(continuar)) {
                mostrarPersonajes();
                System.out.println("Se han creado un total de " + personajesCreados + " personajes.");
                System.out.println("Fin del juego. ¡Hasta luego!");
                salir = true;

            } else if ("n".equalsIgnoreCase(continuar)) {
                salir = true;
                iniciarPrograma(sn);
            } else {
                System.out.println("¡ERROR!. Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        } while (!salir);
    }

    public static void crearPersonaje(int numPersonaje) {
        Scanner sn = new Scanner(System.in);
        try {
            if (arrPersonajes[numPersonaje - 1] != null) {
                personajeCreado(arrPersonajes[numPersonaje - 1]);
            }

            System.out.println("Bienvenido a la pantalla de creación de personajes.");

            System.out.println("Introduzca el nombre del personaje:");
            String nombre = sn.next();

            byte inteligencia, fuerza;

            do {
                System.out.println("Introduzca la inteligencia del personaje (0-100):");
                inteligencia = sn.nextByte();
                try {
                    rangoEstadisticas(inteligencia);
                } catch (ExcepcionRangoEstadisticas e) {
                    System.out.println(e.getMessage());
                }
            } while (inteligencia < MIN_STAT || inteligencia > MAX_STAT);

            do {
                System.out.println("Introduzca la fuerza del personaje (0-100):");
                fuerza = sn.nextByte();
                try {
                    rangoEstadisticas(fuerza);
                } catch (ExcepcionRangoEstadisticas e) {
                    System.out.println(e.getMessage());
                }
            } while (fuerza < MIN_STAT || fuerza > MAX_STAT);

            Personaje personaje = new Personaje(nombre, inteligencia, fuerza);
            arrPersonajes[numPersonaje - 1] = personaje;
            System.out.println("¡Personaje " + numPersonaje + " creado!");
            System.out.println("Datos del personaje " + numPersonaje + ": " + personaje.toString());
        } catch (InputMismatchException e) {
            System.out.println("¡ERROR!: Se ha introducido un valor no válido.");
        } catch (ExcepcionPersonaje e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarPersonajes() {
        for (int i = 0; i < arrPersonajes.length; i++) {
            if (arrPersonajes[i] != null) {
                System.out.println("Datos del personaje " + (i + 1) + ": " + arrPersonajes[i].toString());
            } else {
                System.out.println("El personaje " + (i + 1) + " no ha sido creado.");
            }
        }
    }

    public static void modificarPersonaje(int numPersonaje) {
        Scanner sn = new Scanner(System.in);

        System.out.println("Bienvenido a la pantalla de modificación de personajes.");
        System.out.println("Se va a modificar los datos del personaje " + numPersonaje);
        boolean salir = false;
        do {
            System.out.println("¿Quiere continuar? (S/N)");
            String continuar = sn.next();

            if ("s".equalsIgnoreCase(continuar)) {
                try {
                    System.out.println("Introduzca el nombre del personaje.");
                    String nombre = sn.next();
                    byte inteligencia, fuerza;

                    do {
                        System.out.println("Introduzca la inteligencia del personaje (0-100):");
                        inteligencia = sn.nextByte();
                        try {
                            rangoEstadisticas(inteligencia);
                        } catch (ExcepcionRangoEstadisticas e) {
                            System.out.println(e.getMessage());
                        }
                    } while (inteligencia < MIN_STAT || inteligencia > MAX_STAT);

                    do {
                        System.out.println("Introduzca la fuerza del personaje (0-100):");
                        fuerza = sn.nextByte();
                        try {
                            rangoEstadisticas(fuerza);
                        } catch (ExcepcionRangoEstadisticas e) {
                            System.out.println(e.getMessage());
                        }
                    } while (fuerza < MIN_STAT || fuerza > MAX_STAT);

                    if (numPersonaje == 1) {
                        arrPersonajes[0].setNombre(nombre);
                        arrPersonajes[0].setFuerza(fuerza);
                        arrPersonajes[0].setInteligencia(inteligencia);
                    } else {
                        arrPersonajes[1].setNombre(nombre);
                        arrPersonajes[1].setFuerza(fuerza);
                        arrPersonajes[1].setInteligencia(inteligencia);
                    }

                    System.out.println("Personaje " + numPersonaje + " modificado con éxito.");
                    System.out.println("Datos actualizados del personaje " + numPersonaje + ": " + arrPersonajes[numPersonaje - 1].toString());

                } catch (InputMismatchException e) {
                    System.out.println("¡ERROR! Se ha introducido un valor no válido.");
                }
                salir = true;
            } else if ("n".equalsIgnoreCase(continuar)) {
                salir = true;
            } else {
                System.out.println("¡ERROR! Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        } while (!salir);
    }

    public static void batalla() {
        if (arrPersonajes[0] == null && arrPersonajes[1] == null) {
            System.out.println("No se puede iniciar la batalla porque no se ha creado ningún personaje.");
            return;
        } else if (arrPersonajes[0] == null) {
            System.out.println("No se puede iniciar la batalla porque el personaje 1 no ha sido creado.");
            return;
        } else if (arrPersonajes[1] == null) {
            System.out.println("No se puede iniciar la batalla porque el personaje 2 no ha sido creado.");
            return;
        }
        arrPersonajes[0].batalla(arrPersonajes[1]);
    }
}
