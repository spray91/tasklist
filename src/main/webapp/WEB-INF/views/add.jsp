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
<html lang="en">
<head>
    <title>List of tasks</title>
 
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
	
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		
	<link href='<spring:url value="/static/bootstrap-datetimepicker.min.css" />' rel="stylesheet" media="screen">	

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
				<div class="form-group">
			      <label for="category">Category</label>
			      <form:select class="form-control" path="category">
					<form:options items="${categories}" />
			      </form:select>
			    </div>
			    <div class="has-error">
                	<form:errors path="category" class="help-inline"/>
              	</div>
			</fieldset>
			
			<fieldset class="form-group">
				<div class="form-group">
			      <label for="priority">Priority</label>
			      <form:select class="form-control" path="priority">
					<form:option value="4">4</form:option>
					<form:option value="3">3</form:option>
					<form:option value="2">2</form:option>
					<form:option value="1">1</form:option>
			      </form:select>
			    </div>
			    <div class="has-error">
                	<form:errors path="priority" class="help-inline"/>
              	</div>
			</fieldset>
			
			<fieldset class="form-group">
				<div class="form-group">
					<label for="datetimepicker1">Due Date</label>
		        	<div class="input-group date" id="datetimepicker1">
		            	<form:input type="text" class="form-control" path="dueDate" id="dueDate" placeholder="yyyy-MM-dd HH:mm" />
		                <span class="input-group-addon ">
		                	<span class="glyphicon glyphicon-calendar"></span>
		                </span>
		            </div>
		        </div>
		        <div class="has-error">
                	<form:errors path="dueDate" class="help-inline"/>
              	</div>
			</fieldset>

          	<button type="submit" class="btn">Submit</button>
        
		</form:form>
        </div>
      </div>
    </div>
    
   	
   	<script type="text/javascript" src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/locale/pl.js'></script>
	<script type="text/javascript" src='https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.js'></script>
	<script type="text/javascript" src='<spring:url value="/static/bootstrap-datetimepicker.js" />'></script>
	<script type="text/javascript">
	$(function () {
        $('#datetimepicker1').datetimepicker({
        	format: 'YYYY-MM-DD HH:mm'
        });
    });
	</script>
	
</body>
</html>