package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Class.User;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/src/fragments/prepare.jspf");
    _jspx_dependants.add("/WEB-INF/src/fragments/login_box.jspf");
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/temp-homepage.css\" type=\"text/css\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Your Personal Doctor</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/common_source.jsp", out, false);
      out.write("\n");
      out.write("        </head>\n");
      out.write("        <body style=\"min-width:1300px\">\n");
      out.write("        <!--header start-->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/header.jsp", out, false);
      out.write("\n");
      out.write("            <!--header end-->\n");
      out.write("            <div class=\"background\">\t\t\n");
      out.write("                <div class=\"newsDisplay\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                    <div class=\"mainPicSlider\">\n");
      out.write("                        <div class=\"scroll_pic\">\n");
      out.write("                            <div class=\"arrows\">\n");
      out.write("                                <span id=\"0\" title=\"pervious\" class=\"arrow_left\"></span>\n");
      out.write("                                <span id=\"1\" title=\"next\" class=\"arrow_right\"></span>\n");
      out.write("                            </div>\n");
      out.write("                            <ul class=\"ul_pic\">\n");
      out.write("                                <li class=\"li_img\"><img src=\"PIC/hospital11.jpg\" width=\"600px\" height=\"250px\"></li>\n");
      out.write("                                <li class=\"li_img\"><img src=\"PIC/medical-.jpg\" width=\"600px\" height=\"250px\"></li>\n");
      out.write("                                <li class=\"li_img\"><img src=\"PIC/banner-medical-indemnity.jpg\" width=\"600px\" height=\"250px\"></li>\n");
      out.write("                                <li class=\"li_img\"><img src=\"PIC/medical_technology_insurance.jpg\" width=\"600px\" height=\"250px\"></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div style=\"margin-left: 195px\">\n");
      out.write("                            <div class=\"scroll_btn\"></div>\n");
      out.write("                            <div class=\"scroll_btn\"></div>\n");
      out.write("                            <div class=\"scroll_btn\"></div>\n");
      out.write("                            <div class=\"scroll_btn\"></div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"login-box\">\n");
      out.write("                    ");
      out.write('\n');
 if(log == false){ 
      out.write("\n");
      out.write("<div class=\"login-title\">\n");
      out.write("    <span class=\"icon\">\n");
      out.write("        <i class=\"disPlayA\"></i>\n");
      out.write("    </span>\n");
      out.write("    <n1>Fast Track</n1>\n");
      out.write("</div>\n");
      out.write("<p style=\"margin: 25px;background: #FFFFFF\">\n");
      out.write("    Login is required for more </br>Y-P-D self service! \n");
      out.write("</p>\n");
      out.write("<p style=\"margin: 50px 40px\"> \n");
      out.write("    <a href=\"login.jsp\">\n");
      out.write("        <span class=\"icon-doctor\"> </span> \n");
      out.write("        Login \n");
      out.write("    </a>\n");
      out.write("</p>\n");
}else{
      out.write("   \n");
      out.write("<div class=\"login-title\">\n");
      out.write("    <span class=\"icon\">\n");
      out.write("        <i class=\"disPlayA\"></i>\n");
      out.write("    </span>\n");
      out.write("    <n1>Dashboard</n1>\n");
      out.write("</div>\n");
      out.write("<p style=\"margin: 17px;background: #FFFFFF; line-height: 20px\">\n");
      out.write("<td align=\"center\">\n");
      out.write("    <image style =\"width: 100px; height: 100px; background-size: cover\" src = \"");
if(!user.getImg().equals("")){ out.write(user.getImg()); } else { out.write("PIC/person.png");}
      out.write("\" /></br>\n");
      out.write("    Name: ");
out.write(user.getName());
      out.write("</br>\n");
      out.write("    Age: ");
out.write(Integer.toString(user.getAge()));
      out.write("</br>\n");
      out.write("    Gender: ");
out.write(user.getGenderString());
      out.write("</br>\n");
      out.write("</td>\n");
      out.write("</p>\n");
      out.write("<p style=\"margin: 15px 40px\"> \n");
      out.write("    <a href=\"AccController?method=Match&pairing=true\">\n");
      out.write("        Quick Matching\n");
      out.write("    </a>\n");
      out.write("</p>\n");
      out.write("<p style=\"margin: 15px 40px\"> \n");
      out.write("    <a href=\"AccController?method=Logoff\">\n");
      out.write("        Logout\n");
      out.write("    </a>\n");
      out.write("</p>\n");
}
      out.write('\n');
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"info\">\n");
      out.write("            <div class=\"info_main\">\t\n");
      out.write("                <div class=\"intro_textbox\" style=\"border-right:solid 3px #d8d8f8\">\n");
      out.write("                    <span class=\"intro_icon\" style=\"margin-left: 40%; background: url(PIC/red-cross.png)\"></span>\n");
      out.write("                    <p>Text here</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"intro_textbox\" style=\"border-right:solid 3px #d8d8f8\">\n");
      out.write("                    <span class=\"intro_icon\" style=\"; background: url(PIC/running.png)\"></span>\n");
      out.write("                    <p style=\"margin-left: 10px;\">Text here</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"intro_textbox\">\n");
      out.write("                    <span class=\"intro_icon\" style=\"; background: url(PIC/link.png)\"></span>\n");
      out.write("                    <p style=\"margin-left: 10px;\">Text here</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\t\n");
      out.write("        </div>\n");
      out.write("        <!--footer start-->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/footer.jsp", out, false);
      out.write("\n");
      out.write("        <!--footer end-->\n");
      out.write("        <script src=\"js/index_function.js\"></script>\n");
      out.write("    </body>\n");
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
