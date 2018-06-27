<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Tasks list</title>
	</head>
	<body>
		<a href="">Go back to main page</a><br />
		<a href="add">Add new task</a><br />
		<br />
		<c:choose>
			<c:when test="${isEmpty == true}"> You don't have tasks on your list. </c:when>
			<c:when test="${isEmpty == false}"> 
				<!--<c:forEach items="${tasklist}" var="objectArr"> 
      				<c:forEach items="${ObjectArr}" var="fieldArr">
         				<c:out value="${fieldArr.description}" /> 
     	 			</c:forEach>
  				</c:forEach>-->
  				
  				<c:forEach items="${tasklist}" var="objectArr"> 
         			<c:out value="${objectArr.description}" />  <br />
  				</c:forEach>
			</c:when>
		</c:choose>
		
		
		<c:forEach items="${reqUserDetails}" var="firstVar"> 
      <c:forEach items="${firstVar}" var="secodVar"> // firstVar will hold your object array
         <c:out value="${secondVar.field1}" /> // on iterating the object array 
      </c:forEach>
  </c:forEach>
		
	</body>
</html>