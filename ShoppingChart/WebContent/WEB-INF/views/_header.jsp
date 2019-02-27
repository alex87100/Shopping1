<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<div class="header-container"> 
    <div class="site-name">Online Shop</div> 
    <div class="header-bar">
     	<c:if test="${user == null}">	   
	         <a href="${pageContext.request.contextPath}/login">Login</a> |
	         <a href="${pageContext.request.contextPath}/register">Register</a>
       </c:if>
	   <c:if test="${user != null}">
	 Hello ${user.username} | <a href="${pageContext.request.contextPath}/logout">Logout</a>
	   </c:if>	            
    </div>
</div>