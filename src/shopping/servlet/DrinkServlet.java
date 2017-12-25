package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.entity.Drinks;
import shopping.service.IDrinkService;
import shopping.service.impl.DrinkServiceImpl;



/**
 * Servlet implementation class DrinkServlet
 */
@WebServlet("/DrinkServlet")
public class DrinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDrinkService iDrinkService=new DrinkServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrinkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		  doPost(request, response);
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		List<Drinks> listdrink=new ArrayList<Drinks>();
		List<Drinks> listdrinks=new ArrayList<Drinks>();
		
		
		listdrink=iDrinkService.Drinkshow(0);
		listdrinks=iDrinkService.Drinkshow(1);
		HttpSession httpsession1=request.getSession();
		HttpSession httpsession2=request.getSession();
		httpsession1.setAttribute("listDrink", listdrink);
		httpsession2.setAttribute("listDrinks", listdrinks);
		PrintWriter pw=response.getWriter();
		pw.write("0");
		return;
	}

}
