
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>查看用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/query.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script>
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
</head>
<body>
    <div id="top">当前位置：用户管理 -- 查看用户信息 </div>
    <div id="contexttop"></div>
    <table border="1" id="tap">
        <tr>
            <td colspan="10">
                <form action="${pageContext.request.contextPath}/queryAll.fictionuser">
                    <br>
                    <input type="text" placeholder="用户ID、用户名、昵称、手机号">
                    <input type="submit" value="查询">
                    <br><br>
                </form>
            </td>
        </tr>
        <tr bgcolor="#e0fbc4">
            <th>用户ID</th>
            <th>用户名</th>
            <th>昵称</th>
            <th>手机号</th>
            <th>剩余会员天数</th>
            <th colspan="5">操作</th>
            
        </tr>

            <c:forEach items="${requestScope.pageModel.pageData}" var="c">
        <tr>
                <td>${c.userId}</td>
                <td>${c.userName}</td>
                <td>${c.userFullName}</td>
                <td>${c.movephone}</td>
                <td>${c.memberdayCount}</td>
                <td><a href="./payinfo_selectBypage.html">充值信息</a></td>
                <td><a href="./reading_selectByPage.html">浏览记录</a></td>
                <td><a href="./collect_selectByPage.html">收藏信息</a></td>
                <td><a href="${pageContext.request.contextPath}/toUpdate.fictionuser?userId=${c.userId}">编辑</a></td>
                <td><a  class="delete" href="${pageContext.request.contextPath}/toDelete.fictionuser?userId=${c.userId}">删除</a></td>
        </tr>
            </c:forEach>



    </table>
    <div style="text-align: center;" id="contextbottom">
        总记录数&nbsp;${requestScope.pageModel.recordCount}&nbsp;条&nbsp;共&nbsp;${requestScope.pageModel.totalPages}&nbsp;页&nbsp;
        <a href="${pageContext.request.contextPath}/queryAll.fictionuser?pageNo=1&likeValue=${requestScope.pageModel.likeValue}" id="firstPage">首页</a>&nbsp;
        <a href="${pageContext.request.contextPath}/queryAll.fictionuser?pageNo=${requestScope.pageModel.pageNo-1}&likeValue=${requestScope.pageModel.likeValue}" id="previousPage">上一页</a>&nbsp;
        <a href="${pageContext.request.contextPath}/queryAll.fictionuser?pageNo=${requestScope.pageModel.pageNo+1}&likeValue=${requestScope.pageModel.likeValue}" id="nextPage">下一页</a>&nbsp;
        <a href="${pageContext.request.contextPath}/queryAll.fictionuser?pageNo=${requestScope.pageModel.totalPages}&likeValue=${requestScope.pageModel.likeValue}" id="lastPage">尾页</a>&nbsp;
        第&nbsp;${requestScope.pageModel.pageNo}&nbsp;页
    </div>
</body>
</html>