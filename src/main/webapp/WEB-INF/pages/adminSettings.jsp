<!DOCTYPE html>
<html lang="en">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <head>
        <title>adminOrders.jsp</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
     <link href="<c:url value="/resources/css/fos.css" />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/superMariof2os.css" />" rel="stylesheet"/>
       
        <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>

        <style>
            /* BOOTSTRAP CUSTOM */
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }
            .navbar-custom {
                background-color:#66ccff;
                color:#ffffff;
                border-radius:0;
            }

            .navbar-custom .navbar-nav > li > a {
                color:#fff;
            }
            .navbar-custom .navbar-nav > .active > a, .navbar-nav > .active > a:hover, .navbar-nav > .active > a:focus {
                color: #ffffff;
                background-color:transparent;
            }
            .navbar-custom .navbar-brand {
                color:#eeeeee;
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

            hr {
                border-width: 2px;
            }

            th, td {
                padding: 5px;
                text-align: left;
            }

           table, td, th {    
   border: solid;
  border-width: 1px 0;
    text-align: center;
    width: 30%;
    align-content: center;
}

.itemTD {
    text-align: center;
}

.divTD{
   text-align: center; 
}

 
        </style>

    </head>
    <body>
        <%@ include file="/WEB-INF/pages/bootstrapHeader.jspf" %>
        <div class="container">  
            
                <!-- TURN ON/OFF ORDERING -->
        
        
        </div>  <!-- container --> 
    </body> 
</html>
