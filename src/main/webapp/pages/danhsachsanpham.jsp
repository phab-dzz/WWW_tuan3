<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.phandev.duongvanphan_ss2.backend.reposive.entities.Product" %>
<%@ page import="vn.edu.iuh.fit.phandev.duongvanphan_ss2.frontend.DTO.ProductDTO" %><%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/21/2024
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sach san pham</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            height: 100vh;
            margin: 0;
        }

        /* Style for sidebar */
        .sidebar {
            height: 100vh;
            width: 250px;
            background-color: #2c3e50;
            position: fixed;
            top: 0;
            left: 0;
            padding-top: 20px;
        }

        .sidebar a {
            display: block;
            color: white;
            padding: 15px;
            text-decoration: none;
            font-size: 18px;
        }

        .sidebar a:hover {
            background-color: #34495e;
        }

        /* Style for main content */
        .main-content {
            margin-left: 250px;
            padding: 20px;
            width: calc(100% - 250px);
        }

        /* Container to hold all the cards */
        .card-container {
            display: flex;
            flex-wrap: wrap;
            /* Allow cards to wrap to the next line */
            /*justify-content: center;*/
            gap: 20px;
            /* Add space between the cards */
            max-width: 1200px;
            /* You can adjust the max width as needed */
            padding: 20px;
        }

        .card {
            height: 300px;
            width: 250px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .card img {
            width: 100%;
            height: 100px;
            object-fit: cover;
        }

        .card-info {
            padding: 20px;
            text-align: center;
        }

        .card-info h3 {
            margin: 0;
            font-size: 22px;
        }

        .card-info p {
            color: #777;
            font-size: 14px;
        }

        .buttons {
            margin-top: 5px;
            display: flex;
            justify-content: space-between;
            width: 100%;
            padding: 0 10px;
        }

        .buttons button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
        }

        .btn-update {

            background-color: #3498db;
            color: white;
        }

        .btn-delete {
            background-color: #e74c3c;
            color: white;
        }

        .btn-update:hover {
            background-color: #2980b9;
        }

        .btn-delete:hover {
            background-color: #c0392b;
        }
    </style>
</head>

<body>

<!-- Sidebar -->
<div class="sidebar">
    <a href="">Trang chủ</a>
    <a href="#product-management">Quản lý sản phẩm</a>
    <a href="#product-pricing">Giá sản phẩm</a>
</div>
<!-- Main content -->
<div class="main-content">

    <div class="card-container">
        <%
            List<ProductDTO> products = (List<ProductDTO>) request.getAttribute("products");
            if (products != null) {
                for(ProductDTO p : products) {
        %>
        <div class="card">
            <img src="${pageContext.request.contextPath}/data/ip16.png" alt="Product Image">
            <div class="card-info">
                <h3><%= p.getName() %></h3>
                <p>ID: <%= p.getId() %></p>
                <p><%= p.getDescription() %></p>
            </div>
            <div class="buttons">
                <a class="btn btn-warning" href="control-servlet?action=update&id=<%=p.getId()%>" >Update</a>
                <a class="btn btn-danger" href="control-servlet?action=deleteproduct&id=<%=p.getId()%>">Delete</a>
<%--                <button class=""></button>--%>
<%--                <button class="btn-delete">Delete</button>--%>

            </div>
        </div>
        <%
            }
        } else {
        %>
        <p>No products available</p>
        <% } %>


    </div>
</div>
</body>

</html>
