<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>JEE-Homework</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Bangers|Fredoka+One|Monoton|Passion+One|Prosto+One|Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="assets/style.css" type="text/css">
</head>
<body>

<div class="container no-gutters">

    <div class="header row">

        <div class="logo col-sm">
            <span>User Engine Application</span>
        </div>

        <div class="col-sm">

            <form>
                <button class="btn btn-primary" formaction="add-user">ADD</button>
                <button class="btn btn-success" formaction="check-user">CHECK</button>
                <button class="btn btn-danger" formaction="view-users">VIEW</button>
                <button class="btn btn-warning" formaction="statistic">STATS</button>
            </form>

        </div>

    </div>

</div>