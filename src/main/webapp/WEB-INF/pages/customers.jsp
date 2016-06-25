
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 

<!DOCTYPE html>
<html lang="en">
    <head>
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
         <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
           <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
     <link href="<c:url value="/resources/css/fos.css" />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/superMariof2os.css" />" rel="stylesheet"/>
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
             <script>
  $(document).ready(function() {
    // Setup - add a text input to each footer cell
    $('#example tfoot th').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
    } );
 
    // DataTable
    var table = $('#example').DataTable();
 
    // Apply the search
    table.columns().every( function () {
        var that = this;
 
        $( 'input', this.footer() ).on( 'keyup change', function () {
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );
    } );
  
} );


        </script>
   
     
    </head>
    <body >
      <%@ include file="/WEB-INF/pages/bootstrapHeader.jspf" %>
        <div class="container">
        
      <%--  <c:import url="/resources/includes/logoHeader"></c:import> --%>   <!-- didn't work, no error -->
        
        
         <%--   <jsp:include page="/WEB-INF/pages/LogoHeader" flush="true"></jsp:include> --%>
  
         
      <%--     <jsp:include page="<c:url value='/resources/includes/logoHeader.jsp' />"></jsp:include> --%> <!-- .noHandlerFound No mapping found  -->
          
  <%--    <p>Super Mario Customer List</p>
          <div class="catItems container  table-responsive">
        <table  >
               <tr bgcolor="#ecf2f9">
                    <td>Cust Id</td>
                    <td>Name</td>
                    <td>Phone</td>
                    <td>Email</td>
                    <td>Address</td>
                    <td>Town</td>
                    <td>State</td>
                    <td>Zip</td>
                    <td>Total Orders</td>
                    <td>Role</td>
                </tr>
                <c:forEach var="cust" items="${custs}" varStatus="line">
                       <c:choose>
                        <c:when test="${line.count % 2 == 0}">
                            <tr bgcolor="#e6faff"> 
                            </c:when>
                            <c:otherwise>
                                <tr bgcolor="#ffffff"> 
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
           </div>
  --%>
        <div class="row container" >
               
                   
                       <table id="example" class="catItems stripe display compact" cellspacing="0" width="100%" >
                            <thead>
                                <tr bgcolor ="#ecf2f9" >
                                    <!-- <th class="header">Product ID</td> -->
                                     <th>Cust ID</th>
                                   <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Town</th>
                                    <th>State</th>
                                    <th>Zip</th>
                                    <th>Total Orders</th>
                                    <th>Role</th>
                                </tr> 
                            </thead>
                            <tfoot>
                                <tr>
                                   <th>Cust ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Phone</th>
                                    <th>Email</th>
                                    <th>Address</th>
                                    <th>Town</th>
                                    <th>State</th>
                                    <th>Zip</th>
                                    <th>Total Orders</th>
                                    <th>Role</th>
                                </tr>
                            </tfoot>
                            <tbody>
                                
                                 <c:forEach var="cust" items="${custs}" varStatus="line">
                       <c:choose>
                        <c:when test="${line.count % 2 == 0}">
                            <tr bgcolor="#e6faff"> 
                            </c:when>
                            <c:otherwise>
                                <tr bgcolor="#ffffff"> 
                                </c:otherwise>
                            </c:choose>
                                          
                                            <td data-search="${cust.custId}" data-order="${cust.custId}">
                                              ${cust.custId}
                                            </td>
                                        <td data-search="${cust.fname}" data-order="${cust.fname}">
                                      ${cust.fname}
                                        </td>
                                           <td data-search="${cust.lname}" data-order="${cust.lname}">
                                      ${cust.lname}
                                        </td>
                                        <td data-search="${cust.phone}" data-order="${cust.phone}">
                                           ${cust.phone}
                                        </td>
                                        <td data-search="${cust.email}" data-order="${cust.email}">
                                           ${cust.email}
                                        </td>
                                        <td data-search="${cust.street}" data-order="${cust.street}">
                                     ${cust.street}
                                        </td>
                                        <td data-search="${cust.city}" data-order="${cust.city}">
                                          ${cust.city}
                                        </td>
                                            <td data-search="${cust.state}" data-order="${cust.state}">
                                         ${cust.state}
                                        </td>
                                         <td data-search="${cust.zip}" data-order="${cust.zip}">
                                          ${cust.zip}
                                        </td>
                                         <td data-search="${cust.totalOrders}" data-order="${cust.totalOrders}">
                                          ${cust.totalOrders}
                                        </td>
                                         <td data-search="${cust.role.role}" data-order="${cust.role.role}">
                                          ${cust.role.role}
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
            </div>
           
                 
        </div>
    </body>
</html>
