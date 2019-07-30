<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="csrf" uri="csrf-tags"%>

<div class="overlay-wrap">
	<div class="inner">
		<div class="overlay">
			<div class="auto-refill-opted-in" role="dialog" tabIndex="0"
				aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
				<div class="header">
					<h1 class="title" id="overlayTitle">
						<spring:message code="confirm.auto.refill.overlay.title.label" />
					</h1>
				</div>
				<div class="inner-content" id="overlayDesc">
					<p>
						<spring:message code="confirm.auto.refill.overlay.reminder.text" />
					</p>
					<p>
						<spring:message code="refill.request.notify.email.label" />
						<c:choose>
							<c:when test="${not empty account}">
								<c:if test="${not empty emailStatus}">
									<c:choose>
										<c:when
											test="${emailStatus=='OK'||emailStatus=='Ok'||emailStatus=='ok'}">
											<strong>${account}</strong>
										</c:when>
										<c:otherwise>
											<spring:message code="refill.request.notify.email.unchecked" />
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:when>
							<c:otherwise>
								<spring:message code="refill.request.notify.noemail" />
							</c:otherwise>
						</c:choose>
						<br />
						<spring:message code="refill.request.notify.mobile.label" />
						<c:if
							test="${not empty entityPatient.phoneNumber && fn:length(entityPatient.phoneNumber) == 10}">
							<strong>(${fn:substring(entityPatient.phoneNumber, 0,
								3)})&nbsp;
								${fn:substring(entityPatient.phoneNumber, 3, 6)}-
								${fn:substring(entityPatient.phoneNumber, 6, 10)}</strong>
						</c:if>
					</p>
					<p>
						<spring:message
							code="confirm.auto.refill.overlay.description.text" />
					</p>
					<form class="form-details uniform"
						action="#CLOSE-AUTO-REFILL-OPTED-IN">
						<button class="button-erefill green" type="submit">
							<spring:message code="continue.label" />
						</button>
						<csrf:csrfToken />
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="overlay-screen">
	<div></div>
</div>





