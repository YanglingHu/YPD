package YPD.DatabaseOperation;

import Class.User;
import YPD.Dic.Dictionary;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;
import java.util.Map;
import javax.sql.rowset.CachedRowSet;

public class MySQLstmt implements DatabaseInterface{

    //local connection(Not using).
    private Connection CON = null;
    private Statement STMT = null;
    
    public MySQLstmt() throws SQLException{
        this.setConnection();
    }

    @Override
    public int insertNew(Map<String, String> _map, String _destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deleteUserFromDB(String _uuid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getTargetUser(String _uuid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CachedRowSet getUserDataSet(String _destination) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void setConnection() throws SQLException{
        this.CON = DriverManager.getConnection(Dictionary.URL, Dictionary.USER, Dictionary.PASS);
        this.STMT = this.CON.createStatement();
    }            
    
    protected void release() throws SQLException{
        if(this.CON != null){
            this.CON.close();
            this.STMT.close();
        }
    }
                
//    /**
//     * Remove a user from database, using the uuid to target the user data.
//     *
//     * @param _user A user object that will be deleted.
//     * @return boolean value that tells either success or fail.
//     */
//    public static boolean deleteUserFromDB(User _user) {
//        
//        Statement stmt = null; //A SQL statement will be created.
//        ResultSet rs = null; //Result returned from the SQL database.
//        Connection conn; //A database connection object.
//        String sql = "delete from user where UUID=" + _user.getUuid();
//        try {
//            Class.forName(Dictionary.DRIVER_TYPE);
//            // Open a new connection.
//            conn = DriverManager.getConnection(URL, USER, PASS);
//            // Creating a new statement.
//            stmt = conn.createStatement();
//            // Delete a target user in database..
//            stmt.executeUpdate(sql);
//            conn.close();
//            stmt.close();
//            return true;
//        } catch (SQLException se) {
//            System.out.println("Operation failed:");
//            return false;
////            se.printStackTrace();
//        } catch (ClassNotFoundException cnfe) {
//            // Deal with Class.forName error.
//            System.out.println("Can't find a driver class, loading failed.");
//            return false;
////            cnfe.printStackTrace();
//        }
//        
//    }
//    /**
//     *
//     * @param _UUID
//     * @return
//     * @throws SQLException
//     */
//    public static User getTargetUser(String _UUID) throws SQLException {
//        Statement stmt = null; //A SQL statement will be created.
//        ResultSet rs = null; //Result returned from the SQL database.
//        User user = new User(); //A temp User object.
//        Connection conn; //A database connection object.
//        String sql = "SELECT UUID, username, password, userType FROM user where UUID=" + _UUID; //A string that will be used to general SQL statement.
//        try {
//            Class.forName(DRIVER_TYPE);
//            // Open a new connection.
//            conn = DriverManager.getConnection(URL, USER, PASS);
//            // Creating a new statement.
//            stmt = conn.createStatement();
//            //returning result from database.
//            rs = stmt.executeQuery(sql);
//            //Release all sql relavant.
//            user = new User(rs.getString("UUID"), rs.getString("username"), rs.getString("password"), rs.getInt("userType"),
//                    rs.getString("name"), rs.getInt("age"), rs.getInt("contact"), rs.getString("email"), rs.getBoolean("gender"));
//            
//            rs.close();
//            conn.close();
//            stmt.close();
//        } catch (SQLException se) {
//            System.out.println("Connection error:");
////            se.printStackTrace();
//return null;
//        } catch (ClassNotFoundException cnfe) {
//            // Deal with Class.forName error.
//            System.out.println("Can't find a driver class, loading failed.");
////            cnfe.printStackTrace();
//return null;
//        }
//        System.out.println("getDataSet() method: Successed!");
//        
//        return user;
//    }
//
//    /**
//     * get a copy of user resultset from the database,in form of a CachedRowSet.
//     *
//     * @return a CachedRowSet contains all users in the database.
//     * @throws SQLException
//     */
//    public static CachedRowSet getUserDataSet() throws SQLException {
//        Statement stmt = null;
//        ResultSet rs = null;
//        CachedRowSet crs = new CachedRowSetImpl();
//        Connection conn;
//        String sql = "SELECT UUID, username, password, userType FROM user";
//        try {
//            Class.forName(DRIVER_TYPE);
//            // Open a new connection.
//            conn = DriverManager.getConnection(URL, USER, PASS);
//            // Creating a new statement.
//            stmt = conn.createStatement();
//            //returning result from database.
//            rs = stmt.executeQuery(sql);
//            crs.populate(rs);
//            //Release all sql relavant.
//            rs.close();
//            conn.close();
//            stmt.close();
//        } catch (SQLException se) {
//            System.out.println("Connection error:");
////            se.printStackTrace();
//            return null;
//        } catch (ClassNotFoundException cnfe) {
//            // Deal with Class.forName error.
//            System.out.println("Can't find a driver class, loading failed.");
////            cnfe.printStackTrace();
//            return null;
//        }
//        System.out.println("getDataSet() method: Successed!");
//        return crs;
//    }
//    
//    /**
//     * Add a new user to database.
//     *
//     * @param _user A user object that is ready to be added into database.
//     * @return boolean value that tells either success or fail.
//     */
//    public static boolean newUserToDB(User _user) {
//        PreparedStatement stmt = null;//A SQL prepared statement will be created.
//        ResultSet rs = null; //Result returned from the SQL database.
//        Connection conn; //A database connection object.
//        String sql = "insert into user (UUID,username,password,userType,name,age,contact,email,gender,banned) values (?,?,?,?,?,?,?,?,?,?)";
//        try {
//            Class.forName(DRIVER_TYPE);
//            // Open a new connection.
//            conn = DriverManager.getConnection(URL, USER, PASS);
//            // Creating a new prepared statement.
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, _user.getUuid());
//            stmt.setString(2, _user.getUsername());
//            stmt.setString(3, _user.getPassword());
//            stmt.setInt(4, _user.getUsertype());
//            stmt.setString(5, _user.getName());
//            stmt.setInt(6, _user.getAge());
//            stmt.setInt(7, _user.getContact());
//            stmt.setString(8, _user.getEmail());
//            stmt.setBoolean(9, _user.getGender());
//            stmt.setBoolean(10, _user.getBanned());
//            // Saving result to database.
//            stmt.executeUpdate();
//            conn.close();
//            stmt.close();
//            return true;
//        } catch (SQLException se) {
//            System.out.println("Operation failed:");
//            se.printStackTrace();
//            return false;
//        } catch (ClassNotFoundException cnfe) {
//            // Deal with Class.forName error.
//            System.out.println("Can't find a driver class, loading failed.");
////            cnfe.printStackTrace();
//            return false;
//        }
//
//    }
//
//    /**
//     * Update the info changed of a user.
//     *
//     * @param _user A user object that is ready to update.
//     * @return boolean value that tells either success or fail.
//     */
//    public static boolean updateUserInfo(User _user) {
//        PreparedStatement stmt = null;//A SQL prepared statement will be created.
//        ResultSet rs = null; //Result returned from the SQL database.
//        Connection conn; //A database connection object.
//        String sql = "update user set username=? ,password=?,userTpye=?,name=?,age=?,contact=?,email=?,gender=? where UUID=?";
//        try {
//            Class.forName(DRIVER_TYPE);
//            // Open a new connection.
//            conn = DriverManager.getConnection(URL, USER, PASS);
//            // Creating a new statement.
//            stmt = conn.prepareStatement(sql);
//            stmt.setString(1, _user.getUsername());
//            stmt.setString(2, _user.getPassword());
//            stmt.setInt(3, _user.getUsertype());
//            stmt.setString(4, _user.getName());
//            stmt.setInt(5, _user.getAge());
//            stmt.setInt(6, _user.getContact());
//            stmt.setString(7, _user.getEmail());
//            stmt.setBoolean(8, _user.getGender());
//            stmt.setString(9, _user.getUuid());
//            // Saving result to database.
//            stmt.executeUpdate();
//            conn.close();
//            stmt.close();
//            return true;
//        } catch (SQLException se) {
//            System.out.println("Operation failed:");
////            se.printStackTrace();
//            return false;
//        } catch (ClassNotFoundException cnfe) {
//            // Deal with Class.forName error.
//            System.out.println("Can't find a driver class, loading failed.");
////            cnfe.printStackTrace();
//            return false;
//        }
//
//    }

    @Override
    public Boolean updateObject(Map<String, String> _keyValuePairs, String _uuid, String _table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}