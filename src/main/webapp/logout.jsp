<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.removeAttribute("dn");
System.out.println("Bạn đã đăng xuất");
response.sendRedirect("dangdangnhapcontroller");
%>


</body>
</html>