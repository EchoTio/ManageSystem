package com.servlet;

import com.mysql.jdbc.ResultSet;
import com.util.JDBC;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.JDBC;
public class AddLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        Connection con = null;
        ResultSet rs = null;

        PreparedStatement ps = null;
        try {
            con =JDBC.getConnection();
            Statement s =con.createStatement();
            String sql="SELECT name FROM info";
            ps=con.prepareStatement(sql);
            rs= (ResultSet) ps.executeQuery();
            while (rs.next()){
                if(name.equals(rs.getString("name"))){
                    request.getRequestDispatcher("failed_exist.html").forward(request, response);
                    return;
                }
            }

            String ins="INSERT into info VALUES(?,?)";
            ps=con.prepareStatement(ins);
            ps.setString(1,name);
            ps.setString(2,password);
            int i =ps.executeUpdate();
            if(i==1){
                response.sendRedirect("index.jsp");
            }else{
                request.getRequestDispatcher("fail.html").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC.release(con,ps,rs);
        }


    }
}
