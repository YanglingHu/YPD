package YPD.Model.MsgExchg;

/**
 * This is a messege-exchange model that contains the necessary method for the
 * messege-exchange process: -deleteMsg -sentMsg -getMsg
 *
 * @date lastUpdate: 2018/10/16
 * @author Yi Qi
 */
import Class.*;
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

public class MsgProc {

    private DBoperation opr;

    public MsgProc() throws SQLException, ClassNotFoundException {
        this.opr = new DBoperation();
    }

    public boolean deleteMsg(HttpServletRequest _request, HttpServletResponse _response) {
        Msg msg = (Msg) _request.getAttribute("Msg");
        return opr.deleteObj(Integer.toString(msg.getId()), Dictionary.TABLE_2);
    }

    public boolean sentMsg(HttpServletRequest _request, HttpServletResponse _response) {
        try {
            Msg msg = (Msg) _request.getAttribute("Msg");
            return opr.newObjToDB(msg, Dictionary.TABLE_2);
        } catch (IllegalArgumentException ex) {
            return false;
        } catch (IllegalAccessException ex) {
            return false;
        }
    }

    public void getMsg(HttpServletRequest _request, HttpServletResponse _response) {
        try {
            Msg dummy = new Msg();
            opr.getAll(dummy, Dictionary.TABLE_2);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MsgProc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MsgProc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() throws SQLException {
        opr.close();
    }
}
