
<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<% 
	if(request.getCookies()!=null){
		for(Cookie value : request.getCookies() )
		{
			
				
		}
	}
	%>
	<h1>Welcome to XYZ Web Portal</h1>
	<br>
	<div class="row">
		<div class="col-md-1"></div>
		<form class="form-horizontal col-md-7" action="register" method="get">
			<fieldset>

				<!-- Form Name -->
				<legend>Create Account</legend>

				<!-- Prepended text-->
				<div class="form-group">

					<div class="col-md-5">
						<div class="input-group">
							<span class="input-group-addon">Name</span> <input
								id="prependedtext" name="customerName" class="form-control"
								placeholder="Enter name" type="text" required="">
						</div>

					</div>
				</div>

				<!-- Prepended text-->
				<div class="form-group">
					<div class="col-md-3">
						<div class="input-group">
							<span class="input-group-addon">Age</span> <input
								id="prependedtext" name="age" class="form-control"
								placeholder="Enter Age" type="text" required="">
						</div>

					</div>
				</div>

				<!-- Prepended text-->
				<div class="form-group">
					<div class="col-md-5">
						<div class="input-group">
							<span class="input-group-addon">Mobile No</span> <input id=""
								name="mobileNo" class="form-control"
								placeholder="Enter your Mobile No" type="text" required="">
						</div>
						<p class="help-block">Mobile No. should be of Exact 10 Digit</p>
					</div>
				</div>

				<!-- Multiple Radios (inline) -->
				<div class="form-group">
					<label class="col-md-1 control-label" for="accounttype">Account
						type</label>
					<div class="col-md-5">
						<label class="radio-inline" for="accounttype-0"> <input
							type="radio" name="accounttype" id="accounttype-0"
							value="current" checked="checked"> Current
						</label> <label class="radio-inline" for="accounttype-1"> <input
							type="radio" name="accounttype" id="accounttype-1" value="saving">
							Saving
						</label>
					</div>
				</div>
				<!-- Prepended text-->
				<div class="form-group">
					<div class="col-md-5">
						<div class="input-group">
							<span class="input-group-addon">Password</span> <input
								id="prependedtext" name="password" class="form-control"
								placeholder="Enter a strong password" type="password" required="">
						</div>
						<p class="help-block">A strong password always contains a
							special character</p>
					</div>
				</div>


				<div class="form-group">
					<div class="col-md-4">
						<input type="submit" id="" name="" value="Create Account"
							class="btn btn-success">
					</div>
				</div>
			</fieldset>
		</form>
		<form action="authenticate" method="post" class="col-md-4">
			<input type="text" placeholder="Enter your mobile no or Account no"
				name="accountNo" maxlength="10"> <input type="password"
				placeholder="Enter your password" name="password"> <input
				type="submit" value="Login">
		</form>
	</div>

</body>
</html>