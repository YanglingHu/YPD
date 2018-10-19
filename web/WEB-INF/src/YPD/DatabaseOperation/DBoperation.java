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

/**
 *
 * @author Administrator
 */
public class DBoperation {

    //
    public MySQLstmt stmt;

    /**
     *
     * @param stmt
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public DBoperation(MySQLstmt stmt) throws SQLException, ClassNotFoundException {
        this.stmt = new MySQLstmt();
    }

    /**
     *
     * @param _obj
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean newObjToDB(Object _obj) throws IllegalArgumentException, IllegalAccessException {
        stmt.load(objToMap(_obj));
        return stmt.insertNew(Dictionary.TABLE_1);
    }

    /**
     *
     * @param _obj
     * @param _uuid
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean updataObj(Object _obj, String _uuid) throws IllegalArgumentException, IllegalAccessException {
        stmt.load(objToMap(_obj));
        return stmt.updateObject(_uuid, Dictionary.TABLE_1);
    }

    /**
     *
     * @param _obj
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean updataObj(Object _obj) throws IllegalArgumentException, IllegalAccessException{
        stmt.load(objToMap(_obj));
        return stmt.updateObject(Dictionary.TABLE_1);
    }

    /**
     *
     * @param _uuid
     * @return
     */
    public boolean deleteObj(String _uuid) {
        return stmt.deleteUserFromDB(_uuid);
    }

    /**
     *
     * @param _dummyObject
     * @param _uuid
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public CachedRowSet getTargetObj(Object _dummyObject, String _uuid) throws IllegalArgumentException, IllegalAccessException {
        CachedRowSet crs;
        stmt.load(objToMap(_dummyObject));
        crs = stmt.getTargetData(_uuid, Dictionary.TABLE_1);
        return crs;
    }

    /**
     *
     * @param _dummyObject
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public CachedRowSet getAll(Object _dummyObject) throws IllegalArgumentException, IllegalAccessException {
        stmt.load(objToMap(_dummyObject));
        CachedRowSet set = stmt.getUserDataSet(Dictionary.TABLE_1);
        return set;
    }

    /**
     *
     * @throws SQLException
     */
    public void close() throws SQLException {
        stmt.release();
    }

    /**
     *
     * @param _obj
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
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
