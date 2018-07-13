package com.myServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Interllij IDEA
 * User:Zqc
 * Data:2018/6/14
 * Time:10:35
 * Email:quanchaozhao@yeah.net
 * To change this template use File | Settings | File Templates.
 */
public class MyFirstServlet extends HttpServlet {
    public MyFirstServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("int");
        req.setCharacterEncoding("UTF-8");
        String person = req.getParameter("person");
        String content = req.getParameter("content");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><hrad><title>获取留言信息</title></head><body>");
        out.println("留言人： " + person + "<br>");
        out.println("留言内容： " + content + "<br>");
        out.println("<a href='index.jsp'> 返回 </a>");
        out.println("</body></html>");
        out.close();
    }

}
