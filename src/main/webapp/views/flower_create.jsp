<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">Create flower</jsp:attribute>
    <jsp:body>
        <form method="post" action="/app/flower/create">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4>Create Flower</h4>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label for="name">Flower name</label>
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
                        <label for="freshness">Choose freshness:</label>
                        <select class="form-control" id="freshness" name="freshType">
                            <c:forEach items="${freshness}" var="fresh">
                                <option value="${fresh.type}">${fresh.type}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="size">Flower size</label>
                        <input class="form-control" id="size" name="size" type="number" min="0"/>
                        <c:if test="${not empty size_error}">
                            <div class="alert alert-danger" role="alert">
                                <span class="glyphicon glyphicon-exclamation-sign"></span>
                                <span class="sr-only">Error:</span>
                                    ${size_error}
                            </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="colours">Choose colour:</label>
                        <select class="form-control" id="colours" name="colour">
                            <c:forEach items="${colours}" var="colour">
                                <option value="${colour.colour}">${colour.colour}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <c:if test="${not empty flower_error}">
                        <div class="alert alert-danger" userRole="alert">
                            <span class="glyphicon glyphicon-exclamation-sign"></span>
                            <span class="sr-only">Error:</span>
                                ${flower_error}
                        </div>
                    </c:if>
                    <input type="submit" value="Save" class="btn btn-primary"/>
                </div>
            </div>
        </form>
    </jsp:body>
</t:generic_page>
