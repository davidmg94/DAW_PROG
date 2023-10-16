package prog10.funcionalidad;

import static conexionBBDD.ConexionBBDD.*;
import java.util.ArrayList;
import prog10.funcionalidad.modelos.CuerpoCeleste;
import java.util.InputMismatchException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Funcionalidad extends prog10.entornografico.EntornoGrafico {

    public static final ArrayList<CuerpoCeleste> cuerposCelestes = new ArrayList<>();

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
                if (existeCuerpo(codigo)) {
                    JOptionPane.showMessageDialog(txtCodigo, "Ya existe un Cuerpo Celeste con ese código.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return false;
                } else {
                    crearCuerpoCeleste(codigo, nombre, tipo, diametro);
                    return true;
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
        anadirCuerposCelestes(cc);
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
        int datos = 0;
        try {
            //Conexion con la BBDD
            ResultSet rs = obtenerTodosCuerposCelestes();
            //Transformar informacion obtenida de la BD
            List<CuerpoCeleste> cuerposCelestesDeResultSet = obtenerCuerposCelestesDeResultSet(rs);
            //Rellenar el array cuerposCelestes
            limpiarTablaCuerposCelestes();

            for (int i = 0; i < cuerposCelestesDeResultSet.size(); i++) {
                cuerposCelestes.add(cuerposCelestesDeResultSet.get(i));
            }
            //Añadir datos a la tabla para mostrarlos
            anadirDatosTablaCuerposCelestes();
            if (!cuerposCelestes.isEmpty()) {
                datos++;
            } else {
                datos = 0;
            }
        } catch (InputMismatchException e) {
            errorMessage("ERROR: " + e.getMessage());
        } catch (Exception e) {
            errorMessage("ERROR: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
        return datos;
    }

    public static void anadirDatosTablaCuerposCelestes() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Código");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Diámetro");

        if (!cuerposCelestes.isEmpty()) {
            for (CuerpoCeleste c : cuerposCelestes) {
                model.addRow(new Object[]{c.getCodigoCuerpo(), c.getNombre(), c.getTipoCuerpo(), c.getDiametro()});
            }
        }
        jTableCuerposCelestes.setModel(model);
    }

    public static List<CuerpoCeleste> obtenerCuerposCelestesDeResultSet(ResultSet rs) throws SQLException {
        List<CuerpoCeleste> cuerposCelestesLocal = new ArrayList<>();
        while (rs.next()) {
            short codigo = rs.getShort("codigo");
            String nombre = rs.getString("nombre");
            String tipo = rs.getString("tipo");
            int diametro = rs.getInt("diametro");
            CuerpoCeleste miCuerpoCeleste = new CuerpoCeleste(codigo, nombre, tipo, diametro);
            cuerposCelestesLocal.add(miCuerpoCeleste);

        }
        Collections.sort(cuerposCelestesLocal, Comparator.comparingInt(CuerpoCeleste::getCodigoCuerpo));
        return cuerposCelestesLocal;
    }

    public static void limpiarTablaCuerposCelestes() {
        cuerposCelestes.clear();
    }

    public static void buscarCuerpoPorCodigo() {
        try {
            short code = Short.parseShort(txtBuscarPorCodigo.getText());
            //Conexion con la BBDD
            ResultSet rs = obtenerCuerposCelestesPorCodigo(code);
            //Transformar informacion obtenida de la BD
            List<CuerpoCeleste> cuerposCelestesFromResultSet = obtenerCuerposCelestesDeResultSet(rs);

            //Añadir datos a la tabla para mostrarlos
            anadirDatosTablaCodigo(cuerposCelestesFromResultSet);

        } catch (InputMismatchException e) {
            errorMessage("ERROR: " + e.getMessage());
        } catch (Exception e) {
            errorMessage("ERROR: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
    }

    public static void anadirDatosTablaCodigo(List<CuerpoCeleste> cc) {
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
            //Conexion con la BBDD
            ResultSet rs = obtenerCuerposCelestesPorTipo(tipo);
            //Transformar informacion obtenida de la BD
            List<CuerpoCeleste> cuerposCelestesFromResultSet = obtenerCuerposCelestesDeResultSet(rs);
            //Añadir datos a la tabla para mostrarlos
            anadirDatosTablaTipos(cuerposCelestesFromResultSet);

        } catch (InputMismatchException e) {
            errorMessage("ERROR: " + e.getMessage());
        } catch (Exception e) {
            errorMessage("ERROR: " + e.getMessage());
        } finally {
            cerrarRecursos();
        }
    }

    public static void anadirDatosTablaTipos(List<CuerpoCeleste> cc) {
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
        if (borrarPorCodigo(codigo) > 0) {
            errorMessage("Elemento borrado con exito");
        } else {
            errorMessage("Elemento no borrado.");
        }
        cerrarRecursos();
    }

    public static void borrarTodo() {
        if (borrarTodosCuerpos() > 0) {
            errorMessage("Datos borrados con exito");
        } else {
            errorMessage("No se pudieron borrar los datos.");
        }
        cerrarRecursos();
    }

    public static void cerrarRecursos() {
        cerrarConexion();
        cerrarResult();
        cerrarSentencia();
    }
}
