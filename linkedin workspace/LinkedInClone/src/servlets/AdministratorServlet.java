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

import model.Administrator;
import model.Professional;
import dao.AdministratorDAOImpl;
import dao.AdministratorDAO;
import dao.ProfessionalDAOImpl;
import dao.ProfessionalDAO;
import helper.AdministratorInfo;

/**
 * Servlet implementation class AdministratorServlet
 */
@WebServlet(urlPatterns = {"/AdministratorServlet", "/AdministratorServlet/logout"})
public class AdministratorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestURI = request.getRequestURI();
		if(requestURI.endsWith("logout"))
		{
			HttpSession session = request.getSession(false);
			if(session != null)
			{
			    session.removeAttribute("admin");
			    session.invalidate();
			}
			response.sendRedirect("/LinkedInClone/AdministratorServlet");
			return;
		}
		
		HttpSession session = request.getSession(true);
	
		Administrator admin = (Administrator) session.getAttribute("admin");
        if (admin != null)
        {
             List<Professional> profs = getAllProfessionals(request, response);
             request.setAttribute("profs", profs);
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/admin_page.jsp");  
             rd.forward(request, response);
        }
        else
        {
        	request.setAttribute("error_message","");
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/login.jsp");  
            rd.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        AdministratorInfo adminInfo = login(request, response);
        Administrator admin = adminInfo.getAdmin();
        if (admin != null)
        {
             HttpSession session = request.getSession(true);       
             session.setAttribute("admin",admin);
             List<Professional> profs = getAllProfessionals(request, response);
             request.setAttribute("profs", profs);
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/admin_page.jsp");  
             rd.forward(request, response);
        }
        else
        {
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/login.jsp");
        	request.setAttribute("error_message", adminInfo.getError());
            rd.forward(request, response);
        }
	}
	
	private AdministratorInfo login(HttpServletRequest request,
            HttpServletResponse response)
	{
	 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AdministratorDAO dao = new AdministratorDAOImpl();
        return dao.login(email,password);
    }
	
	private List<Professional> getAllProfessionals(HttpServletRequest request,
            HttpServletResponse response)
	{
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		List<Professional> profs = dao.list();
        return profs;
    }

}
