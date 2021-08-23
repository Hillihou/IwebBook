<%@ page import="java.util.List" %>
<%@ page import="com.iweb.pojo.Category" %>
<%@ page import="com.iweb.util.PageModel" %><%--
  Created by IntelliJ IDEA.
  User: Soul
  Date: 2021/8/15
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小说类别列表</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
    <link rel="stylesheet" href="./css/query.css">
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
<%
String username=request.getParameter("username");
String password=request.getParameter("password");
if (username!=null&&username.length()>0){
    Cookie cookie = new Cookie("username", username);
    cookie.setMaxAge(15811200);//半年自动登录
    response.addCookie(cookie);
}else {
    Cookie[] cookies = request.getCookies();
    if (cookies!=null&&cookies.length>0) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                username = c.getValue();
            }
        }
    }
}

if (username==null||username.length()<=0){
    response.sendRedirect(request.getContextPath()+"/index.jsp");
}

%>


<div id="top">当前位置： 类别管理 -- 查看小说类别</div>
<div id="contexttop"></div>
    <a href="${pageContext.request.contextPath}/toAdd.category">新增一条记录</a>
    <%--<a href="${pageContext.request.contextPath}/logout.category">安全退出</a>--%>
    <table id="tap" border="1">
        <tr>
            <td colspan="6">
                <form action="${pageContext.request.contextPath}/queryAll.category" method="post">
                    <input type="text" placeholder="类别ID,类别名称，类别描述" name="likeValue" value="${requestScope.pageModel.likeValue}"/>
                    <input type="submit" value="搜索">
                </form>
            </td>
        </tr>
        <tr bgcolor="#e0fbc4">
            <th>小说id</th>
            <th>小说名称</th>
            <th>小说创建时间</th>
            <th>小说描述</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${requestScope.pageModel.pageData}" var="c">
        <tr>
            <td>${c.categoryId}</td>
            <td>${c.categoryName}</td>
            <td>${c.createTime}</td>
            <td>${c.desc}</td>
            <td><a href="${pageContext.request.contextPath}/toUpdate.category?categoryId=${c.categoryId}">编辑</a></td>
            <td><a class="delete" href="${pageContext.request.contextPath}/toDelete.category?categoryId=${c.categoryId}">删除</a></td>
        </tr>
        </c:forEach>
    </table>

<div style="text-align: center;" id="contextbottom">
    总记录数&nbsp;${requestScope.pageModel.recordCount}&nbsp;条&nbsp;共&nbsp;${requestScope.pageModel.totalPages}&nbsp;页&nbsp;
    <a href="${pageContext.request.contextPath}/queryAll.category?pageNo=1&likeValue=${requestScope.pageModel.likeValue}" id="firstPage">首页</a>&nbsp;
    <a href="${pageContext.request.contextPath}/queryAll.category?pageNo=${requestScope.pageModel.pageNo-1}&likeValue=${requestScope.pageModel.likeValue}" id="previousPage">上一页</a>&nbsp;
    <a href="${pageContext.request.contextPath}/queryAll.category?pageNo=${requestScope.pageModel.pageNo+1}&likeValue=${requestScope.pageModel.likeValue}" id="nextPage">下一页</a>&nbsp;
    <a href="${pageContext.request.contextPath}/queryAll.category?pageNo=${requestScope.pageModel.totalPages}&likeValue=${requestScope.pageModel.likeValue}" id="lastPage">尾页</a>&nbsp;
    第&nbsp;${requestScope.pageModel.pageNo}&nbsp;页
</div>


</body>
</html>
