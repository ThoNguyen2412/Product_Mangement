<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Form</title>
        <link href="<c:url value="/webjars/bootstrap/3.4.1/css/bootstrap.min.css"/>" 
              type="text/css" rel="stylesheet"/>
        <style>
            .ui-error{
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12" style="text-align: center">
                    <h2>Product Form</h2>
                </div>
            </div>

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
                    <form:form action="${pageContext.request.contextPath}/${action}" method="post" 
                               modelAttribute="product" class="form-horizontal">
                        <c:if test="${action=='updateProduct'}">
                            <input name="id" value="${product.id}" hidden />
                            <input name="category.id" 
                                   value="${product.category.id}" hidden />
                        </c:if>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Name
                                <span class="ui-error">(*)</span></label>
                            <div class="col-sm-8">
                                <input name="name" class="form-control" required
                                       value="${product.name}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">
                                Price</label>
                            <div class="col-sm-8">
                                <input name="price" class="form-control"
                                       value="${product.price}"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">
                                Description</label>
                            <div class="col-sm-8">
                                <textarea name="description" 
                                          class="form-control">${product.description}</textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">
                                Category</label>
                            <div class="col-sm-8">
                                <select name="category.id" class="form-control">
                                    <c:forEach items="${categories}" var="c">
                                        <c:if test="${c.id==product.category.id}" >
                                            <option value="${c.id}" selected>${c.name}</option>
                                        </c:if>
                                        <c:if test="${c.id!=product.category.id}" >
                                            <option value="${c.id}">${c.name}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-primary" 
                                    type="submit">Submit</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
