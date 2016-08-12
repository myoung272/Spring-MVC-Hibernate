<!DOCTYPE html>
<html lang="en">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ page trimDirectiveWhitespaces="true" %>
    

    <?xml version="1.0" encoding="ISO-8859-1" ?>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
             pageEncoding="ISO-8859-1"%>

    <head>
         <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>Super Mario Pizza</title>
          <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
           <link href="<c:url value="/resources/css/responsive.bootstrap.css" />" rel="stylesheet"/> 
      <%--  <link href="<c:url value="/resources/css/fos.css" />" rel="stylesheet" /> --%>
      <link href="<c:url value="/resources/css/bootSuperMariof2os.css" />" rel="stylesheet"/> 
      
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
       <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
       
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

        </style>
        
        <script>
            counter = 0;
            function validatePickOrDel(form) {
                if (document.getElementById('pick').checked) {
                    //alert("pick up is checked");
                }
                else if (document.getElementById('del').checked) {
                    //alert("delivery is checked");
                }
                else {
                    alert("You must select Pick Up or Delivery");
                    return false;
                }
                counter++;
                if (counter > 1) {
                    alert("You have already submited this order, please wait for the confirmation page.");
                    return false;
                }
                form.submit();
            }
        </script>
        <script>
            counter = 0;
            function validate(form) {
                counter++;
                if (counter > 1) {
                    alert("You have already submited this order, please wait for the confirmation page.");
                    return false;
                }
                form.submit();
            }
        </script>
     <script>
            $(document).ready(function () {
                function getCat(event) {
                    event.preventDefault();
                    var href = encodeURI($(this).attr("href"));
                    console.log(href);
                    $('#mainContent').load(href + ' #menuItemsDiv');
                }
                $("#categories a").click(getCat);
                // below only works after fist one if multi

           /*      $( '#menuSelItems' ).on( 'click', 'a', function( event ) {
                 event.preventDefault();
                 var href = encodeURI($(this).attr("href"));
                 console.log( $( this ).text() );
                 $('#menuSelItems').load(href + ' #showOrder');
                 });
            */     

            }); // end doc ready
        </script>
     
       
        <script >
            $(document).ready(function () {
                $("#mainContent").on('click', 'form[name="orderItemForm"]', function () {
                    event.preventDefault();
                    var str = $(this).serialize();
                    var act = $(this).attr("action");
                    console.log(act);
                    $.ajax({
                        type: "get",
                        data: str,
                        url: $(this).attr("action"),
                        async: true,
                        dataType: "html",
                        success: function (data) {
                            $("#mainContent").html($(data).find("#menuSelItems").html());
                        }
                    });
                });
            }); // end doc ready	
        </script>
   
   
     

    </head>

    <body>
        <h2 align="center">Super Mario Spring MVC Hibernate 4.0</h2>
   
      
        <div class="container-fluid">
               <%@ include file="/WEB-INF/pages/custBootstrapHeader.jspf" %>
          

            <!-- list of categories on left side of page, always displayed set as a session attribute. -->
            <div class="row">

           <div class="sidebar1 col-xs-3 col-md-3"> 
                <table id="categories" >
                    <tr><td id="catHeader">Categories:</td></tr>
                    <!-- This link will generate the menu items associated with the category clicked on -->
                    <c:forEach var="cat" items="${catCache}" varStatus="line">
                        <tr><td id="selCat" class="catRow" onMouseOver="style.backgroundColor = '#66ccff';"onMouseOut="style.backgroundColor = '#FFF'">
                                <a href="${pageContext.request.contextPath}/menu/menuCat/${cat.category}.html">${cat.category}</a></td></tr>
                            </c:forEach>
                </table>
            </div>
       
      
            <!-- end .sidebar1 CATEGORIES -->

            <div id="mainContent" class="col-xs-6 col-md-6">
                <p><h3 style="color: red; text-align: center">${message}</h3></p>
                
                <!-- CUSTOMERS ORDERS -->
                <c:if test="${!empty custTodayOrders or !empty orderDetail}">
                <div>
                      <%@ include file="/WEB-INF/pages/showOrders.jspf"%>  
                </div>
                 </c:if>
             
                    <!-- LOGIN FORM -->
                <c:if test="${param.login eq 'login'}">
                    <div class="table-responsive">
                        <form:form method="POST" commandName="user" action="${pageContext.request.contextPath}/user.html">
                            <table class="tablel">
                                <tbody>
                                    <tr>
                                        <td>&nbsp; Email:</td><td> <form:input path="email"/></td>
                                        <td>Password:</td> <td> <form:password path="password"/></td>&nbsp;&nbsp;
                                        <td><input type="submit" value="Submit" class="btn btn-primary btn-sm"/></td>
                                        <td></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form:form>
                    </div>
                </c:if>

                <c:if test="${param.reg eq 'reg'}">
                    <%@ include file="/WEB-INF/pages/regUser.jspf"%>
                </c:if>

                <!-- will show instructions when a category has not been selected -->
                <!--   <div id="ajaxMenu"> -->
                    <c:if test="${empty cacheMenu && empty orderLineItems && empty placedOrder && param.reg ne 'reg' }">
                        <p ><h4 style="text-align: center; " >Pick from a category on the left to start your order.</h4>
                       <img style="margin:0px auto;display:block"  src="<c:url value="/resources/images/leftHand.jpg" />" /> 
                        </p>
                    </c:if>
                    <!-- will show the menu items associated to a category, will not render if cacheMenu is empty -->
                 
                    <c:if test="${!empty cacheMenu}"> 
                           <div id="menuItemsDiv" class="table-responsive">
                              <table id="menuItems" class="table" cellspacing="0" width="100%">

                            <%--    <form:form id="" name="orderItemForm" method="get" commandName="order" action="${pageContext.request.contextPath}/order/orderItems/${cm.productId}.html"> --%>
                          
                                <thead>
                                    <tr>
                                        <th id="catItemsHeader" colspan="6" align="center">Category: ${cacheMenu[0].category}</th>
                                    </tr>
                                    <tr>
                                        <th >Category</th>
                                        <th >Item</th>
                                        <th >Size</th>
                                        <th >Description</th>
                                        <th >Price</th>
                                        <th >Add to Order</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="cm" items="${cacheMenu}" varStatus="line">
                                       
                                        <tr>
                                            <td> ${cm.category}
                                                <input  type="hidden" name="category" value="${cm.category}" />
                                            </td>
                                            <td> ${cm.item}
                                                <input type="hidden" name="item" value="${cm.item}" />
                                                <input type="hidden" name="productId" value="${cm.productId}" />
                                            </td>
                                            <td> ${cm.size}
                                                <input type="hidden" name="size" value="${cm.size}" />
                                            </td>

                                             <td>${cm.description}
                                               <input type="hidden" name="description" value="${cm.description}"/>
                                               </td>
                                            <td>
                                                <fmt:formatNumber value="${cm.price}" type="currency" />
                                                <input type="hidden" name="price" value="${cm.price}" />
                                            </td>
                                            <td>
                                                <%-- commandName="order" --%>
                                                <form:form id="" name="orderItemForm" method="get"  action="${pageContext.request.contextPath}/order/orderItems/${cm.productId}.html">
                                                    <input  type="text" size="2" name="pQuant" value="1"  />
                                                    <input   type="button"  value="Add to Order" class="btn btn-primary btn-sm" /> 
                                                </form:form>
                                            </td> 
                                        </tr> 
                                    </c:forEach>
                                        <tr><td colspan="6">&nbsp;</td></tr>
                                </tbody>
                            </table>
                                    </div>
                    </c:if>
                 
                        
                                   
                    
              <!--  </div> -->
                <!--End ajax menu -->
                <!-- MENU SELECTED ITEMS -->
                <%--    <div id="menuSelItems" class="table-responsive"> --%>
                   <div id="menuSelItems">
                    <c:if test="${!empty orderLineItems }">
                        
                        <c:if test="${param.confirm != 'yes'}">
                         
                                <div class="table-responsive">
                                <table id="tblRemItem" class="table"  >
                                    <tr><td class="normalBeige" colspan="9" align="center" > < Select another category to add to your order.</td></tr>
                                    <tr><td class="normalBeige" colspan="9" align="center"><b>Your Order Contains:</b></td></tr>
                                    <tr><td colspan="8" align="center"><font color="#FF0000">${errorMessage}</font></td></tr>
                                
                                    <tr>
                                        <th >Category</th>
                                        <th >Item</th>
                                        <th >Size</th>
                                        <th>Update</th>
                                        <th >Price</th>
                                        <th >Amount</th>
                                        <th >Remove</th>
                                    </tr>
                          
                                    <c:forEach var="o" items="${orderLineItems}" varStatus="line">
                                        <tr>
                                            <td>${o.category}</td>
                                            <td>${o.item}</td>
                                            <td>${o.size}</td>
                                            <!-- Update Form -->
                                            <td>
                                                <form action="${pageContext.request.contextPath}/order/update/${o.productId}" name="updateItem" method="post">
                                                    <input class="order" type="text" size="2" name="updateOrderQuant"  value="${o.quantity}" />
                                                    <input type="hidden" name="updateIndex" value="${line.count}" />
                                                    <input type="submit" value="Update" class="btn btn-primary btn-sm" />
                                                </form>
                                            </td>
                                            <td>${o.price}</td>
                                            <td>${o.price * o.quantity}</td>
                                            <!-- REMOVE ITEM LINK -->
                                            <td ><a name="removeItem" href="${pageContext.request.contextPath}/order/remove/${o.productId}.html">Remove</a></td>
                                        </tr>
                                        </c:forEach>
                                    <tr><td>&nbsp;</td></tr>
                                </table>
                                </div>
                            </c:if>
                           <c:if test="${empty uBean && !empty orderLineItems}">
                        <p>  <a href="${pageContext.request.contextPath}/user.html?login=login">
                                <font color="#FF0000">You must log in to place your order.</font></a></p>
                              </c:if>
                           
                            <c:if test="${!empty uBean && !empty orderLineItems && empty orderTotals}">
                                <table>
                                    <tr>
                                        <td colspan="8">
                                            <form name="placeOrder" method="get" action="${pageContext.request.contextPath}/order/pickDel.html">
                                                Pick Up
                                                <input type="radio" name="pickOrDel" id="pick"  value="PickUp"/>
                                                Delivery
                                                <input type="radio" name="pickOrDel" id="del" value="Delivery"/>
                                                <input type="hidden" name="confirm" value="yes"/>
                                                <input type="hidden" name="backButton" value="0"/>
                                                <input type="button" value="Continue" class="btn btn-primary btn-sm" onclick="validatePickOrDel(this.form)"/>
                                            </form>
                                        </td>
                                    </tr>
                            </table>
                           </c:if>
                    
                        </c:if>
                                   </div> <!-- END menuSelItems -->
          
                <!-- END MENU SELECTED ITEMS -->
                <!-- Show Order for confirmation after user clicks "Continue" button -->
                       
                <c:if test="${param.confirm eq 'yes'}">
               <!--     <div> -->
                   
                        <c:if test="${!empty orderLineItems}">
                            <div class="table-responsive">
                             <table class="table" rules="rows">
                            <tr>
                                <td colspan="6" align="center"><b> Your Order Contains:</b></td>
                            </tr>
                            <tr >
                                <td >Category</td>
                                <td >Item</td>
                                <td >Size</td>
                                <td >Quantity</td>
                                <td >Price</td>
                                <td >Amount</td>
                            </tr>
                            <c:forEach var="o" items="${orderLineItems}" varStatus="line">
                                <tr>
                                    <td>${o.category}</td>
                                    <td>${o.item}</td>
                                    <td>${o.size}</td>
                                    <td>${o.quantity}</td>
                                    <td><fmt:formatNumber value="${o.price}" type="currency"/></td>
                                    <td><fmt:formatNumber value="${o.quantity * o.price}" type="currency"/></td>
                                </tr>
                            </c:forEach>
                                 </c:if>
                             </table>
                        
                   

                    <form:form method="post" action="${pageContext.request.contextPath}/order/saveOrder/${uBean.custId}.html">
                        <!-- SUBMIT ORDER -->
                        <table class="catItems myOrderInfo">
                            <tr><td colspan="6" align="right"> Pizza Toppings or Special Instructions: </td></tr>
                             <tr><td colspan="6" align="right"><textarea rows="4" cols="40" name="comments"></textarea></td></tr>
                                <c:if test="${param.pickOrDel eq 'Delivery'}" >
                                 <tr><td colspan="6" align="right" >Delivery Charge:<fmt:formatNumber value="${orderTotals.deliveryCharge}" type="currency" /></td></tr>
                                </c:if>
                                <tr><td colspan="6" align="right">Sub Total:<fmt:formatNumber value="${orderTotals.subTotal}" type="currency" /></td></tr>
                                <tr><td colspan="6" align="right">Sales Tax: <fmt:formatNumber value="${orderTotals.salesTax}" type="currency" /></td></tr>
                                <tr><td colspan="6"  align="right">Total: <fmt:formatNumber value="${orderTotals.total}" type="currency" /></td></tr>
                                <tr><td colspan="6" align="right">Please double check you order before you submit. </td></tr>
                                <tr><td colspan="6" align="right">Pick up or Delivery: ${param.pickOrDel}</td></tr>
                                <c:if test="${param.pickOrDel eq 'Delivery'}">
                                    <tr> <td colspan="6" align="right">Deliver To:  ${uBean.fname}&nbsp; ${uBean.lname}&nbsp;  ${uBean.street}&nbsp; ${uBean.city}&nbsp; ${uBean.state} </td></tr>
                                </c:if>
                                <tr>
                                 <c:if test="${param.pickOrDel eq 'Delivery' && orderTotals.total  >= 11 || param.pickOrDel eq 'PickUp' }">
                                 <td> <input type="submit" value="Place Order" class="btn btn-primary btn-sm"/> </td>
                                </c:if>
                                    <td> <input type="hidden" name="orderTotal" value="${orderTotals.total}"/> </td>
                                    <td> <input type="hidden" name="userEmail" value="${uBean.email}"/>
                                         <input type="hidden" name="pickOrDel" value="${param.pickOrDel}"/>
                                 </td>
                                </tr>
                                <c:if test="${param.pickOrDel eq 'Delivery' && orderTotals.total -1 < 11 }">
                                <tr>
                                    <td colspan="6" align="right">
                                            <font color="#FF0000"> Your order items must be $10 or more for delivery.</font>
                                            <form:form name="backForm" method="get" action="${pageContext.request.contextPath}/order/pickDel.html">
                                                <input type="hidden" name="pickOrDel" value="${param.pickOrDel}"/>
                                                <input type="hidden" name="backButton" value="1"/>
                                                <input type="submit" value="Back"  />
                                            </form:form>
                                    </td>
                                </tr>
                                </c:if>
                        </table>
                    </form:form>  
                          </div> 
                </c:if>
                           
                <c:if test="${!empty placedOrder}">
                       <div class="table-responsive">
                    <table class="table ">
                        <tr>
                            <td colspan="6"> Thank You  ${uBean.fname}&nbsp; ${uBean.lname} ( Customer# ${uBean.custId} )</td>
                        </tr>
                        <tr>
                            <td colspan="6">Your Order#( <font color="#FF0000">${order.orderId}</font> ) has been placed. Please double check your order below. If there is a mistake please call right away</td>
                        </tr>
                        <tr>
                            <td colspan="6" align="center"><b> Your Order Contains:</b></td>
                        </tr>
                        <tr  >
                            <td >Category</td>
                            <td >Item</td>
                            <td >Size</td>
                            <td >Quantity</td>
                            <td >Price</td>
                            <td >Amount</td>
                        </tr>
                        <c:forEach var="o" items="${placedOrder}" varStatus="line">
                            <tr>
                                <td>${o.category}</td>
                                <td>${o.item}</td>
                                <td>${o.size}</td>
                                <td>${o.quantity}</td>
                                <td><fmt:formatNumber value="${o.price}" type="currency"/></td>
                                <td><fmt:formatNumber value="${o.quantity * o.price}" type="currency"/></td>
                            </tr>
                        </c:forEach>
                        <c:if test="${!empty order.comments}">
                            <tr>
                                <td colspan="6" align="right">Pizza Toppings or Special Instructions:</td>
                            </tr>
                            <tr>
                                <td colspan="6" align="right"><textarea rows="4" cols="40" name="comments">${order.comments}</textarea></td>
                            </tr>
                        </c:if>
                        <c:if test="${param.pickOrDel eq 'Delivery'}" >
                            <tr>
                                <td colspan="6" align="right">
                                    Delivery Charge:<fmt:formatNumber value="${orderTotals.deliveryCharge}" type="currency" />
                                </td>
                            </tr>
                        </c:if>
                        <tr>
                            <td colspan="6" align="right">Sub Total:<fmt:formatNumber value="${orderTotals.subTotal}" type="currency" /></td>
                        </tr>
                        <tr>
                            <td colspan="6" align="right">
                                Sales Tax: <fmt:formatNumber value="${orderTotals.salesTax}" type="currency" />
                            </td>
                        </tr>
                        <tr>
                            <td  colspan="6" align="right">
                                Total: <fmt:formatNumber value="${orderTotals.total}" type="currency" />
                            </td>
                        </tr>
                    </table>
                       </div>         
                </c:if>
               
            </div>  <!-- end content -->
            
            <div class="col-xs-3 col-md-3 sidebar2">
                <table >
                    <c:if test="${! empty uBean}">
                        <tr>
                            <td class="addressTextColor" align="center">Welcome ${uBean.fname}&nbsp;${uBean.lname}</td>
                        </tr>
                    </c:if>
                    <tr>
                        <td><h4 align="center">Order Times:</h4></td>
                    </tr>
                    <c:choose>
                        <c:when test="${orderTimes.on eq '1'}">
                            <tr>
                                <td colspan="7"><%@ include file="/WEB-INF/pages/orderTimes.jspf"%></td>

                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="7"><font color="#FF0000">Online ordering is not available at this time.</font></td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                </table>
                <p>
                <ul>
                    <li> <b>Delivery Charge:</b><br />
                        Additional $1.00 delivery charge. </li>
                    <li> <b>Minimum Delivery Amount:</b><br />
                        Minimum order amount for delivery is $10.</li>
                    <li> <b>Delivery Area:</b><br/>
                        We do not deliver beyond 7 miles.</li>
                </ul>
                </p>
                <p style="float:left"
                   ${message} <c:out value="${pageContext.request.contextPath}"/><br/>
                </p>
            </div>
            <!-- end .sidebar2 -->
            </div> <!-- END ROW -->

        </div> <!-- end container div -->

    </body>
</html>