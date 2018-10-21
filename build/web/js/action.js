    function del(id) {
        var key = document.getElementById(id).getAttribute("value");
        location.href = "AccController?method=Remove&key=" + key;
    };
    

    function ban(id) {
        var key = document.getElementById(id).getAttribute("value");
        location.href = "AccController?method=Blacklist&key=" + key;
    };
    

    function act() {
        var key = document.getElementById(id).getAttribute("value");
        location.href = "AccController?method=Activate&key=" + key;
    };
    
    function signUp() {
        var OnlineID = document.getElementById("id-u").value;
        var Username = document.getElementById("username-u").value;
        var Password = document.getElementById("password-u").value;
        location.href = "AccController?method=Signup&ID=" + OnlineID + "&username=" + Username + "&password=" + Password;
    };
    
    function signIn() {
        var Username = document.getElementById("username-i").value;
        var Password = document.getElementById("password-i").value;
        location.href = "AccController?method=SignIn&username=" + Username + "&password=" + Password;
    };


