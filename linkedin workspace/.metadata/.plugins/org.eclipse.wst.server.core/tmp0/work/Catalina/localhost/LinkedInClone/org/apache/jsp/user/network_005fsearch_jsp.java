/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2018-09-29 17:15:07 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class network_005fsearch_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1534674664000L));
    _jspx_dependants.put("jar:file:/home/bill/Desktop/linkedin%20workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/LinkedInClone/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153374282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<title>WorkConnect - Network</title>\n");
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
      out.write("            <a href=\"/LinkedInClone/UserNotifications\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-bell\"></i>\n");
      out.write("                Notifications\n");
      out.write("            </a>\n");
      out.write("            <a href=\"/LinkedInClone/UserMessages\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-envelope\"></i>\n");
      out.write("                Messages\n");
      out.write("            </a>\n");
      out.write("            <a href=\"/LinkedInClone/UserJobs\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
      out.write("                <i class=\"fa fa-list\"></i>\n");
      out.write("                Jobs\n");
      out.write("            </a>\n");
      out.write("            <a href=\"/LinkedInClone/UserNetwork\" class=\"w3-bar-item w3-button w3-hide-small w3-right w3-padding-large\">\n");
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
      out.write("        <a href=\"/LinkedInClone/UserNetwork\" class=\"w3-bar-item w3-button w3-padding-large\">Network</a>\n");
      out.write("        <a href=\"/LinkedInClone/UserJobs\" class=\"w3-bar-item w3-button w3-padding-large\">Jobs</a>\n");
      out.write("        <a href=\"/LinkedInClone/UserMessages\" class=\"w3-bar-item w3-button w3-padding-large\">Messages</a>\n");
      out.write("        <a href=\"/LinkedInClone/UserNotifications\" class=\"w3-bar-item w3-button w3-padding-large\">Notifications</a>\n");
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
      out.write("                <div class=\"w3-row-padding\">\n");
      out.write("                    <div class=\"w3-col m12\">\n");
      out.write("                        <div class=\"w3-card w3-white\">\n");
      out.write("                            <div class=\"w3-container w3-padding\">\n");
      out.write("                                <div class=\"w3-padding-8\">\n");
      out.write("                                <form action=\"/LinkedInClone/UserNetwork\" method=\"post\">\n");
      out.write("                                    <table style=\"width:100%\">\n");
      out.write("                                        <td style=\"width:100%\">\n");
      out.write("                                            <input name=\"search\" id=\"search\" type=\"text\" placeholder=\"Search\" class=\"w3-border w3-padding\" style=\"width:100%;\" />\n");
      out.write("                                        </td>\n");
      out.write("                                        <td style=\"width:100%\">\n");
      out.write("                                            <button type=\"submit\" onclick=\"check_search();\" class=\"w3-button w3-theme-d2\">\n");
      out.write("                                                <i class=\"fa fa-search\"></i> Search</button>\n");
      out.write("                                        </td>\n");
      out.write("                                    </table>\n");
      out.write("                                </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
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
      out.write("    <br>\n");
      out.write("    <br>\n");
      out.write("    <!-- Footer -->\n");
      out.write("    <footer class=\"w3-container w3-theme-d5\">\n");
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
      out.write("        function check_search() {\n");
      out.write("            if (document.getElementById('search').value == \"\") {\n");
      out.write("                ;\n");
      out.write("            }\n");
      out.write("            else {\n");
      out.write("                location.href = \"network_search.html\";\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /user/network_search.jsp(111,5) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/user/network_search.jsp(111,5) '${profs_search}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${profs_search}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /user/network_search.jsp(111,5) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("prof_result");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t                <div class=\"w3-container w3-card w3-white w3-margin\">\n");
          out.write("\t\t                    <table style=\"width: 100%\">\n");
          out.write("\t\t                        <td>\n");
          out.write("\t\t                            <p class=\"w3-center\">\n");
          out.write("\t\t                                <a href=\"/LinkedInClone/ViewProfileServlet?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prof_result.getId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("\t\t                                    <img src=\"/LinkedInClone/ImageServlet?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prof_result.getPath()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" class=\"w3-round-large\" style=\"height:116px;width:116px\" alt=\"Avatar\">\n");
          out.write("\t\t                                </a>\n");
          out.write("\t\t                            </p>\n");
          out.write("\t\t                        </td>\n");
          out.write("\t\t                        <td class=\"w3-padding\">\n");
          out.write("\t\t                            <h4 class=\"w3-center\"><a href=\"/LinkedInClone/ViewProfileServlet?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prof_result.getId()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("\" class=\"w3-link\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prof_result.getName()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write(' ');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prof_result.getSurname()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</a></h4>\n");
          out.write("\t\t                        </td>\n");
          out.write("\t\t                        <td>\n");
          out.write("\t\t                            <p>\n");
          out.write("\t\t                                <i class=\"fa fa-pencil fa-fw w3-margin-right w3-text-theme\"></i> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prof_result.getJobTitle()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("\t\t                        </td>\n");
          out.write("\t\t                        <td>\n");
          out.write("\t\t                            <p>\n");
          out.write("\t\t                                <i class=\"fa fa-envelope-open\"></i> Email: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prof_result.getEmail()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("\t\t                            <p>\n");
          out.write("\t\t                                <i class=\"fa fa-phone\"></i> Phone: ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${prof_result.getTelephone()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("\t\t                            </p>\n");
          out.write("\t\t                        </td>\n");
          out.write("\t\t                    </table>\n");
          out.write("\t\t                </div>\n");
          out.write("\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
