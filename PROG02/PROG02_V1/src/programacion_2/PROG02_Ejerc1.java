//PROG02_Ejerc1 

package programacion_2;

import java.util.Scanner;
/**     
*
* @author David
*/
public class PROG02_Ejerc1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); 
        float c1, c2, x; 
        System.out.println("Calcular el valor de X en la ecuación C1x+C2=0"); 
        System.out.println("Introduzca el valor del coeficiente 1: "); 
        c1 = userInput.nextFloat(); 
        System.out.println("Introduzca el valor del coeficiente 2: "); 
        c2 = userInput.nextFloat(); 
        x = -c2 / c1; 
        System.out.printf("%.4fx + %.4f = 0%n", c1, c2); 
        System.out.printf("x = -%.4f/%.4f%n", c2, c1); 
        System.out.printf("El valor de x es: %.4f%n", x); 
    } 
}
