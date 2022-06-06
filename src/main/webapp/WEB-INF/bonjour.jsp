<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bonjour</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<h1>
		Bonjour ${ empty auteur.prenom ? '' : auteur.prenom} ${auteur.nom}
		
	</h1>
	<p>
		${ auteur.actif ? 'Vous êtes actif' : 'Vous êtes inactif' }
	</p>
	
	<!-- JSTL -->
	<h1>JSTL</h1>
	<c:set var="pseudo" value="djoob20" scope="page"/>
	<p><c:out value="Bonjour ${ pseudo }"/></p>
	
	<c:set target="${ auteur }" property="prenom" value="Sakho"/>
	<p><c:out value="Bonjour ${ auteur.prenom }"/></p>
</body>
</html>