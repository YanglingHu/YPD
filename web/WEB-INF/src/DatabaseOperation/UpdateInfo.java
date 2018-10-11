/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperation;

import Class.User;
import javax.sql.*;
import static DatabaseOperation.DatabaseInterface.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "UpdateInfo", urlPatterns = {"/UpdateInfo"})
public class UpdateInfo extends HttpServlet {


    /**
     * Insert a new user in to Database through the Database interface.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int age = Integer.parseInt(request.getParameter("age"));
        int contact = Integer.parseInt(request.getParameter("contact"));
        User user = new User();
        try {
            user = getTargetUser(request.getParameter("uuid"));
            user.setName(request.getParameter("f_name") + " " + request.getParameter("l_name"));
            user.setEmail(request.getParameter("email"));
            user.setAge(Integer.parseInt(request.getParameter("contact")));
            user.setContact(Integer.parseInt(request.getParameter("contact")));
        } catch (SQLException ex) {
            response.sendRedirect("fail.jsp");
        }
            
        if(updateUserInfo(user)){
            response.sendRedirect("success.jsp");
        }else{
            response.sendRedirect("fail.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Update userinfo to mySQL";
    }

}
