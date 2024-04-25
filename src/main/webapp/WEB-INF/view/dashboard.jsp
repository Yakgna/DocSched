<%@page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DocSched</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
			<h1>Appointment History</h1>
			<table class="table">
		        <tr>
		            <th>Appointment Date</th>
		            <th>Symptoms</th>
		            <th>Doctor Name</th>
		            <th>Appointment Status</th>
		        </tr>
		        <c:forEach items='${appointments}' var='appointment'>
		        	<tr>
		        		<td>${appointment.appointmentDate}</td>
		        		<td>${appointment.symptoms}</td>
		        		<td>${appointment.doctor.first_name} ${appointment.doctor.last_name}</td>
		        		<td>
		        			<c:choose>
							    <c:when test="${appointment.status eq 'Cancelled'}">
							    	${appointment.status}
							    </c:when>
							    <c:otherwise>
							        <form method='POST'>
				        				<button>Cancel</button>
				        				<input type='hidden' name='changestatus' value='cancelled' />
				        				<input type='hidden' name='appointmentid' value=${appointment.id} />
				        			</form>
							    </c:otherwise>
							</c:choose>
	        			</td>
		        	</tr>
		        </c:forEach>
	        </table>
		</div>
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>