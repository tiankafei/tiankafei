<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("path", request.getContextPath());
%>
<body>
<h1><fmt:message key="welcomeinfo"/></h1>
<form action="login" method="post" >
    <fmt:message key="username"/>: <input type="text" name="username"/><br><br>
    <fmt:message key="password"/>: <input type="password" name="password"/><br><br>
    <input type="submit" value="<fmt:message key="loginBtn"/>"/>
    <a href="${path}/i18n?locale=zh_CN">中文</a><a href="${path}/i18n?locale=en_US">英文</a>
</form>
</body>
</html>
