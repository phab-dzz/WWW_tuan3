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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <title>Quan Ly San Pham</title>
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

        .sidebar .dropdown-menu {
            background-color: #2c3e50;
            border: none;
        }

        .sidebar .dropdown-menu a {
            color: white;
        }

        .sidebar .dropdown-menu a:hover {
            background-color: #34495e;
        }

        #button {
            background-color: #4CAF50;
            /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 10px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 10px;
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <a href="index.jsp">Trang chủ</a>
    <div class="dropdown">
        <a  class="dropdown-toggle" data-toggle="dropdown">Quản lý sản phẩm</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="control-servlet?action=listproduct">Xem danh sach</a>
            <a class="dropdown-item" href="./pages/Themsanpham.jsp">Thêm</a>
            <a class="dropdown-item" href="#">update</a>
            <a class="dropdown-item" href="#">Xoá</a>
        </div>
    </div>
    <div class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown">Giá sản phẩm</a>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Thêm</a>
            <a class="dropdown-item" href="#">update</a>
            <a class="dropdown-item" href="#">Xoá</a>
        </div>
    </div>
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
