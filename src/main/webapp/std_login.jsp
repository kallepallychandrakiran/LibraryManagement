<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Student Login Page</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<head>
    <style>
      html,
      body {
        height: 100%;
        margin: 0;
        display: flex;
        align-items: center;
        justify-content: center;
        flex-direction: column;
      }

      form {
        display: flex;
        flex-direction: column;
        align-items: center;
      }
    </style>
  </head>
  <body>
   <div><h1>Student Login Page</h1></div> 
    <form action="./student/loginvalidate" method="post">
      <p>
        <label for="email">Student e-mail ID : </label>
        <input
          type="email"
          name="student_email"
          placeholder="Please enter you e-mail"
          id="email"
        />
      </p>
      <p>
        <label for="password">Student Password : </label>
        <input
          type="password"
          name="student_password"
          placeholder="Please enter you password"
          id="password"
        />
      </p>

      <p><button type="submit">Login</button></p>
      <p><a href="./stdsignup.jsp">Not Registered? Signup here</a></p>
      <p><a href="./admin_login.jsp">Are you admin? Click here</a></p>
    </form>
  </body>
</html>
