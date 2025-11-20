package com.quackeyikz.manager;

import java.sql.*;

public class DBConnection {
        private final static String JDBC = "";
        private final static String USER = "";
        private final static String PASS = "";

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
