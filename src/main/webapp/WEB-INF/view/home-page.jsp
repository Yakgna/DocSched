<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DocSched</title>
    </head>
    <body>
        <h1>DocSched</h1>
        <form action="login.htm" method="GET">
            <!-- Radio button for selecting Doctor -->
            <label>
                <input type="radio" name="userType" value="doctor"/>
                Doctor
            </label>

            <!-- Radio button for selecting Patient -->
            <label>
                <input type="radio" name="userType" value="patient"/>
                Patient
            </label>

            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
