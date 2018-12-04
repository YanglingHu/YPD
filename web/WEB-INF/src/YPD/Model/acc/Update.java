package YPD.Model.acc;
import Class.User;
import YPD.DatabaseOperation.DBoperation;
import YPD.Dic.Dictionary;
import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
/**
 * Process all new updates into SQL database.
 * 
 * @Update 2018/12/4
 * @author Yi Qiu
 */
public class Update {
    
    /**
     * Stores the picture file into local disk.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @return where did the picture file is stored.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public static String saveFile(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        
        try {
            if (!ServletFileUpload.isMultipartContent(_request)) {
                return null;
            }
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            String uploadPath = _request.getServletContext().getRealPath("/") + "Avatar";
            File uploadDir = new File(uploadPath);
            User temp = (User) _request.getSession().getAttribute("C_User");
            
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            List<FileItem> FileItems = upload.parseRequest(_request);
            
            if (FileItems != null && FileItems.size() > 0) {
                for (FileItem item : FileItems) {
                    
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        fileName = fileName.substring(fileName.lastIndexOf("."));
                        String filePath = uploadPath + File.separator + temp.getUuid() + "_Avatar" + fileName;
                        File storeFile = new File(filePath);
                        // Store the file into the local disk.
                        item.write(storeFile);
                        
                        return filePath;
                    }
                }
            }
            
            return null;
        } catch (FileUploadException ex) {
            System.out.println(ex);
            return null;
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }


    /**
     * Geneter a string of tags.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @return the string of tags.
     * @throws ServletException if a servlet-specific error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public static String tagBuilder(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        String tags = "";
        String[] temp = _request.getParameterValues("chk[]");
        if (temp != null) {
            for (String s : temp) {
                tags += s + ",";
            }
        }
        
        return tags;
    }


    /**
     * Update the avatar of user/doctor into SQL database. 
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
            User user = (User) session.getAttribute("C_User");
            String Img = saveFile(_request, _response);
            if (Img != null) {
                //Very Important! Might cause BUG when running on an online host!
                Img = Img.replace("\\", "/");
                user.setImg(Img);
            }
            // Decide what to do next based on the returned boolean value.
            if (opr.updataObj(user, Dictionary.TABLE_1)) {
                session.setAttribute("C_User", user);
                _response.sendRedirect("Success.jsp");
            } else {
            _request.setAttribute("Debug", " Can not update your avatar, something went wrong!");
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
            }
        } catch (IllegalArgumentException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        } catch (IllegalAccessException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        } catch (SQLException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        } catch (ClassNotFoundException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        }
    }


    /**
     * Update the new user/doctor-info into SQL database.
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
            User user = (User) session.getAttribute("C_User");
            String temp = "";
            if (!_request.getParameter("Gender").equals("")) {
                temp = _request.getParameter("Gender");
                user.setGender(Integer.parseInt(temp));
            }
            if (!_request.getParameter("Email").equals("")) {
                temp = _request.getParameter("Email");
                user.setEmail(temp);
            }
            if (!_request.getParameter("Age").equals("")) {
                temp = _request.getParameter("Age");
                user.setAge(Integer.parseInt(temp));
            }
            if (!_request.getParameter("PhoneNumber").equals("")) {
                temp = _request.getParameter("PhoneNumber");
                user.setContact(Integer.parseInt(temp));
            }

            if (!_request.getParameter("Name").equals("")) {
                temp = _request.getParameter("Name");
                user.setName(temp);
            }

            // Decide what to do next based on the returned boolean value.
            if (opr.updataObj(user, Dictionary.TABLE_1)) {
                session.setAttribute("C_User", user);
                _response.sendRedirect("Success.jsp");
            } else {
                _request.setAttribute("Debug", " Can not update your profile, something went wrong!");
                _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
            }
        } catch (IllegalArgumentException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        } catch (IllegalAccessException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        } catch (SQLException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        } catch (ClassNotFoundException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        }
    }


    /**
     * Update the Tags for user/doctor into SQL database.
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
            User user = (User) session.getAttribute("C_User");
            user.setMID(tagBuilder(_request, _response));

            // Decide what to do next based on the returned boolean value.
            if (opr.updataObj(user, Dictionary.TABLE_1)) {
                session.setAttribute("C_User", user);
                _response.sendRedirect("Success.jsp");
            } else {
                _request.setAttribute("Debug", " Can not update your tags, something went wrong!");
                _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
            }
        } catch (IllegalArgumentException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        } catch (IllegalAccessException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        } catch (SQLException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        } catch (ClassNotFoundException ex) {
            _request.setAttribute("Debug", ex.toString());
            _request.getRequestDispatcher("Failed.jsp").forward(_request, _response);
        }
    }
}
