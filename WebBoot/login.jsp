<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/index";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录页面</title>
    <style>
        .container {
            width: 300px;
            margin: 0 auto;
            text-align: center;
        }
        .return-link {
            position: absolute;
            top: 10px;
            left: 10px;
        }
        .error {
            color: red;
            margin-bottom: 10px;
        }
    </style>
    <script>
        function validateForm() {
            var loginId = document.forms["loginForm"]["loginId"].value;
            var password = document.forms["loginForm"]["password"].value;
            if (loginId === "" || password === "") {
                alert("用户名或密码不能为空，请重新输入！");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <div class="container">
        <button class="return-link" onclick="location.href='?action=home'">返回首页</button>
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>
        <form name="loginForm" action="?action=login" method="post" onsubmit="return validateForm()">
            用户名: <input type="text" name="loginId"><br>
            密码: <input type="password" name="password"><br>
            <input type="submit" value="登录">
        </form>
    </div>
</body>
</html>