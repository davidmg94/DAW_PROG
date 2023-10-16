package Excepciones;

public class DefinirExcepciones {
        private void exOrdenadores(String numSerie, String discoDuro, short ram, short nucleos) throws Excepcion {

        if (numSerie.length() > 20) {
            throw new Excepcion("¡ERROR! El numero de serie no debe exceder los 20 caracteres.");
        } else if (!"hdd".equalsIgnoreCase(discoDuro) && !"ssd".equalsIgnoreCase(discoDuro)) {
            throw new Excepcion("¡ERROR! El disco duro solo puede ser HDD o SDD.");
        } else if (Short.toString(ram).length() > 3) {
            throw new Excepcion("¡ERROR! La memoria debe ser un número entero de 3 dígitos como máximo.");
        } else if (Short.toString(nucleos).length() > 2) {
            throw new Excepcion("¡ERROR! El nucleo debe ser un número entero de 2 dígitos como máximo.");
        }
    }
}
