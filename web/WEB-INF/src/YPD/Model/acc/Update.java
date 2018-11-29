package YPD.Model.acc;
import Class.User;
import YPD.DatabaseOperation.DBoperation;
import YPD.Dic.Dictionary;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Administrator
 */
public class Update {
    

    /**
     * Update the new user-info to database.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static void updateImg(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {

        try {
            DBoperation opr = new DBoperation();
            HttpSession session = _request.getSession();
            // Get updated user input.
            // Initialize local User class.
            User user = (User)session.getAttribute("C_User");

            // Decide what to do next based on the returned boolean value.
            if (opr.updataObj(user, Dictionary.TABLE_1)) {
                _response.sendRedirect("Success.jsp");
            } else {
                _response.sendRedirect("Failed.jsp");
            }
        } catch (IllegalArgumentException ex) {
            _response.sendRedirect("Failed.jsp");
        } catch (IllegalAccessException ex) {
            _response.sendRedirect("Failed.jsp");
        } catch (SQLException ex) {
            _response.sendRedirect("Failed.jsp");
        } catch (ClassNotFoundException ex) {
            _response.sendRedirect("Failed.jsp");
        }
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

        try {
            DBoperation opr = new DBoperation();
            HttpSession session = _request.getSession();
            // Get updated user input.
            // Initialize local User class.
            User user = (User)session.getAttribute("C_User");
            user.setGender(Integer.parseInt(_request.getParameter("Gender")));
            user.setEmail(_request.getParameter("Email"));
            user.setAge(Integer.parseInt(_request.getParameter("Age")));
            //user.setContact(Integer.parseInt(_request.getParameter("PhoneNumber")));
            user.setName(_request.getParameter("Name"));

            // Decide what to do next based on the returned boolean value.
            if (opr.updataObj(user, Dictionary.TABLE_1)) {
                session.setAttribute("C_User", user);
                _response.sendRedirect("Success.jsp");
            } else {
                _response.sendRedirect("Failed.jsp");
            }
        } catch (IllegalArgumentException ex) {
            _response.sendRedirect("Failed.jsp");
            System.out.println(ex);
        } catch (IllegalAccessException ex) {
            _response.sendRedirect("Failed.jsp");
            System.out.println(ex);
        } catch (SQLException ex) {
            _response.sendRedirect("Failed.jsp");
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            _response.sendRedirect("Failed.jsp");
            System.out.println(ex);
        }
    }    
    
    /**
     * Update the new user-info to database.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static void updateTag(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {

        try {
            DBoperation opr = new DBoperation();
            HttpSession session = _request.getSession();
            // Get updated user input.
            // Initialize local User class.
            User user = (User)session.getAttribute("C_User");
            user.setMID(tagBuilder(_request,_response));
            
            // Decide what to do next based on the returned boolean value.
            if (opr.updataObj(user, Dictionary.TABLE_1)) {
                session.setAttribute("C_User", user);
                _response.sendRedirect("Success.jsp");
            } else {
                _response.sendRedirect("Failed.jsp");
            }
        } catch (IllegalArgumentException ex) {
            _response.sendRedirect("Failed.jsp");
        } catch (IllegalAccessException ex) {
            _response.sendRedirect("Failed.jsp");
        } catch (SQLException ex) {
            _response.sendRedirect("Failed.jsp");
        } catch (ClassNotFoundException ex) {
            _response.sendRedirect("Failed.jsp");
        }
    }    
    
    public static String tagBuilder(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        String tags = "";
        String[] temp = _request.getParameterValues("chk[]");
        if(temp != null){
            for(String s : temp){
            tags += s + ",";
            }
        }

        return tags;
    }
}
