<%--
  Created by IntelliJ IDEA.
  User: PhanDz
  Date: 9/28/2024
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>List of Products</h2>
<ul>
  <c:forEach var="product" items="${products}">
    <li>${product.name}: ${product.description} (Image: ${product.imgPath})</li>
  </c:forEach>
</ul>

</body>
</html>
