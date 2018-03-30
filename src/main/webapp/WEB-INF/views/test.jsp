<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="kawalek" tagdir="/WEB-INF/tags" %>
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
    <link rel="stylesheet" href="<c:url value='/static/css/style.css' />">
    <script src="//code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link href="<c:url value='/static/time/css/bootstrap-datetimepicker.min.css' />" rel="stylesheet" media="screen">
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="<c:url value='/static/css/summernote.css' />" rel="stylesheet">
    <script src="<c:url value='/static/js/summernote.min.js' />"></script>

</head>
<body>
<!-- gorne menu -->
<kawalek:menu/>

<!--beggining of header image-->
	<span class="headerU">
		<div class="jumbotron"
             style="background: url(/static/img/backgrounds/wydarzenie.jpg); background-size: 100%; color: #ffffff; min-height: 200px;">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="intro-text">
                            <span class="name">Dodaj wydarzenie</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</span>
<!-- header image collapse-->
<!-- info-->
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form:form method="POST" modelAttribute="wydarzenie" charset='utf-8'>
                <form:input type="hidden" path="id" id="id"/>
                <div class="has-error">
                    <form:errors path="id" class="help-inline"/>
                </div>
                <form:input type="hidden" path="ocena" id="ocena"/>
                <div class="has-error">
                    <form:errors path="ocena" class="help-inline"/>
                </div>
                <form:input type="hidden" path="autor" id="autor"/>
                <div class="has-error">
                    <form:errors path="autor" class="help-inline"/>
                </div>
                <form:input type="hidden" path="aktywowany" id="aktywowany"/>
                <div class="has-error">
                    <form:errors path="aktywowany" class="help-inline"/>
                </div>
                <fieldset class="form-group">
                    <label for="nazwa">Nazwa</label>
                    <form:input type="text" path="nazwa" class="form-control" id="nazwa" placeholder="Wprowadź nazwę" />
                    <div class="has-error">
                        <form:errors path="nazwa" class="help-inline"/>
                    </div>
                </fieldset>
                <fieldset class="form-group">
                    <label for="region">Wybierz region *</label>
                    <form:select class="form-control" path="region" items="${regions}" multiple="false" itemValue="id" itemLabel="nazwa" />
                    <div class="has-error">
                        <form:errors path="region" class="help-inline"/>
                    </div>
                </fieldset>
                <fieldset class="form-group">
                    <label for="kategoria">Wybierz kategorię *</label>
                    <form:select class="form-control" path="kategoria" items="${kategorie}" multiple="false" itemValue="id" itemLabel="nazwa" />
                    <div class="has-error">
                        <form:errors path="kategoria" class="help-inline"/>
                    </div>
                </fieldset>


                <fieldset class="form-group">
                    <div class="form-group">
                        <label for="dtp_input1">Data rozpoczęcia *</label>
                        <div class="input-group date form_datetime" data-date="" data-date-format="yyyy-mm-dd hh:ii" data-link-field="dtp_input1">
                            <input class="form-control" size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <form:input type="hidden" id="dtp_input1" path="dataRozpoczecia" />
                            <%--<form:input type="text" path="dataRozpoczecia" class="form-control" id="dataRozpoczecia" placeholder="RRRR-MM-dd Hh:Mm:ss" />--%>
                    </div>
                </fieldset>


                <fieldset class="form-group">
                    <div class="form-group">
                        <label for="dtp_input2">Data zakończenia *</label>
                        <div class="input-group date form_datetime" data-date="" data-date-format="yyyy-mm-dd hh:ii" data-link-field="dtp_input2">
                            <input class="form-control" size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <form:input type="hidden" id="dtp_input2" path="dataZakonczenia" /><br/>
                    </div>
                </fieldset>



                <fieldset class="form-group">
                    <label for="opis">Opis</label>
                    <form:textarea class="form-control opisTextarea" path="opis"
                                   rows="13" id="opis" placeholder="Wprowadź opis"/>
                    <div class="has-error">
                        <form:errors path="opis" class="help-inline"/>
                    </div>
                </fieldset>
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
<kawalek:footer/>

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