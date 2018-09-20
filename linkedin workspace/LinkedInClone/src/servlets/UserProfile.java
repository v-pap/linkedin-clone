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
import helper.ProfessionalInfo;
import model.Professional;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		HttpSession session = request.getSession(true);
	
		Professional prof = (Professional) session.getAttribute("prof");
        if (prof != null)
        {   
        	ProfessionalInfo profInfo = refreshProfile(request,response);
        	if(profInfo.getProf() != null)
        	{
        		session.setAttribute("prof",profInfo.getProf());
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/profile.jsp");  
                rd.forward(request, response);
        	}
        	else
        	{
        		response.sendRedirect("/LinkedInClone/UserServlet");
        	}
        }
        else
        {
        	response.sendRedirect("/LinkedInClone/UserServlet");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private ProfessionalInfo refreshProfile(HttpServletRequest request,
            HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
        return dao.refreshProfile(prof);
    }
}
