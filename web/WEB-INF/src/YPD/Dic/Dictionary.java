package YPD.Dic;

/**
 *
 * @Update 2018/11/20
 * @author Yi Qiu
 */
public class Dictionary {
    // JDBC Tpye = MySQL
    public static final String DRIVER_TYPE = "com.mysql.cj.jdbc.Driver";
    // DataBase URL.
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/ypd?serverTimezone=EST";
    //Admin's Username & Password for database.
    public static final String USER = "root";
    public static final String PASS = "Himeasan";
    //Destination
    public static final String TABLE_1 = "User";
    public static final String TABLE_2 = "Msg";
    //Attribute Type
    public static final String INT = "int";
    public static final String STRING = "class java.lang.String";
    //Identification
    public static final int STATUS_CODE_DOCTOR = 0;
    public static final int STATUS_CODE_USER = 1;
    public static final int STATUS_CODE_MANAGER = 2;
    //User is on blacklist
    public static final int ERROR_CODE_3 = 3;
    //No such user in the database.
    public static final int ERROR_CODE_4 = 4;
    
}
