package ejer_banco;

public class CuentaAhorro extends CuentaBancaria {

    private double tipoInteresAnual;

    public CuentaAhorro(double interesAnual, Persona titular, double saldoCuenta, String IBAN) {
        super(titular, saldoCuenta, IBAN);
        this.tipoInteresAnual = interesAnual;
    }

    public double getTipoInteresAnual() {
        return tipoInteresAnual;
    }

    public void setTipoInteresAnual(double tipoInteresAnual) {
        this.tipoInteresAnual = tipoInteresAnual;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + ", tipoInteresAnual=" + tipoInteresAnual;
    }

}
