/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2018-09-19 20:41:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class settings_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>WorkConnect - Settings</title>\n");
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
      out.write("<body class=\"w3-theme-l5\">\n");
      out.write("    <!-- Navbar -->\n");
      out.write("    <div class=\"w3-top\">\n");
      out.write("        <div class=\"w3-bar w3-theme-d3 w3-left-align w3-large\">\n");
      out.write("            <a class=\"w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-large\" href=\"javascript:void(0);\"\n");
      out.write("                onclick=\"openNav()\">\n");
      out.write("                <i class=\"fa fa-bars\"></i>\n");
      out.write("            </a>\n");
      out.write("            <a href=\"/LinkedInClone/UserServlet\" class=\"w3-bar-item w3-button w3-padding-large\">\n");
      out.write("\n");
      out.write("                WorkConnect\n");
      out.write("            </a>\n");
      out.write("            <a href=\"/LinkedInClone/UserServlet/logout\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-sign-out\"></i>\n");
      out.write("                Log Out\n");
      out.write("            </a>\n");
      out.write("            <a href=\"/LinkedInClone/UserSettings\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-gear\"></i>\n");
      out.write("                Settings\n");
      out.write("            </a>\n");
      out.write("            <a href=\"/LinkedInClone/UserProfile\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-user\"></i>\n");
      out.write("                My Profile\n");
      out.write("            </a>\n");
      out.write("            <a href=\"notifications.html\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-bell\"></i>\n");
      out.write("                Notifications\n");
      out.write("            </a>\n");
      out.write("            <a href=\"messages.html\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-envelope\"></i>\n");
      out.write("                Messages\n");
      out.write("            </a>\n");
      out.write("            <a href=\"jobs.html\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-list\"></i>\n");
      out.write("                Jobs\n");
      out.write("            </a>\n");
      out.write("            <a href=\"network.html\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-globe\"></i>\n");
      out.write("                Network\n");
      out.write("            </a>\n");
      out.write("            <a href=\"/LinkedInClone/UserServlet\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-home\"></i>\n");
      out.write("                Home\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Navbar on small screens -->\n");
      out.write("    <div id=\"navDemo\" class=\"w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large\">\n");
      out.write("        <a href=\"/LinkedInClone/UserServlet\" class=\"w3-bar-item w3-button w3-padding-large\">Home</a>\n");
      out.write("        <a href=\"network.html\" class=\"w3-bar-item w3-button w3-padding-large\">Network</a>\n");
      out.write("        <a href=\"jobs.html\" class=\"w3-bar-item w3-button w3-padding-large\">Jobs</a>\n");
      out.write("        <a href=\"messages.html\" class=\"w3-bar-item w3-button w3-padding-large\">Messages</a>\n");
      out.write("        <a href=\"notifications.html\" class=\"w3-bar-item w3-button w3-padding-large\">Notifications</a>\n");
      out.write("        <a href=\"/LinkedInClone/UserProfile\" class=\"w3-bar-item w3-button w3-padding-large\">My Profile</a>\n");
      out.write("        <a href=\"/LinkedInClone/UserSettings\" class=\"w3-bar-item w3-button w3-padding-large\">Settings</a>\n");
      out.write("        <a href=\"/LinkedInClone/UserServlet/logout\" class=\"w3-bar-item w3-button w3-padding-large\">Log Out</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Page Container -->\n");
      out.write("    <div class=\"w3-container w3-content\" style=\"max-width:66.%;margin-top:80px\">\n");
      out.write("        <!-- The Grid -->\n");
      out.write("        <div class=\"w3-row\">\n");
      out.write("\n");
      out.write("            <!-- Middle Column -->\n");
      out.write("            <div class=\"w3-col\">\n");
      out.write("\t\t\t\t<form action=\"/LinkedInClone/UserSettings/email\" method=\"post\">\n");
      out.write("                <div class=\"w3-container w3-card w3-white w3-margin\">\n");
      out.write("                    <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                        <h4>Email</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                        <input id=\"e_email\" name=\"e_email\" type=\"email\" placeholder=\"New Email\" onkeyup=\"check_e_form(this.id);\" class=\"w3-border w3-padding\" style=\"width:100%;\"\n");
      out.write("                            required/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                        <input id=\"e_password\" name=\"e_password\" type=\"password\" placeholder=\"Confirm Password\" onkeyup=\"check_e_form(this.id);\" class=\"w3-border w3-padding\"\n");
      out.write("                            style=\"width:100%;\" required/>\n");
      out.write("                    </div>\n");
      out.write("                    <table>\n");
      out.write("                        <td>\n");
      out.write("                            <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                                <button type=\"submit\" onclick=\"check_e_change();\" class=\"w3-button w3-theme-d2 w3-margin-bottom\">\n");
      out.write("                                    <i class=\"fa fa-edit\"></i> Change</button>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <input id=\"e_error_message\" class=\"w3-opacity-min\" type=\"text\" value=\"");
      out.print(request.getAttribute("e_error_message"));
      out.write("\" style=\"border: 0;background-color: inherit; color:");
      out.print(request.getAttribute("e_color"));
      out.write(";font-weight: bold\"\n");
      out.write("                                readonly>\n");
      out.write("                        </td>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                </form>\n");
      out.write("                <form action=\"/LinkedInClone/UserSettings/password\" method=\"post\">\n");
      out.write("                <div class=\"w3-container w3-card w3-white w3-margin\">\n");
      out.write("                    <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                        <h4>Password</h4>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                        <input id=\"p_password\" name=\"p_password\" type=\"password\" placeholder=\"New Password\" onkeyup=\"check_p_form(this.id);comparePasswords();\" class=\"w3-border w3-padding\"\n");
      out.write("                            style=\"width:100%;\" required/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                        <input id=\"p_new_password\" name=\"p_new_password\" type=\"password\" placeholder=\"Confirm New Password\" onkeyup=\"check_p_form(this.id);comparePasswords();\"\n");
      out.write("                            class=\"w3-border w3-padding\" style=\"width:100%;\" required/>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                        <input id=\"p_c_password\" name=\"p_c_password\" type=\"password\" placeholder=\"Confirm Current Password\" onkeyup=\"check_p_form(this.id);\"\n");
      out.write("                            class=\"w3-border w3-padding\" style=\"width:100%;\" required/>\n");
      out.write("                    </div>\n");
      out.write("                    <table>\n");
      out.write("                        <td>\n");
      out.write("                            <div class=\"w3-row w3-padding\" style=\"width:100%;\">\n");
      out.write("                                <button type=\"submit\" onclick=\"check_p_change();\" class=\"w3-button w3-theme-d2 w3-margin-bottom\">\n");
      out.write("                                    <i class=\"fa fa-edit\"></i> Change</button>\n");
      out.write("                            </div>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <input id=\"p_error_message\" class=\"w3-opacity-min\" type=\"text\" value=\"");
      out.print(request.getAttribute("p_error_message"));
      out.write("\" style=\"border: 0;background-color: inherit; color:");
      out.print(request.getAttribute("p_color"));
      out.write(";font-weight: bold\"\n");
      out.write("                                readonly>\n");
      out.write("                        </td>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            \t</form>\n");
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
      out.write("            <td>\n");
      out.write("                <h5>WorkConnect</h5>\n");
      out.write("            </td>\n");
      out.write("            <td style=\"float:right\">\n");
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
      out.write("        function check_p_form(id) {\n");
      out.write("            document.getElementById(id).setCustomValidity(\"\");\n");
      out.write("            if (document.getElementById(id).checkValidity() == false) {\n");
      out.write("                document.getElementById(id).setCustomValidity(\"Invalid field.\");\n");
      out.write("                document.getElementById('p_error_message').value = \"Missing required fields.\";\n");
      out.write("            }\n");
      out.write("            else {\n");
      out.write("                document.getElementById(id).setCustomValidity(\"\");\n");
      out.write("                document.getElementById('p_error_message').value = \"\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function check_e_form(id) {\n");
      out.write("            document.getElementById(id).setCustomValidity(\"\");\n");
      out.write("            if (document.getElementById(id).checkValidity() == false) {\n");
      out.write("                document.getElementById(id).setCustomValidity(\"Invalid field.\");\n");
      out.write("                if (id == \"e_email\") {\n");
      out.write("                    document.getElementById('e_error_message').value = \"Invalid email.\";\n");
      out.write("                }\n");
      out.write("                else {\n");
      out.write("                    document.getElementById('e_error_message').value = \"Missing required fields.\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            else {\n");
      out.write("                document.getElementById(id).setCustomValidity(\"\");\n");
      out.write("                document.getElementById('e_error_message').value = \"\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function comparePasswords() {\n");
      out.write("            if ((document.getElementById('p_password').value != \"\" &&\n");
      out.write("                document.getElementById('p_new_password').value != \"\") &&\n");
      out.write("                (document.getElementById('p_password').value ==\n");
      out.write("                    document.getElementById('p_new_password').value)) {\n");
      out.write("                document.getElementById('p_password').setCustomValidity(\"\");\n");
      out.write("                document.getElementById('p_new_password').setCustomValidity(\"\");\n");
      out.write("                return true;\n");
      out.write("            } else {\n");
      out.write("                document.getElementById('p_password').setCustomValidity(\"Invalid field.\");\n");
      out.write("                document.getElementById('p_new_password').setCustomValidity(\"Invalid field.\");\n");
      out.write("                document.getElementById('p_error_message').value = \"Passwords not matching.\";\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function check_e_change() {\n");
      out.write("            var error = false;\n");
      out.write("            if (document.getElementById('e_email').value == \"\") {\n");
      out.write("                document.getElementById('e_email').setCustomValidity(\"Invalid field.\");\n");
      out.write("                document.getElementById('e_error_message').value = \"Missing required fields.\";\n");
      out.write("                error = true;\n");
      out.write("            }\n");
      out.write("            else {\n");
      out.write("                document.getElementById('e_mail').setCustomValidity(\"\");\n");
      out.write("            }\n");
      out.write("            if (document.getElementById('e_password').value == \"\") {\n");
      out.write("                document.getElementById('e_password').setCustomValidity(\"Invalid field.\");\n");
      out.write("                document.getElementById('e_error_message').value = \"Missing required fields.\";\n");
      out.write("                error = true;\n");
      out.write("            }\n");
      out.write("            else {\n");
      out.write("                document.getElementById().setCustomValidity(\"\");\n");
      out.write("            }\n");
      out.write("            if (error == false) {\n");
      out.write("                document.getElementById('e_error_message').value = \"\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function check_p_change() {\n");
      out.write("            var error = false, id_arr = [\"p_password\", \"p_new_password\", \"p_c_password\"];\n");
      out.write("            for (var i = 0; i < id_arr.length; i++) {\n");
      out.write("                if (document.getElementById(id_arr[i]).value == \"\") {\n");
      out.write("                    document.getElementById(id_arr[i]).setCustomValidity(\"Invalid field.\");\n");
      out.write("                    document.getElementById('p_error_message').value = \"Missing required fields.\";\n");
      out.write("                    error = true;\n");
      out.write("                }\n");
      out.write("                else {\n");
      out.write("                    document.getElementById(id_arr[i]).setCustomValidity(\"\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            if (comparePasswords() == false) {\n");
      out.write("                error = true;\n");
      out.write("            }\n");
      out.write("            if (error == false) {\n");
      out.write("                document.getElementById('p_error_message').value = \"\";\n");
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
