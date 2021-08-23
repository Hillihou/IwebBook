<%--
  Created by IntelliJ IDEA.
  User: Soul
  Date: 2021/8/17
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>



<body>
<!-- 顶部 -->
<div id="top">
    <div id="topleft"></div>
</div>

<!-- 用户登录信息 -->
<div id="middle">
    <span>[Administrator] : 欢迎登陆IWEB中文网后台管理系统 </span>
    <span style="position: absolute;right: 10px;">
            <a href="${pageContext.request.contextPath}/logout.category">安全退出</a>
        </span>
</div>

<!-- 主体部分 -->
<div id="body">
    <div id="bodyleft">
        <iframe src="${pageContext.request.contextPath}/menu.jsp" frameborder="0"></iframe>
    </div>

    <div id="bodyright">
        <iframe src="${pageContext.request.contextPath}/queryAll.category?username=${param.username}&password=${param.passowrd}" name="show"></iframe>
    </div>
</div>

<!-- 页脚 -->
<div id="footer">版权所有：南京市艾瑞职业培训学校 ICP备案 ：苏ICP备15022503号-1</div>

</body>
</html>
