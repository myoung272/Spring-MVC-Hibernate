
<!DOCTYPE html> 
<html lang="en">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
        <!--  <link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.1.0/css/dataTables.responsive.css"> -->

        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css"> 
        <!--    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"> -->
        <link href="<c:url value="/resources/css/superMariof2os.css" />" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/responsive.dataTables.css" />" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/responsive.bootstrap.css" />" rel="stylesheet"/> 

        <script src=" https://code.jquery.com/jquery-1.12.3.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.js"></script>
        <title>addMenuItem.jsp</title>
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
                /*   border-radius:0; */
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
                /*     table-layout: fixed; */
            }



            .itemTD {
                text-align: center;
            }

            .divTD{
                text-align: center; 
            }

            tfoot input {
                width: 100%;
                padding: 3px;
                box-sizing: border-box;


                .rowA{
                    bgcolor: #d8e5f3;
                }

                .rowB{
                    bgcolor:  #c4d8ed;
                }

            }
            .errorblock {
                color: #000;
                background-color: #ffEEEE;
                border: 3px solid #ff0000;
                padding: 8px;
                margin: 16px;
            }

        </style>
        <script>
            $(document).ready(function () {
                // Setup - add a text input to each footer cell
                $('#tbMenuItems tfoot th').each(function () {
                    var title = $(this).text();
                    $(this).html('<input type="text" placeholder="Search ' + title + '" />');
                });

                // DataTable
                var table = $('#tbMenuItems').DataTable();

                // Apply the search
                table.columns().every(function () {
                    var that = this;

                    $('input', this.footer()).on('keyup change', function () {
                        if (that.search() !== this.value) {
                            that
                                    .search(this.value)
                                    .draw();
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <c:choose>
            <c:when test="${empty uBean or !uBean.getRole().getRole().equalsIgnoreCase('admin') }">
                <h2 align="center">Super Mario Spring MVC Hibernate 4.0</h2>
                <h3 align=" center"><font style="color: red" >You must be logged in as an admin to view this page.</font>  <a href="${pageContext.request.contextPath}/user.html?login=login">Login</a> </h3>

            </c:when>
            <c:otherwise>
                <div class="container-fluid">
                    <!--    <div class="row"> -->
                    <%@ include file="/WEB-INF/pages/bootstrapHeader.jspf" %>
                    <!--    </div> -->
                    <p><h3 style="color: red; text-align: center">${message}</h3></p>

                <c:if test="${!empty fileBucket }">
                    <div class="row  catItems ">
                        <form:form method="POST" action="${pageContext.request.contextPath}/addMenuItem/uploadEx.html" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">
                            <table class="center">
                                <tr>
                                    <td style=" text-align: left;">
                                        <label class=" control-lableX" for="file">Upload menu from Excel sheet</label><br>
                                        <form:input type="file" path="file" id="file" class="form-control input-smx btn btn-primary btn-sm"/><br>
                                        <input type="submit" value="Upload" class="btn btn-primary btn-sm">
                                    </td>
                                </tr>
                            </table>
                        </form:form>
                    </c:if>
                </div>

                <br />
                <c:if test="${!empty addItem}">
                    <div class="row table-responsive catItems ">
                        <form:form method="POST" commandName="addItem"  action="${pageContext.request.contextPath}/addMenuItem.html" >
                            <table class="center">
                                <thead>
                                    <tr>
                                        <td>Category</td>
                                        <td></td>
                                        <td>Item</td>
                                        <td></td>
                                        <td>Description</td>
                                        <td></td>
                                        <td>Size</td>
                                        <td></td>
                                        <td>Price</td>
                                        <td></td>
                                        <td>Add</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><form:input path="category" required="required"  /></td>
                                        <td><form:errors path="category" cssStyle="color : red;"/></td>
                                        <td><form:input path="item" required="required"  /></td>
                                        <td><form:errors path="item" cssStyle="color : red;"/></td>
                                        <td><form:input path="description"  required="required" /></td>
                                        <td><form:errors path="description" cssStyle="color : red;"/></td>
                                        <td><form:input path="size" required="required"  /></td>
                                        <td><form:errors path="size" cssStyle="color : red;"/></td>
                                        <td><form:input path="price" required="required"   /></td>
                                        <td><form:errors path="price" cssStyle="color : red;"/></td>
                                        <td ><input type="submit" value="Add" size="3" class="btn btn-primary btn-sm" /></td>
                                    </tr>
                                </tbody>
                            </table>
                        </form:form>

                    </div>
                </c:if>
                <%-- class="row table-responsive catItems container cell-border stripe" --%>
                <c:if test="${!empty fieldErrors}">
                    <div class="errorblock" align="center">
                        <table >
                            <tr><td>There are error(s) with your edit</td></tr>
                            <c:forEach var="fe" items="${fieldErrors}" varStatus="line">
                                <tr><td> ${fe.defaultMessage}.</td></tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:if> 
                <c:if test="${!empty editMenu}">

                    <div class="table-responsive" >
                        <!--   <div class="col-sm-12"> -->

                        <!--   table table-striped table-bordered  stripe display compact -->
                        <!--  class="table catItems  stripe display compact"  -->
                        <table id="tbMenuItems" class="table catItems  stripe display compact"  cellspacing="0" width="100%" >
                            <thead>
                                <tr bgcolor ="#ecf2f9" >

                                    <th>Prod ID</th>
                                    <th>Category</th>
                                    <th>Item</th>
                                    <th>Description</th>
                                    <th></th>
                                    <th>Size</th>
                                    <th>Price</th>
                                    <th>Edit</th>
                                    <th>Remove Item</th>
                                </tr> 
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Prod ID</th>
                                    <th>Category</th>
                                    <th>Item</th>
                                    <th>Description</th>
                                    <th></th>
                                    <th>Size</th>
                                    <th>Price</th>
                                    <th>Edit</th>
                                    <th>Remove Item</th>
                                </tr>
                            </tfoot>
                            <tbody>

                                <c:forEach var="cm" items="${editMenu}" varStatus="line">
                                    <tr>
                                        <form:form method="post" command="editMenu" action="${pageContext.request.contextPath}/addMenuItem/edit.html" >
                                            <form:errors path="*" cssClass="errorblock" element="div" />
                                            <td data-search="${cm.productId}" data-order="${cm.productId}">
                                                ${cm.productId}
                                            </td>
                                            <td data-search="${cm.category}" data-order="${cm.category}">
                                                <input type="text" name="category" value="${cm.category}"  />
                                            </td>
                                            <td data-search="${cm.item}" data-order="${cm.item}">
                                                <input type="text"  name="item" value="${cm.item}" />
                                            </td>
                                            <td data-search="${cm.description}" data-order="${cm.description}">
                                                <input type="text"  name="description"  value="${cm.description}"/> </td>
                                            <td><form:errors path="description" cssStyle="color : red;"/></td>
                                            <td data-search="${cm.size}" data-order="${cm.size}">
                                                <input type="text"  name="size"  value="${cm.size}" />
                                            </td>
                                            <td data-search="${cm.price}" data-order="${cm.price}">
                                                <input type="text"   name="price" value='<fmt:formatNumber maxFractionDigits="2"
                                                                  minFractionDigits="2" value="${cm.price}" type="NUMBER"/>' />
                                            </td>
                                            <td>

                                                <input type="submit" value="Edit" class="btn btn-primary btn-sm" />
                                                <input type="hidden" name="productId" value="${cm.productId}" />
                                                <input type="hidden" name="categoryX" value="${cm.category}" />
                                                <input type="hidden"  name="itemX" value="${cm.item}" />
                                                <input type="hidden"  name="descriptionX"  value="${cm.description}"/> 
                                                <input type="hidden" name="sizeX"  value="${cm.size}" />
                                                <input type="hidden"  name="priceX"  value="${cm.price}" />
                                                <input type="hidden" name="edit" value="true" />
                                            </form:form>
                                        </td>
                                        <td>
                                            <form method="post" action="${pageContext.request.contextPath}/addMenuItem/remove.html" >
                                                <input type="submit" value="Remove" class="btn btn-primary btn-sm" />
                                                <input type="hidden" name="productId" value="${cm.productId}" />
                                                <input type="hidden" name="remove" value="true" />
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <!--    </div>  -->
                    </div>
                </c:if>
                <c:if test="${!empty  custs}"> 

                    <div class="catItems container table-responsive">


                        <table id="tbMenuItems" class="table catItems stripe display compact" cellspacing="0"  >
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
                                    <tr> 
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
                </c:if>

                <div>
                    <p style="float:right"
                       ${message} <c:out value="${pageContext.request.contextPath}"/><br/>
                    </p>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</body>
</html>
