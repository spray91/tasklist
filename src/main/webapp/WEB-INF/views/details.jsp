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

	<c:choose>
		<c:when test="${isEmpty == true}">
			<div class="text-center">
		    	<h3>There isn't task with ID equals to ${task.id}</h3>
		   	</div>
		</c:when>
		<c:when test="${isEmpty == false}"> 
		    <div class="row">
		        <div class="text-center">
		            <h3>Task Details</h3><br />
		        </div>
		            <div class="col-md-6 col-md-offset-3">		            
		                <div class="panel panel-default">
		                	<div class="panel-heading">
		                			<b><c:out value="${task.title}" /></b>
		                			<div class="btn-group pull-right">
		                				<c:if test = "${task.isDone == false}">
		                					<a href="<c:url value='/task/done/${task.id}' />" class="btn btn-success btn-xs" role="button">Done</a>
				         					<a href="<c:url value='/task/edit/${task.id}' />" class="btn btn-warning btn-xs" role="button">Edit</a>
				      					</c:if>		                				
		                				<a href="<c:url value='/task/delete/${task.id}' />" class="btn btn-danger btn-xs" role="button">Delete</a>
		                			</div>
		                	</div>
		                    <div class="panel-body">
		                        <b>ID: </b><c:out value="${task.id}" /><br />
		                        <b>Priority:</b> <c:out value="${task.priority}" /><br />
		                        <b>Category:</b> <c:out value="${task.category}" /><br />		                        
		                        <b>Description:</b> <span style="white-space:pre"><c:out value="${task.description}" /></span><br />
		                        <b>Due Date:</b> <c:out value="${task.dueDate}" /><br />
		                        <c:if test = "${task.isDone == false}">
				         			<b>Done:</b> NO<br />
				         			<b>Time to deadline:</b> <c:out value="${task.formatedTimeToDeadLine}" />
				      			</c:if>		
		                        <c:if test = "${task.isDone == true}">
				         			<b>Done:</b> YES<br />
				         			<b>Done Date:</b> <c:out value="${task.doneDate}" />
				      			</c:if>						                      
		                    </div>
		                </div>
		            </div>
		        <div class="col-md-6 col-md-offset-3">
			        <c:if test="${not empty nextRecord}">
						<a href="<c:url value='/task/details/${nextRecord}' />" class="btn btn-primary pull-right" role="button">Next record</a>
					</c:if>
					<c:if test="${not empty previousRecord}">
						<a href="<c:url value='/task/details/${previousRecord}' />" class="btn btn-primary pull-left" role="button">Previous record</a>
					</c:if>
				</div>
		    </div>
		    <br />
		 </c:when>
	</c:choose>
</div>
</body>
</html>