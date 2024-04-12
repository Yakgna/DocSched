<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
        	.login-card {
                height: 500px;
                width: 300px;
                color: rgb(154, 109, 221);
                border-radius: 5px;
                background-color: rgba(0, 255, 255, 0.6);
                text-align: center;
                justify-content: center;
            }
        </style>
        <title>DocSched</title>
    </head>
    <body>
        <h1>DocSched</h1>
        <div class="login-card">
            <form action="login.htm" method="POST">
            Username:
            <input type="text" name="username" required/> <br />
            Password:
            <input type="password" name="password" required/> <br />
            <!-- Radio button for selecting Doctor -->
            <label>
                <input type="radio" name="userType" value="doctor" required/>
                Doctor
            </label>

            <!-- Radio button for selecting Patient -->
            <label>
                <input type="radio" name="userType" value="patient" checked/>
                Patient
            </label>
			<br />
            <input type="submit" value="Login"/>
            <p>New User?<a href="signup.htm">Register</a></p>
            </form>
        </div>
    </body>
</html>