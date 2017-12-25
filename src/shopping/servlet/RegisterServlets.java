package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.entity.Account;
import shopping.service.IDrinkService;
import shopping.service.impl.DrinkServiceImpl;

/**
 * Servlet implementation class RegisterServlets
 */
@WebServlet("/RegisterServlets")
public class RegisterServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Account account=new Account();
     IDrinkService iDrinkservice=new DrinkServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlets() {
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
		iDrinkservice.add(account);
		PrintWriter pw=response.getWriter();
		pw.write("0");
		return;
	}


	
	}


