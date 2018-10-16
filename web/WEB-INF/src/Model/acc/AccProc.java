package Model.acc;

import Class.User;
import DatabaseOperation.DatabaseInterface;
import static DatabaseOperation.DatabaseInterface.getTargetUser;
import static DatabaseOperation.DatabaseInterface.updateUserInfo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.sql.rowset.CachedRowSet;
import java.util.*;
import java.net.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Yi Qiu
 */
public class AccProc {

    /**
     * Generate a uuid for the user.
     * 
     * @return a uuid
     */
    public static String getUID() {
        
        String uuid = UUID.randomUUID().toString();
//        System.out.println(uuid);
        return uuid;
    }

    /**
     * Generate cookie for user and url.
     * 
     * @param _name username to generate the cookie
     * @param _url url to generate the cookie
     * @return a cookie array that has cookies in it.
     * @throws UnsupportedEncodingException
     */
    public static Cookie[] generateCookies(String _name, String _url) throws UnsupportedEncodingException {
        
        // Generate two cookies.
        Cookie name = new Cookie("name", URLEncoder.encode(_name, "utf-8"));
        Cookie url = new Cookie("name", URLEncoder.encode(_url, "utf-8"));
        name.setMaxAge(60 * 60 * 168);
        url.setMaxAge(60 * 60 * 168);
        Cookie[] cookie = {name, url};
        return cookie;
    }

    /**
     * Set the age of all cookies that are in the cookie array 
     * to zero.
     * 
     * @param _cookie a array contains cookies that are going to be killed.
     * @return a array contains cookies that are killed
     */
    public static Cookie[] killAllCookies(Cookie[] _cookie) {
        
        for (int i = 0; i < _cookie.length; i++) {
            _cookie[i].setMaxAge(0);
        }
        return _cookie;
    }

    /**
     * Logout the user taht is logged-in.
     * 
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static void logOut(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
        //Get user's cookie.
        Cookie[] cookies = _request.getCookies();
        //Remove the cookie.
        cookies = killAllCookies(cookies);
        for (int i = 0; i < cookies.length; i++) {
            _response.addCookie(cookies[i]);
        }
        //Return to the home page.
        _response.sendRedirect("index.jsp");
    }

    /**
     * Update the new user-info to database.
     * 
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static void updateInfo(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
        // Get updated user input.
        int age = Integer.parseInt(_request.getParameter("age"));
        int contact = Integer.parseInt(_request.getParameter("contact"));
        // Initialize local User class.
        User user = new User();
        try {
            // Load old information to local User class.
            user = getTargetUser(_request.getParameter("uuid"));
            // Update.
            user.setName(_request.getParameter("f_name") + " " + _request.getParameter("l_name"));
            user.setEmail(_request.getParameter("email"));
            user.setAge(Integer.parseInt(_request.getParameter("contact")));
            user.setContact(Integer.parseInt(_request.getParameter("contact")));
        } catch (SQLException ex) {
            // Exception catched means failed.
            _response.sendRedirect("fail.jsp");
        }
            // Decide what to do next based on the returned boolean value.
        if(updateUserInfo(user)){
            _response.sendRedirect("success.jsp");
        }else{
            _response.sendRedirect("fail.jsp");
        }
    }
    
    /**
     * Add a new user to the web server.
     * 
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is signup success or failed.
     */
    public static boolean signUp(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
        return false;
    }
    
    /**
     * User login to the web server.
     * 
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is login success or failed.
     */
    public static boolean signIn(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
        return false;
    }
    
    /**
     * Permanently remove a user from this web server.
     * 
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the delete process success or failed.
     */
    public static boolean deleteUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
        User user = (User)_request.getAttribute("user");
        return DatabaseInterface.deleteUserFromDB(user);
    }
    
    /**
     * Prohibit a user from signing in this web server.
     * 
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the ban process success or failed.
     */
    public static boolean banUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
        User user = (User)_request.getAttribute("user");
        user.setBanned(true);
        return DatabaseInterface.updateUserInfo(user);
        
    }
    
    /**
     * Allow a user to sign in this web server again.
     * 
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the activation process success or failed.
     */
    public static boolean activateUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        User user = (User)_request.getAttribute("user");
        user.setBanned(false);
        return DatabaseInterface.updateUserInfo(user);
    }
    
    /**
     * Get all users from database on this web server.
     * 
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the getData process success or failed.
     */
    public static ArrayList getUserSet(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        ArrayList list = new ArrayList();
        CachedRowSet crs;
        try {
            crs = DatabaseInterface.getUserDataSet();
            while(crs.next()){
                list.add(new User(crs.getString("UUID"),crs.getString("username"),crs.getString("password"),
                        crs.getInt("userType"),crs.getString("name"),crs.getInt("age"),crs.getInt("contact"),
                        crs.getString("email"),crs.getBoolean("gender")));
            }
            crs.close();
        } catch (SQLException ex) {
           
        }       
        return list;
    }
}
