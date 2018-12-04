package YPD.Controller;
import YPD.Model.acc.Update;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @Update 2018/12/3
 * @author Yi Qiu
 */
@WebServlet(name = "UpdateController", urlPatterns = {"/UpdateController"})
public class UpdateController extends HttpServlet {


    /**
     * if the HttpRequest is GET, do nothing.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {

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
        String method;
        if (ServletFileUpload.isMultipartContent(_request)) {
            Update.updateImg(_request, _response);
        }
        method = _request.getParameter("method");
        if(method != null){
            switch(method){
                case "updateInfo":
                    Update.updateInfo(_request, _response);
                    break;
                case "updateTag": 
                    Update.updateTag(_request, _response);
                    break;
            }
        }
    }

}
