package ordenadores.modelo;

import general.interfaces.Reparable;

public class Sobremesa extends Ordenador implements Reparable {

    private String tarjetaGrafica, placaBase;

    public Sobremesa() {
    }

    public Sobremesa(String numSerie, String marca, String modelo, short ram, String procesador, short nucleos, String discoDuro, String placaBase, String tarjetaGrafica, boolean arrancado) {
        super(numSerie, marca, modelo, procesador, discoDuro, ram, nucleos,arrancado);
        this.tarjetaGrafica = tarjetaGrafica;
        this.placaBase = placaBase;
    }

    public String getPlacaBase() {
        return placaBase;
    }

    public void setPlacaBase(String placaBase) {
        this.placaBase = placaBase;
    }

    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public void setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    @Override
    public String toString() {
        String ordenador = super.toString();
        return "Sobremesa: " + ordenador + " tarjetaGrafica=" + tarjetaGrafica + ", placaBase=" + placaBase + " Encendido= " + super.getArrancado();
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

    @Override
    public void reparar() {
        try {
            System.out.println("El sobremesa se esta reparando.");

            for (int i = 0; i < 3; i++) {
                Thread.sleep(1 * 1000);
                System.out.println("***");
            }
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("El sobremesa se ha reparado.\n");
    }
}
