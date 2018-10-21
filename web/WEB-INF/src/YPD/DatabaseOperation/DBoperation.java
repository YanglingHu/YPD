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
    private MySQLstmt stmt;

    /**
     *
     * @param stmt
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public DBoperation() throws SQLException, ClassNotFoundException {
        this.stmt = new MySQLstmt();
    }

    /**
     *
     * @param _obj
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean newObjToDB(Object _obj, String _destination) throws IllegalArgumentException, IllegalAccessException {
        stmt.load(objToMap(_obj));
        return stmt.insertNew(_destination);
    }

    /**
     *
     * @param _obj
     * @param _uuid
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean updataObj(Object _obj, String _uuid, String _destination) throws IllegalArgumentException, IllegalAccessException {
        stmt.load(objToMap(_obj));
        return stmt.updateObject(_uuid, _destination);
    }

    /**
     *
     * @param _obj
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean updataObj(Object _obj, String _destination) throws IllegalArgumentException, IllegalAccessException{
        stmt.load(objToMap(_obj));
        return stmt.updateObject(_destination);
    }

    /**
     *
     * @param _uuid
     * @return
     */
    public boolean deleteObj(String _uuid, String _destination) {
        return stmt.deleteUserFromDB(_uuid, _destination);
    }

    /**
     *
     * @param _dummyObject
     * @param _uuid
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public CachedRowSet getTargetObj(Object _dummyObject, String _uuid, String _destination) throws IllegalArgumentException, IllegalAccessException {
        CachedRowSet crs;
        stmt.load(objToMap(_dummyObject));
        crs = stmt.getTargetData(_uuid, _destination);
        return crs;
    }

    /**
     *
     * @param _dummyObject
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public CachedRowSet getAll(Object _dummyObject, String _destination) throws IllegalArgumentException, IllegalAccessException {
        stmt.load(objToMap(_dummyObject));
        CachedRowSet set = stmt.getUserDataSet(_destination);
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
                if(fields[i].get(_obj)!= null){
                    map.put(fields[i].getName(), fields[i].get(_obj).toString());
                }else{
                    map.put(fields[i].getName(), "");
                }          
            }
        }
        Field.setAccessible(fields, false);
        return map;
    }
    
    public ArrayList restoreToObj(CachedRowSet _crs, Object _dummyObj) throws SQLException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException{
        ArrayList obj = new ArrayList<Object>();
//        String[] name = stmt.getNAME();
        String cases; 
        Class c = _dummyObj.getClass();
        Field[] f = c.getDeclaredFields();
        Field.setAccessible(f, true);
        while(_crs.next()){
            User temp = (User)c.newInstance();
            for(Field t : f){
                cases = t.getType().toString();
                //So far only support two datatype. But can add any case of datatype to it. 
                switch(cases){
                    case Dictionary.INT:
                        t.set(temp, _crs.getInt(t.getName()));
                        break;
                    case Dictionary.STRING:  
                        t.set(temp, _crs.getString(t.getName()));
                        break;
                }                
            }
            obj.add(temp);
        }
        Field.setAccessible(f, false);
        
        return obj;
    }
}
