package YPD;
import Class.User;
import YPD.DatabaseOperation.DBoperation;
import YPD.Dic.Dictionary;
import YPD.Model.acc.AccProc;
import YPD.Model.acc.Verification;
import java.sql.*;
import java.util.*;
import javax.sql.rowset.CachedRowSet;
import org.json.JSONException;
/**
 * A class that is used for testing
 * 
 * @author Yi Qiu
 */
public class Test {    
    
    /**
     *
     * @param arg
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws InstantiationException
     * @throws JSONException
     */
    public static void main(String[] arg) throws SQLException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InstantiationException, JSONException {   
//        Verification.checkForDoctor("John","1912968298");
//        Verification.checkForDoctor("Jason","1912968298");
//        Verification.checkForDoctor("Jason","1234567890");
//        testCase1();
//        testCase3();

    }
    
    /**
     *
     * @param _set
     * @throws SQLException
     */
    public static void printResult(CachedRowSet _set) throws SQLException{
        String s = "";
        while(_set.next()){
            s = "uuid: " + _set.getString("UUID") + " username: " + _set.getString("username") + " password: " + _set.getString("password") 
                    + " Age: " + _set.getInt("age") + " name: " + _set.getString("name");
            System.out.println(s);
        }        
    }
    
    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public static void testCase1() throws SQLException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException{
        User user = null;
        DBoperation db = new DBoperation();
        for(int i = 0; i < 5 ; i++){
        user = new User(AccProc.getUID(),"Test-" + i,"pass",1,"Test-" + i);
        db.newObjToDB(user,Dictionary.TABLE_1);            
        }
        CachedRowSet set = db.getAll(user,Dictionary.TABLE_1);
        printResult(set);
        db.close();        
    }
    
    /**
     *
     * @throws NoSuchFieldException
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void testCase2() throws NoSuchFieldException, ClassNotFoundException, SQLException,
            IllegalArgumentException, IllegalAccessException, InstantiationException{
        User user = new User();
        DBoperation db = new DBoperation();
        CachedRowSet set = db.getAll(user,Dictionary.TABLE_1);
        ArrayList arr = db.restoreToObj(set, user);
        User[] userlist = new User[arr.size()];
        for(int i = 0 ;i < arr.size();i++){
            userlist[i] = (User)arr.get(i);
        }
        
        for(User u : userlist){
            System.out.println(u.toString());
        }
        db.close();
    }
    
    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void testCase3() throws SQLException, ClassNotFoundException{
        DBoperation db = new DBoperation();
        db.deleteObj("1da8e77a-7af5-4c23-83b0-69a3eb3dc724", Dictionary.TABLE_1);
        
    }
    
}
