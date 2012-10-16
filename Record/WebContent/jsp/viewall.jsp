<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
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
</head>
<body class='container-fluid'>
<form method="get" action="Record/vas">
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
<li><a href="#contact">Modify User</a></li>
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
<p><a class="btn btn-success btn-large">Learn more about us....</a></p>
</div>
<table border="1" width="&lt;%">
		<tr>
			
			<th>First Name</th>
			<th>Last Name</th>
			<th>sex</th>
			<th>PhoneNO</th>
			<th>HouseNo</th>
			<th>City</th>
			<th>State</th>
			
		</tr>

		<c:forEach var="row" items="${userlist}">
			<tr>
				<td><c:out value="${row.firstName}"></c:out></td>
				<td><c:out value="${row.lastName}"></c:out></td>
				<td><c:out value="${row.sex}"></c:out></td>
				<td><c:out value="${row.phoneNo}"></c:out></td>
				<td><c:out value="${row.houseNo}"></c:out></td>
				<td><c:out value="${row.city}"></c:out></td>
				<td><c:out value="${row.state}"></c:out></td>

			</tr>
		</c:forEach>


</body>
</html>