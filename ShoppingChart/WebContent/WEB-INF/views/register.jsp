<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Register</title>
<link rel="stylesheet" type="text/css" href="resources/css/styles.css"> 
</head>
<body>
    <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" /> 
   <div class="page-title">Enter Registration Information</div>
	<form method="POST" action="registrationAttempt">
           <table>
               <tr>
               <td>Name</td>
                   <td><input name="name" /></td>
               </tr> 
               <tr>
                   <td>Surname</td>
                   <td><input name="surname" /></td>
               </tr>
               <tr>
                   <td>E-Mail</td>
                   <td><input type="email" name="email" /></td>
               </tr>
               <tr>
                   <td>Address</td>
                   <td><input name="address" /></td>
               </tr>
               <tr>
                   <td>Phone</td>
                   <td><input name="phone" /></td>
               </tr> 
               <tr>
               <tr>
                   <td>Username</td>
                   <td><input name="username" /></td>
               </tr>
                <tr>
                   <td>Password</td>
                   <td><input name="password" /></td>
               </tr>
                   <td>&nbsp;</td>
                   <td><input type="submit" value="Submit" /> 
               </tr>
           </table>
       </form> 
        <jsp:include page="_footer.jsp" />
</body>
</html>