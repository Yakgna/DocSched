<%@page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DocSched</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    </head>
    <body>
        <header class='navbar navbar-expand-lg navbar-light bg-light'>
            <div style="width:60%">
        		<h1>DocSched</h1>
        	</div>
            <div class='form-inline my-2 my-lg-0'>
                <a href="/?action=logout">Logout</a>
            </div> 
        </header>
        <div style='display: flex; gap: 30px; width: 400px;'>
	          <a href='?dashboard=appointments'>Appointments</a>
	          <a href='?dashboard=book'>Book Appointments</a>
	    </div> 
		<div>
			<form method='POST' action='?dashboard=appointments'>
				<label for='doctor'>Select the Doctor you want to consult: </label>
				<select name="doctor" id="doctor">
					<c:forEach items='${doctors}' var='doc'>
						<option value='${doc.email_address}'>${doc.first_name} ${doc.last_name}</option>
	        		</c:forEach>
        		</select> <br/><br/>
        		<label for="appointmentdate">Appointment Date and Time:</label>
    			<input type="datetime-local" id="appointmentdate" name="appointmentdate"/> <br/><br/>
    			<label for="symptoms">Symptoms:</label>
    			<textarea id="symptoms" name="symptoms" rows="5" cols="50" placeholder="Write your symptoms here..."></textarea> <br/><br/>
    			<input type="submit" value="Book Appointment" />
			</form>
		</div>
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>