package programacion_2;

public class PROG02_Ejerc4 {
    public enum MesesDelAño {
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
    }
    
    public static void main(String[] args) {
        MesesDelAño springMonths = MesesDelAño.ABRIL;
        MesesDelAño winterMonths = MesesDelAño.DICIEMBRE;
        
        System.out.println("Resultado de comparación de variables: " + (springMonths.equals(winterMonths) ? "COINCIDEN" : "NO COINCIDEN"));
        
        System.out.println("\nInformación sobre el enum:");
        System.out.println("Posición de " + springMonths + ": " + springMonths.ordinal());
        System.out.println("Posición de " + winterMonths + ": " + winterMonths.ordinal());
        System.out.println("Cantidad de valores en el enum: " + MesesDelAño.values().length);
    }
}
