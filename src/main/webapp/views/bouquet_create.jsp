<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">Create bouquet</jsp:attribute>
    <jsp:body>
        <form method="post" action="/app/bouquet/create">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h4>Create Bouquet</h4>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <label for="title">Bouquet title</label>
                        <input class="form-control" id="title" name="title"/>
                        <c:if test="${not empty name_error}">
                            <div class="alert alert-danger" role="alert">
                                <span class="glyphicon glyphicon-exclamation-sign"></span>
                                <span class="sr-only">Error:</span>
                                    ${name_error}
                            </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="price">Set price:</label>
                        <input class="form-control" id="price" name="price"/>
                    </div>
                    <div class="form-group">
                        <label>Choose flowers:</label>
                        <br>
                        <c:forEach items="${flowers}" var="flower">
                            <c:out value="${flower.id} - ${flower.name},colour:${flower.colour},
                                freshness:${flower.freshness}, size: ${flower.size}"/>
                            <input type="number" min="0" name="flowersQuantity[${flower.id}]">
                            <br>
                        </c:forEach>
                        <c:if test="${not empty flowerIds_error}">
                            <div class="alert alert-danger" role="alert">
                                <span class="glyphicon glyphicon-exclamation-sign"></span>
                                <span class="sr-only">Error:</span>
                                    ${flowerIds_error}
                            </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label>Choose trees:</label>
                        <br>
                        <c:forEach items="${trees}" var="tree">
                            <c:out value="${tree.id} - ${tree.name},size:${tree.size}"/>
                            <input type="number" min="0" name="treesQuantity[${tree.id}]">
                            <br>
                        </c:forEach>
                    </div>
                    <div class="form-group">
                        <label for="accessoryIds">Choose accessory:</label>
                        <select multiple class="form-control" id="accessoryIds" name="accessoryIds">
                            <c:forEach items="${accessories}" var="accessory">
                                <option value="${accessory.id}">${accessory.type}</option>
                            </c:forEach>
                        </select>
                        <c:if test="${not empty accessoryIds_error}">
                            <div class="alert alert-danger" role="alert">
                                <span class="glyphicon glyphicon-exclamation-sign"></span>
                                <span class="sr-only">Error:</span>
                                    ${accessoryIds_error}
                            </div>
                        </c:if>
                    </div>
                    <input type="submit" value="Save" class="btn btn-primary"/>
                </div>
            </div>
        </form>
    </jsp:body>
</t:generic_page>
