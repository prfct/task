<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">Accessories list</jsp:attribute>
    <jsp:body>
        <c:choose>
            <c:when test="${empty accessories_error}">
                <table class="table">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Type</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${accessories}" var="accessor">
                        <tr>
                            <td>${accessor.id}</td>
                            <td>${accessor.type}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign"></span>
                    <span class="sr-only">Error:</span>
                        ${accessories_error}
                </div>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:generic_page>
