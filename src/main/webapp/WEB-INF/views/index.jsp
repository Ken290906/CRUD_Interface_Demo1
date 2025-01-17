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
    <h2 class="text-center">Spring Boot JSP Hello World Example</h2>

    <div class="container mt-5">
        <h1 class="text-center mb-4">Add San Pham</h1>
        <form action="addSanPham" method="post" class="border p-4 rounded bg-light shadow">
            <input type="hidden" name="id" value="${sp != null ? sp.id : ''}">
            <div class="mb-3">
                <label class="form-label">Ma</label>
                <input type="text" class="form-control" name="maSanPham" placeholder="Nhap Ma" value="${sp.maSanPham}">
            </div>
            <div class="mb-3">
                <label class="form-label">Ten</label>
                <input type="text" class="form-control" name="tenSanPham" placeholder="Nhap Ten" value="${sp.tenSanPham}">
            </div>
            <div class="mb-3">
                <label class="form-label">Danh Muc</label>
                <select name="idDanhMuc" class="form-select">
                    <c:forEach items="${listDM}" var="dm">
                        <option value="${dm.id}" ${sp != null && sp.idDanhMuc != null && sp.idDanhMuc.id == dm.id ? 'selected' : ''}>
                                ${dm.maDanhMuc}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Trang Thai</label>
                <select name="trangThai" class="form-select">
                    <option value="Hoat dong">Hoat dong</option>
                    <option value="Khong hoat dong">Khong hoat dong</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary w-100" onclick="return confirm('Ban co chac chan muon them ?')">Submit</button>
            <button type="submit" class="btn btn-secondary w-100 mt-2" formaction="/san-pham/editSP/editSanPham" formmethod="post" onclick="return confirm('Ban co chac chan muon sua khong ?')">Edit</button>
        </form>

        <form action="search-sanPham" method="get" class="d-flex align-items-center mt-4 mb-4">
            <input type="text" name="keyword" id="keyword" class="form-control me-2" placeholder="Search by keyword..." value="${keyword}" required>
            <button type="submit" class="btn btn-primary me-2">Search</button>
            <%--            <button type="button" class="btn btn-secondary" id="btnClear" onclick="clearSearch()">Clear</button>--%>
        </form>

    </div>



    <div class="mt-4">
        <h3>Add Sản Phẩm</h3>

        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Ma SP</th>
                    <th>Ten SP</th>
                    <th>ID Danh Muc</th>
                    <th>Trang Thai</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${currentPage.content}" var="sp">
                    <tr>
                        <td>${sp.id}</td>
                        <td>${sp.maSanPham}</td>
                        <td>${sp.tenSanPham}</td>
                        <td>${sp.idDanhMuc.maDanhMuc}</td>
                        <td>${sp.trangThai}</td>
                        <td>
                            <a href="/san-pham/xoaSP/${sp.id}" class="btn btn-danger btn-sm">Delete</a>
                            <a href="/san-pham/editSP/${sp.id}" class="btn btn-secondary btn-sm">Detail</a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <nav arial-label="Page navigation example" class="mt-4">
            <ul class="pagination justify-content-center">
                <!-- Nút Previous -->
                <li class="page-item ${currentPage.number == 0 ? 'disabled' : ''}">
                    <a class="page-link" href="?page=${currentPage.number - 1}&keyword=${searchInput != null ? searchInput : ''}">Previous</a>
                </li>

                <!-- Các trang -->
                <c:forEach begin="0" end="${currentPage.totalPages - 1}" var="i">
                    <li class="page-item ${currentPage.number == i ? 'active' : ''}">
                        <a class="page-link" href="?page=${i}&keyword=${searchInput != null ? searchInput : ''}">${i + 1}</a>
                    </li>
                </c:forEach>

                <!-- Nút Next -->
                <li class="page-item ${currentPage.number + 1 == currentPage.totalPages ? 'disabled' : ''}">
                    <a class="page-link" href="?page=${currentPage.number + 1}&keyword=${searchInput != null ? searchInput : ''}">Next</a>
                </li>
            </ul>
        </nav>

    </div>
</div>

<script type="text/javascript">
    // function clearSearch() {
    //     window.location = "[[@{/search-sanPham}]]";
    // }
</script>
</body>
</html>

