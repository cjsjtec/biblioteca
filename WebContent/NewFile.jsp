<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	<form action="ItemServlet" method="POST">
		<label for="nome">Nome:</label>
		<input type="text" name="nome" id="nome">
		<br>
		<label><input type="radio" name="tipo" value="P">Professor</label>
		<label><input type="radio" name="tipo" value="A">Aluno</label><br>
		<label><input type="radio" name="status" value="A">Ativo</label>
		<label><input type="radio" name="status" value="S">Suspenso</label><br>
		<button type="submit">Enviar</button>		
	</form>

</body>
</html>