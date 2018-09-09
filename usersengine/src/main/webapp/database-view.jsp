<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp"%>

<div class="mainBox container">

    <div class="searchInfo">
        <h2>Lista użytkowników : </h2>

        <table class="userTable">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Login</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getSurname()}</td>
                    <td>${user.getLogin()}</td>
                    <td>
                        <form method="get" style="border: none;width: auto">
                                <button class="btn btn-warning form-button" type="submit" name="idValue" value="${user.id}" formaction="edit-user">edit</button>
                                <button class="btn btn-danger form-button" type="submit" name="idValue" value="${user.id}" formaction="delete-user">delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


</div>

<%@include file="footer.jsp"%>