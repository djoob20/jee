
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
	
	<p> <c:out value="Bonjour"/> </p>
</body>
</html>