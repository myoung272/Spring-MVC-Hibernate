<!DOCTYPE html>
<html lang="en">
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ page trimDirectiveWhitespaces="true" %>

    <?xml version="1.0" encoding="ISO-8859-1" ?>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
             pageEncoding="ISO-8859-1"%>
<head>
<TITLE>Crunchify - Spring MVC Example with AJAX call</TITLE>
 
<style type="text/css">
body {
    background-image:
        url('http://cdn3.crunchify.com/wp-content/uploads/2013/03/Crunchify.bg_.300.png');
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<script type="text/javascript">
    
    function crunchifyAjax() {
         alert("In crunchifyAjax");
        $.ajax({
            url : 'ajaxtest.html',
            success : function(data) {
                $('#result').html(data);
            }
        });
    }
 
</script>
 
<script type="text/javascript">
    alert("In setInterval");
   // var intervalId = 0;
  //  intervalId = setInterval(crunchifyAjax, 3000);
</script>
</head>
 
<body>
    <div align="center">
        <button onclick="crunchifyAjax()">Click for time</button>
        <br> <br> ${message} <br> <br>
        <div id="result"></div>
        <br>
        <p>
            by <a href="http://crunchify.com">Crunchify.com</a>
        </p>
    </div>
</body>
</html>