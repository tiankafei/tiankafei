<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/29
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是一个成功的页面！<br />
requestScope.get("requestParam")：${requestScope.get("requestParam")}<br />
sessionScope.get("requestParam")：${sessionScope.get("sessionParam")}<br />

msg：${msg}<br />
requestScope.get("msg")：${requestScope.get("msg")}<br />
sessionScope.get("msg")：${sessionScope.get("msg")}<br />
</body>
</html>
