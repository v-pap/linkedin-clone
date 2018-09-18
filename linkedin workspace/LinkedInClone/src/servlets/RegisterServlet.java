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
import dao.ProfessionalDAOImpl;
import helper.ProfessionalInfo;
import dao.ProfessionalDAO;

/**
 * Servlet implementation class AdministratorServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
             RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserServlet");  
             rd.forward(request, response);
        }
        else
        {
        	request.setAttribute("error_message","");
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/register.jsp");  
            rd.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
		
        if (prof != null)
        {
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserServlet");  
            rd.forward(request, response);
            return;
        }
        
        ProfessionalInfo profInfo = register(request, response);
        prof = profInfo.getProf();
        
		if(prof != null)
		{    
            session.setAttribute("prof", prof);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserServlet");
            rd.forward(request, response);
		}
        else
        {
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/register.jsp");
        	request.setAttribute("error_message", profInfo.getError());
            rd.forward(request, response);
        }
	}
	
	private ProfessionalInfo register(HttpServletRequest request,
            HttpServletResponse response)
	{
		String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String job_title = request.getParameter("job_title");

        ProfessionalDAO dao = new ProfessionalDAOImpl();

        return dao.register(name, surname, email, telephone, password, job_title);
    }
	
	private boolean emailExists(HttpServletRequest request,
            HttpServletResponse response)
	{
        String email = request.getParameter("email");

        ProfessionalDAO dao = new ProfessionalDAOImpl();
        return dao.emailExists(email);
    }
	
	private List<Professional> getAllProfessionals(HttpServletRequest request,
            HttpServletResponse response)
	{
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		List<Professional> profs = dao.list();
        return profs;
    }

}

