<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="owntags" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>List of tasks</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href='<spring:url value="/static/bootstrap/dist/css/bootstrap.min.css"/>'>
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
		
	<script type="text/javascript" src='<spring:url value="/static/jquery-3.3.1.min.js"/>' ></script>
	<script type="text/javascript" src='<spring:url value="/static/bootstrap.min.js" />'></script>
	
</head>
<body>
	<owntags:menu/>
	<br />
	<br />	
	<div class="container">
		<div class="jumbotron">
			<h1>Spray Task list</h1>      
			<p>This is my first project in Spring framework. Please be forgiving.</p>
		</div>
	<p>This is some text.</p>      
	<p>This is another text.</p>      
	</div>
</body>
</html>