<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>所有学生信息</title>
    <style>
        table, th, td {
            border: 0.8px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            font-size: 12px; /* 设置字体大小 */
        }
        h1, h2 {
            font-size: 16px; /* 设置标题字体大小 */
        }
        form {
            margin-bottom: 10px; /* 表单与表格之间的间距 */
        }
    </style>
</head>
<body>
    <h1>搜索学生信息</h1>
    <form action="searchStudent" method="get">
        准考证号：<input type="text" name="examNo" />
        <input type="submit" value="搜索" />
    </form>

    <c:if test="${not empty student}">
        <!-- 添加返回链接 -->
        <a href="allStudents" style="font-size: 14px;">返回所有学生信息</a>
        
        <!-- 只显示搜索到的学生信息 -->
        <h2>学生信息</h2>
        <table>
            <tr>
                <th>准考证号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>身份证号</th>
                <th>出生日期</th>
                <th>邮箱</th>
                <th>个人电话</th>
                <th>紧急联系人电话</th>
                <th>考生类别</th>
                <th>生源地</th>
                <th>本科学校</th>
                <th>学科类型</th>
                <th>本科专业</th>
                <th>本科毕业时间</th>
                <th>初试成绩</th>
                <th>复试成绩</th>
                <th>个人简历</th>

            </tr>
            <tr>
                <td>${student.examNo}</td>
                <td>${student.sn}</td>
                <td>${student.sex}</td>
                <td>${student.idNo}</td>
                <td>${student.birthdate}</td>
                <td>${student.email}</td>
                <td>${student.SNumber}</td>
                <td>${student.emergenNumber}</td>
                <td>${student.SCategory}</td>
                <td>${student.province}</td>
                <td>${student.undergraSchool}</td>
                <td>${student.disType}</td>
                <td>${student.undergraMajor}</td>
                <td>${student.undergraTime}</td>
                <td>${student.preScores}</td>
                <td>${student.fushi}</td>
                <td>${student.SResume}</td>

            </tr>
        </table>
    </c:if>
    <c:if test="${empty student}">
        <!-- 显示所有学生信息 -->
        <h1>所有学生信息</h1>
        <table>
            <tr>
                <th>准考证号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>身份证号</th>
                <th>出生日期</th>
                <th>邮箱</th>
                <th>个人电话</th>
                <th>紧急联系人电话</th>
                <th>考生类别</th>
                <th>生源地</th>
                <th>本科学校</th>
                <th>学科类型</th>
                <th>本科专业</th>
                <th>本科毕业时间</th>
                <th>初试成绩</th>
                <th>复试成绩</th> 
                <th>个人简历</th>

            </tr>
            <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.examNo}</td>
                <td>${student.sn}</td>
                <td>${student.sex}</td>
                <td>${student.idNo}</td>
                <td>${student.birthdate}</td>
                <td>${student.email}</td>
                <td>${student.SNumber}</td>
                <td>${student.emergenNumber}</td>
                <td>${student.SCategory}</td>
                <td>${student.province}</td>
                <td>${student.undergraSchool}</td>
                <td>${student.disType}</td>
                <td>${student.undergraMajor}</td>
                <td>${student.undergraTime}</td>
                <td>${student.preScores}</td>
                <td>${student.fushi}</td>
                <td>${student.SResume}</td>

            </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>