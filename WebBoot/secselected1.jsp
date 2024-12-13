<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>复试选择详细信息页面</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        .info {
            margin-bottom: 20px;
        }
        .return-button {
            display: block;
            margin: 20px auto;
            text-align: center;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
    <script>
        function confirmSelection() {
            return confirm('是否确认选择？');
        }
    </script>
</head>
<body>
    <div class="info">
        <h2>导师信息</h2>
        <c:forEach items="${teacherIndices}" var="index">
            <p>教工号：${index.TNo}，一级学科号：${index.disciplineNum}，二级学科号：${index.secondaryNum}</p>
            <input type="hidden" name="tNo" value="${index.TNo}">
            <input type="hidden" name="disciplineNum" value="${index.disciplineNum}">
            <input type="hidden" name="secondaryNum" value="${index.secondaryNum}">
        </c:forEach>
    </div>
    <div>
        <h2>可选学生列表</h2>
        <c:if test="${not empty students}">
            <form action="SecSelectedServlet" method="post" onsubmit="return confirmSelection()">
                <input type="hidden" name="action" value="confirmSelection">
                <table>
                    <tr>
                        <th>准考证号</th>
                        <th>选择</th>
                    </tr>
                    <c:forEach items="${students}" var="student">
                        <tr>
                            <td>${student.examNo}</td>
                            <td><input type="radio" name="selectedStudent" value="${student.examNo}" required></td>
                        </tr>
                    </c:forEach>
                </table>
                <input type="submit" value="提交">
            </form>
        </c:if>
        <c:if test="${empty students}">
            <p>没有待选择的学生。</p>
        </c:if>
    </div>
    <div class="return-button">
        <button onclick="location.href='secselected.jsp'">返回</button>
    </div>
</body>
</html>