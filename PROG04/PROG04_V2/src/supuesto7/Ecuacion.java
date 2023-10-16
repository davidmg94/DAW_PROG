package supuesto7;

public class Ecuacion {

    public static void ExDiscriminanteNegativo(double num) throws ExcepcionDiscriminanteNegativo {
        if (num < 0) {
            throw new ExcepcionDiscriminanteNegativo("EL DISCRIMINANTE ES NEGATIVO: NO HAY SOLUCIONES REALES");
        }
    }
    private int a, b, c;

    public Ecuacion() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public Ecuacion(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double calcularX1() throws ExcepcionDiscriminanteNegativo {
        double x;
        double discriminante = comprobarDiscriminante();
        ExDiscriminanteNegativo(discriminante);
        double raizDelDiscriminante = Math.sqrt(discriminante);
        x = (-(this.b) + raizDelDiscriminante) / (2 * this.a);
        System.out.println("La primera solución de la ecuación de segundo grado a=" + this.a + ", b=" + this.b + ", c=" + this.c + " es: " + x);

        return x;
    }

    public double calcularX2() throws ExcepcionDiscriminanteNegativo {
        double x;
        double discriminante = comprobarDiscriminante();
        ExDiscriminanteNegativo(discriminante);
        double raizDelDiscriminante = Math.sqrt(discriminante);
        x = (-(this.b) - raizDelDiscriminante) / (2 * this.a);
        System.out.println("La segunda solución de la ecuación de segundo grado a=" + this.a + ", b=" + this.b + ", c=" + this.c + " es: " + x);
        System.out.println(discriminante);

        return x;
    }

    public int comprobarDiscriminante() {
        int d = (int) Math.pow(b, 2) - 4 * this.a * c;
        return d;

    }
}
