<%-- 
    Document   : login
    Created on : 2018-12-1, 16:45:37
    Author     : hylhy
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
                                            <button id="button_signIn" type="button" class="btn btn-sm btn-primary" >SignIn</button>
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
                                    <form action="AccController" method="Post" id="form-signUp">
                                            <b>Username：</b></br>
                                        <input id="username_signUp"  name="username" type="text" /></br>
                                            <b>Password：</b></br>
                                        <input id="passwd_signUp" name="password" type="password"/></br>
                                            <b>Check-pw：</b></br>
                                        <input id="repassword_signUp" type="password" /><p>
                                        <input type ="hidden" name="method" value="SignUp"/>
                                        <p align="center">
                                            <button id="button_signUp" type="button" class="btn btn-sm btn-primary" >SignUp</button>
                                        </p>
                                        <p id="Error_signUp" style="color: red"></p>
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
                                <input id="username_signUpD" name="username" type="text" /></br>
                                    <b>Password：</b></br>
                                <input id="passwdD_signUpD" name="password" type="password"/></br>
                                    <b>Check-pw：</b></br>
                                <input id="repasswd_signUpD" type="password" /></br>
                                    <b>Your First Name：</b></br>
                                <input id = "firstname_signUpD" name="firstname" type="text" onkeyup="this.value=this.value.replace(/[^a-zA-Z]/g,'')"/></br>
                                    <b>Your NPI license：</b></br>
                                <input id = "license_signUpD" name="NPI" type="tel" onkeyup="this.value=this.value.replace(/\D/g,'')"/><p>
                                <input type ="hidden" name="method" value="SignUp"/>
                                 <p id="Error_signUpD" style="color: red"></p>
                            </form>
                            
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button id="button_signUpD" type="button" class="btn btn-sm btn-primary">SignUp</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        <jsp:include page="sub_elements/footer.jsp"></jsp:include>
    </body>
</html>
