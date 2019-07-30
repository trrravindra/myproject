<%@ include file="global.jsp"%>

<%@ page session="false"%>
<body>

	<img src="<c:url value='/resources/images/global/ajax-loader.gif'/>"
		alt="Loader.gif" style="width: 32px; height: 32px; display: none" />

	<div class="content">
		<title>sign in</title>

		<h2>Signup Details</h2>
		<form action="${contextPath}/${locale}/user/login" method="post">
			Username: <input required="required" name="username" /> <br />
			Password: <input required="required" type="password" name="password" />
			<br /> <font color="red">${error}</font><br /> <input
				type="checkbox" name="remember">Remember Me <br /> <input
				type="submit" value="Submit" />
			<csrf:csrfToken />
		</form>
	</div>
</body>