package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Dishe;
import impl.Dishinterface;
import java.io.IOException;
import java.io.InputStream;

import database.Dishimpl;

/**
 * Servlet implementation class Adddish
 */
@WebServlet("/Adddish")
@MultipartConfig(maxFileSize=16177215)
public class Adddish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adddish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		Dishe d=new Dishe();
		//d.setDishid(Integer.parseInt(request.getParameter("id")));
		d.setDesc(request.getParameter("des"));
		d.setName(request.getParameter("name"));
		//d.setPhoto(request.getParameter("pic"));
		d.setPrice(Float.parseFloat(request.getParameter("price")));
		// Handle the file upload
	    Part filePart = request.getPart("pic");
	    if (filePart != null) {
	        InputStream inputStream = filePart.getInputStream();
	        byte[] photoBytes = inputStream.readAllBytes();
	        d.setPhoto(photoBytes);
	    }
		
		Dishinterface de=new Dishimpl();
		de.adddish(d);
		request.setAttribute("d", d);
		
		response.sendRedirect("foodlisit.jsp");
	}

}
