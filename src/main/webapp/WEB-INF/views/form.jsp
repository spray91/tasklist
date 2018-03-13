<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <body>
        <form action="add" th:object="${ListForm}" method="post">
            <table>
                <tr>
                    <td>description:</td>
                    <td><form:input type="text" th:field="*{description}" ></form:input></td>
                </tr>
                <tr>
                    <td>scheduledDate:</td>
                    <td><form:input type="text" th:field="*{scheduledDate}"> </form:input></td>
                </tr>
                <tr>
                    <td><button type="submit">Submit</button></td>
                </tr>
            </table>
            <p><strong>${message}</strong></p><br />
            <p><strong>${result}</strong></p>
        </form>
    </body>
</html>
