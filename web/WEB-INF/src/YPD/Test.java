/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YPD;

import Class.Msg;
import Class.User;
import YPD.DatabaseOperation.DBoperation;
import YPD.Dic.Dictionary;
import YPD.Model.acc.AccProc;
import static YPD.Model.acc.AccProc.getUID;
import java.lang.reflect.*;
import java.sql.*;
import java.util.*;
import javax.sql.rowset.CachedRowSet;


/**
 *
 * @author Yi Qiu
 */
public class Test {    
    
    public static void main(String[] arg) throws SQLException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InstantiationException {   
        
        testCase1();
//        testCase3();

    }
    
    
    public static void printResult(CachedRowSet _set) throws SQLException{
        String s = "";
        while(_set.next()){
            s = "uuid: " + _set.getString("UUID") + " username: " + _set.getString("username") + " password: " + _set.getString("password") 
                    + " Age: " + _set.getInt("age") + " name: " + _set.getString("name");
            System.out.println(s);
        }        
    }
    
    public static void testCase1() throws SQLException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException{
        User user = null;
        DBoperation db = new DBoperation();
        for(int i = 0; i < 10 ; i++){
        user = new User(AccProc.getUID(),"name","pass",0,"Test-" + i);
        db.newObjToDB(user,Dictionary.TABLE_1);            
        }
        CachedRowSet set = db.getAll(user,Dictionary.TABLE_1);
        printResult(set);
//        user.setAge(18);
//        db.updataObj(user,Dictionary.TABLE_1);
//        set = db.getAll(user,Dictionary.TABLE_1);
//        printResult(set); 
//        set = db.getTargetObj(user,user.getUuid(),Dictionary.TABLE_1);
//        printResult(set);         
//        db.deleteObj(user.getUuid(),Dictionary.TABLE_1);
//        set = db.getAll(user,Dictionary.TABLE_1);
//        printResult(set); 
        db.close();        
    }
    
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
    
    public static void testCase3() throws SQLException, ClassNotFoundException{
        DBoperation db = new DBoperation();
        db.deleteObj("1da8e77a-7af5-4c23-83b0-69a3eb3dc724", Dictionary.TABLE_1);
        
    }
    
    public static void testCase4() throws SQLException, ClassNotFoundException{
        AccProc acc = new AccProc();
    }
}
