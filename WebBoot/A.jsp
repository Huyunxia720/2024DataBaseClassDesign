<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="TutorPage.jsp" method="post">
        <input type="submit" value="登录" />
    </form>
    <%
        // 直接使用JSP隐式对象session存储导师号到session
        session.setAttribute("TNo", "001");
    %>
</body>
</html>