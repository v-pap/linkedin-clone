/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2018-09-20 11:24:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<title>WorkConnect - Log In</title>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/w3-theme-blue-grey.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/fonts/open_sans.ttf\" />\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/css/font-awesome.min.css\">\n");
      out.write("<style>\n");
      out.write("    html,\n");
      out.write("    body,\n");
      out.write("    h1,\n");
      out.write("    h2,\n");
      out.write("    h3,\n");
      out.write("    h4,\n");
      out.write("    h5 {\n");
      out.write("        font-family: \"Open Sans\", sans-serif\n");
      out.write("    }\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<body background=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/welcome.jpg\" class=\"w3-theme-l5\">\n");
      out.write("\n");
      out.write("    <!-- Page Container -->\n");
      out.write("    <div class=\"w3-container w3-content\" style=\"max-width:1400px;margin-top:160px\">\n");
      out.write("        <!-- The Grid -->\n");
      out.write("        <div class=\"w3-row\">\n");
      out.write("\n");
      out.write("            <!-- Left Column -->\n");
      out.write("            <div class=\"w3-col m8\">\n");
      out.write("                <h1 class=\"w3-outline\">WorkConnect</h1>\n");
      out.write("            </div>\n");
      out.write("            <!-- End Left Column -->\n");
      out.write("\n");
      out.write("            <!-- Middle Column -->\n");
      out.write("            <div class=\"w3-col m4\">\n");
      out.write("                <div class=\"w3-card w3-white\">\n");
      out.write("                    <div class=\"w3-container w3-padding\">\n");
      out.write("                    <form action=\"/LinkedInClone/UserServlet/login\" method=\"post\">\n");
      out.write("                        <table style=\"width:100%\">\n");
      out.write("                            <tr>\n");
      out.write("                                <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                                    <input id=\"email\" name=\"email\" type=\"email\" placeholder=\"Email\" onkeyup=\"check_form(this.id);\" class=\"w3-border w3-padding w3-margin-top\"\n");
      out.write("                                        style=\"width:100%;\" required/>\n");
      out.write("                                </div>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                                    <input id=\"password\" name=\"password\" type=\"password\" placeholder=\"Password\" onkeyup=\"check_form(this.id);\" class=\"w3-border w3-padding\" style=\"width:100%;\"\n");
      out.write("                                        required/>\n");
      out.write("                                </div>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <div class=\"w3-row w3-padding\">\n");
      out.write("                                        <button id=\"sign_in\" type=\"submit\" onclick=\"check_login();\" class=\"w3-button w3-theme-d2\">\n");
      out.write("                                            <i class=\"fa fa-sign-in\"></i> Log In</button>\n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input id=\"error_message\" class=\"w3-opacity-min\" type=\"text\" value=\"");
      out.print(request.getAttribute("error_message"));
      out.write("\" style=\"border: 0;background-color: inherit; color:red;font-weight: bold\"\n");
      out.write("                                        readonly>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr style=\"width: 200%\">\n");
      out.write("                                <td style=\"width: 200%\">\n");
      out.write("                                    <div class=\"w3-row w3-padding\" style=\"width: 200%\">\n");
      out.write("                                        Don't have an account?\n");
      out.write("                                        <a href=\"RegisterServlet\">Register here.</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- End Middle Column -->\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- End Grid -->\n");
      out.write("    </div>\n");
      out.write("    <!-- End Page Container -->\n");
      out.write("    </div>\n");
      out.write("    <br>\n");
      out.write("    <!-- Footer -->\n");
      out.write("    <footer class=\"w3-container w3-theme-d5 w3-bottom\">\n");
      out.write("        <table class=\"w3-opacity-min\" style=\"width:100%\">\n");
      out.write("            <td style=\"text-align: left;\">\n");
      out.write("                <h5>WorkConnect</h5>\n");
      out.write("            </td>\n");
      out.write("            <td style=\"text-align: left;\">\n");
      out.write("                <a href=\"AdministratorServlet\" class=\"w3-link\">Login as Admin</a>\n");
      out.write("            </td>\n");
      out.write("            <td style=\"width:85%; text-align: right;\">\n");
      out.write("                <p>Made by Vasileios Papavasileiou & Vasileios Sakkas - Powered by\n");
      out.write("                    <a href=\"https://www.w3schools.com/w3css/default.asp\" target=\"_blank\">w3.css</a>\n");
      out.write("                </p>\n");
      out.write("            </td>\n");
      out.write("        </table>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        // Used to toggle the menu on smaller screens when clicking on the menu button\n");
      out.write("        function openNav() {\n");
      out.write("            var x = document.getElementById(\"navDemo\");\n");
      out.write("            if (x.className.indexOf(\"w3-show\") == -1) {\n");
      out.write("                x.className += \" w3-show\";\n");
      out.write("            } else {\n");
      out.write("                x.className = x.className.replace(\" w3-show\", \"\");\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function check_form(id) {\n");
      out.write("            document.getElementById(id).setCustomValidity(\"\");\n");
      out.write("            if (document.getElementById(id).checkValidity() == false) {\n");
      out.write("                document.getElementById(id).setCustomValidity(\"Invalid field.\");\n");
      out.write("                if (id == \"email\") {\n");
      out.write("                    document.getElementById('error_message').value = \"Invalid email.\";\n");
      out.write("                }\n");
      out.write("                else {\n");
      out.write("                    document.getElementById('error_message').value = \"Missing required fields.\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            else {\n");
      out.write("                document.getElementById(id).setCustomValidity(\"\");\n");
      out.write("                document.getElementById('error_message').value = \"\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function check_login() {\n");
      out.write("            var error = false;\n");
      out.write("            if (document.getElementById('email').value == \"\") {\n");
      out.write("                document.getElementById('email').setCustomValidity(\"Invalid field.\");\n");
      out.write("                document.getElementById('error_message').value = \"Missing required fields.\";\n");
      out.write("                error = true;\n");
      out.write("            }\n");
      out.write("            else if (document.getElementById('email').checkValidity() == false) {\n");
      out.write("                document.getElementById('email').setCustomValidity(\"Invalid field.\");\n");
      out.write("                document.getElementById('error_message').value = \"Invalid email.\";\n");
      out.write("                error = true;\n");
      out.write("            }\n");
      out.write("            else {\n");
      out.write("                document.getElementById('email').setCustomValidity(\"\");\n");
      out.write("            }\n");
      out.write("            if (document.getElementById('password').value == \"\") {\n");
      out.write("                document.getElementById('password').setCustomValidity(\"Invalid field.\");\n");
      out.write("                document.getElementById('error_message').value = \"Missing required fields.\";\n");
      out.write("                error = true;\n");
      out.write("            }\n");
      out.write("            else {\n");
      out.write("                document.getElementById('password').setCustomValidity(\"\");\n");
      out.write("            }\n");
      out.write("            if (error == false) {\n");
      out.write("                document.getElementById('error_message').value = \"\";\n");
      out.write("                location.href = \"home.html\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
