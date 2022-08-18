package com.example.SBproject;


import java.sql.*;
public class Database {

    public void CreateDB() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost/";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "password");
        System.out.println("Connection established......");
        //Creating the Statement
        Statement stmt = con.createStatement();

        //Query to create a database
        String query = "CREATE database IF NOT EXISTS Employee";
        String query2 = "CREATE TABLE IF NOT EXISTS Employee.employees (username VARCHAR(20), first_name VARCHAR(20),last_name VARCHAR(20));";
        //String query3 = "INSERT INTO Employee.employees (username, first_name, last_name) VALUES ('skanner', 'Shayne','Kanner');";


        //Executing the query
        stmt.execute(query);
        stmt.execute(query2);
        //stmt.execute(query3);
        //System.out.println(rs);
        }

    public void getName() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://localhost/";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "password");
        String query4 = "SELECT * FROM Employee.employees;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query4);
        while (rs.next()) {
            System.out.println(rs.getString("first_name"));
        }
    }

}
