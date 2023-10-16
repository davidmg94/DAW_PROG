package clasesConexionBBDD;

import prog10.entornografico.Login;
import prog10.funcionalidad.modelos.CuerpoCeleste;
import oracle.jdbc.pool.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlternativaConexionBBDD extends prog10.entornografico.Login {

    private static Connection conexion = null;
    private static final String SID = cmbBBDD.getSelectedItem().toString();
    private static final String USER = txtUsuario.getText();
    private static final String PWD = new String(Login.pwdPass.getPassword());

    public static Connection construirConexion(String ipDelServidor, int puertoDelServidor, String sid, String usuario, String password) {
        try {
            OracleDataSource ods = new OracleDataSource();
            String url = "jdbc:oracle:thin:@//" + ipDelServidor + ":" + puertoDelServidor + "/" + sid;
            ods.setURL(url);
            ods.setUser(usuario);
            ods.setPassword(password);
            conexion = ods.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AlternativaConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement ps = conexion.prepareStatement(SQLquery, Statement.RETURN_GENERATED_KEYS);

            //Establecer los valores para la consulta SQL
            ps.setInt(1, cc.getCodigoCuerpo());
            ps.setString(2, cc.getNombre());
            ps.setString(3, cc.getTipoCuerpo());
            ps.setInt(4, cc.getDiametro());

            //Ejecutar la consulta
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(AlternativaConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement ps = conexion.prepareStatement(SQLquery);

            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(AlternativaConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement ps = conexion.prepareStatement(SQLquery);

            //Establecer los valores para la consulta SQL
            ps.setInt(1, code);

            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(AlternativaConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
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
            String SQLquery = "SELECT nombre, codigo, tipo, diametro FROM CUERPOS_CELESTES WHERE tipo=?";
            PreparedStatement ps = conexion.prepareStatement(SQLquery);

            //Establecer los valores para la consulta SQL
            ps.setString(1, tipo);

            //Ejecutar la consulta
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(AlternativaConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement ps = conexion.prepareStatement(SQLquery);

            //Establecer los valores para la consulta SQL
            ps.setShort(1, code);

            //Ejecutar la consulta
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(AlternativaConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
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
            PreparedStatement ps = conexion.prepareStatement(SQLquery);

            //Ejecutar la consulta
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(AlternativaConexionBBDD.class.getName()).log(Level.SEVERE, null, ex);
            conexion = null;
            return 0;
        }
    }
}
