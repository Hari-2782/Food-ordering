package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Dishe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

/**
 * Servlet implementation class Getdishcal
 */
@WebServlet("/Getdishcal")
public class Getdishcal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getdishcal() {
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
		doGet(request, response);
HttpSession session = request.getSession();
        
        // Retrieve the current shopping cart from the session
        @SuppressWarnings("unchecked")
		ArrayList<Dishe> cart = (ArrayList<Dishe>) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new ArrayList<Dishe>();
        }

        // Retrieve the dish information from the request
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String description = request.getParameter("description");
        byte[] photo = Base64.getDecoder().decode(request.getParameter("photo"));
        int quantity = Integer.parseInt(request.getParameter("quantity_" + id));

        // Create a Dishe object for the selected dish
        Dishe selectedDish = new Dishe(id, name, price,  photo, quantity, description);
        
        // Add the selected dish to the shopping cart
        cart.add(selectedDish);

        // Update the shopping cart attribute in the session
        session.setAttribute("cart", cart);

        // Redirect to a page to show the updated cart or another appropriate page
        response.sendRedirect("viewcard.jsp");
	}

}
