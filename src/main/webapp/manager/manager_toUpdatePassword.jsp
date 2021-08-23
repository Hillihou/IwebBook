<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>修改密码</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/changePassword.manager">
        <input type="hidden" name="managerId" value="${requestScope.managerinfo.managerId}">
        <table>
            <tr>
                <td>管理员用户名:</td>
                <td><input type="text" name="manageruserName" value="${requestScope.managerinfo.manageruserName}"></td>
            </tr>
            <tr>
                <td>旧密码:</td>
                <td><input type="text" name="oldPassword"></td>
            </tr>
            <tr>
                <td>新密码:</td>
                <td><input type="text" name="newPassword"></td>
            </tr>
            <tr>
                <td>重复输入新密码:</td>
                <td><input type="text" name="newPassword_repeat"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="提交"></td>
            </tr>
        </table>

    </form>
</body>
</html>