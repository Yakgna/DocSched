<%@page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DocSched</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<header class='navbar navbar-expand-lg navbar-light bg-light'>
		<div style="width: 60%">
			<h1>DocSched</h1>
		</div>
		<div class='form-inline my-2 my-lg-0'>
			<a href="/?action=logout">Logout</a>
		</div>
	</header>
	<div style='display: flex; gap: 30px; width: 400px;'>
		<a href='?dashboard=users'>Patients</a> <a href='?dashboard=doctors'>Doctors</a>
		<a href='?dashboard=appointments'>Appointments</a>
	</div>
	<div>
		<h1>Patients List</h1>
		<table class="table">
			<tr>
				<th>Email</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Date of Birth</th>
				<th>Sex</th>
			</tr>
			<c:forEach items='${patients}' var='patient'>
				<c:choose>
					<c:when test="${patient.email_address ne 'admin'}">
						<tr>
							<td>${patient.email_address}</td>
							<td>${patient.first_name}</td>
							<td>${patient.last_name}</td>
							<td>${patient.dob}</td>
							<td>${patient.sex}</td>
							<td>
								<form method='POST'>
									<button>Delete</button>
									<input type='hidden' name='id' value=${patient.id } /> <input
										type='hidden' name='deleteuser' value="patient" />
								</form>
							</td>
						</tr>
					</c:when>
				</c:choose>
			</c:forEach>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>