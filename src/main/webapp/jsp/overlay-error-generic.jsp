<%@ include file="global.jsp"%>

<div class="overlay-wrap">
	<div class="inner">
		<div class="overlay">
			<div class="refill-history">
				<div class="header">
					<h1 class="title">
						<spring:message code="overlay.error.generic.title" />
					</h1>
				</div>
				<div class="inner-content">
					<p>
						<spring:message code="overlay.error.generic.message" />
					</p>
					<a class="cancel" href="#"><spring:message code="cancel.label" /></a>
				</div>
			</div>
			<a class="close" href="#"><spring:message code="close.label" /></a>
		</div>
	</div>
</div>