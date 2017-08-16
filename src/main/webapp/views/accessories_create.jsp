<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">Create accessories</jsp:attribute>
    <jsp:body>
        <form method="post" action="/app/accessories/create">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4>Create accessories</h4>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label for="type">Choose type:</label>
                        <select class="form-control" id="type" name="type">
                            <c:forEach items="${types}" var="type">
                                <option value="${type.type}">${type.type}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <c:if test="${not empty accessories_error}">
                        <div class="alert alert-danger" userRole="alert">
                            <span class="glyphicon glyphicon-exclamation-sign"></span>
                            <span class="sr-only">Error:</span>
                                ${accessories_error}
                        </div>
                    </c:if>
                    <input type="submit" value="Save" class="btn btn-primary"/>
                </div>
            </div>
        </form>
    </jsp:body>
</t:generic_page>
