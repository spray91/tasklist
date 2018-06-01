<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value='/static/css/style.css' />">
    <script src="//code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link href="<c:url value='/static/time/css/bootstrap-datetimepicker.min.css' />" rel="stylesheet" media="screen">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="<c:url value='/static/css/summernote.css' />" rel="stylesheet">
    <script src="<c:url value='/static/js/summernote.min.js' />"></script>-->
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form:form method="GET" modelAttribute="wydarzenie" charset='utf-8'>


                <c:choose>
                    <c:when test="${edit}">
                        <button type="submit" class="btn btn-primary">Uaktualnij wydarzenie</button>
                    </c:when>
                    <c:otherwise>
                        <button type="submit" class="btn btn-primary">Dodaj wydarzenie</button>
                    </c:otherwise>
                </c:choose>
            </form:form>
            <br/>
            <p>* = pole wymagane</p>
        </div>
    </div>
</div>

<script type="text/javascript" src="/static/time/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="/static/time/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        language:  'pl',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
</script>
<script>$('.opisTextarea').summernote({height: 300});</script>
</body>
</html>