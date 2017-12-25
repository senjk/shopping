package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.entity.Page;
import shopping.entity.Userbuy;
import shopping.service.IDrinkService;
import shopping.service.impl.DrinkServiceImpl;

/**
 * Servlet implementation class UserBuyServlet
 */
@WebServlet("/UserBuyServlet")
public class UserBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Userbuy userbuy=new Userbuy();   
	 IDrinkService iDrinkservice=new DrinkServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserBuyServlet() {
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
		String code=request.getParameter("code");
		int  pageNo=Integer.parseInt(request.getParameter("pageNo"));
		userbuy.setCode(code);
		
		Page page=iDrinkservice.userbuy(userbuy,pageNo,4);
		page.setPageNo(pageNo);
		HttpSession sessions=request.getSession();
	   sessions.setAttribute("page", page);
		PrintWriter pw=response.getWriter();
		pw.write("0");
		return;
	}

}
