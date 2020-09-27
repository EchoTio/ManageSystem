package com.util;

import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;



public class JDBC{
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        try{
            driver = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8";
            username = "root";
            password = "admin";
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
    public static void release(Connection connection,Statement statement,ResultSet resultSet){
        if(resultSet!=null){
            try{
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }


    }

}
