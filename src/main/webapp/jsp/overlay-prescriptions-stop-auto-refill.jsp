<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="csrf" uri="csrf-tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="overlay-wrap">
	<div class="inner">
		<div class="overlay">
			<div class="stop-auto-reffil" role="dialog" tabIndex="0"
				aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
				<div class="header">
					<h1 class="title" id="overlayTitle">
						<spring:message code="stop.auto.refill.overlay.title.label" />
					</h1>
				</div>
				<div class="inner-content" id="overlayDesc">
					<p>
						<strong><span>{{=it.content.name}}</span>,
							({{=it.content.strength}}), Quantity:
							{{=it.content.quantityfilled}} <span>, {{=it.content.sig}}</span>
						</strong>
					</p>
					<p>
						<spring:message code="stop.auto.refill.overlay.description.text" />
					</p>
					<form class="form-details uniform"
						action="${contextPath}/${locale}/autorefill/stop" method="post"
						data-home="${contextPath}/${locale}/prescription/details"
						data-pagenum="{{=it.content.page_num}}"
						data-error="${contextPath}/${locale}/autorefill/updateerror">
						<input type="hidden" id="prescOID" name="prescOID"
							value="{{=it.content.oid}}" />

						<button class="button-erefill green  no-click-button"
							type="submit">
							<spring:message code="stop.auto.refill.overlay.button.label" />
						</button>
						<a class="button-erefill link cancel" href="#" role="button"><spring:message
								code="stop.auto.refill.overlay.back.link" /></a>
						<csrf:csrfToken />
					</form>
				</div>
			</div>
			<a class="close" href="#"><spring:message code="close.label" /></a>
		</div>
	</div>
</div>
<div class="overlay-screen">
	<div></div>
</div>
