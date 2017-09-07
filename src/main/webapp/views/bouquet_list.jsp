<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">Bouquet list</jsp:attribute>
    <jsp:body>
        <c:choose>
            <c:when test="${empty bouquets_error}">
                <table class="table">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>title</th>
                        <th>price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${bouquets}" var="bouquet">
                        <tr>
                            <td><a href="/app/bouquet/detail?id=${bouquet.id}">${bouquet.id}</a></td>
                            <td>${bouquet.title}</td>
                            <td>${bouquet.price}</td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign"></span>
                    <span class="sr-only">Error:</span>
                        ${bouquets_error}
                </div>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:generic_page>


<%--<a href="/app/bouquet/detail?id=${bouquet.id}"></a>--%>