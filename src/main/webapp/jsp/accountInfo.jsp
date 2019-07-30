<%@ include file="global.jsp"%>

<script id="require-js"
	data-main="<c:url value='/resources/js/erefill-form-details.js'/>"
	src="<c:url value='/resources/js/vendor/require.js'/>"
	data-context='<%=request.getContextPath()%>'></script>


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

	<form action="${contextPath}/${locale}/registration/accountinfo/update"
		method="post" class="form-details uniform form-validate">

		<c:choose>
			<c:when test="${'dupUser' eq error}">
				<div class="error error-msg"
					style="display: block; font-weight: bold;">
					<spring:message
						code="registration.account.info.username.exists.errMsg" />
				</div>
			</c:when>
			<c:otherwise>
				<div class="title error error-msg">
					<spring:message code="registration.account.info.common.errMsg" />
				</div>
			</c:otherwise>
		</c:choose>

		<div class="columns col5">
			<div class="column span2">
				<div class="row">
					<label class="title" for="username"> <spring:message
							code="registration.account.info.username.label" /><span>*</span>
						<input type="text" id="username" name="username"
						value="${username}" alphanumeric="true"
						data-msg-alphanumeric="<spring:message	code="my.account.user.name.aphanumeric.errMsg" />"
						data-rule-required="true"
						data-msg-required="<spring:message	code="registration.account.info.username.required.errMsg" />"
						maxlength="100" />
					</label>
				</div>
			</div>
			<div class="column span3">
				<div class="width80">
					<div class="criteria margintop">
						<spring:message
							code="registration.account.info.username.instruction" />
					</div>
				</div>
			</div>
		</div>
		<hr />


		<!--  Hiding the input password field: moved to security question page -->
		<!-- <div class="columns col5">
			<div class="column span2">
				<div class="row">
					<label class="title"> <spring:message
							code="registration.account.info.password.label" /><span>*</span>
						<c:if test="${'pwdError' eq error}">
							<div class="error error-msg"
								style="display: block; font-weight: bold;">
								<spring:message	code="my.account.password.criteria.fail.errMsg" />
							</div>
						</c:if>
		 				<input class="new-password" type="password" autocomplete="off"
						name="newPassword" maxlength="32"
						data-rule-upperlowerspecialchar="true"
						data-msg-upperlowerspecialchar="<spring:message	code="my.account.password.criteria.fail.errMsg" />"
						data-rule-minlength="8"
						data-msg-minlength="<spring:message	code="my.account.password.criteria.fail.errMsg" />"
						data-rule-required="true"
						data-msg-required="<spring:message	code="my.account.new.password.required.errMsg" />" />
					</label>
				</div>

				<div class="row">
					<label class="title"> <spring:message
							code="registration.account.info.confirm.password.label" /><span>*</span>
						<input type="password" autocomplete="off" name="confirmpassword"
						maxlength="32" data-rule-equalto=".new-password"
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
		</div> -->

		<hr class="invisible" />

		<div class="columns col5">
			<div class="column span2">
				<div class="row">
					<label class="title" for="email"> <spring:message
							code="registration.account.info.email.label" /> <c:choose>
							<c:when test="${'dupUser' eq error || 'pwdError' eq error }">
								<c:choose>
									<c:when test="${not empty email}">
										<input type="text" id="email" name="email" value="${email}"
											data-rule-email="true"
											data-msg-email="<spring:message code="my.account.email.criteria.fail.errMsg" />"
											maxlength="100" />
									</c:when>
									<c:otherwise>
										<input type="text" id="email" name="email"
											data-rule-email="true"
											data-msg-email="<spring:message code="my.account.email.criteria.fail.errMsg" />"
											maxlength="100" />
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<input type="text" id="email" name="email" value="${email}"
									data-rule-email="true"
									data-msg-email="<spring:message code="my.account.email.criteria.fail.errMsg" />"
									maxlength="100" />
							</c:otherwise>
						</c:choose>
					</label>
				</div>
			</div>

			<div class="column span3">
				<div class="width80">
					<div class="criteria margintop">
						<spring:message code="registration.account.info.email.instruction" />
						<p>
							<br />
						</p>
						<spring:message code="my.account.email.phone.consent.text" />
						<spring:message
							code="my.account.email.phone.consent.province.table" />
					</div>
				</div>
			</div>
		</div>

		<!-- content-navbottom-button placeholder -->

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