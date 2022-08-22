package com.example.SBproject;


import java.sql.*;
import java.util.*;

public class Database {

    public void CreateDB() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://bsck.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
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
    public List<String[]> getUsers() throws SQLException {
            List<String[]> users = new ArrayList<>();
            String[] user = new String[3];
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //Getting the connection
            String mysqlUrl = "jdbc:mysql://bsck.mysql.database.azure.com:3306?useSSL=true";
            Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
            String query4 = "SELECT * FROM Employee.employees;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query4);
            while (rs.next()) {
                user = new String[3];
                System.out.println(rs.getString("first_name"));
                user[0] = rs.getString("username");
                user[1] = rs.getString("first_name");
                user[2] = rs.getString("first_name");
                users.add(user);
            }
            return users;
        }
    public void getName() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://bsck.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String query4 = "SELECT * FROM Employee.employees;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query4);
        while (rs.next()) {
            System.out.println(rs.getString("first_name"));
        }
    }

    public void Insert(String x, String y, String z) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://bsck.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String InsertQ = "INSERT INTO Employee.employees (username,first_name,last_name) VALUES (?,?,?);";
        PreparedStatement preparedStmt = con.prepareStatement(InsertQ);
        preparedStmt.setString(1, x);
        preparedStmt.setString(2, y);
        preparedStmt.setString(3, z);
        preparedStmt.executeUpdate();
    }

    public void testInsert() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://bsck.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String query3 = "INSERT INTO Employee.employees (username, first_name, last_name) VALUES ('BCoss', 'Brandon','Cossin');";
        Statement stmt = con.createStatement();
        stmt.executeUpdate(query3);
    }

    public void DeleteEmployee(String x) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://bsck.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String DeleteQ = "DELETE FROM Employee.employees WHERE username = ?;";
        PreparedStatement preparedStmt = con.prepareStatement(DeleteQ);
        preparedStmt.setString(1, x);
        preparedStmt.executeUpdate();
    }

    public void ChangeUsername(String x, String y) throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //Getting the connection
        String mysqlUrl = "jdbc:mysql://bsck.mysql.database.azure.com:3306?useSSL=true";
        Connection con = DriverManager.getConnection(mysqlUrl, "skanner", "Password12345");
        String DeleteQ = "UPDATE Employee.employees SET username = ? WHERE username = ?;";
        PreparedStatement preparedStmt = con.prepareStatement(DeleteQ);
        preparedStmt.setString(1, x);
        preparedStmt.setString(2, y);
        preparedStmt.executeUpdate();
    }

}
