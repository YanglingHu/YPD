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
        <title>Manager plannel</title>
    </head>
    <body>
        <%
            AccProc accproc = new AccProc();
            ArrayList<User> list = (ArrayList) session.getAttribute("UserSet");
            int count = 0;
            for (User user : list) {
        %>
        <div>
            <label>UUID: <%out.write(user.getUuid());%> , Name: <%out.write(user.getName());%>, UserType: <%if (user.getUsertype() == 0) {
                    out.write("Doctor");
                } else {
                    out.write("User");
                }%>
                </lable>
                <input type ="hidden" id="user-<%out.write((Integer.toString(count)));%>" value="<%out.write((Integer.toString(count)));%>"/>
                <input type="button" name="user-<%out.write((Integer.toString(count)));%>" value="Delete" onclick= "del(this.name);"/>
                &nbsp;&nbsp;
                <%
                    if (user.getBanned() == 0) {
                %>
                <input type="button" name="user-<%out.write((Integer.toString(count)));%>" value="Ban" onclick="ban(this.name)" />
                <%} else {%>
                <input type="button" name="user-<%out.write((Integer.toString(count)));%>" value="Activate" onclick="act(this.name)" />
                <%}
                count++;%>
        </div>        
        </br>
        <%}%>
        <script src="js/action.js" ></script>
    </body>
</html>
