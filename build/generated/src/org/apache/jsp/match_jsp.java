package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Class.User;
import YPD.Model.acc.AccProc;
import java.util.*;
import Class.User;

public final class match_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/WEB-INF/src/fragments/isLoggin.jspf");
    _jspx_dependants.add("/WEB-INF/src/fragments/list_doctor.jspf");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    User user = new User();
    String[] MID = new String[0];
    Boolean result = (Boolean) session.getAttribute("result");
    //out.print(result);
    if (result != null) {
        if (!result) {
            response.sendRedirect("login.jsp");
            return; 
        }else{
            if (session.getAttribute("C_User") != null) {
                user = (User) session.getAttribute("C_User");
                MID = user.getMidArray();
            }
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/common_source.jsp", out, false);
      out.write("\n");
      out.write("        <title>Match it</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/header.jsp", out, false);
      out.write("\n");
      out.write("        <div class=\"container\" style=\"margin:10px auto;\">\n");
      out.write("            ");
      out.write('\n');

    ArrayList<User> list = (ArrayList) session.getAttribute("DoctorSet");
    int count = 0;
    if (list.size() == 0) {

      out.write("\n");
      out.write("<center><h2>No Doctor founded</h2></center>\n");
      out.write("    ");

        }
        while (count < list.size()) {
            User doctor = list.get(count);
    
      out.write("\n");
      out.write("<div class=\"card\">\n");
      out.write("    <div class=\"card-body\">\n");
      out.write("        <h4 class=\"card-title\">");
out.write(doctor.getTypeString() + "-" + doctor.getName());
      out.write("</h4></br>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-4 col-sm-12 text-center\" style=\"min-height: 180px;vertical-align: central;\">\n");
      out.write("                <img style=\"height: 128px; width: 128px;\" src=\"");
out.write(doctor.getImg());
      out.write("\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-8 col-sm-12\">\n");
      out.write("                <ul class=\"nav nav-tabs\">\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link active\" data-toggle=\"tab\" href=\"#Profile-");
out.write((Integer.toString(count)));
      out.write("\">Profile</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" data-toggle=\"tab\" href=\"#Summary-");
out.write((Integer.toString(count)));
      out.write("\">Summary</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("                <div class=\"tab-content\">\n");
      out.write("                    <div class=\"tab-pane fade show active\" id=\"Profile-");
out.write((Integer.toString(count)));
      out.write("\">\n");
      out.write("                        <p>Age:");
out.write(Integer.toString(doctor.getAge()));
      out.write("</p>\n");
      out.write("                        <p>Phone:");
out.write(Integer.toString(doctor.getContact()));
      out.write("</p>\n");
      out.write("                        <p>Gender:");
out.write(doctor.getGenderString());
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"tab-pane fade\" id=\"Summary-");
out.write((Integer.toString(count)));
      out.write("\">\n");
      out.write("                        <p>Specialist of:</br>");
out.write(doctor.getMidString());
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div style=\"float:right\">\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"\" >More Info</button>\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"window.open('mailto:");
out.write(doctor.getEmail());
      out.write("')\" >Email Me</button>\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"\" >Join IM</button>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
count++;
      out.write('\n');
}
    count = 0;
      out.write('\n');
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/footer.jsp", out, false);
      out.write("\n");
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
