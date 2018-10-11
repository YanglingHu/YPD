var count = 0;
var timer;
var end = false;
ZERO = 0;
IMGWIDTH = 600;

window.onload = function () {
    var arrows = document.getElementsByClassName("arrows");
    var ul_pic = document.getElementsByClassName("ul_pic")[0];
    var li_img = document.getElementsByClassName("li_img");
    var arrow_left = document.getElementById("0");
    var arrow_right = document.getElementById("1");
    var scroll_btn = document.getElementsByClassName("scroll_btn");
    scroll_btn[0].style.backgroundColor = "#858585";

    picTimer();

    function picTimer() {
        timer = setInterval(function () {
            if (!end) {
                count++;
                ul_pic.style.transform = "translate(" + -600 * count + "px)";
                if (count >= li_img.length) {//If reach the last image element.
                    ul_pic.style.transform = "translate(0px)";//Reset ul position
                    count = ZERO;
                }
            }

            for (var i = 0; i < scroll_btn.length; i++) {
                //Set color for all buttoms to default.
                scroll_btn[i].style.backgroundColor = "#e8e8e8";
            }

            scroll_btn[count].style.backgroundColor = "#858585";//Set color for the buttom that represents current image to #858585.
        }
        , 5500);
    }

    arrows.click = function () {
        event.event.stopPropagation();
    };

    arrow_left.onmouseover = function () {
        clearInterval(timer);
    };

    arrow_right.onmouseover = function () {
        clearInterval(timer);
    };

    arrow_left.onmouseout = function () {
        picTimer();
    };

    arrow_right.onmouseout = function () {
        picTimer();
    };

    arrow_left.onclick = function () {
        if (count <= ZERO) {
            ul_pic.style.transform = "translate(-1800px)";//Reset ul position to end.
            count = 3;
        } else {
            count--;
            ul_pic.style.transform = "translate(" + -600 * count + "px)";
        }

        for (var i = 0; i < scroll_btn.length; i++) {
            //Set color for all buttoms to default.
            scroll_btn[i].style.backgroundColor = "#e8e8e8";
        }

        scroll_btn[count].style.backgroundColor = "#858585";//Set color for the buttom that represents current image to #858585.
    };

    arrow_right.onclick = function () {
        if (!end) {
            if (count >= li_img.length - 1) {//If reach the last image element.
                ul_pic.style.transform = "translate(0px)";//Reset ul position
                count = ZERO;
            } else {
                count++;
                ul_pic.style.transform = "translate(" + -600 * count + "px)";
            }
        }

        for (var i = 0; i < scroll_btn.length; i++) {
            //Set color for all buttoms to default.
            scroll_btn[i].style.backgroundColor = "#e8e8e8";
        }

        scroll_btn[count].style.backgroundColor = "#858585";//Set color for the buttom that represents current image to #858585.
    };

};


