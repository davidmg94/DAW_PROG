package programacion_2;

public class PROG02_Ejerc5 {

    public static void main(String[] args) {

        final int CODIGO_MEDICO = 56;
        String nombre = "Juan";
        String apellido = "Garc�a";
        SexoPaciente sexo = SexoPaciente.H; //De 2 posibles (V/H) 
        EstadoCivil estado_civil = EstadoCivil.C; //De 4 posibles (S/C/V/D) 
        byte numero_hijos = 0;
        String direccion = "Calle Hern�n Cort�s 57";
        String ciudad = "Fuenlabrada";
        int codigo_postal = 28940;
        String pais = "Espa�a";
        boolean extranjero = !pais.equalsIgnoreCase("Espa�a");
        float peso_kg = 78.5f;
        float altura_cm = 175;
        float gastos_medicos = 37092.57f;
        float imc = peso_kg / ((altura_cm / 100) * (altura_cm / 100));

        System.out.printf("C�DIGO DEL MEDICO: %s%n%n", CODIGO_MEDICO);
        System.out.printf("FICHA M�DICA DE PACIENTE%n%n");
        System.out.printf("NOMBRE Y APELLIDO: %S %S%n", nombre, apellido);
        System.out.printf("SEXO: %S%n", sexo.getSexo());
        System.out.printf("ESTADO CIVIL: %S%n", estado_civil.getEstadoCivil());
        System.out.printf("HIJOS: %d%n", numero_hijos);
        System.out.printf("DIRECCI�N: %S%n", direccion);
        System.out.printf("CIUDAD: %S%n", ciudad);
        System.out.printf("C�DIGO POSTAL: %d%n", codigo_postal);
        System.out.printf("PA�S: %S%n", pais);
        System.out.printf("EXTRANJERO: %S%n", extranjero ? "si" : "no");
        System.out.printf("PESO: %.1fKg%n", peso_kg);
        System.out.printf("ALTURA: %.0fcm%n", altura_cm);
        System.out.printf("GASTOS MEDICOS GENERADOS: %.2f?%n", gastos_medicos);
        System.out.printf("IMC: %.2f%n", imc);
    }
}
