import com.npcstudio.sqlconnection.MySQLConnection;

import java.sql.SQLException;

public class TestDatabaseConnection {

    public static void main(String[] args) throws Exception{
        MySQLConnection connection = new MySQLConnection();
        connection.readProperties();
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

}
