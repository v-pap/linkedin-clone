package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ProfessionalDAO;
import dao.ProfessionalDAOImpl;
import model.JobOffer;
import model.Like;
import model.Post;
import model.Professional;
import model.Comment;
import model.JobApply;
import helper.ProfessionalInfo;

/**
 * Servlet implementation class UserServlet
 */
@MultipartConfig(location="/home/bill/Desktop/tomcat/temp", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet(urlPatterns = {"/UserServlet", "/UserServlet/logout", "/UserServlet/login", "/UserServlet/post", "/UserServlet/comment", "/UserServlet/like"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String folderPath = "/home/bill/Desktop/multimedia";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
        	if(requestURI.endsWith("logout"))
    		{
    			if(session != null)
    			{
    			    session.removeAttribute("prof");
    			    session.invalidate();
    			}
    			response.sendRedirect("/LinkedInClone/UserServlet");
    		}
    		else
    		{
    			List<Post> posts_list = getPosts(request, response);
        		request.setAttribute("posts_list", posts_list);
        		ProfessionalDAO dao = new ProfessionalDAOImpl();
        		ProfessionalInfo profInfo = dao.updateLikes(prof);
        		if(profInfo.getProf() != null)
            	{
    				session.setAttribute("prof",profInfo.getProf());
    				RequestDispatcher rd = getServletContext().getRequestDispatcher("/user/home.jsp");  
                    rd.forward(request, response);
            	}
            	else
            	{
            		response.sendRedirect("/LinkedInClone/UserServlet");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String requestURI = request.getRequestURI();
		HttpSession session = request.getSession(true);
		
		if(requestURI.endsWith("login"))
		{
			ProfessionalInfo profInfo = login(request, response);
			Professional prof = profInfo.getProf();
			if (prof != null)
	        {       
	             session.setAttribute("prof",prof);
	             response.sendRedirect("/LinkedInClone/UserServlet");
	        }
	        else
	        {
	        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
	        	request.setAttribute("error_message", profInfo.getError());
	            rd.forward(request, response);
	        }
		}
		else if(requestURI.endsWith("post"))
		{
			ProfessionalInfo profInfo = createPost(request, response);
			if(profInfo.getProf() != null)
        	{
				session.setAttribute("prof",profInfo.getProf());
        		response.sendRedirect("/LinkedInClone/UserServlet");
        	}
        	else
        	{
        		response.sendRedirect("/LinkedInClone/UserServlet");
        	}
		}
		else if(requestURI.endsWith("comment"))
		{
			ProfessionalInfo profInfo = commentPost(request, response);
			if(profInfo.getProf() != null)
        	{
				session.setAttribute("prof",profInfo.getProf());
        		response.sendRedirect("/LinkedInClone/UserServlet");
        	}
        	else
        	{
        		response.sendRedirect("/LinkedInClone/UserServlet");
        	}
		}
		else if(requestURI.endsWith("like"))
		{
			ProfessionalInfo profInfo = likePost(request, response);
			if(profInfo.getProf() != null)
        	{
				session.setAttribute("prof",profInfo.getProf());
        		response.sendRedirect("/LinkedInClone/UserServlet");
        	}
        	else
        	{
        		response.sendRedirect("/LinkedInClone/UserServlet");
        	}
		}
	}
	
	private ProfessionalInfo login(HttpServletRequest request,
            HttpServletResponse response)
	{
	 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
        return dao.login(email,password);
    }
	
	private ProfessionalInfo createPost(HttpServletRequest request,
            HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
		ProfessionalDAO dao = new ProfessionalDAOImpl();
		
		Part filePart;
		try {
			filePart = request.getPart("video");
		} catch (ServletException e) {
			return new ProfessionalInfo(null,"couldn't save the video");
		}
		
        String VideoName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String pathVid;
        File fileVideo = null;
        if (VideoName.trim().isEmpty())
        {
        	pathVid="";
        }
        else
        {
        	File multimedia = new File(folderPath);
            fileVideo = File.createTempFile(VideoName, ".tmp", multimedia);
    		try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, fileVideo.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
    		pathVid = fileVideo.getName();
        }
		
		///
        try {
			filePart = request.getPart("audio");
		} catch (ServletException e) {
			return new ProfessionalInfo(null,"couldn't save the audio");
		}
        
        String AudioName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String pathSound;
        File fileAudio = null;
        if (AudioName.trim().isEmpty())
        {
        	pathSound="";
        }
        else
        {
        	File multimedia = new File(folderPath);
            fileAudio = File.createTempFile(AudioName, ".tmp", multimedia);
    		try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, fileAudio.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
    		pathSound = fileAudio.getName();
        }
		////
		
		try {
			filePart = request.getPart("image");
		} catch (ServletException e) {
			return new ProfessionalInfo(null,"couldn't save the photo");
		}
		
		File filePhoto = null;
        String PhotoName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String path;
        if (PhotoName.trim().isEmpty())
        {
        	path="";
        }
        else
        {
        	File multimedia = new File(folderPath);
            filePhoto = File.createTempFile(PhotoName, ".tmp", multimedia);
    		try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, filePhoto.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
    		path = filePhoto.getName();
        }
		
        ProfessionalInfo profInfo = dao.updatePosts(prof);
		if(profInfo.getProf() == null) return profInfo;
		prof = profInfo.getProf();
        String text = request.getParameter("post_text");
        Post new_post = new Post();
        new_post.setText(text);
        new_post.setPathPic(path);
        new_post.setPathVid(pathVid);
        new_post.setPathSound(pathSound);
        prof.addPosts2(new_post);
        //profInfo = dao.updatePosts(prof);
        if(profInfo.getProf() == null)
        {
        	if(!PhotoName.trim().isEmpty()) filePhoto.delete();
        	if(!VideoName.trim().isEmpty()) fileVideo.delete();
        	if(!AudioName.trim().isEmpty()) fileAudio.delete();
        }
        return profInfo;
    }
	
	private List<Post> getPosts(HttpServletRequest request,
            HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
        ProfessionalDAO dao = new ProfessionalDAOImpl();
		List<Post> posts_list = dao.list_posts(prof);
        return posts_list;
    }
	
	private ProfessionalInfo commentPost(HttpServletRequest request,
            HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
		ProfessionalDAO dao = new ProfessionalDAOImpl();
		ProfessionalInfo profInfo = dao.updateComments(prof);
		if(profInfo.getProf() == null) return profInfo;
		prof = profInfo.getProf();
        String id = request.getParameter("post_id");
        String text = request.getParameter("comment");
        Post post = dao.find_post(Integer.parseInt(id));
        Comment comment = new Comment();
        comment.setText(text);
        comment.setPost(post);
        comment.setProfessional(prof);
        //post.addComment(comment);
        prof.addComment(comment);
        
        return new ProfessionalInfo(prof,"");
    }
	
	private ProfessionalInfo likePost(HttpServletRequest request,
            HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Professional prof = (Professional) session.getAttribute("prof");
		ProfessionalDAO dao = new ProfessionalDAOImpl();
		ProfessionalInfo profInfo = dao.updateLikes(prof);
		if(profInfo.getProf() == null) return profInfo;
		prof = profInfo.getProf();
        String id = request.getParameter("post_id");
        Post post = dao.find_post(Integer.parseInt(id));
        Like like = new Like();
        like.setPost(post);
        like.setProfessional(prof);
        prof.addLike(like);
        
        return new ProfessionalInfo(prof,"");
    }

}
