<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Chart</title> 
<link rel="stylesheet" type="text/css" href="resources/css/styles.css"> 
 
</head>
<body>
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   <div class="page-title">My Chart</div>
   
   

    <c:if test="${basket == null}">
       <h2>There is no items in Chart</h2> 
   </c:if>
   <c:if test="${basket != null}"> 
	   <c:forEach items="${basket}" var="product">
	       <div class="product-preview-container">
	           <ul> 
	        	   <li><img src="resources/images/${product.name}.jpg" height="65" width="65" alt="${product.name}"></li>   
	               <li>Code: ${product.code}</li>
	               <li>Name: ${product.name}</li>
	               <li>Price: <fmt:formatNumber value="${product.price}" type="currency"/></li>
	               <li><a href="${pageContext.request.contextPath}/shoppingCartRemoveProduct?code=${product.code}"> Delete </a></li>
	               <!-- li><a
	                   href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}">
	                       Buy Now</a></li-->    
	           </ul>
	       </div>
	 
	   </c:forEach>
   
       
   </c:if>
   <div style="clear: both"></div>
   <!-- input class="button-update-sc" type="submit" value="Update Quantity" /-->
   <a class="navi-item" href="${pageContext.request.contextPath}/productList">
   Continue Buy</a>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>