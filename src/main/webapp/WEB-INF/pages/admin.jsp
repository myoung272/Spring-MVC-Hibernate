<!DOCTYPE html>
<html lang="en">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    
<script language="JavaScript">
function toggleChecked(status) {
 $("#sDay input").each( function() {
 $(this).attr("checked",status);
 })
 }
 
 function toggleChecked2(status) {
 $("#fDay input").each( function() {
 $(this).attr("checked",status);
 })
 }
</script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  

    <div class="container text-center">    
  <h3>Enter Start Ordering Times: </h3>
  <br>
  <form:form method="post"  action="${pageContext.request.contextPath}/updateOrderTimes.html"  modelAttribute="orderTimes">
  <div class="row">
    <div class="col-sm-6">
        Monday<br>
     <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.mo}"  /><br>
        <form:select  path="mo" name="sDays" id="mo"> 
            <option  value="10:00:00" >10:00 AM</option>
                    <option value="10:30:00" >10:30 AM</option>
                    <option value="11:00:00" >11:00 AM</option>
                    <option value="11:30:00" >11:30 AM</option>
        <option value="12:00:00" >12:00 PM</option>
        </form:select>
    </div>
 <%--   <div class="col-sm-2"> 
        Tuesday<br>
         <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.tu}"  /><br>
        <form:select  path="tu" name="sDays" id="tu"> 
                    <option value="10:00" >10:00 AM</option>
                    <option value="10:30" >10:30 AM</option>
                    <option value="11:00" >11:00 AM</option>
                    <option value="11:30" >11:30 AM</option>
        <option value="12:00" >12:00 PM</option>
        </form:select>
    </div>
    <div class="col-sm-2"> 
    Wednesday <br>
      <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.we}"  /><br>
        <form:select  path="we" name="sDays" id="we"> 
                    <option value="10:00" >10:00 AM</option>
                    <option value="10:30" >10:30 AM</option>
                    <option value="11:00" >11:00 AM</option>
                    <option value="11:30" >11:30 AM</option>
        <option value="12:00" >12:00 PM</option>
        </form:select>
    </div>
    <div class="col-sm-2"> 
        Thursday<br>
          <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.tr}"  /><br>
        <form:select  path="tr" name="sDays" id="tr"> 
                    <option value="10:00" >10:00 AM</option>
                    <option value="10:30" >10:30 AM</option>
                    <option value="11:00" >11:00 AM</option>
                    <option value="11:30" >11:30 AM</option>
        <option value="12:00" >12:00 PM</option>
        </form:select>
    </div> 
    <div class="col-sm-2"> 
        Friday<br>
          <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.fr}"  /><br>
        <form:select  path="fr" name="sDays" id="fr"> 
                    <option value="10:00" >10:00 AM</option>
                    <option value="10:30" >10:30 AM</option>
                    <option value="11:00" >11:00 AM</option>
                    <option value="11:30" >11:30 AM</option>
        <option value="12:00" >12:00 PM</option>
        </form:select>
    </div>     
    <div class="col-sm-1"> 
        Saturday<br>
          <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.sa}"  /><br>
        <form:select  path="sa" name="sDays" id="sa"> 
                    <option value="10:00" >10:00 AM</option>
                    <option value="10:30" >10:30 AM</option>
                    <option value="11:00" >11:00 AM</option>
                    <option value="11:30" >11:30 AM</option>
        <option value="12:00" >12:00 PM</option>
        </form:select>
    </div> 
       <div class="col-sm-1"> 
           Sunday<br>
             <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.su}"  /><br>
        <form:select  path="su" name="sDays" id="su"> 
                    <option value="10:00" >10:00 AM</option>
                    <option value="10:30" >10:30 AM</option>
                    <option value="11:00" >11:00 AM</option>
                    <option value="11:30" >11:30 AM</option>
        <option value="12:00" >12:00 PM</option>
        </form:select>
  </div>
 --%>
        <div class="col-sm-6">
            <input type="submit" value="Submit" size="6" />
        </div>
 
  </form:form>   
</div><br>
    </div>


</body>
</html>
