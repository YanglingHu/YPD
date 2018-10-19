/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YPD;

import Class.User;
import YPD.DatabaseOperation.DBoperation;
import YPD.Model.acc.AccProc;
import static YPD.Model.acc.AccProc.getUID;
import java.sql.*;
import java.util.*;
import javax.sql.rowset.CachedRowSet;


/**
 *
 * @author Yi Qiu
 */
public class Test {    
    public static User user = new User(AccProc.getUID(),"name","pass",0,"Yi");
    
    public static void main(String[] arg) throws IllegalArgumentException, IllegalAccessException, SQLException, ClassNotFoundException{   
        DBoperation db = new DBoperation();
        db.newObjToDB(user);
        CachedRowSet set = db.getAll(user);
        printResult(set);
        user.setAge(18);
        db.updataObj(user);
        set = db.getAll(user);
        printResult(set); 
        set = db.getTargetObj(user,user.getUuid());
        printResult(set);         
        db.deleteObj(user.getUuid());
        set = db.getAll(user);
        printResult(set); 
        db.close();

    }
    
    
    public static void printResult(CachedRowSet _set) throws SQLException{
        String s = "";
        while(_set.next()){
            s = "uuid: " + _set.getString("UUID") + " username: " + _set.getString("username") + " password: " + _set.getString("password") 
                    + " Age: " + _set.getInt("age") + " name: " + _set.getString("name");
            System.out.println(s);
        }        
    }
}
