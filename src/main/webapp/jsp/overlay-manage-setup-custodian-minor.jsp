<%@ include file="global.jsp"%>

<%@ page import="java.net.URLDecoder"%>
<%@ page import="java.util.Locale,org.springframework.web.util.UriUtils"%>

<head>
<meta charset="utf-8">
</head>
<%
String requestUri = (String)request.getAttribute("javax.servlet.forward.request_uri");
String locale = "";
	if (null != requestUri) {
		if(requestUri.contains("en_CA")){
			locale="en_CA";
		}else if(requestUri.contains("fr_CA")){
			locale="fr_CA";
		}
	}
%>

<div class="custodian setup-custodianship" role="dialog" tabIndex="0"
	aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
	<div class="header">
		<h1 class="title" id="overlayTitle">
			<spring:message
				code="my.managed.account.minor.custodianship.overlay.title" />
		</h1>
	</div>
	<div class="inner-content" id="overlayDesc">
		<div class="loader hidden">
			<spring:message code="loading.label" />
		</div>
		<%-- <div class="form-step-2 hidden"><h2 class="title"><spring:message code="my.managed.account.minor.custodianship.overlay.successmsg" /></h2></div> --%>

		<form class="form-details custodian-minor uniform"
			action="${contextPath}/${locale}/managedaccount/setupCustodianForMinor"
			method="post"
			data-home-url="${contextPath}/${locale}/managedaccount/details"
			data-access-error=""
			data-error-overlay="${contextPath}/${locale}/managedaccount/setupCustodianForMinor/error"
			data-success-overlay="${contextPath}/${locale}/managedaccount/setupCustodianForMinor/success"
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
				<p class="invalidpassword hiddenErrorMessage" tabIndex="0">
					<spring:message code="invalid.username.pwd" />
				</p>
				<p class="mismatch hiddenErrorMessage" tabIndex="0">
					<spring:message code="invalid.username.dob" />
				</p>

			</div>
			<p>
				<spring:message var="desc"
					code="my.managed.account.minor.custodianship.overlay.description" />
				<%-- <c:set var="desc" value="${fn:replace(desc,'[age]',minorAgeLimit)}" /> --%>
				${desc}
			</p>

			<p class="required">
				<span>*</span><strong><spring:message
						code="required.field.label" /></strong>
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
				<label class="title" for="password"> <spring:message
						code="temporary.password.label" /><span>*</span> <span
					class="tooltip" aria-describedby="minorTip" tabIndex="0"><img
						src="<c:url value='/resources/images/erefill/icon-tooltip.png'/>"
						alt="tooltip"> <span class="tooltip-content" id="minorTip">
							<h3>
								<spring:message
									code="my.managed.account.minor.custodianship.overlay.tooltiptitle" />
							</h3>
							<p>
								<spring:message var="tooltipdesc"
									code="my.managed.account.minor.custodianship.overlay.tooltipdesc" />
								<%-- <c:set var="tooltipdesc" value="${fn:replace(tooltipdesc,'[age]',minorAgeLimit)}" /> --%>
								${tooltipdesc}
							</p>
					</span> </span> <input type="password" id="password" name="password"
					alphanumeric="true"
					data-msg-alphanumeric="<spring:message code='my.account.user.name.aphanumeric.errMsg' />"
					data-rule-required="true"
					data-msg-required="<spring:message code='password.required.errormsg' />"
					data-invalid-password="<spring:message code='invalid.pwd.errmsg' />"
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
						<option selected="selected" disabled="disabled" value="mr0"><spring:message code="select.label" /></option>
						<option value="mr1"><spring:message code="child.label" /></option>
						<option value="mr2"><spring:message
								code="legalguardian.label" /></option>
						<option value="mr3"><spring:message
								code="caregiver.label" /></option>
						<option value="mr4"><spring:message code="other.label" /></option>
				</select>
				</label>
			</div>

			<h2 class="title required">
				<spring:message
					code="my.managed.account.minor.custodianship.overlay.termsconditions.title" />
			</h2>
			<%
			Locale localeObj = new Locale("en", "CA");
				if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
					localeObj = new Locale("fr", "CA");
				}
			ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource=new ReloadableResourceBundleMessageSource();
			reloadableResourceBundleMessageSource.setBasename("classpath:/i18n/messages");

			String tandcDesc = UriUtils.decode(reloadableResourceBundleMessageSource.getMessage("my.managed.account.minor.custodianship.overlay.termsconditions.description", null, localeObj),"UTF-8");
			%>
			<div class="row">
				<textarea cols="100" rows="20" readonly="readonly" class="terms">
	            <%=tandcDesc%>
				</textarea>

			</div>

			<div class="row">
				<label class="erefill-check small" for="checkaccept"> <input
					type="checkbox" id="checkaccept"
					class="check-accept-authority check-required" /> <spring:message
						code="my.managed.account.minor.custodianship.overlay.termsconditions.checkbox" /><span>*</span>
				</label>
			</div>
			<input type="hidden" name="consentOID" value="${consentOid}" />

			<button class="button-erefill green disabled" type="submit">
				<spring:message code="confirm.label" />
			</button>

			<a class="button-erefill link cancel" href="#" role="button"><spring:message
					code="my.managed.account.minor.custodianship.overlay.cancel.label" /></a>
			<csrf:csrfToken />
		</form>
	</div>

</div>
<a class="close" href="#"><spring:message code="close.button.label" /></a>



