package com.search;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/7/2
 * Time:9:31
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class BookDao {


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
        return conn;
    }

    public List<BookBean> find(int page) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
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
        return list;
    }

    public int findCount() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        int count = 0;
        conn = getConnection();

        String sql = "SELECT COUNT(*) FROM bookinfo";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("get count");
        return count;
    }

    public static void main(String[] args) {
        List<BookBean> list = new BookDao().find(1);
        System.out.println(list.toString());
    }
}

