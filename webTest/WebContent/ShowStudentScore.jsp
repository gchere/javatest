<%@page import="student.StudentScore"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style type="text/css">
table {
	width: 50%;
	
	
	text-align: center;
}
td {
	width: 100px;
	height: 30px;
	
	padding: 0px;
}
</style>
</head>
<body>
<div style="text-align: center">
	<h1>学生成绩表</h1>
<form name = "fm" id = "fm">
	<a href="add.html">
	<input type="button" value="add">
	</a>
	<input type="submit" value="update" onclick="document.fm.action='update.jsp';document.fm.submit();">
	<input type="submit" value="delete" onclick="document.fm.action='delete.jsp';document.fm.submit();">
	<input type="button" value="select">
</div>
<hr/>
<div>
	<table id="st">
		<tr>
			<td> </td>
			<td>姓名</td>
			<td>班级</td>
			<td>课程</td>
			<td>分数</td>
			<%
		ServletContext sc = this.getServletContext();
		List<StudentScore> list = (List<StudentScore>)sc.getAttribute("list");
		if(list!=null){
		%>
			<%
				for(int i = 0;i<list.size();i++){
			%>
			<tr id="<%=i %>">
			<td><input type="checkbox" name="<%=i%>"></td>
			
				<td><%=list.get(i).getName() %></td>
				<td><%=list.get(i).getClss() %></td>
				<td><%=list.get(i).getCourse() %></td>
				<td><%=list.get(i).getScore() %></td>
			</tr>
				<%
				}
				}
				%>
		</tr>
	</table>
</div>
</form>
</body>
</html>