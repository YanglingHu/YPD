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
     *
     * @throws SQLException
     */
    public MySQLstmt() throws SQLException, ClassNotFoundException{
        this.setConnection();
    }

    public String[] getNAME() {
        return this.NAME;
    }
    
    /**
     *
     * @param _map
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
     *
     * @param _destination
     * @return
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
     *
     * @param _uuid
     * @return
     */
    @Override
    public Boolean deleteUserFromDB(String _uuid, String _destination) {
        String sql = "delete from " + _destination + " where uuid='" + _uuid + "'";
        return update(sql);
    }
    
    /**
     *
     * @return
     */
    @Override
    public Boolean deleteUserFromDB(String _destination) {
        String sql = "delete from " + _destination + " where uuid='" + this.map.get("uuid") + "'";
        return update(sql);
    }

    /**
     *
     * @param _uuid
     * @param _destination
     * @return
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
     *
     * @param _destination
     * @return
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
     * 
     * @throws SQLException 
     */
    private void setConnection() throws SQLException, ClassNotFoundException{
        Class.forName(Dictionary.DRIVER_TYPE);
        this.CON = DriverManager.getConnection(Dictionary.URL, Dictionary.USER, Dictionary.PASS);
        this.STMT = CON.createStatement();
    }            
    
    /**
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
     * 
     * 
     * @param _sql
     * @return 
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
     * 
     * 
     * @param _sql
     * @return 
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
     *
     * @param _uuid
     * @param _destination
     * @return
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
     *
     * @param _destination
     * @return
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