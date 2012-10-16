<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript">  
      var xmlHttp  
      var xmlHttp
      function showState(str){
      if (typeof XMLHttpRequest != "undefined"){
      xmlHttp= new XMLHttpRequest();
      }
      else if (window.ActiveXObject){
      xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
      }
      if (xmlHttp==null){
      alert("Browser does not support XMLHTTP Request")
      return;
      } 
      var url="city.jsp";
      url +="?count=" +str;
      xmlHttp.onreadystatechange = stateChange;
      xmlHttp.open("GET", url, true);
      xmlHttp.send(null);
      }

      function stateChange(){   
      if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){   
      document.getElementById("city").innerHTML=xmlHttp.responseText   
      }   
      }
      </script> 
      
      <script type="text/javascript" >
      
      function validateForm()
{
var x=document.forms["user"]["firstName"].value;
var y=document.forms["user"]["lastName"].value;
if (x==null || x=="")
  {
  alert("First name must be filled out");
  return false;
  }
  if (y==null || y=="")
  {
  alert("Last name must be filled out");
  return false;
  }
}
      </script> 
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
<form name="user" method="post" action="/Record/ads" onsubmit="return validateForm()">
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
<p><a class="btn btn-success btn-large"href="http://vividiansoft.com/">Learn more about us....</a></p>
</div>

<div align ="center"><p><font color="red">Please enter the user details</font></p></div>

	<table class="table table-hover" class="table" align="center">
		<tr>
			<td><font align="center">FirstName</font></td>
			<td><input type="text" name="firstName" maxlength="50" value="" /></td>
		</tr>
		<tr>
			<td>LastName</td>
			<td><input type="text" name="lastName" maxlength="30" value="" /></td>
		</tr>
		<tr>
			<td>Sex</td>
			<td align="left"><input type="radio" name="sex" value="male">Male&nbsp;&nbsp;<input type="radio" name="sex" value="female">Female</td>
		</tr>
		<tr>
			<td>PhoneNo</td>
			<td><input type="text" name="phoneNo" maxlegth="30" value="" /></td>
		</tr>
		<tr>
			<td >House No</td>
			<td><input type="text" name="houseNo" maxlength="12" value="" /></td>
		</tr>
		
		<tr>
			<td>State</td>
			<td><select name='state' onchange="showState(this.value)">  
       <option value="none">Select</option>  
    <%
 Class.forName("com.mysql.jdbc.Driver").newInstance();  
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");  
 Statement stmt = con.createStatement();  
 ResultSet rs = stmt.executeQuery("Select * from state");
 while(rs.next()){
     %>
      <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>  
      <%
 }
     %>
     <tr>
     <td>City</td>
     <td>
      </select>  
      <br>  
      <div id='city'>  
      <select name='city' >  
      <option value='-1'></option>  
      </select>  
      </div>  </td>
		</tr>
		
		</table>
			<table align="center">
				<tr>
					<td><input type="submit" id="save" value="Save" ></input> </td>
					
					<td> <input type="reset" name="clear" value="Clear"></input>&nbsp;</td>
				</tr>
			</table>
</form>

</body>
</html>