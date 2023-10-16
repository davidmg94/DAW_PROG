//PROG02_Ejerc2

package programacion_2;

import java.util.Scanner;
/**     
*
* @author David
*/
public class PROG02_Ejerc2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); 
        int alumnas, alumnos, total; 
        float porcentajeChicas, porcentajeChicos; 
        System.out.println("Alumnos matriculados en el módulo de Bases de Datos"); 
        System.out.println("\nIntroduce el número de alumnas matriculadas: "); 
        alumnas = entrada.nextInt(); 
        System.out.println("Introduce el número de alumnos matriculados: "); 
        alumnos = entrada.nextInt(); 
        total = alumnas + alumnos; 
        porcentajeChicas = (float) alumnas / total * 100; 
        porcentajeChicos = (float) alumnos / total * 100; 
        System.out.printf("%nHay un total de %d alumnos matriculados%n", total); 
        System.out.printf("El %.1f%% de los alumnos son chicas%n", porcentajeChicas); 
        System.out.printf("El %.1f%% de los alumnos son chicos%n", porcentajeChicos); 
    } 
}