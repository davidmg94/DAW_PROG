package ordenadores.modelo;

import excepciones.ExcepcionOrdenadores;
import java.util.Objects;

public abstract class Ordenador {

    private String numSerie, marca, modelo, procesador, discoDuro;
    private short ram, nucleos;
    private boolean arrancado;

    public Ordenador() {
        this.numSerie = "";
        this.marca = "";
        this.modelo = "";
        this.procesador = "";
        this.discoDuro = "";
        this.ram = 0;
        this.nucleos = 0;
        this.arrancado = false;
    }

    public Ordenador(String numSerie, String marca, String modelo, String procesador, String discoDuro, short ram, short nucleos, boolean arrancado) {
        try {
            exOrdenadores(numSerie, discoDuro, ram, nucleos);
            this.numSerie = numSerie;
            this.marca = marca;
            this.modelo = modelo;
            this.procesador = procesador;
            this.discoDuro = discoDuro;
            this.ram = ram;
            this.nucleos = nucleos;
            this.arrancado = false;
        } catch (ExcepcionOrdenadores e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean getArrancado() {
        return arrancado;
    }

    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(short ram) {
        this.ram = ram;
    }

    public int getNucleos() {
        return nucleos;
    }

    public void setNucleos(short nucleos) {
        this.nucleos = nucleos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public String toString() {
        return "Ordenador: numSerie=" + numSerie + ", marca=" + marca + ", modelo=" + modelo + ", procesador=" + procesador + ", discoDuro=" + discoDuro + ", ram=" + ram + ", nucleos=" + nucleos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ordenador other = (Ordenador) obj;
        return Objects.equals(this.numSerie, other.numSerie);
    }

    public void arrancar() {
        try {
            System.out.println("Encendiendo el equipo...");
            for (int i = 0; i < 4; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
                if (i == 1) {
                    System.out.println("Ya casi esta. Por favor espere.");
                }
            }
            this.arrancado = true;
            System.out.println("Ordenador encendido");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void apagar() {
        try {
            System.out.println("Apagando el equipo...");
            for (int i = 0; i < 4; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("...");
            }
            this.arrancado = false;
            System.out.println("Ordenador apagado");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    abstract public void dibujar();

    private void exOrdenadores(String numSerie, String discoDuro, short ram, short nucleos) throws ExcepcionOrdenadores {

        if (numSerie.length() > 20) {
            throw new ExcepcionOrdenadores("¡ERROR! El numero de serie no debe exceder los 20 caracteres.");
        } else if (!"hdd".equalsIgnoreCase(discoDuro) && !"ssd".equalsIgnoreCase(discoDuro)) {
            throw new ExcepcionOrdenadores("¡ERROR! El disco duro solo puede ser HDD o SDD.");
        } else if (Short.toString(ram).length() > 3) {
            throw new ExcepcionOrdenadores("¡ERROR! La memoria debe ser un número entero de 3 dígitos como máximo.");
        } else if (Short.toString(nucleos).length() > 2) {
            throw new ExcepcionOrdenadores("¡ERROR! El nucleo debe ser un número entero de 2 dígitos como máximo.");
        }
    }
}
