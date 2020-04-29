<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/29
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<body>
<form action="${path}/addUser" method="post">
    编号:<input type="text" name="id"/><br>
    姓名:<input type="text" name="name"/><br>
    年龄:<input type="text" name="age"/><br>
    日期:<input type="text" name="date"/><br>
    省份:<input type="text" name="address.province"/><br>
    城市:<input type="text" name="address.city"/><br>
    区域:<input type="text" name="address.town"/><br>
    <input type="submit" value="submit"/><br>
</form>
</body>
</html>
