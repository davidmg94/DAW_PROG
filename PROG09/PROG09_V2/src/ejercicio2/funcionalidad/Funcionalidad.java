package ejercicio2.funcionalidad;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ejercicio2.funcionalidad.modelos.CuerpoCeleste;
import java.util.InputMismatchException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Funcionalidad extends ejercicio2.entornografico.EntornoGrafico{

    static final String NOMBRE_FICHERO = "sistemasolar.dat";
    static final ArrayList<CuerpoCeleste> cuerposCelestes = new ArrayList<>();

    public static boolean anadirCuerpoCeleste() {
        boolean exito = anadirCuerpo();

        return exito;
    }

    public static boolean anadirCuerpo() {
        try {
            short codigo = Short.parseShort(txtCodigo.getText());
            String nombre = txtNombre.getText();
            int diametro = Integer.parseInt(txtDiametro.getText());
            String tipo = cmbElegirTipo.getSelectedItem().toString();
            if (cuerposCelestes.isEmpty()) {
                crearCuerpoCeleste(codigo, nombre, tipo, diametro);
                return true;
            } else {
                for (CuerpoCeleste cc : cuerposCelestes) {
                    if (codigo == cc.getCodigoCuerpo()) {
                        JOptionPane.showMessageDialog(txtCodigo, "Ya existe un Cuerpo Celeste con ese código.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        return false;
                    } else {
                        crearCuerpoCeleste(codigo, nombre, tipo, diametro);
                        return true;
                    }
                }
            }

        } catch (InputMismatchException e) {
            errorMessage("ERROR: Formato incorrecto (" + e + ")");
        } catch (IllegalStateException e) {
            errorMessage("ERROR: Tipo de dato no admitido");
        } catch (NumberFormatException e) {
            errorMessage("ERROR: Tipo de dato no admitido " + e.getMessage());
        }
        return false;
    }

    public static void crearCuerpoCeleste(short codigo, String nombre, String tipo, int diametro) {
        CuerpoCeleste cc = new CuerpoCeleste(codigo, nombre, tipo, diametro);
        cuerposCelestes.add(cc);
        guardarFichero(NOMBRE_FICHERO, cuerposCelestes);
    }

    public static void guardarFichero(String NOMBRE_FICHERO, Object o) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_FICHERO))) {
            for (CuerpoCeleste cc : cuerposCelestes) {
                oos.writeObject(cc);
            }
        } catch (FileNotFoundException ex) {
            errorMessage(ex.getMessage());
        } catch (IOException ex) {
            errorMessage(ex.getMessage());
        }
    }

    public static void recuperarFichero() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(NOMBRE_FICHERO))) {
            while (true) {
                CuerpoCeleste cc = (CuerpoCeleste) ois.readObject();
                cuerposCelestes.add(cc);
            }
        } catch (FileNotFoundException ex) {
            errorMessage("No existe el fichero " + NOMBRE_FICHERO);
        } catch (EOFException ex) {
            if (cuerposCelestes.isEmpty()) {
                errorMessage("No hay datos en el fichero.");
            } else {
                errorMessage("Cuerpos añadidos del fichero");
            }
        } catch (IOException | ClassNotFoundException ex) {
            errorMessage(ex.getMessage());
        }

    }

    public static boolean existeCuerpo(short codigo) {
        for (CuerpoCeleste c : cuerposCelestes) {
            if (c.getCodigoCuerpo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public static int listarCuerposCelestes() {

        String columnas[] = {"Código", "Nombre", "Tipo", "Diámetro"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        for (CuerpoCeleste c : cuerposCelestes) {
            model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoCuerpo(), c.getDiametro()});
        }
        jTableCuerposCelestes.setModel(model);
        return cuerposCelestes.size();
    }

    public static void buscarCuerpoPorCodigo() {
        try {
            Short codigo = Short.valueOf(txtBuscarPorCodigo.getText());
            buscarPorCodigo(codigo);

        } catch (InputMismatchException | NumberFormatException ex) {
            errorMessage("ERROR: " + ex.getMessage());
        }
    }

    public static void buscarPorCodigo(Short codigo) {

        ArrayList<CuerpoCeleste> cc = new ArrayList<>();
        boolean encontrado = false;
        if (cuerposCelestes.isEmpty()) {
            errorMessage("No existen Cuerpos Celestes.");
        } else {
            for (CuerpoCeleste c : cuerposCelestes) {
                if (c.getCodigoCuerpo() == codigo) {
                    cc.add(c);
                }
            }
            encontrado = true;
            if (encontrado) {
                anadirDatosAtablaCodigo(cc);
            } else {
                errorMessage("No existen cuerpos celestes de ese tipo");
            }
        }

    }

    public static void anadirDatosAtablaCodigo(ArrayList<CuerpoCeleste> cc) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Diámetro");

        if (!cc.isEmpty()) {
            for (CuerpoCeleste c : cc) {
                model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoCuerpo(), c.getDiametro()});
            }
        }
        jTableBuscarPorCodigo.setModel(model);
    }

    public static void buscarCuerpoPorTipo() {
        try {
            String tipo = cmbTipoBuscar.getSelectedItem().toString();
            buscarPorTipo(tipo);

        } catch (Exception e) {
            errorMessage("ERROR: " + e.getMessage());
        }
    }

    public static void buscarPorTipo(String tipo) {

        ArrayList<CuerpoCeleste> cc = new ArrayList<>();
        boolean encontrado = false;
        if (cuerposCelestes.isEmpty()) {
            errorMessage("No existen Cuerpos Celestes.");
        } else {
            for (CuerpoCeleste c : cuerposCelestes) {
                if (c.getTipoCuerpo().equals(tipo)) {
                    cc.add(c);
                }
            }
            encontrado = true;
            if (encontrado) {
                anadirDatosAtablaTipos(cc);
            } else {
                errorMessage("No existen cuerpos celestes de ese tipo");
            }
        }

    }

    public static void anadirDatosAtablaTipos(ArrayList<CuerpoCeleste> cc) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Diámetro");

        if (!cc.isEmpty()) {
            for (CuerpoCeleste c : cc) {
                model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoCuerpo(), c.getDiametro()});
            }
        }
        jTableBuscarPorTipo.setModel(model);
    }

    public static void borrarCuerpoCeleste() {
        short codigo = Short.parseShort(txtBorrarPorCodigo.getText());
        if (cuerposCelestes.isEmpty()) {
            errorMessage("No existen Cuerpos Celestes.");
            return;
        }
        if (!existeCuerpo(codigo)) {
            errorMessage("No existe ningún Cuerpo Celeste con ese código");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(
                txtBorrarPorCodigo,
                "¿Seguro que quieres eliminar este Cuerpo Celeste?",
                "Borrar Cuerpos Celestes",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        Iterator<CuerpoCeleste> iterator = cuerposCelestes.iterator();
        while (iterator.hasNext()) {
            CuerpoCeleste cc = iterator.next();
            if (cc.getCodigoCuerpo() == codigo) {
                iterator.remove();
                errorMessage("Elemento borrado con exito");
                guardarFichero(NOMBRE_FICHERO, cuerposCelestes);
                return;
            }
        }
        errorMessage("Elemento no borrado.");
    }

    public static void borrarTodo() {
        eliminarFichero(NOMBRE_FICHERO);
    }

    public static void eliminarFichero(String nombreFichero) {
        File archivo = new File(nombreFichero);
        if (!archivo.exists()) {
            errorMessage("No hay ningun fichero de datos.");
        } else {
            archivo.delete();
            cuerposCelestes.clear();
            errorMessage("¡Datos borrados!");
        }
    }
}
