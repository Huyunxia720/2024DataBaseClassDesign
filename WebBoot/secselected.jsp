<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>复试选择页面</title>
    <style>
        #studentListButton {
            margin: 20px auto;
            text-align: center;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div id="studentListButton">
        <button onclick="location.href='SecSelectedServlet?action=showBoth'">展示待选择学生列表及导师信息</button>
    </div>
</body>
</html>