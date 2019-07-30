<%@ include file="global.jsp"%>

<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-general'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
</head>
<body>

	<div class="content">
		<div class="width75 user-generated-content">
			<h1 class="title">
				<spring:message code="contactus.heading" />
			</h1>
			<h2>
				<spring:message code="contactus.subheading.tech" />
			</h2>
			<p>
				<spring:message code="contactus.subheading.tech.description"
					arguments="${contextPath}" />
			</p>
		</div>
		<script>
     pageName = "contact-us";
	  </script>
	</div>
</body>
<%-- <c:import url="http://10.209.4.200:4503/content/erefill/${locale}/contactus.textcontent.html"></c:import> --%>