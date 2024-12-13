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
    <title>招生目录</title>
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
        <h2>招生目录</h2>
        <table>
            <tr>
                <th>教工号</th>
                <th>一级学科编号</th>
                <th>二级学科编号</th>
                <th>导师身份</th>
                <th>年度</th>
                <th>是否具有当年招生资格</th>
            </tr>
            <c:forEach items="${catalogList}" var="catalog">
                <tr>
                    <td>${catalog.TNo}</td>
                    <td>${catalog.disciplineNum}</td>
                    <td>${catalog.secondaryNum}</td>
                    <td>${catalog.TIdentity}</td>
                    <td>${catalog.CYear}</td>
                    <td>${catalog.isQualification}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>