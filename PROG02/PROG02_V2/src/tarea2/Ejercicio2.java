package tarea2;

public class Ejercicio2 {

    public static void main(String[] args) {
        short x = 7;
        int y = 5;
        float f1 = 13.5f;
        float f2 = 8f;

        System.out.println("El valor de x es "+ x + " y el valor de y es " + y);
        System.out.println("El resultado de x + y es " + (x + y));
        System.out.println("El resultado de x - y es " + (x - y));
        System.out.printf("División entera: x / y = %d\n", (x / y));
        System.out.println("Resto de la división entera: x % y = " + (x % y));
        System.out.printf("El valor de f1 es %.2f y el de f2 es %.2f\n", f1, f2);
        System.out.printf("El resultado de f1 / f2 es %.2f\n" , (f1 / f2));
    }
}
