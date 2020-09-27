<%--
  Created by IntelliJ IDEA.
  User: Echo
  Date: 2020/9/23
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<head>
  <meta charset="UTF-8">
  <title>登录界面</title>
</head>
<body>
<div class="panel panel-info">
  <div class="panel-heading" align="center">客户信息管理系统</div>
  <div align="center" class="panel-body">
    <form action="login" method="post">
    用户名:<input type="text" name="name" class="form-control" value="请输入用户名" style="width:450px"><br/>
    密码:<input type="password" name="password" class="form-control" style="width:450px"><br/>
    <input type="submit" class="btn btn-primary" align="center" value="登录">
    </form>
  </div>
</div>

</body>
</html>