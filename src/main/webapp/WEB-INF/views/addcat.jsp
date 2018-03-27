<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>add new category</title>
	</head>
	<body>
		<a href="">Go back to main page</a><br />
		<form:form action="${userActionUrl}" method="POST" modelAttribute="Category" charset='utf-8'>
			Category name:
			<form:input type="text" path="name" id="name" /><br />
			
			Desc:
			<form:input type="text" path="description" id="description" /><br />
			<button type="submit">Submit</button>
			
		</form:form>
		<p><strong>${message}</strong></p><br />
        <p><strong>${result}</strong></p>
	</body>
</html>