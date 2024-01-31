package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dishe;

import java.io.IOException;
import database.Dishimpl;
import impl.Dishinterface;

/**
 * Servlet implementation class Updatedish
 */
@WebServlet("/Updatedish")
public class Updatedish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatedish() {
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
		response.setContentType("text/html");
		Dishe d=new Dishe();
		int id=Integer.parseInt(request.getParameter("id"));
		d.setDishid(id);
		d.setDesc(request.getParameter("des"));
		d.setName(request.getParameter("name"));
		//d.setPhoto(request.getParameter("pic"));
    	d.setPrice(Float.parseFloat(request.getParameter("price")));
//		 Part filePart = request.getPart("pic");
//		    if (filePart != null) {
//		        InputStream inputStream = filePart.getInputStream();
//		        byte[] photoBytes = inputStream.readAllBytes();
//		        d.setPhoto(photoBytes);
//		    }
		Dishinterface de=new Dishimpl();
		de.updatedish(id, d);
		response.sendRedirect("foodlisit.jsp");
	}

}
