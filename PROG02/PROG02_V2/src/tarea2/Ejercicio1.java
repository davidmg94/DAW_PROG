package tarea2;
/**
 *
 * @author David
 */
public class Ejercicio1 {

    static boolean aprobado;
    final static float VALOR_MIN = 4.5f;
    static char tipoAlum;
    static float nota;
    static int mesNacimiento;

    public static void main(String[] args) {
        aprobado = true;
        tipoAlum = 'M';
        nota = 6.96f;
        mesNacimiento = 5;
        
        System.out.println("EJERCICIO DE USO DE VARIABLES:");
        System.out.println("\tEl alumno está aprobado: " + aprobado);
        System.out.printf("\tEl valor MINIMO es %.2f%n", VALOR_MIN);
        System.out.println("\tEl tipo de alumno " + tipoAlum);
        System.out.printf("\tLa nota del alumno es %.2f%n", nota);
        System.out.println("\tEl mes de nacimiento es " + mesNacimiento);
    }
}
