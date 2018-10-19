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
    public MySQLstmt() throws SQLException{
        this.setConnection();
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
        String tail = "VALUES (";
        for(int i = 0; i < this.NAME.length; i++){
            head +=  " `" + this.NAME[i] + "`, ";
            tail += " '" + this.VALUE[i] + "', ";            
        }
        head = head.substring(0, head.length() - 2) + ")";
        tail = tail.substring(0, tail.length() - 2) + ")";
        return this.update(head + tail);
    }

    /**
     *
     * @param _uuid
     * @return
     */
    @Override
    public Boolean deleteUserFromDB(String _uuid) {
        String sql = "delete from user where UUID=" + _uuid;
        return this.update(sql);
    }
    
    /**
     *
     * @return
     */
    @Override
    public Boolean deleteUserFromDB() {
        String sql = "delete from user where UUID=" + this.map.get("uuid");
        return this.update(sql);
    }

    /**
     *
     * @param _uuid
     * @return
     */
    @Override
    public Object getTargetData(String _uuid) {
        String head = "SELECT ";
        for(int i = 0; i < this.NAME.length; i++){
            head +=  this.NAME[i] + ", ";        
        }
        head = head.substring(0, head.length() - 2);
        String tail = " FROM user where UUID=" + _uuid;
        return this.read(head + tail);
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
        String tail = "FROM " + _destination;
        CachedRowSet crs;
        try {
            crs = new CachedRowSetImpl();
            ResultSet rs = (ResultSet)this.read(head + tail);
            crs.populate(rs);
            return crs;
        } catch (SQLException ex) {
            return null;
        }
        
    }
    
    /**
     * 
     * @throws SQLException 
     */
    private void setConnection() throws SQLException{
        this.CON = DriverManager.getConnection(Dictionary.URL, Dictionary.USER, Dictionary.PASS);
        this.STMT = this.CON.createStatement();
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
            this.STMT.executeUpdate(_sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }        
    }
    
    /**
     * 
     * 
     * @param _sql
     * @return 
     */
    private Object read(String _sql){
        try {           
            return this.STMT.executeQuery(_sql);
        } catch (SQLException ex) {
            return null;
        }        
    }

    /**
     *
     * @param _uuid
     * @param _table
     * @return
     */
    @Override
    public Boolean updateObject(String _uuid, String _table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param _destination
     * @return
     */
    @Override
    public Boolean updateObject(String _destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}