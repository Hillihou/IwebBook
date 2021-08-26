<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset=`"UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户编辑</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/query.css">
    <script src="${pageContext.request.contextPath}/js/manager.js" type="text/javascript"></script>
    <%
        String str=Math.random()+"";
        session.setAttribute("myflag",str);
    %>
</head>
<body>
<div id="top">当前位置：用户管理 -- 编辑用户 </div>
<div id="contexttop"></div>
    <table>
        <form action="${pageContext.request.contextPath}/addorupdate.fictionuser">
            <input type="hidden" name="flag" value="<%=str%>">
            <tr>
                <td>用户ID:</td>
                <td><input type="text" name="userId"  readonly="readonly" placeholder="新增时候无需填写" value="${requestScope.fictionUser.userId}"></td>
            </tr>
            <tr>
                <td>昵称:</td>
                <td><input type="text" name="userFullName" value="${requestScope.fictionUser.userFullName}"></td>
            </tr>
            <tr>
                <td>手机号码:</td>
                <td><input type="text" name="movephone" value="${requestScope.fictionUser.movephone}"></td>
            </tr>
            <tr>
                <td>会员剩余天数:</td>
                <td><input type="text" name="memberdayCount" value="${requestScope.fictionUser.memberdayCount}"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit">
                </td>
            </tr>
        </form>
    </table>
</body>
</html>