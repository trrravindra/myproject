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
		<label class="registration-note"><span><spring:message
					code="registration.note.label" /></span>
		<spring:message code="registration.message.label" /></label>
		<%@include file="progressTracker.jsp"%>
	</div>

	<form action="${contextPath}/${locale}/registration/identity/validate"
		class="form-details uniform form-dob" method="post">

		<label class="title"> <spring:message
				code="registration.dob.title.label" />
		</label>

		<c:choose>
			<c:when test="${mismatch eq error}">
				<label class="error"><spring:message
						code="registration.dob.mismatch.errorMsg" /></label>
			</c:when>
			<c:otherwise>
				<c:if test="${eAccountLocked eq error}">
					<div class="overlay-wrap" style="top: 0px; display: block;">
						<div class="inner">
							<div class="overlay">
								<div class="overlay-refill-request-success">
									<div class="header">
										<h1 class="title">
											<spring:message
												code="registration.account.locked.popup.errorMsg" />
										</h1>
									</div>
									<div class="inner-content">
										<p>
											<spring:message code="registration.account.locked.errorMsg" />
										</p>
										<a href="<c:url value='/${locale}/user/logout'></c:url>"
											class="button-erefill green cancel no-click"><spring:message
												code="registration.continue.button.label" /></a>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="overlay-screen" style="top: 0px; display: block;">
						<div></div>
					</div>
				</c:if>
			</c:otherwise>
		</c:choose>

		<div class="multi">
			<select name="year" data-rule-required="true"
				data-msg-required="<spring:message code="registration.year.required.errMsg" />">
				<option value="">
					<spring:message code="registration.dob.year.label" />
				</option>
				<c:forEach var="i" begin="0" end="125">
					<option value="${currentYear-i}">${currentYear-i}</option>
				</c:forEach>
			</select> <select name="month" data-rule-required="true"
				data-msg-required="<spring:message code="registration.month.required.errMsg" />">
				<option value="">
					<spring:message code="registration.dob.month.label" />
				</option>
				<option value="01">
					<spring:message code="month.jan.label" /></option>
				<option value="02">
					<spring:message code="month.feb.label" /></option>
				<option value="03">
					<spring:message code="month.mar.label" /></option>
				<option value="04">
					<spring:message code="month.apr.label" /></option>
				<option value="05">
					<spring:message code="month.may.label" /></option>
				<option value="06">
					<spring:message code="month.jun.label" /></option>
				<option value="07">
					<spring:message code="month.jul.label" /></option>
				<option value="08">
					<spring:message code="month.aug.label" /></option>
				<option value="09">
					<spring:message code="month.sep.label" /></option>
				<option value="10">
					<spring:message code="month.oct.label" /></option>
				<option value="11">
					<spring:message code="month.nov.label" /></option>
				<option value="12">
					<spring:message code="month.dec.label" /></option>
			</select> <select name="day" data-rule-required="true"
				data-msg-required="<spring:message code="registration.year.required.errMsg" />">
				<option value="">
					<spring:message code="registration.dob.day.label" />
				</option>
				<option value="01">01</option>
				<option value="02">02</option>
				<option value="03">03</option>
				<option value="04">04</option>
				<option value="05">05</option>
				<option value="06">06</option>
				<option value="07">07</option>
				<option value="08">08</option>
				<option value="09">09</option>
				<c:forEach var="i" begin="10" end="31">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
		</div>

		<div class="navbottom">
			<button class="button-erefill green" type="submit" disabled
				aria-describedby="button-hint">
				<spring:message code="registration.continue.button.label" />
			</button>
			<label class="button-hint" id="button-hint"> </label>
		</div>
		<csrf:csrfToken />
	</form>
</div>