<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bonjour</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<h1>Bonjour ${ empty auteur.prenom ? '' : auteur.prenom}
		${auteur.nom}</h1>
	<p>${ auteur.actif ? 'Vous êtes actif' : 'Vous êtes inactif' }</p>

	<!-- JSTL -->
	<h1>JSTL</h1>
	<c:set var="pseudo" value="djoob20" scope="page" />
	<p>
		<c:out value="Bonjour ${ pseudo }" />
	</p>

	<%-- 
	<c:set target="${ auteur }" property="prenom" value="Sakho" />
	<p>
		<c:out value="Bonjour ${ auteur.prenom }" />
	</p>

	<h1>JSTL Conditions</h1>
	<p>
		<c:if test="${ 20 < 10 }" var="variable">
		</c:if>
		<c:if test="${ 20 > 10 }" var="autreVariable">
		</c:if>

		<c:choose>
			<c:when test="${variable}">Variable!</c:when>
			<c:when test="${autreVariable}">AutreVariable</c:when>
		</c:choose>
	</p>
	
	<h1>JSTL les boucles</h1>
	<c:forEach var="i" begin="0" end="10" step="2">
		<p>Un message n°<c:out value="${i}"></c:out></p>
	</c:forEach>
	<c:forEach items="${ titres }" var="titre" varStatus="status">
		<p>N°<c:out value="${status.count}"/>: <c:out value=" ${ titre } "></c:out></p>
	</c:forEach>
	
	<h1>JSTL boucle pour forTokens chaines characteres</h1>
	<c:forTokens items="un element/un autre element/un dernier element" delims="/ " var="item">
		<p> <c:out value="${item} "></c:out> </p>
	</c:forTokens>
	
--%>

	<h1>JSTL les formulaires</h1>
	<form method="post" action="bonjour">
		<p>
			<label for="login">Login: </label> 
			<input type="text" name="login" id="login" />
		</p>
		<p>
			<label for="pass">Password: </label> 
			<input type="password" name="pass" id="pass" />
		</p>

		<input type="submit">
	</form>
	<c:if test="${ !empty form.result }">
		<p>
			<c:out value="${ form.result }"></c:out>
		</p>
	</c:if>
</body>
</html>