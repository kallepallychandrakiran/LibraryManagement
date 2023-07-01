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

	<h2>Add New Book</h2>
	
	<form:form action="../book/saveBook" method="post" modelAttribute="book">
			<table>
				<tbody>
					<tr>
						<td>
							Title
						</td>
						<td>
							<form:input path="book_title"/>
						</td>
					</tr>
					
					<tr>
						<td>
							Author
						</td>
						<td>
							<form:input path="book_author"/>
						</td>
					</tr>
					
					<tr>
						<td>
							Category
						</td>
						<td>
							<form:input path="book_category"/>
						</td>
					</tr>
					<tr>
						<td>
							
						</td>
						<td>
							<input type='submit' value='save' class='save'/>
						</td>
					</tr>
				
				</tbody>
			</table>	
		</form:form>

</body>
</html>