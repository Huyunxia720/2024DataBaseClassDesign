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
    <title>录取公示</title>
    <style>
        .container {
            width: 80%;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ddd;
            background-color: #f9f9f9;
        }
        .return-link {
            position: absolute;
            top: 10px;
            left: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <button class="return-link" onclick="location.href='?action=home'">返回首页</button>
        <h2>录取公示</h2>
        <table>
            <tr>
                <th>教工号</th>
                <th>准考证号</th>
                <th>一级学科号</th>
                <th>二级学科号</th>
            </tr>
            <c:forEach items="${publicityList}" var="publicity">
                <tr>
                    <td>${publicity.TNo}</td>
                    <td>${publicity.examNo}</td>
                    <td>${publicity.disciplineNum}</td>
                    <td>${publicity.secondaryNum}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>