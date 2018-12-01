$(document).ready(function () {
    function jump(count) {
        
        
        window.setTimeout(function () {
            if (count > 0) {
                $("#Countdown").html("Will return automatically in " + count + " seconds");
                count--;
                jump(count);
            } else {
                location.href = document.referrer;
            }
        }, 1000);
    }
    jump(5);
});

