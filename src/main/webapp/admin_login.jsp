<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Page</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
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

<body>
<h1>Welcome Admin</h1>
    <form action="./admin/loginvalidate" method="post">
      <p>
        <label for="email">Admin e-mail ID : </label>
        <input
          type="email"
          name="admin_email"
          placeholder="Please enter you e-mail"
          id="email"
        />
      </p>
      <p>
        <label for="password">Admin Password : </label>
        <input
          type="password"
          name="admin_password"
          placeholder="Please enter you password"
          id="password"
        />
      </p>

      <p><button type="submit">Login</button></p>
      <p>
        <a href="std_login.jsp">Are you student? Click here</a>
      </p>
    </form>
</body>
</html>