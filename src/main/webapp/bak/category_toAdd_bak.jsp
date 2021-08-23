<%@ page import="com.iweb.pojo.Category" %><%--
  Created by IntelliJ IDEA.
  User: Soul
  Date: 2021/8/15
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>小说类别编辑</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/query.css">
    <script src="<%=request.getContextPath()%>/js/jquery-1.7.2.js" type="text/javascript"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/category.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.2.js"></script>
    <%Category category= (Category) request.getAttribute("category");%>
    <script type="text/javascript">
        $(function () {
            $("#description").val("<%=category==null?"":category.getDesc()%>");
        });
    </script>

</head>
<body>
<div id="top">·当前位置： 类别管理 -- 编辑小说类别</div>
<form action="<%=request.getContextPath()%>/addorupdate.category" method="post">
    <table id="tap" style="margin-top: 30px; border-collapse:separate; border-spacing:0px 10px;">
        <tr>
            <td align="right">类别ID : </td>
            <td align="left">&nbsp;<input type="text" id="categoryId" name="categoryId" readonly="readonly" placeholder="新增时无需填写" value="<%=category==null?"":category.getCategoryId()%>"/></td>
        </tr>
        <tr>
            <td align="right" style="width:40%;">类别名称 : </td>
            <td align="left">&nbsp;<input type="text" id="categoryName" name="categoryName" value="<%=category==null?"":category.getCategoryName()%>"/><span
                    style="color: red"> *</span><span class="message" id="message0" style="color: red;"></span></td>
        </tr>
        <tr>
            <td align="right">类别描述 : </td>
            <td align="left">&nbsp;<textarea id="description" name="description"></textarea><span
                    style="color: red"> *</span><span class="message" id="message1" style="color: red;"></span></td>
        </tr>
        <tr>
            <td colspan="2"><input style="width: 60px;" type="submit" id="submit"
                                   value="提交" /></td>
        </tr>
    </table>
</form>
</body>
</html>
