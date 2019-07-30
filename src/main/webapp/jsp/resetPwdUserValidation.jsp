<%@ include file="global.jsp"%>

<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@ page import="com.lcl.erefill.core.utils.PropertyUtil"%>
<%@page import="com.lcl.erefill.core.connection.ErefillRecaptchaLoader"%>

<link rel="stylesheet"
	href="<c:url value='/resources/styles/pages/erefill/global.css'/>" />
<script src="<c:url value='/resources/js/vendor/modernizr.js'/>"></script>
<script id="require-js"
	data-main="${contextPath }/resources/js/erefill-form-details"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
	
<script src="${locale eq 'fr_CA' ? 'https://www.google.com/recaptcha/api.js?hl=fr-CA':'https://www.google.com/recaptcha/api.js'}" async defer></script>


<div class="content">
	<c:set var="token" value="<%=request.getParameter(\"token\") %>" />
	<c:if test="${empty token}">
		<c:set var="token" value="<%=request.getParameter(\"user_token\") %>" />
	</c:if>
	<c:set var="errormsg" value="${error}" />
	<h1 class="title">
		<spring:message code="reset.password.page.title.label" />
	</h1>

	<!-- form start -->
	<c:choose>
		<c:when test="${not empty token}">
			<form class="form-details hascaptcha uniform form-validate"
				action="${contextPath}/${locale}/resetpassword/validateuser/token"
				novalidate="novalidate" method="POST">
				<input type="hidden" name="user_token" value="${token}" />
		</c:when>
		<c:otherwise>
			<form class="form-details hascaptcha uniform form-validate"
				action="${contextPath}/${locale}/resetpassword/validateuser"
				novalidate="novalidate" method="POST">
		</c:otherwise>
	</c:choose>


	<div class="columns col2 width75">

		<div class="row width80">
			<p>
				<spring:message code="reset.password.step1.page.description.label" />
			</p>
			<p>
				<spring:message
					code="reset.password.step1.page.caregiver.description.label" />
			</p>
		</div>

		<div class="column">
			<div class="row">
				<label class="title"><spring:message code="username.label" /><span>*</span>
					<input type="text" name="username" data-rule-required="true"
					data-msg-required="<spring:message code="username.reqmsg.label" />" />
				</label>
			</div>

			<div class="row">
				<label class="title"><spring:message code="captcha.label" />
					<%--Captcha code --%> <c:set var="loader" value="${loader}"></c:set>

					<%
						String recaptchaSiteKey= PropertyUtil.getRecaptchav2Sitekey();
						ErefillRecaptchaLoader loader = (ErefillRecaptchaLoader)request.getAttribute("loader");
						String googleRecaptchaServer = loader.getGoogleCaptchaApiServer();
					 %> 
					 <!--New Google recaptchav2-->
					 <div class="g-recaptcha" data-sitekey="<%=recaptchaSiteKey%>"></div></label>
			</div>
		</div>
	</div>
	<%--Error Msg --%>
	<c:if test="${not empty errormsg}">
		<label><span>${errormsg}</span></label>
	</c:if>
	<%--Error Msg --%>
	<div class="navbottom">
		<button class="button-erefill green " type="submit" disabled>
			<spring:message code="continue.label" />
		</button>
		<button class="button-erefill border" type="reset">
			<spring:message code="undo.label" />
		</button>
		<label class="button-hint"> <spring:message
				code="username.errmsg.label" /></label>
	</div>
	<csrf:csrfToken />
	</form>
	<!-- form end -->


</div>