package com.search;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement stmt = null;
    Connection conn = null;
    @Test
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bookstore?useSSL=true";
            String userName = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, userName, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(conn.toString());
        return conn;
    }

    @Test
    public void findCount() {
        int page = 2;
        List<BookBean> list = new ArrayList<BookBean>();
        conn = getConnection();
        System.out.println("iont");
        String sql = "select * from bookinfo order by id desc limit ?,?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (page - 1) * BookBean.PAGE_SIZE);
            ps.setInt(2, BookBean.PAGE_SIZE);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookBean bookBean = new BookBean();
                bookBean.setId(rs.getInt("id"));
                bookBean.setName(rs.getString("name"));
                bookBean.setPrice(rs.getDouble("price"));
                bookBean.setBookCount(rs.getInt("bookCount"));
                bookBean.setAuthor(rs.getString("author"));
                list.add(bookBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("get list");
    }
}