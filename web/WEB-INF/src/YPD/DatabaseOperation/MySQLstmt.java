package YPD.DatabaseOperation;
/**
 * 
 * 
 * @Update
 * @author Yi Qiu
 */

import Class.User;
import YPD.Dic.Dictionary;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;
import java.util.Map;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Yi Qiu
 */
public class MySQLstmt implements DatabaseInterface{

    //local connection(Not using).
    private Connection CON = null;
    private Statement STMT = null;
    //Array stores the key and its value.
    private String[] NAME;
    private String[] VALUE;
    //Map object.
    private Map<String,String> map;
    
    /**
     * Calls the setConnection() method to open a new SQL connection.
     * 
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public MySQLstmt() throws SQLException, ClassNotFoundException{
        this.setConnection();
    }
    
    /**
     * 
     * @param _map A map that is presenting a object.
     */
    public void load(Map<String, String> _map){
        this.NAME =  new String[_map.size()];
        this.VALUE =  new String[_map.size()];
        this.map = _map;
        Object[] temp = _map.keySet().toArray();
        for(int i = 0; i < _map.size(); i++){
            NAME[i] = (String)temp[i];
            VALUE[i] = _map.get(NAME[i]);
        }   
    }

    /**
     * Add a new object to the database.
     * 
     * @param _destination The table name in MySQL database.
     * @return success or not.
     */
    @Override
    public Boolean insertNew(String _destination) {
        String head = "INSERT INTO " + _destination + "(";
        String tail = "VALUES(";
        for(int i = 0; i < this.NAME.length; i++){
            head +=  " `" + this.NAME[i] + "`, ";
            tail += " '" + this.VALUE[i] + "', ";            
        }
        head = head.substring(0, head.length() - 2) + ")";
        tail = tail.substring(0, tail.length() - 2) + ")";
        String sql = head + tail;
        return update(head + tail);
    }

    /**
     * Generate a SQL statement and remove target from database(base on the given uuid).
     * 
     * @param _uuid uuid of the target object
     * @param _destination The table name in MySQL database.
     * @return success or not.
     */
    @Override
    public Boolean deleteUserFromDB(String _uuid, String _destination) {
        String sql = "delete from " + _destination + " where uuid='" + _uuid + "'";
        return update(sql);
    }
    
    /**
     * Generate a SQL statement and remove target from database.
     * 
     * @param _destination The table name in MySQL database.
     * @return success or not.
     */
    @Override
    public Boolean deleteUserFromDB(String _destination) {
        String sql = "delete from " + _destination + " where uuid='" + this.map.get("uuid") + "'";
        return update(sql);
    }

    /**
     * Return a target object from database in form of a CachedRowSet(base on the given uuid).
     * 
     * @param _uuid uuid of the target object
     * @param _destination The table name in MySQL database.
     * @return A CachedRowSet contains the info of the object.
     */
    @Override
    public CachedRowSet getTargetData(String _uuid, String _destination) {
        try {
            String head = "SELECT ";
            for(int i = 0; i < this.NAME.length; i++){        
                head +=  this.NAME[i] + ", ";
            }
            head = head.substring(0, head.length() - 2);
            String tail = " FROM " + _destination + " WHERE uuid='" + _uuid + "'";
            CachedRowSet crs = new CachedRowSetImpl();
            crs.populate(read(head + tail));
            return crs;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Return a target object from database in form of a CachedRowSet.
     * 
     * @param _destination The table name in MySQL database.
     * @return A CachedRowSet contains the info of the object.
     */ 
    @Override
    public CachedRowSet getUserDataSet(String _destination) {
        String head = "SELECT ";
        for(int i = 0; i < this.NAME.length; i++){
            head +=  this.NAME[i] + ", ";        
        }
        head = head.substring(0, head.length() - 2);    
        String tail = " FROM " + _destination;        
        CachedRowSet crs;
        try {
            crs = new CachedRowSetImpl();
            ResultSet rs = read(head + tail);
            crs.populate(rs);
            return crs;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
        
    }
    
    /**
     * Open a new SQL connection and a SQL statement.
     * 
     * @throws SQLException 
     */
    private void setConnection() throws SQLException, ClassNotFoundException{
        Class.forName(Dictionary.DRIVER_TYPE);
        this.CON = DriverManager.getConnection(Dictionary.URL, Dictionary.USER, Dictionary.PASS);
        this.STMT = CON.createStatement();
    }            
    
    /**
     * Close the SQL connection and SQL statement to release the memory.
     * 
     * @throws SQLException
     */
    protected void release() throws SQLException{
        if(this.CON != null){
            this.CON.close();
            this.STMT.close();
        }
    }
    
    /**
     * Excute the update statement.
     * 
     * @param _sql A string that has SQL statement to be excuted
     * @return success or not
     */
    private boolean update(String _sql){
        try {
            STMT.executeUpdate(_sql);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }       
    }
    
    /**
     * Excute the query statement.
     * 
     * @param _sql A string that has SQL statement to be excuted
     * @return success or not
     */
    private ResultSet read(String _sql){
        try {           
            return STMT.executeQuery(_sql);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }        
    }

    /**
     * Update a object to database.
     * 
     * @param _uuid uuid of the target object
     * @param _destination The table name in MySQL database.
     * @return success or not.
     */
    @Override
    public Boolean updateObject(String _uuid, String _destination) {
        String sql = "UPDATE " + _destination + " SET ";
        for(int i = 0; i < this.NAME.length; i++){
            sql +=  this.NAME[i] + "='" + this.VALUE[i] + "', ";        
        }
        sql = sql.substring(0, sql.length() - 2); 
        sql += " WHERE uuid='" + _uuid + "'";
        return update(sql);
    }

    /**
     * Update a object to database.
     * 
     * @param _destination The table name in MySQL database.
     * @return success or not.
     */
    @Override
    public Boolean updateObject(String _destination) {
        String sql = "UPDATE " + _destination + " SET ";
        for(int i = 0; i < this.NAME.length; i++){
            sql +=  this.NAME[i] + "='" + this.VALUE[i] + "', ";        
        }
        sql = sql.substring(0, sql.length() - 2); 
        sql += " WHERE uuid='" + this.map.get("uuid") + "'";
        return update(sql);
    }

}