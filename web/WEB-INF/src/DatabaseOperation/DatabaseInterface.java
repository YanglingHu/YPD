package DatabaseOperation;




import Class.User;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.*;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Yi Qiu
 */
public class DatabaseInterface {

    // JDBC Tpye = MySQL
    private static final String DRIVER_TYPE = "com.mysql.cj.jdbc.Driver";
    // DataBase URL.
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/ypd?serverTimezone=EST";

    //Admin's Username & Password for database.
    private static final String USER = "root";
    private static final String PASS = "Himeasan";
    //local connection(Not using)
    private Connection con = null;
    private Statement stmt = null;

    /**
     *
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {

        
//        CachedRowSet crs = getUserDataSet();
//        deBug(crs);
        
    }

    /**
     *
     * @return @throws SQLException
     */
    public static CachedRowSet getUserDataSet() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSet crs = new CachedRowSetImpl();
        Connection conn;
        String sql = "SELECT UUID, username, password, userType FROM user";
        try {
            Class.forName(DRIVER_TYPE);
            // Open a new connection.
            conn = DriverManager.getConnection(URL, USER, PASS);
            // Creating a new statement.
            stmt = conn.createStatement();
            //returning result from database.
            rs = stmt.executeQuery(sql);
            crs.populate(rs);
            //Release all sql relavant.
            rs.close();
            conn.close();
            stmt.close();
        } catch (SQLException se) {
            System.out.println("Connection error:");
//            se.printStackTrace();
            return null;
        } catch (ClassNotFoundException cnfe) {
            // Deal with Class.forName error.
            System.out.println("Can't find a driver class, loading failed.");
//            cnfe.printStackTrace();
            return null;
        }
        System.out.println("getDataSet() method: Successed!");
        return crs;
    }

    /**
     *
     * @param _UUID
     * @return
     */
    public static boolean newUserToDB(User _user) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn;
        String sql = "insert into user (UUID,username,password,userType,name,age,contact,email,gender,banned) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            Class.forName(DRIVER_TYPE);
            // Open a new connection.
            conn = DriverManager.getConnection(URL, USER, PASS);
            // Creating a new prepared statement.
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, _user.getUuid());
            stmt.setString(2, _user.getUsername());
            stmt.setString(3, _user.getPassword());
            stmt.setInt(4, _user.getUsertype());
            stmt.setString(5, _user.getName());
            stmt.setInt(6, _user.getAge());
            stmt.setInt(7, _user.getContact());
            stmt.setString(8, _user.getEmail());
            stmt.setBoolean(9, _user.getGender());
            stmt.setBoolean(10, _user.getBanned());
            // Saving result to database.
            stmt.executeUpdate();
            conn.close();
            stmt.close();
            return true;
        } catch (SQLException se) {
            System.out.println("Operation failed:");
            se.printStackTrace();
            return false;
        } catch (ClassNotFoundException cnfe) {
            // Deal with Class.forName error.
            System.out.println("Can't find a driver class, loading failed.");
//            cnfe.printStackTrace();
            return false;
        }

    }

    /**
     *
     * @param _UUID
     * @return
     */
    public static boolean updateUserInfo(User _user) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection conn;
        String sql = "update user set username=? ,password=?,userTpye=?,name=?,age=?,contact=?,email=?,gender=? where UUID=?";
        try {
            Class.forName(DRIVER_TYPE);
            // Open a new connection.
            conn = DriverManager.getConnection(URL, USER, PASS);
            // Creating a new statement.
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, _user.getUsername());
            stmt.setString(2, _user.getPassword());
            stmt.setInt(3, _user.getUsertype());
            stmt.setString(4, _user.getName());
            stmt.setInt(5, _user.getAge());
            stmt.setInt(6, _user.getContact());
            stmt.setString(7, _user.getEmail());
            stmt.setBoolean(8, _user.getGender());
            stmt.setString(9, _user.getUuid());
            // Saving result to database.
            stmt.executeUpdate();
            conn.close();
            stmt.close();
            return true;
        } catch (SQLException se) {
            System.out.println("Operation failed:");
//            se.printStackTrace();
            return false;
        } catch (ClassNotFoundException cnfe) {
            // Deal with Class.forName error.
            System.out.println("Can't find a driver class, loading failed.");
//            cnfe.printStackTrace();
            return false;
        }
        
    }

    /**
     *
     * @param _UUID
     * @return
     */
    public static boolean deleteUserFromDB(User _user) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn;
        String sql = "delete from user where UUID=" + _user.getUuid();
        try {
            Class.forName(DRIVER_TYPE);
            // Open a new connection.
            conn = DriverManager.getConnection(URL, USER, PASS);
            // Creating a new statement.
            stmt = conn.createStatement();
            // Delete a target user in database..
            stmt.executeUpdate(sql);
            conn.close();
            stmt.close();
            return true;
        } catch (SQLException se) {
            System.out.println("Operation failed:");
            return false;
//            se.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            // Deal with Class.forName error.
            System.out.println("Can't find a driver class, loading failed.");
            return false;
//            cnfe.printStackTrace();
        }

    }

    /**
     *
     * @param _crs
     * @throws SQLException
     */
    public static void deBug(CachedRowSet _crs) throws SQLException {
        CachedRowSet crs = _crs;
        while (crs.next()) {
            // Return the key data.
            int uuid = crs.getInt("UUID");
            String username = crs.getString("username");
            String password = crs.getString("password");
            int ut = crs.getInt("userType");

            // Output the debug
            System.out.print("UUID: " + uuid);
            System.out.print(", username: " + username);
            System.out.print(", password: " + password);
            System.out.print(", usertype: " + ut);
            System.out.print("\n");
        }
        crs.close();
        System.out.print("End");
    }
    
    /**
     *
     * @param _UUID 
     * @return
     * @throws SQLException
     */
    public static User getTargetUser(String _UUID) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        User user = new User();
        Connection conn;
        String sql = "SELECT UUID, username, password, userType FROM user where UUID=" + _UUID;
        try {
            Class.forName(DRIVER_TYPE);
            // Open a new connection.
            conn = DriverManager.getConnection(URL, USER, PASS);
            // Creating a new statement.
            stmt = conn.createStatement();
            //returning result from database.
            rs = stmt.executeQuery(sql);
            //Release all sql relavant.
            user = new User(rs.getString("UUID"),rs.getString("username"),rs.getString("password"),rs.getInt("userType"),
                    rs.getString("name"),rs.getInt("age"),rs.getInt("contact"),rs.getString("email"),rs.getBoolean("gender"));
                    
            rs.close();
            conn.close();
            stmt.close();
        } catch (SQLException se) {
            System.out.println("Connection error:");
//            se.printStackTrace();
            return null;
        } catch (ClassNotFoundException cnfe) {
            // Deal with Class.forName error.
            System.out.println("Can't find a driver class, loading failed.");
//            cnfe.printStackTrace();
            return null;
        }
        System.out.println("getDataSet() method: Successed!");
           
        return user;
    }
}
