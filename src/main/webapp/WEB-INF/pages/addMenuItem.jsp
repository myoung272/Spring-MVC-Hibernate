
<!DOCTYPE html> 
<html lang="en">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ page trimDirectiveWhitespaces="true" %>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link href="<c:url value="/resources/css/fos.css" />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/superMariof2os.css" />" rel="stylesheet"/>
        <title>Add Item | Super Mario Pizza</title>
    </head>
    <body>
        <div class="container">
       <%--     <div class="row">
                <%@ include file="/WEB-INF/pages/header2.jspf" %> 
            </div>
       --%>
         
            <form:form method="POST" action="${pageContext.request.contextPath}/addMenuItem/uploadEx.html" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">
         
            <div class="row">
                <div class="form-group col-md-12">
                    <label class=" control-lable" for="file">Upload menu from Excel sheet</label>
                   
                        <form:input type="file" path="file" id="file" class="form-control input-sm"/>
                </div>
            </div>
     
            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                </div>
            </div>
        </form:form>
            
            <p>${message}</p>
            <br />
            <div class="row table-responsive">
                <form:form method="POST" commandName="addItem"  action="${pageContext.request.contextPath}/addMenuItem.html" >
                    <table class="center">
                        <thead>
                            <tr>
                                <th>Category</th>
                                <th>Item</th>
                                <th>Description</th>
                                <th>Size</th>
                                <th>Price</th>
                                <th>Add</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><form:input path="category" required="required"  /></td>
                                <td><form:input path="item" required="required"  /></td>
                                <td><form:input path="description"  required="required" /></td>
                                <td><form:input path="size" required="required"  /></td>
                                <td><form:input path="price" required="required"   /></td>
                                <td ><input type="submit" value="Add" size="3" /></td>
                            </tr>
                        </tbody>
                    </table>
                </form:form>
            </div>
            <div class="row">
                 <p style="float:right"
                   ${message} <c:out value="${pageContext.request.contextPath}"/><br/>
                    <a href="${pageContext.request.contextPath}/adminOrderTimes.html">Set Order Hours</a><br/>
                    <a href="${pageContext.request.contextPath}/team/list.html">Team list</a><br/>
                    <a href="${pageContext.request.contextPath}/customers/list.html">Customers list</a><br/>
                    <a href="${pageContext.request.contextPath}/index.html">Home page</a><br />
                    <a href="${pageContext.request.contextPath}/user.html?login=login">Login on home page</a>
                </p>
            </div>
        </div>
    </body>
</html>
