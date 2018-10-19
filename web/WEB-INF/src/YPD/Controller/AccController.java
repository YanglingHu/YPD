package YPD.Controller;

import YPD.Model.acc.AccProc;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yi Qiu
 */
@WebServlet(name = "AccController", urlPatterns = {"/LogOut"})
public class AccController extends HttpServlet {

    /**
     * This is a empty method that do not do anything.
     *
     * @param _request Http request.
     * @param _response Http response.
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {

    }

    /**
     * Function for users to logoff their account.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {

        String cases = _request.getParameter("method");
        AccProc accProc = new AccProc();
        if (cases == null || cases.trim().isEmpty()) {
            throw new IOException("Empty method parameter.");
        } else {
            switch (cases) {

                case "Update":
                    accProc.updateInfo(_request, _response);

                case "Logoff":
                    accProc.logOut(_request, _response);

                case "SignIn":
                    accProc.signIn(_request, _response);

                case "SignUp":
                    accProc.signUp(_request, _response);

                case "Blacklist":
                    accProc.banUser(_request, _response);

                case "deBacklist":
                    accProc.activateUser(_request, _response);

                case "Remove":
                    accProc.deleteUser(_request, _response);

            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Logoff";
    }

}
