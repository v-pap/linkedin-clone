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
import model.Message;
import model.Professional;
import model.Relation;
import model.RelationPK;

/**
 * Servlet implementation class UserMessages
 */
@WebServlet("/UserMessages")
public class UserMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMessages() {
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
        	List<Professional> profs = getConnectedProfessionals(request, response);
            request.setAttribute("profs", profs);
            List<Message> messages_list = getMessages(request, response);
            request.setAttribute("messages_list", messages_list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/messages.jsp");
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
		HttpSession session = request.getSession(true);
		
		Professional prof = (Professional) session.getAttribute("prof");
		if (prof != null)
        {
			Professional prof_message = getProfessional(request, response);
        	int status = checkStatus(prof,prof_message);
        	if(status == 0)
        	{
        		ProfessionalInfo profInfo = sendMessage(request, response);
        		if(profInfo.getProf() != null)
        		{
        			request.setAttribute("prof", profInfo.getProf());
        			
        			doGet(request,response);
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
		List<Professional> profs = dao.list_connected(prof);
        return profs;
    }
	
	private List<Message> getMessages(HttpServletRequest request,
            HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof1 = (Professional) session.getAttribute("prof");
		String id = request.getParameter("id");
		ProfessionalDAO dao = new ProfessionalDAOImpl();
		Professional prof2;
        if (id != null) prof2 = dao.find(Integer.parseInt(id));
        else return null;
        request.setAttribute("prof_message", prof2);
		List<Message> messages = dao.list_messages(prof1,prof2);
        return messages;
    }
	
	private int checkStatus(Professional prof1, Professional prof2)
	{
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		return dao.check_status(prof1, prof2);
    }
	
	private Professional getProfessional(HttpServletRequest request,
            HttpServletResponse response) throws IOException
	{
		String profId = request.getParameter("id");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		Professional prof_profile = dao.find(Integer.parseInt(profId));
		ProfessionalInfo profInfo = dao.refreshMessages(prof_profile);
		prof_profile = profInfo.getProf();
        return prof_profile;
    }
	
	private Professional updateMessages(HttpServletRequest request,
            HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		ProfessionalInfo profInfo = dao.refreshMessages(prof);
		Professional prof_updated = profInfo.getProf();
        return prof_updated;
    }
	
	private ProfessionalInfo sendMessage(HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession(true);
		Professional prof1 = (Professional) session.getAttribute("prof");
		String message = request.getParameter("message");
		ProfessionalDAO dao = new ProfessionalDAOImpl();
		ProfessionalInfo profInfo = dao.refreshMessages(prof1);
		if(profInfo.getProf() == null) return profInfo;
		prof1 = profInfo.getProf();
        Professional prof2 = getProfessional(request, response);
        Message msg = new Message();
        msg.setMessageText(message);
        msg.setProfessional1(prof1);
        msg.setProfessional2(prof2);
        prof1.addMessages1(msg);
        return dao.updateProfile(prof1);
    }

}