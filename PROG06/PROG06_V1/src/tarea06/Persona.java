package tarea06;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author David
 */
public class Persona {

    private String nombre, dni, codigoTaquilla;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso, altura;

    private static final char SEXO_POR_DEFECTO = 'H';
    private static final int PESO_IDEAL_BAJO = 0;
    private static final int PESO_IDEAL_NORMAL = 1;
    private static final int PESO_IDEAL_ALTO = 2;

    public Persona() {
        this.nombre = "";
        this.dni = null;
        this.codigoTaquilla = "";
        this.fechaNacimiento = null;
        this.sexo = SEXO_POR_DEFECTO;
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, LocalDate fechaNacimiento, char sexo) {
        this.nombre = nombre;
        this.dni = null;
        this.codigoTaquilla = "";
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, String dni, String codigoTaquilla, LocalDate fechaNacimiento, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.codigoTaquilla = codigoTaquilla;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double IMC = peso / Math.pow(altura, 2);
        if (IMC < 20) {
            return PESO_IDEAL_BAJO;
        } else if (IMC >= 20 && IMC < 25) {
            return PESO_IDEAL_NORMAL;
        } else {
            return PESO_IDEAL_ALTO;
        }
    }

//    private char comprobarSexo(char sexo) {
//        if (sexo == 'H' || sexo == 'M') {
//            return sexo;
//        } else {
//            sexo = SEXO_POR_DEFECTO;
//        }
//        return sexo;
//    }
    public static boolean comprobarSexo(String sexo) {
        if (!"h".equalsIgnoreCase(sexo) && !"m".equalsIgnoreCase(sexo)) {
            return false;
        }
        return true;
    }

    public int getAnyos() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public boolean esMayorDeEdad() {
        return getAnyos() >= 18;
    }

    @Override
    public String toString() {
        return "DNI=" + dni + ", Nombre=" + nombre + ", Edad=" + getAnyos() + ", Codigo de taquilla=" + codigoTaquilla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodigoTaquilla() {
        return codigoTaquilla;
    }

    public void setCodigoTaquilla(String codigoTaquilla) {
        this.codigoTaquilla = codigoTaquilla;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
