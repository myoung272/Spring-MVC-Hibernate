
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
            <div class="row">
                <%@ include file="/WEB-INF/pages/header2.jspf" %> 
            </div>
            <div class="row">
               <form:form action="hello" method="post" enctype="multipart/form-data">
		<input name="excelfile2007" type="file">		
		<input type="submit" value="processExcel2007">
	</form:form>
            </div>
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
        </div>
    </body>
</html>
