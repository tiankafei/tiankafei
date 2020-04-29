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
spring-url返回的消息${msg}

<form action="${path}/tiankafei/hello2" method="post">
    <input type="submit" value="提交">
</form>
</body>
</html>
