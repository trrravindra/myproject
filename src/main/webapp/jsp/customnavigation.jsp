<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page session="false"%>


<c:if test="${userRole eq 'Caregivers' }">
	<c:set var="wasUrl"
		value='${contextPath}/${locale}/caregiver/prescription/details' />
</c:if>
<c:if test="${userRole ne 'Caregivers'}">
	<c:set var="wasUrl"
		value='${contextPath}/${locale}/prescription/details' />
</c:if>

<c:if test="${ not empty assignedPatients }">
	<form class="form-now-viewing uniform" action="${wasUrl}" method="post">
		<c:choose>
			<c:when test="${locale eq 'fr_CA'}">
				<div class="now-viewing now-viewing-fr">
			</c:when>
			<c:otherwise>
				<div class="now-viewing">
			</c:otherwise>
		</c:choose>
		<spring:message code="customnav.title" />
		<span class="tooltip" aria-describedby="custnavTip" tabIndex="0"><img
			src="<c:url value='/resources/images/erefill/icon-tooltip.png'/>"
			alt="tooltip"> <span class="tooltip-content" id="custnavTip">
				<h3>
					<spring:message code="customnav.tooltip.title" />
				</h3>
				<p>
					<spring:message code="customnav.tooltip.description" />
				</p>
		</span> </span>
		</div>

		<c:set var="add" />
		<select name="current-account"
			class="submit-on-change erefill-submit-on-change">
			<c:forEach var="patient" items="${assignedPatients}" varStatus="loop">
				<c:if test="${locale eq 'fr_CA' }">
					<c:choose>
						<c:when test="${patient.birthYear eq 'You'}">
							<c:set var="add" value="Vous" />
						</c:when>
						<c:otherwise>
							<c:set var="add" value="${patient.birthYear }" />
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test="${locale eq 'en_CA' }">
					<c:set var="add" value="${patient.birthYear }" />
				</c:if>
				<c:choose>
					<c:when test="${empty selectedPatientOID && loop.count eq 1}">
						<option value="${patient.patientOID}" selected="selected">${patient.firstName}&nbsp;${patient.lastName}&nbsp;(${add })</option>
					</c:when>
					<c:when test="${patient.patientOID eq selectedPatientOID}">
						<option value="${patient.patientOID}" selected="selected">${patient.firstName}&nbsp;${patient.lastName}&nbsp;(${add })</option>
					</c:when>
					<c:otherwise>
						<option value="${patient.patientOID}">${patient.firstName}&nbsp;${patient.lastName}&nbsp;(${add })</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select>
		<csrf:csrfToken />
	</form>
</c:if>