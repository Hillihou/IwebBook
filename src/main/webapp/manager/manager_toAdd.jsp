<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员新增修改</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js" type="text/javascript"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/query.css">
    <script src="${pageContext.request.contextPath}/js/manager.js" type="text/javascript"></script>
    <%
        String str=Math.random()+"";
        session.setAttribute("myflag",str);
    %>
</head>
<body>
    <div id="top">当前位置：管理员管理 -- 增加管理员 </div>
    <div id="contexttop"></div>
    <form action="${pageContext.request.contextPath}/addorupdate.manager">
        <input type="hidden" name="flag" value="<%=str%>">
    <table id="tap" border="0" style="position: relative;margin: auto;">
        <tr >
            <td align="right">管理员ID:</td>
            <td align="left"><input type="text" readonly="readonly" name="managerId" placeholder="新增时候无需填写" value="${requestScope.managerinfo.managerId}"></td>
        </tr>
        <tr>
            <td align="right" style="width:40%;">管理员用户名:</td>
            <td align="left"><input type="text" name="manageruserName" value="${requestScope.managerinfo.manageruserName}"><span
                style="color: red"> *</span><span class="message" id="message0" style="color: red;"></span></td>
        </tr>
        <tr id="ctr1">
            <td align="right">管理员密码:</td>
            <td align="left"><input type="text" name="password1" value="${requestScope.managerinfo.managerPassword}"><span
                style="color: red"> *</span><span class="message" id="message1" style="color: red;"></span></td>
        </tr>
        <tr id="ctr2">
            <td align="right">重复输入密码:</td>
            <td align="left"><input type="text" name="password2" value="${requestScope.managerinfo.managerPassword}"><span
                style="color: red"> *</span><span class="message" id="message2" style="color: red;"></span></td>
        </tr>
        <tr>
            <td align="right">管理员昵称:</td>
            <td align="left"><input type="text" name="managerfullname" value="${requestScope.managerinfo.managerfullname}"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="submit" id="submit" value="提交" style="width: 60px;"></td>
        </tr>
    </table>
</form>
</body>
</html>