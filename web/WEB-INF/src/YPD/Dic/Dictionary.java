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
    //File operation
    public static final int MEMORY_THRESHOLD = 1024*1024*2;
    public static final int MAX_ALLOWED = 1024*1024*3;
    //Specialist
    public static final int SPEC_BRAIN = 1;
    public static final int SPEC_ENT = 2;
    public static final int SPEC_INTER_MEDIC = 3;
    public static final int SPEC_SURGERY = 4;
    public static final int SPEC_PEDIA = 5;
    public static final int SPEC_INF_DISEASES = 6;
    public static final int SPEC_OG = 7;
    public static final int SPEC_PSYCHOSIS = 8;
    public static final int SPEC_DNSTD = 9;
    public static final int SPEC_ONCOLOGY = 10;
    public static final int SPEC_ORTHOPEDICS = 11;
    public static final int SPEC_ANDROLOGY = 12;
}
