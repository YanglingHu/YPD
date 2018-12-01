$(document).ready(function () {
    $("#username_signIn").change(removeError);
    $("#password_signIn").change(removeError);
    $("#button_signIn").click(login);
   
    function removeError(){
        $("#Error_signIn").html("");
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