<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
  
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
	
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<owntags:menu/>
<div class="container">

		    <div class="row">
		        <div class="text-center">
		            <h3>List of tasks added from CSV</h3><br />
		        </div>
		        <c:forEach items="${tasklist}" var="objectArr" varStatus="loop">
		            <div class="col-md-6 col-md-offset-3">
		                <div class="panel panel-default">
		                	<div class="panel-heading">
		                			<b><c:out value="${objectArr.title}" /></b>
		                	</div>
		                    <div class="panel-body">
		                    	<b>ID:</b> <c:out value="${objectArr.id}" /><br />
		                    	<span style="white-space:pre"><b>Description:</b> <c:out value="${objectArr.description}" /></span><br />
		                        <b>Due date:</b> <c:out value="${objectArr.dueDate}" /><br />
		                        <b>Priority:</b> <c:out value="${objectArr.priority}" />
		                    </div>
		                </div>
		            </div>
		        </c:forEach>
		        
		    </div>
</div>

</body>
</html>