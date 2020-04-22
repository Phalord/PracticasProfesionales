package com.npcstudio.sqlconnection;

import java.sql.SQLException;

public class ConnectionTest {

    public static void main(String[] args) {
        MySQLConnection connection = new MySQLConnection();
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
