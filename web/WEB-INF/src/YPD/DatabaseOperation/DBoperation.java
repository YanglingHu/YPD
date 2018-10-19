package YPD.DatabaseOperation;

import Class.User;
import com.sun.rowset.CachedRowSetImpl;
import YPD.Dic.Dictionary;
import java.sql.*;
import java.util.*;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

public class DBoperation {

    
    public boolean newObjToDB(Object _obj) throws IllegalArgumentException, IllegalAccessException {
        MySQLstmt stmt;
        try {
            stmt = new MySQLstmt();
            stmt.insertNew(objToMap(_obj), Dictionary.TABLE_1);
            stmt.release();
            
            return true;
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    public boolean updataObj(Object _obj,String _uuid) throws IllegalArgumentException, IllegalAccessException{
        MySQLstmt stmt;
        try {
            stmt = new MySQLstmt();
            stmt.updateObject(objToMap(_obj), _uuid, Dictionary.TABLE_1);
            stmt.release();
            
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }
    
    public boolean deleteObj(String _uuid){
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
    
    public Object getTargetObj(String _uuid){
        MySQLstmt stmt;
        try {
            stmt = new MySQLstmt();
            Object obj = stmt.getTargetUser(_uuid);
            stmt.release();
            
            return obj;
        } catch (SQLException ex) {
            return null;
        }        
    }
    
    public CachedRowSet getAll(){
        MySQLstmt stmt;
        try {
            stmt = new MySQLstmt();
            CachedRowSet set = stmt.getUserDataSet(Dictionary.TABLE_1);
            stmt.release();           
            return set;
        } catch (SQLException ex) {
            return null;
        }        
        
    }

    public Map<String,String> objToMap(Object _obj) throws IllegalArgumentException, IllegalAccessException{
        Map<String,String> map= new HashMap<>();
        Field[] fields = _obj.getClass().getDeclaredFields();
        for(int i = 0; i < fields.length ; i++){
            if(Modifier.isPrivate(fields[i].getModifiers())){
                map.put(fields[i].getName(), fields[i].get(_obj).toString());
            }
        }
        return map;
    }
}
