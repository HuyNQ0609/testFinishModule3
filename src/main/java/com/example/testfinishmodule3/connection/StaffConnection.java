package com.example.testfinishmodule3.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StaffConnection {
    private static final String jdbcURL = "jdbc:mysql://localhost:3306/staff_management?useUnicode=yes&characterEncoding=UTF-8";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "Huynhitu12";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Connection successfully");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
