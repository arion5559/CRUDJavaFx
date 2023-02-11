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

            conn.setCatalog("javafxusers");

            SQLSentence = (Statement) conn.createStatement();

            if (sentence.toLowerCase().startsWith("select")) {
                rs = SQLSentence.executeQuery(sentence);
            } else {
                SQLSentence.executeUpdate(sentence);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }

        System.out.println("Desconectado");

        return rs;
    }
}
