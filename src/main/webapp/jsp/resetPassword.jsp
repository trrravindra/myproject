<%@ include file="global.jsp"%>

<link rel="stylesheet"
	href="<c:url value='/resources/styles/pages/erefill/global.css'/>" />
<script src="<c:url value='/resources/js/vendor/modernizr.js'/>"></script>
<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-form-details'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>


<div class="content">
	<c:set var="token" value="<%=request.getAttribute(\"user_token\") %>" />
	<c:set var="pwdvalid" value="${pwdvalid}" />
	<c:set var="errormsg" value="${errormsg}" />
	<h1 class="title">
		<spring:message code="reset.password.page.title.label" />
	</h1>

	<!-- form start -->

	<form class="form-details uniform form-validate"
		action="${contextPath}/${locale}/resetpassword/changepwd"
		novalidate="novalidate" method="POST">

		<div class="columns col5">
			<div class="column span2">
				<div class="row">
					<label class="title"> <spring:message
							code="new.password.label" /><span>*</span> <input
						class="new-password" type="password" name="newpassword"
						autocomplete="off" maxlength="32" data-rule-alphanumeric="true"
						data-msg-alphanumeric="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-rule-minlength="8"
						data-msg-minlength="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-msg-upperlowerspecialchar="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-rule-upperlowerspecialchar="true" data-rule-required="true"
						data-msg-required="<spring:message code="my.account.new.password.required.errMsg" />" />
						<c:if test="${not empty pwdvalid}">
							<label for="newpassword" class="error"> <spring:message
									code="reset.password.already.exists.errmsg" />
							</label>
						</c:if>
					</label>

				</div>
				<div class="row">
					<label class="title"> <spring:message
							code="confirm.new.password.label" /><span>*</span> <input
						type="password" autocomplete="off" name="confirmpassword"
						maxlength="32" data-rule-equalto=".new-password"
						data-msg-equalto="<spring:message code="my.account.password.match.fail.errMsg" />"
						data-rule-minlength="8"
						data-msg-minlength="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-rule-required="true"
						data-msg-required="<spring:message code="my.account.conf.password.required.errMsg" />" />
					</label>
				</div>
			</div>
			<div class="column span3">
				<div class="width80">
					<div class="criteria important margintop">
						<c:choose>
							<c:when test="${not empty registrationStep}">
								<spring:message
									code="registration.account.info.password.instruction" />
							</c:when>
							<c:otherwise>
								<spring:message code="my.account.password.instruction" />
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>

		<div class="navbottom">
			<button class="button-erefill green " type="submit" disabled>
				<spring:message code="continue.label" />
			</button>
			<button class="button-erefill border" type="reset">
				<spring:message code="undo.label" />
			</button>
			<label class="button-hint"> <spring:message
					code="password.errmsg.label" /></label>
		</div>
		<csrf:csrfToken />
	</form>
</div>