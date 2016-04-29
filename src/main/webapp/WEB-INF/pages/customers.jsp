
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
    <head>
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Customers</title>
        <link href="<c:url value="/resources/css/fos.css" />" rel="stylesheet" /> 
        <link href="<c:url value="/resources/css/superMariof2os.css" />" rel="stylesheet"/> 
   
     
    </head>
    <body >
     
        <div class="container">
            <div>     
      <%--  <c:import url="/resources/includes/logoHeader"></c:import> --%>   <!-- didn't work, no error -->
         <%@ include file="/WEB-INF/pages/header2.jspf" %> 
         <%--   <jsp:include page="/WEB-INF/pages/LogoHeader" flush="true"></jsp:include> --%>
  
         
      <%--     <jsp:include page="<c:url value='/resources/includes/logoHeader.jsp' />"></jsp:include> --%> <!-- .noHandlerFound No mapping found  -->
            </div>
         <h1>Customers</h1>
        <p>Here you can see the list customers</p>
        <table align="center" class="normal" cellpadding="5" cellspacing="1" rules="all"  width="100%" >
            
               <tr bgcolor="#E2D1B8">
                    <th>Cust Id</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Town</th>
                    <th>State</th>
                    <th>Zip</th>
                    <th>Total Orders</th>
                    <th>Role</th>
                </tr>
           
            
                <c:forEach var="cust" items="${custs}" varStatus="line">
                    <c:choose>
                        <c:when test="${line.count % 2 == 0}">
                            <tr bgcolor="#CCCCCC"> 
                            </c:when>
                            <c:otherwise>
                                <tr bgcolor="#F1F1F1"> 
                                </c:otherwise>
                            </c:choose>
                            <td>${cust.custId}</td>
                            <td>${cust.fname}&nbsp;${cust.lname}</td>
                            <td>${cust.phone}</td>
                            <td>${cust.email}</td>
                            <td>${cust.street}</td>
                            <td>${cust.city}</td>
                            <td>${cust.state}</td>
                            <td>${cust.zip}</td>
                            <td>${cust.totalOrders}</td>
                            <td>${cust.role.role}</td>

                          
                        </tr>

                    </c:forEach>
           
        </table>

        <p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
        </div>
    </body>
</html>
