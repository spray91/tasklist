<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>add new entry</title>
	</head>
	<body>
		<a href="">Go back to main page</a><br />
		<form:form action="add" method="POST" modelAttribute="TaskListModel" charset='utf-8'>
			Date:
			<form:input type="text" path="scheduledDate" id="scheduledDate" />
			
			Desc:
			<form:input type="text" path="description" id="description" />
			<button type="submit">Submit</button>
			
		</form:form>
		<p><strong>${message}</strong></p><br />
        <p><strong>${result}</strong></p>
	</body>
</html>