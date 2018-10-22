<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>

	<div class="container">
		<a class="navbar-brand" href="#">FUTBOL TOTAL</a> User:
		<security:authentication property="principal.username" />
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/logout">Logout</a>

	</div>

	<!-- Masthead -->
	<header>
		<div class="container">
			<div class="row">
				<div class="col-xl-9 mx-auto">
					<h1 class="mb-5">Tus torneos</h1>
				</div>
				<div class="col-md-12 col-lg-11 col-xl-10 mx-auto">
					<div class="form-row">
						<div class="col-12 col-md-9 mb-2 mb-md-0">
							<div id="content">

								<!-- add our html table here -->
								
								<table class="table table-dark">
									<tr>
										<th scope="col">Nombre</th>
										<th scope="col">No. de equipos</th>
										<th scope="col">No. de jugadores</th>
										<th scope="col">No. jugadores en campo</th>
										<th scope="col">Valor de inscripcion</th>
										<th scope="col">Fecha de inicio</th>
										<th scope="col">Lugar</th>
										<th scope="col">Opciones</th>
									</tr>

									<!-- loop over and print our customer -->
									<c:forEach var="tempUserTournament" items="${userTournaments}">
									
										<!-- construct an "update" link with customer id -->
					                    <c:url var="updateLink" value="/user_home/updateTournament">
					                        <c:param name="tournamentId" value="${tempUserTournament.id}"/>
					                    </c:url>
					                    
					                    <!-- construct an "delete" link with customer id -->
					                    <c:url var="deleteLink" value="/user_home/deleteTournament">
					                        <c:param name="tournamentId" value="${tempUserTournament.id}"/>
					                    </c:url>

										<tr>
											<td>${tempUserTournament.name}</td>
											<td>${tempUserTournament.teamsNumber}</td>
											<td>${tempUserTournament.playersNumber}</td>
											<td>${tempUserTournament.playersInGame}</td>
											<td>${tempUserTournament.inscriptionCost}</td>
											<td>${tempUserTournament.startDate}</td>
											<td>${tempUserTournament.idField.name}</td>
											<td>
					                            <a href="${updateLink}">Actualizar</a>
					                            |
					                            <a href="${deleteLink}"
					                               onclick="if (!(confirm('Are you sure you want to delete this tournament?'))) return false">Eliminar</a>
					                        </td>

										</tr>
										
									</c:forEach>

								</table>

							</div>
						</div>
						<div class="col-12 col-md-3">
						  <c:url var="newTournament" value="/user_home/saveTournament">
		                   </c:url>
							<a class="btn btn-primary"
								href="${newTournament}">Crear torneo</a>
						</div>
					</div>
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
