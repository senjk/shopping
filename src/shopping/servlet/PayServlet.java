package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.entity.Userbuy;
import shopping.service.IDrinkService;
import shopping.service.impl.DrinkServiceImpl;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Userbuy userbuy=new Userbuy();   
	 IDrinkService iDrinkservice=new DrinkServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayServlet() {
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
		int status=Integer.parseInt(request.getParameter("status"));
		String code=request.getParameter("code");
		String drink=request.getParameter("drink");
		userbuy.setCode(code);
		userbuy.setStatus(status);
		userbuy.setDrink(drink);
		int nums=iDrinkservice.ordernum(userbuy);
		userbuy.setOrdernum(nums);
		boolean flag=iDrinkservice.pay(userbuy);
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
