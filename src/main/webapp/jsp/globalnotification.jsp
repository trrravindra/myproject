<%@ include file="global.jsp"%>

<c:set var="user" value="Caregivers" />

<c:choose>
	<c:when test="${user eq userRole }">

	</c:when>
	<c:when test="${user ne userRole }">
		<c:if test="${not empty lastStateDate && null ne lastStateDate }">
			<c:if test="${notificationclicked ne notify }">
				<div class="site-notification">
					<a href="" class="close notification-close">Close</a>
					<h2 class="title">
						<spring:message code="my.prescriptions.warning.label"
							arguments="${contextPath}" />
					</h2>
				</div>
			</c:if>
		</c:if>
	</c:when>
</c:choose>
