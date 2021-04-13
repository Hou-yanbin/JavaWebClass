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
        System.out.println("hello");
        String username=request.getParameter("username");
        String userpass=request.getParameter("userpass");
        //输出流
        PrintWriter out=response.getWriter();

		/*if (username.equals("admin")&&userpass.equals("123456")){
			//登陆成功跳转index。html
			out.println("<script>window.location.href='index.html'</script>");

		}else{//返回登录页面
			out.println("<script>window.location.href='myaccount.html'</script>");
		}*/
        try {//加载驱动  把相应的jar包放入web-inf 下面的lib文件夹中
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //获取数据库的连接
        Connection conn=null;
        String url="jdbc:mysql://localhost:3306/bookstore?useUnicode=true&&characterEncoding=utf-8";
        String user="root";
        String password="7758521";
        try {
            conn=DriverManager.getConnection(url, user, password);
            String sql="select * from userdetail where username=?&&userpass=?";//？占位符
            PreparedStatement ps=conn.prepareStatement(sql);//获取	PreparedStatement对象
            ps.setString(1, username);//给第一个站位符赋值
            ps.setString(2, userpass);
            ResultSet rs=ps.executeQuery();//执行查询 结果放入记录集rs对象中
            if(rs!=null&&rs.next()){
                out.println("<script>window.location.href='index.html'</script>");
            }else{

                out.println("<script>window.location.href='myaccount.html'</script>");

            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }




    }

}
