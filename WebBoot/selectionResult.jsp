<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>第一轮选择结果</title>
</head>
<body>
    <h1>第一轮选择结果</h1>
    <c:if test="${not empty firstDisciplineNum and not empty firstSecondaryNum}">
        <p>一级学科号：${firstDisciplineNum}</p>
        <p>二级学科号：${firstSecondaryNum}</p>
    </c:if>
    <c:if test="${empty firstDisciplineNum and empty firstSecondaryNum}">
        <p>所有专业均已选完。</p>
    </c:if>
</body>
</html>