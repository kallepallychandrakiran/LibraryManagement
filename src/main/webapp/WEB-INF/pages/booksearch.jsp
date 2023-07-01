<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Students</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>

</head>
<body>
			<h2>Search Results</h2>
			<a href="../student/studentview">Go back</a>
		<table>
				<tr>
					<th>Book ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Category</th>
				</tr>
				<c:forEach var="book" items="${books}">
				
				
					<tr>
						<td>${book.book_id}</td>
						<td>${book.book_title}</td>
						<td>${book.book_author}</td>
						<td>${book.book_category}</td>
						
					</tr>
				</c:forEach>
			</table>
			
</body>
</html>