package ejercicio1;
/**
 *
 * @author David
 */
public class Principal {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instanciamos el objeto objFecha1 con el primer constructor de la clase Fecha
        Fecha objFecha1 = new Fecha(Fecha.EnumMes.DICIEMBRE);
        //Actualizamos año y dia con los metodos set
        objFecha1.setDia(25);
        objFecha1.setAño(2022);
        System.out.println("Primera fecha, inicializada con el primer constructor");

        //Mostramos por pantalla el formato largo de la fecha con el metodo toString()
        System.out.println("La fecha es: " + objFecha1.toString());

        //Utilizamos un operador ternario para devolver por pantalla si es navidad o no
        System.out.println(objFecha1.isChristmas() ? "Es Navidad" : "No es Navidad");
        //System.out.println(objFecha1.reyes()?"Es dia de Reyes":"No es Dia de Reyes");

        //Instanciamos el objeto objFecha2 con el segundo constructor de la clase Fecha
        Fecha objFecha2 = new Fecha(25,Fecha.EnumMes.ABRIL,2022);
        System.out.println();
        System.out.println("Segunda fecha, inicializada con el segundo constructor");
        //Mostramos por pantalla el mes
        System.out.println("El mes es: "+objFecha2.getMes());
       //Mostramos por pantalla el formato largo de la fecha con el metodo toString()
        System.out.println("La fecha es: " + objFecha2.toString());
        //Utilizamos un operador ternario para devolver por pantalla si es navidad o no
        System.out.println(objFecha2.isChristmas()? "Es Navidad" : "No es Navidad ");
    }
}

