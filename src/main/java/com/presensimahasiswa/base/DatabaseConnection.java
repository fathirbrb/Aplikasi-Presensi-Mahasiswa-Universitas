package com.presensimahasiswa.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn;

    public static Connection connect() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/presensi_mahasiswa", "root", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
