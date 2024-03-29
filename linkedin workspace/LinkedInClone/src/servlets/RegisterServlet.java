package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Professional;
import dao.ProfessionalDAOImpl;
import helper.ProfessionalInfo;
import dao.ProfessionalDAO;

/**
 * Servlet implementation class AdministratorServlet
 */
@MultipartConfig(location="/home/bill/Desktop/tomcat/temp", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String folderPath = "/home/bill/Desktop/multimedia";
       
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
            //RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserServlet");
            //rd.forward(request, response);
            response.sendRedirect("/LinkedInClone/UserServlet");
		}
        else
        {
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/register.jsp");
        	request.setAttribute("error_message", profInfo.getError());
            rd.forward(request, response);
        }
	}
	
	private ProfessionalInfo register(HttpServletRequest request,
            HttpServletResponse response) throws IOException
	{
		String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");
        String job_title = request.getParameter("job_title");

        ProfessionalDAO dao = new ProfessionalDAOImpl();
        Part filePart;
		try {
			filePart = request.getPart("image");
		} catch (ServletException e) {
			return new ProfessionalInfo(null,"couldn't save the photo");
		}
		
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String path;
        File file = null;
        if (fileName.trim().isEmpty())
        {
        	path="avatar3.png";
        }
        else
        {
        	File multimedia = new File(folderPath);
            file = File.createTempFile(fileName, ".tmp", multimedia);
    		try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
    		path = file.getName();
        }
		ProfessionalInfo profInfo = dao.register(name, surname, email, telephone, password, job_title, path);
		if(profInfo.getProf() == null && !fileName.trim().isEmpty() && !path.equals("avatar3.png"))	file.delete();
        return profInfo;
    }

}

