/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#username_signIn").change(removeError);
    $("#password_signIn").change(removeError);
    $("#button_signIn").click(login);
    $("#username_signUp").change(removeError);
    $("#password_signUp").change(removeError);
    $("#repassword_signUp").change(removeError);
    $("#button_signUp").click(signUp);
    $("#button_mail").click(checkmail);
    $("#button_signUpD").click(signUpD); 
    $("#username_signUpD").change(removeError);
    $("#password_signUpD").change(removeError);
    $("#repassword_signUpD").change(removeError);
    $("#firstname_signUpD").change(removeError);
    $("#license_signUpD").change(removeError);

    
    function checkmail(e){
        if(!/(\S)+[@]{1}(\S)+[.]{1}(\w)+/.test(e)){
            $("#Error_mail").html("The eamil is not exict!");
        }
    }
    
    function removeError(){
        $("#Error_signIn").html("");
         $("#Error_signUpD").html(""); 
         $("#Error_signUp").html("");
    }  
  
    
    function login(){
        var usernm = $("#username_signIn").val();
        var passwd = $("#password_signIn").val();
        if(usernm.length === 0 && passwd.length === 0){
            $("#Error_signIn").html("Username and Password can't be empty");
        }else if(usernm.length === 0){
            $("#Error_signIn").html("Username can't be empty; ");
        }else if(passwd.length === 0){
            $("#Error_signIn").html("Password can't be empty");
        }else{
            $("#form-Login").submit();
        }
    }
              function signUp(){
        var usernm = $("#username_signUp").val();
        var passwd = $("#passwd_signUp").val();
        var repasswd= $("#repassword_signUp").val();
        if(usernm.length === 0 && passwd.length === 0){
            $("#Error_signUp").html("Can't be empty");
    }
        else if(usernm.length === 0){
            $("#Error_signUp").html("Username can't be empty");
        }
        else if(passwd.length === 0){
           $("#Error_signUp").html("Password can't be empty");
    }else if(repasswd.length === 0){
            $("#Error_signUp").html("Re-check Password can't be empty");
        } else if(repasswd!== passwd){
            $("#Error_signUp").html("The password is different");      
        }
        else{
            $("#form-signUp").submit();
        }
    }
    function signUpD(){
        var usernm = $("#username_signUpD").val();
        var passwd = $("#passwdD_signUpD").val();
        var repasswd= $("#repasswd_signUpD").val();
        var firstname=$("#firstname_signUpD").val();
        var NPIc = $("#license_signUpD").val();
        if(usernm.length ===0  && passwd.length === 0){
            $("#Error_signUpD").html("Can't be empty");
    }
        else if(usernm.length === 0){
            $("#Error_signUpD").html("Username can't be empty");
        }
        else if(passwd.length === 0){
           $("#Error_signUpD").html("Password can't be empty");
        }else if(repasswd.length === 0){
            $("#Error_signUpD").html("Re-check Password can't be empty");
        } else if(repasswd!== passwd){
            $("#Error_signUpD").html("The password is different");      
        }else if(firstname.length === 0){
            $("#Error_signUpD").html("The firstname is empty");
        }else if(NPIc.length === 0){
            $("#Error_signUpD").html("The password is different");
        }
        else{
            $("#form-signUpD").submit();
        }
    }

    $("#File").change(function () {
        var filePath = $(this).val();
        if (filePath !== "") {
            var arr = filePath.split('\\');
            var fileName = arr[arr.length - 1];
            $("#FileTips").html(fileName);
        } else {
            $("#FileTips").html("You haven't choose a file yet, or the file type is invalid!");
            return false;
        }
    });
});

