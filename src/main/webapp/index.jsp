<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session</title>
</head>
<body>
	
	<!-- JSTL Session -->
	<h1>JSTL Session</h1>
	<p> Vous êtes sur index.jsp</p>
		<div>
		<c:if test="${ !empty sessionScope.prenom  && !empty sessionScope.nom}">
			<p>Vous êtes ${ sessionScope.prenom } ${ sessionScope.nom }</p>
		</c:if>
		
		
	</div>

</body>
</html>