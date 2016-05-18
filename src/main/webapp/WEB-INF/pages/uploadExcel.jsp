<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Excel Upload</title>
     <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link href="<c:url value="/resources/css/fos.css" />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/superMariof2os.css" />" rel="stylesheet"/>
</head>
<body> 
 
    <div class="container">
        <div class="row">
                <%@ include file="/WEB-INF/pages/header2.jspf" %> 
            </div>
       
        <form:form method="POST" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">
         
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="file">Upload a file</label>
                    <div class="col-md-7">
                        <form:input type="file" path="file" id="file" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="file" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                </div>
            </div>
        </form:form>
        <a href="<c:url value='/welcome' />">Home</a>
    </div>
</body>
</html>
