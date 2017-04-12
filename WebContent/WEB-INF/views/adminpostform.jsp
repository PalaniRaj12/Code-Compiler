<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin </title>
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
      <a class="navbar-brand" href="">Gamification String</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Login <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="adminloginform.html">Admin</a></li>
	  <li><a href="userloginform.html">User</a></li>
        </ul>
      </li>
      <li><a href="registration.html">Register</a></li>
      <li><a href="">About</a></li>
    </ul>
     <ul class="nav navbar-nav"  style="float: right; margin-right: 70px;">
    	<li><a href="adminloginform.html"><b>Log out</b></a></li>
    </ul>
  </div>
</nav>
<div class="adminpost">
<form:form method="Post" action="adminpostform.html"
	commandName="adminForm">
	<br>
	<br>
		
	
	<table style="margin-left: 100px; border-collapse:separate; border-spacing: 5px 10px;">
		
		<tr>
			<td><h5 align="center">Question No.</h5></td>
			<td align="center">
				<form:select id="option" cols="5" rows="1" path="questionId">
				<form:option value="1" label="1"/>
				<form:option value="2" label="2"/>
				<form:option value="3" label="3"/>
				</form:select>
			</td>
			<td><h6><form:errors path="questionId"/></h6></td>
		</tr>
		<tr>
			<td style="width: 600px;"><h5 align="center">String Based Problem</h5></td><td>
			<form:textarea style="width: 400px;" cols="30" required="required" rows="3" path="question" />
			</td>
			<td><h6><form:errors	path="question" /></h6></td>
		</tr>
		<tr>
			<td><h5 align="center">Input String</h5></td><td><form:textarea cols="30" rows="1" path="inputString" /></td>
			<td><h6><form:errors path="inputString" required="required" /></h6></td>
		</tr>
		<tr>
			<td><h5 align="center">Resultant String</h5></td><td><form:textarea cols="30" rows="1" path="resultantString" /></td>
			<td><h6><form:errors path="resultantString" required="required" /></h6></td>
		</tr>
		<tr>
			<td><h5 align="center">Condition</h5></td><td><form:textarea cols="30" rows="3" path="condition" /></td>
			<td><h6><form:errors	path="condition" /></h6></td>
			</tr><tr><td></td>
			<td align="center"><input type="submit" style="background-color: #4a77d4;" class="btn btn-primary btn-block btn-large"  value="Post" /></td>
		</tr>
		<tr>
		<td></td><td><p align="center" style="color: #fff;"><%=session.getAttribute("post")==null?"":session.getAttribute("post") %></p></td>
		</tr>
	</table>
</form:form>
</div>
</body>
</html>