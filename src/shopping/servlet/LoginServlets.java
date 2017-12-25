package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopping.entity.Account;
import shopping.service.ILoginservice;
import shopping.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlets
 */
@WebServlet("/LoginServlets")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ILoginservice iLoginService=new LoginServiceImpl(); 
	 Account account=new Account();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlets() {
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
		response.setContentType("text/html; charset=UTF-8");
		String code=request.getParameter("code");
		String password=request.getParameter("password");
		boolean flag=iLoginService.login(code, password);
		List<Account> listAccount=new ArrayList<Account>();
		if(flag){
			listAccount=iLoginService.selectname(code, password);
			account=listAccount.get(0);
			String name=account.getName();
			String codes=account.getCode();
			String passwords=account.getPassword();
			String email=account.getEmail();
			String sex=account.getSex();
			Date brithday=account.getBirthday();
			String telphone=account.getTelphone();
			HttpSession httpsession=request.getSession();
			HttpSession httpsession1=request.getSession();
			HttpSession httpsession2=request.getSession();
			HttpSession httpsession3=request.getSession();
			HttpSession httpsession4=request.getSession();
			HttpSession httpsession5=request.getSession();
			HttpSession httpsession6=request.getSession();
			httpsession.setAttribute("name", name);
			httpsession1.setAttribute("code", codes);
			httpsession2.setAttribute("password", passwords);
			httpsession3.setAttribute("email", email);
			httpsession4.setAttribute("phone",telphone);
			httpsession5.setAttribute("brithday", brithday);
			httpsession6.setAttribute("sex",sex);
			
			
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
