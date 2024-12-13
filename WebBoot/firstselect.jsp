<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="entity.Teacher" %>
<%@page import="entity.TeacherIndex" %>
<%@page import="entity.Student" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>初次选择页面</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	

  </head>
  
  <body>
  
  <h1>欢迎进行初选</h1>
  <% 
  	TeacherIndex teacherIndex= (TeacherIndex)session.getAttribute("teacherIndex");	
   %>
   <script type="text/javascript">
        var maxSelections = <%=teacherIndex.getIndexNo()%>; // 设置最大选择数量

        function checkSelection() {
            var checkboxes = document.getElementsByName("ExamNo");
            var selectedCount = 0;

            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    selectedCount++;
                }
            }

            if (selectedCount > maxSelections) {
                alert("你不能选择超过 " + maxSelections + " 个选项。");
                // 这里可以将最后一个选中的复选框取消选中
                checkboxes[checkboxes.length - 1].checked = false;
                return false;
            }
            return true;
        }
    </script>
  <h2>老师请注意，您一共有<%= teacherIndex.getIndexNo()%>个指标</h2>
  <h3>以下是可选学生名单</h3>
  	一志愿：<br>
  <% List<Student> choice1=(List<Student>) session.getAttribute("choice1"); 
  	if(choice1!=null){
   %>
   <form action="firstselect" method="post">
   
   <%
   		for(Student s1:choice1){
    %>
    	
    	<input type="checkbox" name="ExamNo" value="<%=s1.getExamNo()%>" onclick="return checkSelection()"/><%= s1.getSn()%><br>
    	<%} %>
    	<%} else{
    	%>
    	无<br>
    	<%
    	}%>
    二志愿：<br>
    <% List<Student> choice2=(List<Student>) session.getAttribute("choice2"); 
  	if(choice2!=null){
  		for(Student s2:choice2){
   %>
   <input type="checkbox" name="ExamNo" value="<%=s2.getExamNo()%>" onclick="return checkSelection()"/><%= s2.getSn()%><br>
    	<%} %>
    	<%} else{
    	%>
    	无<br>
    	<%
    	}%>
    	三志愿：<br>
    <% List<Student> choice3=(List<Student>) session.getAttribute("choice3"); 
  	if(choice3!=null){
  		for(Student s3:choice3){
   %>
   <input type="checkbox" name="ExamNo" value="<%=s3.getExamNo()%>" onclick="return checkSelection()"/><%= s3.getSn()%><br>
    	<%} %>
    	<%} else{
    	%>
    	无<br>
    	<%
    	}%>
    <input type="submit" value="选择"/><br>
   </form>
   <a href="allStudents">查看全部学生信息</a>
  </body>
</html>
