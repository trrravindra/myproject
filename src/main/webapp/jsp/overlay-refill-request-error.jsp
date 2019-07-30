<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="overlay-wrap">
	<div class="inner disableinner">
		<div class="overlay">
			<div class="overlay-refill-request-success">
				<c:choose>
					<c:when test="${isLoggedInUser}">
						<div class="header">
							<h1 class="title">
								<spring:message code="refill.request.erroroverlay.title" />
							</h1>
						</div>
					</c:when>
					<c:otherwise>
						<div class="header">
							<h1 class="title">
								<spring:message
									code="refill.request.erroroverlay.custodian.title"
									arguments='<span class="impersonatedTitle"></span>' />
							</h1>

						</div>
					</c:otherwise>
				</c:choose>
				<div class="inner-content">
					<p>
						<spring:message code="refill.request.erroroverlay.msg" />
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



