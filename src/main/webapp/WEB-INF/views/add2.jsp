<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="owntags" tagdir="/WEB-INF/tags" %>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>List of tasks</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value='/static/css/style.css' />">
    <script src="//code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link href="<c:url value='/static/time/css/bootstrap-datetimepicker.min.css' />" rel="stylesheet" media="screen">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="<c:url value='/static/css/summernote.css' />" rel="stylesheet">
    <script src="<c:url value='/static/js/summernote.min.js' />"></script>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
<body >
  <owntags:menu/>
    <div class="container">
      <div class="row">
        <div class="col-md-6 col-md-offset-3">
          <form:form action="${userActionUrl}" method="post" modelAttribute="TaskList" >
         	<fieldset class="form-group">
              <label for="title">Title:</label>
              <form:input type="text" class="form-control" path="title" id="title" placeholder="Enter new task title"/>
              <div class="has-error">
                <form:errors path="title" class="help-inline"/>
              </div>
			</fieldset>
			
         	<fieldset class="form-group">
              <label for="description">Description</label>
              <form:textarea rows="5" class="form-control" path="description" id="description" placeholder="Enter new task desciption (optional)"/>
              <div class="has-error">
                <form:errors path="description" class="help-inline"/>
              </div>
			</fieldset>
			
			<fieldset class="form-group">
              <label for="category">Category</label>
              <form:textarea rows="5" class="form-control" path="description" id="description" placeholder="Enter new task desciption (optional)"/>
              <div class="has-error">
                <form:errors path="description" class="help-inline"/>
              </div>
			</fieldset>
			
			<fieldset class="form-group">
				<div class="form-group">
			      <label for="sel1">Category</label>
			      <form:select class="form-control" path="category">
					<form:options items="${categories}" />
			      </form:select>
			    </div>
			</fieldset>
			
			
          	<br />
          	<button type="submit" class="btn">Submit</button>
        
		</form:form>
        </div>
      </div>
    </div>

</body>
</html>