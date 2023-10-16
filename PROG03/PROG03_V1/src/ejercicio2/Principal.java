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

        System.out.println("El valor del primer n�mero racional es " +r1.imprime());
        System.out.println("El valor del segundo n�mero racional es " +r2.imprime());
        System.out.println("El valor del numerador del n�mero racional "+ r1.imprime() + " es: " + r1.getNumerador());
        System.out.println("SUMAR");
        System.out.println("La suma de los n�meros racionales " +r1.toString()+" + " +r2.toString()+" = "+r1.sumar(r1, r2));
        System.out.println("Uso del metodo Sumar pas�ndole como par�metro �nicamente un n�mero Racional.");
        System.out.println("Al n�mero Racional " +r1.toString()+" le sumamos el n�mero " + r2.toString()+" obteniendo el numero " +r1.sumar(r2));
        System.out.println("RESTA");
        System.out.println("La resta de los n�meros racionales " +r1.toString() +" - " +r2.toString() +" = " +r1.restar(r1, r2));
        System.out.println("Uso del metodo Restar pas�ndole como par�metro �nicamente un n�mero");
        System.out.println("Al n�mero Racional " + r1.toString()+" le restamos el n�mero " +r2.toString() +" obteniendo el numero " +r1.restar(r2));
        System.out.println("MULTIPLICACION");
        System.out.println("La multiplicaci�n de los n�meros racionales " +r1.toString() +" * " +r2.toString() +" = " +r1.multiplicar(r1, r2));
        System.out.println("Uso del metodo Multiplicar pas�ndole como par�metro �nicamente un n�mero");
        System.out.println("Al n�mero Racional " + r1.toString()+" le multiplicamos el n�mero " +r2.toString() +" obteniendo el numero " +r1.multiplicar(r2));
        System.out.println("IGUALES??");
        System.out.print("Los n�meros racionales "+r1.toString()+" y "+r2.toString());
        System.out.println(r1.igualesR(r1, r2) ? " son iguales" : " no son iguales");

    }

}
