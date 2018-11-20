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
 * @Update 2018/11/20
 * @author Yi Qiu
 */
public class DBoperation {

    //
    private MySQLstmt stmt;

    /**
     * Initializes the DBoperation class, generates a MySQLstmt.
     * 
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public DBoperation() throws SQLException, ClassNotFoundException {
        this.stmt = new MySQLstmt();
    }

    /**
     * Store a new object into mySQL database.
     * 
     * @param _obj Any type of objects that is going to update.
     * @param _destination The table name in MySQL database.
     * @return success or not.
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean newObjToDB(Object _obj, String _destination) throws IllegalArgumentException, IllegalAccessException {
        stmt.load(objToMap(_obj));
        return stmt.insertNew(_destination);
    }

    /**
     * Update a object that is already exist in database.
     * 
     * @param _obj Any type of objects that is going to update.
     * @param _uuid An uuid defines where to update.
     * @param _destination The table name in MySQL database.
     * @return success or not.
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean updataObj(Object _obj, String _uuid, String _destination) throws IllegalArgumentException, IllegalAccessException {
        stmt.load(objToMap(_obj));
        return stmt.updateObject(_uuid, _destination);
    }

    /**
     * Update a object that is already exist in database.
     * 
     * @param _obj Any type of objects that is going to update.
     * @param _destination The table name in MySQL database.
     * @return success or not.
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public boolean updataObj(Object _obj, String _destination) throws IllegalArgumentException, IllegalAccessException{
        stmt.load(objToMap(_obj));
        return stmt.updateObject(_destination);
    }

    /**
     * Remove a object from the database
     * 
     * @param _uuid uuid of the target object
     * @param _destination The table name in MySQL database.
     * @return success or not.
     */
    public boolean deleteObj(String _uuid, String _destination) {
        return stmt.deleteUserFromDB(_uuid, _destination);
    }

    /**
     * Get a target object from the database.
     * 
     * @param _dummyObject A dummy object for MySQLstmt to analyze.
     * @param _uuid uuid of the target object
     * @param _destination The table name in MySQL database.
     * @return a CachedRowSet that is containing the target.
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
     * Get all objects from database.
     * 
     * @param _dummyObject A dummy object for MySQLstmt to analyze.
     * @param _destination The table name in MySQL database.
     * @return a CachedRowSet that is containing all objects that are from the database.
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public CachedRowSet getAll(Object _dummyObject, String _destination) throws IllegalArgumentException, IllegalAccessException {
        stmt.load(objToMap(_dummyObject));
        CachedRowSet set = stmt.getUserDataSet(_destination);
        return set;
    }

    /**
     * Close the MySQLstmt to release memory.
     * 
     * @throws SQLException
     */
    public void close() throws SQLException {
        stmt.release();
    }

    /**
     * Convert a object to a map data that has all fields of this object.
     * 
     * @param _obj Any type of objects.
     * @return A map file that is representing this object.
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
    
    /**
     * Convert all info that is stored in CachedRowSet into a ArrayList of Objects.
     * 
     * @param _crs CachedRowSet
     * @param _dummyObj A dummy object for this method to analyze
     * @return An ArrayList of Objects
     * @throws SQLException
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
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
