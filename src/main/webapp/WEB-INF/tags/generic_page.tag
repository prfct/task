<%@tag description="Page template" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@attribute name="title" fragment="true" %>

<html>
<head>
    <title>
        <jsp:invoke fragment="title"/>
    </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">FlowerShop</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/app/flower/create">Create flower</a></li>
            <li><a href="/app/tree/create">Create tree</a></li>
            <li><a href="/app/accessories/create">Create accessory</a></li>
            <li><a href="/app/accessories/list">List accessories</a></li>
            <li><a href="/app/bouquet/create">Create bouquet</a></li>
            <li><a href="/app/bouquet/list">Bouquet list</a></li>
            <li><a href="/app/flower/list">Flower list</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <jsp:doBody/>
</div>
</body>
</html>