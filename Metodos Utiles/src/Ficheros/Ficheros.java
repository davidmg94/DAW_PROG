package Ficheros;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ficheros {
    public static void guardarFichero() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO))) {
            for (CuerpoCeleste cc : cuerposCelestes) {
                oos.writeObject(cc);
            }
            System.out.println("Fichero guardado con éxito.");
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
                System.out.println("Cuentas añadidas del fichero");
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
        public static void eliminarFichero(String nombreFichero) {
        File archivo = new File(nombreFichero);
        Scanner sn = new Scanner(System.in);
        if (archivo.exists()) {
            System.out.println("Se va a eliminar el archivo " + nombreFichero + "\n¿Quieres continuar?(S/N)");
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
            public void guardarCuentas() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datoscuentasbancarias.dat"))) {
            for (CuentaBancaria cuenta : cuentas) {
                oos.writeObject(cuenta);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void recuperarCuentas() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datoscuentasbancarias.dat"))) {
            while (true) {
                CuentaBancaria cuenta = (CuentaBancaria) ois.readObject();
                this.abrirCuenta(cuenta);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No existe el fichero.");
        } catch (EOFException ex) {
            System.out.println("Cuentas añadidas del fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void generarListado() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ListadoClientesCCC.txt"))) {

            for (CuentaBancaria cuenta : cuentas) {
                String linea = cuenta.getTitular().devolverInfoString() + " IBAN: " + cuenta.getIBAN() + "\r\n";
                bw.write(linea);
            }
            bw.write("Número de cuentas: " + cuentas.size());
        } catch (IOException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
