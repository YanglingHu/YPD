<%-- 
    Document   : Manager
    Created on : 2018-10-20, 15:02:19
    Author     : Administrator
--%>

<%@page import="Class.User"%>
<%@page import="YPD.Model.acc.AccProc"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="sub_elements/common_source.jsp"></jsp:include>
        <title>Manager plannel</title>
    </head>
    <body>
        <div class="col-6 offset-3">
        <%@include file = "WEB-INF/src/fragments/list_manager.jspf" %>
        </div>
        <div class="col-4 mx-auto">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </div>
    </body>
</html>
