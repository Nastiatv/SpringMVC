<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<h4>Message-</h4>
<span>${message}</span>
<table class="table">
            <caption></caption>
                <tr >
                            
                    <c:forEach var="user" items="${listUsers}">  ${user.id}  </c:forEach>
                     <c:forEach var="user" items="${listUsers}">  ${user.name}  </c:forEach>
                      <c:forEach var="user" items="${listUsers}">  ${user.address}  </c:forEach>
                       <c:forEach var="user" items="${listUsers}">  ${user.email} </c:forEach>
             </tr>
            </table>
</body>
</html>
