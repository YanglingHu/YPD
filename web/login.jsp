<%-- 
    Document   : login_doctor
    Created on : 2018-9-29, 15:26:56
    Author     : Yi Qiu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to YPD--</title>
        <link rel="stylesheet" href="CSS/login.css" type="text/css">
        <jsp:include page="sub_elements/common_source.jsp"></jsp:include>
        
    </head>
    <body>        
        <jsp:include page="sub_elements/header.jsp"></jsp:include>
            <div class="Main">
                <div class="BG-warpper">
                    <div class="login-theme">
                        <div class="login-warpper">
                            <!--tab section 1-->
                            <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-1" checked>
                            <label for="tab-radio-1" class="tab-handler tab-handler-1">SignIn</label>
                            <div class="tab-content tab-content-1">
                                <td align="center">
                                    <form action="AccController" method="SignIn">
                                        <b>Username：</b></br>
                                        <input name="username" type="text"><p>
                                            <b>Password：</b></br>
                                        <input name="password" type="password" ><p>
                                            </br>
                                        <p align="center">
                                            <input type="submit" value="SignIn">
                                        </p>
                                    </form>
                                </td>
                            </div>
                            <!--tab section 2-->
                            <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
                            <label for="tab-radio-2" class="tab-handler tab-handler-2">SignUp</label>
                            <div class="tab-content tab-content-2">
                                <td align="center">
                                    <form action="AccController" method="SignUp">
                                        <b>OnlineID：</b></br>
                                        <input name="id" type="text"><p>
                                            <b>Username：</b></br>
                                        <input name="username" type="text"><p>
                                            <b>Password：</b></br>
                                        <input name="password" type="password" ><p>
                                            <b>Check-pw：</b></br>
                                        <input name="repasswd" type="password"><p>
                                            </br>
                                        <p align="center">
                                            <input type="submit" value="SignUp">
                                        </p>
                                    </form>
                                </td>
                            </div>
                        </div>    
                    </div>
                </div>
            </div>
        <jsp:include page="sub_elements/footer.jsp"></jsp:include>
    </body>
</html>
