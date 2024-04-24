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
        	</div>
            <div class='form-inline my-2 my-lg-0'>
                <form action="login" method="POST">
	                Username:
	                <input type="text" name="username" required/>
	                Password:
	                <input type="password" name="password" required/>
	                <input type="submit" value="Login" />
                </form>
		        <a href="doctor">Are you a Doctor?</a>
            </div>    
        </header>
        <form:form action="signup" method="POST" modelAttribute="patient">
	        <div class="login-card">
	        	<div>
	        		First Name:* <br /> <br />
	        		Last Name:* <br /> <br />
	        		Email:* <br /> <br />
	        		Password:* <br /> <br />
	        		Date of Birth:* <br /> <br />
	        		Sex: <br /> <br />
	        	</div>
	        	<div>
	        		<form:input path="first_name" required="true" /> <br /> <br />	            
		            <form:input path="last_name" required="true" /> <br /> <br />		            
		            <form:input type="email" path="email_address" required="true" /> <br /> <br />		            
		            <form:input type="password" path="password" required="true" /> <br /> <br />		            	            
		            <form:input type="date" path="dob" required="true" /> <br /> <br />
		            Male<form:radiobutton path="sex" value="Male"/>  
        			Female<form:radiobutton path="sex" value="Female" />  
		            <input type="submit" value="Register"/>
	        	</div>            
	        </div>
        </form:form>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
