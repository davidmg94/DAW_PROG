package programacion_2;

public class PROG02_Ejerc5 {

    public static void main(String[] args) {

        final int CODIGO_MEDICO = 56;
        String nombre = "Juan";
        String apellido = "García";
        SexoPaciente sexo = SexoPaciente.H; //De 2 posibles (V/H) 
        EstadoCivil estado_civil = EstadoCivil.C; //De 4 posibles (S/C/V/D) 
        byte numero_hijos = 0;
        String direccion = "Calle Hernán Cortés 57";
        String ciudad = "Fuenlabrada";
        int codigo_postal = 28940;
        String pais = "España";
        boolean extranjero = !pais.equalsIgnoreCase("España");
        float peso_kg = 78.5f;
        float altura_cm = 175;
        float gastos_medicos = 37092.57f;
        float imc = peso_kg / ((altura_cm / 100) * (altura_cm / 100));

        System.out.printf("CÓDIGO DEL MEDICO: %s%n%n", CODIGO_MEDICO);
        System.out.printf("FICHA MÉDICA DE PACIENTE%n%n");
        System.out.printf("NOMBRE Y APELLIDO: %S %S%n", nombre, apellido);
        System.out.printf("SEXO: %S%n", sexo.getSexo());
        System.out.printf("ESTADO CIVIL: %S%n", estado_civil.getEstadoCivil());
        System.out.printf("HIJOS: %d%n", numero_hijos);
        System.out.printf("DIRECCIÓN: %S%n", direccion);
        System.out.printf("CIUDAD: %S%n", ciudad);
        System.out.printf("CÓDIGO POSTAL: %d%n", codigo_postal);
        System.out.printf("PAÍS: %S%n", pais);
        System.out.printf("EXTRANJERO: %S%n", extranjero ? "si" : "no");
        System.out.printf("PESO: %.1fKg%n", peso_kg);
        System.out.printf("ALTURA: %.0fcm%n", altura_cm);
        System.out.printf("GASTOS MEDICOS GENERADOS: %.2f?%n", gastos_medicos);
        System.out.printf("IMC: %.2f%n", imc);
    }
}
