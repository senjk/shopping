package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.entity.Userbuy;
import shopping.service.IDrinkService;
import shopping.service.impl.DrinkServiceImpl;


/**
 * Servlet implementation class BuyServlet
 */
@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Userbuy userbuy=new Userbuy();   
	 IDrinkService iDrinkservice=new DrinkServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyServlet() {
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
		String drink=request.getParameter("drink");
		String url=request.getParameter("url");
		String address=request.getParameter("add1")+request.getParameter("add2")+request.getParameter("add3");
		int number=Integer.parseInt(request.getParameter("number"));
		int status=Integer.parseInt(request.getParameter("status"));
		float price=Float.parseFloat(request.getParameter("price"));
		float prices= price*number;
		String code=request.getParameter("code");
		
		HttpSession sessions1=request.getSession();
		HttpSession sessions2=request.getSession();
		HttpSession sessions3=request.getSession();
		HttpSession sessions4=request.getSession();
		HttpSession sessions5=request.getSession();
		HttpSession sessions6=request.getSession();

		sessions1.setAttribute("drink", drink);
		sessions2.setAttribute("url", url);
		sessions3.setAttribute("address", address);
		sessions4.setAttribute("number", number);
		sessions5.setAttribute("price", price);
		sessions6.setAttribute("prices", prices);
		
		userbuy.setCode(code);
		userbuy.setAddress(address);
		userbuy.setDrink(drink);
		userbuy.setNumber(number);
		userbuy.setPrice(prices);
		userbuy.setStatus(status);
		userbuy.setUrl(url);
		boolean flag=iDrinkservice.orderbuy(userbuy);
		
		if(flag){
			PrintWriter pw=response.getWriter();
			pw.write("0");
			return;
		}else{
			PrintWriter pw=response.getWriter();
			pw.write("1");
			return;
		}
	}

}
