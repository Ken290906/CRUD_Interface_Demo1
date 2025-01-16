<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot JSP Hello World</title>
    <!-- Add Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Add Bootstrap JavaScript Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Login Form</h1>
    <h2 class="text-center mb-4">Chuc mung da dang ky tai khoan thanh cong !</h2>

    <form action="/san-pham/login" method="POST" class="border p-4 rounded bg-light shadow">
        <c:if test="${not empty error}">
            <div class="alert alert-danger text-center" role="alert">
                    ${error}
            </div>
        </c:if>

        <div class="mb-3">
            <label for="email" class="form-label">Email hoac Username</label>
            <input type="text" class="form-control" id="email" name="emailORusername" placeholder="Enter your email or your username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password">
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-primary w-100 mb-2">Login</button>
            <button type="submit" class="btn btn-primary w-100" formaction="/san-pham/register-form" formmethod="GET">Register</button>
        </div>
    </form>
</div>
</body>
</html>