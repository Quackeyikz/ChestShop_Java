package com.quackeyikz.manager;

import java.sql.*;

public class DBConnection {
        private final static String JDBC = "jdbc:postgresql://localhost:5432/chestshop_db";
        private final static String USER = "postgres";
        private final static String PASS = "eyyikzsu";

        static {
                try {
                        Class.forName("org.postgresql.Driver"); 
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }
        }
        
        public static Connection getConnection() throws SQLException{
                return DriverManager.getConnection(JDBC, USER, PASS);
        }
        
        // Just a test ~ Quackeyikz
        public static void main(String args[]){
                try {
                        Connection conn = DBConnection.getConnection();
                        System.out.println("Database connected successfully.");
                } catch (SQLException e){
                        e.printStackTrace();
                }

        }
}
