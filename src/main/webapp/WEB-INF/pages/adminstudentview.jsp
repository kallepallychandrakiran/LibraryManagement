<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Students</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	
			<h3><a href="./adminview">go Back to Books section</a></h3>
			<h1>List of Students (ADMIN PANEL)</h1>
			
						<c:url var="deleteLink" value="/admin/deletestudent">
						<c:param name="bookId" value="${book.book_id}"/>
						</c:url>
			<table>
				<tr>
				<th>Student ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>FineAmount</th>
					<th>Issued Book 1</th>
					<th>Issued Book 2</th>
					<th>Issued Book 3</th>
					<th>Issued Date</th>
					<th>Delete Student</th>
					<th>Fine Received?</th>
				</tr>
				<c:forEach var="student" items="${students}">
				<c:url var="deleteLink" value="/admin/deletestudent">
						<c:param name="studentId" value="${student.student_id}"/>
						</c:url>
				<c:url var="YesLink" value="/admin/finereceived">
						<c:param name="studentId" value="${student.student_id}"/>
						</c:url>
					<tr>
						<td>${student.student_id}</td>
						<td>${student.student_name}</td>
						<td>${student.studentEmail}</td>
						<td>${student.fine_amount}</td>
						<td>${student.issued_book1}</td>
						<td>${student.issued_book2}</td>
						<td>${student.issued_book3}</td>
						<td>${student.issued_book_date}</td>
						<td><a href='${deleteLink}'>DELETE</a></td>
						<td><a href='${YesLink}'>YES</a></td>
					</tr>
				</c:forEach>
			</table>
</body>
</html>