<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">Flower list</jsp:attribute>
    <jsp:body>
        <c:choose>
            <c:when test="${empty flowers_error}">
                <table class="table">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Name</th>
                        <th>colour</th>
                        <th>freshness</th>
                        <th>steam</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${flowers}" var="flower">
                        <tr>
                            <td>${flower.id}</td>
                            <td>${flower.name}</td>
                            <td>${flower.colour}</td>
                            <td>${flower.freshness}</td>
                            <td>${flower.steam}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign"></span>
                    <span class="sr-only">Error:</span>
                        ${flowers_error}
                </div>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:generic_page>
