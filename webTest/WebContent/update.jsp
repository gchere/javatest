<%@page import="java.util.Enumeration"%>
<%@page import="student.StudentScore"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>	
<form action="/webTest/servlet/UpDateServlet">
	<%
		//int x = Integer.parseInt(request.getParameter("name"));
		Enumeration enum1 =request.getParameterNames();
		//int x = (int)(session.getAttribute("index"));
		ServletContext sc = this.getServletContext();
		while(enum1.hasMoreElements()){
			String a = (String)enum1.nextElement();
			int x=Integer.parseInt(a);
			session.setAttribute("index", x);
		List<StudentScore> list = (List<StudentScore>)sc.getAttribute("list");
		
			
		%>
		
	<h1>修改学生成绩信息：</h1>
	姓名：<input type="text" name = 'stuName' value="<%= list.get(x).getName()%>"><br/>
	班级：<input type="text" name = 'stuClass' value="<%= list.get(x).getClss()%>"><br/>
	课程：<input type="text" name = 'stuCourse' value="<%= list.get(x).getCourse()%>"><br/>
	分数：<input type="text" name = 'stuScore' value="<%= list.get(x).getScore()%>"><br/>
	<input type="submit" value="update"><br/>
	<%
		}
	
	%>
	</form>

</body>
</html>