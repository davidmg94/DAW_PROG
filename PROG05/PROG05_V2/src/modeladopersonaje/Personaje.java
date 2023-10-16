package modeladopersonaje;

import app_personaje.LanzadorPersonaje;
import java.util.Random;

public class Personaje {

    public static final byte MAX_STAT = 100;
    public static final byte MIN_STAT = 0;
    final static byte MAX_FUERZA = 100;
    final static byte MAX_INTELIGENCIA = 100;
    final static byte MAX_VIDA = 100;
    final static byte MIN_FUERZA = 0;
    final static byte MIN_INTELIGENCIA = 0;
    final static byte MIN_VIDA = 0;

    private static short numPersonajes;

    public static short getNumPersonajes() {
        return numPersonajes;
    }

    public static void setNumPersonajes(short aNumPersonajes) {
        numPersonajes = aNumPersonajes;
    }

    private String nombre;
    private byte vida;
    private byte inteligencia;
    private byte fuerza;

    public Personaje() {
        this.nombre = "S/N";
        this.vida = MAX_VIDA;
        this.inteligencia = MIN_INTELIGENCIA;
        this.fuerza = MIN_FUERZA;
        numPersonajes++;
    }

    public Personaje(String nombre, byte inteligencia, byte fuerza) {
        this.nombre = nombre;
        this.vida = MAX_VIDA;
        this.setInteligencia(inteligencia);
        this.setFuerza(fuerza);
        numPersonajes++;
    }

    public byte getFuerza() {
        return fuerza;
    }

    public void setFuerza(byte fuerza) {
        this.fuerza = fuerza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(byte inteligencia) {
        this.inteligencia = inteligencia;
    }

    public byte getVida() {
        return vida;
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + " Vida=" + vida + " Inteligencia=" + inteligencia + " Fuerza=" + fuerza;
    }

    private void restarVida(Personaje p) {

        byte statsP1 = (byte) (this.getFuerza() + this.getInteligencia());
        byte statsP2 = (byte) (p.getFuerza() + p.getInteligencia());

        if (statsP1 == statsP2) {
            this.restarVida((byte) 20);
            p.restarVida((byte) 20);
        } else if (statsP1 > statsP2) {
            p.restarVida((byte) 20);
        } else if (statsP1 < statsP2) {
            this.restarVida((byte) 20);
        }
        if (this.getVida() < MIN_VIDA) {
            this.vida = MIN_VIDA;
        } else if (p.getVida() < MIN_VIDA) {
            p.vida = MIN_VIDA;
        }
    }

    private void restarVida(byte dano) {
        this.vida = (byte) (this.getVida() - dano);
        if (this.getVida() <= MIN_VIDA) {
            this.vida = MIN_VIDA;
        }
    }

    private void desgaste() {
        this.setFuerza((byte) this.getRandom());
        this.setInteligencia((byte) this.getRandom());
    }

    private int getRandom() {
        Random random = new Random();
        int r = random.nextInt(101);
        return r;
    }

    boolean primeraVezBatalla = false;
    int turnosBatalla = 0;

    public void batalla(Personaje p) {
        if (!primeraVezBatalla) {
            System.out.println("Comienza la batalla a muerte.");
            System.out.println("Se enfrentan dos grandes rivales.");
            System.out.println(this.getNombre() + " Alias el tanque" + " Vs " + p.getNombre() + " Alias la montaña.");
            System.out.println("A continuación se muestran las estadísticas de estos fantásticos luchadores");
            LanzadorPersonaje.mostrarPersonajes();
            System.out.println("¿Quien sobrevivirá al final de la pelea?");
            System.out.println("(Recuerda, en cada turno se modificarán "
                    + "aleatoriamente las estadísticas de los peleadores debido al 'desgaste')");
            System.out.println("¡FIGHT!");

            primeraVezBatalla = true;
        }
        turnosBatalla++;
        System.out.println("Truno " + turnosBatalla);
        restarVida(p);
        if (turnosBatalla == 4) {
            System.out.println("Esta siendo una pelea apasionante. No se puede saber cuál de los dos peledores "
                    + "se alzará con la victoria.");
            this.desgaste();
            p.desgaste();
            LanzadorPersonaje.mostrarPersonajes();

        } else if (this.getVida() > MIN_VIDA && p.getVida() > MIN_VIDA) {
            System.out.println("Ambos luchadores siguen vivos, pero estan agotados.");
            this.desgaste();
            p.desgaste();
            LanzadorPersonaje.mostrarPersonajes();
        }

        if (this.getVida() == MIN_VIDA) {
            System.out.println("El combate ha finalizado.");
            System.out.println("El tanque, " + this.getNombre() + " ha muerto.");
            System.out.println("Ganador del combate: " + p.getNombre() + ", alias la montaña.");
            LanzadorPersonaje.mostrarPersonajes();
            System.out.println("Se han creado un total de " + numPersonajes + " personajes.");
            System.out.println("Fin del juego. Hasta luego.");
        } else if (p.getVida() == MIN_VIDA) {
            System.out.println("El combate ha finalizado.");
            System.out.println("La montaña, " + p.getNombre() + " ha muerto.");
            System.out.println("Ganador del combate: " + this.getNombre() + ", alias el tanque.");
            LanzadorPersonaje.mostrarPersonajes();
            System.out.println("Se han creado un total de " + numPersonajes + " personajes.");
            System.out.println("Fin del juego. Hasta luego.");
        } else if (p.getVida() == MIN_VIDA && this.getVida() == MIN_VIDA) {
            System.out.println("El combate ha finalizado.");
            System.out.println("Ambos luchadores han muerto.");
            System.out.println("La batalla ha terminado en empate");
            LanzadorPersonaje.mostrarPersonajes();
            System.out.println("Se han creado un total de " + numPersonajes + " personajes.");
            System.out.println("Fin del juego. Hasta luego.");
        }
    }
}
