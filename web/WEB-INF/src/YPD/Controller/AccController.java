package YPD.Controller;
import Class.User;
import YPD.Dic.Dictionary;
import YPD.Model.acc.AccProc;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
/**
 *
 * @Update 2018/11/20
 * @author Yi Qiu
 */
@WebServlet(name = "AccController", urlPatterns = {"/AccController"})
public class AccController extends HttpServlet {

    /**
     * If the type of HttpRequest is GET, treat it as POST.
     *
     * @param _request Http request.
     * @param _response Http response.
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        doPost(_request, _response);
    }

    /**
     * Call the appropriate method to Handle the HttpRequest.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {

        try {
            String cases = _request.getParameter("method");
            AccProc accProc = new AccProc();
            //
            if (cases == null || cases.trim().isEmpty()) {
                throw new IOException("Empty method parameter.");
            } else {
                switch (cases) {
                    //
                    case "Logoff":
                        accProc.logOut(_request, _response);
                        break;
                    //
                    case "SignIn":
                        int temp = accProc.signIn(_request, _response);
                        //
                        if (temp == Dictionary.ERROR_CODE_4 || temp == Dictionary.ERROR_CODE_1) {
                            _request.setAttribute("Debug", " User is prohibited, or the Username/Password is not correct!");
                            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
                        } else if (temp == Dictionary.STATUS_CODE_DOCTOR || temp == Dictionary.STATUS_CODE_USER) {
                            _response.sendRedirect("index.jsp");
                        } else {
                            HttpSession session = _request.getSession();
                            session.setAttribute("UserSet", accProc.getUserSet(_request, _response));
                            _response.sendRedirect("Manager.jsp");
                        }

                        break;
                    //
                    case "SignUp":
                        String s = accProc.signUp(_request, _response);
                        
                        if(s.equals("Success")){
                            _response.sendRedirect("Success.jsp");
                        }else{
                            _request.setAttribute("Debug", s);
                            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
                        }
                        break;
                    //
                    case "Blacklist":
                        
                        if (accProc.banUser(_request, _response)) {
                            _response.sendRedirect("Manager.jsp");
                        }
                        break;
                    //
                    case "Activate":
                        
                        if (accProc.activateUser(_request, _response)) {
                            _response.sendRedirect("Manager.jsp");
                        }
                        break;
                    //
                    case "Remove":
                        
                        if (accProc.deleteUser(_request, _response)) {
                            _response.sendRedirect("Manager.jsp");
                        }

                        break;
                    //
                    case "LogInInfo":
                        HttpSession session = _request.getSession();
                        session.setAttribute("result", true);
                        session.setAttribute("C_User", accProc.getTarget(_request.getParameter("name")));
                        _response.sendRedirect("index.jsp");
                        break;
                    //
                    case "Match":
                        accProc.match(_request, _response);
                }
            }
            accProc.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AccController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AccController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
