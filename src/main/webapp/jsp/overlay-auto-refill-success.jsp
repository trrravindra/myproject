<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="csrf" uri="csrf-tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="overlay-wrap">
	<div class="inner disableinner">
		<div class="overlay">

			<div class="overlay-refill-request-success" role="dialog"
				tabIndex="0" aria-labelledby="overlayTitle"
				aria-describedby="overlayDesc">
				<c:choose>
					<c:when test="${isLoggedInUser}">
						<div class="header">
							<h1 class="title" id="overlayTitle">
								<spring:message code="auto.refill.overlay.success.title.label" />
							</h1>
						</div>
					</c:when>
					<c:otherwise>
						<div class="header">
							<h1 class="title" id="overlayTitle">
								<spring:message
									code="auto.refill.overlay.success.custodian.title.label"
									arguments='<span class="impersonatedTitle"></span>' />
							</h1>
						</div>
					</c:otherwise>
				</c:choose>

				<div class="inner-content" id="overlayDesc">
					{{?it.content.deliveryChoice=="Pickup"}}
					<p>
						<spring:message code="auto.refill.overlay.success.pickup.text" />
					</p>
					{{?}} {{?it.content.deliveryChoice=="Delivery"}}
					<p>
						<spring:message code="auto.refill.overlay.success.delivery.text" />
					</p>
					{{?}}

					<p>
						<strong>{{=it.content.date}}</strong>&nbsp;&nbsp;&nbsp; <span>
							<spring:message code="refill.request.note.label" /> <spring:message
								code="auto.refill.overlay.success.date.disclaimer.text" />
						</span>
					</p>

					{{?it.content.email!="" || it.content.mobile!=""}}
					<p>
						<spring:message code="auto.refill.overlay.success.reminder.text" />
					</p>
					{{?}}

					<p>
						{{?it.content.email!=""}}
						<spring:message code="refill.reminder.overlay.success.email.label" />
						<strong>{{=it.content.email}}</strong><br /> {{?}}

						{{?it.content.mobile!=""}}
						<spring:message code="refill.request.notify.mobile.label" />
						
						&nbsp;<strong>{{=it.content.mobile.toString().substring(0,3)}}-{{=it.content.mobile.toString().substring(3,6)}}-{{=it.content.mobile.toString().substring(6,10)}} </strong>
												
						{{?}}
					</p>

					<form class="form-details uniform"
						action="${contextPath}/${locale}/prescription/details"
						method="POST">
						<input type="hidden" id="page_num" name="page_num"
							value="{{=it.content.page_num}}" />
						<button class="button-erefill green no-click-button" type="submit">
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




