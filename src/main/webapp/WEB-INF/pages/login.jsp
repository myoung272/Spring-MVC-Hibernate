<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Super Mario Pizza</title>
        <link href="<c:url value="/resources/css/fos.css" />" rel="stylesheet" /> 
        <link href="<c:url value="/resources/css/superMariof2os.css" />" rel="stylesheet"/> 
        <title>Login page</title>
    </head>
    <body>
        <div class="container">
            <%@ include file="/WEB-INF/pages/header2.jspf" %>  
            <h1>Login</h1>
            <p><h3 style="color: red">${message}</h3></p>
                <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user.html">
                <table class="normal">
                    <tbody>
                        <tr>
                            <td>&nbsp; Email:</td>
                            <td> <form:input path="email"/></td>

                            <td>Password:</td>
                            <td> <form:password path="password"/></td>

                            <td><input type="submit" value="Submit" class="btn btn-primary btn-sm"/></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>

            <p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
        </div>
    </body>
</html>