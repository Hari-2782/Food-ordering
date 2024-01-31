package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import database.Dishimpl;
import impl.Dishinterface;

/**
 * Servlet implementation class Deletefood
 */
@WebServlet("/Deletefood")
public class Deletefood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletefood() {
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
		//response.setContentType("text/html");
		 System.out.println("delete");
		 String idParameter = request.getParameter("id");
			if (idParameter != null && idParameter.matches("\\d+")) {
			    int id = Integer.parseInt(idParameter);
		Dishinterface de=new Dishimpl();
		de.removedishe(id);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/foodlisit.jsp");
		dispatcher.forward(request, response);
			}
	}

}
