package tarea06;

/**
 * @author David
 */
public class Gimnasio {

    private static final int MAX_PERSONAS = 1;
    private final Persona[] personas;
    private int numPersonas;

    public Gimnasio() {
        personas = new Persona[MAX_PERSONAS];
        numPersonas = 0;
    }

    public boolean buscaPersona(String dni) {
        for (int i = 0; i < numPersonas; i++) {
            if (personas[i].getDni().equalsIgnoreCase(dni)) {
                return true;
            }
        }
        return false;
    }

    public Persona devuelvePersona(String dni) {
        for (int i = 0; i < numPersonas; i++) {
            if (personas[i].getDni().equalsIgnoreCase(dni)) {
                return personas[i];
            }
        }
        return null;

    }

    public String datosPersona(String dni) {
        for (int i = 0; i < numPersonas; i++) {
            if (personas[i].getDni().equals(dni)) {
                return personas[i].toString();
            }
        }
        return null;
    }

    public boolean anadePersona(Persona p) {
        if (numPersonas >= MAX_PERSONAS) {
            return false;
        }
        personas[numPersonas] = p;
        numPersonas++;
        return true;
    }

    public void listarPersonas() {
        for (int i = 0; i < numPersonas; i++) {
            System.out.println("Datos de la personas registradas:\n" + personas[i].toString());
        }
    }

    public boolean actualizaTaquilla(String dni, String codTaquilla) {
        for (int i = 0; i < numPersonas; i++) {
            if (personas[i].getDni().equals(dni)) {
                personas[i].setCodigoTaquilla(codTaquilla);
            }
            return true;
        }
        return false;
    }

    public boolean eliminaPersona(String DNI) {
        for (int i = 0; i < numPersonas; i++) {
            if (personas[i].getDni().equals(DNI)) {
                personas[i] = personas[numPersonas - 1];
                personas[numPersonas - 1] = null;
                numPersonas--;
                return true;
            }
        }
        return false;
    }

//    ALTERNATIVA
//    public boolean eliminaPersona(String dni) {
//        for (int i = 0; i < numPersonas; i++) {
//            if (personas[i].getDni().equals(dni)) {
//                for (int j = i; j < numPersonas - 1; j++) {
//                    personas[j] = personas[j + 1];
//                }
//                personas[numPersonas - 1] = null;
//                numPersonas--;
//                return true;
//            }
//        }
//        return false;
//    }
}
