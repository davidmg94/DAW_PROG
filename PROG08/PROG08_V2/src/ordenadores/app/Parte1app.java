package ordenadores.app;

import ordenadores.modelo.Ordenador;
import java.util.InputMismatchException;
import java.util.Scanner;
import ordenadores.modelo.Portatil;
import ordenadores.modelo.Sobremesa;

public class Parte1app {

    private static final Ordenador ordenadores[] = new Ordenador[6];

    public static void main(String[] args) {
        System.out.println("Bienvenido a la tarea PROG08 parte 1.");
        generarArrayOrdenadores();
        mostrarOrdenadores();
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        Scanner sn = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 9) {
            try {
                System.out.println("Elija una opción");
                System.out.println(" 1. Mostrar todos los ordenadores");
                System.out.println(" 2. Mostrar todos los portátiles");
                System.out.println(" 3. Mostrar todos los sobremesa");
                System.out.println(" 4. Encender un ordenador");
                System.out.println(" 5. Apagar un ordenador");
                System.out.println(" 6. Dibujar un ordenador");
                System.out.println(" 7. Cargar portátiles");
                System.out.println(" 8. Descargar portátiles");
                System.out.println(" 9. Salir");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        mostrarOrdenadores();
                        break;
                    case 2:
                        mostrarPortatiles();
                        break;
                    case 3:
                        mostrarSobremesa();
                        break;
                    case 4:
                        encender();
                        break;
                    case 5:
                        apagar();
                        break;
                    case 6:
                        dibujar();
                        break;
                    case 7:
                        cargar();
                        break;
                    case 8:
                        descargar();
                        break;
                    case 9:
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

    private static void generarArrayOrdenadores() {
        Portatil miPortatil1 = new Portatil("c0043ns", "HP", "OMEN 16", (short) 8, "AMD Ryzen 7", (short) 4, "SSD", (byte) 22,300,false);
        Portatil miPortatil2 = new Portatil("15IAH7", "Lenovo ", "IdeaPad Gaming 3", (short) 4, "Intel Core i5", (short) 2, "HDD", (byte) 23,300, false);
        Portatil miPortatil3 = new Portatil("M6500QC", "ASUS", "VivoBook Pro 15", (short) 16, "AMD Ryzen 7", (short) 8, "SSD", (byte) 24,300,false);

        Sobremesa miSobremesa1 = new Sobremesa("10023724", "PcCom", "Gold Elite", (short) 8, "Intel Core i5", (short) 6, "HDD", "MSI B560M PRO-VDH", "GeForce RTX2060",false);
        Sobremesa miSobremesa2 = new Sobremesa("657XES", "MSI", "MAG Infinite S3", (short) 16, "Intel Core i7", (short) 8, "SSD", "MSI MPG B550 GAMING PLUS", "GeForce RTX3060",false);
        Sobremesa miSobremesa3 = new Sobremesa("D500TC", "ASUS ", "ExpertCenter D5", (short) 8, "Intel Core i5", (short) 2, "HDD", "GeForceGigabyte B760", "GeForce 1080",false);

        ordenadores[0] = miPortatil1;
        ordenadores[1] = miPortatil2;
        ordenadores[2] = miPortatil3;
        ordenadores[3] = miSobremesa1;
        ordenadores[4] = miSobremesa2;
        ordenadores[5] = miSobremesa3;
    }

    public static void mostrarOrdenadores() {
        System.out.println("Estos son los ordenadores almacenados:");
        for (Ordenador o : ordenadores) {
            System.out.println(o.toString());
        }
    }

    public static void mostrarPortatiles() {
        System.out.println("Estos son los portátiles almacenados:");
        for (Ordenador o : ordenadores) {
            if (o instanceof Portatil) {
                System.out.println(o.toString());
            }
        }
    }

    public static void mostrarSobremesa() {
        System.out.println("Estos son los sobremesa almacenados:");
        for (Ordenador o : ordenadores) {
            if (o instanceof Sobremesa) {
                System.out.println(o.toString());
            }
        }
    }

    public static void encender() {
        Scanner sn = new Scanner(System.in);
        byte opcion = -1;
        try {

            System.out.println("¿Que ordenador quiere encender?");
            System.out.println("---------------------");

            for (int i = 0; i < ordenadores.length; i++) {
                System.out.println("[" + i + "]" + ordenadores[i].toString());
            }

            opcion = sn.nextByte();
            for (int i = 0; i < ordenadores.length; i++) {
                if (opcion == i) {
                    ordenadores[i].arrancar();
                    System.out.println(ordenadores[i].toString());
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("¡ERROR! Introduzca un numero.");
            sn.next();
        }
    }

    public static void apagar() {
        Scanner sn = new Scanner(System.in);
        byte opcion = -1;
        try {
            System.out.println("¿Que ordenador quiere apagar?");
            System.out.println("---------------------");

            for (int i = 0; i < ordenadores.length; i++) {
                System.out.println("[" + i + "]" + ordenadores[i].toString());
            }

            opcion = sn.nextByte();
            for (int i = 0; i < ordenadores.length; i++) {
                if (opcion == i) {
                    ordenadores[i].apagar();
                    System.out.println(ordenadores[i].toString());
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("¡ERROR! Introduzca un numero.");
            sn.next();
        }
    }

    public static void dibujar() {
        Scanner sn = new Scanner(System.in);
        byte opcion = -1;
        try {
            System.out.println("¿Que ordenador quiere dibujar?");
            System.out.println("---------------------");

            for (int i = 0; i < ordenadores.length; i++) {
                System.out.println("[" + i + "]" + ordenadores[i].toString());
            }

            opcion = sn.nextByte();
            for (int i = 0; i < ordenadores.length; i++) {
                if (opcion == i) {
                    ordenadores[i].dibujar();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("¡ERROR! Introduzca un numero.");
            sn.next();
        }
    }

    public static void cargar() {

        Scanner sn = new Scanner(System.in);
        short carga = 0;
        try {
            System.out.println("¿Cuanta carga le quiere poner a los equipos?");
            carga = sn.nextShort();
            System.out.println("Cargando equipos...");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
            }

            for (Ordenador o : ordenadores) {
                if (o instanceof Portatil portatil) {

                    portatil.cargarBateria(carga);
                    System.out.println(o.toString());
                    Thread.sleep(1 * 1000);

                }
            }
            System.out.println("Equipos cargados.");
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println("¡ERROR! Introduzca un numero.");
            sn.next();
        }
    }

    public static void descargar() {
        Scanner sn = new Scanner(System.in);
        short descarga = 0;
        try {

            System.out.println("¿Cuanta carga le quiere quitar a los equipos?");
            descarga = sn.nextShort();
            System.out.println("Descargando equipos...");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
            }

            for (Ordenador o : ordenadores) {
                if (o instanceof Portatil portatil) {

                    portatil.descargarBateria(descarga);
                    System.out.println(o.toString());
                    Thread.sleep(1 * 1000);

                }
            }
            System.out.println("Equipos descargados.");
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println("¡ERROR! Introduzca un numero.");
            sn.next();
        }
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
