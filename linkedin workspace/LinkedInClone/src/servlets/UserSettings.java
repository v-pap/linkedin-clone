package servlets;

import java.io.IOException;

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
 * Servlet implementation class UserSettings
 */
@WebServlet(urlPatterns = {"/UserSettings", "/UserSettings/email", "/UserSettings/password"})
public class UserSettings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSettings() {
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
			request.setAttribute("e_error_message","");
			request.setAttribute("e_color", "red");
			request.setAttribute("p_error_message","");
			request.setAttribute("p_color", "red");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/settings.jsp");  
            rd.forward(request, response);
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
		
		HttpSession session = request.getSession(true);
		
		Professional prof = (Professional) session.getAttribute("prof");
		if(prof != null)
		{
			if(requestURI.endsWith("email"))
			{
				ProfessionalInfo profInfo = changeEmail(request, response);
				Professional result = profInfo.getProf();
				if(result == null)
				{
					request.setAttribute("e_error_message",profInfo.getError());
					request.setAttribute("e_color", "red");
					request.setAttribute("p_error_message","");
					request.setAttribute("p_color", "red");
		        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/settings.jsp");  
		            rd.forward(request, response);
				}
				else
				{
					session.setAttribute("prof",result);
					request.setAttribute("e_error_message","Success");
					request.setAttribute("e_color", "green");
					request.setAttribute("p_error_message","");
					request.setAttribute("p_color", "red");
		        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/settings.jsp");  
		            rd.forward(request, response);
				}
			}
			else if(requestURI.endsWith("password"))
			{
				ProfessionalInfo profInfo = changePassword(request, response);
				Professional result = profInfo.getProf();
				if(result == null)
				{
					request.setAttribute("e_error_message","");
					request.setAttribute("e_color", "red");
					request.setAttribute("p_error_message",profInfo.getError());
					request.setAttribute("p_color", "red");
		        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/settings.jsp");  
		            rd.forward(request, response);
				}
				else
				{
					session.setAttribute("prof",result);
					request.setAttribute("e_error_message","");
					request.setAttribute("e_color", "red");
					request.setAttribute("p_error_message","Success");
					request.setAttribute("p_color", "green");
		        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/settings.jsp");  
		            rd.forward(request, response);
				}
			}
		}
		else
		{
			request.setAttribute("error_message","");
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");  
            rd.forward(request, response);
		}
	}
		
	private ProfessionalInfo changeEmail(HttpServletRequest request,
            HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
        String newEmail = request.getParameter("e_email");
        String confirmPassword = request.getParameter("e_password");
        if(!prof.getPassword().equals(confirmPassword)) return new ProfessionalInfo(null, "Wrong password");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
        return dao.changeEmail(newEmail, prof);
    }
	
	private ProfessionalInfo changePassword(HttpServletRequest request,
            HttpServletResponse response)
	{
		//TODO
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
        String newPassword = request.getParameter("p_password");
        String currentPassword = request.getParameter("p_c_password");
        if(!prof.getPassword().equals(currentPassword)) return new ProfessionalInfo(null, "Wrong password");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
        return dao.changePassword(newPassword, prof);
    }

}
