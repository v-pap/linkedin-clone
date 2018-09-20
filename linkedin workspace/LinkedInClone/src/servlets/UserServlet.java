package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfessionalDAO;
import dao.ProfessionalDAOImpl;
import model.Professional;
import helper.ProfessionalInfo;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns = {"/UserServlet", "/UserServlet/logout", "/UserServlet/login"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestURI = request.getRequestURI();
		
		HttpSession session = request.getSession(true);
	
		Professional prof = (Professional) session.getAttribute("prof");
        if (prof != null)
        {
        	if(requestURI.endsWith("logout"))
    		{
    			if(session != null)
    			{
    			    session.removeAttribute("prof");
    			    session.invalidate();
    			}
    			response.sendRedirect("/LinkedInClone/UserServlet");
    		}
    		else
    		{
    			RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/home.jsp");  
                rd.forward(request, response);
    		}
        }
        else
        {
        	request.setAttribute("error_message","");
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");  
            rd.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestURI = request.getRequestURI();
		
		if(requestURI.endsWith("login"))
		{
			ProfessionalInfo profInfo = login(request, response);
			Professional prof = profInfo.getProf();
			if (prof != null)
	        {
	             HttpSession session = request.getSession(true);       
	             session.setAttribute("prof",prof);
	             RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/home.jsp");  
	             rd.forward(request, response);
	        }
	        else
	        {
	        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
	        	request.setAttribute("error_message", profInfo.getError());
	            rd.forward(request, response);
	        }
		}
	}
	
	private ProfessionalInfo login(HttpServletRequest request,
            HttpServletResponse response)
	{
	 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
        return dao.login(email,password);
    }

}
