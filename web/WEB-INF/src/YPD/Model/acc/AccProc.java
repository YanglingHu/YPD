package YPD.Model.acc;
/**
 *
 * @author Yi Qiu
 */
import Class.User;
import YPD.DatabaseOperation.DBoperation;
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


public class AccProc {
    /**
     * Allow a user to sign in this web server again.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the activation process success or failed.
     */
    private DBoperation opr;

    public AccProc() throws SQLException, ClassNotFoundException {
        this.opr = new DBoperation();
    }
    
    
    
    public boolean activateUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        User user = (User)_request.getAttribute("user");
        user.setBanned(0);
        try {
            return opr.updataObj(user,user.getUuid());
        } catch (IllegalArgumentException ex) {
            return false;
        } catch (IllegalAccessException ex) {
            return false;
        }
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
    public boolean banUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
        User user = (User)_request.getAttribute("user");
        user.setBanned(1);

        try {
            return opr.updataObj(user, user.getUuid());
        } catch (IllegalArgumentException ex) {
            return false;
        } catch (IllegalAccessException ex) {
            return false;
        }
        
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
    public boolean deleteUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
        User user = (User)_request.getAttribute("user");

        try {
            return opr.deleteObj(user.getUuid());
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }


    /**
     * Generate cookie for user and url.
     * 
     * @param _name username to generate the cookie
     * @param _url url to generate the cookie
     * @return a cookie array that has cookies in it.
     * @throws UnsupportedEncodingException
     */
    public static Cookie[] generateCookies(String _name, String _uuid) throws UnsupportedEncodingException {
        
        // Generate two cookies.
        Cookie name = new Cookie("name", URLEncoder.encode(_name, "utf-8"));
        Cookie uuid = new Cookie("uuid", URLEncoder.encode(_uuid, "utf-8"));
        name.setMaxAge(60 * 60 * 168);
        uuid.setMaxAge(60 * 60 * 168);
        Cookie[] cookie = {name, uuid};
        return cookie;
    }


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
     * Get all users from database on this web server.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the getData process success or failed.
     */
    public ArrayList getUserSet(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException, IllegalArgumentException, IllegalAccessException{
        ArrayList list = new ArrayList();
        User user = new User();
        CachedRowSet crs;

        try {
            crs = opr.getAll(user);
            while(crs.next()){
                list.add(new User(crs.getString("UUID"),crs.getString("username"),crs.getString("password"),
                        crs.getInt("userType"),crs.getString("name"),crs.getInt("age"),crs.getInt("contact"),
                        crs.getString("email"),crs.getInt("gender")));
            }
            crs.close();
        } catch (SQLException ex) {
            
        }
        return list;
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
     * Update the new user-info to database.
     * 
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void updateInfo(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
        try {
            // Get updated user input.
            int age = Integer.parseInt(_request.getParameter("age"));
            int contact = Integer.parseInt(_request.getParameter("contact"));
            // Initialize local User class.
            User user = new User();
            // Load old information to local User class.
            user = (User)opr.getTargetObj(user,_request.getParameter("uuid"));
            // Update.
            user.setName(_request.getParameter("f_name") + " " + _request.getParameter("l_name"));
            user.setEmail(_request.getParameter("email"));
            user.setAge(Integer.parseInt(_request.getParameter("contact")));
            user.setContact(Integer.parseInt(_request.getParameter("contact")));
            // Decide what to do next based on the returned boolean value.
            if(opr.updataObj(user,user.getUuid())){
                _response.sendRedirect("success.jsp");
            }else{
                _response.sendRedirect("fail.jsp");
            }
        } catch (IllegalArgumentException ex) {
            _response.sendRedirect("fail.jsp");
        } catch (IllegalAccessException ex) {
            _response.sendRedirect("fail.jsp");
        }
    }
    
    public void close() throws SQLException{
        opr.close();
    }
    
}
