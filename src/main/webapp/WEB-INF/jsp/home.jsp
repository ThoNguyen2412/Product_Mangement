<%-- 
    Document   : home
    Created on : Jun 4, 2019, 6:55:42 PM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="<c:url value="/webjars/bootstrap/3.4.1/css/bootstrap.min.css"/>" 
              type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12" style="text-align: center">
                    <h2>List Product</h2>
                </div>
            </div>
            <!--Success/fail-->
            <c:if test="${message!=null && message!=''}">
                <div class="row">
                    <div class="col-sm-12">
                        <c:if test="${status!=null && status=='success'}">
                            <div class="alert alert-success">
                                ${message}
                            </div>
                        </c:if>
                        <c:if test="${status!=null && status=='fail'}">
                            <div class="alert alert-danger">
                                ${message}
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:if>
            <!--addProduct-->
            <div class="row">
                <div class="col-sm-6" style="padding-bottom: 10px">
                    <button class="btn btn-info"
                            onclick="location.href = '<c:url value="/form-add-product"/>'">
                        Add Product</button>
                </div>
                <!--searchProduct-->
                <div class="col-sm-6" style="text-align: right">
                    <form action="${pageContext.request.contextPath}/search" method="post" class="form-inline">
                        <div class="form-group">
                            <input name="searchTxt" class="form-control" />
                            <input type="submit" value="Search" class="btn btn-info" />
                        </div>  
                    </form>
                </div>
            </div>
            <!--product table-->
            <div class="row">
                <div class="col-sm-12">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <tr>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Category</th>
                                <th>Price</th>
                                <th>Action</th>
                            </tr>
                            <c:forEach var="product" items="${products}">
                                <tr>
                                    <td>${product.name}</td>
                                    <td>${product.description}</td>
                                    <td>${product.category.name}</td>
                                    <td>${product.price}</td>
                                    <!--action(update/delete)-->
                                    <td>
                                        <button  class="btn btn" style="color: green"
                                                 onclick="location.href = '<c:url value="/update/${product.id}"/>'">
                                            Update</button>
                                        <button class="btn btn " style="color: red"
                                                onclick="location.href = '<c:url value="/delete/${product.id}"/>'">
                                            Delete</button>
                                        <button class="btn btn-primary " style="color: whitesmoke; width: 100px" 
                                                onclick="location.href = '<c:url value="/order/${product.id}"/>'">
                                            Order</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
