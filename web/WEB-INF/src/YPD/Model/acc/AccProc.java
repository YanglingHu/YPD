package YPD.Model.acc;
/**
 *
 * @author Yi Qiu
 */
import Class.User;
import YPD.DatabaseOperation.DBoperation;
import YPD.Model.server.Session;
import YPD.Dic.Dictionary;
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
        ArrayList temp = (ArrayList)_request.getSession().getAttribute("UserSet");
        User user = (User)temp.get(Integer.parseInt(_request.getParameter("key")));
        user.setBanned(0);
        try {
            opr.updataObj(user,Dictionary.TABLE_1);
            Session.refreshAtr(_request, _response, "UserSet",getUserSet(_request, _response));
            return true;
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
        
        ArrayList temp = (ArrayList)_request.getSession().getAttribute("UserSet");
        User user = (User)temp.get(Integer.parseInt(_request.getParameter("key")));
        user.setBanned(1);

        try {
            opr.updataObj(user,Dictionary.TABLE_1);
            Session.refreshAtr(_request, _response, "UserSet",getUserSet(_request, _response));
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        } catch (IllegalAccessException ex) {
            return false;
        }
        
    }

    public void setCookie(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        Cookie[] c = this.generateCookies((String)_request.getAttribute("name"));
        for(Cookie cookie : c){
            _response.addCookie(cookie);
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
            throws ServletException, IOException, IllegalAccessException {
        
        ArrayList temp = (ArrayList)_request.getSession().getAttribute("UserSet");
        User user = (User)temp.get(Integer.parseInt(_request.getParameter("key")));

        try {
            opr.deleteObj(user.getUuid(),Dictionary.TABLE_1);
            Session.refreshAtr(_request, _response, "UserSet",getUserSet(_request, _response));
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }


    /**
     * Generate cookie for user and url.
     * 
     * @param _uuid
     * @return a cookie array that has cookies in it.
     * @throws UnsupportedEncodingException
     */
    public Cookie[] generateCookies(String _uuid) throws UnsupportedEncodingException {
        
        // Generate two cookies.
        Cookie uuid = new Cookie("name", URLEncoder.encode(_uuid, "utf-8"));
        uuid.setMaxAge(60 * 60 * 168);
        Cookie[] cookie = {uuid};
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
        try {
            ArrayList list = new ArrayList<User>();
            User user = new User();
            CachedRowSet crs;       
            crs = opr.getAll(user,Dictionary.TABLE_1);
            ArrayList temp = opr.restoreToObj(crs, user);
            for(Object obj : temp){
                list.add((User)obj);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AccProc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(AccProc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(AccProc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Get one target user from database on this web server.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the getData process success or failed.
     */
    public User getTarget(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException, IllegalArgumentException, IllegalAccessException{
        try {
            User user = new User();
            CachedRowSet crs;       
            crs = opr.getTargetObj(user, _request.getParameter("name"), Dictionary.TABLE_1);
            ArrayList temp = opr.restoreToObj(crs, user);
            for(Object obj : temp){
                user = (User)obj;
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(AccProc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(AccProc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(AccProc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Get one target user from database on this web server.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the getData process success or failed.
     */
    public User getTarget(String _name)
            throws ServletException, IOException, IllegalArgumentException, IllegalAccessException{
        try {
            User user = new User();
            CachedRowSet crs;       
            crs = opr.getTargetObj(user, _name, Dictionary.TABLE_1);
            ArrayList temp = opr.restoreToObj(crs, user);
            for(Object obj : temp){
                user = (User)obj;
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(AccProc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(AccProc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (InstantiationException ex) {
            Logger.getLogger(AccProc.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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
    public int signIn(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException, IllegalArgumentException, IllegalAccessException, SQLException {
        User user;
        String username = _request.getParameter("username");
        String password = _request.getParameter("password");
        user = new User();
        CachedRowSet result = opr.getTargetObj(user, username, Dictionary.TABLE_1);
        while (result.next()) {
            String temp = result.getString("password");
            if(!password.equals(temp) || result.getInt("banned") == 1){
                break;
            }
            _request.setAttribute("name",result.getString("username"));
            
            if(result.getInt("usertype") != 2){
                this.setCookie(_request, _response);
            }
            return result.getInt("usertype");
        }
        return 4;
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
            user = (User)opr.getTargetObj(user,_request.getParameter("uuid"),Dictionary.TABLE_1);
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
