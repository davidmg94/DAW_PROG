package ejercicio2;

import numeros.Racional;

/**
 *
 * @author David
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Racional r1 = new Racional(4);
        Racional r2 = new Racional(8, 7);

        System.out.println("El valor del primer número racional es " +r1.imprime());
        System.out.println("El valor del segundo número racional es " +r2.imprime());
        System.out.println("El valor del numerador del número racional "+ r1.imprime() + " es: " + r1.getNumerador());
        System.out.println("SUMAR");
        System.out.println("La suma de los números racionales " +r1.toString()+" + " +r2.toString()+" = "+r1.sumar(r1, r2));
        System.out.println("Uso del metodo Sumar pasándole como parámetro únicamente un número Racional.");
        System.out.println("Al número Racional " +r1.toString()+" le sumamos el número " + r2.toString()+" obteniendo el numero " +r1.sumar(r2));
        System.out.println("RESTA");
        System.out.println("La resta de los números racionales " +r1.toString() +" - " +r2.toString() +" = " +r1.restar(r1, r2));
        System.out.println("Uso del metodo Restar pasándole como parámetro únicamente un número");
        System.out.println("Al número Racional " + r1.toString()+" le restamos el número " +r2.toString() +" obteniendo el numero " +r1.restar(r2));
        System.out.println("MULTIPLICACION");
        System.out.println("La multiplicación de los números racionales " +r1.toString() +" * " +r2.toString() +" = " +r1.multiplicar(r1, r2));
        System.out.println("Uso del metodo Multiplicar pasándole como parámetro únicamente un número");
        System.out.println("Al número Racional " + r1.toString()+" le multiplicamos el número " +r2.toString() +" obteniendo el numero " +r1.multiplicar(r2));
        System.out.println("IGUALES??");
        System.out.print("Los números racionales "+r1.toString()+" y "+r2.toString());
        System.out.println(r1.igualesR(r1, r2) ? " son iguales" : " no son iguales");

    }

}
