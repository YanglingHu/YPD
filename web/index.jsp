<%-- 
    Document   : Index
    Created on : 2018-9-27, 21:51:42
    Author     : Yi Qiu
--%>
<%@include file = "WEB-INF/src/fragments/prepare.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS/temp-homepage.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Personal Doctor</title>
        <jsp:include page="sub_elements/common_source.jsp"></jsp:include>
        </head>
        <body style="min-width:1300px">
        <!--header start-->
        <jsp:include page="sub_elements/header.jsp"></jsp:include>
            <!--header end-->
            <div class="background">		
                <div class="newsDisplay">
                    <div class="row">
                    <div class="mainPicSlider">
                        <div class="scroll_pic">
                            <div class="arrows">
                                <span id="0" title="pervious" class="arrow_left"></span>
                                <span id="1" title="next" class="arrow_right"></span>
                            </div>
                            <ul class="ul_pic">
                                <li class="li_img"><img src="PIC/hospital11.jpg" width="600px" height="250px"></li>
                                <li class="li_img"><img src="PIC/medical-.jpg" width="600px" height="250px"></li>
                                <li class="li_img"><img src="PIC/banner-medical-indemnity.jpg" width="600px" height="250px"></li>
                                <li class="li_img"><img src="PIC/medical_technology_insurance.jpg" width="600px" height="250px"></li>
                            </ul>
                        </div>
                        <div style="margin-left: 195px">
                            <div class="scroll_btn"></div>
                            <div class="scroll_btn"></div>
                            <div class="scroll_btn"></div>
                            <div class="scroll_btn"></div>
                        </div>
                    </div>
                    <div class="login-box">
                    <%@include file = "WEB-INF/src/fragments/login_box.jspf" %>
                </div>
            </div>
        </div>
        <div class="info">
            <div class="info_main">	
                <div class="intro_textbox" style="border-right:solid 3px #d8d8f8">
                    <span class="intro_icon" style="margin-left: 40%; background: url(PIC/red-cross.png)"></span>
                    <p>Text here</p>
                </div>
                <div class="intro_textbox" style="border-right:solid 3px #d8d8f8">
                    <span class="intro_icon" style="; background: url(PIC/running.png)"></span>
                    <p style="margin-left: 10px;">Text here</p>
                </div>
                <div class="intro_textbox">
                    <span class="intro_icon" style="; background: url(PIC/link.png)"></span>
                    <p style="margin-left: 10px;">Text here</p>
                </div>
            </div>	
        </div>
        <!--footer start-->
        <jsp:include page="sub_elements/footer.jsp"></jsp:include>
        <!--footer end-->
        <script src="js/index_function.js"></script>
    </body>
</html>
