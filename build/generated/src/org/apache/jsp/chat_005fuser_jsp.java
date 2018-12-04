package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Class.User;
import java.util.*;

public final class chat_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/src/fragments/prepare.jspf");
    _jspx_dependants.add("/WEB-INF/src/fragments/chat_user.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
    boolean log;
    boolean checked;
    if(session.getAttribute("result")!= null && session.getAttribute("checked") != null){
        log = (Boolean)session.getAttribute("result");
        checked = (Boolean)session.getAttribute("checked");
    }else{
        log = false;
        checked = false;
    }
    Cookie[] cookie = request.getCookies();
    if (cookie != null && !checked) {
        for (int i = 0; i < cookie.length; i++) {
            if (cookie[i].getName().compareTo("name") == 0) {
                session.setAttribute("checked", true);
                response.sendRedirect("AccController?method=LogInInfo&name=" + cookie[i].getValue());
            }
        }
    }
    User user = new User();
    if(session.getAttribute("C_User") != null){
         user = (User) session.getAttribute("C_User");
    }
    session.setAttribute("result", log);

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <title>Chating</title>\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/common_source.jsp", out, false);
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"CSS/chat.css\" type=\"text/css\">\n");
      out.write("    <script src=\"js/chat.js\"></script>\n");
      out.write("    ");
      out.write("\n");
      out.write(" <script>\n");
      out.write("        var docname;\n");
      out.write("        var linkName;\n");
      out.write("        var websocket = null;\n");
      out.write("        \n");
      out.write("        linkName = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.uuid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("        docname = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("            \n");
      out.write("        if(linkName == \"\") {\n");
      out.write("            alert(\"You must select someone to chat with.\");\n");
      out.write("            window.location.href = \"./index.jsp\";\n");
      out.write("        }\n");
      out.write("            \n");
      out.write("        if ('WebSocket' in window) {\n");
      out.write("            websocket = new WebSocket(\"ws://localhost:8080/Your-Personal-Doctor/websocket\");\n");
      out.write("        }\n");
      out.write("        else {\n");
      out.write("            alert('Not support websocket');\n");
      out.write("            window.location.href = \"./index.jsp\";\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        websocket.onerror = function () {\n");
      out.write("            alert('connect to websocket server error.');\n");
      out.write("            window.location.href = \"./index.jsp\";\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        websocket.onopen = function () {\n");
      out.write("            send(\"connect:\"+linkName+\",\"+\"myname\")\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        websocket.onmessage = function (event) {\n");
      out.write("            // todo: handle\n");
      out.write("            console.log(event.data);\n");
      out.write("            if(event.data.startsWith(\"error:\")) {\n");
      out.write("                var errorinfo = event.data.replace(\"error:\", \"\");\n");
      out.write("                alert(errorinfo);\n");
      out.write("                window.location.href = \"./index.jsp\";\n");
      out.write("            } else if(event.data.startsWith(\"message:\")){\n");
      out.write("                var messageinfo = event.data.replace(\"message:\", \"\");\n");
      out.write("                AddMsg(docname, messageinfo);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    \n");
      out.write("        websocket.onclose = function () {\n");
      out.write("            //alert('websocket server connection lose.');\n");
      out.write("            //window.location.href = \"./index.jsp\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        window.onbeforeunload = function () {\n");
      out.write("            closeWebSocket();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function closeWebSocket() {\n");
      out.write("            websocket.close();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function send(msg) {\n");
      out.write("            //var message = document.getElementById('text').value;\n");
      out.write("            websocket.send(msg);\n");
      out.write("        }\n");
      out.write("    \n");
      out.write("        $(function(){\n");
      out.write("            $(\"#pnl-strtitle\").text(\"Chat with \"+docname);\n");
      out.write("          \n");
      out.write("        });\n");
      out.write("    </script>");
      out.write("    \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"abs cover contaniner\">\n");
      out.write("        <div class=\"abs cover pnl\">\n");
      out.write("            <div class=\"top pnl-head\">\n");
      out.write("                <div id=\"pnl-strtitle\">\n");
      out.write("                Chatting with\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"abs cover pnl-body\" id=\"pnlBody\">\n");
      out.write("                <div class=\"abs cover pnl-left\">\n");
      out.write("                    <div class=\"abs cover pnl-msgs scroll\" id=\"show\">\n");
      out.write("\n");
      out.write("                        <div class=\"pnl-list\" id=\"msgs\">\n");
      out.write("                          \n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"abs bottom pnl-text\">\n");
      out.write("                        <div class=\"abs top pnl-warn\" id=\"pnlWarn\">\n");
      out.write("                   \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"abs cover pnl-input\">\n");
      out.write("                            <textarea class=\"scroll\" id=\"text\" wrap=\"hard\" placeholder=\"Input your question here...\"></textarea>\n");
      out.write("                            <div class=\"abs atcom-pnl scroll hide\" id=\"atcomPnl\">\n");
      out.write("                                <ul class=\"atcom\" id=\"atcom\"></ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"abs br pnl-btn\" id=\"submit\" onclick=\"SendMsg('user')\">Send</div>\n");
      out.write("                        <div class=\"pnl-support\" id=\"copyright\"><a href=\"#\">YPD Project</a></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
