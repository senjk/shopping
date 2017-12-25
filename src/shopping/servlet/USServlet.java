package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.service.IDrinkService;
import shopping.service.impl.DrinkServiceImpl;

/**
 * Servlet implementation class USServlet
 */
@WebServlet("/USServlet")
public class USServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 IDrinkService iDrinkservice=new DrinkServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public USServlet() {
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
		int  ordernum=Integer.parseInt(request.getParameter("id"));
		int  status=Integer.parseInt(request.getParameter("flag"));
		boolean flags=iDrinkservice.updatest(ordernum, status);
		if(flags){
			PrintWriter pw=response.getWriter();
			if(1==status){
				pw.write("0");
				return;
			}
			
			if(3==status){
				pw.write("3");
				return;
			}
			if(4==status){
				pw.write("4");
				return;
			}
			if(5==status){
				pw.write("5");
				return;
			}
		}else{
			PrintWriter pw=response.getWriter();
			pw.write("1");
			return;
		}
	}

}
