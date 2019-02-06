<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title> 
<link rel="stylesheet" type="text/css" href="resources/styles.css"> 
 
</head>
<body>
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
  
   <fmt:setLocale value="en_US" scope="session"/>

      
  <div class="page-title">Product List</div>
  <c:forEach items="${products}" var="product">
       <div class="product-preview-container">
           <ul>
        	   <li><img src="resources/${product.name}.png" height="65" width="65" alt="${product.name}"></li>
        	   <!--li><img src="resources/AceQ.png" height="65" width="65" alt="${product.name}"></li!-->   
               <li>Code: ${product.code}</li>
               <li>Name: ${product.name}</li>
               <li>Price: <fmt:formatNumber value="${product.price}" type="currency"/></li>
               <li><a href="${pageContext.request.contextPath}/buyProduct?productCode=${product.code}&productName=${product.name}&productPrice=${product.price}">Buy Now</a></li>
               <!-- li><a
                   href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}">
                       Buy Now</a></li-->    
           </ul>
       </div>
 
   </c:forEach>
   
   
   <jsp:include page="_footer.jsp" />
 
</body>
</html>