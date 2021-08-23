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
<html>
<head>
    <%
        //    List<Category> categories = (List<Category>) request.getAttribute("categories");
        PageModel pageModel = (PageModel) request.getAttribute("pageModel");
        List<Category> pageData = (List<Category>) pageModel.getPageData();

    %>
    <title>小说类别列表</title>
    <%--<style type="text/css">--%>
        <%--table{--%>
            <%--border-collapse: collapse;--%>
        <%--}--%>
        <%--table,td,th{--%>
            <%--border: 1px solid black;--%>
            <%--padding: 10px;--%>
            <%--text-align: center;--%>
        <%--}--%>
    <%--</style>--%>

    <script src="<%=request.getContextPath()%>/js/jquery-1.7.2.js"></script>
    <link rel="stylesheet" href="../css/query.css">
    <script>
        $(function () {
            //控制分页按钮是否可以用
            var pageNo=<%=pageModel.getPageNo()%>;
            var totalPage=<%=pageModel.getTotalPages()%>;
            if (pageNo==1){
                $("#firstPage").attr("href","#");
                $("#previousPage").attr("href","#");
            }if (pageNo==totalPage){
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
<div id="top">当前位置： 类别管理 -- 查看小说类别</div>
<div id="contexttop"></div>
    <a href="<%=request.getContextPath()%>/toAdd.category">新增一条记录</a>
    <table id="tap" border="1">
        <tr>
            <td colspan="6">
                <form action="<%=request.getContextPath()%>/queryAll.category" method="post">
                    <input type="text" placeholder="类别ID,类别名称，类别描述" name="likeValue" value="<%=pageModel.getLikeValue()==null?"":pageModel.getLikeValue()%>"/>
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
        <%for (Category c:pageData){%>
        <tr>
            <td><%=c.getCategoryId()%></td>
            <td><%=c.getCategoryName()%>    </td>
            <td><%=c.getCreateTime()%></td>
            <td><%=c.getDesc()%></td>
            <td><a href="<%=request.getContextPath()%>/toUpdate.category?categoryId=<%=c.getCategoryId()%>">编辑</a></td>
            <td><a class="delete" href="<%=request.getContextPath()%>/toDelete.category?categoryId=<%=c.getCategoryId()%>">删除</a></td>
        </tr>
        <%}%>

    </table>

    <div style="text-align: center;" id="contextbottom">
        总记录数&nbsp;<%=pageModel.getRecordCount()%>&nbsp;条&nbsp;共&nbsp;<%=pageModel.getTotalPages()%>&nbsp;页&nbsp;
        <a href="<%=request.getContextPath()%>/queryAll.category?pageNo=1&likeValue=<%=pageModel.getLikeValue()%>" id="firstPage">首页</a>&nbsp;

        <a href="<%=request.getContextPath()%>/queryAll.category?pageNo=<%=pageModel.getPageNo()-1%>&likeValue=<%=pageModel.getLikeValue()==null?"":pageModel.getLikeValue()%>" id="previousPage">上一页</a>&nbsp;
        <a href="<%=request.getContextPath()%>/queryAll.category?pageNo=<%=pageModel.getPageNo()+1%>&likeValue=<%=pageModel.getLikeValue()==null?"":pageModel.getLikeValue()%>" id="nextPage">下一页</a>&nbsp;
        <a href="<%=request.getContextPath()%>/queryAll.category?pageNo=<%=pageModel.getTotalPages()%>&likeValue=<%=pageModel.getLikeValue()==null?"":pageModel.getLikeValue()%>" id="lastPage">尾页</a>&nbsp;
        第&nbsp;<%=pageModel.getPageNo()%>&nbsp;页
    </div>

</body>


</html>
