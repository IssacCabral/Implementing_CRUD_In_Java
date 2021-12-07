package mypackage.database;

import mypackage.config.AppConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(AppConfig.getconfig().getProperty("database.url"),
                AppConfig.getconfig().getProperty("database.user"),
                AppConfig.getconfig().getProperty("database.pass"));
    }
}
