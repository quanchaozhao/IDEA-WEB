<%--
  Created by IntelliJ IDEA.
  User: Zqc
  Date: 2018/6/14
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form id="form1" name="form1" method="post" action="FirstServlet">
        留&nbsp;&nbsp;言 &nbsp;&nbsp;人:
        <input name="person" type="text" id="person"><br>
        留言内容：
        <textarea name="content" cols="30" rows="5" id="content">输入内容</textarea><br>
        <input type="submit" name="Subnit" value="提交">&nbsp;
        <input type="reset" name="Submit2" value="重置">

    </form>
</body>
</html>
