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
  编号：<input type="text" name="id">${errors.id}<br>
  姓名：<input type="text" name="name">${errors.name}<br>
  日期：<input type="text" name="birth"${errors.birth}><br>
  <input type="submit" value="提交">
</form>
<form action="${path}/testUpload" method="post" enctype="multipart/form-data">
  <input type="file" name="file"><br>
  <input type="file" name="file"><br>
  <input type="file" name="file"><br>
  <input type="submit" value="上传"><br />
</form>
<a href="${path}/i18n">国际化登录</a><br>
<a href="${path}/i18nTest">国际化标准登录</a><br><br>

<a href="${path}/exception1">自己处理异常</a><br>
<a href="${path}/exception2?username=zhangsan">自定义异常处理</a><br>
<a href="${path}/exception3">Springmvc自己异常处理</a><br>
</body>
</html>
