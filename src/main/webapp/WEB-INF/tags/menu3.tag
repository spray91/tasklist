<%@ tag %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand text-light" href="<c:url value='/' />">Task List</a>
      <a class="btn btn-default navbar-btn btn-dark border-dark" href="<c:url value='/addcat' />">Add category</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar2SupportedContent">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent"> </div>
    </div>
  </nav>
  <br />
  <br />