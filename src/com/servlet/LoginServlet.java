package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;
import com.pojo.info;
import com.util.JDBC;
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        try{
            con=JDBC.getConnection();
            Statement s= con.createStatement();
            String sql = "SELECT * FROM info where name = ?";
            ps=con.prepareStatement(sql);
            ps.setString(1,name);
            rs = (ResultSet) ps.executeQuery();
            while (rs.next()){
                if(password.equals(rs.getString("password"))){
                    request.getRequestDispatcher("success.html").forward(request, response);
                }
                else{
                    response.sendRedirect("index.jsp");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBC.release(con,ps,rs);
        }




    }

}
