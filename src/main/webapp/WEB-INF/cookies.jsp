<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookies</title>
</head>
<body>

	<%@include file="menu.jsp"%>
	<h1>Cookies</h1>

	<p> <c:out value=" Bonjour ${ prenom }"></c:out> </p>
	<form method="post" action="cookies">
		<p>
			<label class="label" for="nom">nom: </label> <input class="input"
				type="text" name="nom" id="nom" />
		</p>
		<p>
			<label class="label" for="prenom">Prenom: </label> <input
				class="input" type="text" name="prenom" id="prenom" />
		</p>


		<input class="input" type="submit">
	</form>

</body>
</html>