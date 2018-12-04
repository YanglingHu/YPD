<%-- 
    Document   : Index
    Created on : 2018-9-27, 21:51:42
    Author     : Yi Qiu
--%>

<%@include file = "WEB-INF/src/fragments/prepare.jspf" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chating</title>
    <jsp:include page="sub_elements/common_source.jsp"></jsp:include>
    <link rel="stylesheet" href="CSS/chat.css" type="text/css">
    <script src="js/chat.js"></script>
    <%@include file = "WEB-INF/src/fragments/chat_user.jspf" %>    
</head>
<body>
    <div class="abs cover contaniner">
        <div class="abs cover pnl">
            <div class="top pnl-head">
                <div id="pnl-strtitle">
                Chatting with
                </div>
            </div>
            <div class="abs cover pnl-body" id="pnlBody">
                <div class="abs cover pnl-left">
                    <div class="abs cover pnl-msgs scroll" id="show">

                        <div class="pnl-list" id="msgs">
                          
                        </div>

                    </div>
                    <div class="abs bottom pnl-text">
                        <div class="abs top pnl-warn" id="pnlWarn">
                   
                        </div>
                        <div class="abs cover pnl-input">
                            <textarea class="scroll" id="text" wrap="hard" placeholder="Input your question here..."></textarea>
                            <div class="abs atcom-pnl scroll hide" id="atcomPnl">
                                <ul class="atcom" id="atcom"></ul>
                            </div>
                        </div>
                        <div class="abs br pnl-btn" id="submit" onclick="SendMsg('user')">Send</div>
                        <div class="pnl-support" id="copyright"><a href="#">YPD Project</a></div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
