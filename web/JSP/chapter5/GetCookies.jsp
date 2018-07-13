<%@ page import="java.net.URLEncoder" %>
<%--
  Created by IntelliJ IDEA.
  User: Zqc
  Date: 2018/5/31
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page import="java.net.*,java.util.*,java.text.*" %>

<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
</head>
<body>
<script language="JavaScript">
    // alert("messagde")
</script>
<%
    Cookie[] cookies = request.getCookies();
    String user = "";
    String date = "";
    String totalUser = "";
    if(cookies != null){
        for(int i = 0; i < cookies.length; i++){
            if(cookies[i].getName().equals("myCookie")){
                user = URLDecoder.decode(cookies[i].getValue().split("#")[0],"utf-8");
                date = cookies[i].getValue().split("#")[1];
            }
            totalUser = totalUser + URLDecoder.decode(cookies[i].getValue().split("#")[0],"utf-8") + "<br>\n\r";
        }
    }
    if("".equals(user) && "".equals(date)){
%>
    游客您好，欢迎您初次光临！<br><br>
    <form action="deal.jsp" method="post">
        请输入名字:<input name="user" type="text" value="">
                    <input type="submit" value="确定">
    </form>
<% }else{%>
欢迎[<b><%=user%></>]，再次光临<br>
您注册的时间是：<%=date%>
<%
    }
%>
<%=totalUser%>
</body>
</html>
