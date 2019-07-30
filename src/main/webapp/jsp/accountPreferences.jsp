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

<div class="content">
	<div class="registration">
		<h1 class="title">
			<spring:message code="registration.title.label" />
		</h1>
		<spring:message code="registration.description.label" />
		<span class="registration-note"> <span><spring:message
					code="registration.note.label" /></span> <spring:message
				code="registration.message.label" />
		</span>
		<%@include file="progressTracker.jsp"%>
	</div>

	<form action="${contextPath}/${locale}/registration/accountpref/update"
		class="form-details uniform form-validate" method="post">


		<!-- Adding the password input fields  -->
		<div class="columns col5">
			<div class="column span2">
				<div class="row">
					<label class="title" for="newpassword"> <spring:message
							code="registration.account.info.password.label" /><span>*</label>
					<c:if test="${'pwdError' eq error}">
						<div class="error error-msg"
							style="display: block; font-weight: bold;">
							<spring:message code="my.account.password.criteria.fail.errMsg" />
						</div>
					</c:if>
					<input class="new-password" id="newpassword" type="password"
						autocomplete="off" name="newPassword" maxlength="32"
						data-rule-upperlowerspecialchar="true"
						data-msg-upperlowerspecialchar="<spring:message	code="my.account.password.criteria.fail.errMsg" />"
						data-rule-minlength="8"
						data-msg-minlength="<spring:message	code="my.account.password.criteria.fail.errMsg" />"
						data-rule-required="true"
						data-msg-required="<spring:message	code="my.account.new.password.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<label class="title" for="confirmpassword"> <spring:message
							code="registration.account.info.confirm.password.label" /><span>*</span>
						<input type="password" id="confirmpassword" autocomplete="off"
						name="confirmpassword" maxlength="32"
						data-rule-equalto=".new-password"
						data-msg-equalto="<spring:message	code="my.account.password.match.fail.errMsg" />"
						data-rule-minlength="8"
						data-msg-minlength="<spring:message	code="my.account.password.criteria.fail.errMsg" />"
						data-rule-required="true"
						data-msg-required="<spring:message	code="my.account.conf.password.required.errMsg" />" />
					</label>
				</div>
			</div>

			<div class="column span3">
				<div class="width80">
					<div class="criteria margintop">
						<spring:message
							code="registration.account.info.password.instruction" />
					</div>
				</div>
			</div>
		</div>
		<!-- End -->




		<div class="columns col2 width75">
			<spring:message code="registration.account.pref.sec.text" />

			<div class="column">
				<div class="row">
					<label class="title" for="question1"> <spring:message
							code="registration.account.pref.sec.qn1.label" /> <select
						name="question1" id="question1" class="security-question"
						data-rule-question-unique="true"
						data-msg-question-unique="<spring:message code="registration.account.pref.sec.questions.unique.errMsg" />">
							<c:forEach var="question" items="${questionsMap}">
								<c:choose>
									<c:when test="${not empty securityQuestion1}">
										<option value="${question.key}" selected="selected">${question.value}</option>
										<c:set var="flag" value="false" />
									</c:when>
									<c:otherwise>
										<option value="${question.key}">${question.value}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>
					</label>
				</div>

				<div class="row marginbottom">
					<label class="title" for="answer1"> <spring:message
							code="registration.account.pref.sec.ans1.label" /><span>*</span>
						<input type="text" id="answer1" class="registration-security"
						name="answer1" data-rule-required="true"
						data-msg-required="<spring:message code="my.account.security.questions.ans.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<label class="title" for="question2"> <spring:message
							code="registration.account.pref.sec.qn2.label" /> <select
						name="question2" id="question2" class="security-question"
						data-rule-question-unique="true"
						data-msg-question-unique="<spring:message code="registration.account.pref.sec.questions.unique.errMsg" />">
							<c:forEach var="question" items="${questionsMap}">
								<c:choose>
									<c:when test="${not empty securityQuestion2}">
										<option value="${question.key}" selected="selected">${question.value}</option>
										<c:set var="flag" value="false" />
									</c:when>
									<c:otherwise>
										<option value="${question.key}">${question.value}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>
					</label>
				</div>

				<div class="row marginbottom">
					<label class="title" for="answer2"> <spring:message
							code="registration.account.pref.sec.ans2.label" /><span>*</span>
						<input type="text" id="answer2" name="answer2"
						class="registration-security" data-rule-required="true"
						data-msg-required="<spring:message code="my.account.security.questions.ans.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<label class="title" for="question3"> <spring:message
							code="registration.account.pref.sec.qn3.label" /> <select
						id="question3" name="question3" class="security-question"
						data-rule-question-unique="true"
						data-msg-question-unique="<spring:message code="registration.account.pref.sec.questions.unique.errMsg" />">
							<c:forEach var="question" items="${questionsMap}">
								<c:choose>
									<c:when test="${not empty securityQuestion3}">
										<option value="${question.key}" selected="selected">${question.value}</option>
										<c:set var="flag" value="false" />
									</c:when>
									<c:otherwise>
										<option value="${question.key}">${question.value}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
					</select>
					</label>
				</div>

				<div class="row">
					<label class="title" for="answer3"> <spring:message
							code="registration.account.pref.sec.ans3.label" /><span>*</span>
						<input type="text" id="answer3" name="answer3"
						class="registration-security" data-rule-required="true"
						data-msg-required="<spring:message code="my.account.security.questions.ans.required.errMsg" />" />
					</label>
				</div>
			</div>
		</div>

		<div class="navbottom">
			<button class="button-erefill green" type="submit" disabled>
				<spring:message code="registration.continue.button.label" />
			</button>
			<button class="button-erefill border" type="reset">
				<spring:message code="my.account.reset.button" />
			</button>
			<span class="button-hint"> </span>
		</div>
		<csrf:csrfToken />
	</form>
</div>
