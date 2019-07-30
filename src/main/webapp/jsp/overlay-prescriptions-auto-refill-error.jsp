<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="overlay-wrap">
	<div class="inner">
		<div class="overlay">
			<div class="overlay-refill-request-success" role="dialog"
				tabIndex="0" aria-labelledby="overlayTitle"
				aria-describedby="overlayDesc">
				<div class="header">
					<h1 class="title" id="overlayTitle">
						<spring:message code="auto.refill.error.overlay.title" />
					</h1>
				</div>
				<div class="inner-content" id="overlayDesc">
					<spring:message code="auto.refill.error.msg" />
					<div>
						<a class="cancel" href="#"> <spring:message
								code="cancel.label" />
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="overlay-screen">
	<div></div>
</div>




