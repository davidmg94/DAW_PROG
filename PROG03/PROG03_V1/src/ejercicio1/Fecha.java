package ejercicio1;

/**
 *
 * @author David
 */
public class Fecha {
    //Declaracion de tipo enumerado variable enumMes

    public enum EnumMes {
        ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE
    }

    //Declaracion de atributos
    private int dia;
    private EnumMes mes;
    private int a�o;

    //Primer constructor
    Fecha(EnumMes mes) {
        this.a�o = 0;
        this.dia = 0;
        this.mes = mes;
    }

    //Segundo constructor
    Fecha(int dia, EnumMes mes, int a�o) {
        this.dia = dia;
        this.mes = mes;
        this.a�o = a�o;
    }

    //Metodos getter de los atributos dia, mes y a�o
    public int getDia() {
        return dia;
    }

    public int getAnio() {
        return a�o;
    }

    public EnumMes getMes() {
        return mes;
    }

    //Metodos setter de los atributos dia, mes y a�o
    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(EnumMes mes) {
        this.mes = mes;
    }

    public void setA�o(int a�o) {
        this.a�o = a�o;
    }

    //Metodo booleano para comprobar si es dia de Reyes o Navidad
    public boolean isChristmas() {
        return (dia == 6 && mes == EnumMes.ENERO) || (dia == 25 && mes == EnumMes.DICIEMBRE);
    }
    //ALTERNATIVA
    //public boolean isChristmas() {
    //  boolean resultado = false;

    //  resultado = ((getDia() == 6 && getMes().toString() == "ENERO") || (getDia() == 25 && getMes().toString() == "DICIEMBRE")) ? true : false;

    //  return resultado;
    //}
    //OPCION
    //public boolean reyes() {
    //  return (dia == 6 && mes == enumMes.ENERO);
    //    }

    //Metodo para devolver la fecha en formato largo 
    public String toString() {

        String fecha_larga = mes + " " + dia + ", " + a�o;

        return fecha_larga;
    }
}
