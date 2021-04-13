package ch04;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.*;

/**
 * @version v-1.8.0_131.
 * @auther Jack hou  Email:256595662@qq.com
 * @data 2021/4/6/16:42
 * @Description:
 **/
public class   Demo1 {
    public static void main(String[] args) {
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //导包否则，System.out.println("驱动找不到！");
        }
        //2.获取数据库连接对象
        String url="jdbc:mysql://localhost:3306/cainiao?useUnicode=true&&characterEncoding=utf8";
        String user="root";
        String password="7758521";
        PreparedStatement ps=null;
        try {
            Connection conn= DriverManager.getConnection(url,user,password);
            //获取prepareStatement对象执行SQL语句
            String sql="select * from websites";
            ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            //把查询结果从记录集取出来
            while (rs.next()){
                System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("url"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}