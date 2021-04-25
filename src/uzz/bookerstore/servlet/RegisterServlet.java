package uzz.bookerstore.servlet;
import uzz.bookerstore.Dao.UserDao;
import uzz.bookerstore.bean.User;

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

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")

public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        request.setCharacterEncoding("utf-8");//设置请求的编码方式
        response.setContentType("text/html;charset=utf-8");//设置响应文档类型和编码方式
        PrintWriter out=response.getWriter();//获取输出流
        String username=request.getParameter("username");
        String userpass=request.getParameter("userpass");
        String useremail=request.getParameter("useremail");
        String usertel=request.getParameter("usertel");
        String usercompany=request.getParameter("usercompany");
        String useraddress=request.getParameter("useraddress");
        User user=new User();
        user.setUsername(username);
        user.setUserpass(userpass);
        user.setEmail(useremail);
        user.setTelephone(usertel);
        user.setCompany(usercompany);
        user.setAddress(useraddress);
        UserDao userdao=new UserDao();
        boolean ok=userdao.insertUser(user);
        if(ok){

            out.println("<script>alert('注册成功');window.location.href='myaccount.html';</script>");}
        else{
            out.println("<script>alert('注册失败');window.location.href='register.html';</script>");

        }
    }







}
