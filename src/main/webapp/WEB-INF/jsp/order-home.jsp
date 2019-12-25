<%-- 
    Document   : order-home
    Created on : Jun 16, 2019, 3:35:26 PM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Home</title>
        <link href="<c:url value="/webjars/bootstrap/3.4.1/css/bootstrap.min.css"/>" 
              type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12" style="text-align: center">
                    <h2>Order Product</h2>
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
            <div class="row">

                <div class="col-sm-12">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <tr>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th colspan="2">Action</th>
                            </tr>
                            <c:forEach var="orders" items="${order.orderDetails}">
                                <tr>
                                    <td>${orders.product.name}</td>
                                    <td>${orders.price}</td>
                                    <td>${orders.quantity}</td>
                                    <td>
                                        <form:form action="${pageContext.request.contextPath}/applyTotalprice" method="post" 
                                                   modelAttribute="quantity"  class="form-horizontal">
                                            <input type="number" name="quantity" step="1" value="1"></input>
                                            <div class="form-group" style="text-align: center">
                                                <button class="btn btn-primary" 
                                                        type="submit">Apply</button>
                                            </div>
                                        </form:form>
                                    </td>
                                    <td>
                                        <button class="btn btn " style="color: red"
                                                onclick="location.href = '<c:url value="/deleteOrder/${product.id}"/>'">
                                            Delete</button>
                                    </td>
                                </tr>
                            </table>

                            <div class="row">
                                <div class="col-sm-12" style="text-align: center">


                                </div>
                            </div>
                        </c:forEach>
                        <div class="col-sm-6" style="padding-bottom: 10px">
                            <button class="btn btn-info"
                                    onclick="location.href = '<c:url value="/home"/>'">
                                Home</button>
                        </div>



                        <div class="col-sm-6" style="text-align: right">
                            <button class="btn btn-info"
                                    onclick="location.href = '<c:url value="/home"/>'">
                                Next</button>
                        </div>
                        <h2>Total Price:${orderDetail.price}</h2> 

                    </div>
                </div>

            </div>
        </div>

    </body>
</html>
