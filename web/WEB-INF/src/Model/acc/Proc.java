package Model.acc;

import Class.User;
import DatabaseOperation.DatabaseInterface.*;
import static DatabaseOperation.DatabaseInterface.getTargetUser;
import static DatabaseOperation.DatabaseInterface.updateUserInfo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.*;
import java.net.*;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Yi Qiu
 */
public class Proc {

    /**
     *
     * @return
     */
    public static String getUID() {
        String uuid = UUID.randomUUID().toString();
//        System.out.println(uuid);
        return uuid;
    }

    /**
     *
     * @param _user
     * @return
     */
    public static boolean isExisted(User _user) {
        //?
        return false;
    }

    /**
     *
     * @param _name
     * @param _url
     * @return
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
     *
     * @param _cookie
     * @return
     */
    public static Cookie[] killAllCookies(Cookie[] _cookie) {
        for (int i = 0; i < _cookie.length; i++) {
            _cookie[i].setMaxAge(0);
        }
        return _cookie;
    }

    /**
     *
     * @param _request
     * @param _response
     * @throws ServletException
     * @throws IOException
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
     *
     * @param _request
     * @param _response
     * @throws ServletException
     * @throws IOException
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
     *
     * @param _request
     * @param _response
     * @throws ServletException
     * @throws IOException
     */
    public static void signUp(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
    }
    
    /**
     *
     * @param _request
     * @param _response
     * @throws ServletException
     * @throws IOException
     */
    public static void signIn(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
    }
    
    
    public static void deleteUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
    }
    
    /**
     *
     * @param _request
     * @param _response
     * @throws ServletException
     * @throws IOException
     */
    public static void banUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
    }
    
    /**
     *
     * @param _request
     * @param _response
     * @throws ServletException
     * @throws IOException
     */
    public static void activateUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
    }
}
