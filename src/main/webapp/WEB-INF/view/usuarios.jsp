<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Users</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

    <div id="wraper">
        <div id="header">
            <h2>Usuarios</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
        
            <!-- add our html table here -->
            <table>
                <tr>
                	<th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Enable</th>
                    <th>Torneos</th>
                    
                </tr>
                
                <!-- loop over and print our customer -->
                <c:forEach var="tempUser" items="${Users}">
                
                    <tr>
                        <td > ${tempUser.id} </td>
                        <td> ${tempUser.name} </td>
                        <td> ${tempUser.email} </td>
                        <td> ${tempUser.password} </td>
                        <td> ${tempUser.enable} </td>
                        <td> 
                        	<table>
                        		<c:forEach var="tempT" items="${tempUser.tournaments}">
                        			<tr>
                        				<td>${tempT.name}</td>
                        			</tr>
                        		</c:forEach>
                        	</table>
                        </td>
                    </tr>
                </c:forEach>
            
            </table>
            
        </div>
    </div>

</body>
</html>