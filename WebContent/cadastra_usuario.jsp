<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar usuário</title>
</head>
<body>
<form action="Controler" method="post">
	<input type="hidden" name="action" value="CadastrarUsuario">
	nome:<input type="text" name="nome"><br>
	username:<input type="text" name="username"><br>
	senha:<input type="text" name="senha"><br>
	tipo:<input type="text" name="tipo"><br>
	<button type="submit">Cadastrar</button>
</form>

</body>
</html>