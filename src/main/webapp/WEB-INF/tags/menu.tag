<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value='/' />"><span class="glyphicon glyphicon-list-alt"></span> Task List</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">List<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                    	<li><a href="<c:url value='/task/donelist' />">COMPLETED TASKS</a></li>
                    	<li><a href="<c:url value='/task/todolist' />">TO DO TASKS</a></li>
                        <li><a href="<c:url value='/category/list' />">CATEGORIES</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Add<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value='/task/add' />">TASK</a></li>
                        <li><a href="<c:url value='/category/add' />">CATEGORY</a></li>
                        <li><a href="<c:url value='/readCSV' />">READ CSV</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br />
<br />
<br />