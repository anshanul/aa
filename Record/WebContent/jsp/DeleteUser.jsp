<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="/Record/css/record.css" rel="stylesheet"> 
<link href="/Record/css/bootstrap-responsive.css" rel="stylesheet">

<style type="text/css">
div h1 {
   color:red;
}
</style>
<script type="text/javascript" >
      
      function validateForm()
{
var x=document.forms["user"]["firstName"].value;

if (x==null || x=="")
  {
  alert("First name must be filled out");
  return false;
  }
  
}
      </script> 
</head>
<body class='container-fluid'>
<form name="user" method="get" action="/Record/dus" onsubmit="return validateForm()">
<div class="navbar navbar-fixed-top ">
<div class="navbar-inner">
<div class="container-fluid"> 
<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</a>
<a class="brand" href="#"></a>
<div class="nav-collapse text-inverse">
<ul class="nav text-danger">
<li class="active"><a href="Home.jsp">Home</a></li>
<li><a href="adduser.jsp">Add User</a></li>
<li><a href="updateuser.jsp">Modify User</a></li>
<li><a href="DeleteUser.jsp">Remove User</a></li>
<li><a href="viewbyname.jsp">View User</a></li>
<li><a href="viewall.jsp">View All</a></li>
<li><a href="http://vividiansoft.com/">Our Products</a></li>
<li><a href="http://vividiansoft.com/">Services</a></li>
<li><a href="http://vividiansoft.com/">Contact Us</a></li>
</ul>
</div>
</div>
</div>
</div>
<div class="hero-unit  btn-primary">
<h1 class='text-warning'>Web Learnings Inc.</h1>
<p class='lead text-important'>Learn,demonstrate,& execute platform for Web technologies</p>
<p><a class="btn btn-success btn-large" href="http://vividiansoft.com/">Learn more about us....</a></p>
</div>
<div >
            <table align="center">
		<tr>
			<td >Please Enter FirstName</td>
			<td><input type="text" name="firstName" maxlength="50" value="" /></td>
		</tr>
		</table>
		<table align="center">
				<tr>
					<td><input type="submit" name="remove" value="Remove User" /></td>
					
				</tr>
			</table>
</div>

</body>
</html>