package uzz.bookerstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uzz.bookerstore.Dao.UserDao;
import uzz.bookerstore.bean.User;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/Login")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello uzz");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置请求的编码方式为urf-8
		request.setCharacterEncoding("utf-8");
		//设置响应的文档类型和编码方式
		response.setContentType("text/html;charset=utf-8");
		//把表单输入的内容取出来
		String username=request.getParameter("username");
		String userpass=request.getParameter("userpass");
		String inputvalcode=request.getParameter("valcode");
		HttpSession session=request.getSession();
		String valcode=(String)session.getAttribute("valcode");
		//输出流
		PrintWriter out=response.getWriter();

		/*if (username.equals("admin")&&userpass.equals("123456")){
			//登陆成功跳转index。html
			out.println("<script>window.location.href='index.html'</script>");

		}else{//返回登录页面
			out.println("<script>window.location.href='myaccount.html'</script>");
		}*/
		if(inputvalcode!=null&&valcode!=null&&inputvalcode.equals(valcode)){
			User user=new User();
			user.setUsername(username);
			user.setUserpass(userpass);
			UserDao userdao=new UserDao();
			boolean ok=userdao.queryByUser(user);
			if(ok){
				session.setAttribute("username", username);
				out.println("<script>window.location.href='index.jsp'</script>");
			}else{
				out.println("<script>window.location.href='myaccount.jsp'</script>");
			}}else{
			out.println("<script>window.location.href='myaccount.jsp'</script>");
		}


	}

}
