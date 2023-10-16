package programacuerposcelestes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.CuerpoCeleste;

public class LanzadorPrograma {

    static final String NOMBRE_FICHERO = "sistemasolar.dat";
    static final ArrayList<CuerpoCeleste> cuerposCelestes = new ArrayList<>();
    static CuerpoCeleste cc = new CuerpoCeleste();

    public static void main(String[] args) {
        recuperarFichero();
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        Scanner sn = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 7) {
            try {
                System.out.println("Bienvenido al programa 'Lanzador de cohetes'.");
                System.out.println(" 1. Añadir cuerpo celeste.");
                System.out.println(" 2. Listar cuerpos celestes.");
                System.out.println(" 3. Buscar cuerpo celeste por c�digo.");
                System.out.println(" 4. Buscar cuerpo celeste por tipo.");
                System.out.println(" 5. Borrar cuerpo celeste.");
                System.out.println(" 6. Borrar fichero de cuerpos celestes.");
                System.out.println(" 7. Salir de la aplicaci�n.");
                System.out.println("Elije una opci�n.");
                opcion = sn.nextInt();
                switch (opcion) {
                    case 1:
                        anadirCuerpoCeleste(cc);
                        break;
                    case 2:
                        listarCuerposCelestes();
                        break;
                    case 3:
                        buscarCuerpoPorCodigo();
                        break;
                    case 4:
                        buscarCuerpoPorTipo();
                        break;
                    case 5:
                        borrarCuerpoCeleste();
                        break;
                    case 6:
                        eliminarFichero(NOMBRE_FICHERO);
                        break;
                    case 7:
                        salir();
                        break;
                    default:
                        System.out.println("�ERROR! Introduzca una opci�n v�lida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("�ERROR! Introduzca una opci�n v�lida.");
                sn.next();
            } catch (Exception e) {
                System.out.println("Error inesperado.");
                sn.next();
            }
        }
    }

    public static void anadirCuerpoCeleste(CuerpoCeleste cc) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int tamanoArray = cuerposCelestes.size();
        do {
            try {
                System.out.println("Introduzca el c�digo del Cuerpo Celeste.(N�mero de 3 d�gitos).");
                int codigo = sn.nextInt();
                sn.nextLine();
                while (existeCuerpo(codigo)) {
                    System.out.println("Ya existe un Cuerpo Celeste registrado con ese codigo.");
                    System.out.println("Introduzca otro codigo.");
                    codigo = sn.nextInt();
                }
                System.out.println("Introduzca el nombre del Cuerpo Celeste.(M�ximo 15 caracteres).");
                String nombre = sn.nextLine();
                
                System.out.println("Elija el tipo de Cuerpo Celeste.");
                String tipoCuerpo = eleccionTipoCuerpo();

                System.out.println("Introduzca el diametro del Cuerpo Celeste.(N�mero de m�ximo 6 d�gitos).");
                int diametro = sn.nextInt();

                cc = new CuerpoCeleste(codigo, nombre, tipoCuerpo, diametro);
                cuerposCelestes.add(cc);
                if (cc.getCodigoCuerpo() == 0) {
                    cuerposCelestes.remove(cc);
                }
                if (cuerposCelestes.size() > tamanoArray) {
                    guardarFichero();
                    tamanoArray = cuerposCelestes.size();
                }
                salir = true;
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Formato incorrecto." + e.getMessage());
                sn.next();
            } catch (Exception e) {
                System.out.println("Error inesperado.");
                sn.next();
            }
        } while (!salir);
    }

