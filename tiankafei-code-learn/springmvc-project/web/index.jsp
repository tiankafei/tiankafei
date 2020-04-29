<%--
  Created by IntelliJ IDEA.
  User: tiankafei
  Date: 2020/4/28
  Time: 22:42
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
返回的消息内容：${msg}

<form action="${path}/update1" method="post">
  <input type="hidden" value="1" name="id">
  姓名：张三<br>
  密码：<input type="text" name="password"><br>
  年龄：<input type="text" name="age"><br>
  <input type="submit" value="提交"><br>
  <img src="${path}/images/filter-servlet-inteceptor-controller执行顺序图.png">
</form>
</body>
</html>
