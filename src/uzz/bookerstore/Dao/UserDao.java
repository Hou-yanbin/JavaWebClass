package uzz.bookerstore.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;

import uzz.bookerstore.bean.User;
import uzz.bookerstore.util.JDBCUtil;
public class UserDao {

    public boolean insertUser(User user){
        boolean ok=false;
        Connection conn=JDBCUtil.getConn();

        String  sql="select * from userdetail where username=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            rs=ps.executeQuery();
            if(rs!=null&&rs.next()==false){
//执行数据库插入操作
                String sql1="insert into userdetail values(?,?,?,?,?,?,0)";//？占位符
                PreparedStatement ps1=conn.prepareStatement(sql1);
                ps1.setString(1, user.getUsername());
                ps1.setString(2, user.getUserpass());
                ps1.setString(3, user.getEmail());
                ps1.setString(4,user.getTelephone());
                ps1.setString(5, user.getCompany());
                ps1.setString(6, user.getAddress());
                int n=ps1.executeUpdate();
                if(n>0){
                    ok=true;
                }
                ps1.close();


            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JDBCUtil.release(rs, ps, conn);







        return ok;



    }


    public boolean queryByUser(User user){
        boolean ok=false;
        Connection conn=JDBCUtil.getConn();
        String  sql="select * from userdetail where username=?&&userpass=?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getUserpass());
            rs=ps.executeQuery();
            if(rs!=null&&rs.next()){
                ok=true;	}



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JDBCUtil.release(rs, ps, conn);








        return ok;



    }
}
