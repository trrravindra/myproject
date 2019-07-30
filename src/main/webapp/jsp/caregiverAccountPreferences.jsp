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
		<label class="registration-note"> <span><spring:message
					code="registration.note.label" /></span> <spring:message
				code="registration.message.label" />
		</label>
		<%@include file="progressTracker.jsp"%>
	</div>

	<form
		action="${contextPath}/${locale}/registration/caregiver/accountpref/update"
		class="form-details uniform form-validate" method="post">


		<div class="columns col2 width75">
			<spring:message code="registration.account.pref.sec.text" />

			<div class="column">
				<div class="row">
					<label class="title"> <spring:message
							code="registration.account.pref.sec.qn1.label" /> <select
						name="question1" class="security-question"
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
					<label class="title"> <spring:message
							code="registration.account.pref.sec.ans1.label" /><span>*</span>
						<input type="text" class="registration-security" name="answer1"
						data-rule-required="true"
						data-msg-required="<spring:message code="my.account.security.questions.ans.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<label class="title"> <spring:message
							code="registration.account.pref.sec.qn2.label" /> <select
						name="question2" class="security-question"
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
					<label class="title"> <spring:message
							code="registration.account.pref.sec.ans2.label" /><span>*</span>
						<input type="text" name="answer2" class="registration-security"
						data-rule-required="true"
						data-msg-required="<spring:message code="my.account.security.questions.ans.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<label class="title"> <spring:message
							code="registration.account.pref.sec.qn3.label" /> <select
						name="question3" class="security-question"
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
					<label class="title"> <spring:message
							code="registration.account.pref.sec.ans3.label" /><span>*</span>
						<input type="text" name="answer3" class="registration-security"
						data-rule-required="true"
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
			<label class="button-hint"> </label>
		</div>
		<csrf:csrfToken />
	</form>
</div>
