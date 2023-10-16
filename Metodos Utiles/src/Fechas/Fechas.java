package Fechas;

import java.time.LocalDate;
import java.util.Scanner;

public class Fechas {
    
        public static boolean mayorFecha(LocalDate fecha) {
        return fecha.isAfter(LocalDate.now());
    }
        
        public static void comparaFecha(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la fecha en formato yyyy-MM-dd:");
        String fechaIngresadaStr = scanner.nextLine();

        // Convertir la fecha ingresada a LocalDate
        LocalDate fechaIngresada = LocalDate.parse(fechaIngresadaStr);

        boolean esMayor = Utilidades.mayorFecha(fechaIngresada);

        if (esMayor) {
            System.out.println("La fecha ingresada es mayor que la fecha actual.");
        } else {
            System.out.println("La fecha ingresada no es mayor que la fecha actual.");
        }
    }
}
