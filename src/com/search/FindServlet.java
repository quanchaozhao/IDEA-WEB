package com.search;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/7/2
 * Time:12:21
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
//1采用注解的方式
//@WebServlet("/")
public class FindServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        int currPage = 1;
        if(req.getParameter("page") != null){
            currPage = Integer.parseInt(req.getParameter("page"));
            System.out.println("do get, currpage : " + currPage);
        }

        BookDao dao = new BookDao();
        List<BookBean> list = dao.find(currPage);
        req.setAttribute("list", list);
        int pages;
        int count = dao.findCount();
        if(count % BookBean.PAGE_SIZE == 0){
            pages = count / BookBean.PAGE_SIZE;
        } else{
            pages = count / BookBean.PAGE_SIZE + 1;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= pages; i++){
            if(i == currPage){
                sb.append("『" + i + "』");
            } else {
                sb.append("<a href='/find?page=" + i + "'>" + i + "</a>");
            }
            sb.append(" ");
        }
        req.setAttribute("bar", sb.toString());
        req.getRequestDispatcher("/BookSearch/bookList.jsp").forward(req,resp);
    }
}
