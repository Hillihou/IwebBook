<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/query.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script type="text/javascript">
        $(function () {
            //控制分页按钮是否可以用
            var pageNo=${requestScope.pageModel.pageNo};
            var totalPages=${requestScope.pageModel.totalPages};
            if (pageNo==1){
                $("#firstPage").attr("href","#");
                $("#previousPage").attr("href","#");
            }if (pageNo==totalPages){
                $("#nextPage").attr("href","#");
                $("#lastPage").attr("href","#");
            }
            //删除之前判断
            $(".delete").click(function () {
                var text=$(this).parent().parent().find("td").eq(1).text();
                if (!confirm("要删除"+$.trim(text)+"吗?")){
                    return false;
                }
            })
        })
    </script>
    <%
        String str=Math.random()+"";
        session.setAttribute("myflag",str);
    %>
</head>
<body>
    <div id="top">当前位置： 管理员管理 -- 查看管理员信息</div>
    <div id="contexttop"></div>
    <a href="${pageContext.request.contextPath}/toAdd.manager">新增一条记录</a>
    <table border="1" id="tap">
        <tr>
            <td colspan="7">
                <form action="${pageContext.request.contextPath}/queryAll.manager">
                    <br>
                    <input type="text" name="likeValue" placeholder="管理员ID、管理员用户名、管理员昵称">
                    <input type="submit" value="查询">
                    <br><br>
                </form>
            </td>
        </tr>
        <tr bgcolor="#e0fbc4">
            <th>管理员ID</th>
            <th>管理员用户名</th>
            <th>管理员昵称</th>
            <th>管理员创建时间</th>
            <th colspan="3">操作</th>
        </tr>

        <c:forEach items="${requestScope.pageModel.pageData}" var="c">
            <tr>
                <td>${c.managerId}</td>
                <td>${c.manageruserName}</td>
                <td>${c.managerfullname}</td>
                <td>${c.createTime}</td>
                <td><a href="${pageContext.request.contextPath}/toUpdate.manager?managerId=${c.managerId}">编辑</a></td>
                <td><a href="${pageContext.request.contextPath}/toUpdatePassword.manager?managerId=${c.managerId}">重置密码</a></td>
                <td><a class="delete" href="${pageContext.request.contextPath}/toDelete.manager?managerId=${c.managerId}">删除</a></td>
            </tr>
        </c:forEach>



    </table>
        <div style="text-align: center;" id="contextbottom">
            总记录数&nbsp;${requestScope.pageModel.recordCount}&nbsp;条&nbsp;共&nbsp;${requestScope.pageModel.totalPages}&nbsp;页&nbsp;
            <a href="${pageContext.request.contextPath}/queryAll.manager?pageNo=1&likeValue=${requestScope.pageModel.likeValue}" id="firstPage">首页</a>&nbsp;
            <a href="${pageContext.request.contextPath}/queryAll.manager?pageNo=${requestScope.pageModel.pageNo-1}&likeValue=${requestScope.pageModel.likeValue}" id="previousPage">上一页</a>&nbsp;
            <a href="${pageContext.request.contextPath}/queryAll.manager?pageNo=${requestScope.pageModel.pageNo+1}&likeValue=${requestScope.pageModel.likeValue}" id="nextPage">下一页</a>&nbsp;
            <a href="${pageContext.request.contextPath}/queryAll.manager?pageNo=${requestScope.pageModel.totalPages}&likeValue=${requestScope.pageModel.likeValue}" id="lastPage">尾页</a>&nbsp;
            第&nbsp;${requestScope.pageModel.pageNo}&nbsp;页
        </div>
</body>
</html>