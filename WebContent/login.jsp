<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bibliotecax</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="row">
					<div class="col-md-12">
						<img src="img/logo.png" id="logo">
					</div>
				</div>
				<div class="panel">
					<div class="panel-body">
						<div class="form-group">
							<label class="rotulo-campo-login" for="username">Username</label>
							<input type="text" name="username" id="username" class="form-control">
						</div>
						<div class="form-group">
							<label class="rotulo-campo-login" for="password">Password</label>
							<input type="text" name="password" id="password" class="form-control">
						</div>
						<div class="form-group">
							<button class="btn btn-primary btn-block" type="button">Sing in</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>