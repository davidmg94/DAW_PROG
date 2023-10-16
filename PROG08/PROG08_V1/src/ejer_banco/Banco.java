package ejer_banco;

import java.util.ArrayList;

public class Banco {

    private final ArrayList<CuentaBancaria> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<>();
    }

    public boolean abrirCuenta(CuentaBancaria c) {

        CuentaBancaria existe = this.buscarCuenta(c.getIBAN());
        if (existe != null) {
            System.out.println("Ya existe esa cuenta bancaria.");
            return false;
        }
        this.cuentas.add(c);
        return true;
    }

    public CuentaBancaria buscarCuenta(String IBAN) {
        for (CuentaBancaria c : this.cuentas) {
            if (c.getIBAN().equals(IBAN)) {
                return c;
            }
        }
        return null;
    }

    public String[] listadoCuentas() {
        String[] infoCuentas = new String[this.cuentas.size()];
        for (int i = 0; i < infoCuentas.length; i++) {
            infoCuentas[i] = "Código de la cuenta: " + this.cuentas.get(i).getIBAN() + " Titular de la cuenta: " + this.cuentas.get(i).getTitular().devolverInfoString() + " Saldo de la cuenta: " + this.cuentas.get(i).getSaldoCuenta();
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

            if (c.getSaldoCuenta() - cantidad >= 0) {
                sePuedeRetirar = true;
            } else if (c instanceof CuentaCorrienteEmpresa) {
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa) c;
                if (Math.abs(c.getSaldoCuenta() - cantidad) <= aux.getMaximoDescubierto()) {
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

    public boolean eliminarCuenta(String IBAN) {
        for (CuentaBancaria c : this.cuentas) {
            if (c.getIBAN().equals(IBAN) && c.getSaldoCuenta() == 0) {
                this.cuentas.remove(c);
                return true;
            }
        }
        return false;
    }
}
