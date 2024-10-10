<%--
  Created by IntelliJ IDEA.
  User: PhanDz
  Date: 10/10/2024
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Bên Trái</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
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
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <a href="control-servlet?action=listproduct">Quản lý sản phẩm</a>
    <a href="#">Giá sản phẩm</a>
</div>

<div class="main-content">
    <h1>Chào mừng đến trang cua Phan</h1>


    <section id="product-management">
        <h2>Quản lý sản phẩm</h2>

    </section>

    <section id="product-pricing">
        <h2>Giá sản phẩm</h2>

    </section>
</div>

</body>
</html>
