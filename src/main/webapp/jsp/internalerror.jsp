<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page
	import=" org.springframework.context.support.ReloadableResourceBundleMessageSource,
				 java.util.Locale"%>
<head>

<title><spring:message code="error500.title"></spring:message></title>
<meta name="description" content="" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="format-detection" content="telephone=yes" />
<meta http-equiv="cleartype" content="on" />
<meta name="mobileoptimized" content="1024" />
<meta name="viewport" content="width=1024" />


<link rel="stylesheet"
	href='<c:url value="/resources/styles/pages/erefill/global.css"/>' />

<script src='<c:url value="/resources/js/vendor/modernizr.js"/>'></script>
<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-form-details.js'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
</head>

<body class="" data-page-analytics=''>

	<section class="container">
		<section class="page page-404">
			<%@ include file="home/header.jsp"%>
			<div class="content">
				<div class="columns col2">
					<%
				localeObj = new Locale("en", "CA");
					locale=(String)pageContext.getAttribute("locale");
					if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
						localeObj = new Locale("fr", "CA");
					}
				%>
					<div class="column notfound-left">
						<div class="column-inner">
							<c:choose>
								<c:when test="${locale eq 'fr_CA'}">
									<img
										src="<c:url value='/resources/images/erefill/500_fr_updated.jpg'/>"
										alt="Internal error Image" />
								</c:when>
								<c:otherwise>
									<img
										src="<c:url value='/resources/images/erefill/500_updated.jpg'/>"
										alt="Internal error Image" />
								</c:otherwise>
							</c:choose>

						</div>
					</div>
					<div class="column">
						<h1 class="title">
							<%=reloadableResourceBundleMessageSource.getMessage("error500.title", null, localeObj)%>
						</h1>
						<p>
							<%=reloadableResourceBundleMessageSource.getMessage("error500.msg1", null, localeObj)%><br />
							<%=reloadableResourceBundleMessageSource.getMessage("error500.msg2", null, localeObj)%>
						</p>
						<a class="button-erefill green "
							href="<c:url value='<%=homePage%>'/>" role="button"> <%=reloadableResourceBundleMessageSource.getMessage("error500.login.label", null, localeObj)%>
						</a>
					</div>
				</div>
			</div>
		</section>
	</section>

</body>
</html>






