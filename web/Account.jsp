<%-- 
    Document   : Account
    Created on : 2018-11-28, 16:28:40
    Author     : Yi Qiu
--%>
<%@include file = "WEB-INF/src/fragments/isLoggin.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="sub_elements/common_source.jsp"></jsp:include>
        <script src="js/Tips.js"></script>
        <title>Account Management</title>
        </head>
        <body>
        <jsp:include page="sub_elements/header.jsp"></jsp:include>
            <div class="container">
                <!--Left nav bar-->
                <div class="row">
                    <div class="col-md-2 col-sm-12">
                        <nav class="navbar navbar-dark bg-primary ">
                            <ul class="nav nav-pills navbar-nav">
                                <li class="nav-item active"><a href="#profile" class="nav-link" data-toggle="tab">Profile</a></li>
                                <li class="nav-item"><a href="#historyboard" class="nav-link" data-toggle="tab">History</a></li>
                                <li class="nav-item"><a href="#mailbox" class="nav-link" data-toggle="tab">MailBox</a></li>
                            </ul>
                        </nav>
                    </div>
                    <!--Canvas for profile-->
                    <div class="col-md-10 col-sm-12 tab-content">
                        <div class="tab-pane fade active show" id="profile">
                            <!---->
                            <div class="card border-light mb-3">
                                <div class="card-header"><h4>Avatar</h4></div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-4 col-sm-12 text-center"><image style ="width: 128px; height: 128px; background-size: cover" src="<%out.write(user.getImg());%>"></image></div>
                                        <div class="col-md-8 col-sm-12">
                                            <p><h5>Upload a new image here</h5></p>
                                            <form id="form-Image" action="UpdateController" method="Post" enctype="multipart/form-data">
                                                Choose a picture to upload:</br>
                                                <div class="custom-file">
                                                    <input type="file" class="custom-file-input" name="File" id="File" accept="image/bmp, image/png, imgage/jpg"/>
                                                    <label id="FileTips" class="custom-file-label" for="File">Choose file</label>
                                                </div>
                                            </form>   
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button type="button" class="btn btn-outline-primary btn-block btn-sm" onclick="document.getElementById('form-Image').submit();">save</button>
                            <!---->
                            <%@include file = "WEB-INF/src/fragments/MyInfo.jspf" %>
                            <!--MyTag-->
                            <%@include file = "WEB-INF/src/fragments/MyTag.jspf" %>
                        <!--Canvas for history-->
                        <div class="tab-pane fade" id="historyboard" style="height: -webkit-fill-available;">
                            <h2>Coming Soon</h2>
                        </div>
                        <!--Canvas for mailbox-->
                        <div class="tab-pane fade" id="mailbox" style="height: -webkit-fill-available;">
                            <h2>Coming Soon</h2>
                        </div>
                    </div>
                </div>
            </div>
        <jsp:include page="sub_elements/footer.jsp"></jsp:include>
    </body>
</html>
