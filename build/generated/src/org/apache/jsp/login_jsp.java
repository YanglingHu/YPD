package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login to YPD--</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/login.css\" type=\"text/css\">\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/common_source.jsp", out, false);
      out.write("\n");
      out.write("        <script src=\"js/Tips.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sub_elements/header.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"Main\">\n");
      out.write("                <div class=\"BG-wrapper\">\n");
      out.write("                    <div class=\"login-theme\">\n");
      out.write("                        <div>\n");
      out.write("                            <!--tab section 1-->\n");
      out.write("                            <input type=\"radio\" name=\"tab-radio\" class=\"tab-radio\" id=\"tab-radio-1\" checked>\n");
      out.write("                            <label for=\"tab-radio-1\" class=\"tab-handler tab-handler-1\">SignIn</label>\n");
      out.write("                            <div class=\"tab-content tab-content-1\">\n");
      out.write("                                <td align=\"center\">\n");
      out.write("                                    <form action=\"AccController\" method=\"Post\" id=\"form-Login\">\n");
      out.write("                                            <b>Username：</b></br>\n");
      out.write("                                        <input id=\"username_signIn\" name=\"username\" type=\"text\" /></br>\n");
      out.write("                                            <b>Password：</b></br>\n");
      out.write("                                        <input id=\"password_signIn\" name=\"password\" type=\"password\" /><p>\n");
      out.write("                                        <input type =\"hidden\" name=\"method\" value=\"SignIn\"/>\n");
      out.write("                                        <p align=\"center\">\n");
      out.write("                                            <button id=\"button_signIn\" type=\"button\" class=\"btn btn-sm btn-primary\" >SignIn</button>\n");
      out.write("                                        </p>\n");
      out.write("                                        <p id=\"Error_signIn\" style=\"color: red\"></p>\n");
      out.write("                                    </form>\n");
      out.write("                                </td>\n");
      out.write("                            </div>\n");
      out.write("                            <!--tab section 2-->\n");
      out.write("                            <input type=\"radio\" name=\"tab-radio\" class=\"tab-radio\" id=\"tab-radio-2\">\n");
      out.write("                            <label for=\"tab-radio-2\" class=\"tab-handler tab-handler-2\">SignUp</label>\n");
      out.write("                            <div class=\"tab-content tab-content-2\">\n");
      out.write("                                <td align=\"center\">\n");
      out.write("                                    <form action=\"AccController\" method=\"Post\" id=\"form-signUp\">\n");
      out.write("                                            <b>Username：</b></br>\n");
      out.write("                                        <input id=\"username_signUp\"  name=\"username\" type=\"text\" /></br>\n");
      out.write("                                            <b>Password：</b></br>\n");
      out.write("                                        <input id=\"passwd_signUp\" name=\"password\" type=\"password\"/></br>\n");
      out.write("                                            <b>Check-pw：</b></br>\n");
      out.write("                                        <input id=\"repassword_signUp\" type=\"password\" /><p>\n");
      out.write("                                        <input type =\"hidden\" name=\"method\" value=\"SignUp\"/>\n");
      out.write("                                        <p align=\"center\">\n");
      out.write("                                            <button id=\"button_signUp\" type=\"button\" class=\"btn btn-sm btn-primary\" >SignUp</button>\n");
      out.write("                                        </p>\n");
      out.write("                                        <p id=\"Error_signUp\" style=\"color: red\"></p>\n");
      out.write("                                    </form>\n");
      out.write("                                </td>\n");
      out.write("                                <p class=\"\" style=\"float: right\"><a href=\"#\" data-toggle=\"modal\" data-target=\"#signUpDoctor\">I'm a doctor</a></p>\n");
      out.write("                            </div>   \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Modal -->\n");
      out.write("            <div class=\"modal fade\" id=\"signUpDoctor\" aria-hidden=\"true\" data-backdrop=\"static\">\n");
      out.write("                <div class=\"modal-dialog modal-dialog-centered\">\n");
      out.write("                    <div class=\"modal-content\">\n");
      out.write("                        <div class=\"modal-header\">\n");
      out.write("                            <h5 class=\"modal-title\">Be a member of us</h5>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-body\">\n");
      out.write("                            <div class=\"col-8 mx-auto text-center\">\n");
      out.write("                                <form id=\"modal-form-doctor\" action=\"AccController\" method=\"Post\">\n");
      out.write("                                    <b>Username：</b></br>\n");
      out.write("                                <input id=\"username_signUpD\" name=\"username\" type=\"text\" /></br>\n");
      out.write("                                    <b>Password：</b></br>\n");
      out.write("                                <input id=\"passwdD_signUpD\" name=\"password\" type=\"password\"/></br>\n");
      out.write("                                    <b>Check-pw：</b></br>\n");
      out.write("                                <input id=\"repasswd_signUpD\" type=\"password\" /></br>\n");
      out.write("                                    <b>Your First Name：</b></br>\n");
      out.write("                                <input id = \"firstname_signUpD\" name=\"firstname\" type=\"text\" onkeyup=\"this.value=this.value.replace(/[^a-zA-Z]/g,'')\"/></br>\n");
      out.write("                                    <b>Your NPI license：</b></br>\n");
      out.write("                                <input id = \"license_signUpD\" name=\"NPI\" type=\"tel\" onkeyup=\"this.value=this.value.replace(/\\D/g,'')\"/><p>\n");
      out.write("                                <input type =\"hidden\" name=\"method\" value=\"SignUp\"/>\n");
      out.write("                                 <p id=\"Error_signUpD\" style=\"color: red\"></p>\n");
      out.write("                            </form>\n");
      out.write("                            \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"modal-footer\">\n");
      out.write("                            <button id=\"button_signUpD\" type=\"button\" class=\"btn btn-sm btn-primary\">SignUp</button>\n");
      out.write("                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
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
