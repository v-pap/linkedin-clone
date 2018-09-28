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
import model.Administrator;
import model.Professional;

/**
 * Servlet implementation class AdministratorNetwork
 */
@WebServlet("/AdministratorNetwork")
public class AdministratorNetwork extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorNetwork() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Administrator admin = (Administrator) session.getAttribute("admin");
		if (admin != null)
        {
			Professional prof_profile = getProfessional(request, response);
			if(prof_profile != null)
			{
				List<Professional> profs_connected = getConnectedProfessionals(request, response, prof_profile);
	        	ArrayList<List<Professional>> list_rows = new ArrayList<List<Professional>>();

	        	int num_of_lines = profs_connected.size()/3;
	        	if(profs_connected.size()%3 > 0) num_of_lines++;
	        	int index = 0;
	        	for(int i = 0; i < num_of_lines; i++)
	        	{
	        		ArrayList<Professional> rows = new ArrayList<Professional>();
	        		for(int j = 0; (j < 3 && profs_connected.size() > index + j); j++)
	        		{
	        			rows.add(profs_connected.get(index + j));
	        		}
	        		list_rows.add(rows);
	        		index += 3;
	        	}
	            request.setAttribute("list_rows", list_rows);
	            request.setAttribute("prof_profile", prof_profile);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/network_admin.jsp");  
	            rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("/LinkedInClone/AdministratorServlet");
			}
        }
        else
        {
			response.sendRedirect("/LinkedInClone/AdministratorServlet");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private List<Professional> getConnectedProfessionals(HttpServletRequest request,
            HttpServletResponse response, Professional prof_profile)
	{
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		List<Professional> profs = dao.list_connected(prof_profile);
        return profs;
    }
	
	private Professional getProfessional(HttpServletRequest request,
            HttpServletResponse response) throws IOException
	{
		String profId = request.getParameter("id");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		Professional prof_profile = dao.find(Integer.parseInt(profId));
		ProfessionalInfo profInfo = dao.refreshProfile(prof_profile);
		prof_profile = profInfo.getProf();
        return prof_profile;
    }

}
