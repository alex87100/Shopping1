<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Login</title> 
<link rel="stylesheet" type="text/css" href="resources/styles.css"> 
</head>
<body>
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" /> 
 
   <div class="page-title">Login</div> 
   <div class="login-container"> 
       <h3>Enter username and password</h3>
       <br>
       <form method="POST" action="loginAttempt">
           <table>
               <tr>
                   <td>User Name *</td>
                   <td><input name="userName" /></td>
               </tr> 
               <tr>
                   <td>Password *</td>
                   <td><input type="password" name="password" /></td>
               </tr>
 
               <tr>
                   <td>&nbsp;</td>
                   <td><input type="submit" value="Login" /> 
                 	   <input type="reset"  value="Reset" /></td>
               </tr>
           </table>
       </form> 
       <span class="error-message">${error}</span>
        <span class="error-message">${logged}</span>
       
   </div>     
   <jsp:include page="_footer.jsp" />
</body>
</html>