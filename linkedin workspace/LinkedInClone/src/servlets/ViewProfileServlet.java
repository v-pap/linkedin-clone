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
import model.Relation;
import model.RelationPK;

/**
 * Servlet implementation class ViewProfileServlet
 */
@WebServlet("/ViewProfileServlet")
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfileServlet() {
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
        	Professional prof_profile = getProfessional(request, response);
        	if(prof_profile.getId() == prof.getId())
        	{
        		response.sendRedirect("/LinkedInClone/UserProfile");
        	}
        	else
        	{
        		int status = checkStatus(prof,prof_profile);
                request.setAttribute("prof_profile", prof_profile);
                request.setAttribute("status", status);
    			RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/user_profile.jsp");  
                rd.forward(request, response);
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
		if (prof != null)
        {
			ProfessionalInfo profInfo = connectRequest(request, response);
			if(profInfo.getProf() != null)
        	{
        		response.sendRedirect("/LinkedInClone/UserNetwork");
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
	
	private Professional getProfessional(HttpServletRequest request,
            HttpServletResponse response) throws IOException
	{
		String profId = request.getParameter("id");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		Professional prof_profile = dao.find(Integer.parseInt(profId));
		ProfessionalInfo profInfo = dao.refreshProfile(prof_profile);
		prof_profile = profInfo.getProf();
		if(prof_profile == null)	response.sendRedirect("/LinkedInClone/UserServlet");
        return prof_profile;
    }
	
	private int checkStatus(Professional prof1, Professional prof2)
	{
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		return dao.check_status(prof1, prof2);
    }
	
	private ProfessionalInfo connectRequest(HttpServletRequest request,
			HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof1 = (Professional) session.getAttribute("prof");
		ProfessionalDAO dao = new ProfessionalDAOImpl();
		ProfessionalInfo profInfo = dao.updateRelations(prof1);
		if(profInfo.getProf() == null) return profInfo;
		prof1 = profInfo.getProf();
        String id = request.getParameter("id");
        Professional prof2 = dao.find(Integer.parseInt(id));
        Relation rel = new Relation();
        RelationPK relPK = new RelationPK();
        relPK.setId1(prof1.getId());
        relPK.setId2(prof2.getId());
        rel.setId(relPK);
        rel.setProfessional1(prof1);
        rel.setProfessional2(prof2);
        rel.setStatus(1);
        prof1.addRelations1(rel);
        return dao.updateProfile(prof1);
    }

}
