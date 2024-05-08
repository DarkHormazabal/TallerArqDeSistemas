package org.example.ConectionSQLData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConection {

    public static Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:sqlite:C:/Users/56949/IdeaProjects/TallerDeArqDeSistemas/Card.db";
        return DriverManager.getConnection(jdbcUrl);
    }
}
