<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>DocSched</title>
    </head>
    <body>
        <nav style="display:flex;justify-content:center;">
            <div style="width:60%">
        		<h1>DocSched</h1>
        	</div>
            <div style="display:grid; width:40%;">
                <form action="login.htm" method="POST">
	                Username:
	                <input type="text" name="username" required/>
	                Password:
	                <input type="password" name="password" required/>
	                <input type="submit" value="Login" />
                </form>
		        <a href="doctor">Are you a Doctor?</a>
            </div>    
        </nav>
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
    </body>
</html>
