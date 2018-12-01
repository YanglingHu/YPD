<%-- 
    Document   : match
    Created on : 2018-11-26, 20:02:00
    Author     : Administrator
--%>
<%@page import="Class.User"%>
<%@page import="YPD.Model.acc.AccProc"%>
<%@page import="java.util.*"%>
<%@include file = "WEB-INF/src/fragments/isLoggin.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="sub_elements/common_source.jsp"></jsp:include>
        <title>Match it</title>
    </head>
    <body>
        <jsp:include page="sub_elements/header.jsp"></jsp:include>
        <div class="container" style="margin:10px auto;">
            <%@include file = "WEB-INF/src/fragments/list_doctor.jspf" %>
        </div>
        <jsp:include page="sub_elements/footer.jsp"></jsp:include>
    </body>
</html>
