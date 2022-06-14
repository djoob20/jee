<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>db</title>
</head>
<body>
	
	<%@ include file="menu.jsp"%>
	<!-- JSTL Session -->
	<h1>JSTL Database</h1>
		
	<form method="post" action="DB_Servlet">
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
	
	<ul>
		<c:forEach var="user" items="${ users }">
			<li><c:out value="${ user.firstname }" /> <c:out value="${ user.lastname }" /></li>
		</c:forEach>
	</ul>
</body>
</html>