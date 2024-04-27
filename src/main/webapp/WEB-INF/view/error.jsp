<%@page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    	<c:choose>
    		<c:when test="${errortype eq 'invalidlogin'}">
    			Username or Password is invalid!
    		</c:when>
    		<c:otherwise>
    			Error
    		</c:otherwise>
    	</c:choose>
    	<br/>
    	<a href="/">Back to Login Page</a>
    </body>
</html>