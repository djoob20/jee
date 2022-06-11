<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session</title>
</head>
<body>
	
	<%@ include file="menu.jsp"%>
	<!-- JSTL Session -->
	<h1>JSTL Session</h1>
		<div>
		<c:if test="${ !empty sessionScope.prenom  && !empty sessionScope.nom}">
			<p>Vous êtes ${ sessionScope.prenom } ${ sessionScope.nom }</p>
		</c:if>
			<form method="post" action="session">
				<p>
					<label class="label" for="nom">nom: </label> <input
						class="input" type="text" name="nom" id="nom" />
				</p>
				<p>
					<label class="label" for="prenom">Prenom: </label> <input
						class="input" type="text" name="prenom" id="prenom" />
				</p>
	
				
				<input class="input" type="submit">
			</form>
		
	</div>

</body>
</html>