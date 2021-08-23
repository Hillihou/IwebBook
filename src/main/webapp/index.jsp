<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Soul
  Date: 2021/8/12
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="./css/index.css">
    <script type="text/javascript" src="./js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
      $(function () {
        $("#btn").click(function(){
          //1 获取用户名输入框里的内容
          var usernameText = $("#username").val();
          var trimName=  $.trim(usernameText);
          if(trimName==null||trimName==""){
            alert("用户名不能为空");
            return false;
          }

          var pwdText = $("#password").val();
          //2 创建正则表达式对象
          var trimpwd= $.trim(pwdText);
          if(trimpwd==null||trimpwd==""){
            alert("请输入密码");
            return false;
          }
        });
      });
    </script>
  </head>
  <body>
  <%
    Cookie[] cookies = request.getCookies();
    if (cookies!=null&&cookies.length>0){
      for (Cookie cookie:cookies){
        if ("username".equals(cookie.getName())){
          cookie.setMaxAge(0);//用于清除cookie
          response.addCookie(cookie);
        }
      }
    }
  %>

  <a href="<%=request.getContextPath()%>/queryAll.manager?pageNo=1">查询全部</a>
  <div id="total">
    <!-- <span class="errorMsg" style="float:none; position: absolute;
    color: red;top: 310px;right: 243px;"></span> -->
    <form action="${pageContext.request.contextPath}/loginAdmin" method="post">
      <table id="tab" border="0">
        <tr>
          <td>用户姓名:</td>
          <td><input type="text" placeholder="请输入用户名" name="username" id="username" value="jack"></td>
          <td style="color: red;position: absolute;font-size: 1px;">用户名错误</td>
        </tr>

        <tr>
          <td>用户密码:</td>
          <td><input type="password" placeholder="请输入用户密码" name="password" id="password" value="123456"></td>
          <td style="color: red;position: absolute;font-size: 1px;">密码错误</td>
        </tr>

        <tr>
          <td><input type="submit" value="登陆" name="sub_btn" id="btn"></td>
          <td><input type="reset" value="重置"></td>

        </tr>
      </table>
    </form>
  </div>



  </body>
</html>
