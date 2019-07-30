<%@ include file="global.jsp"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="${locale}" class="no-js lt-ie10 lt-ie9 lt-ie8 lt-ie7 ie" > <![endif]-->
<!--[if IE 7]>         <html lang="${locale}" class="no-js lt-ie10 lt-ie9 lt-ie8 ie" > <![endif]-->
<!--[if IE 8]>         <html lang="${locale}" class="no-js lt-ie10 lt-ie9 ie" > <![endif]-->
<!--[if IE 9]>         <html lang="${locale}" class="no-js lt-ie10 ie" > <![endif]-->
<!--[if gt IE 9]><!-->
<html lang="${locale}" class="no-js ie">
<!--<![endif]-->

<head>

<title><c:if test="${not empty title}">
		<spring:message code="${title}" />
	</c:if></title>
<meta name="description" content="" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="format-detection" content="telephone=yes" />
<meta http-equiv="cleartype" content="on" />
<meta name="mobileoptimized" content="1024" />
<meta name="viewport" content="width=1024" />


<link rel="stylesheet"
	href="<c:url value='/resources/styles/pages/erefill/global.css'/>" />

<script src="<c:url value='/resources/js/vendor/modernizr.js'/>"></script>

</head>

<body class=""
	data-page-analytics='{"pageCategory" : "","pageName" : "${pageName}","pageTemplate" : "","brand" : "","campaign" : ""}'>

	<section class="container">

		<section class="page page-details">

			<tiles:insertAttribute name="header" />

			<tiles:insertAttribute ignore="true" name="notification" />

			<tiles:insertAttribute name="body" />

		</section>

	</section>

	<!-- FOOTER -->
	<tiles:insertAttribute name="footer" />
</body>
</html>
