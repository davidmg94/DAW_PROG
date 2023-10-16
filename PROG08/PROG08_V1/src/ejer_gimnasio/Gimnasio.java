package ejer_gimnasio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gimnasio {

    private final ArrayList<Persona> personas;

    public Gimnasio() {
        this.personas = new ArrayList<>();
    }

    public boolean buscaPersona(String dni) {
        for (Persona p : this.personas) {
            if (p.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    public Persona devuelvePersona(String dni) {
        for (Persona p : this.personas) {
            if (p.getDni().equals(dni)) {
                return p;
            }
        }
        return null;
    }

    public String datosPersona(String dni) {
        for (Persona p : this.personas) {
            if (p.getDni().equals(dni)) {
                return p.toString();
            }
        }
        return null;
    }

    public boolean anadePersona(Persona p) {
        boolean existe = buscaPersona(p.getDni());
        if (existe) {
            return false;
        }
        this.personas.add(p);
        return true;
    }

    public void listarPersonas() {
        for (Persona p : this.personas) {
            System.out.println("Datos de la personas registradas:\n" + p.toString());
        }
    }

    public boolean actualizaTaquilla(String dni, String codTaquilla) {
        for (Persona p : this.personas) {
            if (p.getDni().equals(dni)) {
                p.setCodigoTaquilla(codTaquilla);
            }
            return true;
        }
        return false;
    }

    public boolean eliminaPersona(String DNI) {
        for (Persona p : this.personas) {
            if (p.getDni().equals(DNI)) {
                this.personas.remove(p);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Persona> personasOrdenadasPorDni() {
        ArrayList<Persona> personasOrdenadas = new ArrayList<>(this.personas);
        Collections.sort(personasOrdenadas, Comparator.comparing(Persona::getDni));
        return personasOrdenadas;
    }
}
