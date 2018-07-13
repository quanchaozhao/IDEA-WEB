<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Zqc
  Date: 2018/5/31
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Save cookies</title>
</head>
<body>
<%
    Date date = new Date();
    SimpleDateFormat dtf = new SimpleDateFormat("h:m:s");
    String user = URLEncoder.encode(request.getParameter("user"),"utf-8");
    Cookie cookie = new Cookie("myCookie",user + "#" + dtf.format(date));
    cookie.setMaxAge(60*60*24*30);
    response.addCookie(cookie);
%>
<script type="text/javascript">
    window.location.href="GetCookies.jsp"
</script>
</body>
</html>
