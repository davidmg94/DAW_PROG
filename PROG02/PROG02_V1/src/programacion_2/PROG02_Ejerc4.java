package programacion_2;

public class PROG02_Ejerc4 {
    public enum MesesDelA�o {
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
    }
    
    public static void main(String[] args) {
        MesesDelA�o springMonths = MesesDelA�o.ABRIL;
        MesesDelA�o winterMonths = MesesDelA�o.DICIEMBRE;
        
        System.out.println("Resultado de comparaci�n de variables: " + (springMonths.equals(winterMonths) ? "COINCIDEN" : "NO COINCIDEN"));
        
        System.out.println("\nInformaci�n sobre el enum:");
        System.out.println("Posici�n de " + springMonths + ": " + springMonths.ordinal());
        System.out.println("Posici�n de " + winterMonths + ": " + winterMonths.ordinal());
        System.out.println("Cantidad de valores en el enum: " + MesesDelA�o.values().length);
    }
}
