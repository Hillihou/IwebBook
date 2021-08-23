<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>menu</title>
    <link rel="stylesheet" href="./css/menu.css">
</head>
<body>
    <!-- <form action="">
    数字<input type="number" name="num" max="100" min="0" step="1"><br>
    搜索<input type="search" name="" id=""><br>
    滑块<input type="range" name="" max="100" min="0" step="2"><br>
    邮箱<input type="email"><br>
    url<input type="url"><br>
    <input type="submit" name="" id=""> -->
    <!-- <script src="./js/menu.js" type="text/javascript" charset="utf-8"></script> -->
<script src="./js/jquery-1.7.2.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () { 
        $("dd").slideUp(0);
        $("dt").click(function(){
        // alert(this);
       $(this).nextAll("dd").slideToggle(300);
    });
     });
    
</script>
    <div class="divmenu">
        <dl>
            <dt onclick="menu(this.parentNode)">类别管理</dt>
            <dd>
                <a href="${pageContext.request.contextPath}/category_toAdd.jsp" target="show">添加类别</a>
            </dd>
            <dd>
                <a href="${pageContext.request.contextPath}/queryAll.category" target="show">查看类别</a>
            </dd>
        </dl>
    </div>

    <div class="divmenu">
        <dl>
            <dt onclick="menu(this.parentNode)">小说管理</dt>
            <dd>
                <a href="./fiction/fiction_toAdd.html" target="show">添加小说</a>
            </dd>
            <dd>
                <a href="./fiction/fiction_selectBypage.html" target="show">查看小说</a>
            </dd>
        </dl>
    </div>
    

    <div class="divmenu">
        <dl>
            <dt onclick="menu(this.parentNode)">用户管理</dt>
            <dd>
                <a href="./fictionUser/FictionUser_selectByPage.html" target="show">查看用户</a>
            </dd>
        </dl>
    </div>
    <div class="divmenu">
        <dl>
            <dt onclick="menu(this.parentNode)">消息管理</dt>
            <dd>
                <a href="./notice/notice_toAdd.html" target="show">发送消息</a>
            </dd>
            <dd>
                <a href="./notice/notice_content.html" target="show">查看消息</a>
            </dd>
        </dl>
    </div>

    <div class="divmenu">
        <dl>
            <dt onclick="menu(this.parentNode)">管理员管理</dt>
            <dd>
                <a href="${pageContext.request.contextPath}/toAdd.manager" target="show">添加管理员</a>
            </dd>
            <dd>
                <a href="${pageContext.request.contextPath}/queryAll.manager" target="show">查看管理员</a>
            </dd>
            <dd>
                <a href="${pageContext.request.contextPath}/manager/manager_toUpdatePassword.jsp" target="show">修改密码</a>
            </dd>
        </dl>
    </div>

</form>
</body>
</html>