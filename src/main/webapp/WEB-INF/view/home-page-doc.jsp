<%@page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
        	.login-card {
        		display: flex;
                height: 500px;
                width: 300px;
                border-radius: 5px;
                background-color: rgba(0, 255, 255, 0.6);
                text-align: center;
                justify-content: center;
            }
        </style>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>DocSched</title>
    </head>
    <body>
        <header class='navbar navbar-expand-lg navbar-light bg-light'>
            <div style="width:60%">
        		<h1>DocSched</h1>
           		<p>For Doctors</p>
        	</div>
            <div class='form-inline my-2 my-lg-0'>
                <form action="login" method="POST">
	                Username:
	                <input type="text" name="username" required/>
	                Password:
	                <input type="password" name="password" required/>
					<input type="hidden" name="doctor" value="doctor" required/>
	                <input type="submit" value="Login" />
                </form>
		        <a href="/">Are you a Patient?</a>
            </div>    
        </header>
        <div>
        	<form:form action="doctor/signup" method="POST" modelAttribute="doctor">
	        <div style='text-align:center;'>
	        	<div class="form-group">
					<label for="first_name">First Name*</label>
				    <form:input class="form-control" id="first_name" path="first_name" required="true" style='width: 350px; margin:auto'/>
	        	</div>
	        	<div class="form-group">
					<label for="last_name">Last Name*</label>
				    <form:input class="form-control" id="last_name" path="last_name" required="true" style='width: 350px; margin:auto'/>
	        	</div>
	        	<div class="form-group">
					<label for="email_address">Email:*</label>
				    <form:input type="email" class="form-control" id="email_address" path="email_address" required="true" style='width: 350px; margin:auto'/>
	        	</div>
	        	<div class="form-group">
					<label for="password">Password:*</label>
				    <form:input type="password" class="form-control" id="password" path="password" required="true" style='width: 350px; margin:auto'/>
	        	</div>
	        	<div class="form-group">
					<label for="specialization">Specialization:*</label>
				    <form:input class="form-control" id="specialization" path="specialization" required="true" style='width: 350px; margin:auto'/>
	        	</div>
	        	<div class="form-group">
					<label for="phone_number">Phone Number:*</label>
				    <form:input class="form-control" id="phone_number" path="phone_number" required="true" style='width: 350px; margin:auto'/>
	        	</div>
	        	<div class="form-group">
					<label for="zip_code">Zip Code:*</label>
				    <form:input class="form-control" id="zip_code" path="zip_code" required="true" style='width: 350px; margin:auto'/>
	        	</div>
	        	<input type="submit" value="Register"/>
	        </div>
        </form:form>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
