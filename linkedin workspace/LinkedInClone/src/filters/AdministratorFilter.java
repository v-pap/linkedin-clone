package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Administrator;

/**
 * Servlet Filter implementation class UrlRewriteFilter
 */
@WebFilter("/admin/*")
//urlPatterns = {"/LinkedInClone/login","/LinkedInClone/login_error"}
public class AdministratorFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdministratorFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false); //its false so it doesn't autocreate sessions
        
        Administrator admin;
        
        chain.doFilter(req, res);
        return;
        /*
        System.out.println(requestURI);
        
        if(requestURI.endsWith(".css") || requestURI.endsWith(".ttf") ||
        		requestURI.endsWith(".woff") || requestURI.endsWith(".woff2"))
        {
        	chain.doFilter(req, res);
        	return;
        }
        
        chain.doFilter(req, res);
        
        /*if (session != null) {
        	admin = (Administrator) session.getAttribute("admin");
        	if(admin != null)
        	{
	        	if(requestURI.endsWith("/LinkedInClone/admin/login.jsp") ||
    	    	requestURI.endsWith("/LinkedInClone/admin/login_error.jsp"))
    	        {
	        		//RequestDispatcher rd = request.getRequestDispatcher("/AdministratorServlet");  
	                //rd.forward(request, response);
    	        	//res.sendRedirect("/LinkedInClone/admin/admin_page.jsp");
	        		((HttpServletResponse) response).sendRedirect("/LinkedInClone/AdministratorServlet");
    	        	return;
    	        }
	        	chain.doFilter(req, res);
	        	return;
	        	//session.invalidate();
        	}
        }
        if(!requestURI.endsWith("/LinkedInClone/admin/login.jsp") &&
    	!requestURI.endsWith("/LinkedInClone/admin/login_error.jsp"))
        {
        	res.sendRedirect("/LinkedInClone/admin/login.jsp");
        	return;
        }
        chain.doFilter(req, res);*/
	}
	/*if(!requestURI.endsWith("/LinkedInClone/admin/login.jsp") &&
    	!requestURI.endsWith("/LinkedInClone/admin/login_error.jsp"))
        {*/

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
