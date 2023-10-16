package ejercicio1;

public class UtilidadesCadenas {

    public static String unionCadenas(String cadena1, String cadena2) {
        return cadena1 + " " + cadena2;
    }

    public static int vecesLetra(String cadena, char letra) {
        int numVeces = 0;
        cadena = cadena.toLowerCase();
        letra = Character.toLowerCase(letra);
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == letra) {
                numVeces++;
            }
        }
        return numVeces;
    }

    public static boolean palindromo(String cadena) {
        cadena = cadena.replaceAll("\\s+", "").toLowerCase();

        for (int i = 0; i < cadena.length() / 2; i++) {
            if (cadena.charAt(i) != cadena.charAt(cadena.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static String girarCadena(String cadena) {
        StringBuilder cadenaGirada = new StringBuilder();
        for (int i = cadena.length() - 1; i >= 0; i--) {
            cadenaGirada.append(cadena.charAt(i));
        }
        return cadenaGirada.toString();
    }

}
