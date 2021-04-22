package servlet;
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
        System.out.println(usercompany+useraddress);
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String url="jdbc:mysql://localhost:3306/bookstore?useUnicode=true&&characterEncoding=utf-8";
        Connection conn=null;
        try {
            conn=DriverManager.getConnection(url, "root","7758521");
            String sql="select * from userdetail where username=?";//？占位符
            PreparedStatement ps=conn.prepareStatement(sql);
            //给占位符赋值
            ps.setString(1,username);
            //执行查询     查询结果放在ResultSet类型的对象中
            ResultSet rs=ps.executeQuery();
            if(rs!=null&&rs.next()){
                //登录成功  跳转到index.html页面
                out.println("<script>alert('该用户已存在');window.location.href='register.html';</script>");//重定向
            }else{
                //登录失败提示登录失败，跳转至myaccount.html页面
                //JavaScript脚本实现
                //用户信息的添加
                String sql1="insert into userdetail values(?,?,?,?,?,?,0)";//？占位符
                PreparedStatement ps1=conn.prepareStatement(sql1);
                ps1.setString(1, username);
                ps1.setString(2, userpass);
                ps1.setString(3, useremail);
                ps1.setString(4, usertel);
                ps1.setString(5, usercompany);
                ps1.setString(6, useraddress);
                int n=ps1.executeUpdate();
                if(n>0){
                    out.println("<script>alert('注册成功');window.location.href='myaccount.html';</script>");}
                else{
                    out.println("<script>alert('注册失败');window.location.href='register.html';</script>");//重定向
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }





}
