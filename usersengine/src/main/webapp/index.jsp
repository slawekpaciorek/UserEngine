<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


    <div class="mainBox container-fluid no-gutters">

        <form class="row">

            <div class="buttonHolder">
                <p>Add</p>
                <button type="submit" formaction="add-user" class="btn btn-primary">Add User</button>
            </div>
            <div class="buttonHolder">
                <p>Check</p>
                <button type="submit" formaction="check-user" class="btn btn-success">Check User</button>
            </div>
            <div class="buttonHolder">
                <p>List</p>
                <button type="submit" formaction="view-users" class="btn btn-danger">View Users</button>
            </div>
            <div class="buttonHolder">
                <p>Stats</p>
                <button type="submit" formaction="statistic" class="btn btn-warning">View Stats</button>
            </div>

        </form>


    </div>

<%@include file="footer.jsp"%>
