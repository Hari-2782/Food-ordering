package web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Dishe;

import java.io.IOException;
import java.sql.SQLException;

import database.Dishimpl;
import impl.Dishinterface;

/**
 * Servlet implementation class Getdish
 */
@WebServlet("/Getdish")
@MultipartConfig(maxFileSize=16177215)
public class Getdish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getdish() {
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
	
		int id=Integer.parseInt(request.getParameter("id"));
		Dishinterface de=new Dishimpl();
		
		try {
			Dishe dish = de.getdish(id);
			request.setAttribute("d", dish);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  RequestDispatcher dispatcher =  request.getRequestDispatcher("editfood.jsp");

		dispatcher.forward(request, response);
		
		
	}

}
