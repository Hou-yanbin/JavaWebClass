package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import util.JDBCUtil;
public class UserDao {
    public boolean queryByUser(User user){
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
                String sql1="insert into userdetail values(?,?,?,?,?,?,0)";
                PreparedStatement ps1=conn.prepareStatement(sql1);
                ps1.setString(1,user.getUsername());
                ps1.setString(2,user.getUserpass());
                ps1.setString(3,user.getEmail());
                ps1.setString(4,user.getTelephone());
                ps1.setString(5,user.getCompany());
                ps1.setString(6,user.getAddress());
                int n =ps1.executeUpdate();
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
}

