package prog07_tarea;

public class Banco {

    private final CuentaBancaria[] cuentas;
    private final int MAX_CUENTAS = 100;
    private int numCuentas;

    public Banco() {
        this.cuentas = new CuentaBancaria[this.MAX_CUENTAS];
        this.numCuentas = 0;
    }

    public boolean abrirCuenta(CuentaBancaria c) {
        if (numCuentas >= this.MAX_CUENTAS) {
            System.out.println("No hay suficiente espacio para abrir más cuentas.");
            return false;
        }
        CuentaBancaria existe = this.buscarCuenta(c.getIBAN());
        if (existe != null) {
            System.out.println("Ya existe esa cuenta bancaria.");
            return false;
        }
        this.cuentas[this.numCuentas] = c;
        this.numCuentas++;
        return true;
    }

    public CuentaBancaria buscarCuenta(String IBAN) {
        for (int i = 0; i < this.numCuentas; i++) {
            if (this.cuentas[i].getIBAN().equals(IBAN)) {
                return this.cuentas[i];
            }
        }
        return null;
    }

    public String[] listadoCuentas() {
        String [] infoCuentas = new String[this.numCuentas];
        for (int i = 0; i < this.numCuentas; i++) {
            infoCuentas[i]= "Código de la cuenta: " + this.cuentas[i].getIBAN()+ " Titular de la cuenta: "+this.cuentas[i].getTitular().devolverInfoString() + " Saldo de la cuenta: " + this.cuentas[i].getSaldoCuenta();
        }
        return infoCuentas;
    }

    public String informacionCuenta(String IBAN) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            return c.devolverInfoString();
        }
        return null;
    }

    public boolean ingresoCuenta(String IBAN, double cantidad) {
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            c.setSaldoCuenta(c.getSaldoCuenta() + cantidad);
            return true;
        }
        return false;
    }

    public boolean retiradaCuenta(String IBAN, double cantidad) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {

            boolean sePuedeRetirar = false;

            if (c.getSaldoCuenta() - cantidad > 0) {
                sePuedeRetirar = true;
            } else if (c instanceof CuentaCorrienteEmpresa) {
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa) c;
                if (Math.abs(c.getSaldoCuenta() - cantidad) < aux.getMaximoDescubierto()) {
                    sePuedeRetirar = true;
                }
            }

            if (sePuedeRetirar) {
                c.setSaldoCuenta(c.getSaldoCuenta() - cantidad);
            }
            return sePuedeRetirar;
        }
        return false;
    }
    
//    ALTERNATIVA
//    public boolean retiradaCuenta(String IBAN, double cantidad) {
//        CuentaBancaria c = this.buscarCuenta(IBAN);
//
//        if (c == null) {
//            return false; // La cuenta no existe
//        }
//
//        if (c.getSaldoCuenta() >= cantidad || (c instanceof CuentaCorrienteEmpresa && Math.abs(c.getSaldoCuenta() - cantidad) < ((CuentaCorrienteEmpresa) c).getMaximoDescubierto())) {
//            c.setSaldoCuenta(c.getSaldoCuenta() - cantidad);
//            return true; // Retirada exitosa
//        }
//
//        return false; // No se puede retirar la cantidad especificada
//    }

    public double saldoCuenta(String IBAN) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            return c.getSaldoCuenta();
        }
        return -1;
    }
}
