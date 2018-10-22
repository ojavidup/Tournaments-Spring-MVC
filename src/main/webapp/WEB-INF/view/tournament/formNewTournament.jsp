<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <meta name="description" content="">
 <meta name="author" content="">
 
  <title>Crea un nuevo torneo</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.min.css">
</head>

<body>
 <div class="container">
 
     <form:form class="form-horizontal" role="form" method="POST" action="saveTournament" id = "saveT" modelAttribute="tournament">
     
     	<!-- need to associate this data whit user id -->
     	<form:hidden path="id" />
     	<div class="row">
        	<div class="col-md-3"></div>
            <div class="col-md-6">
            	<c:if test="${msg != null}">
            		<div class="alert alert-success">${msg}</div>
            	</c:if>
           	</div>
        </div>
        
         <div class="row">
             <div class="col-md-3"></div>
             <div class="col-md-6">
                 <h2>Crear nuevo torneo</h2>
                 <hr>
             </div>
         </div>
         <div>
           <input type="hidden" value=<security:authentication property="principal.username"/> name="userEmail">   
         </div>
         <div class="row">
             <div class="col-md-3 field-label-responsive">
                 <label for="name">Nombre del torneo</label>
             </div>
             <div class="col-md-6">
                 <div class="form-group">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                         <form:input path="name" type="text"  name="name" class="form-control" placeholder="Nombre" />
                     </div>
                 </div>
             </div>
         </div>
         <div class="row">
             <div class="col-md-3 field-label-responsive">
                 <label for="email">Numero de equipos</label>
             </div>
             <div class="col-md-6">
                 <div class="form-group">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fas fa-at"></i></div>
                         <form:input path="teamsNumber" type="number" name="teamsNumber" class="form-control" id="teamsNumber"/>
                     </div>
                 </div>
             </div>
         </div>
         <div class="row">
             <div class="col-md-3 field-label-responsive">
                 <label for="email">Numero de jugadores</label>
             </div>
             <div class="col-md-6">
                 <div class="form-group">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fas fa-at"></i></div>
                         <form:input path="playersNumber" type="number" name="playersNumber" class="form-control" id="playersNumber"/>
                     </div>
                 </div>
             </div>
         </div>
         <div class="row">
             <div class="col-md-3 field-label-responsive">
                 <label for="email">Jugadores en campo</label>
             </div>
             <div class="col-md-6">
                 <div class="form-group">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fas fa-at"></i></div>
                         <form:input path="playersInGame" type="number" name="playersInGame" class="form-control" id="playersInGame"/>
                     </div>
                 </div>
             </div>
         </div>
         <div class="row">
             <div class="col-md-3 field-label-responsive">
                 <label for="email">Valor de inscripcion</label>
             </div>
             <div class="col-md-6">
                 <div class="form-group">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fas fa-at"></i></div>
                         <form:input path="inscriptionCost" type="number" name="inscriptionCost" class="form-control" id="inscriptionCost"/>
                     </div>
                 </div>
             </div>
         </div>
         <div class="row">
             <div class="col-md-3 field-label-responsive">
                 <label for="email">Fecha de inicio</label>
             </div>
             <div class="col-md-6">
                 <div class="form-group">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fas fa-at"></i></div>
                         <form:input path="startDate" type="date" name="startDate" class="form-control" id="startDate"/>
                     </div>
                 </div>
             </div>
         </div>
         <div class="row">
             <div class="col-md-3 field-label-responsive">
                 <label for="authority">Lugar</label>
             </div>

             <div class="col-md-6">
                 <div class="form-group">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fas fa-universal-access"></i></div>
                         	<form:select path="idField.name" name="idField.name" class="form-control" form="saveT">
                         	  <c:forEach var="tempField" items="${Fields}">
                         	    <form:option value="${tempField.name}">${tempField.name}</form:option>
                         	  </c:forEach>
							</form:select>
                     </div>
                 </div>
             </div>
             <div class="col-md-3">
                 <div class="form-control-feedback">
<%--                          <span class="text-danger align-middle" th:if="${#fields.hasErrors('email')}" th:errors="*{email}"> --%>
<!--                          </span> -->
                 </div>
             </div>
         </div>
         <div class="row">
             <div class="col-md-3"></div>
             <div class="col-md-6">
                 <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i>Guardar torneo</button>
             </div>
         </div>
     </form:form>
 </div>
</body>
</html>