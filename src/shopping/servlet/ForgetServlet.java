package shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.service.ILoginservice;
import shopping.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class ForgetServlet
 */
@WebServlet("/ForgetServlet")
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ILoginservice iLoginService=new LoginServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetServlet() {
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
		String id=request.getParameter("id");
		if(id.equals("1")){
			String code=request.getParameter("code");
			boolean flag=iLoginService.forget(code);
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
		if(id.equals("2")){
			String code=request.getParameter("code");
			String pwd=request.getParameter("pwd");
			boolean flag=iLoginService.repwd(code,pwd);
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

}