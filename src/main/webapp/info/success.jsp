<%--
  Created by IntelliJ IDEA.
  User: Soul
  Date: 2021/8/13
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登录成功</h1>
    <%--req.getRequestDispatcher(req.getContextPath()+"/queryAll.category").forward(req, resp);--%>
    <a href="${pageContext.request.contextPath}/queryAll.category">进入首页</a>
</body>
</html>
