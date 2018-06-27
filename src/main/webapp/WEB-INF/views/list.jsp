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

	<c:choose>
		<c:when test="${isEmpty == true}">
			<div class="text-center bestRegion">
		    	<h2>You don't have tasks on your list.</h2>
		   	</div>
		</c:when>
		<c:when test="${isEmpty == false}"> 
		    <div class="row">
		        <div class="text-center bestRegion">
		            <h2>Your tasks</h2><br />
		        </div>
		        <c:forEach items="${tasklist}" var="objectArr" varStatus="loop">
		            <div class="col-md-6">
		                <div class="panel panel-default">
		                	<div class="panel-heading">
		                		<h4>
		                			<c:out value="${objectArr.title}" />
		                			<div class="btn-group pull-right">
		                				<a href="<c:url value='/details/${objectArr.id}' />" class="btn btn-success btn-xs" role="button">Details</a>
		                				<a href="<c:url value='/delete/${objectArr.id}' />" class="btn btn-danger btn-xs" role="button">Delete</a>
		                			</div>
		                		</h4>
		                	</div>
		                    <div class="panel-body">
		                        <h4>Due date: <c:out value="${dueDates[loop.index]}" /></h4>
		                        <h4>Priority: <c:out value="${objectArr.priority}" /></h4>
		                        <h4>ETA: <c:out value="${objectArr.timeToDeadline}" /></h4>
		                    </div>
		                </div>
		            </div>
		        </c:forEach>
		        
		    </div>
		    <div class="col-md-6">
				<a href="<c:url value='/downloadCSV' />" class="btn btn-primary" role="button">Download CSV</a>
			</div>
		 </c:when>
	</c:choose>
</div>

</body>
</html>