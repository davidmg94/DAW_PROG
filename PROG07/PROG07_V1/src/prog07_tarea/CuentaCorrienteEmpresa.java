package prog07_tarea;

public class CuentaCorrienteEmpresa extends CuentaCorriente {

    private double tipoInteresDescubierto;
    private double maximoDescubierto;
    private double comisionFijaDescubierto;

    public CuentaCorrienteEmpresa(double tipoInteresDescubierto, double maximoDescubierto, double comisionFijaDescubierto, String entidadesAutorizadas, Persona titular, double saldoCuenta, String IBAN) {
        super(entidadesAutorizadas, titular, saldoCuenta, IBAN);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubierto = maximoDescubierto;
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    public double getMaximoDescubierto() {
        return maximoDescubierto;
    }

    public void setMaximoDescubierto(double maximoDescubierto) {
        this.maximoDescubierto = maximoDescubierto;
    }

    public double getComisionFijaDescubierto() {
        return comisionFijaDescubierto;
    }

    public void setComisionFijaDescubierto(double comisionFijaDescubierto) {
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + ", tipoInteresDescubierto=" + tipoInteresDescubierto + ", maximoDescubierto=" + maximoDescubierto + ", comisionFijaDescubierto=" + comisionFijaDescubierto;
    }

}
