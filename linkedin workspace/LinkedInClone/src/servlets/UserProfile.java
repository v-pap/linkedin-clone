package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProfessionalDAO;
import dao.ProfessionalDAOImpl;
import helper.ProfessionalInfo;
import model.Experience;
import model.Professional;

/**
 * Servlet implementation class UserProfile
 */
@MultipartConfig(location="/home/bill/Desktop/tomcat/temp", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet(urlPatterns = {"/UserProfile", "/UserProfile/edit"})
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
		String requestURI = request.getRequestURI();
	
		Professional prof = (Professional) session.getAttribute("prof");
        if (prof != null)
        {   
        	ProfessionalInfo profInfo = refreshProfile(request,response);
        	if(profInfo.getProf() != null)
        	{
        		session.setAttribute("prof",profInfo.getProf());
        		if(requestURI.endsWith("edit"))
        		{
        			//System.out.println(profInfo.getProf().getExperiences().size());
        			request.setAttribute("num_of_experience", profInfo.getProf().getExperiences().size());
        			request.setAttribute("num_of_education", profInfo.getProf().getEducations().size());
        			RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/profile_edit.jsp");  
                    rd.forward(request, response);
        		}
        		else
        		{
        			RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/profile.jsp");  
                    rd.forward(request, response);
        		}
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
        
		if(prof != null)
		{   //be careful empty values mean either null or ""
			ProfessionalInfo profInfo = modifyProfile(request, response);
			if(profInfo.getProf() != null)
        	{
        		session.setAttribute("prof",profInfo.getProf());
        		response.sendRedirect("/LinkedInClone/UserProfile");
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
	
	private ProfessionalInfo refreshProfile(HttpServletRequest request,
            HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
        return dao.refreshProfile(prof);
    }
	
	private ProfessionalInfo modifyProfile(HttpServletRequest request,
            HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
		prof.setName(request.getParameter("name"));
		prof.setSurname(request.getParameter("surname"));
		prof.setTelephone(request.getParameter("telephone"));
		prof.setJobTitle(request.getParameter("description"));
		String choice = request.getParameter("w_visibility");
		if("Public".equals(choice))	prof.setExperiencePrivate(false);
		else	prof.setExperiencePrivate(true);
		int numberOfExperience = Integer.parseInt(request.getParameter("return_experience"));
		List<Experience> experiences = new ArrayList<Experience>();
		for(int i = 1; i <= numberOfExperience; i++)
		{
			if(request.getParameter("work_title_" + Integer.toString(i)) != null)
			{
				Experience exp = new Experience();
				exp.setDescription(request.getParameter("work_description_" + Integer.toString(i)));
				exp.setFrom(request.getParameter("work_from_" + Integer.toString(i)));
				exp.setTitle(request.getParameter("work_title_" + Integer.toString(i)));
				exp.setTo(request.getParameter("work_to_" + Integer.toString(i)));
				exp.setProfessional(prof);
				experiences.add(exp);
			}
		}
		prof.setExperiences(experiences);
		ProfessionalDAO dao = new ProfessionalDAOImpl();
		return dao.updateProfile(prof,experiences);
    }
}
