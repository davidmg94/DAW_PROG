package ejer_banco;

public class CuentaCorrientePersonal extends CuentaCorriente {

    private double comisionMantenimiento;

    public CuentaCorrientePersonal(double comisionMantenimiento, String entidadesAutorizadas, Persona titular, double saldoCuenta, String IBAN) {
        super(entidadesAutorizadas, titular, saldoCuenta, IBAN);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString()+", comisionMantenimiento=" + comisionMantenimiento;
    }

}
