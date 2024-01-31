package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import database.Deliveryimpl;
import impl.Deliveryinterface;
import model.Delivery;

/**
 * Servlet implementation class Deliveryserverlet
 */

@WebServlet("/")
public class Deliveryserverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Deliveryinterface de;
       public void inti() {
    	   de=new  Deliveryimpl(); 
       }
   	/**
   	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   	 */
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		// TODO Auto-generated method stub
   		doGet(request, response);
   	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	
			
	}
	private void listUser(HttpServletRequest request, HttpServletResponse response)throws  SQLException, IOException, ServletException {
		response.setContentType("text/html");
		
	RequestDispatcher dispatcher = request.getRequestDispatcher("deliverylist.jsp");
		dispatcher.forward(request, response);
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String idParameter = request.getParameter("id");
		if (idParameter != null && idParameter.matches("\\d+")) {
		    int id = Integer.parseInt(idParameter);
		    de=new  Deliveryimpl();
			 de.delete(id);
				
				response.sendRedirect("list");
		} else {
		    // Handle the case where 'id' is not a valid integer or is null.
		    // You can redirect to an error page or provide a meaningful error message.
			System.out.print(idParameter);
		}
	
	

	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("delivery.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		 de=new  Deliveryimpl();
		Delivery existingUser = de.getdetail(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("delivery.jsp");

		request.setAttribute("d", existingUser);
		dispatcher.forward(request, response);
	}
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name =request.getParameter("name");
		String phone =request.getParameter("phone");
		 String email=request.getParameter("email") ;
		 String address=request.getParameter("address");
		 de=new  Deliveryimpl();
		Delivery dq=new Delivery(name, phone, email, address);
		 
		de.adddelivery(dq);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name =request.getParameter("name");
		String phone =request.getParameter("phone");
		 String email=request.getParameter("email") ;
		 String address=request.getParameter("address");
		 int id= Integer.parseInt(request.getParameter("id"));
		 de=new  Deliveryimpl();
		 Delivery d=new Delivery(id, name, phone, email, address);
		 de.updatedetails(d);
		response.sendRedirect("list");
	}
}
