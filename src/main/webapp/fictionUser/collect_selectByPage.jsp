<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>收藏记录</title>
    <link rel="stylesheet" href="../css/query.css">
    <script>
        function toListPage(){
            window.location="FictionUser_selectByPage.jsp";
        }
    </script>
</head>
<body>
    <div id="top">当前位置： 用户管理 -- 查看用户收藏</div>
    <div id="contexttop">
        <div class="returnList"><button onclick="toListPage()">返回用户列表</button></div>
    <table border="1" id="tap">
        <tr>
            <td colspan="10">
                <form action=""> 
                <input type="text" placeholder="小说ID、小说名称、作者">
                <input type="submit" value="查询">
            
            </form>
            </td>
        </tr>
        <tr bgcolor="#e0fbc4">
            <th>小说ID</th>
            <th>类别</th> 
            <th>小说名称</th>
            <th>作者</th>
            <th>简要描述</th>
            <th>是否已经阅读</th>
            <th>封面</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>f1001</td>
            <td>玄幻</td>
            <td>晚唐浮生</td>
            <td>孤独麦克</td>
            <td>很有趣的书</td>
            <td>未阅读</td>
            <td><img src="../img/10000.jpg" alt="晚唐浮生" width="40" height="50"></td>
            <td><a href="">删除收藏</a></td>
        </tr>
        <tr>
            <td>f1001</td>
            <td>玄幻</td>
            <td>晚唐浮生</td>
            <td>孤独麦克</td>
            <td>很有趣的书</td>
            <td>未阅读</td>
            <td><img src="../img/10000.jpg" alt="晚唐浮生" width="40" height="50"></td>
            <td><a href="">删除收藏</a></td>
        </tr>
        <tr>
            <td>f1001</td>
            <td>玄幻</td>
            <td>晚唐浮生</td>
            <td>孤独麦克</td>
            <td>很有趣的书</td>
            <td>未阅读</td>
            <td><img src="../img/10000.jpg" alt="晚唐浮生" width="40" height="50"></td>
            <td><a href="">删除收藏</a></td>
        </tr>
        <tr>
            <td>f1001</td>
            <td>玄幻</td>
            <td>晚唐浮生</td>
            <td>孤独麦克</td>
            <td>很有趣的书</td>
            <td>未阅读</td>
            <td><img src="../img/10000.jpg" alt="晚唐浮生" width="40" height="50"></td>
            <td><a href="">删除收藏</a></td>
        </tr>
        <tr>
            <td>f1001</td>
            <td>玄幻</td>
            <td>晚唐浮生</td>
            <td>孤独麦克</td>
            <td>很有趣的书</td>
            <td>未阅读</td>
            <td><img src="../img/10000.jpg" alt="晚唐浮生" width="40" height="50"></td>
            <td><a href="">删除收藏</a></td>
        </tr>
        <tr>
            <td>f1001</td>
            <td>玄幻</td>
            <td>晚唐浮生</td>
            <td>孤独麦克</td>
            <td>很有趣的书</td>
            <td>未阅读</td>
            <td><img src="../img/10000.jpg" alt="晚唐浮生" width="40" height="50"></td>
            <td><a href="">删除收藏</a></td>
        </tr>


        
    </table>
    <div style="text-align: center;" id="contextbottom">
        总记录数&nbsp;8&nbsp;条&nbsp;共&nbsp;1&nbsp;页&nbsp;
        <a href="">首页</a>&nbsp;
        <a href="">上一页</a>&nbsp;
        <a href="">下一页</a>&nbsp;
        <a href="">尾页</a>&nbsp;
        第&nbsp;1&nbsp;页
    </div>
</body>
</html>