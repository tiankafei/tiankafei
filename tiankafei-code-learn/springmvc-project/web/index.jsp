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
返回的用户名：${username}<br />
返回的消息内容：${msg}<br />

<form action="${path}/update1" method="post">
  <input type="hidden" value="1" name="id">
  姓名：张三<br>
  密码：<input type="text" name="password"><br>
  年龄：<input type="text" name="age"><br>
  <input type="submit" value="提交"><br>
  <img src="${path}/images/filter-servlet-inteceptor-controller执行顺序图.png">
</form>
<form action="${path}/converter" method="post">
  <input type="text" name="user">
<input type="submit" value="提交"><br />
</form>
<form action="dateConvertion" method="post">
  编号：<input type="text" name="id"><br>
  姓名：<input type="text" name="name"><br>
  日期：<input type="text" name="birth"><br>
  <input type="submit" value="提交">
</form>
</body>
</html>
