package ordenadores.modelo;

import excepciones.ExcepcionPulgadas;
import general.interfaces.Reparable;

public class Portatil extends Ordenador implements Reparable, Comparable<Portatil> {

    private byte pulgadas;
    private int bateria;

    public Portatil() {
    }

    public Portatil(String numSerie, String marca, String modelo, short ram, String procesador, short nucleos, String discoDuro, byte pulgadas, int bateria, boolean arrancado) {
        super(numSerie, marca, modelo, procesador, discoDuro, ram, nucleos, arrancado);
        try {
            exPulgadas(pulgadas);
            this.pulgadas = pulgadas;
            this.bateria = bateria;
        } catch (ExcepcionPulgadas e) {
            System.out.println(e.getMessage());
        }
    }

    public byte getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(byte pulgadas) {
        this.pulgadas = pulgadas;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    @Override
    public String toString() {
        String ordenador = super.toString();
        return "Portatil: " + ordenador + " Pulgadas= " + pulgadas + " , Bateria= " + bateria + "min" + " Encendido= " + super.getArrancado();
    }

    public String cargarBateria(int carga) {
        this.bateria = this.bateria + carga;
        return "Batería para el portatil " + this.getNumSerie() + ": " + this.bateria;
    }

    public String descargarBateria(int descarga) {
        this.bateria = this.bateria - descarga;
        if (bateria < 0) {
            this.bateria = 0;
        }
        return "Batería para el portatil " + this.getNumSerie() + ": " + this.bateria;
    }

    @Override
    public void dibujar() {
        System.out.println(this.toString());
        String ram = "";
        for (int i = 0; i < this.getRam(); i++) {
            ram += "*";
        }
        for (int i = 0; i < this.getNucleos(); i++) {
            System.out.println(ram);
        }
    }

    private void exPulgadas(byte pulgadas) throws ExcepcionPulgadas {
        if (Byte.toString(pulgadas).length() != 2) {
            throw new ExcepcionPulgadas("¡ERROR! Las pulgadas deben ser un número entero de 2 dígitos.");
        }
    }

    @Override
    public void reparar() {
        try {
            System.out.println("El portátil se esta reparando.");

            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("***");
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("El portátil se ha reparado.\n");
    }

    @Override
    public int compareTo(Portatil p) {
        if (this.pulgadas < p.pulgadas) {
            return -1;
        } else if (this.pulgadas > p.pulgadas) {
            return 1;
        } else {
            return 0;
        }
    }
}
