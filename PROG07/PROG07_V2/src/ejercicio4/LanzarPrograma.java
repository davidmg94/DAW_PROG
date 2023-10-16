package ejercicio4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LanzarPrograma {

    static final ArrayList<CuerpoCeleste> cuerposCelestes = new ArrayList<>();
    static CuerpoCeleste cc = new CuerpoCeleste();

    public static void main(String[] args) {
        anadirCuerpoCeleste(cc);
    }

    public static void anadirCuerpoCeleste(CuerpoCeleste cc) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        do {
            try {
                System.out.println("Introduzca el código del Cuerpo Celeste.(Número de 3 dígitos).");
                int codigo = sn.nextInt();
                sn.nextLine();
                while (existeCuerpo(codigo)) {
                    System.out.println("Ya existe un Cuerpo Celeste registrado con ese codigo.");
                    System.out.println("Introduzca otro codigo.");
                    codigo = sn.nextInt();
                }
                System.out.println("Introduzca el nombre del Cuerpo Celeste.(Máximo 15 caracteres).");
                String nombre = sn.nextLine();

                System.out.println("Elija el tipo de Cuerpo Celeste.");
                String tipoCuerpo = eleccionTipoCuerpo();

                System.out.println("Introduzca el diametro del Cuerpo Celeste.(Número de máximo 6 dígitos).");
                int diametro = sn.nextInt();

                cc = new CuerpoCeleste(codigo, nombre, tipoCuerpo, diametro);
                cuerposCelestes.add(cc);
                if (cc.getCodigoCuerpo() == 0) {
                    cuerposCelestes.remove(cc);
                }
                if (salir()) {
                    salir = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Formato incorrecto." + e.getMessage());
                sn.next();
            } catch (Exception e) {
                System.out.println("Error inesperado.");
                sn.next();
            }
        } while (!salir);
    }

    public static String eleccionTipoCuerpo() {
        Scanner sn = new Scanner(System.in);
        int eleccion = 0;
        String tipoCuerpo = "";

        do {
            System.out.println("1. Luna.");
            System.out.println("2. Planeta enano.");
            System.out.println("3. Planeta.");

            try {
                eleccion = sn.nextInt();

                switch (eleccion) {
                    case 1:
                        tipoCuerpo = "luna";
                        break;
                    case 2:
                        tipoCuerpo = "planeta enano";
                        break;
                    case 3:
                        tipoCuerpo = "planeta";
                        break;
                    default:
                        System.out.println("¡ERROR! Introduzca una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR! Introduzca una opción válida.");
                sn.next();
                eleccion = -1;
            } catch (Exception e) {
                System.out.println("Error inesperado.");
                sn.next();
                eleccion = -1;
            }
        } while (eleccion != 1 && eleccion != 2 && eleccion != 3);

        return tipoCuerpo;
    }

    public static boolean existeCuerpo(int codigo) {
        for (CuerpoCeleste c : cuerposCelestes) {
            if (c.getCodigoCuerpo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public static void listarCuerposCelestes() {
        if (cuerposCelestes.isEmpty()) {
        } else {
            for (CuerpoCeleste c : cuerposCelestes) {
                System.out.println(c.toString());
            }
        }
    }

    public static boolean salir() {
        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        do {
            System.out.println("¿Quiere añadir mas Cuerpos Celestes? (S/N)");
            String continuar = sn.next();

            if ("n".equalsIgnoreCase(continuar)) {
                listarCuerposCelestes();
                System.out.println("Fin del programa. ¡Hasta luego!");
                salir = true;

            } else if ("s".equalsIgnoreCase(continuar)) {
                salir = true;
                anadirCuerpoCeleste(cc);
            } else {
                System.out.println("¡ERROR!. Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        } while (!salir);
        return salir;
    }
}
