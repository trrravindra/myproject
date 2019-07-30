<%@ include file="global.jsp"%>
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

Locale localeObj = new Locale("en", "CA");
if (locale != null && "fr_CA".equalsIgnoreCase(locale)) {
	localeObj = new Locale("fr", "CA");
}
ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource=new ReloadableResourceBundleMessageSource();
reloadableResourceBundleMessageSource.setBasename("classpath:/i18n/messages");
String tandcDesc = UriUtils.decode(reloadableResourceBundleMessageSource.getMessage("my.managed.account.accept.custodianship.overlay.termsconditions.description", null, localeObj),"UTF-8");
%>

<div class="custodian accept-being-custodian " role="dialog"
	tabIndex="0" aria-labelledby="overlayTitle"
	aria-describedby="overlayDesc">

	<div class="header">
		<h1 class="title" id="overlayTitle">
			<spring:message
				code="my.managed.account.accept.custodianship.overlay.title" />
		</h1>
	</div>

	<div class="inner-content" id="overlayDesc">

		<p>
			<spring:message
				code="my.managed.account.accept.custodianship.overlay.description" />
		</p>
		<p>
			<spring:message code="my.managed.account.name.label" />
			:&nbsp;<strong>${name}</strong><br />
			<spring:message code="my.managed.account.relationship.label" />
			:&nbsp;<strong><spring:message code="${relationship}"
					text="${relationship}" /></strong>
		</p>

		<form class="form-details accept-request uniform"
			action="${contextPath}/${locale}/managedaccount/acceptRequest"
			method="post"
			data-success-overlay="${contextPath}/${locale}/managedaccount/acceptRequest/success"
			data-error-overlay="${contextPath}/${locale}/managedaccount/acceptRequest/failure">
			<div class="err-msg"
				data-default-msg="<spring:message code='my.managed.account.custodianship.required.error.msg' />"
				tabIndex="0">
				<ul>
				</ul>
			</div>

			<h2 class="title">
				<spring:message
					code="my.managed.account.accept.custodianship.overlay.termsconditions.title" />
			</h2>

			<div class="row">
				<textarea class="terms" readonly="readonly">
	            <%-- <spring:message code="my.managed.account.accept.custodianship.overlay.termsconditions.description" arguments="${contextPath}"/> --%>
	            		<%=tandcDesc%>
	            </textarea>

			</div>

			<!-- terms agree -->
			<div class="row consent">
				<label class="erefill-radio small"> <input type="checkbox"
					class="radio-agree check-required" name="terms" value="accept" />
					<c:choose>
						<c:when test="${not empty consentAgreement}">${consentAgreement}<span>*</span>
						</c:when>
						<c:otherwise>
							<spring:message
								code="my.managed.account.accept.custodianship.overlay.termsconditions.checkbox1" />
						</c:otherwise>
					</c:choose>

				</label>
			</div>
			<c:set var="requestorName" value="${name}" />
			<div class="row">
				<label class="erefill-check small"> <input type="checkbox"
					class="check-accept-authority check-required" name="confirm"
					value="accept" /> <spring:message var="checkbox"
						code="my.managed.account.accept.custodianship.overlay.termsconditions.checkbox2" />
					<c:set var="checkbox"
						value="${fn:replace(checkbox,'[name]',requestorName)}" /> <c:set
						var="checkbox"
						value="${fn:replace(checkbox,'[application]','eRefill')}" />
					${checkbox}
				</label>
			</div>

			<input type="hidden" name="requestorUserName" value="${username}" />
			<input type="hidden" name="consentOID" value="${consentOid}" />

			<button class="button-erefill green disabled" type="submit">
				<spring:message code="my.managed.account.accept.request.label" />
			</button>

			<a class="button-erefill link cancel" href="#" role="button"><spring:message
					code="cancel.label" /></a>

			<csrf:csrfToken />
		</form>


	</div>

</div>