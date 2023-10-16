package ClasesConexionBBDD;

public class ConexionMariaDB extends ConexionBBDD {

    public ConexionMariaDB(String host, String puerto, String baseDatos, String usuario, String password) {
        super("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + host + ":" + puerto + "/" + baseDatos, usuario, password);
    }

    public ConexionMariaDB(String host, String baseDatos, String usuario, String password) {
        super("org.mariadb.jdbc.Driver", "jdbc:mariadb://" + host + "/" + baseDatos, usuario, password);
    }  
}