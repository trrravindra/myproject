<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="overlay-wrap">
	<div class="inner">
		<div class="overlay">

			<div class="auto-refill-opted-in" role="dialog" tabIndex="0"
				aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
				<c:choose>
					<c:when test="${isLoggedInUser}">
						<div class="header">
							<h1 class="title" id=overlayTitle>
								<spring:message code="auto.refill.overlay.error.title.label" />
							</h1>
						</div>
					</c:when>
					<c:otherwise>
						<div class="header">
							<h1 class="title" id="overlayTitle">
								<spring:message
									code="auto.refill.overlay.error.custodian.title.label"
									arguments='<span class="impersonatedTitle"></span>' />
							</h1>
						</div>
					</c:otherwise>
				</c:choose>
				<div class="inner-content" id="overlayDesc">
					<p>
						<spring:message code="auto.refill.overlay.error.text" />
					</p>
					<p>
					<p class="0 hiddenErrorMessage">
						<spring:message code="auto.refill.overlay.error.text.0" />
					</p>
					<p class="3003 hiddenErrorMessage">
						<spring:message code="auto.refill.overlay.error.text.expired.3003" />
					</p>
					<p class="3002 hiddenErrorMessage">
						<spring:message code="auto.refill.overlay.error.text.aborted.3002" />
					</p>
					<p class="3004 hiddenErrorMessage">
						<spring:message code="auto.refill.overlay.error.text.repeat.3004" />
					</p>
					<p class="535 hiddenErrorMessage">
						<spring:message code="auto.refill.overlay.error.text.deceased.535" />
					</p>
					<p class="3025 hiddenErrorMessage">
						<spring:message
							code="auto.refill.overlay.error.text.alreadyexist.3025" />
					</p>
					</p>
					<a class="cancel" href="#"><spring:message code="cancel.label" /></a>
				</div>
			</div>

		</div>
	</div>
</div>
<div class="overlay-screen">
	<div></div>
</div>

