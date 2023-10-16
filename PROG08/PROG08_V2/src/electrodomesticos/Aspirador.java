package electrodomesticos;

import general.interfaces.Reparable;

public class Aspirador implements Reparable {

    private String modelo;
    private byte peso;
    private byte potencia;
    private Boolean encendido;

    public Aspirador() {
    }

    public Aspirador(String modelo, byte peso, byte potencia) {
        this.modelo = modelo;
        this.peso = peso;
        this.potencia = potencia;
        this.encendido = false;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public byte getPeso() {
        return peso;
    }

    public void setPeso(byte peso) {
        this.peso = peso;
    }

    public byte getPotencia() {
        return potencia;
    }

    public void setPotencia(byte potencia) {
        this.potencia = potencia;
    }

    public Boolean getEncendido() {
        return encendido;
    }

    public void setEncendido(Boolean encendido) {
        this.encendido = encendido;
    }

    @Override
    public String toString() {
        return "Aspirador{" + "modelo=" + modelo + ", peso=" + peso + ", potencia=" + potencia + ", encendido=" + encendido + '}';
    }

    public void encender() {
        try {
            System.out.println("Encendiendo...");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
            }
            this.encendido = true;
            System.out.println("Aspiradora encendida");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void limpiar() throws InterruptedException {
        System.out.println("¡Comienza la limpieza!");
        for (int i = 0; i < 3; i++) {
            System.out.println("Limpiando...");
            Thread.sleep((this.potencia / 100) * 1000);
        }
        System.out.println("Limpieza terminada.");
    }

    public void apagar() {
        try {
            System.out.println("Apagando...");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
            }
            this.encendido = false;
            System.out.println("Aspiradora apagada");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public void reparar() {
        try {
            System.out.println("El aspirador se esta reparando.");

            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("El aspirador se ha reparado.\n");
    }
}
