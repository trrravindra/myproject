<%@ include file="global.jsp"%>

<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />

<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-form-details.js'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
</head>

<div class="page sidebar-left-layout page-refill-request page-reconsent">
	<div class="content display">

		<h4 class="subhead-five">
			<spring:message code="reconsent.sure.you.want.to.cancel" />
		</h4>
		<p class="detail">
			<spring:message code="reconsent.decline.terms.of.use" />
		</p>
		<a href="${contextPath}/${locale}/reconsent/view"
			class="button-erefill reconsent green refill-submit"> <spring:message
				code="reconsent.back.to.terms.of.use" />
		</a>

		<p class="cancel-warn">
			<a href="${contextPath}/${locale}/user/logout"> <spring:message
					code="reconsent.sure.log.me.out" />
			</a>
		</p>
	</div>
</div>