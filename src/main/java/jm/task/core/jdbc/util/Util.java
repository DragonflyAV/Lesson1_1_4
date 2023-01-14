package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/Lesson1_1_4?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "dragonfly";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        return connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
