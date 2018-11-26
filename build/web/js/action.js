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



