package Salir;

import java.util.Scanner;

public class Salir {
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
}
