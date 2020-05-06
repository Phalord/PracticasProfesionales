import com.npcstudio.sqlconnection.MySQLConnection;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDatabaseConnection {
    private static final MySQLConnection connection = new MySQLConnection();

    public static void main(String[] args){
        readProperties();
        testConnection();
    }

    private static void readProperties() {
        try {
            connection.readProperties();
        } catch (FileNotFoundException fileNotFoundException) {
            saveProperties();
        }
    }

    private static void testConnection() {
        try {
            connection.getConnection();
            System.out.println("Conexión exitosa");
            connection.closeConnection();
            System.out.println("Conexión cerrada");
        } catch (SQLException exception) {
            System.out.println(String.format("SQLException: %s", exception.getMessage()));
            System.out.println(String.format("SQLException: %s", exception.getErrorCode()));
            System.out.println(String.format("SQLException: %s", exception.getSQLState()));
        }
    }

    private static void saveProperties() {
        try {
            connection.saveProperties();
        } catch (FileNotFoundException fileNotFoundException) {
            Logger.getLogger(TestDatabaseConnection.class.getName())
                    .log(Level.SEVERE, fileNotFoundException.getMessage(), fileNotFoundException);
        }
    }
}
