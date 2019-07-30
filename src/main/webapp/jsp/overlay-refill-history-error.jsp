<%@ include file="global.jsp"%>

<div class="overlay-wrap">
	<div class="inner">
		<div class="overlay">
			<div class="refill-history" role="dialog" tabIndex="0"
				aria-labelledby="overlayTitle" aria-describedby="overlayDesc">
				<div class="header">
					<h1 class="title" id="overlayTitle">
						<spring:message code="my.prescriptions.refill.history.label" />
					</h1>
				</div>
				<div class="inner-content" id="overlayDesc">
					<p>
						<spring:message code="refillhistory.overlay.error.txt" />
					</p>
					<a class="cancel" href="#"><spring:message code="cancel.label" /></a>
				</div>
			</div>
		</div>
	</div>
</div>