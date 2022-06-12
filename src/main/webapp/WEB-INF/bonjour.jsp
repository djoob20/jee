<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bonjour</title>
<style><%@include file="/WEB-INF/css/styles.css"%></style>
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
	<div>
		<form method="post" action="bonjour" enctype="multipart/form-data">
			<p>
				<label class="label" for="login">Login: </label> <input
					class="input" type="text" name="login" id="login" />
			</p>
			<p>
				<label class="label" for="pass">Password: </label> <input
					class="input" type="password" name="pass" id="pass" />
			</p>

			<p>
				<label class="label" for="desc">Description du fichier: </label> 
				<input class="input" type="text" name="desc" id="desc" />
			</p>
			<p>
				<label class="label" for="file">Fichier à envoyer: </label> 
				<input class="input" type="file" name="file" id="file" />
			</p>
			<input class="input" type="submit">
		</form>
		<c:if test="${ !empty form.result }">
			<p>
				<c:out value="${ form.result }"></c:out>
			</p>
		</c:if>
		
		 <c:if test="${ !empty file }">
		 	<p><c:out value="Le fichier ${ file } (${ desc }) a été uploadé !" /></p>
		 </c:if>
	</div>

</body>
</html>