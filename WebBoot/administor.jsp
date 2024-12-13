<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.TeacherIndex" %>
<%@ page import="java.util.List" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员页面</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  </head>
  
  <body>
  	<h1>欢迎进入管理员页面</h1>
  	<% List<TeacherIndex> teacherIndexs=(List<TeacherIndex>)request.getSession().getAttribute("teacherIndexs");%>
  	<h3>导师指标表</h3>
  	<%if(teacherIndexs==null || teacherIndexs.isEmpty())
  	{
  	 %>
  	 <p>导师指标表为空</p>
  	 <%
  	 }else{
  	  %>
  	  <table border="1">
  	  		<tr>
  	  			<th>教工号</th>
  	  			<th>导师姓名</th>
  	  			<th>一级学科编号</th>
  	  			<th>二级学科编号</th>
  	  			<th>指标数</th>
  	  			
  	  		</tr>
  	  	<%
  	  		for(TeacherIndex teacherIndex:teacherIndexs){
  	  			
  	  	 %>
  	  	 	<tr>
  	  	 		<td><%=teacherIndex.getTNo() %></td>
  	  	 		<td><%=teacherIndex.getTN() %></td>
  	  	 		<td><%=teacherIndex.getDisciplineNum() %></td>
  	  	 		<td><%=teacherIndex.getSecondaryNum() %></td>
  	  	 		<td><%=teacherIndex.getIndexNo() %></td>
  	  	 	</tr>
  	  	 <%
  	  	 }}
  	  	 %>
  	  </table>
  	  
  	  <h3>请输入要修改的导师指标数的信息</h3>
  	  <form action="administorServlet" method="post">
  	  教工号：<input type="text" name="tno"><br>
  	  一级学科编号：<input type="text" name="disciplineNum"><br>
  	  二级学科编号：<input type="text" name="secondaryNum"><br>
  	  指标数修改为：<input type="text" name="indexNo"><br>
  	  <input type="submit" value="修改">
  	  </form>
  </body>
</html>
