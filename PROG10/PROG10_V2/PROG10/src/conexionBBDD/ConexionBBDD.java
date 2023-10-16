package conexionBBDD;

import prog10.entornografico.Login;
import prog10.funcionalidad.modelos.CuerpoCeleste;
import oracle.jdbc.pool.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBBDD extends prog10.entornografico.Login {

    private static Connection conexion = null;
    private static PreparedStatement sentencia;
    private static ResultSet resultSet;
    private static final String SID = cmbBBDD.getSelectedItem().toString();
    private static final String USER = txtUsuario.getText();
    private static final String PWD = new String(Login.pwdPass.getPassword());

    public static Connection construirConexion(String servidor, int puerto, String sid, String usuario, String password) {
        try {
            OracleDataSource ods = new OracleDataSource();
            String url = "jdbc:oracle:thin:@//" + servidor + ":" + puerto + "/" + sid;
            ods.setURL(url);
            ods.setUser(usuario);
            ods.setPassword(password);
            conexion = ods.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
        }
        return conexion;
    }

    public static Connection construirConexion(String sid, String usuario, String password) {
        return construirConexion("localhost", 1521, sid, usuario, password);
    }

    public static Connection getConexion() {
        return conexion;
    }

    /**
     * Metodo para almacenar un cuerpo celeste
     *
     * @param cc (CuerpoCeleste) Objeto CuerpoCeleste
     * @return OK=1, KO=0
     */
    public static int anadirCuerposCelestes(CuerpoCeleste cc) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);
            //Crear la consulta SQL
            String SQLquery = "INSERT INTO CUERPOS_CELESTES "
                    + "(codigo, nombre, tipo, diametro) "
                    + "VALUES (?,?,?,?)";

            //Preparar la ejecucion de la sentencia SQL
            sentencia = conexion.prepareStatement(SQLquery);

            //Establecer los valores para la consulta SQL
            sentencia.setInt(1, cc.getCodigoCuerpo());
            sentencia.setString(2, cc.getNombre());
            sentencia.setString(3, cc.getTipoCuerpo());
            sentencia.setInt(4, cc.getDiametro());

            //Ejecutar la consulta
            int res = sentencia.executeUpdate();
            cerrarSentencia();

            return res;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
            return 0;
        }
    }

    /**
     * Obtiene todos los registros de la tabla CUERPOS_CELESTES
     *
     * @return null = ko
     */
    public static ResultSet obtenerTodosCuerposCelestes() {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);
            //Preparar la ejecucion de la sentencia SQL
            String SQLquery = "SELECT nombre, codigo, tipo, diametro FROM CUERPOS_CELESTES";

            //Establecer los valores para la consulta SQL
            sentencia = conexion.prepareStatement(SQLquery);

            //Ejecutar la consulta
            resultSet = sentencia.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
            return null;
        }
    }

    /**
     * Método que obtiene una lista de cuerpos celestes por código
     *
     * @param code (int) Código del cuerpo celeste
     * @return null = ko
     */
    public static ResultSet obtenerCuerposCelestesPorCodigo(int code) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);

            //Preparar la ejecucion de la sentencia SQL
            String SQLquery = "SELECT nombre, codigo, tipo, diametro FROM CUERPOS_CELESTES WHERE codigo=?";
            sentencia = conexion.prepareStatement(SQLquery);

            //Establecer los valores para la consulta SQL
            sentencia.setInt(1, code);

            //Ejecutar la consulta
            resultSet = sentencia.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
            return null;
        }
    }

    /**
     * Método que obtiene una lista de cuerpos celestes por tipo
     *
     * @param tipo(String) Tipo del cuerpo celeste
     * @return null = ko
     */
    public static ResultSet obtenerCuerposCelestesPorTipo(String tipo) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);

            //Preparar la ejecucion de la sentencia SQL

            String SQLquery = "SELECT nombre, codigo, tipo, diametro FROM CUERPOS_CELESTES WHERE lower(tipo)=lower(?)";
            sentencia = conexion.prepareStatement(SQLquery);

            //Establecer los valores para la consulta SQL
            sentencia.setString(1, tipo);

            //Ejecutar la consulta
            resultSet = sentencia.executeQuery();
            return resultSet;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
            return null;
        }
    }

    /**
     * Método para eliminar cuerpos celestes
     *
     * @param code (short) Código del cuerpo celeste que queremos eliminar
     * @return OK=1, KO=0
     */
    public static int borrarPorCodigo(short code) {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);

            //Preparar la ejecucion de la sentencia SQL
            String SQLquery = "DELETE FROM CUERPOS_CELESTES WHERE codigo=?";
            sentencia = conexion.prepareStatement(SQLquery);

            //Establecer los valores para la consulta SQL
            sentencia.setShort(1, code);

            //Ejecutar la consulta
            int res = sentencia.executeUpdate();
            cerrarSentencia();

            return res;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
            return 0;
        }
    }

    public static int borrarTodosCuerpos() {
        try {
            //Construir conexion
            construirConexion(SID, USER, PWD);

            //Preparar la ejecucion de la sentencia SQL
            String SQLquery = "DELETE FROM CUERPOS_CELESTES";
            sentencia = conexion.prepareStatement(SQLquery);

            //Ejecutar la consulta
            int res = sentencia.executeUpdate();
            cerrarSentencia();

            return res;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
            return 0;
        }
    }

    public static void cerrarResult() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, "Error al cerrar el ResultSet", ex);
        }
    }

    public static void cerrarSentencia() {
        try {
            if (sentencia != null) {
                sentencia.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void cerrarConexion() {
        try {
            if (resultSet != null) {
                cerrarResult();
            }
            if (sentencia != null) {
                cerrarSentencia();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
