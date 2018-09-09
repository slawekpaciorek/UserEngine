<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="mainBox container">

        <form class="container-fluid" id="check" method="post" action="check-user">

            <label>Check ID :
            <input name="id" type="text" required>
            </label>
            <br/>
            <button class="btn btn-success" type="submit">Sprawdź Użytkownika</button>

        </form>

        <div class="searchInfo">

            <c:choose>
                <c:when test="${user == null}">
                    <c:choose>
                        <c:when test="${message == null}">
                            <h5 class="info">${message = "Wpisz Id"}</h5>
                        </c:when>
                        <c:otherwise>
                            <h5 class="alert">${message}</h5>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <table class="userTable">
                        <tr>
                            <th>Numer ID</th>
                            <th>Name</th>
                            <th>Login</th>
                            <th>Status</th>
                        </tr>
                        <tr>
                            <td>${user.getId()}</td>
                            <td>${user.getName()} ${user.getSurname()}</td>
                            <td>${user.getLogin()}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${user.status == 'W'}">
                                        Waiting
                                    </c:when>
                                    <c:when test="${user.status == 'A'}">
                                        Active
                                    </c:when>
                                    <c:when test="${user.status == 'D'}">
                                        Deleted
                                    </c:when>
                                    <c:when test="${user.status == 'BL'}">
                                        Blocked
                                    </c:when>
                                    <c:when test="${user.status == 'BA'}">
                                        Baned
                                    </c:when>
                                </c:choose>
                            </td>
                        </tr>
                    </table>
                </c:otherwise>
            </c:choose>

        </div>

    </div>

<%@include file="footer.jsp"%>
