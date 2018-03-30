<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>add new entry</title>
	</head>
	<body>
		<a href="">Go back to main page</a><br />
		<form:form action="${userActionUrl}" method="POST" modelAttribute="TaskList" charset='utf-8'>
			Date:
			<form:input type="date" path="scheduledDate" id="scheduledDate" value="1991-11-11" /><br />
			
			Desc:
			<form:input type="text" path="description" id="description" value="test desc" /> <br />
			
			
			Category:			
			<form:select path="category">
    			<form:options items="${categories}" />
			</form:select>
			
			<br />
			
			
			<button type="submit">Submit</button>
		</form:form>
		<p><strong>${message}</strong></p><br />
        <p><strong>${result}</strong></p>
	</body>
</html>