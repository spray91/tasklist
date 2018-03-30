<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Dodaj wydarzenie</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="//code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>
<!-- info-->
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form:form method="POST" modelAttribute="TaskList" charset='utf-8'>

                <fieldset class="form-group">
                    <label for="nazwa">Desc</label>
                    <form:input type="text" path="description" class="form-control" id="description" placeholder="type desc" />
                    <div class="has-error">
                        <form:errors path="description" class="help-inline"/>
                    </div>
                </fieldset>
             
                <fieldset class="form-group">
                    <div class="form-group">
                        <label for="dtp_input1">Date *</label>
                        <div class="input-group date form_datetime" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
                            <input class="form-control" size="16" type="text" value="1991-11-11">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <form:input type="hidden" id="dtp_input1" path="scheduledDate" />
                            <%--<form:input type="text" path="dataRozpoczecia" class="form-control" id="scheduledDate" placeholder="yy-mm-dd" />--%>
                    </div>
                </fieldset>

                        <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
            <br/>
            <p>* = pole wymagane</p>
        </div>
    </div>
</div>

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