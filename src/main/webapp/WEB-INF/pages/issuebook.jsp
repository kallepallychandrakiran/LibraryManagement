<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/add-book-style.css" />
<body>

	<h2>Book Issue Form</h2>
	<!-- need to associate this data with customer id -->
			
	
	<form:form action="issuebook" method="get" modelAttribute="book">
	<form:hidden path="book_id"/>
			<table>
				<tbody>
				<tr>
						<td>
							Book_ID
						</td>
						<td>
							<form:input path="book_id" disabled="true"/>
						</td>
					</tr>
					
					<tr>
						<td>
							Title
						</td>
						<td>
							<form:input path="book_title" disabled="true"/>
						</td>
					</tr>
					
					<tr>
						<td>
							Author
						</td>
						<td>
							<form:input path="book_author" disabled="true"/>
						</td>
					</tr>
					
					<tr>
						<td>
							Category
						</td>
						<td>
							<form:input path="book_category" disabled="true"/>
						</td>
					</tr>
					<tr>
						<td>
							Student ID
						</td>
						<td>
							<input type="text" name="studentId" placeholder="Enter Student ID" />
							
						</td>
					</tr>
					
					
					<tr>
						<td>
							<input type='submit' value='ISSUE' class='save'/>
						</td>
					</tr>
				
				</tbody>
			</table>	
		</form:form>

</body>
</html>