 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>f2os Fast Food Ordering Systems</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
           <link href="<c:url value="/resources/css/responsive.bootstrap.css" />" rel="stylesheet"/> 
 
      <link href="<c:url value="/resources/css/bootSuperMariof2os.css" />" rel="stylesheet"/> 
      
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
       <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
      
       <style>
              .navbar-custom {
   background-color:#66ccff;
    color:#ffffff;
    border-radius:0;
} 
.navbar-custom .navbar-nav > .active > a, .navbar-nav > .active > a:hover, .navbar-nav > .active > a:focus {
    color: #ffffff;
    background-color:transparent;
}
       </style>
      
</head>

<body>
   <div class="container-fluid">
    
       <%@ include file="/WEB-INF/pages/custBootstrapHeader.jspf" %>
    <h2 align="center">Welcome to f2os ( Fast Food  Ordering Systems).</h2>

    <p><h3>This application was built using Spring MVC 4.0 with Hibernate and MySql for persistence.</h3><br>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Technologies Used</button></p>
       <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Super Mario (f2os) Technologies Used  </h4>
        </div>
        <div class="modal-body">
<p>Spring MVC 4</p>
<p>Tomcat 8</p>
<p>Hibernate</p>
<p>Java Sever Pages, JSTL</p>
<p>DataTables.net</p>
<p>Bootstrap</p>
<p>Twilio</p>
<p>CSS 3</p>
<p>HTML 5</p>
<p>jquery</p>
<p>AJAX</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>

<br>
<strong>Note:</strong> To view this site as the pizza shop administrator login with these credentials: <br>
<strong> Email: </strong> mario@msn.com<br>
<strong>Password: </strong> password<br>
    </p>
    <h3>Features Include:</h3><br>
    <strong>  E-Z menu loading </strong>
    <p><h5>The menu will need to initially be typed into an  Excel sheet. <a href="<c:url value='/download/pizza' />">Download sample pizza menu</a>   Then an admin user  can upload the file through the admin interface. After the initial menu load  the admin 
        can either re-upload an edited file or use the admin interface to  edit items or add new items. When an existing item is edited, that item is  marked as inactive and a new item is created to replace the edited item. This  is for history reasons so that an order history will reflect the state of the  item when ordered.
        The menu is stored in cache  as a global attribute which is loaded from the database at sever (Tomcat) start  up. Any edits or re-loads will re-load the menu cache. This allows for fast  order selection without database reads. </h5></p>
    <p><strong>Order notifications:</strong></p>
    <p><h5>The restaurant can view  online orders with any web enabled device. By monitoring the admin orders page,  which auto refreshes, new orders will appear 
    within  60 seconds of when they  are placed, The  admin can update the  order as &quot;In Progress&quot; &quot;Completed&quot;  or &quot;Canceled&quot;. 
    The customer  receives an email when the order is placed. A text message (sms) and a fax notification is also available.</h5></p>
<p><strong>Ordering Times:</strong></p>
    <p><h5>The admin can set the  ordering times through the admin interface on a day-of-the-week basis. The admin can also turn off ordering completely for 
        holidays or other reasons.</h5></p>
        <h5>   <p>Ordering times are displayed  to the user on the start order page. A user may still build their order but  will not be allowed to place the order till ordering is open. The order is  retained in their session for 30 minutes. If their session expires before they  can place their order they will need to rebuild their order.</p>
    <p><strong>Order Tracking:</strong></p>
    <p>A customer needs to be  registered to place orders and the customer's order history is saved.  Promotions and free items can be triggered based on order history.</p>
    <p>An admin has the ability to  look up orders based on either order id or customer id.</p></h5>
   
    
   <p>   <a name="contactInfo"><strong> Contact Info:</strong></a>
   <br>Mitch Young Java Web Developer:<br>
    Middletown, NJ<br>
    732.241.0646<br>
   <a href="mailto:myphoto@msn.com">myphoto@msn.com</a>
       </div>
  
</body>
</html>