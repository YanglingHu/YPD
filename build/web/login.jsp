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
                                    <form action="AccController?method=signIn" method="Post">
                                            <b>Username：</b></br>
                                        <input id="username-i" type="text" /></br>
                                            <b>Password：</b></br>
                                        <input id="password-i" type="password" /><p>
                                        <p align="center">
                                            <button type="button" class="btn btn-sm btn-primary" onclick="signIn()">SignIn</button>
                                        </p>
                                    </form>
                                </td>
                            </div>
                            <!--tab section 2-->
                            <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
                            <label for="tab-radio-2" class="tab-handler tab-handler-2">SignUp</label>
                            <div class="tab-content tab-content-2">
                                <td align="center">
                                    <form action="AccController?method=SignUp" method="Post">
                                            <b>OnlineID：</b></br>
                                        <input id="id-u" type="text" /></br>
                                            <b>Username：</b></br>
                                        <input id="username-u" type="text" /></br>
                                            <b>Password：</b></br>
                                        <input id="password-u" type="password"/></br>
                                            <b>Check-pw：</b></br>
                                        <input id="repasswd-u" type="password" /><p>
                                        <p align="center">
                                            <button type="button" class="btn btn-sm btn-primary" onclick="signUp()">SignUp</button>
                                        </p>
                                    </form>
                                </td>
                                <p class="" style="float: right"><a href="#" data-toggle="modal" data-target="#signUpDoctor">I'm a doctor</a></p>
                            </div>
                        </div>    
                    </div>
                </div>
            </div>
            <!-- Modal -->
            <div class="modal fade" id="signUpDoctor" aria-hidden="true" data-backdrop="static">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Be a member of us</h5>
                        </div>
                        <div class="modal-body">
                            <div class="col-8 mx-auto text-center">
                            <form action="AccController?method=SignUp" method="Post">
                                    <b>OnlineID：</b></br>
                                <input id="id-d" type="text" /></br>
                                    <b>Username：</b></br>
                                <input id="username-d" type="text" /></br>
                                    <b>Password：</b></br>
                                <input id="password-d" type="password"/></br>
                                    <b>Check-pw：</b></br>
                                <input id="repasswd-d" type="password"/></br>
                                    <b>Your First Name：</b></br>
                                <input id="Firstname-d" type="text" onkeyup="this.value=this.value.replace(/[^a-zA-Z]/g,'')"/></br>
                                    <b>Your NPI license：</b></br>
                                <input id="NPI-d" type="tel" onkeyup="this.value=this.value.replace(/\D/g,'')"/><p>
                            </form>
                            </div>
                        </div>
                        <div class="modal-footer">
                        <button type="button" class="btn btn-sm btn-primary" onclick="signUpD()">SignUp</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        <jsp:include page="sub_elements/footer.jsp"></jsp:include>
        <script src="js/action.js" ></script>
    </body>
</html>
