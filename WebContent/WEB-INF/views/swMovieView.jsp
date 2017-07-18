<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Star Wars Movie Data!</title>
</head>
<body>
	<h3>Star Wars Movie Data!</h3>
</body>
<body>
	<p>
		The backend of this webpage consists of an application pulling the
		data from the MySQL database and displaying it on this webpage!<br />The
		application creates the data at runtime, and deletes the data from the
		database when complete.
	</p>
</body>
<body>
	<c:forEach var="swMovie" items="${starWarsData}">
		<c:out value="${swMovie}"></c:out>
		<br />
	</c:forEach>
</body>
</html>