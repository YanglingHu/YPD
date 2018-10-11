package Controller.acc;

import Model.acc.Proc;
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
        
        String method=_request.getParameter("method");
        switch(method){
            
            case "Update": Proc.updateInfo(_request, _response);
            
            case "Logoff": Proc.logOut(_request, _response);
            
            case "SignIn": Proc.signIn(_request, _response);
            
            case "SignUp": Proc.signUp(_request, _response);
            
            case "Blacklist": Proc.banUser(_request, _response);
            
            case "deBacklist": Proc.activateUser(_request, _response);
            
            case "Remove": Proc.deleteUser(_request, _response);
            
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
