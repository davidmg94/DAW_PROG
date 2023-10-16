package ejer_banco;

import java.io.Serializable;

public abstract class CuentaBancaria implements Imprimible, Serializable {

    private Persona titular;
    private double saldoCuenta;
    private String IBAN;

    public CuentaBancaria(Persona titular, double saldoCuenta, String IBAN) {
        this.titular = titular;
        this.saldoCuenta = saldoCuenta;
        this.IBAN = IBAN;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(double saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    @Override
    public String devolverInfoString() {
        return "titular: " + titular.devolverInfoString() + ", saldoCuenta: " + saldoCuenta + ", IBAN: " + IBAN;
    }
}
