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

/**
 * Servlet implementation class AdministratorServlet
 */
@WebServlet(urlPatterns = {"/AdministratorServlet", "/AdministratorServlet/logout", "/AdministratorServlet/login"})
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String requestURI = request.getRequestURI();
		//RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/login.jsp");  

		//rd.forward(request, response);
		if(requestURI.endsWith("logout"))
		{
			HttpSession session = request.getSession(false);
			if(session != null)
			    session.invalidate();
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
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/login.jsp");  
            rd.forward(request, response);
        	//response.sendRedirect("admin/login.jsp");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
        String url = "";
        if (requestURI.endsWith("login")) {
            Administrator admin = login(request, response);
            if (admin != null)
            {
                  
                 HttpSession session = request.getSession(true);       
                 session.setAttribute("admin",admin);
                 //response.sendRedirect("admin/admin_page.jsp"); //logged-in page
                 List<Professional> profs = getAllProfessionals(request, response);
                 request.setAttribute("profs", profs);
                 
                 RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/admin_page.jsp");  
                 rd.forward(request, response);
            }
            else
            {
            	//TO DO ERROR PAGE
            	//response.sendRedirect("admin/login_error.jsp"); //error page 
            }
        }
        //getServletContext()
        //        .getRequestDispatcher(url)
        //        .forward(request, response);
	}
	
	private Administrator login(HttpServletRequest request,
            HttpServletResponse response) {
	 
	 	//HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AdministratorDAO dao = new AdministratorDAOImpl();

        Administrator admin = dao.login(email,password);
        return admin;
    }
	
	private List<Professional> getAllProfessionals(HttpServletRequest request,
            HttpServletResponse response) {
	 
	 	//HttpSession session = request.getSession();

        ProfessionalDAO dao = new ProfessionalDAOImpl();

		List<Professional> profs = dao.list();
        return profs;
    }

}
