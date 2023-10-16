package prog03;

import java.util.Locale;
import java.util.Scanner;

public class CoheteEspacial {

    static final float GRAVEDAD = 9.81f;
    static final float PI = 3.1416f;
    static final int MAX_ETAPAS = 5;
    static final int MIN_ETAPAS = 1;

    private static int contadorCohetes;

    public static int getContadorCohetes() {
        return contadorCohetes;
    }

    public static void setContadorCohetes(int aContadorCohetes) {
        contadorCohetes = aContadorCohetes;
    }

    private String denominacion;
    private String agenciaEspacial;
    private float altura;
    private float diametro;
    private int masa;
    private int etapas;
    private boolean reutilizable;

    public CoheteEspacial() {
        this.denominacion = "S/N";
        this.agenciaEspacial = "S/A";
        this.altura = 0;
        this.diametro = 0;
        this.masa = 0;
        this.etapas = 1;
        this.reutilizable = false;
        contadorCohetes++;

    }

    public CoheteEspacial(String denominacion, String agenciaEspacial, float altura, float diametro, int masa, int etapas, boolean reutilizable) {
        this.denominacion = denominacion;
        this.agenciaEspacial = agenciaEspacial;
        this.altura = altura;
        this.diametro = diametro;
        this.masa = masa;
        this.etapas = etapas;
        this.reutilizable = reutilizable;

        contadorCohetes++;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getAgenciaEspacial() {
        return agenciaEspacial;
    }

    public void setAgenciaEspacial(String agenciaEspacial) {
        this.agenciaEspacial = agenciaEspacial;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getDiametro() {
        return diametro;
    }

    public void setDiametro(float diametro) {
        this.diametro = diametro;
    }

    public int getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    public int getEtapas() {
        return etapas;
    }

    public void setEtapas(int etapas) {
        if (etapas >= MIN_ETAPAS) {
            if (etapas > MAX_ETAPAS) {
                this.etapas = MAX_ETAPAS;
            } else {
                this.etapas = etapas;
            }
        } else {
            this.etapas = MIN_ETAPAS;
        }
    }

    public boolean isReutilizable() {
        return reutilizable;
    }

    public void setReutilizable(boolean reutilizable) {
        this.reutilizable = reutilizable;
    }

    @Override
    public String toString() {
        return "CoheteEspacial{" + "denominacion=" + denominacion + ", agenciaEspacial=" + agenciaEspacial + ", altura=" + altura + ", diametro=" + diametro + ", masa=" + masa + ", etapas=" + etapas + ", reutilizable=" + reutilizable + '}';
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useLocale(Locale.US);

        String nombreCohete;
        String nombreAgencia;
        float alturaCohete;
        float diametroCohete;
        int masaCohete;
        int etapasCohete;
        boolean coheteReutilizable;

        CoheteEspacial miCohete = new CoheteEspacial();

        System.out.println("Bienvenido al programa de la clase Cohete Espacial de Nombre y Apellidos.");

        System.out.println("Introduzca el nombre del cohete:");
        nombreCohete = sn.nextLine();
        miCohete.setDenominacion(nombreCohete);

        System.out.println("Introduzca el nombre de la Agencia Espacial:");
        nombreAgencia = sn.nextLine();
        miCohete.setAgenciaEspacial(nombreAgencia);

        System.out.println("El nombre del cohete creado es: " + miCohete.getDenominacion());
        System.out.println("El nombre de la agencia espacial para el cohete" + miCohete.getDenominacion()
                + " es: " + miCohete.getAgenciaEspacial());

        System.out.println("Introduzca la altura del cohete:");
        alturaCohete = sn.nextFloat();
        miCohete.setAltura(alturaCohete);

        System.out.println("Introduzca el diámetro del cohete:");
        diametroCohete = sn.nextFloat();
        miCohete.setDiametro(diametroCohete);

        System.out.println("Introduzca la masa del cohete:");
        masaCohete = sn.nextInt();
        miCohete.setMasa(masaCohete);

        System.out.println("Introduzca las etapas del cohete:");
        etapasCohete = sn.nextInt();
        miCohete.setEtapas(etapasCohete);

        System.out.println("Introduzca si el cohete es reutilizable: (true/false)");
        coheteReutilizable = sn.nextBoolean();
        miCohete.setReutilizable(coheteReutilizable);

        System.out.println("Datos del cohete: \n" + miCohete.toString());

        CoheteEspacial coheteVacio = new CoheteEspacial();
        System.out.println("Datos del cohete Vacío: \n" + coheteVacio.toString());

        CoheteEspacial cohete1 = new CoheteEspacial("Ariane 5", "ESA", 59, 5.4f, 777000, 2, false);
        System.out.println("Datos del cohete 1: \n" + cohete1.toString());

        CoheteEspacial cohete2 = new CoheteEspacial("Saturno V", "NASA", 110.6f, 10.1f, 297000, 3, false);
        System.out.println("Datos del cohete 2: \n" + cohete2.toString());

        CoheteEspacial cohete3 = new CoheteEspacial("Falcon 9", "SpaceX", 70, 3.66f, 549054, 2, true);
        System.out.println("Datos del cohete 3: \n" + cohete3.toString());

        cohete1.setAgenciaEspacial("NASA");
        cohete1.setDenominacion("Apolo XIX");

        cohete2.setDiametro(8.5f);
        cohete2.setAltura(115.55f);

        cohete3.setMasa(123456);
        cohete3.setEtapas(4);

        System.out.println("Datos actualizados del cohete 1: " + cohete1.toString());
        System.out.println("Datos actualizados del cohete 2: " + cohete2.toString());
        System.out.println("Datos actualizados del cohete 3: " + cohete3.toString());

        CoheteEspacial cohete4 = new CoheteEspacial("Luna 6", "SpaceX", 65, 7.4f, 456789, 2, true);
        System.out.println("Datos del cohete 4: \n" + cohete4.toString());

        cohete4.setMasa(354687);
        cohete4.setEtapas(4);
        System.out.println("Datos actualizados del cohete 4: \n" + cohete4.toString());

        System.out.println("La suma de etapas de los cohetes " + cohete1.getDenominacion() + " y " + cohete2.getDenominacion() + " es: " + cohete1.sumarEtapas(cohete2));

        System.out.println("El volumen del cohete " + cohete1.getDenominacion() + " es " + cohete1.calcularVolumen());

        cohete3.setEtapas(10);
        System.out.println("Datos del cohete 3: \n" + cohete3.toString());

        cohete2.setEtapas(-1);
        System.out.println("Datos del cohete 2: \n" + cohete2.toString());

        System.out.println("El número de cohetes creados es: " + contadorCohetes);

        System.out.println("El valor de la gravedad es: " + GRAVEDAD);
    }

    public float calcularVolumen() {
        double volumenCohete;
        double radio = diametro / 2;
        volumenCohete = PI * altura * Math.pow(radio, 2);
        return (float) volumenCohete;
    }

    public int sumarEtapas(CoheteEspacial c) {
        int totalEtapas = c.etapas + this.etapas;
        return totalEtapas;
    }
}
