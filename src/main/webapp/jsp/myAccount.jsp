<%@ include file="global.jsp"%>
<head>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<script id="require-js"
	data-path="${pageContext.request.contextPath}/static/global.html"
	data-main="<c:url value='/resources/js/erefill-form-details'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>
</head>

<c:set var="placeholder" value="YYYY-MM-DD" />
<c:if test="${locale eq 'fr_CA' }">
	<c:set var="placeholder" value="AAAA-MM-JJ" />
</c:if>

<div class="content">
	<h1 class="title">
		<spring:message code="my.account.page.title.label" />
	</h1>

	<ul class="nav-account-sections">
		<li><a href="#" class="scroll-link"
			data-link-target=".section-username"><spring:message
					code="my.account.user.name.label" /></a></li>
		<li><a href="#" class="scroll-link"
			data-link-target=".section-password"><spring:message
					code="my.account.password.title.label" /></a></li>
		<li><a href="#" class="scroll-link"
			data-link-target=".section-communication"><spring:message
					code="my.account.communication.title.label" /></a></li>
		<li><a href="#" class="scroll-link"
			data-link-target=".section-questions"><spring:message
					code="my.account.security.questions.title.label" /></a></li>
		<li><a href="#" class="scroll-link"
			data-link-target=".section-tax-teceipt"><spring:message
					code="my.account.patient.tax.receipt.report.title.label" /></a></li>
		<li><a href="#" class="scroll-link"
			data-link-target=".section-terms-of-use"><spring:message
					code="my.account.terms.of.use.title.hyperlink.label" /></a></li>
		<li class="last"><a href="#" class="scroll-link"
			data-link-target=".section-close-account"><spring:message
					code="my.account.close.title.hyperlink.label" /></a></li>
	</ul>

	<!-- form start -->
	<form
		class="form-details form-account-update bordertop uniform form-validate section-username"
		action="${contextPath}/${locale}/myaccount/username/update">

		<h2 class="title">
			<spring:message code="my.account.user.name.title.label" />
		</h2>

		<div class="columns col2">
			<div class="row">
				<span class="title"><spring:message
						code="my.account.name.label" /></span>
				<p>${account.firstName} ${account.lastName}</p>
			</div>

			<div class="column">
				<div class="row">
					<label class="title" for="uname"><spring:message
							code="my.account.user.name.label" /><input type="text"
						name="username" alphanumeric="true"
						data-msg-alphanumeric="<spring:message code="my.account.user.name.aphanumeric.errMsg" />"
						data-rule-required="true"
						data-msg-required="<spring:message code="my.account.user.name.required.errMsg" />"
						value="${userName}" id="uname" /> </label>
				</div>

				<div class="row">
					<button class="button-erefill green" type="submit" disabled=""
						name="changeusername_button">
						<spring:message code="my.account.change.user.name.button" />
					</button>
					<button class="button-erefill border" type="reset">
						<spring:message code="my.account.reset.button" />
					</button>
					<span class="button-success"><spring:message
							code="my.account.user.name.successMsg" /> </span> <span
						class="button-error"><spring:message
							code="my.account.user.name.errorMsg" /></span> <span
						class="button-exception"><spring:message
							code="my.account.user.name.exceptionMsg" /></span>
				</div>
			</div>

			<div class="column">
				<div class="width80">
					<div class="criteria margintop">
						<p>
							<spring:message code="my.account.user.name.instruction" />
						</p>
					</div>
				</div>
			</div>
		</div>
		<a href="#" class="scroll-link to-top"><spring:message
				code="scroll.back.to.top.label" /></a>
		<csrf:csrfToken />
	</form>
	<!-- form end -->

	<!-- form start -->
	<form
		class="form-details form-account-update bordertop uniform form-validate section-password"
		action="${contextPath}/${locale}/myaccount/password/change">

		<h2 class="title">
			<spring:message code="my.account.password.title.label" />
		</h2>

		<div class="columns col2">

			<div class="column">

				<div class="row">
					<label class="title" for="currentpassword"> <spring:message
							code="my.account.current.password.label" /><span>*</span> <input
						class="chkpass" id="currentpassword" type="password"
						name="currentpassword" autocomplete="off" maxlength="32"
						data-rule-required="true"
						data-msg-required="<spring:message code="my.account.current.password.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<label class="title" for="newpassword"> <spring:message
							code="my.account.new.password.label" /><span>*</span> <input
						class="new-password chkpass" id="newpassword" type="password"
						name="newpassword" autocomplete="off" maxlength="32"
						data-rule-alphanumeric="true"
						data-msg-alphanumeric="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-rule-minlength="8"
						data-msg-minlength="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-msg-upperlowerspecialchar="<spring:message code="my.account.password.criteria.fail.errMsg" />"
						data-rule-upperlowerspecialchar="true" data-rule-required="true"
						data-msg-required="<spring:message code="my.account.new.password.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<label class="title" for="confirmpassword"> <spring:message
							code="my.account.confirm.new.password.label" /><span>*</span> <input
						type="password" id="confirmpassword" class="chkpass"
						name="confirmpassword" autocomplete="off" maxlength="32"
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
					<span class="button-success"><spring:message
							code="my.account.password.successMsg" /> </span> <span
						class="button-error"><spring:message
							code="my.account.password.errorMsg" /></span> <span
						class="button-error1"><spring:message
							code="my.account.current.password.errorMsg" /></span> <span
						class="button-exception"><spring:message
							code="my.account.password.exceptionMsg" /></span>
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

	<!-- form start -->
	<form
		class="form-details bordertop uniform form-validate section-communication"
		action="${contextPath}/${locale}/myaccount/email/update">

		<h2 class="title">
			<spring:message code="my.account.communication.label" />
		</h2>

		<div class="columns col2">
			<div class="column">
				<div class="row">
					<label class="title" for="email"><spring:message
							code="my.account.current.email.label" /><input type="text"
						name="email" id="email" value="${mailId}" data-rule-email="true"
						data-msg-email="<spring:message code="my.account.email.criteria.fail.errMsg" />"
						data-msg-required="<spring:message code="my.account.email.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<span class="title"><spring:message
							code="my.account.status.label" /></span>
					<p class="confirmation-status">${mailStatus}</p>
				</div>

				<div class="row">
					<button class="button-erefill green" type="submit"
						name="changemailid_button">
						<spring:message code="my.account.change.email.button" />
					</button>
					<button class="button-erefill border" type="reset">
						<spring:message code="my.account.reset.button" />
					</button>
					<span class="button-success"><spring:message
							code="my.account.email.successMsg" /> </span> <span
						class="button-error"><spring:message
							code="my.account.email.errorMsg" /></span> <span
						class="button-unsubscribe"><spring:message
							code="my.account.email.unsubscribeMsg" /></span> <span
						class="button-exception"><spring:message
							code="my.account.email.exceptionMsg" /></span>
				</div>
			</div>

			<div class="column">
				<div class="width80">
					<div class="criteria margintop">
						<p>
							<strong><spring:message
									code="my.account.email.instruction" /></strong>
						</p>
					</div>
					<div>
						<spring:message code="my.account.email.phone.consent.text" />
						<spring:message
							code="my.account.email.phone.consent.province.table" />
					</div>
				</div>
			</div>
		</div>
		<csrf:csrfToken />
	</form>
	<!-- form end -->

	<!-- form start -->
	<form class="form-details uniform phone-number form-validate"
		action="${contextPath}/${locale}/myaccount/phone/update">
		<div class="columns col2">
			<div class="column">
				<div class="row">
					<fieldset>
						<legend class="title">
							<spring:message code="my.account.telephone.number.title.label" />
						</legend>

						<div>
							<input type="text" name="phone1" class="phone1"
								value="${phoneNum1}" maxlength="3" numeric="true"
								data-msg-numeric="<spring:message code="data.msg.numeric.errMsg"/>"
								data-rule-minlength="3"
								data-msg-minlength="<spring:message code="data.msg.length.3.errMsg"/>"
								data-msg-required="<spring:message code="my.account.phone.first.input.required.errMsg"/>">
							- <input type="text" name="phone2" class="phone2"
								value="${phoneNum2}" maxlength="3" numeric="true"
								data-msg-numeric="<spring:message code="data.msg.numeric.errMsg"/>"
								data-rule-minlength="3"
								data-msg-minlength="<spring:message code="data.msg.length.3.errMsg"/>"
								data-msg-required="<spring:message code="my.account.phone.second.input.required.errMsg"/>">
							- <input type="text" name="phone3" class="phone3"
								value="${phoneNum3}" maxlength="4" numeric="true"
								data-msg-numeric="<spring:message code="data.msg.numeric.errMsg"/>"
								data-rule-minlength="4"
								data-msg-minlength="<spring:message code="data.msg.length.4.errMsg"/>"
								data-msg-required="<spring:message code="my.account.phone.third.input.required.errMsg"/>">
						</div>
					</fieldset>
				</div>

				<div class="row">
					<span class="title"><spring:message
							code="my.account.status.label" /></span>
					<p class="confirmation-status">${phnStatus}</p>
				</div>

				<div class="row">
					<button class="button-erefill green" type="submit"
						name="changephoneno_button">
						<spring:message code="my.account.change.phone.number.button" />
					</button>
					<button class="button-erefill border" type="reset">
						<spring:message code="my.account.reset.button" />
					</button>
					<span class="button-success"><spring:message
							code="my.account.phone.successMsg" /> </span> <span
						class="button-error"><spring:message
							code="my.account.phone.errorMsg" /></span> <span
						class="button-unsubscribe"><spring:message
							code="my.account.phone.unsubscribeMsg" /></span> <span
						class="button-invalid"><spring:message
							code="my.account.phone.invalidMsg" /></span> <span
						class="button-exception"><spring:message
							code="my.account.phone.exceptionMsg" /></span>
				</div>
			</div>

			<div class="column">
				<div class="width80">
					<div class="criteria margintop">
						<p>
							<strong><spring:message
									code="my.account.phone.instruction" /></strong>
						</p>
					</div>
					<div>
						<spring:message code="my.account.email.phone.consent.text" />
						<spring:message
							code="my.account.email.phone.consent.province.table" />
					</div>
				</div>
			</div>
		</div>
		<a href="#" class="scroll-link to-top"><spring:message
				code="scroll.back.to.top.label" /></a>
		<csrf:csrfToken />
	</form>
	<!-- form end -->

	<!-- form start -->
	<form
		class="form-details form-account-update bordertop padtop uniform form-validate section-questions"
		action="${contextPath}/${locale}/myaccount/securityquestions/update">

		<h2 class="title">
			<spring:message code="my.account.security.questions.label" />
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
					<label class="aoda_lbl" for="answer1"></label> <input
						type="password" autocomplete="off" class="form-security"
						name="answer1" id="answer1" data-rule-required="true"
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
					<label class="aoda_lbl" for="answer2"></label> <input
						type="password" autocomplete="off" id="answer2" name="answer2"
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
					<label class="aoda_lbl" for="answer3"></label> <input
						type="password" id="answer3" autocomplete="off"
						class="form-security" name="answer3" data-rule-required="true"
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
			<span class="button-success"><spring:message
					code="my.account.security.questions.successMsg" /> </span> <span
				class="button-error"><spring:message
					code="my.account.security.questions.errorMsg" /></span> <span
				class="button-exception"><spring:message
					code="my.account.security.questions.exceptionMsg" /></span>
		</div>
		<a href="#" class="scroll-link to-top"><spring:message
				code="scroll.back.to.top.label" /></a>
		<csrf:csrfToken />
	</form>
	<!-- form end -->

	<!-- form start -->
	<form
		class="form-details form-tax-receipt uniform bordertop section-tax-teceipt"
		action="${contextPath}/${locale}/myaccount/taxreceipt/report"
		data-download-error="<spring:message code="my.account.patient.tax.receipt.report.download.errMsg" />"
		data-cal-enable="<c:url value='/resources/images/erefill/icon-calendar.png'/>"
		data-cal-disable="<c:url value='/resources/images/erefill/icon-calendar-disabled.png'/>">

		<h2 class="title">
			<spring:message code="my.account.patient.tax.receipt.report.label" />
		</h2>
		<p>
			<spring:message
				code="my.account.patient.tax.receipt.report.option.header" />
		</p>

		<div class="err-msg"
			data-default-msg="<spring:message code="my.account.patient.tax.receipt.report.default.errMsg" />">
			<ul>
			</ul>
		</div>

		<div class="row">
			<label class="radio-item" for="tax-dates"> <input
				type="radio" id="tax-dates" name="tax-dates"
				data-rule-required="true"
				data-msg-required="<spring:message code="my.account.patient.tax.receipt.radio.option.required.errMsg" />"
				class="full-year" value="current-year"> <spring:message
					code="my.account.patient.tax.receipt.radio.option.full.year" />
			</label>
		</div>
		<div class="row date-range">
			<label class="radio-item" for="date-range"> <input
				type="radio" id="date-range" name="tax-dates"
				data-rule-required="true"
				data-msg-required="<spring:message code="my.account.patient.tax.receipt.radio.option.required.errMsg" />"
				class="radio-date-range" value="specified-range"> <spring:message
					code="my.account.patient.tax.receipt.radio.option.specified.range" />
			</label>
			<div class="date-range-group disabled">
				<fieldset>
					<legend class="aoda_lbl">Date range</legend>
					<label for="From"><spring:message code="from.label" />: <input
						title="From" id="From" type="text" class="date-from date-picker"
						name="from" value=""
						data-msg-required="<spring:message code="my.account.patient.tax.receipt.to.from.dates.required.errMsg" />"
						data-msg-malformed-date="<spring:message code="my.account.patient.tax.receipt.date.format.errMsg" />"
						data-msg-malformed-range="The From Date must come before or on the To Date"
						placeholder="${placeholder}" maxlength="10" /> </label> <label for="to"><spring:message
							code="to.label" />: <input title="To" type="text"
						class="date-to date-picker" name="to" value=""
						data-msg-required="<spring:message code="my.account.patient.tax.receipt.to.from.dates.required.errMsg" />"
						data-msg-malformed-date="<spring:message code="my.account.patient.tax.receipt.date.format.errMsg" />"
						placeholder="${placeholder}" maxlength="10" /> </label>
				</fieldset>
			</div>
		</div>
		<div class="row">
			<div class="checkbox-item">
				<label for="excludemed"> <input type="checkbox"
					id="excludemed" name="exclude-medication"> <spring:message
						code="my.account.patient.tax.receipt.checkbox.message" />
				</label>
			</div>
		</div>

		<div class="row">
			<button class="button-erefill green" type="submit"
				name="downloadtaxreceipt_button">
				<spring:message code="my.account.download.tax.receipt.report.button" />
			</button>
			<button class="button-erefill border" type="reset">
				<spring:message code="my.account.reset.button" />
			</button>
			<span class="button-success"><spring:message
					code="my.account.tax.receipt.report.successMsg" /> </span> <span
				class="button-error"><spring:message
					code="my.account.tax.receipt.report.errorMsg" /></span> <span
				class="button-exception"><spring:message
					code="my.account.tax.receipt.report.exceptionMsg" /></span> <span
				class="adobe-reader"><spring:message
					code="adobe.reader.required" /></span>
		</div>
		<div class="row">
			<div class="no-adobe-reader hiddenErrorMessage">
				<spring:message code="adobe.reader.required" />
			</div>
		</div>
		<a href="#" class="scroll-link to-top"><spring:message
				code="scroll.back.to.top.label" /></a>
		<csrf:csrfToken />
	</form>
	<!-- form end -->

	<hr />

	<div class="columns col2" id="form-terms-close">
		<div class="column">
			<div class="column-inner dividerright section-terms-of-use">
				<h2 class="title">
					<spring:message code="my.account.terms.of.use.title.label" />
				</h2>
				<div class="row">
					<div class="criteria">
						<p>${termsofUseText}</p>
					</div>
				</div>
				<div class="row">
					<a class="button-erefill green modal btn-revoke" href="#"
						data-modal="${contextPath}/${locale}/myaccount/consent/revoke/view" role="button">
						<spring:message code="my.account.revoke.button" />
					</a>
				</div>
			</div>
		</div>

		<div class="column">
			<div class="column-inner width80 section-close-account">
				<h2 class="title">
					<spring:message code="my.account.close.title.label" />
				</h2>
				<div class="row">
					<div class="criteria">
						<p>
							<spring:message code="my.account.close.account.text" />
						</p>
					</div>
				</div>
				<div class="row">
					<a class="button-erefill green modal btn-closeacc" href="#"
						data-modal="${contextPath}/${locale}/myaccount/account/close/view" role="button">
						<spring:message code="my.account.close.button" />
					</a>
				</div>
			</div>
		</div>
		<a href="#" class="scroll-link to-top"><spring:message
				code="scroll.back.to.top.label" /></a>
	</div>
</div>