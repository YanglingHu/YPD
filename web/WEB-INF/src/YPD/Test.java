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
import java.util.*;


/**
 *
 * @author Administrator
 */
public class Test {    

    public static void main(String[] arg) throws IllegalArgumentException, IllegalAccessException{
        DBoperation db = new DBoperation();
        User user = new User(AccProc.getUID(),"name","pass",0,"Yi");
        Map<String,String> map = db.objToMap(user);
        System.out.print(map.keySet());
    }
}
