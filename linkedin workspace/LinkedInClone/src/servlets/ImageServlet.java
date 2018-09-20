package servlets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	String folderPath = "/home/bill/Desktop/multimedia/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("image/jpeg");
		String path = request.getParameter("id");
		File file = new File(folderPath + path);
		BufferedImage bi = ImageIO.read(file);
		OutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		out.close();
	}

}
