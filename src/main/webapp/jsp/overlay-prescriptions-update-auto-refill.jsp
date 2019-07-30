<%@ include file="global.jsp"%>

<div class="update-auto-refill" role="dialog" tabIndex="0"
	aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
	<div class="header">
		<h1 class="title" id="overlayTitle">
			<spring:message
				code="update.auto.refill.reminder.overlay.title.label" />
		</h1>
	</div>
	<div class="inner-content" id="overlayDesc">
		<p>
			<spring:message
				code="update.auto.refill.reminder.overlay.notification.text" />
		</p>
		<form class="form-details uniform" method="post"
			action="${contextPath}/${locale}/autorefill/update"
			data-opt-out="${contextPath}/${locale}/autorefill/optout"
			data-error="${contextPath}/${locale}/autorefill/updateerror">

			<input id="<%=ERefillConstants.AUTO_REFILL_OID%>"
				name="<%=ERefillConstants.AUTO_REFILL_OID%>" value="${oid}"
				type="hidden" />
			<div class="refill-notify">
				<div class="checkbox-item  myacc-email">
					<label> <c:choose>
							<c:when test="${not empty selectedEmail}">
								<input type="checkbox" name="emailnotifypresc" checked>
								<input type="hidden" name="emailpresc" value="${selectedEmail}">
								<spring:message code="refill.request.notify.email.label" />
								<strong>${selectedEmail}</strong>
							</c:when>
							<c:otherwise>
								<input type="checkbox" name="emailnotifypresc" disabled>
								<div class="update-noemail">
									<spring:message code="refill.request.notify.email.label" />
									<spring:message code="update.auto.refill.no.email.text" />
								</div>
							</c:otherwise>
						</c:choose>
					</label>
				</div>
				<div class="checkbox-item mycust-email">
					<label> <c:choose>
							<c:when test="${not empty emailId}">
								<c:if test="${not empty emailStatus}">
									<c:choose>
										<c:when test="${fn:containsIgnoreCase(emailStatus, 'OK')}">
											<input type="checkbox" name="emailnotifyuser">
											<spring:message code="refill.request.notify.email.label" />
											<strong>${emailId}</strong>
											<input id="email" name="emailuser" value="${emailId}"
												type="hidden" />
										</c:when>
										<c:otherwise>
											<input type="checkbox" name="emailnotifyuser" disabled>
											<spring:message code="refill.request.notify.email.label" />
											<spring:message code="update.auto.refill.verify.email.updated.text" />
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:when>
							<c:otherwise>
								<input type="checkbox" name="emailnotifyuser" disabled>
								<div class="update-noemail">
									<spring:message code="refill.request.notify.email.label" />
									<spring:message code="update.auto.refill.no.email.updated.text"
										arguments="${contextPath}" />
								</div>
							</c:otherwise>
						</c:choose>
					</label>
				</div>
				<c:if test="${userRole ne 'Caregivers'}">
					<!-- Mobile number in prescription   -->
					<div class="checkbox-item  myacc-mob">
						<label> <c:choose>
								<c:when test="${not empty selectedPhone}">
									<input type="checkbox" name="mobilenotifypresc" checked>
									<input type="hidden" value="${selectedPhone}" id="mobilepresc"
										name="mobilepresc" />
									<div>
										<spring:message code="phone.label" />
										<strong>${fn:substring(selectedPhone, 0, 3)}-${fn:substring(selectedPhone, 3, 6)}-${fn:substring(selectedPhone, 6, 10)}</strong>
									</div>
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="mobilenotifypresc" disabled>
									<div class="update-nomobile">
										<spring:message code="phone.label" />
										<spring:message code="update.auto.refill.no.mobile.text" />
									</div>
								</c:otherwise>
							</c:choose>
						</label>
					</div>

					<!-- Mobile number of logged in user   -->
					<div class="checkbox-item mycust-mob">
						<label> <c:choose>
								<c:when test="${not empty mobileNumber}">
									<c:if test="${not empty mobileStatus}">
										<c:choose>
											<c:when test="${mobileStatus == 0}">
												<input type="checkbox" name="mobilenotifyuser">
												<input type="hidden" value="${mobileNumber}"
													name="mobileuser" />
												<div>
													<spring:message code="phone.label" />
													<strong>${fn:substring(mobileNumber, 0, 3)}-${fn:substring(mobileNumber, 3, 6)}-${fn:substring(mobileNumber, 6, 10)}</strong>
												</div>
											</c:when>
											<c:when test="${mobileStatus== 1}">
												<input type="checkbox" name="mobilenotifyuser" disabled>
												<div class="update-nomobile">
													<spring:message code="phone.label" />
													<spring:message
														code="update.auto.refill.verify.mobile.updated.text" />
												</div>
											</c:when>
											<c:when test="${mobileStatus== 2}">
												<input type="checkbox" name="mobilenotifyuser" disabled>
												<div class="update-nomobile">
													<spring:message code="phone.label" />
													<spring:message
														code="update.auto.refill.no.mobile.updated.text"
														arguments="${contextPath}" />
												</div>
											</c:when>
										</c:choose>
									</c:if>
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="mobilenotifyuser" disabled>
									<div class="update-nomobile">
										<spring:message code="phone.label" />
										<spring:message code="update.auto.refill.no.mobile.updated.text" arguments="${contextPath}" />
									</div>
								</c:otherwise>
							</c:choose>
						</label>
					</div>
				</c:if>
			</div>

			<div class="auto-update">
				<a href="" class="auto-update-email"><spring:message
						code="update.auto.refill.update.email.label" /></a><br />
				<c:if test="${userRole ne 'Caregivers'}">
					<a href="" class="auto-update-mobile"><spring:message
							code="update.auto.refill.update.phone.label" /></a>
				</c:if>
			</div>
			<p></p>

			<div class="form-footer">
				<button class="button-erefill green no-click-button" type="submit">
					<spring:message code="submit.button.label" />
				</button>

				<a class="button-erefill link cancel" href="#" role="button"><spring:message
						code="cancel.button.label" /></a>
			</div>
			<csrf:csrfToken />
		</form>
	</div>
</div>
