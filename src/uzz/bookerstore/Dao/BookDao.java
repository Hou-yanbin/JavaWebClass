package uzz.bookerstore.Dao;

import sun.plugin.PluginURLJarFileCallBack;
import uzz.bookerstore.bean.Book;
import uzz.bookerstore.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.BinaryOperator;

/**
 * @version v-1.8.0_131.
 * @auther Jack hou  Email:256595662@qq.com
 * @data 2021/4/25/16:34
 * @Description:
 **/
public class BookDao {
    public ArrayList<Book> queryBook() {
        ArrayList<Book> booklist = new ArrayList<Book>();
        Connection conn = JDBCUtil.getConn();
        String sql = "select * from book";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                Book book = new Book();
                book.setISBN(rs.getInt("ISBN"));
                book.setBookName(rs.getString("BookName"));
                book.setCategoryId(rs.getInt("CategoryId"));
                book.setAuthor(rs.getString("Author"));
                book.setCount(rs.getInt("Count"));
                book.setDecription(rs.getString("Decription"));
                book.setEntrytime(rs.getString("Entrytime"));
                book.setPrice(rs.getDouble("Price"));
                book.setSpecialBook(rs.getInt("SpecialBook"));
                book.setImage(rs.getString("Image"));
                booklist.add(book);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JDBCUtil.release(rs,ps,conn);
        return booklist;
    }
}