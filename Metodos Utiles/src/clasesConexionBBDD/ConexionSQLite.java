package ClasesConexionBBDD;

public class ConexionSQLite extends ConexionBBDD {

    public ConexionSQLite(String ruta) {
        super("org.sqlite.JDBC", "jdbc:sqlite:" + ruta);
    }
}