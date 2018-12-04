package YPD.Model.acc;

import Class.User;
import YPD.DatabaseOperation.DBoperation;
import YPD.Dic.Dictionary;
import static YPD.Model.acc.Verification.*;
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
import org.json.JSONException;

/**
 * Manage the basic functions the user will call.
 *
 * @Update 2018/11/20
 * @author Yi Qiu, Yangling Hu
 */
public class AccProc {
    
    private DBoperation opr;
    
    /**
     * Generate a uuid for the user.
     *
     * @return a uuid
     */
    public static String getUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }


    /**
     * Set the age of all cookies that are in the cookie array to zero.
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
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public AccProc() throws SQLException, ClassNotFoundException {
        this.opr = new DBoperation();
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
    public boolean activateUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        ArrayList temp = (ArrayList) _request.getSession().getAttribute("UserSet");
        User user = (User) temp.get(Integer.parseInt(_request.getParameter("key")));
        user.setBanned(0);
        try {
            opr.updataObj(user, Dictionary.TABLE_1);
            _request.getSession().setAttribute("UserSet", getUserSet(_request, _response));
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        } catch (IllegalAccessException ex) {
            return false;
        }
    }


    /**
     * Get all doctors that have required MID and set them into HttpSession.
     *
     * @param _request
     * @param _response
     * @throws ServletException
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public void automatch(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException, IllegalArgumentException, IllegalAccessException {
        ArrayList t_arr = this.getUserSet(_request, _response);
        ArrayList f_arr = new ArrayList<User>();
        String[] MID = ((User) _request.getSession().getAttribute("C_User")).getMidArray();

        for (Object obj : t_arr) {
            for (String s : MID) {
                String[] match = ((User) obj).getMidArray();

                if (Arrays.asList(match).contains(s) && ((User) obj).getUsertype() == Dictionary.STATUS_CODE_DOCTOR) {
                    f_arr.add((User) obj);
                    break;
                }
            }
        }
        HttpSession session = _request.getSession();
        session.setAttribute("DoctorSet", f_arr);
        _response.sendRedirect("match.jsp");
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

        ArrayList temp = (ArrayList) _request.getSession().getAttribute("UserSet");
        User user = (User) temp.get(Integer.parseInt(_request.getParameter("key")));
        user.setBanned(1);

        try {
            opr.updataObj(user, Dictionary.TABLE_1);
            _request.getSession().setAttribute("UserSet", getUserSet(_request, _response));
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        } catch (IllegalAccessException ex) {
            return false;
        }
    }


    /**
     * Release the DBoperation instance.
     *
     * @throws SQLException
     */
    public void close() throws SQLException {
        opr.close();
    }

    /**
     * Permanently remove a user from this web server.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the delete process success or failed.
     * @throws IllegalAccessException
     */
    public boolean deleteUser(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException, IllegalAccessException {

        ArrayList temp = (ArrayList) _request.getSession().getAttribute("UserSet");
        User user = (User) temp.get(Integer.parseInt(_request.getParameter("key")));

        try {
            opr.deleteObj(user.getUuid(), Dictionary.TABLE_1);
            _request.getSession().setAttribute("UserSet", getUserSet(_request, _response));
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
     * Get one target user from database on this web server.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the getData process success or failed.
     * @throws java.lang.IllegalAccessException
     */
    public User getTarget(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException, IllegalArgumentException, IllegalAccessException {
        try {
            User user = new User();
            CachedRowSet crs;
            crs = opr.getTargetObj(user, _request.getParameter("name"), Dictionary.TABLE_1);
            ArrayList temp = opr.restoreToObj(crs, user);
            for (Object obj : temp) {
                user = (User) obj;
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
     * @param _name
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the getData process success or failed.
     * @throws IllegalAccessException
     */
    public User getTarget(String _name)
            throws ServletException, IOException, IllegalArgumentException, IllegalAccessException {
        try {
            User user = new User();
            CachedRowSet crs;
            crs = opr.getTargetObj(user, _name, Dictionary.TABLE_1);
            ArrayList temp = opr.restoreToObj(crs, user);
            for (Object obj : temp) {
                user = (User) obj;
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
     * Get all users from database on this web server.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is the getData process success or failed.
     * @throws IllegalAccessException
     */
    public ArrayList getUserSet(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException, IllegalArgumentException, IllegalAccessException {
        try {
            ArrayList list = new ArrayList<User>();
            User user = new User();
            CachedRowSet crs;
            crs = opr.getAll(user, Dictionary.TABLE_1);
            ArrayList temp = opr.restoreToObj(crs, user);
            for (Object obj : temp) {
                list.add((User) obj);
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
     * Get all doctors that have required MID and set them into HttpSession.
     *
     * @param _request
     * @param _response
     * @throws ServletException
     * @throws IOException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public void match(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException, IllegalArgumentException, IllegalAccessException {

        if (!_request.getParameter("pairing").equals("true")) {
            ArrayList t_arr = this.getUserSet(_request, _response);
            ArrayList f_arr = new ArrayList<User>();
            String MID = _request.getParameter("MID");

            if (MID == null) {
                for (Object t : t_arr) {
                    User temp = (User) t;

                    if (temp.getUsertype() == Dictionary.STATUS_CODE_DOCTOR) {
                        f_arr.add(temp);
                    }
                }
            } else {
                for (Object t : t_arr) {
                    User temp = (User) t;
                    String[] s = temp.getMidArray();

                    if (Arrays.asList(s).contains(MID) && temp.getUsertype() == Dictionary.STATUS_CODE_DOCTOR) {
                        f_arr.add(temp);
                    }
                }
            }
            HttpSession session = _request.getSession();
            session.setAttribute("DoctorSet", f_arr);
            _response.sendRedirect("match.jsp");
        } else {
            this.automatch(_request, _response);
        }
    }


    /**
     *
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void setCookie(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        Cookie[] c = this.generateCookies((String) _request.getAttribute("name"));
        for (Cookie cookie : c) {
            _response.addCookie(cookie);
        }
    }


    /**
     * User login to the web server.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is login success or failed.
     * @throws SQLException
     * @throws IllegalAccessException
     */
    public int signIn(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException, IllegalArgumentException, IllegalAccessException, SQLException {
        User user;
        String username = _request.getParameter("username");
        String password = _request.getParameter("password");
        if (_request.getParameter("username").equals("") && _request.getParameter("password").equals("")) {
            user = new User();
            CachedRowSet result = opr.getTargetObj(user, username, Dictionary.TABLE_1);
            if (result != null && result.next()) {
                String temp = result.getString("password");
                if (!password.equals(temp) || result.getInt("banned") == Dictionary.ERROR_CODE_1) {
                    return Dictionary.ERROR_CODE_1;
                }
                _request.setAttribute("name", result.getString("username"));

                if (result.getInt("usertype") != Dictionary.STATUS_CODE_MANAGER) {
                    this.setCookie(_request, _response);
                }
                return result.getInt("usertype");
            }
        }
        return Dictionary.ERROR_CODE_4;
    }


    /**
     * Add a new user to the web server.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @return is success or failed.
     */
    public String signUp(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        String s = "";
        try {
            if (_request.getParameter("username").equals("") && _request.getParameter("password").equals("")) {
                if (_request.getParameter("NPI") != null) {
                    s = " Verification Failed: Please make sure your name and NPI matches each other!";
                    Map<String, String> map = checkForDoctor(_request.getParameter("firstname"), _request.getParameter("NPI"));

                    if (map != null) {
                        User user = new User(this.getUID(), _request.getParameter("username"), _request.getParameter("password"), Dictionary.STATUS_CODE_DOCTOR, "Unknown");
                        user.setName(map.get("first_name"));
                        user.setImg(map.get("img"));
                        if (opr.newObjToDB(user, Dictionary.TABLE_1)) {
                            return "Success";
                        }

                    }
                }
            } else {
                s = " Provided infomation is invalid/ Username is already registered by others";
                User user = new User(this.getUID(), _request.getParameter("username"), _request.getParameter("password"), Dictionary.STATUS_CODE_USER, "Unknown");
                if (opr.newObjToDB(user, Dictionary.TABLE_1)) {
                    return "Success";
                }
            }
        } catch (JSONException | IllegalArgumentException | IllegalAccessException ex) {
            return ex.toString();
        }
        return s;
    }

}
