package AccOperation;
import Class.User;
import DatabaseOperation.DatabaseInterface.*;
import java.io.UnsupportedEncodingException;


import java.util.*;
import java.net.*;
import javax.servlet.http.*;

/**
 *
 * @author Administrator
 */
public class Acc {
    
    public static void main(String[] args){
//        getUID();

    }
    
    public static String getUID(){
        String uuid = UUID.randomUUID().toString();
//        System.out.println(uuid);
        return uuid;
    }
    
    public static boolean isExisted(User _user){
        
        return false;
    }
    
    public static Cookie[] generateCookies(String _name, String _url) throws UnsupportedEncodingException{
        
        Cookie name = new Cookie("name", URLEncoder.encode(_name,"utf-8"));
        Cookie url = new Cookie("name", URLEncoder.encode(_url,"utf-8"));
        name.setMaxAge(60*60*168); 
        url.setMaxAge(60*60*168); 
        Cookie[] cookie= {name,url};
        return cookie;        
    }
    
    public static Cookie[] killAllCookies(Cookie[] _cookie){
        for(int i = 0; i < _cookie.length ; i++){
            _cookie[i].setMaxAge(0);
        }
        return _cookie;
    }
    
}
