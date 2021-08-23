<%--
  Created by IntelliJ IDEA.
  User: Soul
  Date: 2021/8/22
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="text-align: center;" id="contextbottom">
    总记录数&nbsp;${requestScope.pageModel.recordCount}&nbsp;条&nbsp;共&nbsp;${requestScope.pageModel.totalPages}&nbsp;页&nbsp;
    <a href="${pageContext.request.contextPath}/queryAll.category?pageNo=1&likeValue=${requestScope.pageModel.likeValue}" id="firstPage">首页</a>&nbsp;
    <a href="${pageContext.request.contextPath}/queryAll.category?pageNo=${requestScope.pageModel.pageNo-1}&likeValue=${requestScope.pageModel.likeValue}" id="previousPage">上一页</a>&nbsp;
    <a href="${pageContext.request.contextPath}/queryAll.category?pageNo=${requestScope.pageModel.pageNo+1}&likeValue=${requestScope.pageModel.likeValue}" id="nextPage">下一页</a>&nbsp;
    <a href="${pageContext.request.contextPath}/queryAll.category?pageNo=${requestScope.pageModel.totalPages}&likeValue=${requestScope.pageModel.likeValue}" id="lastPage">尾页</a>&nbsp;
    第&nbsp;${requestScope.pageModel.pageNo}&nbsp;页
</div>
