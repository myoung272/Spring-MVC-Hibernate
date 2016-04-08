
  <div class="header">
    <div class="logo"> <img src="images/super mario logo-1.jpg" /> </div>
    <div class="headerText">
      <P>Forget the Planet,<br />
        Best Pizza in the Solar System!</P>
    </div>
    <div class="peppers"> <img src="images/redgreenpeppersCrooped.jpg" /> </div>
    <div class="headerAddress">
      <p> 101 Centirian Star Way, <br />
        &nbsp; 3rd Rock Orb <br />
        &nbsp;&nbsp; Alpha Centuri<br />
        &nbsp;&nbsp; &nbsp;p. 123.123.1234<br />
        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;f. 321.321.3214 </p>
    </div>
    <div class="navLinks">
      <c:choose>
        <c:when test="${empty uBean}">
          <p align="right"> <a href="showCatItems.jsp?login=login">Login</a> | <a href="showCatItems.jsp?reg=reg">Register</a> </p>
        </c:when>
        <c:otherwise>
          <p>
            <%@ include file="header.jsp"%>
            <%--<a href='Login.do?email=logOut'>Log Out</a>--%>
          </p>
        </c:otherwise>
      </c:choose>
    </div>
  </div>