    public static void guardarFichero() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO))) {
            for (CuerpoCeleste cc : cuerposCelestes) {
                oos.writeObject(cc);
            }
            System.out.println("Fichero guardado con �xito.");
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void recuperarFichero() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_FICHERO))) {
            while (true) {
                CuerpoCeleste cc = (CuerpoCeleste) ois.readObject();
                cuerposCelestes.add(cc);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero.");
        } catch (EOFException ex) {
            if (cuerposCelestes.isEmpty()) {
                System.out.println("No existen Cuerpos Celestes.");
            } else {
                System.out.println("Cuentas a�adidas del fichero");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        for (CuerpoCeleste cc : cuerposCelestes) {
            System.out.println(cc);
        }
    }

    public static String eleccionTipoCuerpo() {
        Scanner sn = new Scanner(System.in);
        int eleccion = 0;
        String tipoCuerpo = "";

        do {
            System.out.println("1. Luna.");
            System.out.println("2. Planeta enano.");
            System.out.println("3. Planeta.");

            try {
                eleccion = sn.nextInt();

                switch (eleccion) {
                    case 1:
                        tipoCuerpo = "luna";
                        break;
                    case 2:
                        tipoCuerpo = "planeta enano";
                        break;
                    case 3:
                        tipoCuerpo = "planeta";
                        break;
                    default:
                        System.out.println("�ERROR! Introduzca una opci�n v�lida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("�ERROR! Introduzca una opci�n v�lida.");
                sn.next();
                eleccion = -1;
            } catch (Exception e) {
                System.out.println("Error inesperado.");
                sn.next();
                eleccion = -1;
            }
        } while (eleccion != 1 && eleccion != 2 && eleccion != 3);

        return tipoCuerpo;
    }

    public static boolean existeCuerpo(int codigo) {
        for (CuerpoCeleste c : cuerposCelestes) {
            if (c.getCodigoCuerpo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public static void listarCuerposCelestes() {
        if (cuerposCelestes.isEmpty()) {
            System.out.println("No existen Cuerpos Celestes.");
        } else {
            for (CuerpoCeleste c : cuerposCelestes) {
                System.out.println(c.toString());
            }
        }
    }

    public static void buscarCuerpoPorCodigo() {
        Scanner sn = new Scanner(System.in);

        if (cuerposCelestes.isEmpty()) {
            System.out.println("No existen Cuerpos Celestes.");
        } else {
            System.out.println("Introduzca el c�digo del Cuerpo Celeste.");
            boolean encontrado = false;
            int codigo = sn.nextInt();
            for (CuerpoCeleste c : cuerposCelestes) {
                if (c.getCodigoCuerpo() == codigo) {
                    System.out.println(c.toString());
                    encontrado = true;
                }
                if (!encontrado) {
                    System.out.println("No existen cuerpos celestes de ese tipo");
                }
            }
        }
    }

    public static void buscarCuerpoPorTipo() {
        Scanner sn = new Scanner(System.in);

        if (cuerposCelestes.isEmpty()) {
            System.out.println("No existen Cuerpos Celestes.");
        } else {
            System.out.println("Introduzca el tipo del Cuerpo Celeste.");
            boolean encontrado = false;
            String tipo = eleccionTipoCuerpo();
            for (CuerpoCeleste c : cuerposCelestes) {
                if (c.getTipoCuerpo().equalsIgnoreCase(tipo)) {
                    System.out.println(c.toString());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No existen cuerpos celestes de ese tipo");
            }
        }
    }

    public static void borrarCuerpoCeleste() {
        Scanner sn = new Scanner(System.in);

        if (cuerposCelestes.isEmpty()) {
            System.out.println("No existen Cuerpos Celestes.");
        } else {
            try {
                System.out.println("Introduzca el c�digo del Cuerpo Celeste que desea eliminar.");
                int codigo = sn.nextInt();

                existeCuerpo(codigo);

                System.out.println("�Esta seguro que quiere eliminar el Cuerpo Celeste " + codigo + "?(S/N)");
                String confirmacion = sn.next();
                if ("s".equalsIgnoreCase(confirmacion)) {
                    eliminarCuerpoCeleste(codigo);
                    System.out.println("Cuerpo Celeste eliminado con exito.");
                } else if ("n".equalsIgnoreCase(confirmacion)) {
                    System.out.println("No se elimino el Cuerpo Celeste.");
                } else {
                    System.out.println("�ERROR! Introduzca una opci�n v�lida.");
                    sn.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("�ERROR! Introduzca una opci�n v�lida.");
                sn.next();
            } catch (Exception e) {
                System.out.println("Error inesperado.");
                sn.next();
            }
        }
    }

    public static boolean eliminarCuerpoCeleste(int codigo) {
        for (CuerpoCeleste c : cuerposCelestes) {
            if (c.getCodigoCuerpo() == codigo) {
                cuerposCelestes.remove(c);
                guardarFichero();
                return true;
            }
        }
        return false;
    }

    public static void eliminarFichero(String nombreFichero) {
        File archivo = new File(nombreFichero);
        Scanner sn = new Scanner(System.in);
        if (archivo.exists()) {
            System.out.println("Se va a eliminar el archivo " + nombreFichero + "\n�Quieres continuar?(S/N)");
            String continuar = sn.next();
            if ("s".equalsIgnoreCase(continuar)) {
                if (archivo.delete()) {
                    System.out.println("El archivo " + nombreFichero + "fue borrado exitosamente.");
                    cuerposCelestes.clear();
                } else {
                    System.out.println("No se pudo borrar el archivo " + nombreFichero);
                }
            } else if ("n".equalsIgnoreCase(continuar)) {
                System.out.println("No se elimino el archivo.");
                iniciarPrograma();
            }
        } else {
            System.out.println("El archivo " + nombreFichero + " no existe.");
        }
    }

    public static void salir() {
        Scanner sn = new Scanner(System.in);

        boolean salir = false;
        do {
            System.out.println("�Quiere salir? (S/N)");
            String continuar = sn.next();

            if ("s".equalsIgnoreCase(continuar)) {
                System.out.println("Fin del programa. �Hasta luego!");
                salir = true;

            } else if ("n".equalsIgnoreCase(continuar)) {
                salir = true;
                iniciarPrograma();
            } else {
                System.out.println("�ERROR!. Debe introducir uno de los siguientes valores (S, s, N, n)");
            }
        } while (!salir);
    }
}
