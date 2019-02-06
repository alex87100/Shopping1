<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Chart</title> 
<link rel="stylesheet" type="text/css" href="resources/styles.css"> 
 
</head>
<body>
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   <div class="page-title">My Chart</div>

    <c:if test="${itemCode == null}">
       <h2>There is no items in Chart</h2> 
   </c:if>
   <c:if test="${itemCode != null}"> 
    <div class="product-preview-container">
       <ul>
    	   <li><img src="resources/${itemName}.png" height="65" width="65" alt="${itemName}"></li>
           <li>Code: ${itemCode}</li>
           <li>Name: ${itemName}</li>
           <li>Item price: <fmt:formatNumber value="${itemPrice}" type="currency"/></li>           
           <li><a href="${pageContext.request.contextPath}/shoppingCartRemoveProduct?code=${itemCode}">
            Delete </a></li>
            
       </ul>
     </div>  
       
   </c:if>
   <div style="clear: both"></div>
   <!-- input class="button-update-sc" type="submit" value="Update Quantity" /-->
   <a class="navi-item" href="${pageContext.request.contextPath}/productList">
   Continue Buy</a>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>