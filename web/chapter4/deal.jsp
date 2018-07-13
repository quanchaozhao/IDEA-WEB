<%--
  Created by IntelliJ IDEA.
  User: Zqc
  Date: 2018/5/28
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="userf" scope="page" class="com.zqc.UserBean" type="com.zqc.UserBean">
    <jsp:setProperty name="userf" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>显示登录信息</title>
    <meta charset="UTF-8">
</head>

<body>
用户名：<%=userf.getName() + "，欢迎您."%>
<br><br>
密    码：<%=userf.getPwd()%>
</body>
</html>
