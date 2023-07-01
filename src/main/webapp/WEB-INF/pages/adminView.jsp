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
			<h3><a href="studentlist">go to List of Students</a></h3>
			<h1>List of Books (ADMIN PANEL)</h1>
		
			<!-- put new button:: Add Customer -->
			<input type='button' value='Add Book'
				onclick="window.location.href='showForm'; return false;"
				class="add-button" />
				
				
			<table>
				<tr>
					<th>Book ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Category</th>
					<th>Issue Book</th>
					<th>Update Book</th>
					<th>Delete Book</th>
				</tr>
				<c:forEach var="book" items="${books}">
				
				<c:url var="issueLink" value="/admin/showissueform">
						<c:param name="bookId" value="${book.book_id}"/>
					</c:url>
					
					<c:url var="updateLink" value="/admin/showupdateform">
						<c:param name="bookId" value="${book.book_id}"/>
					</c:url>
						<c:url var="deleteLink" value="/admin/deletebook">
						<c:param name="bookId" value="${book.book_id}"/>
					</c:url>
					
					<tr>
						<td>${book.book_id}</td>
						<td>${book.book_title}</td>
						<td>${book.book_author}</td>
						<td>${book.book_category}</td>
						<td><a href='${issueLink}'>ISSUE</a></td>
						<td><a href='${updateLink}'>UPDATE</a></td>
						<td><a href='${deleteLink}'>DELETE</a></td>
					</tr>
				</c:forEach>
			</table>
	
</body>
</html>