    function del(id) {
        var key = document.getElementById(id).getAttribute("value");
        location.href = "AccController?method=Remove&key=" + key;
    };
    

    function ban(id) {
        var key = document.getElementById(id).getAttribute("value");
        location.href = "AccController?method=Blacklist&key=" + key;
    };
    

    function act(id) {
        var key = document.getElementById(id).getAttribute("value");
        location.href = "AccController?method=Activate&key=" + key;
    };
    
    function signUp() {
        var OnlineID = document.getElementById("id-u").value;
        var Username = document.getElementById("username-u").value;
        var Password = document.getElementById("password-u").value;
        location.href = "AccController?method=SignUp&ID=" + OnlineID + "&username=" + Username + "&password=" + Password;
    };
    
    function signUpD() {
        var OnlineID = document.getElementById("id-d").value;
        var Username = document.getElementById("username-d").value;
        var Password = document.getElementById("password-d").value;
        var firstname = document.getElementById("Firstname-d").value;
        var NPI = document.getElementById("NPI-d").value;
        location.href = "AccController?method=SignUp&ID=" + OnlineID + "&username=" + Username + "&password=" + Password + "&firstname=" + firstname + "&NPI=" + NPI;
    };
    
    function signIn() {
        var Username = document.getElementById("username-i").value;
        var Password = document.getElementById("password-i").value;
        location.href = "AccController?method=SignIn&username=" + Username + "&password=" + Password;
    };


