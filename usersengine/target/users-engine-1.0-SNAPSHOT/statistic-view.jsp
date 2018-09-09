<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp"%>

<div class="mainBox container">

    <div class="searchInfo">
        <h2>Statystyki wyszukiwań</h2>

        <table class="userTable">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Login</th>
                <th>Number of searches</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getSurname()}</td>
                    <td>${user.getLogin()}</td>
                    <td>${user.getStats().getNumberOfCalls()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="footer.jsp"%>