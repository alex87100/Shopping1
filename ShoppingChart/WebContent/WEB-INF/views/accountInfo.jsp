<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Account Info</title>
<link rel="stylesheet" type="text/css" href="resources/css/styles.css"> 
</head>
<body>
    <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" /> 
   <div class="page-title">Account Info</div> 
   <div class="account-container">
        <ul>
	        <li>Name: ${user.name}</li>
	        <li>Surname: ${user.surname}</li>
	        <li>E-mail: ${user.email}</li>
	        <li>Address: ${user.address}</li>
	        <li>Phone: ${user.phone}</li>
	        <li>UserName: ${user.username}</li>
       </ul>
   </div>
 	<!-- Edit Customer Info -->
  	<a class="navi-item"
      href="${pageContext.request.contextPath}/shoppingCartCustomer">Edit Customer Info</a>
   <jsp:include page="_footer.jsp" />
</body>
</html>