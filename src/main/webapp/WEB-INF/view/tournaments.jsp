<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>List Users</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

    <div id="wraper">
        <div id="header">
            <h2>Torneos</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
        
            <!-- add our html table here -->
            <table>
                <tr>
                	<th>Nombre</th>
                    <th>Fecha de inicio</th>
                    <th>Organizador</th>
                    <th>Lugar</th>
                </tr>
                
                <!-- loop over and print our customer -->
                <c:forEach var="tempTournament" items="${Tournaments}">
                
                    <tr>
                        <td> ${tempTournament.name} </td>
                        <td> ${tempTournament.startDate} </td>
                        <td> ${tempTournament.idUser.name} </td>
                        <td> ${tempTournament.idField.name} </td>
                        
                    </tr>
                </c:forEach>
            
            </table>
            
        </div>
    </div>

</body>
</html>