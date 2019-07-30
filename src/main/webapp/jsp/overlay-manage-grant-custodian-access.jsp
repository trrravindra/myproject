<%@ include file="global.jsp"%>
<head>
<meta charset="utf-8">
</head>
<div class="custodian grant-access" role="dialog" tabIndex="0"
	aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
	<div class="header">
		<h1 class="title" id="overlayTitle">
			<spring:message
				code="my.managed.account.grant.custodianship.overlay.title" />
		</h1>
	</div>

	<div class="inner-content" id="overlayDesc">
		<p>
			<spring:message
				code="my.managed.account.grant.custodianship.overlay.description" />
		</p>
		<form class="form-details uniform grant-access"
			action="${contextPath}/${locale}/managedaccount/grantAccess"
			method="post" data-access-error=""
			data-error-overlay="${contextPath}/${locale}/managedaccount/grantAccess/error"
			data-success-overlay="${contextPath}/${locale}/managedaccount/grantAccess/success"
			data-cal-enable="<c:url value='/resources/images/erefill/icon-calendar.png'/>"
			data-cal-disable="<c:url value='/resources/images/erefill/icon-calendar-disabled.png'/>">
			<div class="err-msg"
				data-default-msg="<spring:message code='my.managed.account.custodianship.required.error.msg' />"
				tabIndex="0">
				<ul>
				</ul>
				<p class="536 hiddenErrorMessage" tabIndex="0">
					<spring:message code="my.managed.account.invalid.username" />
				</p>
				<p class="mismatch hiddenErrorMessage" tabIndex="0">
					<spring:message code="invalid.username.dob" />
				</p>
			</div>
			<p class="required-fields">
				<span>*</span>
				<spring:message code="required.field.label" />
			</p>
			<div class="row">
				<label class="title" for="username"> <spring:message
						code="user.id.label" /><span>*</span> <input type="text"
					id="username" name="username" alphanumeric="true"
					data-msg-alphanumeric="<spring:message code='my.account.user.name.aphanumeric.errMsg' />"
					data-rule-required="true"
					data-msg-required="<spring:message code='custodian.minor.user.name.required.errMsg' />"
					value="" />
				</label>
			</div>
			<div class="row">
				<label class="date-selector" for="dob"> <spring:message
						code="dob.label" /><span>*</span> <input type="text" id="dob"
					class="date-of-birth-date-picker date-select" title="Date Of Birth"
					name="date-of-birth-date" value=""
					placeholder="<spring:message code='date.format' />" maxlength="10"
					data-rule-required="true"
					data-msg-required="<spring:message code='dob.required.errormsg' />"
					data-msg-malformed-date="<spring:message code='dob.format.errormsg' />" />
				</label>
			</div>
			<div class="row">
				<label class="title" for="relationship"> <spring:message
						code="relationship.to.you.label" /><span>*</span> <select
					name="relationship" id="relationship" class="relationship"
					data-rule-required="true"
					data-msg-required="<spring:message code='my.managed.account.relationship' />">
						<option selected="selected" disabled="disabled" value="r0"><spring:message code="select.label" /></option>
						<option value="r1"><spring:message code="friend.label" /></option>
						<option value="r2"><spring:message code="child.label" /></option>
						<option value="r3"><spring:message code="parent.label" /></option>
						<option value="r4"><spring:message code="spouse.label" /></option>
						<option value="r5"><spring:message code="sibling.label" /></option>
						<option value="r6"><spring:message
								code="legalguardian.label" /></option>
						<option value="r7"><spring:message code="caregiver.label" /></option>
						<option value="r8"><spring:message code="other.label" /></option>
				</select>
				</label>
			</div>
			<div class="row">
				<label class="erefill-check small" for="chkaccept"> <input
					type="checkbox" id="chkaccept" class="check-consent check-required" />
					<c:choose>
						<c:when test="${not empty consentAgreement}">${consentAgreement}<span>*</span>
						</c:when>
						<c:otherwise>
							<spring:message
								code="my.managed.account.grant.custodianship.overlay.checkbox" />
						</c:otherwise>
					</c:choose>

				</label>
			</div>
			<input type="hidden" name="consentOID" value="${consentOid}" />
			<button class="button-erefill green disabled" type="submit">
				<spring:message code="submit.button.label" />
			</button>
			<a class="button-erefill link cancel" href="#" role="button"><spring:message
					code="cancel.label" /></a>
			<csrf:csrfToken />
		</form>
	</div>
</div>
<a class="close" href="#"><spring:message code="close.button.label" /></a>
