<%--
  Created by IntelliJ IDEA.
  User: Zqc
  Date: 2018/5/28
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户登录</title>
    <meta charset="UTF-8">
    <style type="text/css">
        body {
            font-size: 50px;
            font-family: 华文行楷;
        }
    </style>
</head>
<body>
<form name="form1" method="post" action="../JSP/chapter5/GetCookies.jsp">
    用户名：<input name="name" type="text" style="width: 120px"/>
    <br>
    密 &nbsp;&nbsp;码：<input name="pwd" type="password" style="width: 120px"/>
    <br>
    <input type="submit" name="Submit" value="提交"/>
</form>

</body>
</html>
