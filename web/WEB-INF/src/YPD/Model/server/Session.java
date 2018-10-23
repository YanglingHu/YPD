package YPD.Model.server;

/**
 *
 * @author Administrator
 */
import Class.User;
import YPD.DatabaseOperation.DBoperation;
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

/**
 *
 * @author Yi Qiu
 */
public class Session {
    
    /**
     * Updata the object of a specific Attribute of the HttpSession.
     * 
     * @param _request servlet request.
     * @param _response servlet response.
     * @param _atr Name of the attribute
     * @param _obj Object to updata.
     * @throws ServletException
     * @throws IOException
     */
    public static void refreshAtr(HttpServletRequest _request, HttpServletResponse _response, String _atr, Object _obj)
            throws ServletException, IOException {
        HttpSession session = _request.getSession();
        session.removeAttribute(_atr);
        session.setAttribute(_atr, _obj);
    }
}
