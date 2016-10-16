
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    private static final String userid = "miguel.santeliz";
    private static final String pass = "123";
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=SEGURIDAD";
    private static Connection con = null;
    
    public static Connection conectarse() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.DriverJDBCVersion");
            con = DriverManager.getConnection(url, userid, pass);
////            System.out.println("Conectado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR: " + ex.getMessage());
        }
        return con;
    
    }
    
////    public static void main (String...arg){
////        conectarse();
////    }
}
