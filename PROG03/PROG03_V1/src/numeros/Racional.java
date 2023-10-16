package numeros;

/**
 *
 * @author David
 */
public class Racional {

    private int numerador;
    private int denominador;
    private static final int CONSTANTE = 1;

    public Racional() {
    }

    public Racional(int numerador) {
        this.numerador = numerador;
        this.denominador = CONSTANTE;
    }

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    /**
     * @return the numerador
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * @param numerador the numerador to set
     */
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    /**
     * @return the denominador
     */
    public int getDenominador() {
        return denominador;
    }

    /**
     * @param denominador the denominador to set
     */
    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public String imprime() {

        String fraccion = getNumerador() + "/" + getDenominador();

        return fraccion;
    }

    public Racional sumar(Racional a, Racional b) {

        return new Racional((a.numerador * b.denominador) + (a.denominador * b.numerador), a.denominador * b.denominador);

    }

    //ALTERNATIVA-Tambien vale para la resta
//    public Racional sumar(Racional a, Racional b) {
//        float num = a.numerador * b.denominador + a.denominador * b.numerador;
//        float den = a.denominador * b.denominador;
//        Racional R;
//        R = new Racional(num, den);
//        return R;
//    }
    public Racional sumar(Racional a) {

        return new Racional((a.numerador * getDenominador()) + (a.denominador * getNumerador()), a.denominador * getDenominador());

    }

    public Racional restar(Racional a, Racional b) {

        return new Racional((a.numerador * b.denominador) - (a.denominador * b.numerador), a.denominador * b.denominador);

    }

    public Racional restar(Racional b) {

        return new Racional((getNumerador() * b.denominador) - (getDenominador() * b.numerador), getDenominador() * b.denominador);

    }

    public Racional multiplicar(Racional a, Racional b) {

        return new Racional((a.numerador * b.numerador), (a.denominador * b.denominador));
    }

    public Racional multiplicar(Racional b) {

        return new Racional((getNumerador() * b.numerador), (getDenominador() * b.denominador));
    }

    public String toString() {

        String fraccion = getNumerador() + "/" + getDenominador();

        return fraccion;
    }
    
    public boolean igualesR(Racional a, Racional b){
    return (a.numerador == b.numerador)&&(a.denominador==b.denominador);
    }
}
