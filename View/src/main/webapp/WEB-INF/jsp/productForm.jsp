<%--
  Created by IntelliJ IDEA.
  User: isias
  Date: 7/19/18
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<body>
<h1>Product Form</h1>
<a href="${pageContext.request.contextPath}/">Cancel</a>
<form:form method="POST" action="/saveProduct" modelAttribute="product">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td><form:label path="manufacturer">Manufacturer</form:label></td>
            <td><form:input path="manufacturer"/></td>
        </tr>
        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td><form:label path="sku">SKU</form:label></td>
            <td><form:input path="sku"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
