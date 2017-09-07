<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:generic_page>
    <jsp:attribute name="title">Bouquet Detail</jsp:attribute>
    <jsp:body>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4>Bouquet Detail</h4>
            </div>
            <div class="panel-body">
                <div class="form-group">
                    <label for="id">ID</label>
                    <input class="form-control" id="id" name="id" value="${bouquet.id}" readonly/>
                </div>
                <div class="form-group">
                    <label for="title">Bouquet title</label>
                    <input class="form-control" id="title" name="title" value="${bouquet.title}" readonly/>
                </div>
                <div class="form-group">
                    <label for="price">Bouquet price</label>
                    <input class="form-control" id="price" name="price" value="${bouquet.price}" readonly/>
                </div>
                <div class="form-group">
                    <label>Flowers</label>
                    <ul class="list-group">
                        <c:forEach items="${bouquet.flowerList}" var="bouquetFlower">
                            <li class="list-group-item">
                                    ${bouquetFlower.flower.id} - name:${bouquetFlower.flower.name},
                                colour:${bouquetFlower.flower.colour}, freshness:${bouquetFlower.flower.freshness},
                                size: ${bouquetFlower.flower.size}, quantity: ${bouquetFlower.quantity}
                            </li>
                        </c:forEach>
                        <form method="post"
                              action="/app/bouquet/sort_fresh?bouId=${bouquet.id}">
                            <button class="btn btn-default btn-sm">SortByVery</button>
                        </form>
                        <form method="post" style="display: inline-block;"
                              action="/app/bouquet/diapason?id=${bouquet.id}">
                            Choose diapason flowers:
                            <br>
                            From: <input type="number" name="from" min="0" size="3"
                            <c:if test="${not empty failedFrom}">
                                         value="${failedFrom}" style="color: red; border-color: red"
                            </c:if>><br>
                            To: <input type="number" name="to" min="0" size="3"
                            <c:if test="${not empty failedTo}">
                                       value="${failedTo}" style="color: red; border-color: red"
                            </c:if>><br>
                            <button class="btn btn-default btn-sm">Set</button>
                        </form>
                    </ul>
                </div>
                <div class="form-group">
                    <label>Trees</label>
                    <ul class="list-group">
                        <c:forEach items="${bouquet.treeList}" var="bouquetTree">
                            <li class="list-group-item">
                                    ${bouquetTree.tree.id} -name:${bouquetTree.tree.name},
                                size:${bouquetTree.tree.size}
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="form-group">
                    <label>Accessories</label>
                    <ul class="list-group">
                        <c:forEach items="${bouquet.accessoriesList}" var="bouquetAccessory">
                            <li class="list-group-item">
                                    ${bouquetAccessory.accessories.id} -type:${bouquetAccessory.accessories.type}
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <input type="submit" value="Purchase" class="btn btn-primary"/>
            </div>
        </div>
    </jsp:body>
</t:generic_page>

