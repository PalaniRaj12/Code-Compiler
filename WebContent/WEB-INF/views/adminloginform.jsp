<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" type="text/css" href="style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Gamification String</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="index.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Login <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li class="active"><a href="adminloginform.html">Admin</a></li>
	  <li><a href="userloginform.html">User</a></li>
        </ul>
      </li>
      <li><a href="registration.html">Register</a></li>
      <li><a href="#">About</a></li>
    </ul>
  </div>
</nav>
<div class="login">
<h1>Admin Login Form</h1>
<form:form action="adminloginform.html"  commandName="loginForm">
	<table>
		<tr>
			<td><h6>
			<form:errors	path="email" /></h6></td>
		</tr>
		<tr>
			<td><form:input placeholder="Email" path="email" required="required"/></td>
		</tr>
		<tr>
			<td><h6><form:errors	path="password" /></h6></td>
		</tr>
		<tr>
			<td><form:password style="width: 300px;" placeholder="Password" path="password" required="required"/></td>
		</tr>
		<tr>		
			<td><input type="submit" style="background-color: #4a77d4;" class="btn btn-primary btn-block btn-large" value="Login" /></td>
		</tr>
	</table>
</form:form>
</div>
</body>
</html>