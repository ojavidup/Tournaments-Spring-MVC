<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Landing Page - Start Bootstrap Theme</title>
	
	<!-- Reference Bootstrap files -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

	<div class="container">
		<a class="navbar-brand" href="#">FUTBOL TOTAL</a>
	  	<a class="btn btn-primary" href="${pageContext.request.contextPath}/user_home">Iniciar sesión</a>
	  	<a class="btn btn-primary" href="${pageContext.request.contextPath}/saveUser">Registrate</a>
	</div>

	<!-- Masthead -->
	<header>
		<div class="container">
			<div class="row">
				<div class="col-xl-9 mx-auto">
					<h1 class="mb-5">Crea y gestiona tu torneo de futbol
						aficionado!</h1>
				</div>
				<div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
					<form>
						<div class="form-row">
							<div class="col-12 col-md-9 mb-2 mb-md-0">
								<input type="email" class="form-control form-control-lg"
									placeholder="Ingresa tu email...">
							</div>
							<div class="col-12 col-md-3">
								<button type="submit" class="btn btn-block btn-lg btn-primary">Registrate!</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</header>

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
						<td>${tempTournament.name}</td>
						<td>${tempTournament.startDate}</td>
						<td>${tempTournament.idUser.name}</td>
						<td>${tempTournament.idField.name}</td>

					</tr>
				</c:forEach>

			</table>

		</div>
	</div>
	
</body>

</html>
