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
		                		<h4><c:out value="${objectArr.title}" /></h4>
		                	</div>
		                    <div class="panel-body">
		                    	<h4>Id: <c:out value="${objectArr.id}" /></h4><br />
		                        <h4>Due date: <c:out value="${dueDates[loop.index]}" /></h4><br />
		                        <h4>Description: <c:out value="${objectArr.description}" /></h4><br />
		                        <h4>Category: <c:out value="${objectArr.category}" /></h4><br />
		                        <h4>Priority: <c:out value="${objectArr.priority}" /></h4><br />
		                        <h4>Creation Date: <c:out value="${objectArr.creationDate}" /></h4><br />
		                    </div>
		                </div>
		            </div>
		        </c:forEach>
		
		    </div>
		 </c:when>
	</c:choose>
</div>

</body>
</html>