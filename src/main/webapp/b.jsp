<%--
  Created by IntelliJ IDEA.
  User: Soul
  Date: 2021/8/14
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%


    String servletPath = request.getServletPath();
    String contextPath = request.getContextPath();
    System.out.println(contextPath);
    System.out.println(servletPath);
%>

${key1}
${key2}
${key3}
${key4}

</body>
</html>
