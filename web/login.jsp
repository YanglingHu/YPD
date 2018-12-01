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
        <script src="js/Tips.js"></script>
    </head>
    <body>        
        <jsp:include page="sub_elements/header.jsp"></jsp:include>
            <div class="Main">
                <div class="BG-wrapper">
                    <div class="login-theme">
                        <div>
                            <!--tab section 1-->
                            <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-1" checked>
                            <label for="tab-radio-1" class="tab-handler tab-handler-1">SignIn</label>
                            <div class="tab-content tab-content-1">
                                <td align="center">
                                    <form action="AccController" method="Post" id="form-Login">
                                            <b>Username：</b></br>
                                        <input id="username_signIn" name="username" type="text" /></br>
                                            <b>Password：</b></br>
                                        <input id="password_signIn" name="password" type="password" /><p>
                                        <input type ="hidden" name="method" value="SignIn"/>
                                        <p align="center">
                                            <button id="button_signIn" type="button" class="btn btn-sm btn-primary">SignIn</button>
                                        </p>
                                        <p id="Error_signIn" style="color: red"></p>
                                    </form>
                                </td>
                            </div>
                            <!--tab section 2-->
                            <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
                            <label for="tab-radio-2" class="tab-handler tab-handler-2">SignUp</label>
                            <div class="tab-content tab-content-2">
                                <td align="center">
                                    <form action="AccController" method="Post">
                                            <b>Username：</b></br>
                                        <input name="username" type="text" /></br>
                                            <b>Password：</b></br>
                                        <input name="password" type="password"/></br>
                                            <b>Check-pw：</b></br>
                                        <input id="repasswd" type="password" /><p>
                                        <input type ="hidden" name="method" value="SignUp"/>
                                        <p align="center">
                                            <button type="button" class="btn btn-sm btn-primary" onclick="this.form.submit()">SignUp</button>
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
                            <form id="modal-form-doctor" action="AccController" method="Post">
                                    <b>Username：</b></br>
                                <input name="username" type="text" /></br>
                                    <b>Password：</b></br>
                                <input name="password" type="password"/></br>
                                    <b>Check-pw：</b></br>
                                <input id="repasswd" type="password"/></br>
                                    <b>Your First Name：</b></br>
                                <input name="firstname" type="text" onkeyup="this.value=this.value.replace(/[^a-zA-Z]/g,'')"/></br>
                                    <b>Your NPI license：</b></br>
                                <input name="NPI" type="tel" onkeyup="this.value=this.value.replace(/\D/g,'')"/><p>
                                <input type ="hidden" name="method" value="SignUp"/>
                            </form>
                            </div>
                        </div>
                        <div class="modal-footer">
                        <button type="button" class="btn btn-sm btn-primary" onclick="document.getElementById('modal-form-doctor').submit();">SignUp</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        <jsp:include page="sub_elements/footer.jsp"></jsp:include>
    </body>
</html>
