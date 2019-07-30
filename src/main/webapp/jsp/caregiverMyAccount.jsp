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
	<h1 class="title">
		<spring:message code="my.account.page.title.label" />
	</h1>

	<ul class="nav-account-sections">
		<li><a href="#" class="scroll-link"
			data-link-target=".section-username"><spring:message
					code="my.account.user.name.title.label" /></a></li>
		<li><a href="#" class="scroll-link"
			data-link-target=".section-password"><spring:message
					code="my.account.password.title.label" /></a></li>
		<li><a href="#" class="scroll-link"
			data-link-target=".section-communication"><spring:message
					code="my.account.communication.title.label" /></a></li>
		<li><a href="#" class="scroll-link"
			data-link-target=".section-questions"><spring:message
					code="my.account.security.questions.title.label" /></a></li>
	</ul>

	<!-- About you : user name begins -->
	<form
		class="form-details form-account-update bordertop uniform form-validate section-username">
		<h2 class="title">
			<spring:message code="my.account.user.name.title.label" />
		</h2>

		<div class="columns col2">
			<div class="row">
				<label class="title"><spring:message
						code="my.account.name.label" /></label>
				<p>${account.firstName} ${account.lastName}</p>
			</div>
		</div>
		<a href="#" class="scroll-link to-top"><spring:message
				code="scroll.back.to.top.label" /></a>
	</form>
	<!-- About you : user name end -->

	<!-- form start -->
	<form
		class="form-details form-account-update bordertop uniform form-validate section-password"
		action="${contextPath}/${locale}/myaccount/caregiver/password/change">

		<h2 class="title">
			<spring:message code="my.account.password.title.label" />
		</h2>

		<div class="columns col2">

			<div class="column">

				<div class="row">
					<label class="title"> <spring:message
							code="my.account.current.password.label" /><span>*</span> <input
						class="chkpass" type="password" name="currentpassword"
						autocomplete="off" maxlength="32" data-rule-required="true"
						data-msg-required="<spring:message code="my.account.current.password.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<label class="title"> <spring:message
							code="my.account.new.password.label" /><span>*</span> <input
						class="new-password chkpass" type="password" name="newpassword"
						autocomplete="off" maxlength="32" data-rule-alphanumeric="true"
						data-msg-alphanumeric="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-rule-minlength="8"
						data-msg-minlength="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-msg-upperlowerspecialchar="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-rule-upperlowerspecialchar="true" data-rule-required="true"
						data-msg-required="<spring:message code="my.account.new.password.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<label class="title"> <spring:message
							code="my.account.confirm.new.password.label" /><span>*</span> <input
						type="password" class="chkpass" name="confirmpassword"
						autocomplete="off" maxlength="32"
						data-rule-equalto=".new-password"
						data-msg-equalto="<spring:message code="my.account.password.match.fail.errMsg" />"
						data-rule-minlength="8"
						data-msg-minlength="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-rule-required="true"
						data-msg-required="<spring:message code="my.account.conf.password.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<button class="button-erefill green" type="submit" disabled=""
						name="changepassword_button">
						<spring:message code="my.account.change.password.button" />
					</button>
					<button class="button-erefill border" type="reset">
						<spring:message code="my.account.reset.button" />
					</button>
					<label class="button-success"><spring:message
							code="my.account.password.successMsg" /> </label> <label
						class="button-error"><spring:message
							code="my.account.password.errorMsg" /></label> <label
						class="button-error1"><spring:message
							code="my.account.current.password.errorMsg" /></label> <label
						class="button-exception"><spring:message
							code="my.account.password.exceptionMsg" /></label>
				</div>
			</div>

			<div class="column">
				<div class="width80">
					<div class="criteria margintop">
						<spring:message code="my.account.password.instruction" />
					</div>
				</div>
			</div>
		</div>
		<csrf:csrfToken />
		<a href="#" class="scroll-link to-top"><spring:message
				code="scroll.back.to.top.label" /></a>
	</form>
	<!-- form end -->

	<!-- Email display start -->
	<form
		class="form-details bordertop uniform form-validate section-communication">
		<h2 class="title">
			<spring:message code="caregiver.account.communication.title.label" />
		</h2>

		<div class="columns col2">
			<div class="column">
				<div class="row">
					<label class="title"><spring:message
							code="my.account.current.email.label" /> <input type="text"
						name="email" value="${mailId}" disabled /> </label>
				</div>
			</div>

			<div class="column">
				<div class="width80">
					<div class="criteria margintop">
						<spring:message code="caregiver.my.account.email.instruction" />
					</div>
				</div>
			</div>
		</div>
	</form>
	<!-- Email display end -->

	<!-- form start -->
	<form
		class="form-details form-account-update bordertop padtop uniform form-validate section-questions"
		action="${contextPath}/${locale}/myaccount/caregiver/securityquestions/update">

		<h2 class="title">
			<spring:message code="my.account.security.questions.title.label" />
		</h2>

		<div class="columns col2">
			<div class="column">
				<div class="row">
					<select name="question1" class="security-question"
						data-rule-question-unique="true"
						data-msg-question-unique="<spring:message code="my.account.security.questions.unique.errMsg" />">
						<c:forEach var="question" items="${questionsMap}">
							<c:choose>
								<c:when
									test="${question.key==accountPreferenceVO.securityQuestion1}">
									<option value="${question.key}" selected="selected">${question.value}</option>
									<c:set var="flag" value="false" />
								</c:when>
								<c:otherwise>
									<option value="${question.key}">${question.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>

				<div class="row marginbottom">
					<input type="password" autocomplete="off" class="form-security"
						name="answer1" data-rule-required="true"
						data-msg-required="<spring:message code="my.account.security.questions.ans.required.errMsg" />"
						value="${accountPreferenceVO.securityQuestion_Answer1}" />
				</div>

				<div class="row">
					<select name="question2" class="security-question"
						data-rule-question-unique="true"
						data-msg-question-unique="<spring:message code="my.account.security.questions.unique.errMsg" />">
						<c:forEach var="question" items="${questionsMap}">
							<c:choose>
								<c:when
									test="${question.key==accountPreferenceVO.securityQuestion2}">
									<option value="${question.key}" selected="selected">${question.value}</option>
									<c:set var="flag" value="false" />
								</c:when>
								<c:otherwise>
									<option value="${question.key}">${question.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>

				<div class="row marginbottom">
					<input type="password" autocomplete="off" name="answer2"
						class="form-security" data-rule-required="true"
						data-msg-required="<spring:message code="my.account.security.questions.ans.required.errMsg" />"
						value="${accountPreferenceVO.securityQuestion_Answer2}" />
				</div>

				<div class="row">
					<select name="question3" class="security-question"
						data-rule-question-unique="true"
						data-msg-question-unique="<spring:message code="my.account.security.questions.unique.errMsg" />">
						<c:forEach var="question" items="${questionsMap}">
							<c:choose>
								<c:when
									test="${question.key==accountPreferenceVO.securityQuestion3}">
									<option value="${question.key}" selected="selected">${question.value}</option>
									<c:set var="flag" value="false" />
								</c:when>
								<c:otherwise>
									<option value="${question.key}">${question.value}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>

				<div class="row">
					<input type="password" autocomplete="off" class="form-security"
						name="answer3" data-rule-required="true"
						data-msg-required="<spring:message code="my.account.security.questions.ans.required.errMsg" />"
						value="${accountPreferenceVO.securityQuestion_Answer3}" />
				</div>
			</div>
		</div>

		<div class="row">
			<button class="button-erefill green" type="submit" disabled=""
				name="changesecurityquestions_button">
				<spring:message code="my.account.change.security.questions.button" />
			</button>
			<button class="button-erefill border" type="reset">
				<spring:message code="my.account.reset.button" />
			</button>
			<label class="button-success"><spring:message
					code="my.account.security.questions.successMsg" /> </label> <label
				class="button-error"><spring:message
					code="my.account.security.questions.errorMsg" /></label> <label
				class="button-exception"><spring:message
					code="my.account.security.questions.exceptionMsg" /></label>
		</div>
		<csrf:csrfToken />
		<a href="#" class="scroll-link to-top"><spring:message
				code="scroll.back.to.top.label" /></a>
	</form>
	<!-- form end -->
</div>