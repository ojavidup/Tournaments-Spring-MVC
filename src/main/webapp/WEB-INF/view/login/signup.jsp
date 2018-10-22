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
 
  <title>Registrate</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.0.0/css/font-awesome.min.css">
</head>

<body>
 <div class="container">
 
     <form:form class="form-horizontal" role="form" method="POST" action="saveUser" id = "saveF" modelAttribute="user">
     
     	<!-- need to associate this data whit user id -->
<%--      	<form:hidden path="id" /> --%>
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
                 <h2>Registrar nuevo usuario</h2>
                 <hr>
             </div>
         </div>
	     <div class="form-group">
	        <div class="col-xs-15">
	            <div>
				
					<!-- Check for registration error -->
					<c:if test="${registrationError != null}">
				
						<div class="alert alert-danger col-xs-offset-1 col-xs-10">
							${registrationError}
						</div>
	
					</c:if>
															
	            </div>
	        </div>
	    </div>
         <div class="row">
             <div class="col-md-3 field-label-responsive">
                 <label for="name">Name</label>
             </div>
             <div class="col-md-6">
                 <div class="form-group">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                         <input type="text" name="name" class="form-control" id="name" placeholder="Name" required autofocus/>
                     </div>
                 </div>
             </div>
         </div>
         <div class="row">
             <div class="col-md-3 field-label-responsive">
                 <label for="email">Email</label>
             </div>
             <div class="col-md-6">
                 <div class="form-group">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fas fa-at"></i></div>
                         <input type="text" name="email" class="form-control" id="email" placeholder="email@email.com" required>
                     </div>
                 </div>
             </div>
         </div>
         <div class="row">
             <div class="col-md-3 field-label-responsive">
                 <label for="authority">Authority</label>
             </div>
             <div class="col-md-6">
                 <div class="form-group">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fas fa-universal-access"></i></div>
                         	<select name="authority" class="form-control" form="saveF">
                         	  <c:forEach var="tempAuthority" items="${Authorities}">
                         	    <option value="${tempAuthority.authority}">${tempAuthority.authority}</option>
                         	  </c:forEach>
							</select>

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
             <div class="col-md-3 field-label-responsive">
                 <label for="password">Password</label>
             </div>
             <div class="col-md-6">
                 <div class="form-group has-danger">
                     <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                         <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-key"></i></div>
                         <input type="password" name="password" class="form-control" id="password" placeholder="Password" required>
                     </div>
                 </div>
             </div>
             <div class="col-md-3">
                 <div class="form-control-feedback">
<%--                          <span class="text-danger align-middle" th:if="${#fields.hasErrors('password')}" th:errors="*{password}"> --%>
<!--                          </span> -->
                 </div>
             </div>
         </div>
         <div class="row">
             <div class="col-md-3"></div>
             <div class="col-md-6">
                 <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i> Register</button>
             </div>
         </div>
     </form:form>
 </div>
</body>
</html>