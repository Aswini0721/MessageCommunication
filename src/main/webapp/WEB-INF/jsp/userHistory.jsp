<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List All user</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
 rel="stylesheet"></link>

</head>

<body>
	<div class="generic-container">
		<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">User Messages</span>
			</div>
			&nbsp; <br></br>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Messages</th>
						<th>Received Date</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="users">
						<tr>
							<td width="30%">${users.user.username}</td>
							<td width="30%">${users.messageInfo}</td>
							<td width="30%">${users.date}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	       <button class="btn btn-lg btn-primary" id="submit" onclick="location.href ='/index.html'" >Send Messages</button>
			</div>
		</div>
	</div>
</body>
</html>