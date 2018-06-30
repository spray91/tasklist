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
		    	<h3>You don't have tasks on your list.</h3>
		   	</div>
		</c:when>
		<c:when test="${isEmpty == false}"> 
			<div class="text-center">
		    	<h3>Tasks To Do</h3><br />
		    </div>
		    <br />
		
		  <ul class="nav nav-tabs col-md-6 col-md-offset-3">
		    <li class="active"><a data-toggle="tab" href="#byid">By ID</a></li>
		    <li><a data-toggle="tab" href="#menu1">By Due Date</a></li>
		    <li><a data-toggle="tab" href="#menu2">By Priority</a></li>
		  </ul>
		
		  <div class="tab-content col-md-6 col-md-offset-3">
		    <div id="byid" class="tab-pane fade in active">
			    <br />
			    <div class="row">
			        <c:forEach items="${doneList}" var="objectArr" varStatus="loop">         
			                <div class="panel panel-default">
			                	<div class="panel-heading">
			                			<b><c:out value="${objectArr.title}" /></b>
			                			<div class="btn-group pull-right">
			                				<a href="<c:url value='/task/done/${objectArr.id}' />" class="btn btn-success btn-xs" role="button">Done</a>
			                				<a href="<c:url value='/task/details/${objectArr.id}' />" class="btn btn-info btn-xs" role="button">Details</a>
			                				<a href="<c:url value='/task/edit/${objectArr.id}' />" class="btn btn-warning btn-xs" role="button">Edit</a>
			                				<a href="<c:url value='/task/delete/${objectArr.id}' />" class="btn btn-danger btn-xs" role="button">Delete</a>		                				
			                			</div>
			                	</div>
			                    <div class="panel-body">
			                        <b>Due date:</b> <c:out value="${objectArr.dueDate}" /><br />
			                        <b>Priority:</b> <c:out value="${objectArr.priority}" /> <br />
			                        <b>ETA:</b> <c:out value="${objectArr.timeToDeadline}" /><br />
			                        <b>Description:</b> <span style="white-space:pre"><c:out value="${objectArr.description}" /></span>
			                    </div>
			                </div>
			        </c:forEach>		        
			    </div>
		    </div>
		    <div id="menu1" class="tab-pane fade">
			    <br />
			    <div class="row">
			        <c:forEach items="${doneListByDueDate}" var="objectArr2" varStatus="loop">         
			                <div class="panel panel-default">
			                	<div class="panel-heading">
			                			<b><c:out value="${objectArr2.title}" /></b>
			                			<div class="btn-group pull-right">
			                				<a href="<c:url value='/task/done/${objectArr2.id}' />" class="btn btn-success btn-xs" role="button">Done</a>
			                				<a href="<c:url value='/task/details/${objectArr2.id}' />" class="btn btn-info btn-xs" role="button">Details</a>
			                				<a href="<c:url value='/task/edit/${objectArr2.id}' />" class="btn btn-warning btn-xs" role="button">Edit</a>
			                				<a href="<c:url value='/task/delete/${objectArr2.id}' />" class="btn btn-danger btn-xs" role="button">Delete</a>		                				
			                			</div>
			                	</div>
			                    <div class="panel-body">
			                    	MENU2
			                        <b>Due date:</b> <c:out value="${objectArr2.dueDate}" /><br />
			                        <b>Priority:</b> <c:out value="${objectArr2.priority}" /> <br />
			                        <b>ETA:</b> <c:out value="${objectArr2.timeToDeadline}" /><br />
			                        <b>Description:</b> <span style="white-space:pre"><c:out value="${objectArr2.description}" /></span>
			                    </div>
			                </div>
			        </c:forEach>		        
			    </div>
		    </div>		    
		    <div id="menu2" class="tab-pane fade">
			    <br />
			    <div class="row">
			        <c:forEach items="${doneListByPriority}" var="objectArr3" varStatus="loop">         
			                <div class="panel panel-default">
			                	<div class="panel-heading">
			                			<b><c:out value="${objectArr3.title}" /></b>
			                			<div class="btn-group pull-right">
			                				<a href="<c:url value='/task/done/${objectArr3.id}' />" class="btn btn-success btn-xs" role="button">Done</a>
			                				<a href="<c:url value='/task/details/${objectArr3.id}' />" class="btn btn-info btn-xs" role="button">Details</a>
			                				<a href="<c:url value='/task/edit/${objectArr3.id}' />" class="btn btn-warning btn-xs" role="button">Edit</a>
			                				<a href="<c:url value='/task/delete/${objectArr3.id}' />" class="btn btn-danger btn-xs" role="button">Delete</a>		                				
			                			</div>
			                	</div>
			                    <div class="panel-body">
			                    MENU3
			                        <b>Due date:</b> <c:out value="${objectArr3.dueDate}" /><br />
			                        <b>Priority:</b> <c:out value="${objectArr3.priority}" /> <br />
			                        <b>ETA:</b> <c:out value="${objectArr3.timeToDeadline}" /><br />
			                        <b>Description:</b> <span style="white-space:pre"><c:out value="${objectArr3.description}" /></span>
			                    </div>
			                </div>
			        </c:forEach>		        
			    </div>
		    </div>
		    
		  </div>
		  <br />	    
		    
		    <div class="col-md-6 col-md-offset-3">
				<center><a href="<c:url value='/downloadCSV' />" class="btn btn-primary" role="button">Download CSV</a></center>
				<br />
				<br />
			</div>
		 </c:when>
	</c:choose>
</div>
</body>
</html>