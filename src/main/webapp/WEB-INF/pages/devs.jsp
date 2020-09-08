<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<h4>Message-</h4>
<span>${message}</span>
<table class="table">
            <caption></caption>
               <tr >
<c:forEach var="dev" items="${listDevs}">  ${dev.id}  </c:forEach>
<c:forEach var="dev" items="${listDevs}">  ${dev.lastName}  </c:forEach>
<c:forEach var="dev" items="${listDevs}">  ${dev.firstName}  </c:forEach>

</tr>
            </table>
</body>
</html>
