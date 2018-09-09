<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp"%>

    <div class="mainBox container">

        <form class="container-fluid" id="user" method="post">

            <label>First name :
            <input name="name" type="text" required>
            </label>
            <label>Surname :
            <input name="surname" type="text" required>
            </label>
            <label>Login :
            <input name="login" type="text" required>
            </label>
            <label>Password :
            <input name="password" type="password" required>
            </label>
            <label>Age :
            <input name="age" type="number" required>
            </label>
            <div>
            <button class="btn btn-success" type="submit" formaction="add-user">Zapisz</button>
            <button class="btn btn-warning" type="submit" formaction="edit-user">Edytuj</button>
            </div>
        </form>

    </div>

<%@include file="footer.jsp"%>