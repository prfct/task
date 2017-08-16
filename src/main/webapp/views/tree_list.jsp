<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">Flower list</jsp:attribute>
    <jsp:body>
        <c:choose>
            <c:when test="${empty trees_error}">
                <table class="table">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>Name</th>
                        <th>Size</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${trees}" var="tree">
                        <tr>
                            <td>${tree.id}</td>
                            <td>${tree.name}</td>
                            <td>${tree.size}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign"></span>
                    <span class="sr-only">Error:</span>
                        ${trees_error}
                </div>
            </c:otherwise>
        </c:choose>
    </jsp:body>
</t:generic_page>
