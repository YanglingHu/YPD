package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class choices_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/choices.css\">\n");
      out.write("        <title>Type Of Diseases</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/common_source.jsp", out, false);
      out.write("\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("            <!--header start-->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/header.jsp", out, false);
      out.write("\n");
      out.write("            <!--header end-->\n");
      out.write("            <div class=\"headslider\">\n");
      out.write("                <div class =\"head\" >\n");
      out.write("                    <span class=\"img1\" style=\"background: url(PIC/brain-and-head.png)\"></span>\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        <div class=\"dropbtn\">Doctor Types</div>\n");
      out.write("\n");
      out.write("                        <div class=\"dropdown-content\">\n");
      out.write("\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=1')\">Brain</a>\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=2')\">Ear Nose & Throat</a>\n");
      out.write("                           \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class =\"head\">\n");
      out.write("                    <span class=\"img1\" style=\"background: url(PIC/brain-and-head.png)\"></span>\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        <div class=\"dropbtn\">Doctor Types</div>\n");
      out.write("\n");
      out.write("                        <div class=\"dropdown-content\">\n");
      out.write("\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=3')\">Internal Medicine</a>\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=4')\">Surgery</a>\n");
      out.write("                         \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div><div class =\"head\">\n");
      out.write("                    <span class=\"img1\" style=\"background: url(PIC/brain-and-head.png)\"></span>\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        <div class=\"dropbtn\">Doctor Types</div>\n");
      out.write("\n");
      out.write("                        <div class=\"dropdown-content\">\n");
      out.write("\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=5')\">Pediatrics</a>\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=6')\">Infectious Diseases</a>\n");
      out.write("                          \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div><div class =\"head\">\n");
      out.write("                    <span class=\"img1\" style=\"background: url(PIC/brain-and-head.png)\"></span>\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        <div class=\"dropbtn\">Doctor Types</div>\n");
      out.write("\n");
      out.write("                        <div class=\"dropdown-content\">\n");
      out.write("\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=7')\">Obstetrics & Gynecology</a>\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=8')\">Psychosis</a>\n");
      out.write("                         \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div><div class =\"head\">\n");
      out.write("                    <span class=\"img1\" style=\"background: url(PIC/brain-and-head.png)\"></span>\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        <div class=\"dropbtn\">Doctor Types</div>\n");
      out.write("\n");
      out.write("                        <div class=\"dropdown-content\">\n");
      out.write("\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=9')\">Dermatology</a>\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=10')\">Oncology</a>\n");
      out.write("                          \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div><div class =\"head\">\n");
      out.write("                    <span class=\"img1\" style=\"background: url(PIC/brain-and-head.png)\"></span>\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        <div class=\"dropbtn\">Doctor Types</div>\n");
      out.write("\n");
      out.write("                        <div class=\"dropdown-content\">\n");
      out.write("\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=11')\">Orthopedices</a>\n");
      out.write("                            <a href=\"#\" onclick=\"window.open('AccController?method=Match&pairing=true&MID=12')\">Andrology</a>\n");
      out.write("                           \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--footer start-->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/footer.jsp", out, false);
      out.write("\n");
      out.write("        <!--footer end-->\n");
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
