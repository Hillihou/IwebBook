<%--
  Created by IntelliJ IDEA.
  User: Soul
  Date: 2021/8/14
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  errorPage="/errorpage/errorPage.jsp" %>
<%@include file="b.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%System.out.println(request.getContextPath());
    System.out.println(request.getServletPath());
    System.out.println(request.getRequestURI());
%>


</body>
</html>
