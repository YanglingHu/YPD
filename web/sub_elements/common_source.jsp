<%-- 
    Document   : common_source
    Created on : 2018-9-29, 15:46:12
    Author     : Yi Qiu
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="CSS/general_elements.css" type="text/css">
<link rel="stylesheet" href="CSS/bootstrap.min.css" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    $(function () {
        function footerPosition() {
            $("footer").removeClass("fixed-bottom");
            var contentHeight = document.body.scrollHeight;
                    var winHeight = window.innerHeight;
            if (!(contentHeight > winHeight)) {
                $("footer").addClass("fixed-bottom");
            } else {
                $("footer").removeClass("fixed-bottom");
            }
        }
        footerPosition();
        $(window).resize(footerPosition);
    });
</script>

