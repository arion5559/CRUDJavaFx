package com.example.crudjavafx;

import java.sql.*;

public class DatabaseConnection {
    public static ResultSet execute(String sentence) throws SQLException {
        Connection conn = null;
        String url = "jdbc:mysql://localhost";
        String user = "root";
        String password = "";
        Statement SQLSentence;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado");

            SQLSentence = (Statement) conn.createStatement();

            rs = SQLSentence.executeQuery(sentence);
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        } finally {
            if (conn != null){
                conn.close();
            }
        }

        System.out.println("Desconectado");

        return rs;
    }
}
