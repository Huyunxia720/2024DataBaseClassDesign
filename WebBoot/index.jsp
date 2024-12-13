<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <style>
        .container {
            width: 80%;
            margin: auto;
            text-align: center;
        }
        .return-link {
            position: absolute;
            top: 10px;
            left: 10px;
        }
        .login-link {
            position: absolute;
            top: 10px;
            right: 10px;
        }
        .publicity-link {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>硕士研究生录取页</h2>
        <button class="return-link" onclick="location.href='index?action=home'">返回首页</button>
        <button class="login-link" onclick="location.href='index?action=login'">登录</button>
        <div class="publicity-link">
            <button onclick="location.href='index?action=catalog'">招生目录</button>
        </div>
        <div class="publicity-link">
            <button onclick="location.href='index?action=publicity'">结果公示</button>
        </div>
    </div>
</body>
</html>