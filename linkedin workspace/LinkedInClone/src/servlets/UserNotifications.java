package servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import model.Post;
import model.Professional;
import model.Relation;
import model.RelationPK;

/**
 * Servlet implementation class UserNotifications
 */
@WebServlet(urlPatterns = {"/UserNotifications", "/UserNotifications/accept", "/UserNotifications/deny"})
public class UserNotifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserNotifications() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Professional prof = (Professional) session.getAttribute("prof");
		if (prof != null)
        {
        	List<Professional> profs_pending = getConnectedProfessionals(request, response);
        	ArrayList<List<Professional>> list_rows = new ArrayList<List<Professional>>();

        	int num_of_lines = profs_pending.size()/3;
        	if(profs_pending.size()%3 > 0) num_of_lines++;
        	int index = 0;
        	for(int i = 0; i < num_of_lines; i++)
        	{
        		ArrayList<Professional> rows = new ArrayList<Professional>();
        		for(int j = 0; (j < 3 && profs_pending.size() > index + j); j++)
        		{
        			rows.add(profs_pending.get(index + j));
        		}
        		list_rows.add(rows);
        		index += 3;
        	}
            request.setAttribute("list_rows", list_rows);
            List<Post> posts_list = getMyPosts(request,response);
            request.setAttribute("posts_list", posts_list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/notifications.jsp");  
            rd.forward(request, response);
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
			HttpSession session = request.getSession(true);
			String requestURI = request.getRequestURI();
			Professional prof = (Professional) session.getAttribute("prof");

			if (prof != null)
	        {
				if(requestURI.endsWith("accept"))
				{
					ProfessionalInfo profInfo = updateStatus(request, response, 0);
					if(profInfo.getProf() != null)
		        	{
		        		response.sendRedirect("/LinkedInClone/UserNotifications");
		        	}
		        	else
		        	{
		        		response.sendRedirect("/LinkedInClone/UserServlet");
		        	}
				}
				else if(requestURI.endsWith("deny"))
				{
					ProfessionalInfo profInfo = updateStatus(request, response, 2);
					if(profInfo.getProf() != null)
		        	{
		        		response.sendRedirect("/LinkedInClone/UserNotifications");
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
			else
	        {
				response.sendRedirect("/LinkedInClone/UserServlet");
	        }
	}
	
	private List<Professional> getConnectedProfessionals(HttpServletRequest request,
            HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		List<Professional> profs = dao.list_pending(prof);
        return profs;
    }
	
	private ProfessionalInfo updateStatus(HttpServletRequest request,
            HttpServletResponse response, int status)
	{
		HttpSession session = request.getSession(true);
		Professional prof1 = (Professional) session.getAttribute("prof");
		ProfessionalDAO dao = new ProfessionalDAOImpl();
        String id = request.getParameter("id");
        Professional prof2 = dao.find(Integer.parseInt(id));
        Relation rel = dao.find_relation(prof1, prof2);
        return dao.updateRelations(prof1, prof2, status);
    }
	
	private List<Post> getMyPosts(HttpServletRequest request,
            HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		List<Post> posts_list = dao.list_myposts(prof);
        return posts_list;
    }

}
