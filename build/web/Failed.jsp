<%-- 
    Document   : Failed.jsp
    Created on : 2018-11-26, 16:12:34
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="sub_elements/common_source.jsp"></jsp:include>
        <script src="js/Debug.js"></script>
        <title>Failed</title>
    </head>
    <body>
        <center>
        <h1>Failed!</h1>
        <h4>Debug:${Debug}</h4>
        <h5 id="Countdown"></h>
        </center>
    </body>
</html>
