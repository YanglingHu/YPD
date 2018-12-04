<%-- 
    Document   : Account
    Created on : 2018-11-28
    Author     : Mengmeng Liu
--%>
<%@include file = "WEB-INF/src/fragments/isLoggin.jspf" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/choices.css">
        <title>Type Of Diseases</title>
        <jsp:include page="sub_elements/common_source.jsp"></jsp:include>
        </head>
        <body>
            <!--header start-->
        <jsp:include page="sub_elements/header.jsp"></jsp:include>
            <!--header end-->
            <div class="headslider">
                <div class ="head" >
                    <span class="img1" style="background: url(PIC/brain-and-head.png)"></span>
                    <div class="dropdown">
                        <div class="dropbtn">Doctor Types</div>

                        <div class="dropdown-content">

                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=1')">Brain</a>
                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=2')">Ear Nose & Throat</a>
                           
                        </div>
                    </div>
                </div>
                <div class ="head">
                    <span class="img1" style="background: url(PIC/brain-and-head.png)"></span>
                    <div class="dropdown">
                        <div class="dropbtn">Doctor Types</div>

                        <div class="dropdown-content">

                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=3')">Internal Medicine</a>
                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=4')">Surgery</a>
                         
                        </div>
                    </div>
                </div><div class ="head">
                    <span class="img1" style="background: url(PIC/brain-and-head.png)"></span>
                    <div class="dropdown">
                        <div class="dropbtn">Doctor Types</div>

                        <div class="dropdown-content">

                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=5')">Pediatrics</a>
                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=6')">Infectious Diseases</a>
                          
                        </div>
                    </div>
                </div><div class ="head">
                    <span class="img1" style="background: url(PIC/brain-and-head.png)"></span>
                    <div class="dropdown">
                        <div class="dropbtn">Doctor Types</div>

                        <div class="dropdown-content">

                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=7')">Obstetrics & Gynecology</a>
                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=8')">Psychosis</a>
                         
                        </div>
                    </div>
                </div><div class ="head">
                    <span class="img1" style="background: url(PIC/brain-and-head.png)"></span>
                    <div class="dropdown">
                        <div class="dropbtn">Doctor Types</div>

                        <div class="dropdown-content">

                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=9')">Dermatology</a>
                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=10')">Oncology</a>
                          
                        </div>
                    </div>
                </div><div class ="head">
                    <span class="img1" style="background: url(PIC/brain-and-head.png)"></span>
                    <div class="dropdown">
                        <div class="dropbtn">Doctor Types</div>

                        <div class="dropdown-content">

                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=11')">Orthopedices</a>
                            <a href="#" onclick="window.open('AccController?method=Match&pairing=true&MID=12')">Andrology</a>
                           
                        </div>
                    </div>
                </div>
            </div>
            <!--footer start-->
        <jsp:include page="sub_elements/footer.jsp"></jsp:include>
        <!--footer end-->
    </body>
</html>
