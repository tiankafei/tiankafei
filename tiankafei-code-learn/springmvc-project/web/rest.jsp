<%--
  Created by IntelliJ IDEA.
  User: tiankafei
  Date: 2020/4/28
  Time: 23:42
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
<form action="${path}/user" method="post">
    <input type="submit" value="增加">
</form>
<form action="${path}/user/1" method="post">
    <input name="_method" value="delete" type="hidden">
    <input type="submit" value="删除">
</form>
<form action="${path}/user/1" method="post">
    <input name="_method" value="put" type="hidden">
    <input type="submit" value="修改">
</form>
<a href="${path}/user/1">查询</a><br/>
</body>
</html>
