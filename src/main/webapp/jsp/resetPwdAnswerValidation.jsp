<%@ include file="global.jsp"%>

<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@ page import="com.lcl.erefill.core.utils.PropertyUtil"%>
<%@page import="com.lcl.erefill.core.connection.ErefillRecaptchaLoader"%>
<head>
<link rel="stylesheet"
	href="<c:url value='/resources/styles/pages/erefill/global.css'/>" />
<script src="<c:url value='/resources/js/vendor/modernizr.js'/>"></script>
<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-form-details'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
</head>


<script src="${locale eq 'fr_CA' ? 'https://www.google.com/recaptcha/api.js?hl=fr-CA':'https://www.google.com/recaptcha/api.js'}" async defer></script>

<div class="content">
	<c:set var="userName" value="${userName}" />
	<c:set var="securityQuestion" value="${securityQuestion}" />
	<c:set var="choice" value="${choice}" />
	<c:set var="invalidAnswer" value="${invalidAnswer}" />
	<c:set var="errormsg" value="${errormsg}" />
	<c:set var="userProvidedQuestions" value="${userProvidedQuestions }" />

	<h1 class="title">
		<spring:message code="reset.password.page.title.label" />
	</h1>
	<!-- form start -->
	<form class="form-details hascaptcha uniform form-validate"
		action="${contextPath}/${locale}/resetpassword/validatesecanswer"
		novalidate="novalidate" method="POST">
		<div class="columns col2 width85">
			<div class="row">
				<p>
					<spring:message code="username.label" />
					<br /> <strong> ${userName} </strong>
				</p>
			</div>
			<div class="row width80">
				<p>
					<spring:message code="secquestioninstruction.label" />
				</p>
			</div>
			<div class="column">
				<div class="row">
					<p class="nomargin">
						<spring:message code="required.field.highlighter" />
						<br />
						<spring:message code="question.label" />
						<br /> <strong>${securityQuestion}</strong> <input type="hidden"
							name="username" value="${userName}" /> <input type="hidden"
							name="question" value="${securityQuestion}" /> <input
							type="hidden" name="choice" value="${choice}" /> <input
							type="hidden" name="userProvidedQuestions"
							value="${userProvidedQuestions }">

					</p>
				</div>
				<div class="row">
					<label class="title" for="answer"> <spring:message
							code="answer.label" /> <span>*</span> <input type="text"
						id="answer" name="answer" data-rule-required="true"
						data-msg-required="<spring:message code="invalidanswer.errmsg.label" />">
					</label>

				</div>

				<div class="row">
					<label class="title"><spring:message code="captcha.label" />
						<%--Captcha code --%> <c:set var="loader" value="${loader}"></c:set>

						<%
						String recaptchaSiteKey= PropertyUtil.getRecaptchav2Sitekey();
						ErefillRecaptchaLoader loader = (ErefillRecaptchaLoader)request.getAttribute("loader");
						String googleRecaptchaServer = loader.getGoogleCaptchaApiServer();
					 %>  <!--New Google recaptchav2-->
					 <div class="g-recaptcha" data-sitekey="<%=recaptchaSiteKey%>"></div></label>
				</div>
			</div>
		</div>

		<%--invalidAnswer Error Msg --%>
		<c:if test="${not empty errormsg }">
			<label class="alert error error-msg"><span>${errormsg}</span></label>
		</c:if>

		<div class="navbottom">
			<button class="button-erefill green " type="submit" disabled>
				<spring:message code="continue.label" />
			</button>
			<button class="button-erefill border" type="reset">
				<spring:message code="undo.label" />
			</button>
			<!-- <label class="button-hint"> <spring:message code="username.errmsg.label" /></label> -->
		</div>
		<csrf:csrfToken />
	</form>
</div>