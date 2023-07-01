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
			<h2>List of Books</h2>
			<c:set var="student" value="${student}" />
			
			
			<c:set var="count" value="0" />

<c:if test="${empty student.issued_book1}">
    <c:set var="count" value="${count + 1}" />
</c:if>

<c:if test="${empty student.issued_book2}">
    <c:set var="count" value="${count + 1}" />
</c:if>

<c:if test="${empty student.issued_book3}">
    <c:set var="count" value="${count + 1}" />
</c:if>


        


 
<h3>Welcome ${student.student_name} </h3>     
   <form action="../book/search" method="GET">
<div class="wrap">
   <div class="search">
      <input type="text"  name="keyword" class="searchTerm" id="keyword" placeholder="search by title / author / category">
      <button type="submit" for="keyword"  class="searchButton" onclick="encodeAndSearch()">
        <i class="fa fa-search"></i>
     </button>
   </div>
</div>   
</div>     
     </form>
        
        <script>
function encodeAndSearch() {
  var searchTerm = document.getElementById("keyword").value;
  var encodedSearchTerm = encodeURIComponent(searchTerm);
  var actionUrl = "../book/search?keyword=" + encodedSearchTerm;
  
  // Perform the search by navigating to the encoded URL
  window.location.href = actionUrl;
}
</script>

        
        
        
        
<p>You are authorized to borrow ${count} books.</p>
<c:choose>
    <c:when test="${student.fine_amount==0}">
        <p>You don't have any outstanding fines</p>
    </c:when>
    <c:when test="${!empty student.fine_amount}">
        <p>You have an oustanding fine of ${student.fine_amount} rupees</p>
    </c:when>
</c:choose> 

			<table>
				<tr>
					<th>Book ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>Category</th>
				</tr>
				<c:forEach var="book" items="${books}">
				
				<c:url var="getLink" value="/student/getbook">
						<c:param name="bookId" value="${book.book_id}"/>
					</c:url>
					
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