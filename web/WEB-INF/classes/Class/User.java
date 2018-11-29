/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import YPD.Dic.Dictionary;
import java.util.UUID;

/**
 *
 * @Update 2018/11/20
 * @author Yi Qiu
 */
public class User {
    private String uuid;
    private String username = "";
    private String password = "";
    private int usertype;
    private String name;
    private int age;
    private int contact;
    private String email;
    private int gender;
    private int banned;
    private String img = "";
    private String MID = "";

    
    public User(){
        this.uuid = null;          
    }
    
    public User(String _uuid,String _username,String _password,int _usertype, String _name,int _age,int _contact,String _email,int _gender){
        this.uuid = _uuid;
        this.username = _username;
        this.password = _password;
        this.usertype = _usertype;
        this.name = _name;
        this.age = _age;
        this.contact = _contact;
        this.email = _email;
        this.gender = _gender;
        this.banned = 0;        
    }
    
    public User(String _uuid,String _username,String _password,int _usertype, String _name){
        this.uuid = _uuid;
        this.username = _username;
        this.password = _password;
        this.usertype = _usertype;
        this.name = _name;
        this.email = "";
        this.banned = 0;        
    }
    
    public String getUuid(){
        return uuid;
       
    }
    public void setUuid(String _uuid){
        this.uuid = _uuid;
    }
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String _username){
        this.username = username;
    }
     public String getPassword(){
        return password;
       
    }
    public void setPassword(String _password){
        this.password = _password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String _img) {
        this.img = _img;
    }
     public int getUsertype(){
        return usertype;   
    }
    
    public void setUsertype(int _usertype){
        this.usertype = _usertype;
    } 
    
    public String getTypeString(){
        if(this.usertype == Dictionary.STATUS_CODE_DOCTOR){
            return "Doctor";
        }else if(this.usertype == Dictionary.STATUS_CODE_USER){
            return "User";
        }else if(this.usertype == Dictionary.STATUS_CODE_MANAGER){
            return "Manager";
        }
        return "unknown";
    } 
    
    public String getName(){
        return name;
       
    }
    public void setName(String _name){
        this.name = _name;
    }
    
     public int getAge(){
        return age;
       
    }
    public void setAge(int _age){
        this.age = _age;
    }
    
     public int getContact(){
        return contact;
       
    }
    public void setContact(int _contact){
        this.contact = _contact;
    }
    
     public String getEmail(){
        return email;
       
    }
    public void setEmail(String _email){
        this.email = _email;
    }
    
     public int getGender(){
        return gender;
       
    }
     
    public String getGenderString(){
        if(this.gender == 0){
            return "male";
        }else if(this.gender == 1){
            return "female";
        }else{
            return "unknown";
        }
    } 
     
    public void setGender(int _gender){
        this.gender = _gender;
    }
    
    public String getMID() {
        return MID;
    }

    public void setMID(String _MID) {
        this.MID = _MID;
    }

    public int getBanned(){
        return this.banned;
    }
    
    public void setBanned(int _banned){
        this.banned = _banned;
    }

    @Override
    public String toString() {
        return "User{" + "uuid=" + uuid + ", username=" + username + ", password=" + password + ", usertype=" + usertype + ", name=" + name + ", age=" + age + ", contact=" + contact + ", email=" + email + ", gender=" + gender + ", banned=" + banned + '}';
    }
    
    
}
