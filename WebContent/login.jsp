<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biblioteca</title>


<link rel="stylesheet" href="css/reset.css">

<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<link rel="stylesheet" href="css/style.css">

</head>

<body>
	<%@ page import="java.sql.*"%>
	<%@ page import="javax.sql.*"%>
	<%
		String action = request.getParameter("action");
		System.out.println("action = " + action);
		if(new String("logar").equals(action))
		{
			System.out.println("logando");
			String userid = request.getParameter("usr");
			session.putValue("userid", userid);
			String pwd = request.getParameter("pwd");
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "762666");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from user where user='" + userid + "'");
			if (rs.next()) {
				if (rs.getString(2).equals(pwd)) {			
				   session.setAttribute("usuario", userid);		
				   response.sendRedirect("index.jsp");	
				} 
			} 
		} 
		
		else if(new String("registrar").equals(action)) 
		{
			System.out.println("registrando");
			String user = request.getParameter("userid");
			session.putValue("userid", user);
			String pwd = request.getParameter("pwd");

			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "762666");
			Statement st = con.createStatement();
			ResultSet rs;
			int i = st.executeUpdate("insert into user values ('" + user + "','" + pwd + "')");
			response.sendRedirect("login.jsp");	
		}
	%>



	<!-- Mixins-->
	<!-- Pen Title-->
	<div class="pen-title">
		<h1>Biblioteca</h1>
		<span>Desenvolvido por: <i class='fa fa-code'></i> <a
			href='https://github.com/devsdamassa/biblioteca'>DevsDaMassa</a></span>
	</div>

	<div class="container">
		<div class="card"></div>
		<div class="card">
		
		<h1 class="title">Login</h1>		

			<form  method="post">
				<div class="input-container">
					<input type="hidden" name="action" value="logar">
					<input type="text" name="usr" id="Username" required="required" />
					<label for="Username">Usuário</label>
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="password" name="pwd" id="Password" required="required" />
					<label for="Password">Senha</label>
					<div class="bar"></div>
				</div>
				<div class="button-container">
					<button>
						<span>Entrar</span>
					</button>
				</div>
				<div class="footer"></div>
			</form>
		</div>



		<div class="card alt">
			<div class="toggle"></div>
			<h1 class="title">
				Registrar
				<div class="close"></div>
			</h1>
			<form  method="post">
				<div class="input-container">
					<input type="hidden" name="action" value="registrar">
					<input type="text" name="userid" id="Username" required="required" />
					<label for="Username">Usuário</label>
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="password" name="pwd" id="Password" required="required" />
					<label for="Password">Senha</label>
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="password" id="Repeat Password" required="required" />
					<label for="Repeat Password">Repita a senha</label>
					<div class="bar"></div>
				</div>
				<div class="button-container">
					<button>
						<span>Proximo</span>
					</button>
				</div>
			</form>
		</div>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>
</body>
</html>
