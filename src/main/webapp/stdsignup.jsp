<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>Student Signup</title>
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
   <div><h1>Student Signup Page</h1></div> 
    <form action="./student/signup" method="post">
    
    <p>
        <label for="student_name">Student Name : </label>
        <input
          type="text"
          name="student_name"
          placeholder="Please enter your name"
          id="name"
          required="true"
        />
      </p>
     
     
     
      <p>
        <label for="email">Student e-mail ID : </label>
        <input
          type="email"
          name="student_email"
          placeholder="Please enter you e-mail"
          id="email"
          required="true"
        />
      </p>
      <p>
        <label for="password">Student Password : </label>
        <input
          type="password"
          name="student_password"
          placeholder="Please enter you password"
          id="password"
          required="true"
        />
      </p>

      <p><button type="submit">Signup</button></p>
      <p><a href="./std_login.jsp">Already Registered? Login here</a></p>
      <p><a href="./admin_login.jsp">Are you admin? Click here</a></p>
    </form>
  </body>
</html>
