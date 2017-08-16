<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">Create tree</jsp:attribute>
    <jsp:body>
        <form method="post" action="/app/tree/create">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4>Create tree</h4>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label for="name">Tree name</label>
                        <input class="form-control" id="name" name="name"/>
                        <c:if test="${not empty name_error}">
                            <div class="alert alert-danger" role="alert">
                                <span class="glyphicon glyphicon-exclamation-sign"></span>
                                <span class="sr-only">Error:</span>
                                    ${name_error}
                            </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="size">Choose size:</label>
                        <select class="form-control" id="size" name="size">
                            <c:forEach items="${sizes}" var="size">
                                <option value="${size.size}">${size.size}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <c:if test="${not empty tree_error}">
                        <div class="alert alert-danger" userRole="alert">
                            <span class="glyphicon glyphicon-exclamation-sign"></span>
                            <span class="sr-only">Error:</span>
                                ${tree_error}
                        </div>
                    </c:if>
                    <input type="submit" value="Save" class="btn btn-primary"/>
                </div>
            </div>
        </form>
    </jsp:body>
</t:generic_page>
