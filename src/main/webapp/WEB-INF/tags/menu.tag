<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value='' />"><span class="glyphicon glyphicon-list-alt"></span> Task List</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value='/list' />">List of tasks</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Add<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value='/add' />">TASK</a></li>
                        <li><a href="<c:url value='/addcat' />">CATEGORY</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br />
<br />
<br />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>