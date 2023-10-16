package general.app;

import electrodomesticos.Aspirador;
import general.interfaces.Reparable;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import ordenadores.modelo.Portatil;
import ordenadores.modelo.Sobremesa;

public class Parte2app {

    private static final Reparable reparables[] = new Reparable[6];
    private static final Portatil portatiles[] = new Portatil[3];

    public static void main(String[] args) {
        System.out.println("Bienvenido a la tarea PROG08 parte 2.");
        generarArrayReparables();
        generarArrayPortatiles();
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        Scanner sn = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 4) {
            try {
                System.out.println("Elija una opción");
                System.out.println(" 1. Reparar los equipos.");
                System.out.println(" 2. Mostrar los portátiles desordenados.");
                System.out.println(" 3. Mostrar los portatiles ordenados.");
                System.out.println(" 4. Salir");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        reparaTodo(reparables);
                        break;
                    case 2:
                        portatilesDesordenados();
                        break;
                    case 3:
                        portatilesOrdenados(portatiles);
                        break;
                    case 4:
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

    public static void generarArrayReparables() {
        Portatil miPortatil1 = new Portatil("c0043ns", "HP", "OMEN 16", (short) 8, "AMD Ryzen 7", (short) 4, "SSD", (byte) 22, 300, false);
        Portatil miPortatil2 = new Portatil("15IAH7", "Lenovo ", "IdeaPad Gaming 3", (short) 4, "Intel Core i5", (short) 2, "HDD", (byte) 23, 300, false);
        Sobremesa miSobremesa1 = new Sobremesa("10023724", "PcCom", "Gold Elite", (short) 8, "Intel Core i5", (short) 6, "HDD", "MSI B560M PRO-VDH", "GeForce RTX2060", false);
        Sobremesa miSobremesa2 = new Sobremesa("657XES", "MSI", "MAG Infinite S3", (short) 16, "Intel Core i7", (short) 8, "SSD", "MSI MPG B550 GAMING PLUS", "GeForce RTX3060", false);
        Aspirador miAspirador1 = new Aspirador("Dyson v15", (byte) 3, (byte) 88);
        Aspirador miAspirador2 = new Aspirador("Xiaomi G10", (byte) 2, (byte) 60);

        reparables[0] = miPortatil1;
        reparables[1] = miPortatil2;
        reparables[2] = miSobremesa1;
        reparables[3] = miSobremesa2;
        reparables[4] = miAspirador1;
        reparables[5] = miAspirador2;
    }

    public static void generarArrayPortatiles() {
        Portatil miPortatil1 = new Portatil("c0043ns", "HP", "OMEN 16", (short) 8, "AMD Ryzen 7", (short) 4, "SSD", (byte) 32, 300, false);
        Portatil miPortatil2 = new Portatil("15IAH7", "Lenovo ", "IdeaPad Gaming 3", (short) 4, "Intel Core i5", (short) 2, "HDD", (byte) 19, 300, false);
        Portatil miPortatil3 = new Portatil("M6500QC", "ASUS", "VivoBook Pro 15", (short) 16, "AMD Ryzen 7", (short) 8, "SSD", (byte) 24, 300, false);

        portatiles[0] = miPortatil1;
        portatiles[1] = miPortatil2;
        portatiles[2] = miPortatil3;
    }

    public static void reparaTodo(Reparable cosas[]) {
        System.out.println("Reparaciones iniciadas");
        for (Reparable r : cosas) {
            r.reparar();
        }
    }

    public static void portatilesDesordenados() {
        for (Portatil p : portatiles) {
            System.out.println(p.toString());
        }
    }

    public static void portatilesOrdenados(Portatil[] portatil) {
        Arrays.sort(portatil);
        for (Portatil p : portatil) {
            System.out.println(p.toString());
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
