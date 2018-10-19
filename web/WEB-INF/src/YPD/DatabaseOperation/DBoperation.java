package YPD.DatabaseOperation;

import Class.User;
import com.sun.rowset.CachedRowSetImpl;
import YPD.Dic.Dictionary;
import java.sql.*;
import java.util.*;
import java.lang.Object;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

public class DBoperation {

    public boolean newObjToDB(Object _obj) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        MySQLstmt stmt;
        try {
            stmt = new MySQLstmt();
            stmt.load(objToMap(_obj));
            stmt.insertNew(Dictionary.TABLE_1);
            stmt.release();

            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    public boolean updataObj(Object _obj, String _uuid) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        MySQLstmt stmt;
        try {
            stmt = new MySQLstmt();
            stmt.load(objToMap(_obj));
            stmt.updateObject(_uuid, Dictionary.TABLE_1);
            stmt.release();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }    
        
    public boolean updataObj(Object _obj) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException {
        MySQLstmt stmt;
        try {
            stmt = new MySQLstmt();
            stmt.load(objToMap(_obj));
            stmt.updateObject(Dictionary.TABLE_1);
            stmt.release();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean deleteObj(String _uuid) throws ClassNotFoundException {
        MySQLstmt stmt;
        try {
            stmt = new MySQLstmt();
            stmt.deleteUserFromDB(_uuid);
            stmt.release();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    public CachedRowSet getTargetObj(Object _dummyObject, String _uuid) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        MySQLstmt stmt;
        CachedRowSet crs;
        try {
            stmt = new MySQLstmt();
            stmt.load(objToMap(_dummyObject));
            crs = stmt.getTargetData(_uuid, Dictionary.TABLE_1);
            stmt.release();

            return crs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public CachedRowSet getAll(Object _dummyObject) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        MySQLstmt stmt;
        try {
            stmt = new MySQLstmt();
            stmt.load(objToMap(_dummyObject));
            CachedRowSet set = stmt.getUserDataSet(Dictionary.TABLE_1);
            stmt.release();
            return set;
        } catch (SQLException ex) {
            return null;
        }

    }

    public Map<String, String> objToMap(Object _obj) throws IllegalArgumentException, IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        Class obj = _obj.getClass();
        Field[] fields = obj.getDeclaredFields();
        Field.setAccessible(fields, true);
        for (int i = 0; i < fields.length; i++) {
            if (Modifier.isPrivate(fields[i].getModifiers())) {
                map.put(fields[i].getName(), fields[i].get(_obj).toString());
            }
        }
        Field.setAccessible(fields, false);
        return map;
    }
}
