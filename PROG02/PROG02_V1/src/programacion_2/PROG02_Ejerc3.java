package programacion_2;

import java.util.Scanner;

public class PROG02_Ejerc3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa un número entero de 5 dígitos: ");
        int numero = scanner.nextInt();
        
        if (numero >= 10000 && numero <= 99999) {
            int digito;
            int numeroReverso = 0;
            
            while (numero > 0) {
                digito = numero % 10;
                numeroReverso = numeroReverso * 10 + digito;
                numero /= 10;
            }
            
            System.out.println("Número al revés: " + numeroReverso);
        } else {
            System.out.println("El número debe tener 5 dígitos.");
        }
    }
}
//ALTERNATIVA
//import java.util.Scanner;
//
//public class PROG02_Ejerc3 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        
//        System.out.print("Ingresa un número entero de 5 dígitos: ");
//        int numero = scanner.nextInt();
//        
//        if (numero >= 10000 && numero <= 99999) {
//            System.out.print("Número al revés: ");
//            while (numero > 0) {
//                System.out.print(numero % 10);
//                numero /= 10;
//            }
//        } else {
//            System.out.println("El número debe tener 5 dígitos.");
//        }
//    }
//}

//ALTERNATIVA(PARA CUALQUIER NUMERO)
//
//import java.util.Scanner;
//
//public class PROG02_Ejerc3 {
//    public static void main(String[] args) {
//       Scanner entrada = new Scanner (System.in);
//        System.out.println("Introduzca un numero de 5 dígitos: ");
//        int numero = entrada.nextInt();
//        invertido(numero);
//    }
//    public static void invertido(int numero){
//        if (numero>0){
//        System.out.print(numero%10);
//        invertido(numero/10);
//        }
//    }
//}