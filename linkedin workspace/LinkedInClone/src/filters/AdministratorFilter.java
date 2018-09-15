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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Administrator;

/**
 * Servlet Filter implementation class UrlRewriteFilter
 */
@WebFilter(urlPatterns = {"/AdministratorServlet/logout","/AdministratorServlet"})
public class AdministratorFilter implements Filter
{

    /**
     * Default constructor. 
     */
    public AdministratorFilter()
    {
        // TODO Auto-generated constructor stub
    	System.out.println("Administrator Filter Deployed");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;                
        res.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        res.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        res.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        res.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
        chain.doFilter(req, res);
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		// TODO Auto-generated method stub
	}

}