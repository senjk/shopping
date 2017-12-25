package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import shopping.service.IDrinkService;
import shopping.service.ILoginservice;
import shopping.service.impl.DrinkServiceImpl;
import shopping.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Account account=new Account();
	 ILoginservice iLoginService=new LoginServiceImpl(); 
     IDrinkService iDrinkservice=new DrinkServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		//@SuppressWarnings("deprecation")
		String brith=request.getParameter("brithday");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date brithday = null;
		try {
			brithday = df.parse(brith);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		account.setCode(code);
		account.setName(username);
		account.setEmail(email);
		account.setPassword(password);
		account.setSex(sex);
		account.setBirthday(brithday);
		account.setTelphone(phone);
		iDrinkservice.update(account);
		
		List<Account> listAccount=new ArrayList<Account>();
		listAccount=iLoginService.selectname(code, password);
		account=listAccount.get(0);
		String name=account.getName();
		String codes=account.getCode();
		String passwords=account.getPassword();
		String emails=account.getEmail();
		String sexs=account.getSex();
		Date brithdays=account.getBirthday();
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
		httpsession3.setAttribute("email", emails);
		httpsession4.setAttribute("phone",telphone);
		httpsession5.setAttribute("brithday", brithdays);
		httpsession6.setAttribute("sex",sexs);
		PrintWriter pw=response.getWriter();
		pw.write("0");
		return;
	}

}