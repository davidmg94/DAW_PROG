package ejer_banco;

public class CuentaCorriente extends CuentaBancaria {

    private String listaEntidades;

    public CuentaCorriente(String entidadesAutorizadas, Persona titular, double saldoCuenta, String IBAN) {
        super(titular, saldoCuenta, IBAN);
        this.listaEntidades = entidadesAutorizadas;
    }

    public String getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + ", listaEntidades=" + listaEntidades;
    }

}
