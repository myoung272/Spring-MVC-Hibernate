<!DOCTYPE html>
<html lang="en">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <head>
        <title>admin.jsp</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <!--       <link href="<c:url value="/resources/css/fos.css" />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/superMariof2os.css" />" rel="stylesheet"/>
  -->
        
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

    
        
    </head>
    <body>
           <c:choose>
       <c:when test="${empty uBean or !uBean.getRole().getRole().equalsIgnoreCase('admin') }">
            <h2 align="center">Super Mario Spring MVC Hibernate 4.0</h2>
            <h3 align=" center"><font style="color: red" >You must be logged in as an admin to view this page.</font>  <a href="${pageContext.request.contextPath}/user.html?login=login">Login</a> </h3>
           
       </c:when>
           <c:otherwise>
        <%@ include file="/WEB-INF/pages/bootstrapHeader.jspf" %>
        
        <div class="container text-center">   
        <form:form method="post"  action="${pageContext.request.contextPath}/updateOrderTimes/${orderTimes.id}.html"  modelAttribute="orderTimes">
            <h2> Super Mario Ordering Times: </h2>
            <c:if test="${orderTimes.on == 0}">
                <h4><font color="red"> Online Ordering Is Off</font></h4>
            </c:if>
             <c:if test="${orderTimes.smsOn eq 'false'}">
                <h4><font color="red">SMS Notifications are Off</font></h4>
            </c:if> 
                 <c:if test="${orderTimes.faxOn eq 'false'}">
                <h4><font color="red">Fax Notifications are Off</font></h4>
            </c:if>
            <hr>
            <h3>Enter Start Ordering Times: </h3>
            <br>
           
                <div class="row">
                    <div class="col-sm-1">
                        Monday<br>
                        <%--  <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.mo}"  /><br> --%>
                        <form:select  path="mo" name="sDays" id="mo"> 
                             <form:options items="${startTimes}" />
                        </form:select>
                    </div>
                    <div class="col-sm-1"> 
                        Tuesday<br>
              <%--          <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.tu}"  /><br> --%>
                        <form:select  path="tu" name="sDays" id="tu"> 
                              <form:options items="${startTimes}" />
                        </form:select>
                    </div>
                    <div class="col-sm-1"> 
                        Wednesday <br>
                <%--        <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.we}"  /><br>  --%>
                        <form:select  path="we" name="sDays" id="we"> 
                             <form:options items="${startTimes}" />
                        </form:select>
                    </div>
                    <div class="col-sm-1"> 
                        Thursday<br>
              <%--          <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.tr}"  /><br> --%>
                        <form:select  path="tr" name="sDays" id="tr"> 
                              <form:options items="${startTimes}" />
                        </form:select>
                    </div> 
                    <div class="col-sm-1"> 
                        Friday<br>
               <%--         <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.fr}"  /><br>  --%>
                        <form:select  path="fr" name="sDays" id="fr"> 
                              <form:options items="${startTimes}" />
                        </form:select>
                    </div>     
                    <div class="col-sm-1"> 
                        Saturday<br>
              <%--          <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.sa}"  /><br> --%>
                        <form:select  path="sa" name="sDays" id="sa"> 
                               <form:options items="${startTimes}" />
                        </form:select>
                    </div> 
                    <div class="col-sm-1"> 
                        Sunday<br>
                <%--        <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.su}"  /><br>  --%>
                        <form:select  path="su" name="sDays" id="su"> 
                               <form:options items="${startTimes}" />
                        </form:select>
                    </div>
                      
                         <div class="col-sm-2">
                        <input type="submit" value="Submit" size="6" />
                    </div>
         
            </div>
            <div class="row">
                 <hr>
                  <h3>Enter Stop Ordering Times: </h3>
                  <div class="col-sm-1">
                        Monday<br>
          <%--              <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.fmo}"  /><br> --%>
                        <form:select  path="fmo" name="sDays" id="fmo"> 
                             <form:options items="${stopTimes}" />
                        </form:select>
                    </div>
                    <div class="col-sm-1"> 
                        Tuesday<br>
           <%--             <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.ftu}"  /><br> --%>
                        <form:select  path="ftu" name="sDays" id="ftu"> 
                              <form:options items="${stopTimes}" />
                        </form:select>
                    </div>
                    <div class="col-sm-1"> 
                        Wednesday <br>
           <%--             <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.fwe}"  /><br> --%>
                        <form:select  path="fwe" name="sDays" id="fwe"> 
                             <form:options items="${stopTimes}" />
                        </form:select>
                    </div>
                    <div class="col-sm-1"> 
                        Thursday<br>
                 <%--       <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.ftr}"  /><br> --%>
                        <form:select  path="ftr" name="sDays" id="ftr"> 
                              <form:options items="${stopTimes}" />
                        </form:select>
                    </div> 
                    <div class="col-sm-1"> 
                        Friday<br>
              <%--         <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.ffr}"  /><br> --%>
                        <form:select  path="ffr" name="sDays" id="ffr"> 
                              <form:options items="${stopTimes}" />
                        </form:select>
                    </div>     
                    <div class="col-sm-1"> 
                        Saturday<br>
             <%--           <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.fsa}"  /><br> --%>
                        <form:select  path="fsa" name="sDays" id="fsa"> 
                               <form:options items="${stopTimes}" />
                        </form:select>
                    </div> 
                    <div class="col-sm-1"> 
                        Sunday<br>
                 <%--       <fmt:formatDate type="time" timeStyle="short" value="${orderTimes.fsu}"  /><br> --%>
                        <form:select  path="fsu" name="sDays" id="fsu"> 
                               <form:options items="${stopTimes}" />
                        </form:select>
                    </div>
                         <div class="col-sm-2">
                        <input type="submit" value="Submit" size="6" />
                    </div>
                         </div>
           
                        <div class="row">
                              <hr>
            <h3>Turn Ordering/Notifications On/Off </h3>
            <div class="col-sm-1">
                Online Ordering<br>
                <form:select  path="on" name="sDays" id="on"> 
                
                   <form:option value="1" label="On"/>
                   <form:option value="0" label="Off"/>
                </form:select><br>
            </div>  
            <div class="col-sm-1">
                SMS Notifications<br>
                <form:select  path="smsOn" name="sDays" id="smsOn"> 
              
                   <form:option value="true" label="On"/>
                   <form:option value="false" label="Off"/>
                </form:select><br>
            </div> 
              <div class="col-sm-1">
                Fax Notifications<br>
                <form:select  path="faxOn" name="sDays" id="faxOn"> 
                  
                   <form:option value="true" label="On"/>
                   <form:option value="false" label="Off"/>
                </form:select><br>
            </div>
                    <div class="col-sm-2">
                        <input type="submit" value="Submit" size="6" />
                    </div>
                        </div>
                    </form:form> 
           
        
        </div>

   </c:otherwise>
        </c:choose>
    </body>
</html>
